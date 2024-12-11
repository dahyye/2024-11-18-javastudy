package bankpkg;

public class SingletoneBankMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				
		SingletoneBank s1 = SingletoneBank.getInstance();
		SingletoneBank s2 = SingletoneBank.getInstance();
		SingletoneBank s3 = SingletoneBank.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
