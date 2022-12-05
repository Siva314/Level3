package logicallayer;

import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojos.UserInfo;
import storagelayer.CacheLayer;
import storagelayer.Storage;

public class FoodOrdering {
	
	Storage data=new CacheLayer();

	public UserInfo checkLogin(String userName,String password) throws HelperException{
		return data.checkLogin(userName, password);
	}
	
	public String createUser(UserInfo user) throws HelperException{
		if(data.signUp(user)) {
			return "Try to Login With new UserId";
		}
		else {
			return "Didn't create Try again after some time";
		}
	}
	
	public Map<String, Integer> searchByHotel(String hotel) throws HelperException{
		Map<String, Integer> map=data.searchHotel(hotel);
		if(map!=null) {
			return map;
		}
		else {
			throw new HelperException("Not found");
		}
	}
	
	public Map<String, Integer> searchFood() throws HelperException{
		Map<String, Integer> map=data.searchFood();
		if(map!=null) {
			return map;
		}
		else {
			throw new HelperException("Not Found");
		}
	}
	
	public List<String> getHotelName() throws HelperException{
		return data.getHotelName();
	}
}
