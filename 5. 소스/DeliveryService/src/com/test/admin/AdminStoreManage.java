package com.test.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.test.project.Ui;

/**
 * 
 * @author 유희윤
 * 
 * @see java.io.BufferedReader
 * @see java.io.BufferedWriter
 * @see java.io.FileReader
 * @see java.io.FileWriter
 * @see java.util.Scanner
 *
 */
public class AdminStoreManage {

	final static String STORE = "C:\\class\\code\\java\\DeliveryService\\dat\\점포.txt";
	
	/**
	    * 점포조회, 점포수정, 점포삭제, UI,mainUI의 해당 메소드로 이동하는 메소드
	    * 
	    * @see#adminSMM()
	    * @see#storeChange()
	    * @see#storeDelete()
	    * @see UI.mainUi()
	    */
	public static void storeManage() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t▽점포관리");
		System.out.println();
		System.out.println();
		System.out.print("\t\t1.점포조회  2.점포수정  3.점포삭제  0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			adminSMM();
		} else if(input.equals("2")) {
			storeChange();
		} else if(input.equals("3")) {
			storeDelete();
		} else if(input.equals("0")) {
			Ui.mainUi();
		}
		
	}
	
	/**
	    * 점포리스트 조회, 점포 검색의 해당 메소드로 이동하는 메소드
	    * 
	    * @see#storeCheck()
	    * @see#storeSearch()
	    * @see#storeMange()
	    * @see UI.mainUI()
	    */
	public static void adminSMM() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽점포조회");
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.점포리스트조회   2.점포검색   3.이전페이지   0.메인페이지 ");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		String input = scan.nextLine();

		if (input.equals("1")) {
			storeCheck();
		} else if (input.equals("2")) {
			storeSearch();
		} else if (input.equals("3")) {
			storeManage();
		} else if (input.equals("0")) {
			Ui.mainUi();
		}

	}

	/**
	    * 점포리스트를 조회한 결과를 보여주는 메소드
	    * 
	    * @see #storeList()
	    * @see#adminSMM()
	    * @see UI.mainUI()
	    */
	public static void storeCheck() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽점포리스트조회");
		System.out.println();
		System.out.println();
		System.out.println("[사업자등록번호][사업자명][상호명]\t[주소]\t\t\t\t[분류]\t\t[평점][배달최소시간][배달최대시간][기본배달비][최소배달금액][배달가능지역]");
		System.out.println("\t\t" + storeList());
		System.out.println();
		System.out.println();
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		String input = scan.nextLine();

		if (input.equals("1")) {
			adminSMM();

		} else if (input.equals("0")) {
			Ui.mainUi();
		}
	}

	/**
	    * 데이터파일에서 점포 리스트를 찾아주는 메소드
	    * STORE파일에서 점포 정보를 읽어와 각 점포의 정보를 출력한다.
	    * 
	    * @see java.io.BufferedReader
	    * @see java.io.FileReader
	    * @return 빈문자열
	    */
	public static String storeList() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STORE));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				System.out.printf("%s\t%-3s\t%-8s\t%s\t%-10s\t%s\t%-10s\t%s\t%-10s\t%-10s\t%s\n", temp[0], temp[1], temp[2],
						temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	    * 사용자가 사업자등록번호를 입력하여 점포 정보를 검색할 수 있는 기능을 제공
	    * 사용자로부터 사업자등록번호를 입력받은 후, 해당하는 점포 정보를 출력
	    * 사용자는 이전페이지로 돌아가거나 메인페이지로 돌아갈 수 있다.
	    * Scanner 객체를 이용하여 사업자등록번호를 String 값으로 입력받음
	    * 
	    *  @see#search(input)
	    *  @see#adminSMM()
	    *  @see UI.mainUI()
	    */
	public static void storeSearch() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽점포검색");
		System.out.println();
		System.out.print("\t\t사업자등록번호 : ");
		String input = scan.nextLine();
		System.out.println();
		System.out.println();
		System.out.println("\t\t해당 점포 정보 : ");
		System.out.println("\t\t" + search(input));
		System.out.println();
		System.out.println();
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		if (input.equals("1")) {
			adminSMM();

		} else if (input.equals("0")) {
			Ui.mainUi();
		}
	}

	/**
	    * 전달받은 사업자등록번호를 이용하여 STORE파일에서 해당하는 점포 정보를 검색하는 기능을 제공
	    * STORE 파일을 한 줄씩 읽어와서 사업자등록번호가 일치하는 점포정보를 풀력
	    * 
	    * @see java.io.BufferedReader
	    * @see java.io.FileReader
	    * 
	    * @param input 검색하고자하는 사업자등록번호
	    * @return 빈문자열
	    */
	public static String search(String input) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(STORE));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if (temp[0].equals(input)) {
					System.out.println(
							"[사업자등록번호][사업자명][상호명]\t\t[주소]\t\t\t[분류]\t[평점][배달최소시간][배달최대시간][기본배달비][최소배달금액][배달가능지역]");
					System.out.printf("%s\t%-3s\t%-8s\t%s\t%-10s\t%s\t%-10s\t%s\t%-10s\t%-10s\t%s\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	    * 사용자로부터 입력받은 점포의 정보를 수정하는 메소드
	    * 수정하고자하는 점포의 해당 사업자등록번호를 입력받아, 해당 점포의 데이터파일을 불러온다.
	    * 해당 점포의 정보의 수정할 정보의 번호와 내용을 입력받아 수정, 결과를 출력한다.
	    * Scanner 객체를 이용하여 사업자등록번호, 점포 정보의 번호, 수정내용을 String 값으로 입력받음
	    * 
	    * @see#search2(input)
	    * @see#change(info, num, content)
	    * @see#storeManage()
	    * @see#UI.mainUi()
	    * 
	    */
	public static void storeChange() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽점포수정");
		System.out.println();
		System.out.println();
		System.out.print("\t\t수정할 점포 사업자등록번호 : ");
		String input = scan.nextLine();
		System.out.println();
		System.out.println();

		String[] info = search2(input);

		System.out.println("\t\t해당 점포 정보 : ");
		System.out.println("\t\t" + Arrays.toString(info));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.사업자등록번호  2.사업자명  3.상호명  4.사업자주소  5.평점");
		System.out.println("\t\t6.배달소요시간  7.배달비  9.최소주문비용  10.배달가능주소");
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
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");

		String input1 = scan.nextLine();

		if (input1.equals("1")) {
			storeManage();

		} else if (input1.equals("0")) {
			Ui.mainUi();
		}
	}

	/**
	    * 주어진 사업자등록번호를 검색하여 해당하는 점포 정보를 String 배열 형태로 반환하는 메소드
	    * 
	    * @see java.io.BufferedReader
	    * @see java.io.FileReader
	    * @param input 검색할 사업자등록번호
	    * @return 해당 사업자등록번호에 해당하는 점포정보를 담은 String 배열, 검색 실패시 null 반환
	    */
	public static String[] search2(String input) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STORE));
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
	/**
	    * 점포의 정보를 수정하는 메소드
	    * 사용자가 입력한 사업자등록번호를 가진 점포를 찾아서 해당 점포의 정보를 출력한다
	    * 수정할 정보의 번호와 수정할 내용을 입력받아서 해당 정보를 수정한다
	    * 
	    * @see java.io.BufferedReader
	    * @see java.io.FileReader
	    * @see java.io.BufferedWriter
	    * @param info 수정할 점포의 정보를 담은 String배열
	    * @param num 수정할 정보의 번호
	    * @param content 수정할 내용
	    */
	private static void change(String[] info, String num, String content) {

		//edit
		info[Integer.parseInt(num) - 1] = content;
		
		
		//USER > 
		String userData = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STORE));
			String line = null;
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split("■");
				
				if (temp[0].equals(info[0])) {
					
					userData += String.format("%s\t%-3s\t%-8s\t%s\t%-10s\t%s\t%-10s\t%s\t%-10s\t%-10s\t%s\n", temp[0], temp[1], temp[2],
							temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
					
				} else {
					
					userData += line + "\r\n";
					
				}				
				
			}
			reader.close();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(STORE));
			
			writer.write(userData);
			
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	    * 삭제할 점포의 사업자등록번호를 입력받아 해당 점포를 삭제한 결과를 보여주는 메소드
	    * 점포가 삭제된 뒤 점포 리스트를 불러온다
	    *
	    *
	    * @see#delete(input)
	    * @see#storeList()
	    * @see#storeManage()
	    * @see UI.mainUI()
	    * 
	    */
	public static void storeDelete() {
	    Scanner scan = new Scanner(System.in);

	    System.out.println();
	    System.out.println("\t====================================================================");
	    System.out.println();
	    System.out.println("\t\t▽점포삭제");
	    System.out.println();

	    System.out.print("\t\t삭제할 점포 사업자등록번호 : ");
	    String input = scan.nextLine();
	    delete(input);

	    System.out.println();
	    System.out.println();
	    System.out.println("\t점포가 삭제되었습니다. : ");
	    System.out.println();
	    System.out.println("\t\t점포 리스트 : ");
	    storeList();
	    System.out.println();
	    System.out.println();
	    System.out.println("\t\t1. 이전페이지   0. 메인페이지");
	    System.out.println();
	    System.out.println("\t====================================================================");
	    System.out.println();
	    System.out.print("\t\t   번호 입력: ");

	    if (input.equals("1")) {
	        storeManage();
	    } else if(input.equals("0")) {
	        Ui.mainUi();
	    }
	}

	/**
	    * 주어진 사업자등록번호를 가진 점포를 삭제하는 메소드
	    * 
	    * @param input 삭제할 점포의 사업자등록번호
	    * @see java.io.BufferedReader
	    * @see java.io.BufferedWriter
	    * @see java.io.FileReader
	    * @see java.io.FileWriter
	    */
	private static void delete(String input) {
	    try {
	        // 기존 파일을 읽기 전용으로 열기
	        BufferedReader reader = new BufferedReader(new FileReader(STORE));
	        List<String> lines = new ArrayList<>();
	        String line;

	        // 파일의 모든 라인을 메모리에 적재
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
	        BufferedWriter writer = new BufferedWriter(new FileWriter(STORE));
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
