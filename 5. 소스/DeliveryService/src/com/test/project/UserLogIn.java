package com.test.project;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.util.Scanner;

public class UserLogIn {
	final public static String USER = "C:\\class\\code\\java\\DeliveryService\\dat\\normalmem.txt";
	public static String id;
	public static String pw;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		UserLogIn.id = id;
	}

	public static String getPw() {
		return pw;
	}

	public static void setPw(String pw) {
		UserLogIn.pw = pw;
	}

	// 김완진 userlogin
	public static void UserLoginAccess() {
		
		// 로그인 성공했을경우 회원정보 선택창으로 넘어감
		if (LoginCheckMem(getId(), getPw())) {
			String chkUId = getId();
			System.out.println("\t============================================");
			System.out.println("\t\t로그인 성공!, 3초후 회원 선택 화면으로 넘어갑니다...");
			System.out.println("\t============================================");
			try {
				Thread.sleep(3000);
				Ui.memberSelectUi(chkUId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	// 김완진 userlogincheck
	public static boolean LoginCheckMem(String id, String pw) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));
			boolean flag = false;
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] check = line.split("■");
				if (id.equals(check[0]) && pw.equals(check[1])) {
					flag = true;
					return flag;
				}
			}
			if (flag == false) {
				System.out.println("\t\t로그인 실패, 다시 시도하세요");
				userLogin();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void userLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t============================================");
		System.out.print("\n\t\t아이디 : ");
		// 정규식을 이용한 공백문자 제거
		id = sc.nextLine().replaceAll("\\p{Z}", "");
		if (id.equals("")) {
			System.out.println("\t\t아이디는 필수입력 입니다, 다시 입력해주세요.");
			userLogin();
		}
		setId(id);
		System.out.print("\t\t비밀번호 : ");
		// 정규식을 이용한 공백문자 제거
		pw = sc.nextLine();
		if (pw.equals("")) {
			System.out.println("\t\t비밀번호는 필수입력 입니다, 다시 입력해주세요.");
			userLogin();
		}
		setPw(pw);
		LoginCheckMem(UserLogIn.getId(), UserLogIn.getPw());
		UserLoginAccess();
	}

}
