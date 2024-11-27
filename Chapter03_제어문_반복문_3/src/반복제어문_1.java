/*
 
 	break; => 반복문, 선택문에서만 사용이 가능 (if문에서는 불가능)
 	
 	for()
 	{
 		if()
 		{
 		break; -> for문안에 있는 if문에서는 사용 가능해
 		}
 		
 	}
 	
	
 	
 	continue => 반복문에서만 사용이 가능
 	조건문 / 선택문에서는 사용이 불가능
 	=>특정부분을 제외할 때 사용
 	=>for문에서는 증가식으로 이동
 	=>while문에서는 조건식으로 이동
 	
 	
 	break나 continue가 있는 경우에 다음에는 소스코딩을 할 수 없다
 	for()
 	{
 		if()
 		{
 		//코딩가능
 		break;
 		//코딩불가능
 		}
 		
 	}
 	
 */
public class 반복제어문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++)
		{
			if(i==5)
				continue;  // continue결과값 5만제거하고 출력, break결과값 4까치 출력 후 종료
			System.out.print(i+" ");
			
		}
	}

}
