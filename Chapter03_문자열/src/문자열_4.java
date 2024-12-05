/*
 https://try.jsoup.org/     => htmi가져오기
	------------------
	데이터를 모아서 저장 : 배열
	명령문을 모아서 처리 : 메소드
	-----------------------> 모아서 처리 : 클래스
	 						------------------> 여러개 모아서 처리 : 패키지

 	마지막으로 예외처리
 	
 	
 */
import java.util.*;

public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



int a1=(int)(Math.random()*100)+1;
		int a2=(int)(Math.random()*100)+1;
		int a3=(int)(Math.random()*100)+1;
		int a4=(int)(Math.random()*100)+1;
		int a5=(int)(Math.random()*100)+1;
		int a6=(int)(Math.random()*100)+1;
		int a7=(int)(Math.random()*100)+1;
		int a8=(int)(Math.random()*100)+1;
		int a9=(int)(Math.random()*100)+1;
		int a0=(int)(Math.random()*100)+1;
		int max=0;
		int max2=0;
		
		
		int[] arr=new int[10];
		for(int i=0;i<9;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
			System.out.println(arr[i]);
			if(arr[i]>max2)
				max2=arr[i];
		}
		
		if(a1>max)
			max=a1;
		if(a2>max)
			max=a2;
		if(a3>max)
			max=a3;
		if(a4>max)
			max=a4;
		if(a5>max)
			max=a5;
		if(a6>max)
			max=a6;
		if(a7>max)
			max=a7;
		if(a8>max)
			max=a8;
		if(a9>max)
			max=a9;
		
		
		System.out.printf("%d %d %d %d %d %d %d %d %d\n", a1,a2,a3,a4,a5,a6,a7,a8,a9);
		System.out.println(max);
		System.out.println(Arrays.toString(arr)); //배열출력
		System.out.println(max2);
	}

}
