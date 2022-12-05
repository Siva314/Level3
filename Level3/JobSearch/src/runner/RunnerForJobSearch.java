package runner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import helper.HelperException;
import logicallayer.JobSearch;
import pojos.ApplicantInfo;
import pojos.CompanyInfo;
import pojos.JobPost;

public class RunnerForJobSearch {
	
	static Scanner scanner=new Scanner(System.in);
	
	public static int getInteger(int number) {
		boolean flag=true;
		while(flag) {
			if(scanner.hasNextInt()) {
				number=scanner.nextInt();
				return number;
			}
			System.out.println("Enter integer only");
		}
		return number;
	}

	public static void main(String[] args) {
		JobSearch jobObject=new JobSearch();
		boolean flag=true;
		do {
			System.out.println("1.User Login\n2.Company Login\n3.New Applicant\n4.New Company Registration\n5.Leave Appllication");
			int outerChoice=getInteger(0);
			try {
				switch(outerChoice) {
					case 1:{
						System.out.println("Enter User Name");
						String userName=scanner.next();
						System.out.println("Enter password");
						String password=scanner.next();
						ApplicantInfo details=jobObject.userLogin(userName, password);
						System.out.println("Welcome "+details.getName());
						boolean checker=true;
						do {
							System.out.println("1.Job Search\n2.Inbox\n3.Logout");
							int userChoice=getInteger(0);
							try {
								switch(userChoice) {
									case 1:{
										System.out.println("Enter job role");
										String role=scanner.next();
										List<JobPost> list=jobObject.showCompanyList(role);
										int i=1;
										if(list!=null) {
											for(JobPost temp:list) {
												System.out.println(i+" "+temp +" "+temp.getCompany());
											}
											int number=scanner.nextInt();
											CompanyInfo company=list.get(number-1).getCompany();
											System.out.println(jobObject.addApplicationForCompany(details, company));
										}
										else {
											System.out.println("Not Found");
										}
										break;
									}
									case 2:{
										CompanyInfo info=jobObject.showOffer(details.getUserName());
										if(info!=null) {
											System.out.println(info);
										}
										else {
											System.out.println("You didn't have any Offer");
										}
										break;
									}
									default:{
										checker=false;
										System.out.println("Keep search");
										break;
									}
								}
							}
							catch(HelperException e) {
								System.out.println(e.getMessage());
							}
						}while(checker);
						
						break;
					}
					case 2:{
						System.out.println("Enter User Name");
						String userName=scanner.next();
						System.out.println("Enter password");
						String password=scanner.next();
						CompanyInfo company=jobObject.companyLogin(userName, password);
						System.out.println("Welcome "+company.getCompanyName());
						boolean checker=true;
						do {
							System.out.println("1.Post Vacancy\n2.Select candidate\n3.view Application\n4.logout");
							int innerChoice=getInteger(0);
							try {
								switch(innerChoice) {
									case 1:{
										JobPost post=new JobPost();
										System.out.println("Enter the Job Title");
										post.setRole(scanner.next());
										System.out.println("Enter the Number of openings");
										post.setNumberOfOpenings(scanner.nextInt());
										System.out.println("Enter the Job critiria");
										post.setCriteria(scanner.nextLine());
										post.setCompany(company);
										System.out.println(jobObject.postNewJob(post));
										break;
									}
									case 2:{
										Map<String,ApplicantInfo> applicant=jobObject.viewApplicants();
										for(Entry<String, ApplicantInfo> info:applicant.entrySet()) {
											System.out.println(info);
										}
										System.out.println("Enter name to send mail");
										String name=scanner.next();
										ApplicantInfo select=applicant.get(name);
										System.out.println(jobObject.sendMail(select, company));
										break;
									}
									case 3:{
										List<ApplicantInfo> list=jobObject.showApplicationForCompany(company);
										if(list!=null) {
											int i=1;
											for(ApplicantInfo temp:list) {
												System.out.println(i+" "+temp);
											}
											System.out.println("Enter number");
											int number=scanner.nextInt();
											ApplicantInfo select=list.get(number-1);
											System.out.println(jobObject.sendMail(select, company));
											
										}
										else {
											System.out.println("No application found");
										}
										break;
									}
									default:{
										checker=false;
										System.out.println("Keep use us");
										break;
									}
								}
							}
							catch(HelperException e) {
								System.out.println(e.getMessage());
							}
						}while(checker);
						break;
					}
					case 3:{
						ApplicantInfo application=new ApplicantInfo();
						System.out.println("Enter the Name");
						application.setName(scanner.next());
						System.out.println("Enter the Email");
						application.setEmail(scanner.next());
						System.out.println("Enter the mobile");
						application.setMobile(scanner.nextLong());
						System.out.println("Enter the Role");
						application.setRole(scanner.next());
						System.out.println("Enter the Age");
						application.setAge(scanner.nextInt());
						System.out.println("Enter the Experience");
						application.setExperience(scanner.nextInt());
						System.out.println("Enter the Username");
						application.setUserName(scanner.next());
						System.out.println("Enter the Password");
						application.setPassword(scanner.next());
						jobObject.addApplicant(application);
						break;
					}
					case 4:{
						CompanyInfo company=new CompanyInfo();
						System.out.println("Enter the Company");
						company.setCompanyName(scanner.next());
						System.out.println("Enter the Company Website");
						company.setWebsite(scanner.next());
						System.out.println("Enter the company mobile number");
						company.setMobile(scanner.nextLong());
						System.out.println("Enter the Email");
						company.setEmail(scanner.next());
						System.out.println("Enter the Username");
						company.setUserName(scanner.next());
						System.out.println("Enter the password");
						company.setPassword(scanner.next());
						jobObject.addCompany(company);
						break;
					}
					case 5:{
						System.out.println("Keep using your application");
						flag=false;
						break;
					}
					default:{
						System.out.println("Enter valid choice");
						break;
					}
				}
			}
			catch (HelperException e) {
				System.out.println(e.getMessage());
			}
			
		}while(flag);
		
	}

}
