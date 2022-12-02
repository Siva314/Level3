package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import helper.HelperException;
import pojo.ReservationInfo;
import pojo.UserInfo;

public class FileLayer implements Storage{
	
	static Map<String,Map<Integer,List<ReservationInfo>>>  reservationDetails;
	static Map<Integer,UserInfo> userDetails;
	static Map<String,List<Integer>> ticketAvailability;
	
	
	private ObjectOutputStream createFileOutputStream(String fileName) throws HelperException {
		try {
			return new ObjectOutputStream(new FileOutputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			throw new HelperException(e);
		} catch (IOException e) {
			throw new HelperException(e);
		}
	}

	private ObjectInputStream createFileInputStream(String fileName) throws HelperException {
		try {
			return new ObjectInputStream(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			throw new HelperException(e);
		} catch (IOException e) {
			throw new HelperException(e);
		}
	}
	

	@Override
	public boolean storeUserInfo(ReservationInfo details) throws HelperException {
//		ObjectInputStream inputStream=createFileInputStream("reservation.ser");
//		ObjectOutputStream outputStream=createFileOutputStream("reservation.ser");
//		try {
//			Map<String,Map<Integer,List<ReservationInfo>>> reservationDetails=(Map<String,Map<Integer,List<ReservationInfo>>>)inputStream.readObject();
//			reservationDetails.put(details.getPNRNumber(), details);
//			outputStream.writeObject(reservationDetails);
//		} catch (IOException | ClassNotFoundException e) {
//			throw new HelperException(e);
//		}
//		finally {
//			try {
//				inputStream.close();
//				outputStream.close();
//			} catch (IOException e) {
//				
//			}
//		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserInfo checkUser(int userId) throws HelperException {
		ObjectInputStream inputStream=createFileInputStream("loginDetails.ser");
		try {
			userDetails=(Map<Integer,UserInfo>)inputStream.readObject();
			UserInfo userInfo=userDetails.get(userId);
			return userInfo;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new HelperException(e);
		}
		finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				
			}
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, List<ReservationInfo>> getCompartmentDetails(String compartmentName) throws HelperException {
		ObjectInputStream inObject=createFileInputStream("reservation.ser");
		try {
			reservationDetails=(Map<String, Map<Integer, List<ReservationInfo>>>) inObject.readObject();
			Map<Integer,List<ReservationInfo>> classCompartment=reservationDetails.get(compartmentName);
			return classCompartment;
		} catch (ClassNotFoundException | IOException e) {
			throw new HelperException(e);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public void addOns(String method) throws HelperException {
		switch(method) {
		case "login":{
			ObjectInputStream objInput = null;
			try {
				objInput=createFileInputStream("loginDetails.ser");
				reservationDetails=(Map<String, Map<Integer, List<ReservationInfo>>>)objInput.readObject();
				ticketAvailability=(Map<String,List<Integer>>)objInput.readObject();
				
			} catch (ClassNotFoundException | IOException e) {
				throw new HelperException(e);
			}
			finally {
				try {
					objInput.close();
				} catch (IOException e) {
					
				}
			}
			break;
		}
		case "logout":{
			writeInFIle();
			break;
		}
		}
		
	}
	
	public void writeInFIle() throws HelperException {
		ObjectOutputStream objectOutput=createFileOutputStream("reservation.ser");
		try {
			objectOutput.writeObject(reservationDetails);
			objectOutput.writeObject(ticketAvailability);
		} catch (IOException e) {
			throw new HelperException(e);
		}
	}

	@Override
	public boolean bookTicket(ReservationInfo details) throws HelperException {
		String seatType=details.getSeatAllot();
		List<Integer> seatNumber=ticketAvailability.get(seatType);
		Collections.sort(seatNumber);
		details.setSeatAllot(String.valueOf(seatNumber.get(0)));
		seatNumber.remove(0);
		String classType=details.getClassType();
		int pnrNo=details.getPNRNumber();
		Map<Integer,List<ReservationInfo>> compartment=reservationDetails.get(classType);
		List<ReservationInfo> list=compartment.get(pnrNo);
		list.add(details);
		compartment.put(pnrNo, list);
		reservationDetails.put(classType, compartment);
		return true;
	}

}
