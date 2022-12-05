package logicallayer;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.ApplicantInfo;
import pojos.CompanyInfo;
import pojos.JobPost;
import storagelayer.CacheLayer;
import storagelayer.Storage;

public class JobSearch {
	Storage data=new CacheLayer();
	
	public ApplicantInfo userLogin(String userName,String password) throws HelperException{
		ApplicantInfo user= data.checkUserLogin(userName);
		if(user.getPassword().equals(password)) {
			return user;
		}
		else {
			throw new HelperException("Invalid password");
		}
	}
	
	public CompanyInfo companyLogin(String userName,String password) throws HelperException{
		CompanyInfo company=data.checkCompanyLogin(userName);
		if(company.getPassword().equals(password)) {
			return company;
		}
		else {
			throw new HelperException("Invalid password");
		}
	}
	
	public String addApplicant(ApplicantInfo details) throws HelperException{
		boolean check=data.createApplicant(details);
		if(check) {
			return "Create Successfully";
		}
		else {
			return "Creation failed";
		}
	}
	
	public String addCompany(CompanyInfo info) throws HelperException{
		boolean check=data.createCompanyRecord(info);
		if(check) {
			return "Create Successfully";
		}
		else {
			return "Creation failed";
		}
	}
	
	public String postNewJob(JobPost post) throws HelperException{
		boolean flag=data.addNewJob(post);
		if(flag) {
			return "Added successfully";
		}
		else {
			throw new HelperException("Cannot add new post");
		}
	}
	
	public Map<String,ApplicantInfo> viewApplicants() throws HelperException{
		return data.showApplicants();
	}
	
	public String sendMail(ApplicantInfo info,CompanyInfo cInfo) throws HelperException{
		boolean flag=data.addApplicantInSelectionList(info, cInfo);
		if(flag) {
			return "Notification sended";
		}
		return "Can't send Invitation";
	}
	
	public List<ApplicantInfo> showApplicationForCompany(CompanyInfo info) throws HelperException{
		return data.showApplicationList(info);
	}
	
	public List<JobPost> showCompanyList(String role) throws HelperException{
		return data.showJobs(role);
	}
	
	public String addApplicationForCompany(ApplicantInfo info,CompanyInfo cInfo) throws HelperException{
		boolean flag=data.addNewApplicationForCompany(info, cInfo);
		if(flag) {
			return "Successfully Send";
		}
		else {
			throw new HelperException("Didn't send");
		}
	}
	
	public CompanyInfo showOffer(String userName) throws HelperException{
		return data.showInbox(userName);
	}
	
}
