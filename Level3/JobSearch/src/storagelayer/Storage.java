package storagelayer;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.ApplicantInfo;
import pojos.CompanyInfo;
import pojos.JobPost;

public interface Storage {

	ApplicantInfo checkUserLogin(String userName) throws HelperException;
	CompanyInfo checkCompanyLogin(String userName) throws HelperException;
	boolean createApplicant(ApplicantInfo info) throws HelperException;
	boolean createCompanyRecord(CompanyInfo details) throws HelperException;
	
	boolean addNewJob(JobPost newPost) throws HelperException;
	Map<String,ApplicantInfo> showApplicants() throws HelperException;
	boolean addApplicantInSelectionList(ApplicantInfo info,CompanyInfo cInfo) throws HelperException;
	List<ApplicantInfo> showApplicationList(CompanyInfo info) throws HelperException;
	List<JobPost> showJobs(String role) throws HelperException;
	boolean addNewApplicationForCompany(ApplicantInfo info,CompanyInfo cInfo) throws HelperException;
	CompanyInfo showInbox(String userName) throws HelperException;
}
