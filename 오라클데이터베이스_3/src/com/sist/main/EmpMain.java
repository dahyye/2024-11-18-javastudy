package com.sist.main;
import com.sist.dao.*;
import com.sist.vo.*;

import java.util.*;
public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("★★★★★ 사원 목록 ★★★★★");
		//오라클연결
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list=dao.empJoinAllData();
		for(EmpVO vo : list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getHiredate()+" "+
							vo.getStrSal()+"  "+vo.getDvo().getDname()+" "+
							vo.getDvo().getLoc()+" "+vo.getSvo().getGrade());
//			
		}
	}

}
