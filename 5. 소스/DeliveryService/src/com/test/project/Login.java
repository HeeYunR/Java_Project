package com.test.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;

import com.test.storekeeper.StorekeeperScreen;

public class Login {
	
	final public static String USER = "C:\\class\\code\\java\\DeliveryService\\dat\\점주정보.txt"; 
	public static String id;
	public static String pw;
	public static String[] storekeeper;
	
		
	public static String[] getStorekeeper() {
		return storekeeper;
	}

	public static String storekeepertoString() {
	
		return String.format("\t\t아이디: %s\n\t\t전화번호: %s\n\t\t성별: %s\n\t\t이름: %s\n\t\t사업자등록번호: %s",storekeeper[0],storekeeper[3],storekeeper[4],storekeeper[5],storekeeper[6] );
	}


	public static void setStorekeeper(String[] storekeeper) {
		Login.storekeeper = storekeeper;
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Login.id = id;
	}

	public static String getPw() {
		return pw;
	}

	public static void setPw(String pw) {
		Login.pw = pw;
	}


	public static void adminLogin(){
		
		 mainLogin();
		 
		}
		
		
//	public static void storekeeperLogin() {
//			
//		mainLogin();
//		LoginCheck(getId(),getPw(), store);
//		
//		
//			
//		}
	
	
	public static StorekeeperScreen storekeeperLogin() {
			
		mainLogin();
		if(LoginCheck(getId(),getPw(), USER)) {
			System.out.println("\t\t\t로그인 성공");
			System.out.print("\t============================================\n");
			return StorekeeperScreen.storekeeperScreen();
		}else{
			return storekeeperLogin();
		}
			
		}
	
	
	public static boolean LoginCheck(String id , String pw, String txt) {
		
		boolean a = false;
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(txt));
			String line = null;
			while ((line = reader.readLine()) != null) {
				
				setStorekeeper(line.split("■")); 
				
				if(id.equals(getStorekeeper()[0])&&pw.equals(getStorekeeper()[1])) {
					a = true;
					return a;
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	
	
	public static void userLogin() {
		
		
		if(LoginCheck(getId(),getPw(), USER)) {
			System.out.println("미완성");
		}
			
		}


	public static void mainLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\t============================================\n");
		
		System.out.print("\t\t아이디 : ");
		id = sc.nextLine();
		setId(id);
		System.out.print("\t\t비밀번호: ");
		pw = sc.nextLine();
		setPw(pw);
		
		System.out.print("\t============================================\n");
	
	}

}