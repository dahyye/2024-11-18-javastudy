/*
 	반복문
 	while / do~while
 		
 		break; : 반복종료
 		continue : 특정부분을 제외
 				(for문에서는 증가식으로 이동, while문에서는 조건식으로 이동)
 				
 		
 
 
 
 */
public class 반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~10출력
		System.out.println("=======for======");
		
		for(int i=1;i<=10;i++)
		{
			System.out.print(i+" ");
		}
		
		
		System.out.println("\n\n=======while======");
		
		int i=1;
		while(i<=10)
		{
			System.out.print(i+" ");
			i++;
		}
		
		
		i=1;
		System.out.println("\n\n=====do ~ while====");
		
		do
		{
			System.out.print(i+" ");
			i++;
		}while(i<=10);
		
		
	}

}
