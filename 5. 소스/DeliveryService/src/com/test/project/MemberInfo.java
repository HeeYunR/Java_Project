package com.test.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MemberInfo {
	private static String id;
	private static String pw;
    private static String email;
	private static String age;
	private static String phoneNum;
	private static String gender;
	private static String name;
	private static String address;
	private static String nickname;
	private static String point;
	
	
	public MemberInfo() {
		
	}
	
	public MemberInfo(String id, String pw, String email, String age, String phoneNum, String gender, String name, String address, String nickname, String point) {
		MemberInfo.id = id;
		MemberInfo.pw = pw;
		MemberInfo.email = email;
		MemberInfo.age = age;
		MemberInfo.phoneNum = phoneNum;
		MemberInfo.gender = gender;
		MemberInfo.name = name;
		MemberInfo.address = address;
		MemberInfo.nickname = nickname;
		MemberInfo.point = point;
	}
	
	
	//김완진 멤버select ui
	private final static String MEMBERINFO = "C:\\class\\code\\java\\DeliveryService\\dat\\normalmem.txt";
	private final static String ORDER = "C:\\class\\code\\java\\DeliveryService\\dat\\주문이력.txt";
	private final static String REVIEW = "C:\\class\\code\\java\\DeliveryService\\dat\\리뷰.txt";
	
	//회원정보 조회
	public static void memberinfo(String chkUid) {
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
	        MemberInfo mi = new MemberInfo(id, pw, email, age, phoneNum, gender, name, address, nickname, point);
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            String[] check = line.split("■");
	            if (chkUid.equals(check[0])) {
	            	mi = new MemberInfo(check[0], check[1], check[2], check[3], check[4], check[5], check[6], check[7], check[8], check[9]);
	            	mi.show();
	            	break;
	            }
	        }
	        reader.close();
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	}
	
	public void show() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t===================회원정보====================");
	    System.out.println("\t\t아이디: " + MemberInfo.id);
	    System.out.println("\t\t비밀번호: " + MemberInfo.pw);
	    System.out.println("\t\t이메일: " + MemberInfo.email);
	    System.out.println("\t\t나이: " + MemberInfo.age);
	    System.out.println("\t\t전화번호: " + MemberInfo.phoneNum);
	    System.out.println("\t\t성별: " + MemberInfo.gender);
	    System.out.println("\t\t이름: " + MemberInfo.name);
	    System.out.println("\t\t주소: " + MemberInfo.address);
	    System.out.println("\t\t닉네임: " + MemberInfo.nickname);
	    System.out.println("\t============================================");
	    System.out.print("\t\t엔터를 입력하시면 이전화면으로 넘어갑니다. \n");
	    System.out.println("\t============================================");
	    String input = sc.nextLine();
	    Ui.userFunctUi(MemberInfo.id);
	}

	public static void memberdelete(String chkUid) {
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
	        ArrayList<String> deletemem = new ArrayList<String>();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] check = line.split("■");
	            if (chkUid.equals(check[0])) {
	                // Do nothing
	            } else {
	                deletemem.add(line);
	            }
	        }
	        reader.close();

	        BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
	        for (String editline : deletemem) {
	            writer.write(editline);
	            writer.newLine();
	        }

	        writer.close();
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	}
	
	//숫자+영문자 무작위 문자6자리를 반환하는 메소드
	public static String deleteCharacter() {
		String result;
		List<String> alpha = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z","0","1","2","3","4","5","6","7","8","9");
		Collections.shuffle(alpha);
		result = alpha.get(0)+alpha.get(1)+alpha.get(2)+alpha.get(3)+alpha.get(4)+alpha.get(5);
		return String.format("\t\t\t%s", result);
	}
	
	public static String getPoint(String chkUid) {
		
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            String[] check = line.split("■");
	            if (chkUid.equals(check[0])) {
	            	
	            	point = check[9];
	            }
	        }
	        reader.close();
	        return point;
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
		return "1000";
	}
	
	public static String getId() {
		return id;
	}
	
	public static void orderUi(String chkUId) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> foodList = new ArrayList<String>();
		
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(ORDER));
	        String line;
	        
	        System.out.println("\t=====================================================");
	        System.out.println("\t\t\t회원님의 주문내역");
	        System.out.println("\t[번호]\t[음식점]\t[메뉴]\t\t[옵션]\t[가격]\t[리뷰]");
	        
	        int index = 1;
	        
	        while ((line = reader.readLine()) != null) {
	            String[] check = line.split("■");
	            if (chkUId.equals(check[0])) {
	            	System.out.printf("\t%s\t%s\t%-10s\t%s\t%s\t%s\n"
	            			, index
	            			, check[1]
	            			, check[2]
	            			, check[3]
	            			, check[6]
	            			, check[5].equals("true") ? "O" : "X");
	            	list.add(check[1]);
	            	foodList.add(check[3]);
	            	index++;
	            }
	        }       
	        reader.close();
	        System.out.println("\t=====================================================");
	        
	        System.out.print("\t리뷰를 작성할 음식점의 번호를 입력해주세요.: ");
	        
	        String num = scan.nextLine();
	        
	        File file = new File(REVIEW);
	        
	        FileWriter fw = new FileWriter(file, true);
	        BufferedWriter writer = new BufferedWriter(fw);
	        
	        System.out.print("\t리뷰의 내용을 적어주세요: ");
	        String txt = scan.nextLine();
	        System.out.print("\t음식의 평점을 적어주세요: ");
	        String rating = scan.nextLine();
	        
	        writer.write(String.format("%s■%s■%s■%s■%s\n", chkUId
	        					, list.get(Integer.parseInt(num)-1)
	        					, foodList.get(Integer.parseInt(num)-1)
	        					, txt, rating ));
	        
	        writer.close();
	        
	        Ui.pause();
	        Ui.userFunctUi(chkUId);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}

