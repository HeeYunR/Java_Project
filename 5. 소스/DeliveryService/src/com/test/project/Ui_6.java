package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Ui_6 {

	final static String USER = "C:\\class\\code\\java\\DeliveryService\\dat\\회원정보.txt";
	final static String OWNER = "C:\\class\\code\\java\\DeliveryService\\dat\\점주정보.txt";
	
	public static void findIdPw() {
		Scanner scan = new Scanner(System.in);
	
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t1.아이디 찾기   2.비밀번호 찾기   0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
	
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			findIdKind();
		} else if(input.equals("2")) {
			findPwKind();
		} else if(input.equals("0")) {
			Ui.mainUi();
		} 
	}
	
	public static void findIdKind() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t1.회원 아이디 찾기   2.점주 아이디 찾기   0.이전페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
	
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			findIdUi();
		} else if(input.equals("2")) {
			findIdOwner();
		} else if(input.equals("0")) {
			findIdPw();
		} 
	
	}
	
	public static void findPwKind() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t1.회원 비밀번호 찾기   2.점주 비밀번호 찾기   0.이전페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
	
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			findPwUi();
		} else if(input.equals("2")) {
			findPwOwnerUi();
		} else if(input.equals("0")) {
			findIdPw();
		} 
	}
	
	public static void findIdOwner() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t점주 아이디 찾기 ");
		System.out.println();
		System.out.print("\t\t1.이름 : ");
		String inputName = scan.nextLine();
		System.out.println();
		System.out.print("\t\t2.전화번호 :  ");
		String inputPhoneNum = scan.nextLine();
		System.out.println();
		System.out.print("\t\t3.사업자등록번호 :  ");
		String inputBusiness = scan.nextLine();
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		
		
		String IdOwner = searchIdOwner(inputName,inputPhoneNum,inputBusiness);
			
		if(IdOwner != null) {
			findIdOwnerTrueUi(IdOwner);
		}else {
			findIdFalseUi();
		}
		
	}
	
	private static String searchIdOwner(String inputName, String inputPhoneNum, String inputBusiness) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(OWNER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split("■");
				
				if(temp[5].equals(inputName) && temp[6].equals(inputBusiness)) {
					return temp[0];
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		return null;
	}
	
	public static void findIdOwnerTrueUi(String IdOwner) {
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t아이디 찾기 완료");
		System.out.println();
		System.out.println("\t\t등록된 아이디 : " + IdOwner);
		System.out.println();
		System.out.println("\t\t  0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();	
		} 
	}
	
	
	public static void findIdUi() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t아이디 찾기 ");
		System.out.println();
		System.out.print("\t\t1.이름 : ");
		String inputName = scan.nextLine();
		System.out.println();
		System.out.print("\t\t2.전화번호 :  ");
		String inputPhoneNum = scan.nextLine();
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
	

		String Id = searchId(inputName,inputPhoneNum);
		if(Id != null) {
			findIdTrueUi(Id);
		}else {
			findIdFalseUi();
		}

	}
	
	private static String searchId(String inputName, String inputPhoneNum) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));
			
			String line = null;
			
			while((line = reader.readLine())  != null) {
			
				String[] temp = line.split("■");
				
				if(temp[5].equals(inputName) && temp[3].equals(inputPhoneNum)) {
					return temp[0];
				}
		
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	public static void findIdFalseUi() {
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t아이디 찾기 실패");
		System.out.println();
		System.out.println("\t\t 0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();
		} 
	}
	
	public static void findIdTrueUi(String Id) {
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t아이디 찾기 완료");
		System.out.println();
		System.out.println("\t\t등록된 아이디 : " + Id);
		System.out.println();
		System.out.println("\t\t  0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();
		} 
	}
	
	public static void findPwUi() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t\t비밀번호 찾기 ");
		System.out.println();
		System.out.print("\t\t1. 아이디 : ");
		String inputId = scan.nextLine();
		System.out.println();
		System.out.println("\t====================================================================");
		
		
		String pw = searchPw(inputId);
		if(inputId != null) {
			findPwTrueUi(pw);
		}
		findPwFalseUi();
	}
	
	private static String searchPw(String inputId) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));
		
			String line = null;
			while((line = reader.readLine()) != null) {
					
				String temp[] = line.split("■");
				if(temp[0].equals(inputId)) {
					return temp[1];
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void findPwFalseUi() {
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t비밀번호 찾기 실패");
		System.out.println();
		System.out.println("\t\t0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();
		
		} 
	}
	
	public static void findPwTrueUi(String pw) {
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t비밀번호 찾기 완료");
		System.out.println();
		System.out.println("\t\t등록된 비밀번호 : " + pw);
		System.out.println();
		System.out.println("\t\t0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();;
		}
	}
	
	public static void findPwOwnerUi() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t\t비밀번호 찾기 ");
		System.out.println();
		System.out.print("\t\t1. 아이디 : ");
		String inputId = scan.nextLine();
		System.out.println();
		System.out.println("\t====================================================================");
		
		
		String pwOwner = searchPwOwner(inputId);

		if(pwOwner != null) {
			findPwOwnerTrueUi(pwOwner);
		} else {
			findPwFalseUi();
			
		}
		
	}
	
	private static String searchPwOwner(String inputId) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(OWNER));
		
			String line = null;
			while((line = reader.readLine()) != null) {
					
				String temp[] = line.split("■");
					
					
				if(temp[0].equals(inputId)) {
					return temp[1];
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void findPwOwnerTrueUi(String pwOwner) {
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t비밀번호 찾기 완료");
		System.out.println();
		System.out.println("\t\t등록된 비밀번호 : " + pwOwner);
		System.out.println();
		System.out.println("\t\t0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.equals("0")) {
			Ui.mainUi();;
		}
	}
}
