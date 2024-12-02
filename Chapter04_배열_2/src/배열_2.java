/*
 	char 배열 사용법 / double / String
 */
public class 배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//선언
		char[] alpha = new char[26];
		//초기화
		char c='A';
		for(int i=0;i<alpha.length;i++) 
		{
			alpha[i]=c++; //A~Z까지 입력
		}
		
		//출력
		for(char cc:alpha)
		{
			System.out.print(cc+" ");
		}
		
		System.out.println();
		
		//=>'K'가 있는 인덱스번호를 출력 
		for(int i=0;i<alpha.length;i++) 
		{
			if(alpha[i]=='K')
			{
				System.out.println("K는 "+(i+1)+"번째이다");   //i번째를 int index변수를 만들어서 만들 수도 있음
															//index=i; 실제위치는 +1 
			}
			
			
		}
		
	}

}
