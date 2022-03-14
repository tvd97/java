package treeshopxml.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class UserLogin {

	private String username;
	private String password;
	private boolean remember;

	public UserLogin() {
		super();
	}

	public UserLogin(String username, String password, boolean remember) {
		super();
		this.username = username;
		this.password = password;
		this.remember = remember;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

}
