package com.test.storekeeper;

import java.util.Scanner;

import com.test.project.Ui;

public class StorekeeperCheak {
	
	   public static void findIdOwner() {
	      
	      Scanner scan = new Scanner(System.in);
	      
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      System.out.println("\t\t점주 아이디 찾기 ");
	      System.out.println();
	      System.out.print("\t\t1.이름 : ");
	      String inputName = scan.nextLine();
	      System.out.println();
	      System.out.print("\t\t2.이메일 : ");
	      String inputEmail = scan.nextLine();
	      System.out.println();
	      System.out.print("\t\t3.전화번호 :  ");
	      String inputPhoneNum = scan.nextLine();
	      System.out.println();
	      System.out.print("\t\t3.사업자등록번호 :  ");
	      String inputBusiness = scan.nextLine();
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      
	      
	      if (true) {
	         findIdTrueUi();
	      } else if(false) {
	         findIdTrueUi();
	      } 
	         
	   }
	   
	   public static void findIdUi() {
	      
		   Scanner scan = new Scanner(System.in);
		   
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.println("\t\t아이디 찾기 ");
		   System.out.println();
		   System.out.print("\t\t1.이름 : ");
		   String inputName = scan.nextLine();
		   System.out.println();
		   System.out.print("\t\t2.이메일 : ");
		   String inputEmail = scan.nextLine();
		   System.out.println();
		   System.out.print("\t\t3.전화번호 :  ");
		   String inputPhoneNum = scan.nextLine();
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   
		   
		   if (true) {
		      findIdTrueUi();
		   } else if(false) {
		      findIdTrueUi();
		   } 
	   
	   }
	   
	   public static void findIdFalseUi() {
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      System.out.println("\t\t아이디 찾기 실패");
	      System.out.println();
	      System.out.println("\t\t   1. 이전페이지  0. 메인페이지");
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      System.out.print("\t\t   번호 입력: ");
	      
	      Scanner scan = new Scanner(System.in);
	      String input = scan.nextLine();
	      
	      if (input.equals("1")) {
	         findIdUi();
	      } else if(input.equals("0")) {
	         Ui.mainUi();
	      } 
	   }
	   
	   public static void findIdTrueUi() {
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.println("\t\t아이디 찾기 완료");
		   System.out.println();
		   System.out.println("\t\t등록된 아이디 : ");
		   System.out.println();
		   System.out.println("\t\t   1. 이전페이지  2. 비밀번호찾기  0. 메인페이지");
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.print("\t\t   번호 입력: ");
		   
		   Scanner scan = new Scanner(System.in);
		   String input = scan.nextLine();
		   
		   if (input.equals("1")) {
		      findIdUi();
		   } else if(input.equals("2")) {
		      findPwUi();
		      
		   } else if(input.equals("0")) {
		      Ui.mainUi();
		   } 
	   }
	   
	   public static void findPwUi() {
	      
	      Scanner scan = new Scanner(System.in);
	      
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      System.out.println("\t\t\t비밀번호 찾기 ");
	      System.out.println();
	      System.out.println("\t\t1. 아이디 : ");
	      String inputId = scan.nextLine();
	      System.out.println();
	      System.out.println("\t====================================================================");
	      
	      
	      if (true) {
	         findPwTrueUi();
	      } else if(false) {
	         findPwFalseUi();
	      } 
	     
	   }
	   
	   public static void findPwFalseUi() {
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      System.out.println("\t\t비밀번호 찾기 실패");
	      System.out.println();
	      System.out.println("\t\t   1. 이전페이지  0. 메인페이지");
	      System.out.println();
	      System.out.println("\t====================================================================");
	      System.out.println();
	      System.out.print("\t\t   번호 입력: ");
	      
	      Scanner scan = new Scanner(System.in);
	      String input = scan.nextLine();
	      
	      if (input.equals("1")) {
	         findPwUi() ;
	      } else if(input.equals("0")) {
	         Ui.mainUi();
	      } 
	   }
	   
	   public static void findPwTrueUi() {
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.println("\t\t비밀번호 찾기 완료");
		   System.out.println();
		   System.out.println("\t\t등록된 비밀번호 : ");
		   System.out.println();
		   System.out.println("\t\t   1. 이전페이지  0. 메인페이지");
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.print("\t\t   번호 입력: ");
		   
		   Scanner scan = new Scanner(System.in);
		   String input = scan.nextLine();
		   
		   if (input.equals("1")) {
		      findPwUi();
		   } else if(input.equals("0")) {
		      Ui.mainUi();
		   } 
	   }
}
