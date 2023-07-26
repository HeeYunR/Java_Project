package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 사용자가 음식을 담고 그 정보들을 처리하는 클래스이다.
 * @author 이재성
 *
 */
public class ShoppingBag {
	
	private final static String RESTAURANT = ".\\dat\\점포.txt";	

	/**
	 * 사용자가 음식을 다 담고 결제를 하려고하면 출력하는 Ui이다.
	 * 최소주문금액보다 담은 음식들의 총 합이 낮으면 더 담아야 하며
	 * 최소주문금액보다 높으면 결제가 진행된다.
	 * @param companyNumber
	 */
	public static void shoppingUi(String companyNumber) {
		
		Scanner scan = new Scanner(System.in);
		int deliveryPrice = 0;
		int index = 1;
		int totalPrice = 0;
		
		Restaurant r = new Restaurant();
		deliveryPrice = r.getDeliveryPrice(companyNumber);
		
		System.out.println("=============================================");
		System.out.println("\t\t고객님의 주문정보");
		System.out.println("---------------------------------------------");
		
		HashMap<String,Menu> list = MenuList.getChoice();
		
		for (Menu m : list.values()) {
			System.out.printf("%d. %-15s\t\t%,7d원\n", index, m.getName(), m.getPrice());
			System.out.printf("%-3s: %-15s\t\t%,7d원\n", "옵션", m.getChoiceOption().get(0).getOptionName(), m.getChoiceOption().get(0).getOptionPrice());
			System.out.println();
			totalPrice = totalPrice + m.getPrice() + m.getChoiceOption().get(0).getOptionPrice();
			index++;
		}
		
		System.out.printf("배달비 :%-15s \t\t%,7d원\n", "", deliveryPrice);
		System.out.println("----------------------------------------------");
		totalPrice += deliveryPrice;
		System.out.printf("총 결제 금액 : \t\t\t%,7d원\n", totalPrice);
		System.out.printf("최소주문금액 : \t\t\t%,7d원\n", r.getMinprice(companyNumber));
		System.out.println("=============================================");
		
		System.out.print("주문 하시겠습니까? (y/n):");
		String input = scan.nextLine();
		
		if (input.equals("y")) {
			if (totalPrice >= r.getMinprice(companyNumber)) {
				Request.requestUi(companyNumber);
			} else {
				System.out.println();
				System.out.println("주문한 상품이 최소주문금액보다 낮습니다.");
				MenuList.printMenu(companyNumber);
			}
			
		} else {
			MenuList.printMenu(companyNumber);
		}
		
	}
}
