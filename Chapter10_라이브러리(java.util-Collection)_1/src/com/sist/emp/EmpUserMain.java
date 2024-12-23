package com.sist.emp;
import java.util.*;
public class EmpUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDAO dao = EmpDAO.newInstance();
//		HashSet<String> set = dao.empGetJobs();
//		
//		System.out.println("저장 갯수 : "+set.size());
//		for(String job : set)
//		{
//			System.out.println(job);
//		}

		TreeSet<String> set = dao.empGetNames();
		
		System.out.println("사원 인원 : "+set.size());
		for(String name:set)
		{
			System.out.println(name);
		}
		
//		System.out.println("==== 1명 퇴사 ====");
//		set.remove("SCOTT");
//		System.out.println("사원 인원 : "+set.size());
//		for(String name:set)
//		{
//			System.out.println(name);
//		}
		
		System.out.println(set.subSet("K", "WARD"));  //a부터 b사이의 값 출력(a는 포함 b는 미포함)
		
		
	}

}
