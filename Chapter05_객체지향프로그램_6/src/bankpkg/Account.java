package bankpkg;

public class Account {
	
	private String name;
	private int balance;//잔액
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		if(name==null||name.isEmpty())
		{
			System.out.println("null이나 빈문자열 금지");
			return;
		}
		this.name = name;
		System.out.println("소유자 : "+name);
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		
		if(balance<0)
		{
			System.out.println("0보다 작은 숫자 금지");
			return;
		}
		this.balance = balance;
		System.out.println("잔액 : "+balance);
	}
	
	
	
	
}
