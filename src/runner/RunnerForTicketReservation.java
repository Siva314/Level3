package runner;

import java.util.Scanner;

import helper.HelperException;
import logical.TicketReservation;
import pojo.UserInfo;

public class RunnerForTicketReservation {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner inputReader=new Scanner(System.in);
		boolean flag=false;

		try {
			
			System.out.println("Enter the user id");
			int userId=inputReader.nextInt();
			System.out.println("enter the password");
			String password=inputReader.next();
			
			TicketReservation test=new TicketReservation();
			UserInfo user=test.checkLogin(userId, password);
			System.out.println("Welcome "+user.getName());
			do {
				
				System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.View Ticket\n4.Exit");
				int choice=inputReader.nextInt();
				switch(choice) {
					case 1:{
						break;
					}
					case 2:{
						break;
					}
					case 3:{
						break;
					}
					case 4:{
						test.logout();
						flag=false;
						break;
					}
				}
				
				
				System.out.println("do you want to contine .Then press 1");
				int condition=inputReader.nextInt();
				if(condition==1) {
					flag=true;
				}
			}while(flag);
		} catch (HelperException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
