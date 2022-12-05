package storagelayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.HotelDetails;
import pojos.UserInfo;

public class CacheLayer implements Storage{
	
	static Map<String,Map<String,HotelDetails>> hotelInfo=new HashMap<>();
	static List<HotelDetails> list=new ArrayList<>();
	
	static List<UserInfo> userDetails=new ArrayList<>();
	
	public CacheLayer() {
		
		Map<String,HotelDetails> innerMap=new HashMap<>();
		HotelDetails hotel1=new HotelDetails();
		hotel1.setHotelName("PLA residency");
		hotel1.setLocation("karaikudi");
		hotel1.setAvailableRooms(4);
		hotel1.setRating(4.0);
		hotel1.setRoomPrice(400);
		
		innerMap.put(hotel1.getHotelName(), hotel1);
		
		HotelDetails hotel2=new HotelDetails();
		hotel2.setHotelName("RSA residency");
		hotel2.setLocation("karaikudi");
		hotel2.setAvailableRooms(3);
		hotel2.setRating(4.5);
		hotel2.setRoomPrice(400);
		
		innerMap.put(hotel2.getHotelName(), hotel2);
		
		hotelInfo.put(hotel2.getLocation(), innerMap);
		Map<String,HotelDetails> innerMap1=new HashMap<>();
		
		HotelDetails hotel3=new HotelDetails();
		hotel3.setAvailableRooms(4);
		hotel3.setHotelName("Bridhavan Residency");
		hotel3.setLocation("Pudukkottai");
		hotel3.setRating(3.8);
		hotel3.setRoomPrice(450);
		
		innerMap1.put(hotel3.getHotelName(), hotel3);
		
		HotelDetails hotel4=new HotelDetails();
		hotel4.setAvailableRooms(4);
		hotel4.setHotelName("SVS Shanthi Residency");
		hotel4.setLocation("Pudukkottai");
		hotel4.setRating(4.2);
		hotel4.setRoomPrice(480);
		
		innerMap1.put(hotel4.getHotelName(), hotel4);
		
		hotelInfo.put(hotel4.getLocation(), innerMap1);
		
		
		for(Map<String,HotelDetails> inner:hotelInfo.values()) {
			for(HotelDetails info:inner.values()) {
				list.add(info);
			}
		}
		
		UserInfo user1=new UserInfo();
		user1.setAmont(1350);
		user1.setHotelName("Bridhavan Residency");
		user1.setLocation("Pudukkottai");
		user1.setUserId(1);
		user1.setUserName("user1");
		userDetails.add(user1);
		
		UserInfo user2=new UserInfo();
		user2.setAmont(1600);
		user2.setHotelName("PLA Residency");
		user2.setLocation("Karaikudi");
		user2.setUserId(2);
		user2.setUserName("user2");
		userDetails.add(user2);
		
		UserInfo user3=new UserInfo();
		user3.setAmont(800);
		user3.setHotelName("RSA Residency");
		user3.setLocation("Karaikudi");
		user3.setUserId(3);
		user3.setUserName("user3");
		userDetails.add(user3);
		
		UserInfo user4=new UserInfo();
		user4.setAmont(1920);
		user4.setHotelName("SVS Shanthi Residency");
		user4.setLocation("Pudukkottai");
		user4.setUserId(4);
		user4.setUserName("user4");
		userDetails.add(user4);
		
		UserInfo user5=new UserInfo();
		user5.setAmont(1440);
		user5.setHotelName("SVS Shanthi Residency");
		user5.setLocation("Pudukkottai");
		user5.setUserId(5);
		user5.setUserName("user5");
		userDetails.add(user5);
	
	}

	@Override
	public List<HotelDetails> sortByName() throws HelperException {

		Collections.sort(list,new Comparator<HotelDetails>() {

			@Override
			public int compare(HotelDetails o1, HotelDetails o2) {
				return (o1.getHotelName().compareTo(o2.getHotelName()));
			}
			
		});
		return list;
		
	}

	@Override
	public List<HotelDetails> sortByRating() throws HelperException {
		Collections.sort(list,new Comparator<HotelDetails>() {

			@Override
			public int compare(HotelDetails o1, HotelDetails o2) {
				return String.valueOf(o2.getRating()).compareTo((String.valueOf(o1.getRating())));
			}
			
		});
		return list;		
	}

	@Override
	public Map<String, HotelDetails> searchByPlace(String placeName) throws HelperException {
		if(hotelInfo.containsKey(placeName)) {
			return hotelInfo.get(placeName);
		}
		return null;
		
	}

	@Override
	public List<HotelDetails> sortByRoomAvailable() throws HelperException {
		
		Collections.sort(list,new Comparator<HotelDetails>() {

			@Override
			public int compare(HotelDetails o1, HotelDetails o2) {
				return String.valueOf(o2.getAvailableRooms()).compareTo(String.valueOf(o1.getAvailableRooms()));
			}
			
		});
		return list;
		
	}

	@Override
	public List<UserInfo> printAllBookingDatas() throws HelperException {
		return userDetails;
	}

	@Override
	public List<HotelDetails> printAllHotel() throws HelperException {
		
		return list;
	}

}
