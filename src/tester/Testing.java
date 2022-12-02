package tester;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import pojo.UserInfo;

public class Testing {
	public static void main(String[] args) {
		UserInfo user1=new UserInfo();
		UserInfo user2=new UserInfo();
		UserInfo user3=new UserInfo();
		UserInfo user4=new UserInfo();
		UserInfo user5=new UserInfo();
		user1.setUserId(1);
		user1.setPassword("user1@123");
		user1.setName("user1");
		user2.setUserId(2);
		user2.setPassword("user2@123");
		user2.setName("user2");
		user3.setUserId(3);
		user3.setPassword("user3@123");
		user3.setName("user3");
		user4.setUserId(4);
		user4.setPassword("user4@123");
		user4.setName("user4");
		user5.setUserId(5);
		user5.setPassword("user5@123");
		user5.setName("user5");
		Map<Integer,UserInfo> temp=new HashMap<>();
		temp.put(1, user1);
		temp.put(2, user2);
		temp.put(3, user3);
		temp.put(4, user4);
		temp.put(5, user5);
		try {
			FileOutputStream file=new FileOutputStream(new File("loginDetails.ser"));
			ObjectOutputStream obj=new ObjectOutputStream(file);
			obj.writeObject(temp);
			file.close();
			obj.close();
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hsdfgh");
	}
}
