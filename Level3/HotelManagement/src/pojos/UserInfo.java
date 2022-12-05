package pojos;

public class UserInfo {

	private int userId,amont;
	private String userName,hotelName,location;
	
	
	public int getUserId() {
		return userId;
	}
	public int getAmont() {
		return amont;
	}
	public String getUserName() {
		return userName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getLocation() {
		return location;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setAmont(int amont) {
		this.amont = amont;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "userId=" + userId + ", amont=" + amont + ", userName=" + userName + ", hotelName=" + hotelName
				+ ", location=" + location;
	}
	
}
