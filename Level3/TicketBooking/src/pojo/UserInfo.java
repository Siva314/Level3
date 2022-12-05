package pojo;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	
	private static final long serialVersionUID = 2872332265271799040L;
	private int userId,pnrNo;
	private String password,name;	
	
	
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPnrNo() {
		return pnrNo;
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
	
	public String toString() {
		return name+" "+password+" "+userId+" "+pnrNo;
	}
	
}
