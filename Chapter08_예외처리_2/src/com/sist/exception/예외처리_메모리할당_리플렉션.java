package com.sist.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 	
 
 */
//Class.forName() => ClassNotFoundException 오류 발생할 수 있어(CheckException)
//메모리할당
class Movie
{
	public void display()
	{
		System.out.println("Movie:display() Call...");
	}
}
public class 예외처리_메모리할당_리플렉션 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Movie m = new Movie();
//		m.display();
		try
		{
			Class clsName = Class.forName("com.sist.exception.Movie");
			//클래스 정보 읽기
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods = clsName.getDeclaredMethods();
			methods[0].invoke(obj,null);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
