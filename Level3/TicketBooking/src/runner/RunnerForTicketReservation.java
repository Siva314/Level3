package runner;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import helper.HelperException;
import logical.TicketReservation;
import pojo.UserInfo;
import pojo.ReservationInfo;

public class RunnerForTicketReservation {
	static TicketReservation test=new TicketReservation();
	
	static Scanner inputReader=new Scanner(System.in);
	
	public static int getInteger(int number) {
		boolean flag=true;
		while(flag) {
			if(inputReader.hasNextInt()) {
				number=inputReader.nextInt();
				flag=false;
			}
			else {
				System.out.println("Enter integer only");
				inputReader.next();
			}
		}
		return number;
	}
	
	public static void main(String[] args) {
		
		boolean flag=false;

		try {
			
			System.out.println("Enter the user id");
			int userId=getInteger(0);
			System.out.println("enter the password");
			String password=inputReader.next();
			
			UserInfo user=test.checkLogin(userId, password);
			System.out.println("Welcome "+user.getName());
			do {
				
				System.out.println("1.Book Ticket\n2.Cancel Ticket"
						+ "\n3.View Ticket\n4.Exit");
				int choice=getInteger(0);
				switch(choice) {
					case 1:{
						String[] array=new String[3];
						int i=0;
						Map<String,List<String>> availability=test.viewAvailability("firstClass");
						for(Entry<String, List<String>> temp:availability.entrySet()) {
							List<String> avail=temp.getValue();
							if(avail.size()>0) {
								String key=temp.getKey();
								array[i]=key;
								i++;
								System.out.println(key.toUpperCase()+"  "+avail);
							}
						}
						ReservationInfo detailOfReservation=new ReservationInfo();
						detailOfReservation.setPassangerName(user.getName());
						detailOfReservation.setPNRNumber(user.getPnrNo());
						detailOfReservation.setTrainName("Chennai Express");
						detailOfReservation.setTrainNumber(456732);
						detailOfReservation.setClassType("firstClass");
						detailOfReservation.setTarvelDate("21/12/2022");
						detailOfReservation.setBookedDate("02/12/2022");
						System.out.println("Enter from place");
						String fromPlace=inputReader.next();
						detailOfReservation.setFromPlace(fromPlace);
						System.out.println("Enter destination");
						String toPlace=inputReader.next();
						detailOfReservation.setDestination(toPlace);
						if(i==0) {
							detailOfReservation.setStatus("Waiting");
							detailOfReservation.setPrice(200);
							System.out.println("Ticket price 200");
							System.out.println(test.bookTicketInWaiting(detailOfReservation));
						}
						else {
							for(int j=0;j<3;j++) {
								if(array[j]!=null)
								System.out.println(j+1+"."+array[j]);
							}
							int seatType=getInteger(0);
							while(seatType<=0 || seatType>array.length) {
								System.out.println("Enter valid number");
								seatType=getInteger(0);
							}
							detailOfReservation.setSeatAllot(array[seatType-1]);
							detailOfReservation.setStatus("Booked");
							detailOfReservation.setPrice(200);
							System.out.println("Ticket price 200");
							System.out.println(test.bookTicket(detailOfReservation));
						}
						break;
					}
					case 2:{
						boolean check=printTicket(user);
						if(check) {
							System.out.println("Press to 1 to cancel");
							int cancel=getInteger(0);
							if(cancel==1) {
								System.out.println(test.cancelTicket(user.getPnrNo(), "firstClass"));
							}
						}
						break;
					}
					case 3:{
						printTicket(user);
						break;
					}
					case 65:{

						test.printData();
						break;
					}
					case 4:{
						test.logout();
						flag=false;
						break;
					}
				}
				
				
				System.out.println("do you want to contine .Then press 1");
				int condition=getInteger(0);
				if(condition==1) {
					flag=true;
				}
			}while(flag);
		} catch (HelperException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static boolean printTicket(UserInfo user) {
		try {
			List<ReservationInfo> list=test.viewReservation(user.getPnrNo(),"firstClass");
			for(ReservationInfo info:list) {
				System.out.println(info);
			}
			return true;
		}	
		catch(Exception e) {
			System.out.println("Sorry you didn't book any ticket");
			return false;
		}		
	}

}
