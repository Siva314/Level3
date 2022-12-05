package storagelayer;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.UserInfo;

public interface Storage {

	boolean signUp(UserInfo user) throws HelperException;
	UserInfo checkLogin(String userName,String Password) throws HelperException;
	Map<String,Integer> searchHotel(String hotelName) throws HelperException;
	Map<String,Integer> searchFood() throws HelperException;
	List<String> getHotelName() throws HelperException;
}
