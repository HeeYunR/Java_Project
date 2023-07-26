package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantList {
	
	private final static String RESTAURANT = ".\\dat\\점포.txt";	
	private static List<Restaurant> list;
	
	/**
	 * 
	 * @param category
	 * 번호를 입력하면 해당하는 카테고리의 음식적들을 출력하는 메소드
	 */
	public static void printRestaurant(String category) {
		
		list = new ArrayList<Restaurant>();
		
		try {
			
			Scanner scan = new Scanner(System.in);
			BufferedReader reader = new BufferedReader(new FileReader(RESTAURANT));
			
			int page = 1;
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				if (temp[4].equals(category)) {
					Restaurant r = new Restaurant(temp[0], temp[2], temp[4], temp[5], temp[7], temp[8], temp[9]);
					list.add(r);
				}
			}
			
						
			System.out.println("========================================================================");
			System.out.println("번호\t상호명\t\t\t평점\t최소주문금액\t배달비\t배달예상시간");
			System.out.println("------------------------------------------------------------------------");
			printRestaurantList(1);
			System.out.println("========================================================================");
			
			System.out.println();
			System.out.println("\t\t   ==========================");
			System.out.println("\t\t   0. 카테고리화면");		
			System.out.println("\t\t   ==========================");
			System.out.println();
			System.out.print("\t\t   번호 입력: ");
			
			String input = scan.nextLine();
			
			if (input.equals("0")) {
				Ui.categoryUi();
			} 	
			
			enterRestaurant(input);
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param page
	 * 
	 */
	private static void printRestaurantList(int page) {
		
		int max = 15;
		
		if (list.size() < 15) {
			max = list.size();
		}
		
		for (int i=0; i<max; i++) {
			Restaurant item = list.get(i);
			System.out.printf("%2d\t%-20s\t%3s\t%,5d\t\t%,5d\t%3s\n", i+1, item.getRestaurantName(), item.getRating(), Integer.parseInt(item.getMinprice())
					, Integer.parseInt(item.getDeliveryPrice()), item.getMaxDeliveryTime());
		}
		
	}
	
	/**
	 * 
	 * @param num
	 * 음식점의 번호를 입력하면 그 음식적으로 들어가게 해준다.
	 */
	private static void enterRestaurant(String num) {
		
		String companyNumber = list.get(Integer.parseInt(num) - 1).getCompanyNumber();
		MenuList.menuList(companyNumber);
	}
	
}
