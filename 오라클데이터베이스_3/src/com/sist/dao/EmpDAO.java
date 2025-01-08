package com.sist.dao;
//Data Access Object 데이터 연결해주는 클래스
import java.util.*;

import com.sist.vo.*;

import java.sql.*;
/*
 
 	오라클 -> SQL
 			---자바에서 실행여부 확인 -> 자바에서 오라클 SQL문장 정리
 
 */
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	//싱글톤
	private static EmpDAO dao;
	
	//드라이버등록
	public EmpDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//클래스명으로 메모리 할당
			/*
			 	이름을 몰라도
			 	생성자, 멤버변수, 메소드를 제어할 수 있다는 장점이 있다
			 	=> 리플렉션 => 이걸 이용해서 만들어진 프로그램이 Spring
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	 
	//싱글톤 생성 -> 메모리재사용
	//newInstance() getInstance()가 들어가면 싱글턴
	//파싱 : XML / HTML / JSON
	//			  ----> Jsoup
	public static EmpDAO newInstance()
	{
		if(dao==null)
		{
			dao=new EmpDAO();
		}
		return dao;
	}
	
	//연결
	public void getConnection()
	{
		try {
			//sqlplus를 띄우는 역할
			
			conn=DriverManager.getConnection(URL,"hr","happy");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//해제
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
//============================여기까지가 꼭 들어가는 부분================================
/*
 	DAO => 테이블 1개에 대한 제어
 		=> 게시판(BoardDAO), 댓글(ReplyDAO)
 	
 	Service => 관련된 테이블 여러개 제어
 		=> BoardService : Board/Reply
 		
 */
	// 기능
	/*
	   1. 사원 (사번, 이름, 직위, 입사일, 급여)
	   	  부서 (부서명, 근무지)
	   	  등급 (등급)
	 */
	public List<EmpVO> empJoinAllData()
	{
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job,hiredate,TO_CHAR(sal,'$99,999'),dname,loc,grade "
					+"From emp,dept,salgrade "
					+"WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal";
			ps=conn.prepareStatement(sql); //ps:전송
			//실행 후 결과값을 메모리에 저장
			ResultSet rs = ps.executeQuery();
			//커서위치 바꿔주기
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setStrSal(rs.getString(5));
				//Dvo 객체 안에 dname, loc
				vo.getDvo().setDname(rs.getString(6));
				vo.getDvo().setLoc(rs.getString(7));
				//Svo 객체 안에 grade
				vo.getSvo().setGrade(rs.getInt(8));
				list.add(vo);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	
	
	public EmpVO empFindData(int empno)
	{
		EmpVO vo = new EmpVO();
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job,hiredate,TO_CHAR(sal,'$999,999'),dname,loc,grade From emp,dept,salgrade WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal AND empno="+empno;
			ps=conn.prepareStatement(sql); //ps:전송
			//실행 후 결과값을 메모리에 저장
			ResultSet rs = ps.executeQuery();
			//커서위치 바꿔주기
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			//vo.setSal(rs.getInt(5));
			vo.setStrSal(rs.getString(5));
			//Dvo 객체 안에 dname, loc
			vo.getDvo().setDname(rs.getString(6));
			vo.getDvo().setLoc(rs.getString(7));
			//Svo 객체 안에 grade
			vo.getSvo().setGrade(rs.getInt(8));
			list.add(vo);
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
