package com.test.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import com.test.project.Ui;

public class AdminMemberManage {

	final static String USER = "C:\\class\\code\\java\\DeliveryService\\dat\\회원정보.txt";

	public static void memberManage() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽회원관리");
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.회원조회   2.회원수정   3.회원삭제   0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		String input = scan.nextLine();

		if (input.equals("1")) {
			memberCheck();
		} else if (input.equals("2")) {
			memberChange();
		} else if (input.equals("3")) {
			memberDelete();
		} else if (input.equals("0")) {
			Ui.mainUi();
		}
	}

	public static void adminMMM() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽회원조회");
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.회원리스트조회   2.회원검색   3.이전페이지   0.메인페이지 ");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		String input = scan.nextLine();

		if (input.equals("1")) {
			memberCheck();
		} else if (input.equals("2")) {
			memberSearch();
		} else if (input.equals("3")) {
			memberManage();
		} else if (input.equals("0")) {
			Ui.mainUi();
		}

	}

	public static void memberCheck() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽회원리스트조회");
		System.out.println();
		System.out.println();
		System.out.println("[아이디]\t\t[비밀번호]\t[나이]\t[전화번호]\t\t[성별]\t[이름]\t[주소]\t\t\t\t\t[주문수]\t\t[등급]\t\t[닉네임]\t\t[포인트]");
		System.out.println("\t\t" + memberList());
		System.out.println();
		System.out.println();
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		String input = scan.nextLine();

		if (input.equals("1")) {
			memberManage();
		} else if (input.equals("0")) {
			Ui.mainUi();
		}
	}

	public static String memberList() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));

			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%-30s\t%s\t\t%-15s\t%s\t%s\n", temp[0], temp[1], temp[2],
						temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void memberSearch() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽회원검색");
		System.out.println();
		System.out.print("\t\t회원 아이디 : ");
		String input = scan.nextLine();
		System.out.println();
		System.out.println();
		System.out.println("\t\t해당 회원 정보 : ");
		System.out.println("\t\t" + search(input));
		System.out.println();
		System.out.println();
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		if (input.equals("1")) {
			adminMMM();

		} else if (input.equals("0")) {
			Ui.mainUi();
		}
	}

	public static String search(String input) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if (temp[0].equals(input)) {
					System.out.println(
							"[아이디]\t[비밀번호]\t[나이]\t[전화번호]\t[성별]\t[이름]\t[주소]\t\t\t\t\t\t[주문수]\t[등급]\t\t[닉네임]\t[포인트]");
					System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%-30s\t%s\t\t%-15s\t%s\t%s\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	

	public static void memberChange() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽회원수정");
		System.out.println();
		System.out.println();
		System.out.print("\t\t수정할 회원 아이디 : ");
		String input = scan.nextLine();
		System.out.println();
		System.out.println();

		String[] info = search2(input);

		System.out.println("\t\t해당 회원 정보 : ");
		System.out.println("\t\t" + Arrays.toString(info));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.아이디  2.비밀번호  3.나이  4.전화번호  5.성별  6.이름");
		System.out.println("\t\t 7.주소  8.주문수  9.등급  10.닉네임  11.포인트");
		System.out.println();
		System.out.print("\t\t수정할 정보의 번호 입력 : ");
		String num = scan.nextLine();
		System.out.println();
		System.out.print("\t\t수정 내용 입력: ");
		String content = scan.nextLine();
		System.out.println();
		change(info, num, content);
		System.out.println("\t\t수정 결과: ");
		System.out.println("\t\t" + Arrays.toString(info));
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();

	}

	public static String[] search2(String input) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if (temp[0].equals(input)) {
					return temp;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	private static void change(String[] info, String num, String content) {

		//edit
		info[Integer.parseInt(num) - 1] = content;
		
		
		//USER > 
		String userData = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USER));
			String line = null;
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split("■");
				
				if (temp[0].equals(info[0])) {
					
					userData += String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s■%s■%s\r\n", info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9], info[10]);
					
				} else {
					
					userData += line + "\r\n";
					
				}				
				
			}
			reader.close();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(USER));
			
			writer.write(userData);
			
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void memberDelete() {
		
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽회원삭제");
		System.out.println();

		System.out.print("\t\t삭제할 회원 아이디 : ");
		String input = scan.nextLine();
		delete(input);
		System.out.println();
		System.out.println();
		System.out.println("\t삭제되었습니다. : ");
		System.out.println();
		System.out.println("\t\t회원 리스트 : ");
		memberList();
		System.out.println();
		System.out.println();
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		
		if (input.equals("1")) {
			memberManage();
		} else if(input.equals("0")) {
			Ui.mainUi();
		}
		
	}
	
	private static void delete(String input) {
		try {
			// 기존 파일을 읽기 전용으로 열기
			BufferedReader reader = new BufferedReader(new FileReader(USER));
			List<String> lines = new ArrayList<>();
			String line;

			// 파파일의 모든 라인을 메모리에 적재
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();

			// 삭제할 라인을 찾아서 제거
			for (int i = 0; i < lines.size(); i++) {
				String[] fields = lines.get(i).split("■");
	            if (fields[0].equals(input)) {
	                lines.remove(i);
	                break;
	            }
			}
	        // 수정된 내용으로 파일을 다시 씀
	        BufferedWriter writer = new BufferedWriter(new FileWriter(USER));
	        for (String modifiedLine : lines) {
	            writer.write(modifiedLine);
	            writer.newLine();
	        }
	        writer.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}//
