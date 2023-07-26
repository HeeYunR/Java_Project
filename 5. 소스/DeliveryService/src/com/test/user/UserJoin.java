package com.test.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.project.Member;
import com.test.project.Ui;

//김완진 일반회원가입
public class UserJoin {
	public final static String NORMALMEM = "C:\\class\\code\\java\\DeliveryService\\dat\\회원정보.txt";

	public static void normalMemRegUi() {   
	      String regex = "";          //정규식
	      Pattern pattern = null;      //정규식 객체
	      Matcher matcher = null;      //결과 객체
	      
	      Scanner sc = new Scanner(System.in);
	      System.out.println();
	      System.out.println("\t============================================");
	      System.out.println("\t\t      [일반회원가입]");
	      System.out.println("\t아이디는 필수입력, 영어 소문자로 이루고, 4~12자 이내로 입력하세요.");
	      System.out.print("\t\t      아이디: ");
	                          //정규식을 이용하여 모든 문자열의 공백 제거
	      String id = sc.nextLine().replaceAll("\\p{Z}", "");
	      //정규식을 이용하여 아이디 형식에 올맞게 작성하게끔 설정
	      regex = "^[A-Za-z0-9]{4,12}$";
	      pattern = Pattern.compile(regex);
	      matcher = pattern.matcher(id);
	      
	      //아이디 형식이 맞지않을때 if문 실행
	      if(!matcher.find()) {
	         System.out.println("\t잘못된 아이디 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	      
	      try {
	          // 버퍼드리더로 NORMALMEM 파일을 읽습니다.
	          BufferedReader reader = new BufferedReader(new FileReader(NORMALMEM));
	          String line;
	          // while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
	          while((line = reader.readLine()) != null){
	              // 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
	              String[] userInfo = line.split("■");
	              String registId = userInfo[0];
	              // 스캐너로 입력받은 아이디와 비교하여 중복되는 아이디가 있는지 확인합니다.
	              if (registId.equals(id)) {
	                  System.out.println("\t중복된 아이디 입니다. 다른 아이디를 입력해주세요.");
	                  Ui.pause();
	                  normalMemRegUi();
	              }
	          }
	          reader.close();
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      
	      System.out.println("\t비밀번호는 필수입력, '숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호는 8~16자 이내로 입력하세요.");
	      System.out.print("\t\t      비밀번호: ");
	                          //정규식을 이용하여 모든 문자열의 공백 제거
	      String pw = sc.nextLine().replaceAll("\\p{Z}", "");
	      //정규식을 이용하여 비밀번호 형식에 올맞게 작성하게끔 설정
	      regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
	      pattern = Pattern.compile(regex);
	      matcher = pattern.matcher(pw);
	      
	      //비밀번호 형식이 맞지 않을때 if문 실행
	      if(!matcher.find()) {
	         System.out.println("\t잘못된 비밀번호 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	        	      
	      System.out.println("\t세자리 이내, 숫자로 입력하세요.");
	      System.out.print("\t\t      나이: ");
	                           //정규식을 이용하여 모든 문자열의 공백 제거
	      String age = sc.nextLine().replaceAll("\\p{Z}", "");
	      //정규식을 이용하여 나이 형식에 알맞게 작성하게끔 설정
	      regex = "^[0-9]{1,3}$";
	      pattern = Pattern.compile(regex);
	      matcher = pattern.matcher(age);   //입력값을 대상으로 정규식 검사
	      
	      //나이 형식이 맞지 않을때 if문 실행
	      if(!matcher.find()) {
	         System.out.println("\t잘못된 나이 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	      
	      System.out.println("\t전화번호 형식은 010XXXXXXXX 이나 010-XXXX-XXXX로 입력하세요.");
	      System.out.print("\t\t      전화번호: ");
	                              //문자열에 -들어가는 부분 모두 제거, 모든 문자열의 공백제거
	      String phoneNum = sc.nextLine().replaceAll("-", "").replaceAll("\\p{Z}", "");
	      //정규식을 이용하여 전화번호 형식에 알맞게 작성하게끔 설정
	      regex = "^010[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$";
	      pattern = Pattern.compile(regex);
	      matcher = pattern.matcher(phoneNum);   
	      
	      //전화번호 형식이 맞지 않을때 if문 실행
	      if(!matcher.find()) {
	         System.out.println("\t잘못된 전화번호 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	      
	      try {
	          // 버퍼드리더로 NORMALMEM 파일을 읽습니다.
	          BufferedReader reader = new BufferedReader(new FileReader(NORMALMEM));
	          String line;
	          // while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
	          while((line = reader.readLine()) != null){
	              // 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
	              String[] userInfo = line.split("■");
	              String registPhone = userInfo[4];
	              // 스캐너로 입력받은 전화번호와 비교하여 중복되는 전화번호가 있는지 확인합니다.
	              if (registPhone.equals(phoneNum)) {
	                  System.out.println("\t중복된 전화번호 입니다. 다른 전화번호를 입력해주세요.");
	                  Ui.pause();
	                  normalMemRegUi();
	              } 
	          }
	          reader.close();
	      }
	      catch (Exception e) {
	          e.printStackTrace();
	      }
	      
	      System.out.println("\t성별 형식 '남자'나 '여자'만 입력하세요.");
	      System.out.print("\t\t      성별(남자/여자): ");
	                           //모든 문자열의 공백제거
	      String gender = sc.nextLine().replaceAll("\\p{Z}", "");
	      
	      //성별 형식에 알맞지 않게 작성할 경우 if문 실행
	      if(!(gender.equals("남자")||gender.equals("여자"))){
	         System.out.println("\t잘못된 성별 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	      
	      System.out.println("\t이름은 필수입력, 한글, 2~5자 이내로 입력하세요.");
	      System.out.print("\t\t      이름: ");
	                           //모든 문자열의 공백제거
	      String name = sc.nextLine().replaceAll("\\p{Z}", "");
	      
	      //이름 형식에 알맞게 작성하게끔 설정
	      regex = "^[가-힣]{2,5}$";
	      pattern = Pattern.compile(regex);
	      matcher = pattern.matcher(name);
	      
	      //이름 형식에 알맞지 않게 작성할 경우 if문 실행
	      if(!matcher.find()) {
	         System.out.println("\t잘못된 이름 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	      
	      System.out.println("\t주소는 필수입력, 서울시 OO구 OO동 OO아파트 O동OOO호 형식으로 입력하세요.");
	      System.out.print("\t\t      주소: ");
	      								//모든 문자열 공백 제거
	      String address = sc.nextLine().replaceAll("\\p{Z}", "");
	      
	        //주소를 "서울시" + "구" + "동" + "OO아파트" + "O동" + "호" 형식으로 작성하게 설정
	       regex = "서울시\\s*\\S+구\\s*\\S+동\\s*\\S+아파트\\s*\\d+동\\s*\\d+호";

	        pattern = Pattern.compile(regex);
	        matcher = pattern.matcher(address);
	        
	        //형식에 맞지 않을경우 if문 실행
	        if(!matcher.find()) {
	           System.out.println("\t잘못된 주소 형식입니다, 다시 입력해주세요");
	           Ui.pause();
	           normalMemRegUi();
	        }
	      
	      
	      System.out.println("\t닉네임은 필수입력, 한글, 1~10자 이내로 입력하세요.");
	      System.out.print("\t\t      닉네임: ");
	                              //모든 공백문자 제거
	      String nickname = sc.nextLine().replaceAll("\\p{Z}", "");
	      //닉네임 형식에 맞게 작성하도록 설정
	      regex = "^[가-힣]{1,10}$";
	      pattern = Pattern.compile(regex);
	      matcher = pattern.matcher(nickname);   //입력값을 대상으로 정규식 검사
	      
	      //맞지 않을경우 if문 실행
	      if(!matcher.find()) {
	         System.out.println("\t잘못된 닉네임 형식입니다, 다시 입력해주세요.");
	         Ui.pause();
	         normalMemRegUi();
	      }
	      
	      try {
	          // 버퍼드리더로 NORMALMEM 파일을 읽습니다.
	          BufferedReader reader = new BufferedReader(new FileReader(NORMALMEM));
	          String line;
	          // while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
	          while((line = reader.readLine()) != null){
	              // 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
	              String[] userInfo = line.split("■");
	              String registNick = userInfo[7];
	              // 스캐너로 입력받은 닉네임과 비교하여 중복되는 닉네임이 있는지 확인합니다.
	              if (registNick.equals(nickname)) {
	                  System.out.println("\t중복된 닉네임 입니다. 다른 닉네임을 입력해주세요.");
	                  Ui.pause();
	                  normalMemRegUi();
	              } 
	          }
	          reader.close();
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      
	      String point = "0";
	      
	      Member m = new Member(id, pw, age, phoneNum, gender, name, address, nickname, point);
	      try {
	         BufferedWriter writer = new BufferedWriter(new FileWriter(NORMALMEM, true));
	         writer.write(String.format("%s■%s■%s■%s■%s■%s■%s■■%s\r\n"
	               , m.getId()
	               , m.getPw()
	               , m.getAge()
	               , m.getPhoneNum()
	               , m.getGender()
	               , m.getName()
	               , m.getAddress()
	               , m.getNickname()));
	         writer.close();
	         System.out.println("\t============================================");
	         System.out.println("\t\t    회원가입이 완료되었습니다!");
	         System.out.println(m.toString());
	         System.out.println("\t============================================");
	         System.out.println("\t\t    메인메뉴로 돌아갑니다");
	         Ui.pause();
	         Ui.mainUi();
	      } 
	      catch (IOException e) {
	         e.printStackTrace();
	      }

	   }
}
