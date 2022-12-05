package storagelayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.ApplicantInfo;
import pojos.CompanyInfo;
import pojos.JobPost;

public class CacheLayer implements Storage{
	
	static Map<String,CompanyInfo> companyDetails=new HashMap<>();
	static Map<String,ApplicantInfo> applicantDetails=new HashMap<>();
	static Map<String,List<JobPost>> availableJob=new  HashMap<>();
	static Map<String,CompanyInfo> selectionListForApplicant=new HashMap<>();
	static Map<String,List<ApplicantInfo>> selectionListForCompany=new HashMap<>();
	
	
	public CacheLayer() {
		CompanyInfo company=new CompanyInfo();
		company.setCompanyName("zoho");
		company.setEmail("zoho@info.com");
		company.setMobile(9876543210l);
		company.setPassword("Zoho@123");
		company.setUserName("zoho123");
		company.setWebsite("zoho.info");
		
		companyDetails.put(company.getUserName(), company);
		
		CompanyInfo company2=new CompanyInfo();
		company2.setCompanyName("tcs");
		company2.setEmail("tcs@info.com");
		company2.setMobile(9767543210l);
		company2.setPassword("Tcs@123");
		company2.setUserName("tcs123");
		company2.setWebsite("tcs.info");
		
		companyDetails.put(company2.getUserName(), company2);
		
		ApplicantInfo applicant=new ApplicantInfo();
		applicant.setAge(23);
		applicant.setEmail("applicant1@gmail.com");
		applicant.setExperience(1);
		applicant.setMobile(7865435647l);
		applicant.setName("Applicant1");
		applicant.setPassword("user1@123");
		applicant.setRole("Devolper");
		applicant.setUserName("user1");
		applicantDetails.put(applicant.getUserName(), applicant);
		
		ApplicantInfo applicant2=new ApplicantInfo();
		applicant2.setAge(26);
		applicant2.setEmail("applicant2@gmail.com");
		applicant2.setExperience(4);
		applicant2.setMobile(7865647435l);
		applicant2.setName("Applicant2");
		applicant2.setPassword("user2@123");
		applicant2.setRole("Devolper");
		applicant2.setUserName("user2");
		applicantDetails.put(applicant2.getUserName(), applicant2);
		
		JobPost job1=new JobPost();
		job1.setCompany(company);
		job1.setCriteria("Skills required =Java,Sql");
		job1.setNumberOfOpenings(3);
		job1.setRole("Devolper");
		
		List<JobPost> jList=new ArrayList<>();
		jList.add(job1);
		
		JobPost job2=new JobPost();
		job2.setCompany(company2);
		job2.setCriteria("Skill set = C++,Java");
		job2.setNumberOfOpenings(5);
		job2.setRole("Devolper");
		jList.add(job2);
		
		availableJob.put("devolper", jList);
		
	}

	@Override
	public boolean createApplicant(ApplicantInfo info) throws HelperException {
		String userName=info.getUserName();
		applicantDetails.put(userName, info);
		return true;
	}

	@Override
	public boolean createCompanyRecord(CompanyInfo details) throws HelperException {
		String userName=details.getUserName();
		companyDetails.put(userName, details);
		return true;
	}

	@Override
	public ApplicantInfo checkUserLogin(String userName) throws HelperException {
		if(applicantDetails.containsKey(userName)) {
			return applicantDetails.get(userName);
		}
		else {
			throw new HelperException("Invalid User");
		}
	}

	@Override
	public CompanyInfo checkCompanyLogin(String userName) throws HelperException {
		if(companyDetails.containsKey(userName)) {
			return companyDetails.get(userName);
		}
		else {
			throw new HelperException("Invalid user");
		}
	}

	@Override
	public boolean addNewJob(JobPost newPost) throws HelperException {
		List<JobPost> list=new ArrayList<>();
		String role=newPost.getRole();
		if(availableJob.containsKey(role)) {
			list=availableJob.get(role);
		}
		list.add(newPost);
		availableJob.put(role, list);
		return true;
	}

	@Override
	public Map<String, ApplicantInfo> showApplicants() throws HelperException {
		return applicantDetails;
	}

	@Override
	public boolean addApplicantInSelectionList(ApplicantInfo info, CompanyInfo cInfo) throws HelperException {
		selectionListForApplicant.put(info.getUserName(), cInfo);
		return true;
	}

	@Override
	public List<ApplicantInfo> showApplicationList(CompanyInfo info) throws HelperException {
		String name=info.getCompanyName();
		if(selectionListForCompany.containsKey(name)) {
			return selectionListForCompany.get(name);
		}
		return null;
	}

	@Override
	public List<JobPost> showJobs(String role) throws HelperException {
		if(availableJob.containsKey(role)) {
			return availableJob.get(role);
		}
		return null;
	}

	@Override
	public boolean addNewApplicationForCompany(ApplicantInfo info,CompanyInfo cInfo) throws HelperException {
		String companyName=cInfo.getCompanyName();
		List<ApplicantInfo> list=new ArrayList<>();
		if(selectionListForCompany.containsKey(companyName)) {
			list=selectionListForCompany.get(companyName);
		}
		list.add(info);
		selectionListForCompany.put(companyName, list);
		return true;
	}

	@Override
	public CompanyInfo showInbox(String userName) throws HelperException {
		return selectionListForApplicant.get(userName);
	}

}
