package pojos;

public class JobPost {

	private String role,criteria;
	private int numberOfOpenings;
	private CompanyInfo company;
	

	public String getRole() {
		return role;
	}
	public String getCriteria() {
		return criteria;
	}
	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}
	public CompanyInfo getCompany() {
		return company;
	}
	
	
	public void setRole(String role) {
		this.role = role;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}
	public void setCompany(CompanyInfo company) {
		this.company = company;
	}
	
	public String toString() {
		return role+" "+criteria+" "+numberOfOpenings;
	}
	
}
