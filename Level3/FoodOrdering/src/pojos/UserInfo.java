package pojos;

public class UserInfo {

	private int age;
	private double mobile;
	private String name,email,password;
	
	
	public int getAge() {
		return age;
	}
	public double getMobile() {
		return mobile;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
