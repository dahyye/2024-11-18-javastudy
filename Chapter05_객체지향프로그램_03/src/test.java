/*
 	생성자 특징
 		모든 생성자 이름은 클래스와 이름이 동일해야함
 		오버로딩이 가능하다
 		객체 생성시에 호출, 변수를 초기화하기위해 
 		생성자는 생략이 가능하나 컴파일러에 의해 자동으로 생겨
 		
 		
 	this 특징
 		모든 클래스에 존재한다
 		static으로 되어 있다
 		this의 사용위치는 생성자와 인스턴스 메소드에서만 사용이 가능하다
 		
 	오버로딩 특징
 		매서드명이 같아야한다
 		매개변수 개수나 데이터형이 달라야한다
 		리턴형은 관계없다
 		접근지정어도 관계없다
 		
 	초기화
 		인스턴스변수 / 정적변수 => 초기화를 안해도 기본으로 null값이 들어간다
 		
 */

class Student
{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;	
}

class PlayingCard// 다른 클래스에서도 사용이 가능해
{ 
	int kind; //인스턴스변수=멤버변수(8byte) -> heap영역저장 -> 프로그램 종료시까지 유지
	int num;  //인스턴스변수 
	static int width; //정적변수(공유변수) 
	static int height;//정적변수(공유변수) ->메소드영역저장 -> 프로그램 종료시까지 유지
	
	//생성자 변수 초기화를 위해 사용
	PlayingCard(int k, int n) //매개변수도 지역변수
	{ 
			kind = k; //지역변수 -> Stack에 저장 -> {}이 종료되면 자동삭제
			num = n; //지역변수

	} 

	
class Member
{
	String name;
	String id;
	String password;
	int age;
	
	Member(String n,String id)
	{
		this.name=name;
		this.id=id;
	}
	
}

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
