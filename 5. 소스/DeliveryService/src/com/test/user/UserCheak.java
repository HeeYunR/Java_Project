package com.test.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.test.project.Main;
import com.test.validation.Validation;

public class UserCheak {
	final static String USER = "C:\\class\\code\\java\\DeliveryService\\dat\\회원정보.txt";
	public static void userCheakMain(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t\t=============================");
		System.out.print("\t\t아이디 찾기: 1\t비밀번호 찾기: 2\r\n\t\t메인화면: 0\n");
		System.out.println("\t\t=============================");
		
		System.out.print("\t\t\t번호입력: ");
		String num = sc.nextLine().trim();
		
		idCheak(num);
		
	}

	private static void idCheak(String i) {
		Scanner sc = new Scanner(System.in);
		if(i.equals("1")) {
			System.out.println("\t\t=============================");
			System.out.print("\t\t이름: ");
			String username = sc.nextLine();
			
			System.out.print("\t\t전화번호: ");
			String usertel = sc.nextLine();
			
			
//			usertel.i
			System.out.print("\t\t나이:");
			String userage = sc.nextLine();
			

			try {
				BufferedReader reader = new BufferedReader(new FileReader(USER));
				int count =0;
				int cheakCount = 0;
				while(reader.readLine() != null) {
					count++;
				}
				
				reader = new BufferedReader(new FileReader(USER));
				String line = null;
				while((line = reader.readLine()) != null) {
					String[] cheak = line.split("■");
					String cheakName = cheak[5];
					String cheakTel = cheak[3];
					String cheakage = cheak[2];
					cheakCount++;
					if(username.equals(cheakName)) {
						
						
						if(usertel.equals(cheakTel)) {
						
							if(userage.equals(cheakage)) {
								System.out.printf("\t\t아이디: %s\n", cheak[0]);
								
								if(1==move()) {
									Main.main(null);
								}else if(2==move()){
									//로그인화면
								}
						}
					}
							
					}else if(count == cheakCount){
						System.out.print("\t\t일치하는 정보가 없습니다. 다시입력하시겠습니까? y/n");
						String a = sc.nextLine();
						if(a.equals("y")) {
							idCheak("1");
						}else {	
							userCheakMain();
						}
					}
				}		
			} catch (Exception e) {

				e.printStackTrace();
			}
			
	}else if(i.equals("2")) {
		System.out.println("\t\t=============================");
		System.out.print("\t\t아이디: ");
		String userId = sc.nextLine();
		
		System.out.print("\t\t이름: ");
		String userName = sc.nextLine();
		Validation.NameCheck(userName);
		System.out.print("\t\t전화번호: ");
		String userTel = sc.nextLine();
		Validation.PhoneNumCheck(userTel);
		
		 
	        try {
				BufferedReader reader = new BufferedReader(new FileReader(USER));
				int count =0;
				int cheakCount = 0;
				while(reader.readLine() != null) {
					count++;
				}
				
				reader = new BufferedReader(new FileReader(USER));
				String line = null;
				while((line = reader.readLine()) != null) {
					String[] cheak = line.split("■");
					String cheakId = cheak[0];
					String cheakTel = cheak[3];
					String cheakName = cheak[5];
					cheakCount++;
					if(userId.equals(cheakId)) {
						if(userTel.equals(cheakTel)) {		
							if(userName.equals(cheakName)) {
								System.out.printf("비밀번호: %s\n", cheak[1]);
								
								move();
								if(1==move()) {
									Main.main(null);
								}else if(2==move()){
									//로그인화면
								}
							
						}
					}
							
					}else if(count == cheakCount){
						System.out.print("\t\t일치하는 정보가 없습니다. 다시입력하시ㅈ겠습니까? y/n");
						String a = sc.nextLine();
						if(a.equals("y")) {
							
							idCheak("1");
						}else {
							sc.close();
							userCheakMain();
						}
					}
				}
				
			} catch (Exception e) {
				sc.close();
				e.printStackTrace();
			}
	        
	}else if(i.equals("0")) {
		Main.main(null);
	}
	
}

	private static int move() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t=============================");
		System.out.print("\t\t메인화면: 1\t 로그인화면: 2");
		String num = sc.nextLine();
		
		if(num.equals("1")) {
			
			return 1;
		}else if(num.equals("2")) {
			
			return 2;
			//로그인화면으로 이동
		}else {
			move();
			return move();
		}
	}
}