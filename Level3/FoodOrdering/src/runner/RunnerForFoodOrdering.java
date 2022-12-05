package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import helper.HelperException;
import logicallayer.FoodOrdering;
import pojos.UserInfo;

public class RunnerForFoodOrdering {
	
	public static void main(String[] args) {
		FoodOrdering food=new FoodOrdering();
		@SuppressWarnings("resource")
		Scanner inputReader=new Scanner(System.in);
		boolean flag=true;
		do {
			System.out.println("1.Login\n2.SignUp\n3.Exit");
			int choice=inputReader.nextInt();
			try {
				switch(choice) {
					case 1:
						System.out.println("Enter username");
						String userName=inputReader.next();
						System.out.println("Enter password");
						String Upassword=inputReader.next();
						UserInfo userInfo=food.checkLogin(userName, Upassword);
						System.out.println("Welcome "+userInfo.getName());
						boolean check=true;
						do {
							System.out.println("1.Order by Hotel\n2.Order by Food\n3.Exit");
							int innerChoice=inputReader.nextInt();
							if(innerChoice==1) {
								List<String> hotelName=food.getHotelName();
								int number=1;
								for(String hName:hotelName) {
									System.out.println(number+" "+hName);
									number++;
								}
								System.out.println("Enter hotel");
								int hotelNumber=inputReader.nextInt();
								Map<String,Integer> foodMap=food.searchByHotel(hotelName.get(hotelNumber-1));
								int foodChoice=2,total=0;
								List<String> foodList=new ArrayList<>(foodMap.keySet());
								do {
									foodChoice=2;
									System.out.println("1.Cart");
									for(Entry<String, Integer> temp:foodMap.entrySet()) {
										System.out.println(foodChoice+" "+ temp.getKey()+" "+temp.getValue());
										foodChoice++;
									}
									System.out.println("Enter Food");
									int chooseFood=inputReader.nextInt();
									if(chooseFood==1) {
										break;
									}
									total+=foodMap.get(foodList.get(chooseFood-2));
								}while(foodChoice!=1);
								if(total==0) {
									break;
								}
								System.out.println("Your Total Amount is "+total+"\nEnter yes to confirm Order");
								String confirm=inputReader.next();
								if(confirm.equalsIgnoreCase("yes")) {
									System.out.println("Order confirmed");
								}
								break;
							}
							else if(innerChoice==2) {
								Map<String,Integer> foodMap=food.searchFood();
								int foodChoice=2,total=0;
								List<String> foodList=new ArrayList<>(foodMap.keySet());
								do {
									foodChoice=2;
									System.out.println("1.Cart");
									for(Entry<String, Integer> temp:foodMap.entrySet()) {
										System.out.println(foodChoice+" "+ temp.getKey()+" "+temp.getValue());
										foodChoice++;
									}
									System.out.println("Enter Food");
									int chooseFood=inputReader.nextInt();
									if(chooseFood==1) {
										break;
									}
									total+=foodMap.get(foodList.get(chooseFood-2));
								}while(foodChoice!=1);
								if(total==0) {
									break;
								}
								System.out.println("Your Total Amount is "+total+"\nEnter yes to confirm Order");
								String confirm=inputReader.next();
								if(confirm.equalsIgnoreCase("yes")) {
									System.out.println("Order confirmed");
								}
								break;
							}
							else {
								break;
							}
						}while(check);
						break;
						
					case 2:
						String password="",re_entry="";
						UserInfo user=new UserInfo();
						System.out.println("Enter the Email id");
						user.setEmail(inputReader.next());
						System.out.println("Enter Name");
						user.setName(inputReader.next());
						System.out.println("Enter Age");
						user.setAge(inputReader.nextInt());
						System.out.println("Enter Mobile");
						user.setMobile(inputReader.nextDouble());
						do {
							System.out.println("Enter the password");
							password=inputReader.next();
							System.out.println("Re-enter the Password");
							re_entry=inputReader.next();
						}while(!password.equals(re_entry));
						user.setPassword(password);
						food.createUser(user);
						break;
						
					case 3:
						flag=false;
						break;
				}
			}
			catch(HelperException e) {
				e.printStackTrace();
			}
			
		}while(flag);
	}

}
