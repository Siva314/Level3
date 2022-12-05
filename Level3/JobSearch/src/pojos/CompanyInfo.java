package pojos;

public class CompanyInfo {

	private String companyName,userName,password,website,email;
	private long mobile;
	

	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getWebsite() {
		return website;
	}
	public String getEmail() {
		return email;
	}
	public long getMobile() {
		return mobile;
	}
	
	public String toString() {
		return companyName+" "+website+" "+ mobile+" "+ email;
	}
	
}
