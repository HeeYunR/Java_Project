package com.test.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.test.project.Ui;

public class Ui_1 {
//관리자 로그인
	final static String ADMIN = "C:\\class\\code\\java\\DeliveryService\\dat\\admin.txt";
	
	
	/**
	 * Scanner 객체를 이용하여 아이디,비밀번호를 String 값으로 입력받음
	 * 
	 */
	public static void loginAdmin() {
	Scanner scan = new Scanner(System.in);
	
	System.out.println();
	System.out.println("\t============================================");
	System.out.println();
	System.out.println("\t\t▽관리자 로그인");
	System.out.println();
	System.out.print("\t\t아이디 : ");
	String inputId = scan.nextLine();
	System.out.println();
	System.out.print("\t\t비밀번호 : ");
	String inputPw = scan.nextLine();
	System.out.println();
	System.out.println("\t============================================");
	System.out.println();
	
	String search = searchAdmin(inputId, inputPw); 
	
	if(search != null) {
		adminMain();
	}else {
		loginAdminFail();
	}
	
}
	
	/**
	 * 
	 * 매개변수 값이 String인 아이디,비밀번호를 인자값으로 전달받아  
	 * 
	 * @param inputId
	 * @param inputPw
	 * @return
	 */
	public static String searchAdmin(String inputId, String inputPw) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ADMIN));
			String line = null;
			String s = "성공";
			while((line = reader.readLine())  != null) {
				String[] temp = line.split("■");
				if(temp[1].equals(inputId) && temp[2].equals(inputPw)) {
					return s;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void loginAdminFail() {
		System.out.println();
		System.out.println("\t============================================");
		System.out.println();
		System.out.println("\t\t로그인 실패");
		System.out.println();
		System.out.println("\t\t0. 메인페이지");
		System.out.println();
		System.out.println("\t============================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();
		
		} 
	}
	public static void adminMain() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽관리자 메인메뉴");
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.점포관리   2.회원관리   3.이벤트관리   0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			AdminStoreManage.storeManage();
		} else if(input.equals("2")) {
			AdminMemberManage.memberManage();
		} else if(input.equals("3")) {
			AdminEvent.eventmain();
		} else if(input.equals("0")) {
			Ui.mainUi();
		}
		
	}
}//