package pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReservationInfo implements Serializable{
	private int PNRNumber,trainNumber;
	private String classType,trainName,passangerName,fromPlace,destination,status,seatAllot;
	private LocalDateTime bookedDate,tarvelDate;
	
	
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
	public void setBookedDate(LocalDateTime bookedDate) {
		this.bookedDate = bookedDate;
	}
	public void setTarvelDate(LocalDateTime tarvelDate) {
		this.tarvelDate = tarvelDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setSeatAllot(String seatAllot) {
		this.seatAllot = seatAllot;
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
	public LocalDateTime getBookedDate() {
		return bookedDate;
	}
	public LocalDateTime getTarvelDate() {
		return tarvelDate;
	}
	public String getSeatAllot() {
		return seatAllot;
	}
}
