package logical;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojo.UserInfo;
import pojo.ReservationInfo;
import storage.FileStorage;
import storage.Storage;

public class TicketReservation {

	Storage controller=new FileStorage();
	
	public UserInfo checkLogin(int userId,String password) throws HelperException {
		UserInfo user=null;
		try {
			user=controller.checkUser(userId);
			if(!user.getPassword().equals(password)) {
				throw new HelperException("Wrong Password");
			}
			controller.addOns("login");
		} catch (HelperException e) {
			throw new HelperException("Invaild User",e);
		}
		return user;
	}
	
	public List<ReservationInfo> viewReservation(int pnrNumber,String classType) throws HelperException {
		return controller.showReservation(pnrNumber, classType);
	}
	
	public void logout() throws HelperException {
		controller.addOns("logout");
	}
	
	public void printData() {
		try {
			controller.addOns("print");
		} catch (HelperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<String,List<String>> viewAvailability(String classType) throws HelperException{
		return controller.showAvailability(classType);
	}
	
	public String bookTicket(ReservationInfo details) throws HelperException{
		boolean flag=controller.bookTicket(details);
		if(flag) {
			return "Ticket Booked SuccessFully";
		}
		else {
			return "Booking Failed";
		}
	}
	
	public String bookTicketInWaiting(ReservationInfo details) throws HelperException{
		boolean flag=controller.addInWaitingList(details);
		if(flag) {
			return "Ticket Booked successfully";
		}
		return "Ticket booking failed";
	}
	
	public String cancelTicket(int pnrNummber,String classType) throws HelperException{
		boolean flag=false;
		flag=controller.cancelTicket(pnrNummber, classType);
		if(flag) {
			return "Ticket Cancelled";
		}return "Ticket not Cancelled please try again";
	}
	
}
