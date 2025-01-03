package com.sist.dao;
/*
 	
 	오라클 연동
 		1. 드라이버 설정(한 번만-> 생성자이용) -> Class.forNAme("드라이버명");
 														---------oracle.jdbc.driver.OracleDriver
 																 com.mysql.cj.jdbc.Driver
 		2. 오라클 연결
 			connection conn = DriverManager.getConnection(URL,"hr","happy")
 		3. 오라클로 SQL문장을 전송
 			PreparedStatement ps = conn.preparedStatement(sql)
 		4. 오라클에서 SQL문장 실행하고 결과값 요청
 			ResultSet rs = ps.executeQuery();
 			
	 			rs
	 			------------------------
	 			 id 	pwd		name
	 			------------------------
	 			aaa		1234	홍길동	| => next() -> 가장 많이 사용
	 			------------------------	 단위가 record라서 한 줄에 있는 모든 데이터를 읽는다
	 			bbb		1234	심청이
	 			------------------------
	 			ccc		1234 	박문수
	 			------------------------
	 			ddd 	1234 	이순신	| => previous()
	 			------------------------
	 			| 기본 cursor(커서)위치
	 			//커서에 있는 값을 가져오기 떄문에 커서이동이 필요
 			
 		5. rs.close()
 		6. ps.close()
 		7. conn,close()	//닫는 순서는 반대로 
 		
 		
 			
 */
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
/*
 	SQL문장에 ;을 사용하지 않는다
 	자바에서 사용하면 약간 변경되는 부분 => LIKE
 	LIKE '%'||문자열||'%'=> 문자열결합 자바
 	LIKE CONCAT('%',문자열,'%') => MYSQL
 	JOIN -> Oracle JOIN / ANSI JOIN 
 
 */

public class EmpDAO {
	
	//오라클 연결객체
	private Connection conn;
	//오라클 송수신
	private PreparedStatement ps;
	/*
	 	SQL문장을 전송
	 	오라클 실행 결과 읽기
	 	-------------------
	 	StateMent
	 	PreparedStatement : SQL먼저 전송하고
	 						나중에 데이터를 채운다
	 	CallableStatement : procedure 호출 -> 함수
	 							|
	 							SQL문장이 노출되지 않는다
	 							보안
	 							ERP -> 관리 프로그램 
	 							E4NET.. 삼성역....
	 	
	 	EmpVO
	 	(PreparedStatement)
	 	String sql="INSERT INTO emp VALUES("+vo.getEmpno()+",'"+vo.getEname()+",'"+
	 									vo.getjob()+",'"+vo.getHiredate()....
	 									
		String sqk="INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)"

	 
	 */
	//DAO->오라클연동 -> 사용자 한 명당 1개만 사용(싱글턴)
	private static EmpDAO dao;
	//URL
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//TCP => Socket을 이용해서 오라클로 SQL문장을 전송
	//오라클 = 서버, 자바응용프로그램 = 클라이언트
	public EmpDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ojdbc.jar
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//기능설정
	//모든 메소드에서 공통으로 사용되는 기능 => 메소드로 만들기
	//오라클 연결 / 오라클 해제
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy"); //conn hr/happy;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//싱글톤 -> 메모리공간을 한 개만 생성하겠다
	public static EmpDAO newInstance()
	{
		if(dao==null)
			dao = new EmpDAO();
		return dao;
	}
	//---------------------------------- 항상 사용 -----------------------------------------------
	//목록출력 SELCET colum_list
	public List<EmpVO> empListData(int type)
	{
		List<EmpVO> list = new ArrayList<EmpVO>();
		String order="";
		if(type==1)
			order="ORDER BY empno ASC";
		else if(type==2)
			order="ORDER BY hiredate DESC";
		else if(type==3)
			order="ORDER BY ename ASC";
		try {
			//1, 오라클연결
			getConnection();
			//2. SQL문장 제작
			String sql = "SELECT empno,ename,job,hiredate FROM emp "+order;
			//3. 오라클로 전송
			ps=conn.prepareStatement(sql);
			//4. SQL실행 후 결과값을 가지고 온다
			ResultSet rs = ps.executeQuery();
			//데이터받기 정수:getInt() 실수:getDouble(), 문자열:getString(), 날짜:getDate()
			//커서위치 변경
			//7839 KING PRESIDENT 81/11/17
			while(rs.next()) //처음부터 마지막까지 읽어온다
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredatel(rs.getDate(4));
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
	
	//정보상세보기 WHERE
	/*
	 	List : 여러명
	 	EmpVO : 1명 => 상세보기
	 	
	 	aaa 1
	 	aaa 2
	 	aaa 3
	 	aaa 4
	 	aaa 5
	 	
	 	aaa로 같은 데이터가 들어가도 1~5로 번호가 다르기 때문에 구분할 수 있다 -> 기본키 -> 보통 숫자로 구분
	 
	 */
	public EmpVO empDetailData(int empno) //사번이 중복이 없기 때문에 사번으로 구분(기본키)
	{
		EmpVO vo = new EmpVO();//사원 한 명에 대한 정보
		try {
			getConnection();
			//sql문장
			String sql="SELECT * FROM emp WHERE empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next(); //한 번만 가져오면 되니까 while문은 안써도 됨 
			//첫 번째 위치값을 읽어와라
			//읽어오는 순서는 출력순으로
			//  EMPNO   ENAME   JOB   MGR   HIREDATE   SAL  COMM   DEPTNO
			//순서를 잘 못 가져오면 내부변환 오류 => 데이터형이 다른 경우
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMgr(rs.getInt(4));
			vo.setHiredatel(rs.getDate(5));
			vo.setSal(rs.getInt(6));
			vo.setComm(rs.getInt(7));
			vo.setDepno(rs.getInt(8));
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
	
	
	
}
