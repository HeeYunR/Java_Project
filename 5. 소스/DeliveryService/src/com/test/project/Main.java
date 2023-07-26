package com.test.project;

import java.util.Scanner;

import com.test.admin.Ui_1;
import com.test.notmem.NotmemJoin;
import com.test.user.UserSearch;

public class Main {

	private static boolean member = true; 
	private static boolean flag = true;
	
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		String input;
		
		extracted(scan);
		scan.close();
		
	} //main
	
	/**
	 * 3-> 5-> 4-> 순서대로 입력하면 결제까지 테스트 가능
	 * @param scan
	 */
	private static void extracted(Scanner scan) {
		String input;
		while (flag) {
			
			Ui.mainUi();
			input = scan.nextLine();
			
			if (input.equals("1")) {
				Ui_1.loginAdmin();
			} else if(input.equals("2")) {
				member = false;
				NotmemJoin.unmemUI();
			} else if(input.equals("3")) {
				member = true;
				UserLogIn.userLogin();
			} else if(input.equals("4")) {
				Login.storekeeperLogin();
			} else if(input.equals("5")) {
				Ui.registUi();
			} else if(input.equals("6")) {
				Ui_6.findIdPw();
			} else if(input.equals("7")) {
				flag = false;
				System.out.println();
				System.out.println("프로그램이 종료되었습니다.");
			} else {
				System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		
		}
	}
	
	public boolean getMember() {
		return member;
	}
} 
