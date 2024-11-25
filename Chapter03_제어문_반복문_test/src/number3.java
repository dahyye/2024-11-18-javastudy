/*
 * 
 * 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
 */
public class number3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int sum=0;
		for(int i=2;i<=100;i+=2)
		{
			sum=sum+i;
			// sum+=i;
		}
		System.out.println("2~100까지 짝수의 합은 "+sum);
	
	}

}
