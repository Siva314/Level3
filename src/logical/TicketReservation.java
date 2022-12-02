package logical;

import helper.HelperException;
import pojo.UserInfo;
import storage.FileLayer;
import storage.Storage;

public class TicketReservation {

	Storage controller=new FileLayer();
	
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
	
	public void logout() {
		
	}
	
	
}
