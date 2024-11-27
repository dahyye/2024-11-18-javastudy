//1~10까지 난수를 발생 평균출력
public class 반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=1;
		int sum=0;
		double avg=0.0;
		while(i<=10)
		{
			int a=(int)(Math.random()*10)+1;
			System.out.print(a+" ");
			sum+=a;
			i++;
		}
		avg=sum/10.0;
		System.out.println("\n평균 값 : "+avg);
//		
		
		
	}

}
