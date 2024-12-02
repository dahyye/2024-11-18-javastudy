//6개의 난수 발생 ( 1~45사이의 중복되지 않는 난수 )  //피망에서 사용하고 있는 로직

import java.util.Arrays;
public class 배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] lotto = new int[6];
		int su=0; //난수 발생시 저장하는 변수
		boolean bCheck=false;  //중복여부 확인
		
		for(int i=0;i<lotto.length;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				su=(int)(Math.random()*45)+1;
				bCheck=false;  //while문 종료
				//같은 정수가 있는지 확인
				for(int j=0;j<i;j++)
				{
					if(lotto[j]==su) //저장된 데이터 중 같은 값이 있나
					{
						bCheck=true; //while문을 다시 실행import java.util.Arrays;
						break;
					}
				}
			}
			lotto[i]=su;
		}
		Arrays.sort(lotto);//배열정렬
		System.out.println(Arrays.toString(lotto));
		
		
	}

}
