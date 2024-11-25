//1~100까지 합을 구하시오
public class 반복문_4 {
//짝수합, 홀수합, 총합 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int sum1=0;
		int sum2=0;
		for(int a=1; a<=100 ; a++)
		{
			
			sum+=a;
			
			
			if(a%2==0)
			{
				sum1+=a;
			}else
			{
				sum2+=a;
			}
			
			System.out.println("sum="+sum+",a="+a);
		}
		System.out.println("총합="+sum);
		System.out.println("짝수="+sum1);
		System.out.println("홀수="+sum2);
	}

}
