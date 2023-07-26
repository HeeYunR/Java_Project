package com.test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class dummy {
	final static String TXT = "C:\\class\\code\\java\\DeliveryService\\dat\\회원정보.txt";
	public static void main(String[] args) {
		
		try {
			String result = "";
			
			BufferedReader reader = new BufferedReader(new FileReader(TXT));
			
			String line = null;
			while((line = reader.readLine()) !=null) {
				
				line = line.replace(",", "■");
				result += line+"\n";
				
				
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(TXT));
			
			writer.write(result);
			writer.flush();
			writer.close();
			

		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}
