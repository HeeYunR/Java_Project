package com.test.project;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author PC
 * 회원, 비회원이 결제를 하는 페이지이다.
 */
public class Payment {

	private static int coupon;
	private static int point;
	private static String id;
	/**
	 * 
	 * @param companyNumber
	 * 비회원이 결제를 할 때 나타나는 페이지이다.
	 */
	public static void nonPaymentUi(String companyNumber) {

		Scanner scan = new Scanner(System.in);
		
		int index = 1;
		int totalPrice = 0;
		
		Restaurant r = new Restaurant();
		
		System.out.println();
		System.out.println("=============================================");
		System.out.println("\t\t   결제화면");
		System.out.println("---------------------------------------------");
		
		HashMap<String,Menu> list = MenuList.getChoice();
		
		for (Menu m : list.values()) {
			System.out.printf("%d. %-15s\t\t%,7d원\n", index, m.getName(), m.getPrice());
			System.out.printf("%-3s: %-15s\t\t%,7d원\n", "옵션", m.getChoiceOption().get(0).getOptionName(), m.getChoiceOption().get(0).getOptionPrice());
			System.out.println();
			totalPrice = totalPrice + m.getPrice() + m.getChoiceOption().get(0).getOptionPrice();
			index++;
		}
		
		
		System.out.printf("배달비 :%-15s \t\t%,7d원\n", "", r.getDeliveryPrice(companyNumber));
		System.out.println("----------------------------------------------");
		System.out.printf("주문금액 :%,7d원 + %,6d원(배달비)\n", totalPrice, r.getDeliveryPrice(companyNumber));
		System.out.printf("배달 예상 시간 : %s분\n", r.getDeliveryTime(companyNumber));
		System.out.println("=============================================");
			
		System.out.println("결제가 완료되었습니다.");
		Ui.pause();
		
	}
	
	/**
	 * 
	 * @param companyNumber
	 * 회원이 결제를 할 때 나타나는 페이지이다.
	 */
	public static void paymentUi(String companyNumber) {
		
		Scanner scan = new Scanner(System.in);
		
		int index = 1;
		int totalPrice = 0;
		
		Restaurant r = new Restaurant();
		
		System.out.println();
		System.out.println("=============================================");
		System.out.println("\t\t결제가 완료되었습니다.");
		System.out.println("---------------------------------------------");
		
		HashMap<String,Menu> list = MenuList.getChoice();
		
		for (Menu m : list.values()) {
			System.out.printf("%d. %-15s\t\t%,7d원\n", index, m.getName(), m.getPrice());
			System.out.printf("%-3s: %-15s\t\t%,7d원\n", "옵션", m.getChoiceOption().get(0).getOptionName(), m.getChoiceOption().get(0).getOptionPrice());
			System.out.println();
			totalPrice = totalPrice + m.getPrice() + m.getChoiceOption().get(0).getOptionPrice();
			index++;
		}
		
		
		
		System.out.printf("배달비 :%-15s \t\t%,7d원\n", "", r.getDeliveryPrice(companyNumber));
		System.out.println("----------------------------------------------");
		System.out.printf("주문금액	: %,-7d원 + %,6d원(배달비)\n", totalPrice, r.getDeliveryPrice(companyNumber));
		System.out.printf("할인된 금액	: %,-7d원(할인쿠폰) + %4d원(포인트)\n", Payment.coupon, Payment.point);
		
		totalPrice += r.getDeliveryPrice(companyNumber);
		
		System.out.printf("총 결제된 금액: %,6d원\n", totalPrice - Payment.coupon - Payment.point);
		System.out.printf("배달 예상 시간 : %s분\n", r.getDeliveryTime(companyNumber));
		System.out.println("=============================================");
		

		Ui.pause();
		
		Main.main(null);
	}
	
	/**
	 * 
	 * @param companyNumber
	 * 주문하는 사람이 회원인 경우 할인쿠폰이나 포인트를 사용할지 물어보는 페이지이다.
	 */
	public static void discount(String companyNumber) {
		
		Scanner scan = new Scanner(System.in);
		
		int index = 1;
		int totalPrice = 0;
		
		Restaurant r = new Restaurant();
		
		System.out.println();
		System.out.println("=============================================");
		System.out.println("\t\t   할인혜택");
		System.out.println("---------------------------------------------");
		
		
		MemberInfo mi = new MemberInfo();
		Ui u = new Ui();
		id = Ui.getChkUId();
		int point = Integer.parseInt(mi.getPoint(id));
		Coupon c = new Coupon();
		String[] list = c.getCoupon(id);
		
		System.out.println("1. 할인쿠폰");
		
		int i = 1;
		for (String s : list) {
			if (s != null) {
				System.out.printf("%d. %d원\t", i, Integer.parseInt(s));
				i++;
			}
		}
		
		System.out.println();
		System.out.print("2. 보유포인트: ");
		System.out.printf("%s\n", point);
		
		
		System.out.println("=============================================");
		
		System.out.print("1. 사용할 할인 쿠폰의 번호를 입력하세요: ");
		String input = scan.nextLine();
		
		
		setCoupon(Integer.parseInt(list[Integer.parseInt(input)-1]));
		
		System.out.print("2. 사용할 포인트를 입력하세요: ");
		input = scan.nextLine();
		setPoint(input);
		
		Ui.pause();
		
		paymentUi(companyNumber);
	}

	public static int getCoupon() {
		return coupon;
	}

	public static int getPoint() {
		return point;
	}

	public static void setCoupon(int num) {
		Payment.coupon = num;
	}

	public static void setPoint(String point) {
		Payment.point = Integer.parseInt(point);
	}
	
}
