/*
 	this는 자신의 객체
 		지역변수와 매개변수 == 멤버변수가 동일한 이름을 가지고 있는 경우 구분하기 위해 사용
 		모든 클래스는 this를 가지고 있다
 		
 	class A
 	{
 		this
 	}
 	class B
 	{
 		this
 	}
 	
 	this는 static변수 
 	A a=new A()   ==> this=a; 와 같은 역할
 	B b=new B()
 	a를 사용하면 A안에 있는 this
 	b를 사용하면 B안에 있는 this 
 */
class Member2
{
	int no=100;
	Member2()
	{
		System.out.println("this="+this);
		int no=200;
		System.out.println("no(지역변수)+no(멤버변수) = "+(no+this.no));//this는 클래스 자신이 가지고 있는 멤버변수, 메소드 가져올 수 있다
		//우선순위 지역변수,매개변수 > 멤버변수
		
	}
}

/*
	 int a=10;
	 static int b=20;
	 static void display()  //공통으로 사용하는 기능이 많을 때 사용
	 {
	 	b만 사용가능 // static메소드에서는 static변수만 사용가능
	 }
	 void display()
	 {
	 	a,b사용가능
	 }
 
 
 */
public class 클래스_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member2 m = new Member2();
		Member2 m1 = new Member2();
		System.out.println(m1);//m1과 this는 같은 주소값을 가지고 있다
		//static에서는 this를 사용할 수없고 인스턴스변수에서만 사용할 수 있다
		// this는 공유
	}

}
