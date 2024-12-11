package bankpkg;

public class SingletoneBank {

	private static SingletoneBank instance = new SingletoneBank();
	
	private SingletoneBank() {
		// TODO Auto-generated constructor stub
		System.out.println("객체생성");
	}
	public static SingletoneBank getInstance()
	{
		System.out.println("객체 리턴");
		return instance;
	}
	}
