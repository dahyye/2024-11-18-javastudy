/*
 
 변수 : 데이터 한개저장 -> 데이터변경가능
 		읽기(메모리에서 데이터를 가지고 온다)
 		쓰기(메모리저장)
 		수정
 		
 상수 : 데이터 한개 저장 -> 데이터변경불가능
 		읽기(메모리에서 데이터를 가지고 온다)
 		쓰기(메모리저장)
 			final 데이터형 변수명=값;
 			변수는 소문자로 시작
 			상수는 대문자로 시작
 ----------------------------------
 배열 : 변수여러개를 한개의 이름으로 제어(관리가 쉽다)
 		=> 고정적
 		-=>같은 데이터형만 모아서 관리
 
 클래스 : 여러개의 데이터를 한 번에 제어할 수 있다
 		=> 고정적이 아니다(원하는 갯수만큼 저장이 가능
 		
 		1. 데이터를 모아준다 -> 한개의 대한 정보
 		사람-> 사람 한 명에 대한 변수들
 		학생-> 학생 한 명에 대한 정보
 		---------------------
 		저장하는 공간을 따라 만든 생성
 		=> 데이터형 클래스
 		=> 액션 ==> 변수 / 메소드
 		
 		ex. 학생
		
			class 학생=> 20명을 할 때 20개를 저장하는 공간만 만들면 된다
			{
				이름, 학번, 학점....
				
			}
			
			==> new 라는 연산자로 저장하는 공간만 만들면 된다
			==> 장점 : 다른 데이터형들을 한 번에 모아서 처리할 수 있다


		java => 한 개의 파일안에 여러개의 클래스를 생성할 수 있는데
				public class는 한 번만 사용이 가능

 */
import java.util.Scanner;

class Student
{
	int hakbun;
	String name;
	int age;
	
	public Student()
	{
		
	}
	
}



public class 클래스_1 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Student hong = new Student();
		hong.hakbun = 1;
		hong.name = "홍길동";
		hong.age = 20;
		
		System.out.println(hong);
		//Student@4aa8f0b4 주소
		System.out.println("학번 : "+hong.hakbun);
		System.out.println("이름 : "+hong.name);
		System.out.println("나이 : "+hong.age);
		
		Student sim = new Student();
		sim.hakbun = 2;
		sim.name = "심객체";
		sim.age = 18;
		System.out.println(sim);
		//Student@574caa3f 주소
		System.out.println("학번 : "+sim.hakbun);
		System.out.println("이름 : "+sim.name);
		System.out.println("나이 : "+sim.age);
		
	}

}
