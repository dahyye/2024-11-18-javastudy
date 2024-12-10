/*
 
 	멤버변수의 초기화
 		1. 생성자 => 인스턴스 변소, static 변수의 초기화
 			반드시 호출해서 사용해야한다
 		2. 인스턴스 블럭 => 인스턴스 변소, static 변수의 초기화
 		3. static 블럭 => static 변수의 초기화만 가능
 		--------------> 공통점 멤버의 초기화 담당, 시작과 동시에 처리하는 기능
 						구현이 가능, 상속은 예외
 						
 			int a;		a=10;						a=100    a=200 => 최종출력은 200
 		=> 기본초기화 => 명시적 초기화 => static 블럭 => 인스턴스블럭 => 생성자

 		명시적 초기화가 가장 우선시된다
 		
 		int[] arr=new int[5], 난수값 5개를 초기화
 		=> 명시적초기화불가능 => 블럭을 이용해서 초기화
 
 */
class Movie
{
	int movieNo = 1;//명시적초기화
	static int id=1;
	{
		System.out.println("인스턴스 블럭 진입");
		movieNo=2;//인스턴스블럭
		System.out.println("movieNo변수 저장완료!!");
	}
	Movie()
	{
		System.out.println("생성자 호출!!");
		movieNo=3;
		System.out.println("생성자에서 movieNo 저장완료!!");
	}
	static
	{
		System.out.println("static 블럭 진입");
		id=100;
		System.out.println("저장완료");
	}
}
public class 클래스_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie m = new Movie();
		System.out.println("movieNo = "+m.movieNo);
		System.out.println("id = "+Movie.id);//값을 가져올 때 생성자가 필요없다, static은 메모리 할당이 필요없다
	}

}
