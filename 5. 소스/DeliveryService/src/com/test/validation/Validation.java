package com.test.validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.project.Login;
import com.test.project.Main;
import com.test.storekeeper.StorekeeperScreen;
/**
 * 
 * @author 정상우
 *  
 */	
public class Validation {
	final static String USER = "C:\\class\\code\\java\\DeliveryService\\dat\\회원정보.txt"; 
	final static String STOREKEEPER = "C:\\class\\code\\java\\DeliveryService\\dat\\점주정보.txt";
	final static String STORE = "C:\\class\\code\\java\\DeliveryService\\dat\\점포.txt";
	
	/**
	 * 전화번호와 데이터파일위치를 String 매개변수로 받아 데이터파일에서 전화번호를 찾아주는 메소드
	 *  
	 * @param i 전화번호
	 * @param TXT 데이터파일 위치
	 * @return 주어진 매개변수가 데이터파엘에 동일한 데이터가있으면 true, 그렇지 않은 경우 false
	 */
	public static Boolean PhoneNumSearch(String i, String TXT) {
		boolean cheak = false;
		try {
			BufferedReader user = new BufferedReader(new FileReader(TXT));

	        String line = null;
	        user = new BufferedReader(new FileReader(TXT));
	        while((line= user.readLine()) != null) {	
	        	String[] txt = line.split("■");
	        	String userId = txt[3];//유저아이디위치 
	        	if(i.equals(userId)) {
	        		cheak =true;
	        		break;
	        	}		 
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cheak) {
			return true;
		}else {
			return false;
		}
	}
	
	/**전화번호를 입력받아 형식에맞게 변환후 전화번호 형식이 유효한지 검사
	 * 
	 * @see java.lang.StringBuffer
	 * 
	 * 
	 * @param phonenum 전화번호
	 * @return 형식이맞으면 true 맞지않으면 false
	 */
	public static Boolean PhoneNumCheck(String phonenum){
		//전화번호 사이 - 제거후 형식에맞게 저장
		//ex)01012341234 -> 010-1234-1234
		// 인터넷번호(서울만)02 , 010 
		String[] tel = phonenum.split("-");
		phonenum ="";
		StringBuffer sb = new StringBuffer();
		   
		for(String t : tel) {
		  	phonenum+=t;
		}
        sb.append(phonenum);
        sb.insert(3, "-");
        sb.insert(8, "-");
        if(!(sb.toString().length()==13)) {
        	return false;
        }else {
        	return true;
        }
	}
	
	/**Id를 입력받아 영문자 대소문자, 숫자로만 구성되는지 유효성검사
	 * 
	 * 
	 * 
	 * @param id 아이디
	 * @return 형식이맞으면 true 맞지않으면 false
	 */
	public static Boolean IdCheck(String id) {
		
		if(id.length()>=2&&id.length()<=10) {
		for(int i=0; i< id.length(); i++) {
			
			if((id.charAt(i)>=47&&id.charAt(i)<=57)||id.charAt(i)>=65&&id.charAt(i)<=90||id.charAt(i)>=97&&id.charAt(i)<122) {
				
			}else {
				return false;
			}
			
		}
			return true;
		}else {
			return false;
		}
		
	}//아이디 : 영문자숫자 2~10글자
	
	/**
	 * 유저아이디를 매개변수 i로 입력받아 회원정보리스트 매개변수 TXT에서 유저아이디가 중복여부 조회
	 * 
	 * @see java.io.BufferedReader
	 * 
	 * @param i = 유저아이디
	 * @param TXT = 텍스트 위치
	 * @return true :중복되는 아이디가 있으면 return값으로 true를 반환  false: 중복되는 아이디가 없으면 return값으로 false 반환 
	 * 
	 */
	public static Boolean IdSearch(String i, String TXT) {
		boolean cheak = false;
		try {
			BufferedReader user = new BufferedReader(new FileReader(TXT));

			String line = null;
	        user = new BufferedReader(new FileReader(TXT));
	        while((line= user.readLine()) != null) {	
	        	String[] txt = line.split("■");
	        	String userId = txt[0];//유저아이디위치
	        	 
	        	if(i.equals(userId)) {
	        		cheak =true;
	        		break;
	        	}		 
	        }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cheak) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public static String  PasswordCheckStorekeeper() {
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호(영대소문자,특수문자,숫자 포함: ");
		String pw = sc.nextLine();
		
		Pattern password = Pattern.compile(pw);
				
		return pw;
	}
	
	/**
	 * 유저패스워드를 입력받아 회원정보리스트에서 유저패스워드를 조회후 
	 * 중복되는 패스워드가 있으면 return값으로 true를 반환
	 * 중복되는 패스워드가 없으면 return값으로 false 반환
	 * 
	 * @see java.io.BufferedReader
	 * @param i = 유저패스워드
	 * @param TXT = 텍스트 위치
	 * @return true  false 
	 * 
	 */
	public static Boolean PasswordSearch(String i,String TXT) {
		boolean cheak = false;
		try {
			BufferedReader user = new BufferedReader(new FileReader(TXT));

			String line = null;
			user = new BufferedReader(new FileReader(TXT));
			while((line= user.readLine()) != null) {	
				String[] txt = line.split("■");
				String userpw = txt[1];//유저아이디위치
      	 
				if(i.equals(userpw)) {
					cheak =true;
					break;
				}		 
			}
		
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
		if(cheak) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 유저나이를 매개변수 i 로 입력받아 회원,점주정보리스트를 TXT매개변수로 입력받아 회원정보리스트에서 유저패스워드를 조회
	 * 
	 * 
	 * @see java.io.BufferedReader
	 * @see java.io.FileReader
	 * 
	 * 
	 * @param i = 유저나이
	 * @param TXT = 회원,점주정보리스트
	 * 
	 * @return true : 유저의 나이가 일치하면 return값으로 true반환    false : 유조의 나이가 일치하지 않으면 return값으로 false반환
	 * 
	 */
	public static Boolean AgeSearch(String i,String TXT) {
		boolean cheak = false;
		try {
			BufferedReader user = new BufferedReader(new FileReader(TXT));
	
	        String line = null;
	        user = new BufferedReader(new FileReader(TXT));
	        while((line= user.readLine()) != null) {	
	      	  	String[] txt = line.split("■");
	      	  	String userpw = txt[3];//유저나이위치
	      	 
	      	  	if(i.equals(userpw)) {
	      	  		cheak =true;
	      	  		break;
	      	  	}		 
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
		if(cheak) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 아이디를 입력받기위한 화면출력, 아이디 입력, 아이디유효성검사를 위한 메소드
	 * 유효하지 않은 아이디를 입력받으면 유효한 아이디를 입력받기까지 IdCheckStorekeeper() 메소드 호출 후 유효한 아이디를 입력받으면 return 값으로 id반환
	 *  
	 * 
	 * @return String id : 입력받은 유효한 아이디
	 */
	public static String IdCheckStorekeeper() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t아이디는 필수입력, 영어,소문자로 이루고, 4~12자 이내로 입력하세요.\n");
		System.out.print("\t\t아이디: ");
		String id = sc.nextLine();
		if(Validation.IdSearch(id, STOREKEEPER )){
		 
			System.out.print("죽복된아이디입니다.\n");
			id = IdCheckStorekeeper();
		}else if(!Validation.IdCheck(id)) {
    		
			System.out.print("아이디가 유효하지 않습니다.\n");
			id = IdCheckStorekeeper();
		
		}
		return id;
	}
	
	/**
	 *  패스워드를 입력받기위한 화면출력, 아이디 입력, 아이디유효성검사를 위한 메소드
	 *  유효하지 않은 패스워드를 입력받으면 유효한 패스워드를 입력받기까지 PasswordCheck() 메소드 호출 후 유효한 아이디를 입력받으면 return 값으로 pw반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 *
	 * 
	 * 
	 * 
	 * @return String pw : 입력받은 유효한 패스워드
	 */
	public static String PasswordCheck() {
		Scanner sc = new Scanner (System.in);
		System.out.print("\t비밀번호는 필수입력, '숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호는 8~16자 이내로 입력하세요.\n\t\t비밀번호: ");
    	String pw = sc.nextLine();
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"); // 정규식을 적는부분 e+을 지우고 쓰세요
		Matcher matcher = passPattern1.matcher(pw);
		if( matcher.find()) {
			return pw;
		}else
			
			pw = PasswordCheck();
			return pw;
			
	}//비밀번호: 영문자숫자특수문자들 최소 1글자 이상씩 2~15글자 
	
	
	/**
	 * 패스워드를 입력받기위한 화면출력, 아이디 입력, 아이디유효성검사를 위한 메소드
	 * 유효하지 않은 나이값 입력받으면 유효한 나이값을 입력받기까지 
	 * AgeCheck() 메소드 호출 후 유효한 나이값를 입력받으면 return 값으로 age반환
	 * 
	 * @see java.util.Scanner
	 * 
	 * @return String age : 입력받은 유효한 나이값
	 * 
	 */
	public static String AgeCheck() {
		Scanner sc = new Scanner (System.in);
		System.out.println("\t\t세자리 이내, 숫자로 입력하세요.");
		System.out.print("\t\t나이: ");
		String age = sc.nextLine();
		if(Integer.valueOf(age)>0&&Integer.valueOf(age)<150) {
			return age;
		}else {
			System.out.println("\t잘못된 나이 형식입니다, 다시 입력해주세요.");
			age =  AgeCheck();
			return age;
		}
	}
	
	/**
	 * 성별을 입력받기위한 화면출력, 성별 입력, 성별유효성검사를 위한 메소드
	 * 유효한 성별을 입력받으면 return 값으로 true 반환
	 * @param i : 유저성별(남,여) 
	 * @return true : 입력받은 인자값이 유효하면 true  false : 입력받은 인자값이 유효하지않으면 false
	 * 
	 */
	public static Boolean GenderCheck(String i) {
		
		if(i.equals("남")) {
			return true;
		}else if(i.equals("여")) {
			return true;
		}else return false;
			
	}
	
	/**
	 * 매개변수로 입력받은 문자열(이름)을 한글1~5글자 형식에 맞는지 유효성검사 하는 메소드
	 * 
	 * 
	 * @param name : 이름
	 * 
	 * @return true : 형식에맞으면 true    false: 형식에맞지않으면 false 
	 */
	public static Boolean NameCheck(String name) {
		
		if(name.length()>=2&&name.length()<=5) {
			for(int i=0; i<name.length(); i++) {
			if(name.charAt(i)>='가'&&name.charAt(i)<='힣') {
				
			}else {
				return false;
			}
			}return true;
			
		}else {
			return false;
		}
		
	}
	
	/**
	 * 매개변수로 입력받은 문자열(사업자등록번호)을 000-00-00000(숫자) 형식에 맞는지 유효성검사 하는 메소드
	 * 
	 * 
	 * @param num : 사업자등록번호
	 * 
	 * @return true : 형식에맞으면 true    false: 형식에맞지않으면 false 
	 */
	public static Boolean BusinessNumberCheck(String num) {
		
		String[] a = num.split("-");
		if(a.length==3) {
			for(int i=0; i<num.length(); i++) {
			if((num.charAt(i)>=48&&num.charAt(i)<=57)||num.charAt(i)=='-') {
				
			}else {
				return false;
			}
			}return true;
		}else return false;
		
	}


	/**
	 * 매개변수로 입력받은 i(사업자등록번호)를 TXT매개변수(찾고싶은 데이터텍스트 위치)에서  유효한값이 있는지 찾아 검사하는 메소드
	 * 
	 * 
	 * @see java.io.BufferedReader
	 * @see java.io.FileReader
	 * 
	 * 
	 * @param i = 사업자등록번호
	 * @param TXT = 데이터 텍스트경로
	 * 
	 * @return ture : 텍스트파일에 일치한 사업자등록번호가 있을시 true return   false : 일치하지 않을시 false return
	 */
	public static Boolean BusinessNumberSearch(String i,String TXT) {
		boolean cheak = false;
		try {
		BufferedReader user = new BufferedReader(new FileReader(TXT));

        String line = null;
        user = new BufferedReader(new FileReader(TXT));
        while((line= user.readLine()) != null) {	
      	  String[] txt = line.split("■");
      	  String userpw = txt[3];//유저나이위치
      	 
      		if(i.equals(userpw)) {
      			cheak =true;
      			break;
      		}		 
        }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(cheak) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 *  전화번호를 입력받기위한 화면출력, 전화번호 입력, 전화번호유효성검사를 위한 메소드
	 *  유효하지 않은 전화번호를 입력받으면 유효한 전화번호를 입력받기까지 TelCheck() 메소드 호출 후 유효한 전화번호를 입력받으면 return 값으로 tel반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * 
	 * 
	 * @return String tel : 입력받은 유효한 전화번호
	 */
	public static String TelCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t전화번호 형식은 010XXXXXXXX 이나 010-XXXX-XXXX로 입력하세요.\n");
		System.out.print("\t\t입력: ");
		String tel = sc.nextLine().replaceAll("-", "").replaceAll("\\p{Z}", "");;
		 Pattern pattern = Pattern.compile("\\d{3}\\d{4}\\d{4}");
	    Matcher matcher = pattern.matcher(tel);
	    if (matcher.matches()) {
	    	return tel;
	    }else {
	    	System.out.println("\t잘못된 전화번호 형식입니다, 다시 입력해주세요.");
	    	tel = TelCheck();
	    	return tel;
	    }
		
	}

	/**
	  *  성별를 입력받기위한 화면출력, 성별 입력, 성별유효성검사를 위한 메소드
	 *  유효하지 않은 성별을 입력받으면 유효한 성별을 입력받기까지 GenderCheck() 메소드 호출 후 유효한 성별을 입력받으면 return 값으로 gender반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * 
	 * 
	 * @return String gender : 입력받은 유효한 성별
	 */
	public static String GenderCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t성별 형식 '남자'나 '여자'만 입력하세요.");
	    System.out.print("\t\t성별(남자/여자): ");
		String gender = sc.nextLine().replaceAll("\\p{Z}", "");
		if(gender.equals("남자")||gender.equals("여자")) {
			return gender;
		}else {
			 System.out.println("\t잘못된 성별 형식입니다, 다시 입력해주세요.");
			gender = GenderCheck();
			return gender;
		}
	}

	/**
	  *  이름을 입력받기위한 화면출력, 이름 입력, 이름유효성검사를 위한 메소드
	 *  유효하지 않은 이름을 입력받으면 유효한 이름을 입력받기까지 NameCheck() 메소드 호출 후 유효한 이름을 입력받으면 return 값으로 name반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * 
	 * 
	 * @return String name : 입력받은 유효한 이름
	 */
	public static String NameCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t이름은 필수입력, 한글, 2~5자 이내로 입력하세요.");
	    System.out.print("\t\t이름: ");
	                           //모든 문자열의 공백제거
	    String name = sc.nextLine().replaceAll("\\p{Z}", "");
	 
	    Pattern pattern = Pattern.compile("^[가-힣]{2,5}$");
	    Matcher matcher = pattern.matcher(name);
	    if(matcher.matches()) {
	    	return name;
	    }else {
	    	System.out.println("\t잘못된 이름 형식입니다, 다시 입력해주세요.");
	    	name = NameCheck();
	    	return name;
	     }
	}

	/**
	 *  사업자등록번호를 입력받기위한 화면출력, 사업자등록번호 입력, 사업자등록번호유효성검사를 위한 메소드
	 *  유효하지 않은 사업자등록번호를 입력받으면 유효한 사업자등록번호를 입력받기까지 BusinessNumberCheck() 메소드 호출 후 유효한 사업자등록번호를 입력받으면 return 값으로 number반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * 
	 * 
	 * @return String number : 입력받은 유효한 사업자등록번호
	 */
	public static String BusinessNumberCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t사업자등록번호는 필수입력, 000-00-00000 형식으로 입력하세요.");
	    System.out.print("\t\t사업자등록번호: ");
	    String number = sc.nextLine().replaceAll("\\p{Z}", "");
	     
		Pattern pattern = Pattern.compile("([0-9]{3})-?([0-9]{2})-?([0-9]{5})");
	    Matcher matcher = pattern.matcher(number);
	    if(matcher.matches()) {
	    	return number;
	    }else {
	    	System.out.println("\t잘못된 사업자등록번호 형식입니다, 다시 입력해주세요.");
	    	number = BusinessNumberCheck();
	    	return number;
	     }
	}

	/**
	 *  주소를 입력받기위한 화면출력, 주소 입력, 주소유효성검사 위한 메소드
	 *  유효하지 않은 주소를 입력받으면 유효한 주소를 입력받기까지 addressCheck() 메소드 호출 후 유효한 주소를 입력받으면 return 값으로 adress반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * 
	 * 
	 * @return String address : 입력받은 유효한 주소
	 */
	public static String addressCheck() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\t주소는 필수입력, 서울시 OO구 OO동 000-000 형식으로 입력하세요.");
		System.out.print("\t\t주소: ");
		String address = sc.nextLine();
		
		if(!address.equals("")) {
			
			}
		    String adr = address;
		    
		    String  regex = "(([가-힣]+(시)|서울)( |)[가-힣]+(시|군|구))"
		               + "|([가-힣A-Za-z]+(구)+\\s*[가-힣A-Za-z]+(동)( |)[0-9]+((길|가)?)(\\s*[0-9]+)?)"
		               + "|[0-9]{1,4}(-)( |)[0-9]{1,4}\"";
//서울시 금천구 양재동 851-331
		    //^[가-힣]+(시)+ [가-힣]+ [가-힣]+-\d{1,5}-\d{1,5}$
		    Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(adr);
		    
		    if(adr.contains("시")==false && adr.contains("동")==false && !adr.contains("구")) {
		           System.out.println("\t잘못된 주소 형식입니다, 다시 입력해주세요");
		           address = addressCheck();
		     }
		    
		    
		    //주소 형식에 알맞지 않게 작성할 경우 if문 실행
		    if(!matcher.find()) {
		       System.out.println("\t잘못된 주소 형식입니다, 다시 입력해주세요.");
		       address = addressCheck();
		    }
			return address;
		
	}
//1.한식	2.양식	 3.중식	4.일식 5.카페	6.아시안	 7.패스트푸드 8.검색	9.추천메뉴 0.메인화면
	
	/**
	 * 카테고리를 입력받기위한 화면출력, 카테고리번호 입력
	 *  배열에 저장된 카테고리 출력후 유효하지 않은 카테고리 번호를 입력받으면 유효한 카테고리번호를 입력받기까지 categoryCheck() 
	 *  메소드 호출 후 유효한 카테고리번호를 입력받으면 return 값으로 category1반환
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * 
	 * 
	 * @return String category1 : 입력받은 유효한 카테고리
	 */
	public static String categoryCheck() {
		String[] category = {"한식","양식","중식","일식","카페","아시안","패스트푸드"};
		System.out.println("\t\t1.한식\t2.양식\t 3.중식\t4.일식");
		System.out.println("\t\t5.카페\t6.아시안\t 7.패스트푸드");
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t번호입력: ");
		int num = sc.nextInt();
		
		if(category.length>=num&&0<num){
			return category[num];
		}else {
			String category1 = categoryCheck();
			return category1;
		}

	}

	public static double ratingCheck() {
		return 0;
	}

	/**
	 * 배달소요시간을 입력받기위한 화면출력, 배달소요시간 입력
	 *  배달최소 int deliveryh,최대시간 int deliveryh2 을 입력받아 "배달최소,최대시간" 문자열 값으로 return
	 * 
	 * @see java.util.Scanner
	 * 
	 * @return String.format("%d■%d",deliveryh,deliveryh2)
	 * 
	 */
	public static String deliveryH() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t배달 최소시간(분): ");		
		int deliveryh= sc.nextInt();  
		System.out.print("\t\t최대 소요시간(분): ");
		int deliveryh2 = sc.nextInt();
		if(deliveryh<deliveryh2) {
			return String.format("%d■%d",deliveryh,deliveryh2);
		}else {
			return String.format("%d■%d",deliveryh2,deliveryh);
		}
	}

	/**
	 * 배달비를 입력받기위한 화면출력,입력 메소드
	 * 배달비를 int amount값으로 입력받아 유효성검사후 return 값반환
	 * 
	 * @see java.util.Scanner
	 * 
	 * @return true:  String.format("%d",amount) false : null;   
	 */
	public static String deliveryAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t배달비(3000): ");
		int amount = sc.nextInt();
		if(amount>=0) {
			return String.format("%d",amount);
		}
		return null;
	}

	/**
	 * 배달최소금액을 입력받기위한 화면출력,입력 메소드
	 * 배달최소금액을 int amount값으로 입력받아 유효성검사후 return 값반환
	 * 
	 * @see java.util.Scanner
	 * 
	 * @return true:  String.format("%d",amount) false : null;  
	 */
	public static String amountCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t최소주문비용(13000): ");
		int amount = sc.nextInt();
		if(amount>=0) {
			return String.format("%d",amount);
		}
		
		return null;
	}

	/**
	 * 배달가능지역 입력받기위한 화면출력,입력 메소드
	 * 배달가능지역을 String adr로 입력받아 유효성 검사(00구) 진행후 입력받은 지역들을 ,구분자로 구분하여 return [000구,00구,00구]
	 * 
	 * @see java.util.Scanner
	 * @see java.util.regex.Pattern
	 * @see java.util.regex.Matcher
	 * 
	 * @return String.format("[%s]",result);
	 */
	public static String deliveryAddressCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t배달가능주소(OO구): ");
		String adr = sc.nextLine();
		String regex ="[가-힣]+(구){1,5}";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(adr);
		
		String[] adress = adr.split("구");
		for(int i=0; i<adress.length; i++) {
			if(i<adress.length-1) {
					adress[i] = String.format("%s%s", adress[i].trim(),"구, ");
			}else if(i == adress.length-1) {
				adress[i] = String.format("%s%s", adress[i].trim(),"구");
			}
			
		}
		String result = "";
		for(int j=0; j<adress.length; j++) {
				result += adress[j].trim();	
		}
		
		return String.format("[%s]",result);
	}
						
	/**
	 * 점포데이터를 수정하는 메소드
	 * 매개변수String배열로 점포데이터,변경할 점포데이터를 받아 점포리스트에서 기존점포데이터와 동일한 점포데이터를 찾아 찾으면 변경할 점포데이터로 변경
	 * 
	 * @see java.io.BufferedReader
	 * @see java.io.FileReader
	 * @see java.io.BufferedWriter
	 * @see java.io.FileWriter
	 * 
	 * @param info : 기존 점포 데이터
	 * @param result : 변경할 점포 데이터
	 */
	public static void change(String[] info,String[] result) {
		  
		     //edit
		
	
		     //USER > 
		 
		     try {
		    	 String line = null;
		    	 int count = 0;
		    	 BufferedReader reader = new BufferedReader(new FileReader(STORE));
				  	while((line=reader.readLine())!=null){
					  count++;
				  	}
				  	String[] list = new String[count];
				  	reader = new BufferedReader(new FileReader(STORE));
				  	count = 0;
				  	line = null;
				  	while ((line = reader.readLine()) != null) {
		           
				  		list[count] = line;
				  		String[] AA = line.split("■");
				  		count++;
				  		if (AA[0].equals(info[0])) {
    	   
		        	   list[count] = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s■%s■%s%s\r\n", result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7], result[8], result[9], result[10],result[11]);
		           } 
		           
		        }

		        reader.close();
		        
		        BufferedWriter writer = new BufferedWriter(new FileWriter(STORE));
		        String data="";
		        
			  	for(int i=0; i<list.length; i++) {
			  		data += String.format("%s\n", list[i]);
			  	}
			  	
		        writer.write(data);
		        writer.flush();
		        writer.close();
		    
		     } catch (Exception e) {
		        e.printStackTrace();
		     }

		  }

	/**
	 * 점주데이터를 수정하는 메소드
	 * 변경할 데이터 선택화면출력,변경 데이터입력, 데이터변경 메소드
	 * 데이터를 입력받아 TXT파일을 BufferedReader로 확인후 점주데이터가 일치하면 BufferedWroter를 사용하여 점주데이터를 변경
	 * 변경완료후 이전화면으로 이동하는 선택화면출력후 데이터를 입력받아 화면이동
	 * 
	 * @see java.util.Scanner
	 * @see java.io.BufferedReader
	 * @see java.io.FileReader
	 * @see java.io.BufferedWriter
	 * @see java.io.FileWriter
	 * 
	 * 
	 */
	public static void storekeeperChange() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STOREKEEPER));
			String result = "";
			String line = null;

			System.out.println("\t\t1.비밀번호 변경\t2.전화번호 변경");
			System.out.println("\t\t3.사업자등록번호 변경");
			Scanner sc = new Scanner(System.in);
			System.out.print("\t\t입력: ");
			String a = sc.nextLine();
				
			if(a.equals("1")) {//비밀번호변경
				while((line = reader.readLine())!=null) {
					String[] re = line.split("■");
					if(re[0].equals(Login.storekeeper[0])) {
						String pw = Validation.PasswordCheck();
				
						Login.storekeeper[1] = pw;
				
						result += String.format("%s■%s■%s■%s■%s■%s■%s\n",Login.storekeeper[0], Login.storekeeper[1],Login.storekeeper[2],Login.storekeeper[3],Login.storekeeper[4],Login.storekeeper[5],Login.storekeeper[6]);
		
					}else {
						result += line+"\n";
					}
				}
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(STOREKEEPER));
				writer.write(result);
				writer.flush();
				System.out.println("\t\t수정완료! ");
				System.out.print("\t============================================\n");
				System.out.println("\t\t1.이전화면 2. 메인화면  3.종료");
				System.out.println("\t\t입력: ");
				a = sc.nextLine();
				
				if(a.equals("1")){
					StorekeeperScreen.storekeeperScreen();
				}else if(a.equals("2")) {
					Main.main(null);
				}else if(a.equals("3")) {
					System.exit(0);
				}
					
			} else if(a.equals("2")) {//전화번호변경
				while((line = reader.readLine())!=null) {
					String[] re = line.split("■");
					if(re[0].equals(Login.storekeeper[0])) {
						String pw = Validation.TelCheck();
			
						Login.storekeeper[3] = pw;
			
						result += String.format("%s■%s■%s■%s■%s■%s■%s\n",Login.storekeeper[0], Login.storekeeper[1],Login.storekeeper[2],Login.storekeeper[3],Login.storekeeper[4],Login.storekeeper[5],Login.storekeeper[6]);
		
					}else {
						result += line+"\n";
					}
				}
	
				BufferedWriter writer = new BufferedWriter(new FileWriter(STOREKEEPER));
				writer.write(result);
				writer.flush();
				System.out.println("\t\t수정완료! ");
				System.out.print("\t============================================\n");
				System.out.println("\t\t1.이전화면 2. 메인화면  3.종료");
				System.out.println("\t\t입력: ");
				a = sc.nextLine();
				
				if(a.equals("1")){
					StorekeeperScreen.storekeeperScreen();
				}else if(a.equals("2")) {
					Main.main(null);
				}else if(a.equals("3")) {
					System.exit(0);
				}
			} else if(a.equals("3")) {//사업자등록번호수정
				while((line = reader.readLine())!=null) {
					String[] re = line.split("■");
					if(re[0].equals(Login.storekeeper[0])) {
						String pw = Validation.BusinessNumberCheck();
			
						Login.storekeeper[6] = pw;
			
						result += String.format("%s■%s■%s■%s■%s■%s■%s\n",Login.storekeeper[0], Login.storekeeper[1],Login.storekeeper[2],Login.storekeeper[3],Login.storekeeper[4],Login.storekeeper[5],Login.storekeeper[6]);
		
					}else {
						result += line+"\n";
					}
				}
			
				BufferedWriter writer = new BufferedWriter(new FileWriter(STOREKEEPER));
				writer.write(result);
				writer.flush();
				System.out.print("\t============================================\n");
				System.out.println("\t\t1.이전화면 2. 메인화면  3.종료");
				System.out.println("\t\t입력: ");
				a = sc.nextLine();
				
				if(a.equals("1")){
					StorekeeperScreen.storekeeperScreen();
				}else if(a.equals("2")) {
					Main.main(null);
				}else if(a.equals("3")) {
					System.exit(0);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	/**
	 * 회원탈퇴 메소드
	 * 로그인 되어있는 점주 데이터를 입력받아 TXT파일을 BufferedReader로 확인후 점주데이터가 일치하면 BufferedWroter를 사용하여 점주데이터를 삭제
	 * 변경완료후 이전화면으로 이동하는 선택화면출력후 데이터를 입력받아 화면이동
	 * 
	 * 
	 */
	public static void delete() {
		System.out.println("\t\t정말 회원 탈퇴 하시겠습니까?y/n");
		System.out.print("\t\t입력: ");
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		if(a.equals("y")) {
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(STOREKEEPER));
				String result = "";
				String line = null;

				while((line = reader.readLine())!=null) {
					String[] re = line.split("■");
					
					if(re[0].equals(Login.storekeeper[0])) {
						String pw = "  ";
						for(int i=0; i<Login.storekeeper.length; i++) {
							Login.storekeeper[i] = pw;
						}
						
					}else {
						result += line+"\n";		
					}
				}			
						
				BufferedWriter writer = new BufferedWriter(new FileWriter(STOREKEEPER));
				writer.write(result);
				writer.flush();
				
				System.out.println("\t\t4삭제완료! ");
				System.out.println("\t============================================");
				System.out.print("\t============================================\n");
				System.out.println("\t\t1.이전화면 2. 메인화면  3.종료");
				System.out.println("\t\t입력: ");
				a = sc.nextLine();
				if(a.equals("1")){
					StorekeeperScreen.storekeeperScreen();
				}else if(a.equals("2")) {
					Main.main(null);
				}else if(a.equals("3")) {
					System.exit(0);
				}
						
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(a.equals("n")) {
			
		}
	}

	public static void storeChange() {
		 
		String BusinessNumber = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STORE));
			String result = "";
			String line = null;

			System.out.println("\t\t1.점포수정");
		
			Scanner sc = new Scanner(System.in);
			
			System.out.print("\t\t입력: ");
			String a = sc.nextLine();
				
			if(a.equals("1")) {
				while((line = reader.readLine())!=null) {
					
					String[] re = line.split("■");
					if(re[0].equals(Login.storekeeper[6])) {
							
						BusinessNumber = BusinessNumberCheck();
						String name = NameCheck();
						System.out.print("\t\t상호명: ");
						String name2 = sc.nextLine();
						String address = addressCheck();
						String category = categoryCheck();
						//평점
						String deliveryTime = deliveryH();//2개
						String[] time = deliveryTime.split("■");
						String deliveryAmount = deliveryAmount();
						String deliveryIeast = amountCheck();
						String deliveryaddress = deliveryAddressCheck();

						result += String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s■%s■%s\n",BusinessNumber,name,name2,address,category,re[5],time[0],time[1],deliveryAmount,deliveryIeast,deliveryaddress);
				
					} else {
						result += line+"\n";
					}
				}
				
				String line2 = null;
				BufferedReader reader1 = new BufferedReader(new FileReader(STOREKEEPER));
				String result1 = "";
				
				while((line2 = reader1.readLine())!=null) {
					String[] re = line2.split("■");
					if(re[0].equals(Login.storekeeper[6])) {
				
						Login.storekeeper[6] = BusinessNumber;
				
						result1 += String.format("%s■%s■%s■%s■%s■%s■%s\n",Login.storekeeper[0], Login.storekeeper[1],Login.storekeeper[2],Login.storekeeper[3],Login.storekeeper[4],Login.storekeeper[5],Login.storekeeper[6]);
			
					}else {
					result1 += line2+"\n";
					}
				}
					
				BufferedWriter writer1 = new BufferedWriter(new FileWriter(STOREKEEPER));
				writer1.write(result1);
				writer1.flush();
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(STORE));
				writer.write(result);
				writer.flush();
				
				System.out.println();
				System.out.println("수정 완료! ");
				System.out.println("\t====================================================================");
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\t\t1.이전화면 2.메인화면 3.종료");
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		
		if(a.equals("1")) {
			StorekeeperScreen.storekeeperScreen();
		}else if(a.equals("2")) {
			Main.main(null);
		}else if(a.equals("3")) {
			System.exit(0);
		}
			
	}
}
	

//아이디 : 영문자숫자 2~10글자 0
//비밀번호: 영문자숫자특수문자들 최소 1글자 이상씩 2~15글자 0 
//나이 0< 150 0 
//성별 > 남 여  0
//이름 2글자~5글자  한글 0
//사업자번호 530-29-14581 2  
//닉네임 1글자 ~10글자
