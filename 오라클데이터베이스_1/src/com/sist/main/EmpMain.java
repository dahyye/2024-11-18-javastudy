package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("사번순(1), 입사순(2), 이름순(3) : ");
		int type = scan.nextInt();
		
		//오라클 연결
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empListData(type);
		for(EmpVO vo : list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getHiredatel());
		}
		
		
		System.out.println("==============================");
		System.out.print("사번 입력 : ");
		int empno=scan.nextInt();
		
		EmpVO vo=dao.empDetailData(empno);
		System.out.println("=============사원정보============");
		System.out.println("사번 : "+vo.getEmpno());
		System.out.println("이름 : "+vo.getEname());
		System.out.println("직위 : "+vo.getJob());
		System.out.println("사수 : "+vo.getMgr());
		System.out.println("입사일 : "+vo.getHiredatel());
		System.out.println("급여 : "+vo.getSal());
		System.out.println("성과금 : "+vo.getComm());
		System.out.println("부서 : "+vo.getDepno());
	}

}
