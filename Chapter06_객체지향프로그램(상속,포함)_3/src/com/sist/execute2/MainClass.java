package com.sist.execute2;
class Sub
{
	//Object => 모든 메소드 사용이 가능
	
	int a=10;
	public void display()
	{
		System.out.println("sub..");
	}
	
	@Override
	public String toString() {
		System.out.println("Sub..");
		return "";
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = new Sub();
		//묶어서 한개로 관리
		//but 하위클래스를 제어할 수 없기 때문에 Sub의 메소드인 display를 가져올 수 없다
		obj.toString();
		//상위클래스에서 받은 걸 오버라이딩한거라서 상위클래스에서도 접근가능
	}

}
