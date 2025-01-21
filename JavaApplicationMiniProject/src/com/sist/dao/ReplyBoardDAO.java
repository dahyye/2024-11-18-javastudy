package com.sist.dao;
import java.util.*;
import java.beans.Transient;
import java.sql.*;
import com.sist.vo.*;

public class ReplyBoardDAO {

	//연결 -> 오라클
	private Connection conn;
	//송수신-> SQL문장 전송, 결과값 받기
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static ReplyBoardDAO dao;
	
	//드라이버 등록
	public ReplyBoardDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//리플랙션 -> 클래스이름으로 메모리할당 / 메소드 제어..
			//new 역할 -> 메소드명을 모르는 경우에도 호출 가능
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static ReplyBoardDAO newInstance()
	{
		if(dao==null)
			dao=new ReplyBoardDAO();
		return dao;
	}
	//연결
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//해제
	public void disConnection()
	{
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//==========================오라클 연결 기본(공통사용부분)=======================================
	
	
	//기능
	// 
	/*
	 1. 목록 출력 -> 인라인뷰  => 1페이지에 10개씩 
	 					  => 최신순
	 					  => index 사용은 x -> 추가 수정 삭제가 많은 경우에는 index가 속도가 느려 -> order by 이용
	 
	 */
	public List<ReplyBoardVO> boardListData(int page)
	{
		List<ReplyBoardVO> list = new ArrayList<ReplyBoardVO>();
		
		try {
			getConnection();
			String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,group_tab,num "
					  +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
					  +"FROM (SELECT no,subject,name,regdate,hit,group_tab "
					  +"FROM replyBoard ORDER BY group_id DESC,group_step ASC)) "
					  +"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ReplyBoardVO vo=new ReplyBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return list;
	}
	
	public int boardRowCount()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM replyBoard";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	
	// 2. 글쓰기   -> INSERT 
	public void boardInsert(ReplyBoardVO vo)
	{
		try {
			getConnection();
			//새로운 그룹 생성 -> 그룹번호 : group_id
			String sql="INSERT INTO replyBoard(no,name,subject,content,pwd,group_id) "
					+ "VALUES(rb_no_seq.nextval,?,?,?,?,(SELECT NVL(MAX(group_id)+1,1) FROM replyBoard))";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate();//commit수행
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
	}
	
	// 3. 상세보기 -> WHERE 
	public ReplyBoardVO boardDetailData(int type, int no)
	{
		//상세보기 : 반드시 사용자로부터 primary key
		ReplyBoardVO vo = new ReplyBoardVO();
		try {
			getConnection();
			//조회수 증가
			if(type==1)
			{
				String sql="UPDATE replyBoard SET hit=hit+1 WHERE no="+no;
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			
			//상세내용 보기
			String sql="SELECT no,name,subject,content, TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit FROM replyBoard WHERE no="+no;
			ps=conn.prepareStatement(sql);			
			//sql문장은 여러개가 존재할 수 있다
			
			ResultSet rs= ps.executeQuery();
			
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbday(rs.getString(5));
			vo.setHit(rs.getInt(6));
			
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
		
	}
	// 4. 수정하기 -> UPDATE
	//4-1데이터가져오기
	public ReplyBoardVO boardUpdateData(int no)
	{
		ReplyBoardVO vo=new ReplyBoardVO();
		try {
			getConnection();
			String sql="SELECT no,name,subject,content FROM replyBoard WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			
			rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return vo;
		
	}
	
	//4-2 실제 수정하기
	public boolean boardUpdate(ReplyBoardVO vo)
	{
		boolean bCheck=false; //비밀번호 처리
		/*
		 	메소드 : 사용자 요청 처리 -> 벤치마킹 : 메뉴, 버튼
		 	1) 사용자 요청값을 받는다
		 		=> 매개변수
		 	
		 	2) 요청처리후에 결과값
		 		=> 경우의 수
					목록 : List(~VO)
					상세보기 : ~VO
					비밀번호 맞다/아니다 : boolean
					경우의수 3개이상 : String or Int (기본적으로는 String을 선택하는 경우가 많다)
									|
									ex) NOID/NOPWD/OK
								
					-----------------------------------------------------
					자바 => 메소드 제작
						   -------- 데이터확인(VO)
						   
		 */
		try {
			getConnection();
			//비밀번호 가져오는 sql
			String sql="SELECT pwd FROM replyBoard WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			
			rs.close();
			
			if(db_pwd.equals(vo.getPwd()))
			{
				bCheck=true;
				//실제수정
				sql="UPDATE replyBoard SET name=?,subject=?,content=? WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				//수정해라
				//insert/update/delete가 여러개인 경우 -> 트랜젝션
				ps.executeUpdate();
				
				/*				 		 
				 INSERT사용시 default가 많으면 값을 다 채워주지 않아도 되기 때문에 
						INSERT INTO table_name(컬럼,컬럼...) VALUES(값,값...) 처럼 입력할 값만 지정해서 추가하는게 편함
				
				 UPDATE
				 		UPDATE table_name SET 컬럼=값, 컬럼=값.. [WHERE 조건]
				 	
				 DELETE 
				 		DELETE table_name [WHERE 조건]
				 ---------------------------------------------------> insert/update/delete는 commit필요하다 -> executeUpdate()		
				 		
				 SELECT 
				 		이미 저장된 데이터를 검색
				
				
						
				*/
				
			}
			else
			{
				bCheck=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return bCheck;
	}
	
	
	// 5. 답변하기 -> 트랜잭션
/*
		 
	
	try 
	{
		getConnection; //연결
		conn.setAutoCommit(false); //해제 
		-------------------------------
		SQL => INSERT
		SQL => INSERT
		-------------------------------
		conn.commit();
		
	} catch (Exception e) 
	{
		// TODO: handle exception
		e.printStackTrace();
		try 
		{
			conn.rollback() -> sql 명령문 취소
		}catch(Exception e){}
	}
	finally 
	{
		
		disConnection();
	}
	
	
	 */
	/*
	 							group_id		group_step		group_tab	root	depth
	 	AAAAA						1				0				0		  		  2
	 		=>DDDD(새댓글)			1				1				1
	 		=>BBBB					1				1				1
	 		  =>CCCCCC				1				2				2
	 	    
	 	ASC
	 
	 	
	 
	 */
	
	public void replyInsert(int pno, ReplyBoardVO vo)
	{
		try {
			getConnection();
			conn.setAutoCommit(false);
			//sql 4개
			//첫번쨰 sql
			String sql="SELECT group_id,group_step,group_tab FROM replyBoard WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			int gi=rs.getInt(1);
			int gs=rs.getInt(2);
			int gt=rs.getInt(3);
			rs.close();
			
			//2번째 sql -> group_step을 변경 -> 답변 핵심
			sql="UPDATE replyBoard SET group_step=group_step+1 WHERE group_id=? AND group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();

			//3번째 sql -> INSERT
			sql="INSERT INTO replyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
					+ "VALUES(rb_no_seq.nextval,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, pno);
			ps.executeUpdate();
			
			
			//4번째 sql -> UPDATE 
			sql="UPDATE replyBoard SET depth=depth+1 WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			
			
			
			conn.commit();
		} catch (Exception e) {
			//트랜젝션을 일괄처리 -> 스프링에서는 1챕터로 나와(그만큼 중요) 
			try {
				conn.rollback(); //명령문 전체 취소
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.setAutoCommit(true);//원상복귀
			} catch (Exception e2) {
				// TODO: handle exception
			}
			disConnection();
			
		}
	}
	
	 
	
	// 6. 삭제  	 -> 트랜잭션

	public boolean replyDelete(int no,String pwd)
	{
		boolean bCheck=false;
		/*
		 1. 비밀번호 확인
		 2. depth 
		 	=> 0이면 delete
		 	=> 0보다 크면 update
		 3. depth 감소 update
		 		 
		 */
		
		try {
			getConnection();
			conn.setAutoCommit(false);
			String sql="SELECT pwd,root,depth FROM replyBoard WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			int root=rs.getInt(2);
			int depth=rs.getInt(3);
			
			rs.close();
			
			
			if(db_pwd.equals(pwd))
			{
				bCheck=true;
				//삭제
				if(depth==0) //글에 대한 답변이 없는 경우
				{
					sql="DELETE FROM replyBoard WHERE no="+no;
					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
				}
				else //글에 대한 답변이 있는 경우
				{
					String msg="관리자가 삭제한 게시물입니다";
					sql="UPDATE replyBoard SET subject=?,content=? WHERE no="+no;
					ps=conn.prepareStatement(sql);
					ps.setString(1, msg);
					ps.setString(2, msg);
					ps.setInt(3, no);
					ps.executeUpdate();
					
				}
				
				sql="SELECT depth FROM replyBoard WHERE no="+root;
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				rs.next();
				
				int d=rs.getInt(1);
				rs.close();
				//if(d>0)
				{
					sql="UPDATE replyBoard SET depth=depth-1 WHERE no="+root;
					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
				}
				
			}
			else
			{
				bCheck=false;
				
			}
			
			
			
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			disConnection();
		}
		//나중에는 @Transactional 간단하게 사용할 수 있다
		return bCheck;
	}

	
}
