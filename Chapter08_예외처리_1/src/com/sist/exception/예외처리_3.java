package com.sist.exception;

public class 예외처리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		try {
			System.out.println(4);
			System.out.println(0/0);
			System.out.println(5);
			System.out.println(6);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(7);
		}
		System.out.println(8);
		System.out.println(9);
		
	}

}
