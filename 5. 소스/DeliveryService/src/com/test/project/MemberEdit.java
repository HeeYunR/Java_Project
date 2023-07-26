package com.test.project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberEdit {

	private static String id;
	private static String pw;
	private static String email;
	private static String age;
	private static String phoneNum;
	private static String gender;
	private static String name;
	private static String address;
	private static String nickname;

	public MemberEdit(String id, String pw, String email, String age, String phoneNum, String gender, String name,
			String address, String nickname) {
		MemberEdit.id = id;
		MemberEdit.pw = pw;
		MemberEdit.email = email;
		MemberEdit.age = age;
		MemberEdit.phoneNum = phoneNum;
		MemberEdit.gender = gender;
		MemberEdit.name = name;
		MemberEdit.address = address;
		MemberEdit.nickname = nickname;
	}

	private final static String MEMBERINFO = "C:\\class\\code\\java\\DeliveryService\\dat\\normalmem.txt";

	public static void memberBfedit(String chkUid) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
			MemberEdit m = new MemberEdit(id, pw, email, age, phoneNum, gender, name, address, nickname);
			String line;

			while ((line = reader.readLine()) != null) {
				String[] check = line.split("■");
				if (chkUid.equals(check[0])) {
					m = new MemberEdit(check[0], check[1], check[2], check[3], check[4], check[5], check[6], check[7],
							check[8]);
					m.showBfedit();
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void showBfedit() {
		System.out.println("\t===============변경전 회원정보====================");
		System.out.println("\t\t0.모든 정보 변경(아이디 제외)");
		System.out.println("\t\t1.아이디(ID는 변경 불가합니다: " + MemberEdit.id);
		System.out.println("\t\t2.비밀번호: " + MemberEdit.pw);
		System.out.println("\t\t3.이메일: " + MemberEdit.email);
		System.out.println("\t\t4.나이: " + MemberEdit.age);
		System.out.println("\t\t5.전화번호: " + MemberEdit.phoneNum);
		System.out.println("\t\t6.성별: " + MemberEdit.gender);
		System.out.println("\t\t7.이름: " + MemberEdit.name);
		System.out.println("\t\t8.주소: " + MemberEdit.address);
		System.out.println("\t\t9.닉네임: " + MemberEdit.nickname);
		System.out.println("\t============================================");
	}

	public static void pwEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t비밀번호는 필수입력, '숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호는 8~16자 이내로 입력하세요.");
		System.out.print("\t\t      비밀번호: ");
		// 정규식을 이용하여 모든 문자열의 공백 제거
		String pw = sc.nextLine().replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 비밀번호 형식에 올맞게 작성하게끔 설정
		regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(pw);

		// 비밀번호 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 비밀번호 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.pwEdit(chkUid);
		}
		
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		                user[1] = pw; // 비밀번호 정보를 수정
		                line = String.join("■", user);
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========비밀번호 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
		
		
	}

	public static void emailEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체

		System.out.println("\t이메일은 필수입력, 형식에 알맞게 작성하세요(aaa@aaa.XXX).");
		System.out.print("\t\t      이메일: ");

		// 정규식을 이용하여 모든 문자열의 공백 제거
		String email = sc.nextLine().replaceAll("\\p{Z}", "");

		// 정규식을 이용하여 이메일 형식에 알맞게 작성하게끔 설정
		regex = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(email);

		// 이메일 형식이 맞지 않을 때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 이메일 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.emailEdit(chkUid);
		}

		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		            if (user[2].equals(email)) {
		                System.out.println("\t중복된 이메일입니다. 다시 입력해주세요.");
		                Ui.pause();
		                MemberEdit.emailEdit(chkUid); // 중복된 이메일인 경우, 재입력을 요청
		            } else {
		                user[2] = email; // email 정보를 수정
		                line = String.join("■", user);
		            }
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========이메일 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
	}

	public static void ageEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t세자리 이내, 숫자로 입력하세요.");
		System.out.print("\t\t      나이: ");
		// 정규식을 이용하여 모든 문자열의 공백 제거
		String age = sc.nextLine().replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 나이 형식에 알맞게 작성하게끔 설정
		regex = "^[0-9]{1,3}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(age); // 입력값을 대상으로 정규식 검사

		// 나이 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 나이 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.ageEdit(chkUid);
		}
		
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		                user[3] = age; // 나이 정보를 수정
		                line = String.join("■", user);
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========나이 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
	}

	public static void phoneEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t전화번호 형식은 010XXXXXXXX 이나 010-XXXX-XXXX로 입력하세요.");
		System.out.print("\t\t      전화번호: ");
		// 문자열에 -들어가는 부분 모두 제거, 모든 문자열의 공백제거
		String phoneNum = sc.nextLine().replaceAll("-", "").replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 전화번호 형식에 알맞게 작성하게끔 설정
		regex = "^010[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(phoneNum);

		// 전화번호 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 전화번호 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.phoneEdit(chkUid);
		}

		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		            if (user[4].equals(phoneNum)) {
		                System.out.println("\t중복된 전화번호 입니다. 다시 입력해주세요.");
		                Ui.pause();
		                MemberEdit.phoneEdit(chkUid); // 중복된 이메일인 경우, 재입력을 요청
		            } else {
		                user[4] = phoneNum; // 전화번호 정보를 수정
		                line = String.join("■", user);
		            }
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========전화번호 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
	}
		

	

	public static void genderEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t성별 형식 '남자'나 '여자'만 입력하세요.");
		System.out.print("\t\t      성별(남자/여자): ");
		// 모든 문자열의 공백제거
		String gender = sc.nextLine().replaceAll("\\p{Z}", "");

		// 성별 형식에 알맞지 않게 작성할 경우 if문 실행
		if (!(gender.equals("남자") || gender.equals("여자"))) {
			System.out.println("\t잘못된 성별 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.genderEdit(chkUid);
		}
		
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		                user[5] = gender; // 성별 정보를 수정
		                line = String.join("■", user);
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========성별 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
	}

	public static void nameEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t이름은 필수입력, 한글, 2~5자 이내로 입력하세요.");
		System.out.print("\t\t      이름: ");
		// 모든 문자열의 공백제거
		String name = sc.nextLine().replaceAll("\\p{Z}", "");

		// 이름 형식에 알맞게 작성하게끔 설정
		regex = "^[가-힣]{2,5}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(name);

		// 이름 형식에 알맞지 않게 작성할 경우 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 이름 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.nameEdit(chkUid);
		}

		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		                user[6] = name; // 이름 정보를 수정
		                line = String.join("■", user);
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========이름 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
	}

	public static void addressEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t주소는 필수입력, 서울시 OO구 OO동 OO아파트 O동OOO호 형식으로 입력하세요.");
		System.out.print("\t\t      주소: ");
		// 모든 문자열 공백 제거
		String address = sc.nextLine().replaceAll("\\p{Z}", "");

		// 주소를 "서울시" + "구" + "동" + "OO아파트" + "O동" + "호" 형식으로 작성하게 설정
		regex = "서울시\\s*\\S+구\\s*\\S+동\\s*\\S+아파트\\s*\\d+동\\s*\\d+호";

		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(address);

		// 형식에 맞지 않을경우 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 주소 형식입니다, 다시 입력해주세요");
			Ui.pause();
			MemberEdit.addressEdit(chkUid);
		}
		
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		                user[7] = address; // 주소 정보를 수정
		                line = String.join("■", user);
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========주소 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();

	}

	public static void nickEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t닉네임은 필수입력, 한글, 1~10자 이내로 입력하세요.");
		System.out.print("\t\t      닉네임: ");
		// 모든 공백문자 제거
		String nickname = sc.nextLine().replaceAll("\\p{Z}", "");
		// 닉네임 형식에 맞게 작성하도록 설정
		regex = "^[가-힣]{1,10}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(nickname); // 입력값을 대상으로 정규식 검사

		// 맞지 않을경우 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 닉네임 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.nickEdit(chkUid);
		}

		try {
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    ArrayList<String> editmem = new ArrayList<String>();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        String[] user = line.split("■");
		        if (chkUid.equals(user[0])) {
		            // 현재 유저를 찾았을 때
		            if (user[8].equals(nickname)) {
		                System.out.println("\t중복된 닉네임 입니다. 다시 입력해주세요.");
		                Ui.pause();
		                MemberEdit.nickEdit(chkUid); // 중복된 닉네임인 경우, 재입력을 요청
		            } else {
		                user[8] = nickname; // 닉네임 정보를 수정
		                line = String.join("■", user);
		            }
		        }
		        editmem.add(line);
		    }
		    reader.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO));
		    for (String editline : editmem) {
		        writer.write(editline);
		        writer.newLine();
		    }

		    writer.close();
		} catch (Exception e) {
		    // TODO: handle exception
		}
		System.out.println("\t==========닉네임 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();

	}

	public static void allEdit(String chkUid) {
		Scanner sc = new Scanner(System.in);
		String regex = ""; // 정규식
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 결과 객체
		System.out.println("\t비밀번호는 필수입력, '숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호는 8~16자 이내로 입력하세요.");
		System.out.print("\t\t      비밀번호: ");
		// 정규식을 이용하여 모든 문자열의 공백 제거
		String pw = sc.nextLine().replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 비밀번호 형식에 올맞게 작성하게끔 설정
		regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(pw);

		// 비밀번호 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 비밀번호 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		System.out.println("\t이메일은 필수입력, 형식에 알맞게 작성하세요(aaa@aaa.XXX).");
		System.out.print("\t\t      이메일: ");
		// 정규식을 이용하여 모든 문자열의 공백 제거
		String email = sc.nextLine().replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 이메일 형식에 알맞게 작성하게끔 설정
		regex = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(email);

		// 이메일 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 이메일 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		try {
			// 버퍼드리더로 NORMALMEM 파일을 읽습니다.
			BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
			String line;
			// while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
			while ((line = reader.readLine()) != null) {
				// 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
				String[] userInfo = line.split("■");
				String registEmail = userInfo[2];
				// 스캐너로 입력받은 이메일과 비교하여 중복되는 이메일이 있는지 확인합니다.
				if (registEmail.equals(email)) {
					System.out.println("\t중복된 이메일 입니다. 다른 이메일을 입력해주세요.");
					Ui.pause();
					MemberEdit.allEdit(chkUid);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\t세자리 이내, 숫자로 입력하세요.");
		System.out.print("\t\t      나이: ");
		// 정규식을 이용하여 모든 문자열의 공백 제거
		String age = sc.nextLine().replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 나이 형식에 알맞게 작성하게끔 설정
		regex = "^[0-9]{1,3}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(age); // 입력값을 대상으로 정규식 검사

		// 나이 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 나이 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		System.out.println("\t전화번호 형식은 010XXXXXXXX 이나 010-XXXX-XXXX로 입력하세요.");
		System.out.print("\t\t      전화번호: ");
		// 문자열에 -들어가는 부분 모두 제거, 모든 문자열의 공백제거
		String phoneNum = sc.nextLine().replaceAll("-", "").replaceAll("\\p{Z}", "");
		// 정규식을 이용하여 전화번호 형식에 알맞게 작성하게끔 설정
		regex = "^010[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(phoneNum);

		// 전화번호 형식이 맞지 않을때 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 전화번호 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		try {
			// 버퍼드리더로 NORMALMEM 파일을 읽습니다.
			BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
			String line;
			// while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
			while ((line = reader.readLine()) != null) {
				// 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
				String[] userInfo = line.split("■");
				String registPhone = userInfo[4];
				// 스캐너로 입력받은 전화번호와 비교하여 중복되는 전화번호가 있는지 확인합니다.
				if (registPhone.equals(phoneNum)) {
					System.out.println("\t중복된 전화번호 입니다. 다른 전화번호를 입력해주세요.");
					Ui.pause();
					MemberEdit.allEdit(chkUid);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\t성별 형식 '남자'나 '여자'만 입력하세요.");
		System.out.print("\t\t      성별(남자/여자): ");
		// 모든 문자열의 공백제거
		String gender = sc.nextLine().replaceAll("\\p{Z}", "");

		// 성별 형식에 알맞지 않게 작성할 경우 if문 실행
		if (!(gender.equals("남자") || gender.equals("여자"))) {
			System.out.println("\t잘못된 성별 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		System.out.println("\t이름은 필수입력, 한글, 2~5자 이내로 입력하세요.");
		System.out.print("\t\t      이름: ");
		// 모든 문자열의 공백제거
		String name = sc.nextLine().replaceAll("\\p{Z}", "");

		// 이름 형식에 알맞게 작성하게끔 설정
		regex = "^[가-힣]{2,5}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(name);

		// 이름 형식에 알맞지 않게 작성할 경우 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 이름 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		System.out.println("\t주소는 필수입력, 서울시 OO구 OO동 OO아파트 O동OOO호 형식으로 입력하세요.");
		System.out.print("\t\t      주소: ");
		// 모든 문자열 공백 제거
		String address = sc.nextLine().replaceAll("\\p{Z}", "");

		// 주소를 "서울시" + "구" + "동" + "OO아파트" + "O동" + "호" 형식으로 작성하게 설정
		regex = "서울시\\s*\\S+구\\s*\\S+동\\s*\\S+아파트\\s*\\d+동\\s*\\d+호";

		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(address);

		// 형식에 맞지 않을경우 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 주소 형식입니다, 다시 입력해주세요");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		System.out.println("\t닉네임은 필수입력, 한글, 1~10자 이내로 입력하세요.");
		System.out.print("\t\t      닉네임: ");
		// 모든 공백문자 제거
		String nickname = sc.nextLine().replaceAll("\\p{Z}", "");
		// 닉네임 형식에 맞게 작성하도록 설정
		regex = "^[가-힣]{1,10}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(nickname); // 입력값을 대상으로 정규식 검사

		// 맞지 않을경우 if문 실행
		if (!matcher.find()) {
			System.out.println("\t잘못된 닉네임 형식입니다, 다시 입력해주세요.");
			Ui.pause();
			MemberEdit.allEdit(chkUid);
		}

		try {
			// 버퍼드리더로 NORMALMEM 파일을 읽습니다.
			BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
			String line;
			// while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
			while ((line = reader.readLine()) != null) {
				// 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
				String[] userInfo = line.split("■");
				String registNick = userInfo[8];
				// 스캐너로 입력받은 닉네임과 비교하여 중복되는 닉네임이 있는지 확인합니다.
				if (registNick.equals(nickname)) {
					System.out.println("\t중복된 닉네임 입니다. 다른 닉네임을 입력해주세요.");
					Ui.pause();
					MemberEdit.allEdit(chkUid);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		    // 버퍼드리더로 NORMALMEM 파일을 읽습니다.
		    BufferedReader reader = new BufferedReader(new FileReader(MEMBERINFO));
		    String line;
		    // 새로운 정보를 담을 리스트 생성
		    List<String> newInfoList = new ArrayList<>();
		    // while문을 이용하여 버퍼드리더로 한 줄씩 읽어오면서 검사를 진행합니다.
		    while ((line = reader.readLine()) != null) {
		        // 버퍼드리더로 읽어온 값을 쉼표로 구분하여 배열에 저장합니다.
		        String[] userInfo = line.split("■");
		        // 기존 정보와 수정할 정보의 id가 일치하는 경우
		        if (userInfo[0].equals(chkUid)) {
		            // 수정된 정보를 배열에 저장합니다.
		            String[] newUserInfo = {chkUid, pw, email, age, phoneNum, gender, name, address, nickname};
		            // 수정된 정보를 문자열로 변환합니다.
		            String newLine = String.join("■", newUserInfo);
		            // 새로운 정보 리스트에 추가합니다.
		            newInfoList.add(newLine);
		        } else {
		            // 기존 정보를 리스트에 추가합니다.
		            newInfoList.add(line);
		        }
		    }
		    reader.close();
		    
		    // 버퍼드라이터를 이용하여 파일에 새로운 정보를 기록합니다.
		    BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERINFO, false));
		    for (String newLine : newInfoList) {
		        writer.write(newLine + "\n");
		    }
		    writer.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("\t==========모든 정보 수정 완료!==============");
		Ui.pause();
		Ui.mainUi();
		sc.nextLine();
	}

}
