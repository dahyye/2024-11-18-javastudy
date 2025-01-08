package com.sist.vo;
//사원정보를 모아서 관리 -> 사원 한 명에 대한 정보를 저장
//모아서 한 번에 윈도우나 브라우저로 전송하기 위해
/*
 EMPNO NOT NULL NUMBER(4)
 ENAME VARCHAR2(10)
 JOB VARCHAR2(9)
 MGR NUMBER(4)
 HIREDATE DATE
 SAL   NUMBER(7,2)
 COMM NUMBER(7,2)
 DEPTNO NUMBER(2)
 
 오라클과 자바의 데이터형을 잘 맞춰줘야한다
 데이터형이 다르면 '내부변환이 안된다' 라는 오류발생
 
 */

import java.util.*;
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String strSal;
	
	//조인 -> 포함클래스
	// => 테이블연동할 때 다른 테이블의 컬럼을 추가하면 안된다
	//필요할 때 추가하겠다
	//테이블 여러개의 컬럼을 섞어서 사용하려면 한 개의 테이블로 변경해서 사용 -> View(가상테이블)
	private DeptVO dvo = new DeptVO();
	private SalGradeVO svo = new SalGradeVO();
	
	
	
	
	public String getStrSal() {
		return strSal;
	}
	public void setStrSal(String strSal) {
		this.strSal = strSal;
	}
	public DeptVO getDvo() {
		return dvo;
	}
	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}
	public SalGradeVO getSvo() {
		return svo;
	}
	public void setSvo(SalGradeVO svo) {
		this.svo = svo;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	
	
}
