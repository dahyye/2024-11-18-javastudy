
public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a3=0;
		int a5=0;
		int a7=0;
		
		for(int i=1; i<=100 ; i++)
		{
			if(i%3==0)
			{
				a3+=i;
			}
			if(i%5==0)
			{
				a5+=i;
			}
			if(i%7==0)
			{
				a7+=i;
			}
			
			//배수가 서로 겹칠 수 있으니까 단일if문으로 실행
			
		}
		
		System.out.println("3의배수 합 : "+a3);
		System.out.println("5의배수 합 : "+a5);
		System.out.println("7의배수 합 : "+a7);
		
		
	}

}
