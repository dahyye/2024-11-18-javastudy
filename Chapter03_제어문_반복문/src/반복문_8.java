//10개의 정수를 추출해서 최소값, 최대값을 구하기
//1~100

public class 반복문_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int max=1, min=100; // 1~100사이이 값이니까
		int a3=0;
		for(int i=1;i<=10;i++)
		{
			int num=(int)(Math.random()*100)+1; //1~100
//						~~~~~~~~~~~~~~~
//						   0.0~0.99						
			System.out.print(num+" ");
			//최대값
			//최소값
			if(max<num) // max 값과 min값에 각각 1,100을 초기값으로 넣은 이유 (비교하기가 쉬워)
				max=num;
			else if(min>num)
				min=num;
			
			if(num%3==0)
				a3+=1;
			/// 생략가능	else 
			// a3++;
			
		}
		System.out.println();
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);
		System.out.println("3의 배수는 "+a3+"개");
	}

}
