package com.sist.main;
//오른쪽마우스-new-file생성

//보안이 필요한 내용 작성
//키=값 형식
/*
 properties => XML/JSON => Security 보안관련
 데이트베이스 => table / column
 
 
 
 */
//import java.util.Properties;

import java.util.*;
public class Properties_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Properties props=System.getProperties();
		EmpDAO dao = new EmpDAO();
		List<Emp> list = dao.empListData();
		for(Emp e:list)
		{
			System.out.println(e.getEmpno()+" ");
			
			
		}
	}

}
