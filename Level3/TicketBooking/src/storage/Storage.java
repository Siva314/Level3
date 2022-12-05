package storage;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojo.ReservationInfo;
import pojo.UserInfo;

public interface Storage {
	
	UserInfo checkUser(int userId) throws HelperException;
	
	boolean bookTicket(ReservationInfo details) throws HelperException;
	boolean addInWaitingList(ReservationInfo details) throws HelperException;
	List<ReservationInfo> showReservation(int number,String classType) throws HelperException;
	Map<String, List<String>> showAvailability(String classType)throws HelperException;
	
	boolean cancelTicket(int pnrNumber,String classType) throws HelperException;
	
	void addOns(String type) throws HelperException;

}
