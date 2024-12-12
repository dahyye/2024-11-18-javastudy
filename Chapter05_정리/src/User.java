
public class User {
	private String id;
	private String pwd;
	private String nickname;


	public User() {}
	
	public User(String id, String pwd, String nickname) {
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}//생성자

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}