package com.sist.dao;

import java.util.*;
import java.sql.*;

import com.sist.vo.*;

/*
 	
 	매번 같은 소스가 들어갈 경우에 반복을 없애기 위해서
 	
 		  Class/Method       
 	오라클 / 자바 / 자바스크립트 / HTML / CSS
 	PROCEDURE	 function 
 
 
 */
public class EmpDAO {
	//생성된 객체를 닫아야하기 때문에 conn,ps 는 멤버변수로 선언
	private Connection conn;
	private PreparedStatement ps;
	private Database db = new Database();
	private static EmpDAO dao;
	
	public static EmpDAO newInstance()
	{
		if(dao==null) 
			dao = new EmpDAO();
		return dao;
	}
	//기능 -> 전체 목록출력
	public List<EmpVO> empListData()
	{
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn=db.getConnection();
			String sql="SELECT empno,ename,job,hiredate,dname,loc "+
						"FROM emp JOIN dept "+
						"ON emp.deptno=dept.deptno";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				list.add(vo);			
				
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			db.disConnection(conn, ps);
		}
		return list;
	}
	
	//상세보기 => EmpVO(사원 한명에 대한 모든 정보를 저장
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo = new EmpVO();
		try {
			conn=db.getConnection();
			String sql="SELECT e1.empno,e1.ename,e1.job,e2.ename,e1.hiredate,"
				     +"e1.sal,e1.comm,dname,loc,grade "
				     +"FROM emp e1,emp e2,dept d,salgrade s "
				     +"WHERE e1.mgr=e2.empno "
				     +"AND e1.deptno=d.deptno "
				     +"AND e1.sal BETWEEN losal AND hisal "
				     +"AND e1.empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();			
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setmEname(rs.getString(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getInt(6));
			vo.setComm(rs.getInt(7));
			vo.getDvo().setDname(rs.getString(8));
			vo.getDvo().setLoc(rs.getString(9));
			vo.getSvo().setGrade(rs.getInt(10));
			
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			db.disConnection(conn, ps);
		}
		return vo;
	}
	
	//검색 => 조인
	
	public List<EmpVO> empFindData(String col,String fd)
	{
		//검색할 때 이름 or 입사일 or 직위 or 부서명
		//어떤 데이터로 검색할 지 컬럼명으로 불러오기
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn=db.getConnection();
			String sql="SELECT empno,ename,job,hiredate,dname,loc "
					+ "FROM emp,dept "
					+ "WHERE emp.deptno=dept.deptno "
					+ "AND "+col+" LIKE '%'||?||'%'";
			//조건이 있는 경우 AND를 사용해서 추가
			ps=conn.prepareStatement(sql);
			//?값을 채울 때 -> setString(1,fd) => ''이 자동으로 붙기때문에 문자열결합을 해줘야해
			ps.setString(1, fd);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				list.add(vo);	
			}
			rs.close();			
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			db.disConnection(conn, ps);
		}
		
		return list;
	}
	
	

}
