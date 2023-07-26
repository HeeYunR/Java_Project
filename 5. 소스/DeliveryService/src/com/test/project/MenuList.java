package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import com.test.project.*;

/**
 * 
 * @author PC
 *	음식점의 메뉴가 보이는 페이지이다.
 */
public class MenuList {

	private final static String MENU = ".\\dat\\메뉴.txt";
	private final static String NOTICE = ".\\dat\\공지사항.txt";

	private static ArrayList<String> names;
	private static HashMap<String,Menu> menu;
	private static HashMap<String,Menu> choice;
	private static String currentCompanyNumber;
	private static String notice;
	
	
	/**
	 * 사업자 번호로 해당하는 메뉴를 가져오고 그 메뉴를 출력한다.
	 * @param companyNumber
	 */
	public static void menuList(String companyNumber) {

		menu = new HashMap<String, Menu>();
		choice = new HashMap<String, Menu>();
		names = new ArrayList<String>();
		currentCompanyNumber = companyNumber;
		
		numToNotice(currentCompanyNumber);
		numToMenu(companyNumber); 	//사업자번호로 메뉴를 가져온다.
		printMenu(currentCompanyNumber);

	}
	
	/**
	 * 
	 * @param num
	 * 주문하려는 음식의 번호를 입력하면 해당하는 음식의 옵션을 출력한다.
	 */
	public static void selectOption(int num) {
		
		Scanner scan = new Scanner(System.in);
		
		int oIndex = 1;
		int dupliIndex = 2;
		String menuName = names.get(num-1);
		
		System.out.println("=============================================");
		System.out.printf("%s 옵션 선택\n", menuName);
		System.out.println("---------------------------------------------");
		
		
		ArrayList<MenuOption> list = menu.get(menuName).getOptionList();
		
		for (MenuOption m : list) {
			System.out.printf("%d. %-15s\t\t%,7d원\n", oIndex, m.getOptionName(), m.getOptionPrice());
			oIndex++;
		}
		
		System.out.println("=============================================");
		System.out.println();
		
		System.out.print("번호 입력: ");
		String input = scan.nextLine();
		int num2 = Integer.parseInt(input);
		
		if (num2 > 0 && num2 <= oIndex-1) {
			
			MenuOption mo = menu.get(menuName).getOptionList().get(num2-1);
			menu.get(menuName).setChoice(mo);
			
			if (choice.containsKey(menuName)) {	
				choice.put(menuName+dupliIndex, menu.get(menuName));
				dupliIndex++;
			} else {
				choice.put(menuName, menu.get(menuName));
			}
			
			System.out.println("장바구니에 추가되었습니다.");
			System.out.println();
			printMenu(currentCompanyNumber);
		}  else {
			System.out.println("잘못된 번호를 입력하셨습니다.");
			System.out.println();
			printMenu(currentCompanyNumber);
		}
		
		
	}	
	

	/**
	 * 
	 * @param companyNumber
	 * 음식점의 메뉴를 출력해준다.
	 */
	public static void printMenu(String companyNumber) {
		
		Scanner scan = new Scanner(System.in);
		
		numToNotice(companyNumber); //사업자 번호로 공지사항을 가져온다.
		Restaurant r = new Restaurant();
		
		System.out.println("=============================================");
		System.out.printf("%s\n",r.getRestaurantName(companyNumber));
		System.out.printf("공지사항: %s\n", notice);
		System.out.println("---------------------------------------------");
		
		int cIndex = 1;
		for (int i=0; i<names.size(); i++) {
			for (String k : menu.keySet()) {
				if (k.equals(names.get(i))) {
					Menu value = menu.get(k);
					System.out.printf("%d. %-15s\t\t%,7d원 %s\n", cIndex, value.getName(), value.getPrice(), value.getSoldOut().equals("true") ? "품절" : "");
					cIndex++;
				}
			}
		}
		
		System.out.println("=============================================");
		System.out.println();
		
		int num = 0;
		System.out.print("번호 입력(결제 y): ");
		String input = scan.nextLine();
		
		
		if (input.equals("y")) {
			ShoppingBag.shoppingUi(companyNumber);
		} else {
			num = Integer.parseInt(input);
		}		
		
		System.out.println();
				
		if (num > 0 && num <= names.size() && !isSoldOut(num)) {
			System.out.println();
			selectOption(num);
		} else if (num == 0) {
			Ui.categoryUi();
		} else if (isSoldOut(num)){
			if (num > names.size() || num < 0) {
				System.out.println("잘못된 번호를 입력하셨습니다.");
				System.out.println();
				printMenu(companyNumber);
			} else {
			System.out.println("품절된 음식은 주문할 수 없습니다.");
			printMenu(companyNumber);
			}
		} 
		
	
	}
	
	/**
	 * 
	 * @param num
	 * @return 품절이면 true를 수량이 있으며 false를 반환한다.
	 * 음식의 품절여부를 반환해준다.
	 */
	private static boolean isSoldOut(int num) {
		if (num > names.size() || num < 0 || menu.get(names.get(num-1)).getSoldOut().equals("true")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	

	/**
	 * 
	 * @param companyNumber
	 * 사업자번호로 공지사항을 설정한다.
	 */
	private static void numToNotice(String companyNumber) {
		
		try {
			
			notice = "";
			
			BufferedReader reader = new BufferedReader(new FileReader(NOTICE));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				//해당 음식점의 사업자번호를 찾아서 공지사항을 가져온다.
				if(temp[0].equals(companyNumber)) {
					notice = temp[1];
				}
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @param companyNumber
	 * 사업자 번호로 해당 음식적의 메뉴를 설정한다.
	 */
	private static void numToMenu(String companyNumber) {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(MENU));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				//해당 음식점의 사업자번호를 찾아서 메뉴를 가져온다.
				if(temp[0].equals(companyNumber)) {
					 Menu m = new Menu(temp[1], temp[2], Integer.parseInt(temp[3]), temp[temp.length-1]);
					 for (int i=4; i<temp.length-1; i+=2) {
							MenuOption mo = new MenuOption(temp[i], Integer.parseInt(temp[i+1]));
							m.setOptionList(mo);
						}
					 if (!isDuplicate(temp[2])) {
						 menu.put(temp[2], m);
						 names.add(temp[2]);
					 }
				}
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * 메뉴이름의 중복을 검사한다.
	 */
	private static boolean isDuplicate(String name) {
		
		for (int i=0; i<names.size(); i++) {
			if (names.get(i).equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 * 고객이 고른 상품들을 반환해준다.
	 */
	public static HashMap<String, Menu> getChoice() {
		return choice;
	}
}
