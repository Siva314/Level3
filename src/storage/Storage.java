package storage;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojo.ReservationInfo;
import pojo.UserInfo;

public interface Storage {
	
	boolean storeUserInfo(ReservationInfo details) throws HelperException;
	UserInfo checkUser(int userId) throws HelperException;
	Map<Integer,List<ReservationInfo>> getCompartmentDetails(String className) throws HelperException;
	
	
	boolean bookTicket(ReservationInfo details) throws HelperException;
	
	
	void addOns(String type) throws HelperException;

}
