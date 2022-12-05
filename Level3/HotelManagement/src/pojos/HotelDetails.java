package pojos;

public class HotelDetails{

	private String hotelName,location;
	private int availableRooms,roomPrice;
	private double rating;
	
	
	public String getHotelName() {
		return hotelName;
	}
	public String getLocation() {
		return location;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public double getRating() {
		return rating;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	
	@Override
	public String toString() {
		return "hotelName=" + hotelName + ", location=" + location + ", availableRooms=" + availableRooms
				+ ", rating=" + rating + ", roomPrice=" + roomPrice ;
	}
	
	
}
