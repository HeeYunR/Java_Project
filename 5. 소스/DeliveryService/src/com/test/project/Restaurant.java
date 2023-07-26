package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 
 * @author PC
 * 음식점의 정보가 담긴 클래스이다.
 */
public class Restaurant {

	private String companyNumber;
	private String restaurantName;
	private String category;
	private String rating;
	private String maxDeliveryTime;
	private String deliveryPrice;
	private String minprice;
	private final static String RESTAURANT = ".\\dat\\점포.txt";	
	
	public Restaurant() {
		
	}
	
	public Restaurant(String companyNumber, String restaurantName, String category, String rating, String maxDeliveryTime, String deliveryPrice, String minprice) {
		this.companyNumber = companyNumber;
		this.restaurantName = restaurantName;
		this.category = category;
		this.rating = rating;
		this.maxDeliveryTime = maxDeliveryTime;
		this.deliveryPrice = deliveryPrice;
		this.minprice = minprice;
	}

	public String getCompanyNumber( ) {
		return companyNumber;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}

	public String getRating() {
		return rating;
	}

	public String getMaxDeliveryTime() {
		return maxDeliveryTime;
	}

	public String getDeliveryPrice() {
		return deliveryPrice;
	}
	
	public String getMinprice() {
		return minprice;
	}
	
	/**
	 * 
	 * @param companyNumber
	 * @return 최소주문금액
	 * 사업자번호를 기준으로 최소주문 금액을 반환한다.
	 */
	public int getMinprice(String companyNumber) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(RESTAURANT));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				if (temp[0].equals(companyNumber)) {
					minprice = temp[9];
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(minprice);
	}
	
	/**
	 * 
	 * @param companyNumber
	 * @return 배달비
	 * 사업자번호를 기준으로 배달비를 반환한다.
	 */
	public int getDeliveryPrice(String companyNumber) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(RESTAURANT));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				if (temp[0].equals(companyNumber)) {
					deliveryPrice = temp[8];
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(deliveryPrice);
	}
	
	/**
	 * 
	 * @param companyNumber
	 * @return 배달시간
	 * 사업자번호를 기준으로 배달시간을 반환한다.
	 */
	public String getDeliveryTime(String companyNumber) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(RESTAURANT));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				if (temp[0].equals(companyNumber)) {
					maxDeliveryTime = temp[7];
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maxDeliveryTime;
	}
	
	/**
	 * 
	 * @param companyNumber
	 * @return 음식점이름
	 * 사업자번호를 기준으로 음식점 이름을 반환한다.
	 */
	public String getRestaurantName(String companyNumber) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(RESTAURANT));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				if (temp[0].equals(companyNumber)) {
					restaurantName = temp[2];
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restaurantName;
	}
	
}
