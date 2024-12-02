import java.util.Arrays;

public class 배열응용_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.print("정렬 전 :");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.print("정렬 후 :");
		Arrays.sort(arr);  // 올림차순 => 필요하면 오버라이딩 시킬 수 있다
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		//내림차순
		for(int i=arr.length-1;i>=0;i--)
		{
			System.out.print(arr[i]+" ");
			
			//데이터베이스 연동 / 웹에서 브라우저 전송 => 사용자 정의 라이브러리
			
			
		}
		
		
	}

}
