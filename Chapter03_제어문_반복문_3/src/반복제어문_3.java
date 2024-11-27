
public class 반복제어문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for(int i=1; i<=3 ; i++)
			{
				for(int j=1;j<=3;j++)
				{
					
					if(j==2)
						continue;  //while문에서 가끔 잘못된 입력이 있는 경우 사용 => 
					System.out.println("i="+i+", j="+j);
				}
			
			}
			
			
	}

}
