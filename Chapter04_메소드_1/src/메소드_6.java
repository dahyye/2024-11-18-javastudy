/*
 	메소드 호출 => 매개변수
 	1)Call By Value
 		=> 값만 전송
 	2)Call By Reference =>자바에서 주소전송은 배열 / 클래스
 											  ~~~~~~> String은 제외
 											  		String은 일반 데이터형으로 취급
 	 	=> 주소값 전송
 	 	
 	 	성적을 메소드로 만들 때 kor[], mat[], eng[]를 한 번에 하고 싶다 
		=> call by value 로 하면 값만 전송하는데
		메소드는 리턴값이 1개 => 3가지 성적 전송이 불가능
		
		==>>이럴 때 call by reference를 사용하면
		주소값에 값을 저장할 수 있기 때문에
		return이 없는 메소드를 생성해서 3가지 값을 한 번에 저장할 수 있어
		static void input(int kor[], int mat[], int eng[])
 		{
 			for(~~)
 			{
 			kor[i]=i... 형식으로 주소값에 값을 바로 저장할 수 있다
 			}
 			
 		}
 	
 */
// Call By Value => 값만 전송 => 복사본! 원본은 그대로
public class 메소드_6 {
	static void swap(int a,int b)
	{
		System.out.println("swap메소드에 진입....=>2");
		System.out.println("사용자가 요청한 값=>3");
		System.out.println("swap => 변경 전");
		System.out.println("a= "+a);//=>4
		System.out.println("b= "+b);//=>5
		int temp=a;
		a=b;
		b=temp;
		System.out.println("swap => 변경 후");
		System.out.println("a= "+a);//
		System.out.println("b= "+b);//
		System.out.println("swap메소드 요청 완료!=>6");
	}
	//메인은 자동호출, 사용자 정의는 자동호출 안되고 필요시 요청해야함
	//Trace => 디버킹머드 => f6누르면 진행방향으로 한칸씩 이동
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("main 시작=>1");
//		int a=10;
//		int b=20;
//		System.out.println("main => 변경 전");
//		System.out.println("a= "+a);
//		System.out.println("b= "+b);
//		swap(a,b);
//		System.out.println("main => 변경 후");
//		System.out.println("a= "+a);
//		System.out.println("b= "+b);
//		System.out.println("main 종료 => 프로그램 종료=>7");
		
		int[] arr= {10,20,30};
		int[] a=arr; // 별칭개념 arr이라는 이름 대신에 a라는 이름을 쓰겠다랑 비슷한 의미
		System.out.println("arr= "+arr);
		System.out.println("a= "+a);  // arr과 a가 같은 주소값을 가진다
		a[0]=1000;
		a[1]=2000;
		a[2]=3000;
		System.out.println(arr[0]); 
		System.out.println(arr[1]);
		System.out.println(arr[2]);//주소값이 같기 때문에 a값만 변경해도 arr값이 같이 변경됨
		System.out.println("arr= "+arr);
		System.out.println("a= "+a); 
	}

}
