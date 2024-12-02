/* char변환

 	char => 문자열은 불가능
 			~~~~
 			compare() / equals()
 			  >  <        ==
 	
 		=> 정수형 취급한다
 		연산자를 사용하면 정수로 변경
		ex. 'A' < 'B'
		   =>65<66 
*/	
import java.util.Arrays;
public class 배열응용_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		char[] arr=new char[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(char)((int)(Math.random()*26)+65);
		}
		System.out.println("=======정렬전======");
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(arr[i]<arr[j])
				{
					char temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
						
			}
		}
		System.out.println();
		System.out.println("=======정렬후======");
		System.out.println(Arrays.toString(arr));  
		for(char a:arr)
		{
			System.out.print(a+" ");
		}
	}

}
