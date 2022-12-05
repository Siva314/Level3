package tester;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import pojo.ReservationInfo;
import pojo.UserInfo;

@SuppressWarnings("unused")
public class Testing {
	public static void main(String[] args) {
//		UserInfo user1=new UserInfo();
//		UserInfo user2=new UserInfo();
//		UserInfo user3=new UserInfo();
//		UserInfo user4=new UserInfo();
//		UserInfo user5=new UserInfo();
//		user1.setUserId(1);
//		user1.setPassword("user1@123");
//		user1.setName("user1");
//		user1.setPnrNo(11);
//		user2.setUserId(2);
//		user2.setPassword("user2@123");
//		user2.setName("user2");
//		user2.setPnrNo(12);
//		user3.setUserId(3);
//		user3.setPassword("user3@123");
//		user3.setName("user3");
//		user3.setPnrNo(13);
//		user4.setUserId(4);
//		user4.setPassword("user4@123");
//		user4.setName("user4");
//		user4.setPnrNo(14);
//		user5.setUserId(5);
//		user5.setPassword("user5@123");
//		user5.setName("user5");
//		user5.setPnrNo(15);
//		Map<Integer,UserInfo> temp=new HashMap<>();
//		temp.put(1, user1);
//		temp.put(2, user2);
//		temp.put(3, user3);
//		temp.put(4, user4);
//		temp.put(5, user5);
		
		Map<String,List<String>> map=new HashMap<>();
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		List<String> list3=new ArrayList<>();
		
		list1.add("LOW1");
		list1.add("LOW2");
		list1.add("LOW3");
		list1.add("LOW4");
		list1.add("LOW5");
		
		list2.add("UPP1");
		list2.add("UPP2");
		list2.add("UPP3");
		list2.add("UPP4");
		list2.add("UPP5");
		
		list3.add("MID1");
		list3.add("MID2");
		list3.add("MID3");
		list3.add("MID4");
		list3.add("MID5");
		
		map.put("middle", list3);
		map.put("lower", list1);
		map.put("upper", list2);

		Map<String,Map<Integer,List<ReservationInfo>>> map22=new HashMap<>();
		Map<Integer,List<ReservationInfo>> map2=new HashMap<>();
		List<ReservationInfo> list=new ArrayList<>();
		
		ReservationInfo r1=new ReservationInfo();
		r1.setBookedDate(null);
		r1.setClassType("firstClass");
		r1.setDestination("kkdi");
		r1.setFromPlace("chni");
		r1.setPassangerName("sv");
		r1.setPNRNumber(12);
		r1.setSeatAllot("LOW1");
		r1.setStatus("conformed");
		r1.setTrainName("pandian");
		r1.setTrainNumber(12);
		list.add(r1);
		map2.put(12, list);
		map22.put("firstClass", map2);
		Queue<ReservationInfo> waiting=new PriorityQueue<>();
		
		try {
			FileOutputStream file=new FileOutputStream(new File("C:\\\\Users\\\\SIVA\\\\siva\\\\Level3\\\\src\\\\storage\\\\reservation.ser"));
			ObjectOutputStream obj=new ObjectOutputStream(file);
			obj.writeObject(map);
			obj.writeObject(map22);
			obj.writeObject(waiting);
			obj.close();
			file.close();
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hsdfgh");
	}
}
