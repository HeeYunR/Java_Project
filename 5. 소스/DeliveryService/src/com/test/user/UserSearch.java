package com.test.user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.test.project.Main;
import com.test.project.Ui_6;


public class UserSearch {
	
	public static void usersearch(){
		
		findIdKind();

	}
	
	public static void findIdKind() {
	      
		   Scanner scan = new Scanner(System.in);
		   
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.println("\t\t1.회원 아이디 찾기   2.점주 아이디 찾기   0.메인화면");
		   System.out.println();
		   System.out.println("\t====================================================================");
		   System.out.println();
		   System.out.print("\t\t   번호 입력: ");
		   
		String input = scan.nextLine();
		      
		   if (input.equals("1")) {
			   UserCheak.userCheakMain();
		   } else if(input.equals("2")) {
		       Ui_6.findIdPw();
		   } else if(input.equals("0")) {
			   Main.main(null);
		   }
		   
	}
	
}
	
