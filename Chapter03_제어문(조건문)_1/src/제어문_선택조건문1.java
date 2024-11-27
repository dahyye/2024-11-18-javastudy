/*
 
 	선택조건문
 		=> 조건이 true일 때
 		=> 조건이 false일 때 
 		-------------------나눠서 처리
 		ex. 로그인 (o), 로그인(x)
 		=> 둘 중에 한 개의 문장만 무조건 수행
 		
 		if(조건문){
 		 
 		  true 일 때
 		  
 		}else {
 			
 		  false 일 때
 			
 		}
 		
 
 */


public class 제어문_선택조건문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char c='A';
		int type = (int)(Math.random()*2);
		
		if(type==0)
		{
			
			c=(char)(Math.random()*26+65);
			
		}
		if(type==1)
		{
			
			c=(char)(Math.random()*26+97);
		}
		System.out.println("type="+type);
		System.out.println("c="+c);
		
		System.out.println("======결과값======");
		/*
		if(c>='A'&&c<='Z')
			System.out.println(c+"는(은) 대문자입니다");
		if(c>='a'&&c<='z')
			System.out.println(c+"는(은) 소문자입니다");
		*/
		if(c>='A'&&c<='Z')
			System.out.println(c+"는(은) 대문자입니다");
		else
			System.out.println(c+"는(은) 소문자입니다");
	}

}
