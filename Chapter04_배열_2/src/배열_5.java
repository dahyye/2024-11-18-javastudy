/*
 
  6개의 난수 발생 ( 1~45사이의 중복되지 않는 난수 )
 
 
 */



import java.util.*;
public class 배열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int[6];
		for(int i=0;i<lotto.length;i++)
		{
			lotto[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++)
			{
				if(lotto[i]==lotto[j])
				{
					i--;  //중복이면 현재 발생한 난수의 자리에 다시 난수 발생
					break;
				}
			}
		}
		Arrays.sort(lotto); //정렬
		System.out.println(Arrays.toString(lotto));
		
			
		
	}

}
