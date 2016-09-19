package com.adanac.tool.supertool.java2e.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.adanac.tool.supertool.entity.Employee;

public class SerializationDemo {

	public static void serializObj(Object e) {
		try {
			String filename = "employee.ser";
			String proUrl = System.getProperty("user.dir");
			FileOutputStream fileOut = new FileOutputStream(proUrl + "/" + filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + proUrl + "/" + filename);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void deserializObj(Object e) {
		try {
			String filename = "employee.ser";
			String proUrl = System.getProperty("user.dir");
			FileInputStream fileIn = new FileInputStream(proUrl + "/" + filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee) in.readObject();
			System.out.println(e.toString());
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) {
		// Employee e = new Employee();
		// e.name = "Reyan Ali";
		// e.address = "Phokka Kuan, Ambehta Peer";
		// e.SSN = 11122333;
		// e.number = 101;
		//
		// serializObj(e);
		Employee e = null;
		deserializObj(e);

	}
}
