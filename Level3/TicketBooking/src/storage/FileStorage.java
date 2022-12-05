package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import helper.HelperException;
import pojo.ReservationInfo;
import pojo.UserInfo;

public class FileStorage implements Storage{
	
	static Map<String,Map<Integer,List<ReservationInfo>>>  reservationDetails;
	static Map<Integer,UserInfo> userDetails;
	static Map<String,List<String>> ticketAvailability;
	static Queue<ReservationInfo> waitingList;
	static Map<Integer,List<ReservationInfo>> allDetails;
	
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
	

	@SuppressWarnings("unchecked")
	@Override
	public UserInfo checkUser(int userId) throws HelperException {
		ObjectInputStream inputStream=null;
		try {
			inputStream=createFileInputStream("/home/inc11/Level3/TicketBooking/src/storage/loginDetails.ser");
			userDetails=(Map<Integer,UserInfo>)inputStream.readObject();
			UserInfo userInfo=userDetails.get(userId);
			return userInfo;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new HelperException(e);
		}
		finally {
			if(inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					
				}
			}			
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void addOns(String method) throws HelperException {
		switch(method) {
		case "login":{
			ObjectInputStream objInput = null;
			try {
				objInput=createFileInputStream("/home/inc11/Level3/TicketBooking/src/storage/reservation.ser");
				ticketAvailability=(Map<String,List<String>>)objInput.readObject();
				reservationDetails=(Map<String,Map<Integer,List<ReservationInfo>>>)objInput.readObject();
				waitingList=(Queue<ReservationInfo>)objInput.readObject();
				allDetails=(Map<Integer,List<ReservationInfo>>)objInput.readObject();
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
		case "print":{
			for(Entry<Integer, UserInfo> entry:userDetails.entrySet()) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			for(Entry<String, List<String>> entry:ticketAvailability.entrySet()) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			for(Entry<String, Map<Integer, List<ReservationInfo>>> entry:reservationDetails.entrySet()) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			for(ReservationInfo info:waitingList) {
				System.out.println(info);
			}
			
			
		}
		case "logout":{
			writeInFIle();
			break;
		}
		}
		
	}
	
	public void writeInFIle() throws HelperException {		
		try(ObjectOutputStream objectOutput=createFileOutputStream("/home/inc11/Level3/TicketBooking/src/storage/reservation.ser")) {
			objectOutput.writeObject(ticketAvailability);
			objectOutput.writeObject(reservationDetails);
			objectOutput.writeObject(waitingList);
			objectOutput.writeObject(allDetails);			
		} catch (IOException e) {
			throw new HelperException(e);
		}
	}

	@Override
	public boolean bookTicket(ReservationInfo details) throws HelperException {
		String seatType=details.getSeatAllot();
		List<String> seatNumber=ticketAvailability.get(seatType);
		Collections.sort(seatNumber);
		details.setSeatAllot(seatNumber.get(0));
		seatNumber.remove(0);
		String classType=details.getClassType();
		int pnrNo=details.getPNRNumber();
		Map<Integer,List<ReservationInfo>> compartment=reservationDetails.get(classType);
		List<ReservationInfo> list=new ArrayList<>();
		if(compartment.containsKey(pnrNo)) {
			list=compartment.get(pnrNo);
		}
		list.add(details);
		compartment.put(pnrNo, list);
		reservationDetails.put(classType, compartment);
		List<ReservationInfo> reservInfo=new ArrayList<>();
		if(allDetails.containsKey(pnrNo)) {
			reservInfo=allDetails.get(pnrNo);
		}
		reservInfo.add(details);
		allDetails.put(pnrNo, reservInfo);
		return true;
	}

	@Override
	public List<ReservationInfo> showReservation(int number,String classType) throws HelperException {
		Map<Integer,List<ReservationInfo>> compartment=reservationDetails.get(classType);
		return compartment.get(number);
	}

	@Override
	public Map<String, List<String>> showAvailability(String classType) throws HelperException {
		return ticketAvailability;
	}

	@Override
	public boolean addInWaitingList(ReservationInfo details) throws HelperException {
		return waitingList.add(details);
	}

	@Override
	public boolean cancelTicket(int pnrNumber, String classType) throws HelperException {
		Map<Integer,List<ReservationInfo>> compartment=reservationDetails.get(classType);
		List<ReservationInfo> list=compartment.get(pnrNumber);
		ReservationInfo reserv=list.get(0);
		list.remove(0);
		String seatNumber=reserv.getSeatAllot();
		changeRecord(seatNumber);
		reserv.setStatus("Cancelled");
		compartment.put(pnrNumber, list);
		reservationDetails.put(classType, compartment);
		List<ReservationInfo> reservInfo=new ArrayList<>();
		if(allDetails.containsKey(pnrNumber)) {
			reservInfo=allDetails.get(pnrNumber);
		}
		reservInfo.add(reserv);
		allDetails.put(pnrNumber, reservInfo);
		return true;
	}
	
	private boolean changeRecord(String seatNumber) throws HelperException{
		if(waitingList.isEmpty()) {
			if(seatNumber.startsWith("LOW")) {
				List<String> list=ticketAvailability.get("lower");
				if(!list.contains(seatNumber)) {
					list.add(seatNumber);
				}
				ticketAvailability.put(seatNumber, list);
			}
			else if(seatNumber.startsWith("UPP")) {
				List<String> list=ticketAvailability.get("upper");
				if(!list.contains(seatNumber)) {
					list.add(seatNumber);
				}
				ticketAvailability.put(seatNumber, list);
			}
			else {
				List<String> list=ticketAvailability.get("middle");
				if(!list.contains(seatNumber)) {
					list.add(seatNumber);
				}
				ticketAvailability.put(seatNumber, list);
			}
			return true;
		}
		else {
			ReservationInfo reserv=waitingList.element();
			reserv.setSeatAllot(seatNumber);
			reserv.setStatus("Booked");
			int pnrNo=reserv.getPNRNumber();
			String className=reserv.getClassType();
			Map<Integer,List<ReservationInfo>> compartment=reservationDetails.get(className);
			List<ReservationInfo> list=new ArrayList<>();
			list.add(reserv);
			compartment.put(pnrNo, list);
			reservationDetails.put(className, compartment);
			waitingList.remove();
			List<ReservationInfo> reservInfo=new ArrayList<>();
			if(allDetails.containsKey(pnrNo)) {
				reservInfo=allDetails.get(pnrNo);
			}
			reservInfo.add(reserv);
			allDetails.put(pnrNo, reservInfo);
			return true;
		}
	}

}
