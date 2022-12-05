package pojo;

import java.io.Serializable;

public class ReservationInfo implements Serializable,Comparable<ReservationInfo>{
	private static final long serialVersionUID = 1L;
	private int PNRNumber,trainNumber,price;
	private String classType,trainName,passangerName,fromPlace,destination,status,bookedDate,tarvelDate,seatAllot;
	
	public void setPNRNumber(int seatNumber) {
		this.PNRNumber = seatNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
	public void setTarvelDate(String tarvelDate) {
		this.tarvelDate = tarvelDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setSeatAllot(String seatAllot) {
		this.seatAllot = seatAllot;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

	public String getStatus() {
		return status;
	}
	public int getPNRNumber() {
		return PNRNumber;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public String getClassType() {
		return classType;
	}
	public String getTrainName() {
		return trainName;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public String getDestination() {
		return destination;
	}
	public String getBookedDate() {
		return bookedDate;
	}
	public String getTarvelDate() {
		return tarvelDate;
	}
	public String getSeatAllot() {
		return seatAllot;
	}
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return PNRNumber+" "+passangerName+" "+status+" "+trainNumber+" "
	+classType+" "+trainName+" "+fromPlace+" "+destination+" "+bookedDate+" "+tarvelDate+" "
				+seatAllot+" "+price;
	}
	@Override
	public int compareTo(ReservationInfo o) {
		return (this.PNRNumber-o.PNRNumber);
	}
}
