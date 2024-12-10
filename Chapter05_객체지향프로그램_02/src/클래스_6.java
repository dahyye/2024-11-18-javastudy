class Rand
{
	//인스턴스 초기화 블럭
	int[] arr=new int[5];//저장이 안된상태
	static int[] arr2=new int[5]; //이미 저장된 상태 
	{
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
	}
	
	
	//생성자 블럭 초기화
	
	//인스턴스 변수의 초기화는 보통 생성자에서
	//static변수의 초기화는 static블럭에서 주로 사용
	
	Rand()
	{
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
	}
	
	static
	{
		for(int i=0;i<arr2.length;i++)
		{
			arr2[i]=(int)(Math.random()*100)+1;
		}
	}
	
}
public class 클래스_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rand r=new Rand();
		//r=> arr=>메모리가 따로 따로 저장
		//접근시 => 객체명.변수, 객체명.메소드		
		System.out.println("인스턴스");
		for(int i=0;i<r.arr.length;i++)
		{
			System.out.println(r.arr[i]);
		}
		//static => 클래스명.변수, 클래스명.메소드
		//ex. Math.random()    String.valueOf()
		System.out.println("static");
		for(int i=0;i<Rand.arr2.length;i++)
		{
			System.out.println(Rand.arr2[i]);
		}
	}

}
