package com.test.storekeeper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import com.test.project.Main;
import com.test.validation.Validation;


/**
 * 
 * 
 * 
 * @author 정상우
 * 
 * 
 * 
 * @see java.io.BufferedWriter;
 * @see java.io.FileWriter;
 * @see java.util.Scanner;
 * @see com.test.project.Main;
 * @see com.test.validation.validation;

 */
public class StorekeeperJoin {
	final static String TXT = "C:\\class\\code\\java\\DeliveryService\\dat\\점주정보.txt";
	
	/**
	 * 점주회원가입 화면출력,회원가입메소드 호출 메소드
	 * 점주회원가입에 필요한 메소드들을 호출하여 return받은 값으로 점주데이터파일에 데이터를 추가하는 메소드
	 * 
	 * @see java.io.BufferedWriter;
	 * @see java.io.FileWriter;
	 * @see java.util.Scanner;
	 * @see com.test.project.Main;
	 * @see com.test.validation.validation;
	 * @see validation.IdCheckStorekeeper()
	 * @see validation.PasswordCheck()
	 * @see validation.AgeCheck()
	 * @see validation.TelCheck()
	 * @see validation.GenderCheck()
	 * @see validation.NameCheck()
	 * @see validation.BusinessNumberCheck()
	 * @see Main.main()
	 * @see
	 * 
	 * 
	 * 
	 */
	public static void storeMemRegJoin(){
		Scanner sc = new Scanner (System.in);
		System.out.println("\t============================================");
    	System.out.println("\t\t      [점주회원가입]");
    	System.out.println("\t============================================");
    	String userId = Validation.IdCheckStorekeeper();
    	System.out.println("\t============================================");
    	String userPw = Validation.PasswordCheck();
    	System.out.println("\t============================================");
    	String userAge = Validation.AgeCheck();
    	System.out.println("\t============================================");
    	String tel = Validation.TelCheck();
    	System.out.println("\t============================================");
    	String gender = Validation.GenderCheck();
    	System.out.println("\t============================================");
    	String name = Validation.NameCheck();
    	System.out.println("\t============================================");
    	String businessNumber = Validation.BusinessNumberCheck();
    	System.out.println("\t============================================");
    	try {
	    		
	    		
    		FileWriter fw = new FileWriter(TXT, true); 
    		BufferedWriter writer = new BufferedWriter(fw);
			
    		 
			writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n",userId,userPw,userAge,tel,gender,name,businessNumber ));
			writer.flush();
			System.out.println();
			System.out.println("\t============================================");
			System.out.println("\t\t회원가입이 완료되었습니다.");
			System.out.println("\t\t메인화면: 0" );
			System.out.print("\t\t입력: ");
			String s = sc.nextLine();
			if(s.equals("0")) {
				Main.main(null);
			}
				
		} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	    
	
//	      아이디,비밀번호,나이,전화번호,성별,이름,사업자등록번호
	    	
	    	//아이디 : 영문자숫자
	    	//비밀번호: 영문자숫자특수문자
	    	//나이 0< 150 
	    	//성별 > 남 여 
	    	//이름 2글자~5글자 한글
	    	//사업자번호 530-29-145812  
	    