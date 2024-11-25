//1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라


public class number7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter=0;
		
		for(int i=2;i<=30;i+=2)
		{
			counter +=1;
			System.out.print(i + " ");
			if(counter%3==0)
			{
				System.out.println();
			}
		}	
//		for(int i=1;i<=30;i++)
//		{
//			if(i%2==0)
//			{
//				System.out.printf("%02d\t",i);
//				if(i%3==0)
//					{
//						System.out.println();
//					}
//			}
//		}
			
		

	}

}
