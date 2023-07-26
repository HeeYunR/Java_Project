package com.test.notmem;

import java.util.Scanner;

import com.test.project.Ui;

public class NotmemJoin {
	
	//김완진 비회원 ui
	public static void unmemUI() {
		NotRegistCheck nr = new NotRegistCheck();
		Scanner sc = new Scanner(System.in);
		System.out.println("\t===========================================================");
		System.out.println("\t\t      [비회원 주문]");
		System.out.println("\t이름은 필수입력, 한글, 2~5자 이내로 입력하세요.");
		System.out.print("\t\t      이름: ");
									//공백제거
		String unName = sc.nextLine().replaceAll("\\p{Z}", "");
		nr.unMemName(unName);
		System.out.println("\t주소는 필수입력, 서울시 OO구 OO동 OO아파트 O동OOO호 형식으로 입력하세요.");
		System.out.print("\t\t      주소: ");
									//공백제거
		String unAdr = sc.nextLine().replaceAll("\\p{Z}", "");
		nr.unMemAdr(unAdr);
		System.out.println("\t전화번호 형식은 010XXXXXXXX 이나 010-XXXX-XXXX로 입력하세요.");
		System.out.print("\t\t      전화번호: ");
									//공백제거, 중간에 -들어가는것 제거
		String unNum = sc.nextLine().replaceAll("-", "").replaceAll("\\p{Z}", "");
		nr.unMemPhone(unNum);
		
		nr.write(unName,unAdr,unNum);
		
		System.out.println("\t==========================================================");
		System.out.println("\t\t정보가 입력되었습니다, 3초후 카테고리로 넘어갑니다...");
		//3초후 카테고리로 넘어감
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        Ui.categoryUi();
		
	}
}
