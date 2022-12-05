package storagelayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.UserInfo;

public class CacheLayer implements Storage {
	
	static Map<String,UserInfo> loginDetails=new LinkedHashMap<>();
	static Map<String,Map<String,Integer>> hotel=new LinkedHashMap<>();
	static Map<String,Integer> foodMap=new LinkedHashMap<>();
	
	
	public CacheLayer() {
		UserInfo user=new UserInfo();
		user.setAge(21);
		user.setEmail("user1@123.com");
		user.setMobile(1234567890l);
		user.setName("user1");
		user.setPassword("user1@123");
		loginDetails.put(user.getEmail(), user);
		
		UserInfo user1=new UserInfo();
		user1.setAge(23);
		user1.setEmail("user2@123.com");
		user1.setMobile(1234567560l);
		user1.setName("user2");
		user1.setPassword("user2@123");
		loginDetails.put(user1.getEmail(), user1);
		
		Map<String,Integer> food1=new LinkedHashMap<>();
		food1.put("Idly (2)", 30);
		food1.put("Dosa", 30);
		food1.put("Masal Dosa", 50);
		food1.put("Pongal", 90);
		food1.put("Vadai", 10);
		food1.put("Poori(2)", 30);
		food1.put("Chappathi(2)", 30);
		food1.put("Veg meals", 130);
		
		hotel.put("Murugan Bhavan", food1);
		Map<String,Integer> food2=new LinkedHashMap<>();
		food2.put("Idly (2)", 30);
		food2.put("Dosa", 30);
		food2.put("Masal Dosa", 50);
		food2.put("Pongal", 90);
		food2.put("Vadai", 10);
		food2.put("Poori(2)", 30);
		food2.put("Chappathi(2)", 30);
		food2.put("Veg meals", 150);
		food2.put("Non-veg meals", 200);
		food2.put("Chicken Briyani", 200);
		food2.put("Mutton Briyani", 250);
		food2.put("Parotta(2)", 50);
		hotel.put("Muniyandi vilas", food2);
		foodMap=new LinkedHashMap<>(food2);
		foodMap.put("Grilled Chicken", 450);
		foodMap.put("BBQ grill",300 );
		
	}

	@Override
	public boolean signUp(UserInfo user) throws HelperException {
		loginDetails.put(user.getEmail(), user);
		return true;
		
	}

	@Override
	public UserInfo checkLogin(String userName, String password) throws HelperException {
		if(loginDetails.containsKey(userName)) {
			UserInfo user=loginDetails.get(userName);
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				throw new HelperException("Wrong password");
			}
		}
		throw new HelperException("Invalid user");
	}

	@Override
	public Map<String, Integer> searchHotel(String hotelName) throws HelperException {
		return hotel.get(hotelName);
	}

	@Override
	public Map<String, Integer> searchFood() throws HelperException {
		return foodMap;
	}

	@Override
	public List<String> getHotelName() throws HelperException {
		List<String> hotelList=new ArrayList<>(hotel.keySet());
		return hotelList;
	}

}
