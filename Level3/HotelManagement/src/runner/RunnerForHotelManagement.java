package runner;

import java.util.Scanner;

import helper.HelperException;
import logicallayer.HotelBookingSystem;

public class RunnerForHotelManagement {

	public static void main(String[] args) {
		HotelBookingSystem hotel=new HotelBookingSystem();
		@SuppressWarnings("resource")
		Scanner inputReader=new Scanner(System.in);
		boolean flag=true;
		do {
			System.out.println("1.Print All Hotels\n2.Print Hotels by Ratings"
					+ "\n3.Print Hotels by Name\n4.Search Hotel\n5.Sort by Room Available\n6.View All Booked Details"
					+ "\n7.exit");
			int choice=inputReader.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.println(hotel.showHotel());
					break;
				
				case 2:
					System.out.println(hotel.orderByRating());
					break;
					
				case 3:
					System.out.println(hotel.orderByName());
					break;

				case 4:
					System.out.println("Enter the Location");
					String name=inputReader.next();
					System.out.println(hotel.searchHotel(name));
					break;
					
				case 5:
					System.out.println(hotel.orderByRooms());
					break;
					
				case 6:
					System.out.println(hotel.getBookedUsers());
					break;
					
				case 7:
					flag=false;
					break;
					
				default:
					System.out.println("Enter valid Choice");
					break;
				}
			} catch (HelperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(flag);


	}

}
