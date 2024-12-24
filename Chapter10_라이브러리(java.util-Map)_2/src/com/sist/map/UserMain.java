package com.sist.map;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container c = new Container();
		Model model=c.getBean("board");
		model.execute();
		System.out.println(model);
		model=c.getBean("board");
		System.out.println(model);
		model=c.getBean("board");
		System.out.println(model);
		model=c.getBean("board");
		System.out.println(model);
		model=c.getBean("board");
		System.out.println(model);
		model=c.getBean("board");
		System.out.println(model);// 하나의 메모리주소로 제어 => 싱글턴
		
	}

}
