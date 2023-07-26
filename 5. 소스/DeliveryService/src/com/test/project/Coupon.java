package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 회원이 보유하고 있는 쿠폰의 정보를 처리한다.
 * @author 이재성
 *
 */
public class Coupon {

	private static int couponPrice;
	
	public final static String EVENTCOUPON = "C:\\class\\code\\java\\DeliveryService\\dat\\EventCoupon.txt";
	
	/**
	 * 회원 아이디를 인자로 받아 회원이 보유하고 있는 쿠폰들을 반환한다.
	 * @param chkUId
	 * @return
	 */
	public static String[] getCoupon(String chkUId) {
		
		String[] coupon = new String[50];
		int index = 0;
		
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(EVENTCOUPON));
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            String[] check = line.split("■");
	            if (chkUId.equals(check[0])) {
	            	coupon[index] = check[4];
	            	
	            	coupon[index] = coupon[index].replace("원", "");
	    	        coupon[index] = coupon[index].replace(",", "");
	    	        index++;
	            }
	        }
	        
	        reader.close();
	        return coupon;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return null;
	}
	
	/**
	 * 회원의 쿠폰 보유 상황을 출력한다.
	 * @param chkUId
	 */
	public static void couponUi(String chkUId) {
		
		String[] couponList = getCoupon(chkUId);
		String grade = "";
		
		
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(EVENTCOUPON));
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            String[] check = line.split("■");
	            if (chkUId.equals(check[0])) {
	            	grade = check[1];
	            }
	        }       
	        reader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		System.out.println();
		System.out.printf("%s님의 쿠폰현황\n", chkUId);
		System.out.printf("등급: %s\n", grade);
		
		int i = 1;
		
		for (String s : couponList) {
			if (s != null) {
				System.out.printf("%d. %d원 할인쿠폰\n", i, Integer.parseInt(s));
				i++;
			}
		}
		
	}
	
}
