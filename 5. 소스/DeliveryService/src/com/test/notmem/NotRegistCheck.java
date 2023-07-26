package com.test.notmem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotRegistCheck {
	//김완진 비회원 정보등록
	public final static String UNMEMLIST = "C:\\class\\code\\java\\DeliveryService\\dat\\unmemlist.txt";
	String regex = "";          //정규식
    Pattern pattern = null;      //정규식 객체
    Matcher matcher = null;      //결과 객체
    Scanner sc = new Scanner(System.in);
    
	public boolean unMemName(String unName) {
		if(unName.equals("")) {
		System.out.println("\t이름은 필수입력, 한글, 2~5자 이내로 입력하세요.");
		}
	    String name = unName;
	    //이름 형식에 알맞게 작성하게끔 설정
	    regex = "^[가-힣]{2,5}$";
	    pattern = Pattern.compile(regex);
	    matcher = pattern.matcher(name);
	    
	    //이름 형식에 알맞지 않게 작성할 경우 if문 실행
	    if(!matcher.find()) {
	       System.out.println("\t잘못된 이름 형식입니다, 다시 입력해주세요.");
	       NotmemJoin.unmemUI();
	    }
		return false;
	}
	
	public boolean unMemAdr(String unAdr) {
		if(unAdr.equals("")) {
		System.out.println("\t주소는 필수입력, 서울시 OO구 OO동 OO아파트 O동OOO호 형식으로 입력하세요.");
		}
	    String adr = unAdr;
	    
	    //주소를 "서울시" + "구" + "동" + "OO아파트" + "O동" + "호" 형식으로 작성하게 설정
	    regex = "서울시\\s*\\S+구\\s*\\S+동\\s*\\S+아파트\\s*\\d+동\\s*\\d+호";
	    pattern = Pattern.compile(regex);
	    matcher = pattern.matcher(adr);
	    
	    //주소 형식에 알맞지 않게 작성할 경우 if문 실행
	    if(!matcher.find()) {
	       System.out.println("\t잘못된 주소 형식입니다, 다시 입력해주세요.");
	       NotmemJoin.unmemUI();
	    }
		return false;
	}
	
	public boolean unMemPhone (String unNum) {
		if(unNum.equals("")) {
		System.out.println("\t전화번호 형식은 010XXXXXXXX 이나 010-XXXX-XXXX로 입력하세요.");
		}
	                         
	    String num = unNum;
	    //이름 형식에 알맞게 작성하게끔 설정
	    regex = "^010[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$";
	    pattern = Pattern.compile(regex);
	    matcher = pattern.matcher(num);  
	    
	    //이름 형식에 알맞지 않게 작성할 경우 if문 실행
	    if(!matcher.find()) {
	       System.out.println("\t잘못된 번호 형식입니다, 다시 입력해주세요.");
	       NotmemJoin.unmemUI();
	    }
		return false;
	}

	public void write(String resultunName, String resultunAdr, String resultunNum) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(UNMEMLIST, true));
	        writer.write(String.format("%s,%s,%s\r\n"
	              , resultunName
	              , resultunAdr
	              , resultunNum));
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
