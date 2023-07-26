package com.test.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.test.project.Ui;

public class AdminEvent {
	final static String EVENT = "C:\\class\\code\\java\\DeliveryService\\dat\\이벤트리스트.txt";

	public static void eventmain() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽이벤트관리");
		System.out.println();
		System.out.println("\t이벤트 리스트 : ");
		eventlist();
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.이벤트추가   2.이벤트수정   3.이벤트삭제   0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			eventAdd();
		} else if(input.equals("2")) {
			eventChange();
		} else if(input.equals("3")) {
			eventDelete();
		} else if(input.equals("0")) {
			Ui.mainUi();
		}
	}
	
	public static void eventlist() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(EVENT));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				System.out.printf("\t%s\t%-10s\t%-30s\t%s\n", temp[0], temp[1], temp[2], temp[3]);
			}
			System.out.println("\t====================================================================");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void eventAdd() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽이벤트추가");
		System.out.println();
		System.out.println();
		System.out.print("\t\t이벤트 이름 : ");
		String name = scan.nextLine();
		System.out.println();
		System.out.print("\t\t이벤트 상품 : ");
		String gift = scan.nextLine();
		System.out.println();
		System.out.print("\t\t이벤트 기간 : ");
		String period = scan.nextLine();
		System.out.println();
		
		add(name, gift, period);
		
		System.out.println("\t\t추가완료: ");
		eventlist();
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.이전페이지 0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		String input = scan.nextLine();
		

		if (input.equals("1")) {
			eventmain();
		} else if(input.equals("0")) {
			Ui.mainUi();
		}
	}
	
	public static void add(String name, String gift, String period) {
	    try {
	        // Read existing events from file
	        BufferedReader reader = new BufferedReader(new FileReader(EVENT));
	        List<String[]> events = new ArrayList<>();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] temp = line.split("■");
	            events.add(temp);
	        }
	        reader.close();
	        
	        // Find the maximum event number
	        int maxNumber = 0;
	        for (String[] event : events) {
	            int number = Integer.parseInt(event[0]);
	            if (number > maxNumber) {
	                maxNumber = number;
	            }
	        }
	        
	        // Add the new event to the list
	        String[] newEvent = new String[4];
	        newEvent[0] = String.valueOf(maxNumber + 1);
	        newEvent[1] = name;
	        newEvent[2] = gift;
	        newEvent[3] = period;
	        events.add(newEvent);
	        
	        // Write the updated list of events back to file
	        BufferedWriter writer = new BufferedWriter(new FileWriter(EVENT));
	        for (String[] event : events) {
	            writer.write(String.join("■", event) + "\n");
	        }
	        writer.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public static void eventChange() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽이벤트수정");
		System.out.println();
		System.out.println();
		System.out.print("\t\t수정할 이벤트 번호 : ");
		String input = scan.nextLine();
		System.out.println();
		System.out.println();

		String[] info = search2(input);

		System.out.println("\t\t해당 이벤트 정보 : ");
		System.out.println("\t\t" + Arrays.toString(info));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t1.번호  2.이벤트 이름  3.이벤트 상품  4.이벤트 기간");
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
		System.out.println();
		System.out.println("\t\t1.이전페이지 0.메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		String input1= scan.nextLine();
		

		if (input1.equals("1")) {
			eventmain();
		} else if(input1.equals("0")) {
			Ui.mainUi();
		}
	}

	public static String[] search2(String input) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(EVENT));
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
		
		
		//EVENT > 
		String userData = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(EVENT));
			String line = null;
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split("■");
				
				if (temp[0].equals(info[0])) {
					userData += String.format("%s■%s■%s■%s\r\n", info[0], info[1], info[2], info[3]);
				} else {	
					userData += line + "\r\n";		
				}				
			}
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(EVENT));
			
			writer.write(userData);
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void eventDelete() {
		
		Scanner scan = new Scanner(System.in);
	
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t\t▽이벤트삭제");
		System.out.println();
		System.out.println("\t이벤트 리스트 : ");
		eventlist();
		System.out.println();
	
		System.out.print("\t\t삭제할 이벤트 번호 : ");
		String input = scan.nextLine();
		delete(input);
		System.out.println();
		System.out.println();
		System.out.println("\t이벤트가 삭제되었습니다. : ");
		System.out.println("\t이벤트 리스트 : ");
		eventlist();	
		System.out.println();
		System.out.println();
		System.out.println("\t\t1. 이전페이지   0. 메인페이지");
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.print("\t\t   번호 입력: ");
		
		if (input.equals("1")) {
			eventmain();
		} else if(input.equals("0")) {
			Ui.mainUi();
		}
	
	}
	
	private static void delete(String input) {
		
		int count = 0;
	    String contents = "";

	    // 이벤트 파일 읽고 조작
	    try {
	    	BufferedReader reader = new BufferedReader(new FileReader(EVENT));
	    	String line = null;

	         while ((line = reader.readLine()) != null) {
	
	            String temp[] = line.split("■");
	
	            // 입력값에 따른 번호 삭제 후 나머지 내용 추출
	            if (!temp[0].equals(input)) {
	               count++;
	               temp[0] = String.valueOf(count);
	
	               for (int i = 0; i < temp.length; i++) {
	
	                  if (i == temp.length) {
	                     contents += temp[i];
	                  }
	                  contents += temp[i] + "■";
	               }
	               contents += "\n";
	            }
	         }
	         reader.close();
	
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      // 이벤트 파일 수정
	      try {
	         BufferedWriter writer = new BufferedWriter(new FileWriter(EVENT));

	         writer.write(contents);
	         writer.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	public static void eventPage() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t====================================================================");
		System.out.println();
		System.out.println("\t이벤트 리스트 : ");
		eventlist();
		
	}
}//