package bankpkg;

public class DepositService {
	
	private void open()
	{
		System.out.println("입금 작업이 시작되었습니다");
	}

	private void deposit()
	{
		System.out.println("입금되었습니다");
	}
	private void end()
	{
		System.out.println("입금작업이 끝났습니다");
	}
	public void work()
	{
		open();
		deposit();
		end();
	}
}
