package com.test.project;

import java.util.Scanner;

/**
 * 
 * @author PC
 * 사용자가 사장님께 보내는 요청사항을 작성하는 곳이다.
 */
public class Request {

	private static boolean disposable = false;
	private static String requestMent;
	private static boolean faceToFace = true;
	
	/**
	 * 
	 * @param companyNumber
	 * 1회 용품 사용 여부, 요청사항, 대면-비대면 옵션을 설정한다.
	 */
	public static void requestUi(String companyNumber) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("=============================================");
		System.out.println("\t\t   요청사항");
		System.out.println("---------------------------------------------");
		
		System.out.print("1회 용품 수저가 필요하신가요?(y/n): ");
		String input = scan.nextLine();
		if (input.equals("y")) {
			disposable = true;
		}
		
		System.out.println("사장님께 부탁하실 요청사항을 적어주세요: ");
		requestMent = scan.nextLine();
		
		System.out.print("비대면으로 받으시겠습니까?(y/n): ");
		input = scan.nextLine();
		if (input.equals("n")) {
			faceToFace = false;
		}
		System.out.println("=============================================");
		
		Ui.pause();
		
		Main m = new Main();
		if (m.getMember() == false) {
			Payment.nonPaymentUi(companyNumber);
		} else {
			Payment.discount(companyNumber);
		}
	}

	public static boolean isDisposable() {
		return disposable;
	}

	public static String getRequestMent() {
		return requestMent;
	}

	public static boolean isFaceToFace() {
		return faceToFace;
	}	
	
}


