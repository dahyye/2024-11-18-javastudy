
public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1="Hello Java";
		String s2="Hello Java";
		String s3=new String("Hello Java");
		String s4=new String("hello java");
		
		//s1,s2는 주소값이 같아 
		if(s1==s3)//주소값비교
		{
			System.out.println("같다");
		}
		else
		{
			System.out.println("다르다");
		}
		if(s1.equals(s3))//실제 들어가있는 값 비교
		{
			System.out.println("같다");
		}
		else
		{
			System.out.println("다르다");
		}
		if(s1.equalsIgnoreCase(s4))//실제 들어가있는 값 비교(대소문자 구분x)
		{
			System.out.println("같다");
		}
		else
		{
			System.out.println("다르다");
		}
		
	}

}
