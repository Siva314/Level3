package storagelayer;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.HotelDetails;
import pojos.UserInfo;

public interface Storage {

	List<HotelDetails> sortByName()throws HelperException;
	List<HotelDetails> sortByRating() throws HelperException;
	Map<String,HotelDetails> searchByPlace(String placeName) throws HelperException;
	List<HotelDetails> sortByRoomAvailable() throws HelperException;
	List<UserInfo> printAllBookingDatas() throws HelperException;
	List<HotelDetails> printAllHotel() throws HelperException;
	
}
