package com.test.storekeeper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import com.test.project.Login;
import com.test.project.Main;
import com.test.project.Ui;
import com.test.validation.Validation;

/**
 * @author 정상우
 * 
 * @see jio.BufferedWriter;
 * @see java.io.FileWriter;
 * @see java.util.Scanner;
 * @see com.test.project.Login;
 * @see com.test.project.Main;
 * @see com.test.validation.validation;
 * 
 * 
 *
 */
public class StorekeeperScreen {
	
	/**
	 * 점주로그인화면 메소드
	 * 점포등록,수정,삭제, 점주정보조회,수정,탈퇴 기능메소드를 호출하는 메소드
	 * 
	 * @see java.io.BufferedWriter;
	 * @see import java.io.FileWriter;
	 * @see import java.util.Scanner;
	 * @see validation.NameCheck()
	 * @see validation.addressCheck()
	 * @see validation.categoryCheck()
	 * @see validation.deliveryH()
	 * @see validation.deliveryAmount()
	 * @see validation.amountCheck()
	 * @see validation.deliveryAddressCheck()
	 * @see validation.storeChange()
	 * @see validation.delete()
	 * @see validation.storekeeperChange()
	 * @see Login.storekeepertoString()
	 * @see storekeeperScreen()
	 * 
	 * @return storekeeperScreen
	 */
	public static StorekeeperScreen storekeeperScreen() {
		
		final String TXT = "C:\\class\\code\\java\\DeliveryService\\dat\\점포.txt";
		
		System.out.println();
		System.out.print("\t============================================\n");
		System.out.print("\t\t\t1.점포 관리\n\t\t\t2.점주 정보 조회\n\t\t\t3.점주정보 수정\n\t\t\t4.점주 탈퇴\n\t\t\t입력:");
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		System.out.println();
		System.out.print("\t============================================\n");
		if(n.equals("1")) {//점포관리
			System.out.print("\t\t\t1.점포 등록\n\t\t\t2.점포 수정\n\t\t\t3.점포 삭제\n\t\t\t입력:");
			n = sc.nextLine();
			if(n.equals("1")) {//점포관리 > 점포등록 
				System.out.print("\t============================================\n");
				String businessNumber = Login.storekeeper[6];//사업자 등록번호
				System.out.println();
				String buisnessMan = Validation.NameCheck();//사업자명
				System.out.println();
				System.out.print("\t\t상호명 :");	//상호명
				String businessName = sc.nextLine();
				System.out.println();
				String address = Validation.addressCheck();	//사업자주소
				System.out.println();
				String category = Validation.categoryCheck();//카테고리
				System.out.println();
				double rating = 0;//평점
				String deliveryH = Validation.deliveryH();//배달최소소요시간 최소최대
				System.out.println();
				String deliveryAmount = Validation.deliveryAmount();//배달비
				System.out.println();
				String Amount = Validation.amountCheck();//최소주문비용
				System.out.println();
				String deliveryAddress = Validation.deliveryAddressCheck();//배달가능 주소(지역)	
				System.out.println();
				
				try {
					FileWriter fw = new FileWriter(TXT, true); 
					BufferedWriter writer = new BufferedWriter(fw);
					writer.write(String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s■%s\n",businessNumber,buisnessMan,businessName,address,category,rating,deliveryH,deliveryAmount,Amount,deliveryAddress));
					writer.flush();
					System.out.println();
					System.out.print("\t============================================\n");
					System.out.println("\t\t등록완료!");
					System.out.print("\t\t1.이전화면 2.메인화면 0.종료\n");
					n = sc.nextLine();
					if(n.equals("1")) {
						return storekeeperScreen();
					}else if(n.equals("2")) {
						Ui.pause();
						Main.main(null);
					}else if(n.equals("0")) {
						System.exit(0);
					}
				} catch (Exception e) {

					e.printStackTrace();
					
				}
				
			}else if(n.equals("2")) {//점포관리 > 점포수정
				System.out.print("\t============================================\n");
					
				Validation.storeChange();
					
			}else if(n.equals("3")) {//점포관리 > 점포 삭제
				
				Validation.delete();
				
			}
			
			
		}else if(n.equals("2")) {//점주조회
			System.out.print("\t============================================\n");
			System.out.println(Login.storekeepertoString());
			System.out.print("\t\t1.이전화면\n\t\t2.종료\n\t\t\t\n\t\t입력:");
			n = sc.nextLine();
			System.out.print("\t============================================\n");
			if(n.equals("1")) {
				return storekeeperScreen();
			
			}else if(n.equals("2")) {
				System.exit(0);
			}
			
			
		}else if(n.equals("3")) {//점주 수정
			
			
			Validation.storekeeperChange();
			
			
		}else if(n.equals("4")) {//점주 삭제
			Validation.delete();
		}
		
		return null;
			
	}

	/**
	 * 점주회원의 점포를 수정하는 메소드
	 * 
	 * @see validation.BusinessNumberCheck()
	 * @see validation.NameCheck()
	 * @see validation.addressCheck()
	 * @see validation.categoryCheck()
	 * @see validation.deliveryH()
	 * @see validation.deliveryAmount()
	 * @see validation.amountCheck()
	 * @see validation.deliveryAddressCheck()
	 * @see validation.change(String[],String)
	 * @see
	 * @see
	 * 
	 * @param List : 점회회원 점포정보
	 * @return result : 변경된 점포정보
	 */
	private static String[] sotrekeepercorrection(String[] List) {
		String[] result = new String[List.length];
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t1.전체 수정 0.종료");
		int num = sc.nextInt();
	
		if(num==1) {
			String businessNumber = Validation.BusinessNumberCheck();//사업자 등록번호
			result[0]= businessNumber;
			String buisnessMan = Validation.NameCheck();//사업자명
			result[1]=buisnessMan;
			System.out.print("\t\t상호명 :");	//상호명
			String name = sc.nextLine();
			result[2]=name;
			String businessName = sc.nextLine();
			result[3]=businessName;
			String address = Validation.addressCheck();	//사업자주소
			result[4]=address;
			String category = Validation.categoryCheck();//카테고리
			result[6]=category;
			String deliveryH = Validation.deliveryH();//배달최소소요시간 최소최대
			String[] H = deliveryH.split("■");
			result[7]=H[0];
			result[8]=H[1];
			String deliveryAmount = Validation.deliveryAmount();//배달비
			result[9]=deliveryAmount;
			String Amount = Validation.amountCheck();//최소주문비용
			result[10]=Amount;
			String deliveryAddress = Validation.deliveryAddressCheck();//배달가능 주소(지역)	
			result[11]=deliveryAddress;
			result[5] = List[5];
			Validation.change(List,result);
		}else if(num==0) {
			System.exit(0);
		}
		return result;
	}

	private static void storeList() {
		// TODO Auto-generated method stub
		
	}
	
}
