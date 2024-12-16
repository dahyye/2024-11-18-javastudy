package com.sist.main;
import com.sist.dao.*;
import com.sist.dao.DataBase;

public class Main {
	public static void main(String[] args) {
		
		DataBase db=new Emp();
		System.out.println("=======Emp=======");
		db.listPrint();
		System.out.println("=======Dept=======");
		db=new Dept();
		db.listPrint();
	}

}
