//10개의 알파벳을 추출 => 대문자 몇개, 소문자 몇개?
public class 반복문_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int big = 0;
		int small = 0;
		
		for(int i=1; i<=10;i++)
		{
			char c = 'A';
			int no=(int)(Math.random()*2); // 0,1
			if(no==0)
			{
				c=(char)((Math.random()*26)+65);  // 대문자 추출
				//big++;
			}
			else
			{
				c=(char)((Math.random()*26)+97);
				//small++;
			}
			System.out.print(c+" ");
			/*
			if(c>='A'&&c<='Z')
			{
				big++;
			}
			else
				small++;
			
			*/
		}
		System.out.println("대문자는"+big+"개");
		System.out.println("소문자는"+small+"개");
	}

}
