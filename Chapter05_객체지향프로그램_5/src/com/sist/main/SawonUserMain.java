package com.sist.main;
import com.sist.vo.*;//라이브러리, 사용자 정의 
					//패키지가 다른 경우 import를 이용해서 값을 가져와야함
//조립
public class SawonUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon hong = new Sawon(1,"홍길동","개발부","대리","2021-10-10",3600);
		//변수에 대해서 읽기 쓰기를 해야하는데
		//job만 public이라서 읽을 수 있어
		//생성자를 이용해서 초기화를 하면 변경이 불가능하다
		//나머지 변경은 => Setter 사용
		System.out.println("====== 홍길동 사원의 정보 ======");
		System.out.println("사번 : "+hong.getSabun());
		System.out.println("이름 : "+hong.getName());
		System.out.println("부서 : "+hong.getDept());
		System.out.println("직위 : "+hong.getJob());
		System.out.println("입사일 : "+hong.getRegdate());
		System.out.println("연봉 : "+hong.getPay());
		
		
		//변경
		hong.setDept("영업부");
		hong.setJob("과장");
		hong.setPay(4200);
		
		System.out.println("====== 변경 후 정보 ======");
		System.out.println("사번 : "+hong.getSabun());
		System.out.println("이름 : "+hong.getName());
		System.out.println("부서 : "+hong.getDept());
		System.out.println("직위 : "+hong.getJob());
		System.out.println("입사일 : "+hong.getRegdate());
		System.out.println("연봉 : "+hong.getPay());
		
	}

}
