//1~10 사이의 숫자 중 3의 배수를 제외하고 출력하라 (continue 사용)

public class number9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=10; i++)
		{
			if(i%3==0)
			{
				continue;
			}
			else
			{
				System.out.print(i+" ");
			}
			
		}
		
		
	}

}
