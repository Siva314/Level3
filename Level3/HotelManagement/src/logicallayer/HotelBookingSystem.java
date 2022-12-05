package logicallayer;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.HotelDetails;
import pojos.UserInfo;
import storagelayer.CacheLayer;
import storagelayer.Storage;

public class HotelBookingSystem {

	Storage data=new CacheLayer();
	
	public List<HotelDetails> showHotel() throws HelperException{
		List<HotelDetails> hotelList=data.printAllHotel();
		if(hotelList!=null) {
			return hotelList;
		}
		else {
			throw new HelperException("No Hotel Found");
		}
	}
	
	public List<HotelDetails> orderByName() throws HelperException{
		List<HotelDetails> list=data.sortByName();
		if(list!=null) {
			return list;
		}
		else {
			throw new HelperException("No Hotel Found");
		}
	}
	
	public List<HotelDetails> orderByRooms() throws HelperException{
		List<HotelDetails> hotelList=data.sortByRoomAvailable();
		if(hotelList!=null) {
			return hotelList;
		}
		else {
			throw new HelperException("No Hotel Found");
		}
	}
	
	public List<HotelDetails> orderByRating() throws HelperException{
		List<HotelDetails> hotelList=data.sortByRating();
		if(hotelList!=null) {
			return hotelList;
		}
		else {
			throw new HelperException("No Hotel Found");
		}
	}
	
	public Map<String, HotelDetails> searchHotel(String name) throws HelperException{
		Map<String, HotelDetails> hotelMap=data.searchByPlace(name);
		if(hotelMap!=null) {
			return hotelMap;
		}
		else {
			throw new HelperException("No Hotel Found");
		}
	}
	
	public List<UserInfo> getBookedUsers() throws HelperException{
		List<UserInfo> userList=data.printAllBookingDatas();
		if(userList!=null) {
			return userList;
		}
		else {
			throw new HelperException("No user Found");
		}
	}
	
}
