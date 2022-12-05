package pojos;

public class ApplicantInfo {

	private int age,experience;
	private String userName,email,name,password,role;
	private long mobile;
	
	
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public int getExperience() {
		return experience;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public long getMobile() {
		return mobile;
	}
	
	public String toString() {
		return userName+" "+name+" "+age+" "+email+" "+mobile+" "+experience+" "+role;
	}
	
}
