//1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 
public class number8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int b=0;
		for(int i=1 ; i<=10;i++)
		{
			if(i%2==0)
			{
				b-=i;
			}
			else
			{
				b+=i;		
			}
			
		}
		
		System.out.println("합은"+b);
		
		
		
	}

}
