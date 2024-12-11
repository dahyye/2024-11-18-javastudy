package loginpkg;

public class UserLogin {

	//생성자 및 UserData 멤버변수 초기화 
	private String id;
	private String password;
	private String role;
	
	public UserLogin(String role) {
		String[] data=null;
		
		UserData userData = UserData.getInstance();
		
		if(role.equals("a"))
		{
			data = userData.getAdminData();	
		}else if(role.equals("u"))
		{
			data = userData.getUserData();
		}
		
		this.id=data[0];
		this.password=data[1];
		this.role=data[2];
		
	}
	//로그인 (아이디 비밀번호 맞는지 체크)
	boolean isLogin(String id, String passwordm, String role)
	{
		boolean rs = false;
		
		if(id.equals(this.id))
		{
			if(password.equals(this.password))
			{
				System.out.printf("Welcom !! %s%s",this.role,id);
				rs = true;
			}
			else
			{
				System.out.println("Login Fail-step3");
			}
			
		}
		else
		{
			System.out.println("Login Fail-step2");
		}
		return rs;
			
	}

}
