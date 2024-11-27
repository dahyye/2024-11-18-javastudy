/*
 
 	증가되는 위치에 따라 변하는 값을 확인하기 위한 
 	예제들
 ★
 
 	주사위 2개를 던져서 6이 나올 확률?
 	
 */
public class 반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		char a = 'A';// 65
		
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				System.out.print((a++)+" ");
			}
			System.out.println();
		}
		
		System.out.println();System.out.println();System.out.println();
		
		
		for(int i=1;i<=4;i++)
		{
			char b ='A';
			for(int j=1;j<=4;j++)
			{
				System.out.print((b++)+" ");
			}
			System.out.println();
		}
		
		System.out.println();System.out.println();System.out.println();
		
		
		char c ='A';
		for(int i=1;i<=4;i++)
		{
			
			for(int j=1;j<=4;j++)
			{
				System.out.print(c+" ");
			}
			c++;
			System.out.println();
		}
		
		
		System.out.println();System.out.println();System.out.println();
		
		for(int i=1;i<=4;i++)
		{
			
			for(int j=1;j<=4;j++)
			{	
				if(i==j)
					System.out.print("#");
				else
					System.out.print(j);
					
			}
			System.out.println();
		}
		
		
		System.out.println();System.out.println();System.out.println();
		
		for(int i=1;i<=4;i++)
		{
			
			for(int j=1;j<=i;j++)
			{	
				System.out.print("★");
			}
			System.out.println();
		}
		
		
		System.out.println();System.out.println();System.out.println();
		
		for(int i=1;i<=4;i++)
		{
			
			for(int j=1;j<=5-i;j++)
			{	
				System.out.print("★");
			}
			System.out.println();
		}
		
		//주사위2개 던져서 합이 6이 나올 경우의 수
		int count=0;
		for(int i=1;i<=6;i++)
		{
			
			for(int j=1;j<=6;j++)
			{	
				
				if(i+j==6)
				{
					count+=1;
					System.out.print("["+i+","+j+"]");
				}
				
			}
			System.out.println();
		}
		System.out.println(count+"개");
		
		
		//역순표시할 땐 i+j=4 => j=4-i
		 
*/		
/*
 		   *
 		  **
 		 ***
 		****
 		
 		****
 		 ***
 		  **
 		   *
 	
 		i   j   k
 	   줄수 공백  별표
 		1   0   4
 		2   1	3
 		3   2	2
 		4	3	1
 		
 */
		//1-4 2-34 3-234
	/*	for(int i=0;i<=4;i++)
		{
			for(int j=2;j<=1+i;j++)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=4-i;k++)
			{				
				System.out.print("★");
			}
			System.out.println();    
		}
		
		for(int i=1;i<=4;i++) //줄수
		{
			for(int j=1;j<=i-1;j++)  //공백 규칙찾아 j=i-1
			{
				System.out.print(" ");
			}
			for(int k=1;k<=5-i;k++) //별표 k=5-1
			{				
				System.out.print("★");
			}
			System.out.println();    
		}
		
		*/
		
		
		for(int i=1;i<=4;i++)
		{
			
			for(int j=1;j<=4;j++)
			{	
				if(i==j)
					System.out.print("#");
				else
					System.out.print(j);
					
			}
			System.out.println();
		}
		
//		   *
//		  **
//		 ***
//		****
//		131
//		222
//		313
//		404
		for(int i=1;i<=4;i++) //줄수
		{
			for(int j=1;j<=4-i;j++)  //공백 규칙찾아 j=4-i
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) //별표 k=5-1  k=i
			{				
				System.out.print("★");
			}
			System.out.println();    
		}
		
		
		
		
		
	}

}
