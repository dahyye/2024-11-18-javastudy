/*
 
 	데이터 관리                       =>           데이터 가공             =>        가공된 데이터 출력
 	~~~~~~~~
 	-> 데이터를 묶어서 사용
 	  -------------------
 	     배열 / 클래스
 	     파일 / RDBMS(오라클)
 	     
 	     *오라클은 중형db
 	     
 	     
 	 데이터 가공 과정
 	 	요청에 맞게 가공 => 연산자 / 제어문 => 명령문을 묶어 => 메소드

 	가공된 데이터 출력 => 클래스 ( 재사용이 좋아서 기업용으로 많이 사용)
 	
 	
 	
 	데이터베이스
 	------------------ 데이터를 모아서 관리하는 곳
 	변수
 	char
 	
 */

//1~100사이의 난수 5개 발생

public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		int a=(int)(Math.random()*100)+1;
//		int b=(int)(Math.random()*100)+1;
//		int c=(int)(Math.random()*100)+1;
//		int d=(int)(Math.random()*100)+1;
//		int e=(int)(Math.random()*100)+1;
		
//		int max=a;
//		int min=a;
//		
////		
//		
//		if(max<b)
//			max=b;
//		if(max<c)
//			max=c;
//		if(max<d)
//			max=d;
//		if(max<e)
//			max=e;
//		
//		if(min>b)
//			min=b;
//		if(min>c)
//			min=c;
//		if(min>d)
//			min=d;
//		if(min>e)
//			min=e;
//		
//		System.out.printf("%d, %d, %d, %d, %d", a,b,c,d,e);
//		System.out.println("최소값 : "+min);
//		System.out.println("최대값 : "+max);
		
		int i=1;
		int max=1;
		int min=100;
		while(i<=10)
		{
			int a=(int)(Math.random()*100)+1;
			System.out.println(a+" ");
			if(max<a)
				max=a;
			if(min>a)
				min=a;
			i++;
			
			
		}
		System.out.println();
		System.out.println("최소값 : "+min);
		System.out.println("최대값 : "+max);
		
	
	}

}
