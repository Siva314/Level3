package pojo;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	
	private int userId;
	private String password,name;	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	
}
