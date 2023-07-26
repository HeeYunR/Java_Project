package com.test.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import com.test.admin.AdminEvent;
import com.test.storekeeper.StorekeeperJoin;
import com.test.user.UserJoin;

public class Ui {

	
	private static String chkUId;
	private final static String EVENTCOUPON = "C:\\class\\code\\java\\DeliveryService\\dat\\EventCoupon.txt";
	
	public static void mainUi() {
		
		System.out.println("////////////////////////////////////////////////////////////\r\n"
				+ "//////////////////////////*/**//*///////////////////////////\r\n"
				+ "///////////////////////,.,,****//(/(////////////////////////\r\n"
				+ "/////////////////////*  ....,,**,/*(##*(////////////////////\r\n"
				+ "/////////////////////./ //../(*,,*.####/((//////////////////\r\n"
				+ "////////////////////,*., .#./...,#,(/%%((((/////////////////\r\n"
				+ "/////////////////////,....(,(,.,&**.(##((((/////////////////\r\n"
				+ "//////////////////////*....,**,**((*///(((//////////////////\r\n"
				+ "///////////////////(/////,,,*****/##((((////////////////////\r\n"
				+ "///////////////////////*/*///*.,,*/(%((....,*///////////////\r\n"
				+ "/////////////////////,,(/,,,*(((##*/#(*.**,**/#%////////////\r\n"
				+ "/////////////////////*./%(//**/(((&@&#*,.***./(#(((/////////\r\n"
				+ "////////////////// /#,,/#(/,/#%&&&%&&(**/,.,/((#(((/////////\r\n"
				+ "/////////////////*,,,,*(((/*(&((%%%%&%##%##%##%((((/////////\r\n"
				+ "//////////////*(%(((/*//##/(*#(%&&&&&@*/(((#(/((////////////\r\n"
				+ "//////////////#%(,,..*////#%%%%%&&&#*/@//*,&(/((////////////\r\n"
				+ "//////////////(&%....###((/((((((((((@@(*,.%#(((////////////\r\n"
				+ "///////////////*#@@&%#((((/////////////#%%#((((/////////////\r\n"
				+ "////////////////////////////////////////////////////////////");
		
		for (int i=0; i<3; i++) {
			System.out.println();
		}
		
		
		System.out.println("\t============================================");
		System.out.println("\t\t      [배달의 민족]");
		System.out.println("\t\t      1. 관리자 로그인");
		System.out.println("\t\t      2. 비회원 주문");
		System.out.println("\t\t      3. 회원 로그인");
		System.out.println("\t\t      4. 점주 로그인");
		System.out.println("\t\t      5. 회원가입");
		System.out.println("\t\t      6. 아이디/비밀번호 찾기");
		System.out.println("\t\t      7. 프로그램 종료");
		System.out.println("\t============================================");
		System.out.println();
		
		System.out.print("\t\t\t번호 입력: ");
	}
	
	
	/**
	 * 음식 카테고리 화면 출력
	 */
	public static void categoryUi() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		
		System.out.println("\t\t=============================");
		System.out.println("\t\t1.한식\t2.양식\t 3.중식\t4.일식");
		System.out.println();
		System.out.println("\t\t5.카페\t6.아시안\t 7.패스트푸드");
		System.out.println();
		System.out.println("\t\t8.검색\t0.메인화면");
		System.out.println("\t\t=============================");
		System.out.println();
		System.out.print("\t\t번호입력: ");
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			RestaurantList.printRestaurant("한식");
		} else if(input.equals("2")) {
			RestaurantList.printRestaurant("양식");
		} else if(input.equals("3")) {
			RestaurantList.printRestaurant("중식");
		} else if(input.equals("4")) {
			RestaurantList.printRestaurant("일식");
		} else if(input.equals("5")) {
			RestaurantList.printRestaurant("카페");
		} else if(input.equals("6")) {
			RestaurantList.printRestaurant("아시안");
		} else if(input.equals("7")) {
			RestaurantList.printRestaurant("패스트푸드");
		} else if(input.equals("9")) {
			AdminEvent.eventPage();
		} else if(input.equals("0")) {
			Main.main(null);
		}
		
	}
	
	/**
	 * 동작을 잠시 멈추고 엔터를 입력하면 진행하는 메소드
	 */
	public static void pause() {
		//잠시 멈춤(메인 메뉴로 바로 돌아가지 못하게 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		scan.nextLine();
	}
	
	
	public static void registUi() {
	      boolean flag = true;
	      Scanner sc = new Scanner(System.in);
	      System.out.println();
	      System.out.println("\t============================================");
	      System.out.println("\t\t      [회원가입 선택]");
	      System.out.print("\t1. 일반회원");
	      System.out.print("\t2. 점주회원");
	      System.out.print("\t0. 메인화면\n");
	      System.out.println("\t============================================");
	      System.out.println();
	      System.out.print("\t\t\t번호입력: ");
	      String input = sc.nextLine();
	      while(flag)
	         if (input.equals("0")) {
	            mainUi();
	            break;
	         } else if (input.equals("1")) {
	            UserJoin.normalMemRegUi();
	            break;
	         } else if (input.equals("2")) {
	            StorekeeperJoin.storeMemRegJoin();;
	            break;
	         } else {
	            System.out.println("\t\t      올바른 번호를 입력해주세요(0,1,2)");
	            pause();
	            registUi();
	            flag=false;
	         }
	      }	
	
	//회원메뉴
		public static void memberSelectUi(String chkUId) {
			Scanner sc = new Scanner(System.in);
			System.out.println("////////////////////////////////////////////////////////////\r\n"
					+ "//////////////////////////*/**//*///////////////////////////\r\n"
					+ "///////////////////////,.,,****//(/(////////////////////////\r\n"
					+ "/////////////////////*  ....,,**,/*(##*(////////////////////\r\n"
					+ "/////////////////////./ //../(*,,*.####/((//////////////////\r\n"
					+ "////////////////////,*., .#./...,#,(/%%((((/////////////////\r\n"
					+ "/////////////////////,....(,(,.,&**.(##((((/////////////////\r\n"
					+ "//////////////////////*....,**,**((*///(((//////////////////\r\n"
					+ "///////////////////(/////,,,*****/##((((////////////////////\r\n"
					+ "///////////////////////*/*///*.,,*/(%((....,*///////////////\r\n"
					+ "/////////////////////,,(/,,,*(((##*/#(*.**,**/#%////////////\r\n"
					+ "/////////////////////*./%(//**/(((&@&#*,.***./(#(((/////////\r\n"
					+ "////////////////// /#,,/#(/,/#%&&&%&&(**/,.,/((#(((/////////\r\n"
					+ "/////////////////*,,,,*(((/*(&((%%%%&%##%##%##%((((/////////\r\n"
					+ "//////////////*(%(((/*//##/(*#(%&&&&&@*/(((#(/((////////////\r\n"
					+ "//////////////#%(,,..*////#%%%%%&&&#*/@//*,&(/((////////////\r\n"
					+ "//////////////(&%....###((/((((((((((@@(*,.%#(((////////////\r\n"
					+ "///////////////*#@@&%#((((/////////////#%%#((((/////////////\r\n"
					+ "////////////////////////////////////////////////////////////");
			for (int i=0; i<3; i++) {
				System.out.println();
			}
			
			System.out.println("\t============================================");
			System.out.println("\t\t      [회원 선택 화면]");
			System.out.println("\t\t      1. 주문하기");
			System.out.println("\t\t      2. 마이페이지");
			System.out.println("\t\t      3. 이벤트페이지");
			System.out.println("\t\t      4. 뒤로가기");
			System.out.println("\t\t      5. 프로그램 종료:");
			System.out.println("\t============================================");
			System.out.println();
			
			setChkUId(chkUId);
			
			System.out.print("\t\t\t번호 입력: ");
			String select = sc.nextLine();
			if(select.equals("2")) {
				userFunctUi(chkUId);
			} else if(select.equals("1")) {
				categoryUi();
			} else if(select.equals("4")) {
				Main.main(null);
			} else if(select.equals("3")) {
				AdminEvent.eventPage();
				System.out.println("룰렛 이벤트에 참가하시려면 [엔터]를 입력하세요.");
				sc.nextLine();
				rouletteUi();
			}
		}
			
	//김완진 회원이 수행할 수있는 목록
		public static void userFunctUi(String chkUId) {
				Scanner sc = new Scanner(System.in);
				System.out.println("\t============================================");
				System.out.println("\t\t      [회원 메뉴]");
				System.out.println("\t\t1. 주문하기\t2. 회원정보수정");
				System.out.println("\t\t3. 쿠폰확인\t4. 주문이력열람 및 리뷰작성");
				System.out.println("\t\t5. 회원정보\t6. 최근음식 재주문하기");
				System.out.println("\t\t7. 회원탈퇴\t8. 로그아웃");
				System.out.println("\t\t9. 서비스종료");
				System.out.println("\t============================================");
				System.out.println();
				System.out.print("\t\t\t번호 입력: ");
				String input = sc.nextLine();
						
				
				if(input.equals("2")) {
					System.out.println("\t========수정하실 정보의 번호를 입력하세요.==========");
					MemberEdit.memberBfedit(chkUId);	
					System.out.print("\t\t숫자 입력: ");
					String inputEdit = sc.nextLine();
					if(inputEdit.equals("0")) {
						MemberEdit.allEdit(chkUId);
					}
					else if(inputEdit.equals("1")) {
						System.out.println("\t\t아이디는 변경 불가합니다.");
						userFunctUi(chkUId);
					}else if(inputEdit.equals("2")) {
						MemberEdit.pwEdit(chkUId);
					}else if(inputEdit.equals("3")) {
						MemberEdit.emailEdit(chkUId);		
					}else if(inputEdit.equals("4")) {
						MemberEdit.ageEdit(chkUId);
					}else if(inputEdit.equals("5")) {
						MemberEdit.phoneEdit(chkUId);
					}else if(inputEdit.equals("6")) {
						MemberEdit.genderEdit(chkUId);
					}else if(inputEdit.equals("7")) {
						MemberEdit.nameEdit(chkUId);
					}else if(inputEdit.equals("8")) {
						MemberEdit.addressEdit(chkUId);
					}else if(inputEdit.equals("9")) {
						MemberEdit.nickEdit(chkUId);
					}				
				}else if(input.equals("5")) {
					MemberInfo.memberinfo(chkUId);
				}else if(input.equals("8")) {				
					System.out.println("\t============================================");
					System.out.print("\t\t로그아웃 완료!, 3초뒤 메인메뉴로 이동합니다... \n");
					System.out.println("\t============================================");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				    Ui.mainUi();
				} else if(input.equals("7")) {
					System.out.println("\t============================================");
					System.out.println("\t탈퇴를 진행하시려면 화면에 표시된 문자를 입력하세요.");
					String ranNum = MemberInfo.deleteCharacter();
					System.out.println(ranNum);
					ranNum = ranNum.trim();
					System.out.println("\t============================================");
					System.out.print("\t\t문자 입력: ");
					String inputDel = sc.nextLine();
					if(inputDel.equals(ranNum)) {
						MemberInfo.memberdelete(chkUId);	
					    System.out.println("\t============================================");
					    System.out.println("\t\t탈퇴가 완료되었습니다, 3초후 메인메뉴로 이동합니다...");
					    System.out.println("\t============================================");
					    try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Ui.mainUi();
					}else{
						System.out.println("\t   화면에 표시된 문자와 입력된 문자가 다릅니다");
						System.out.println("\t           회원 메뉴로 돌아갑니다.");
						userFunctUi(chkUId);
					}
				} else if(input.equals("1")) {
					categoryUi();
				} else if(input.equals("3")) {
					Coupon.couponUi(chkUId);
					System.out.println();
					pause();
					userFunctUi(chkUId);
				} else if(input.equals("4")) {
					MemberInfo.orderUi(chkUId);
				}
		}
		
	/**
	 * 룰렛 이벤트로 회원에게 랜덤으로 할인 쿠폰을 제공하는 메소드이다.
	 */
	public static void rouletteUi() {
		
		Scanner scan = new Scanner(System.in);
		
		int prize = 0;
		
		System.out.println("주사위 눈에 따라 할인 쿠폰을 드립니다!");
		System.out.println("★★★ 6 ★★★ : 10000원");
		System.out.println(" ★★ 5 ★★  : 5000원");
		System.out.println("  ★ 4 ★   : 3000원");
		System.out.println("   1~3    : 1000원");
		System.out.println("'주사위'를 입력하면 주사위가 던져집니다!");
		
		String input = scan.nextLine();
		
		if (input.equals("주사위")) {
			
			int dice = (int)(Math.random() * 100) + 1;
			
			if (dice <= 34) {
				System.out.println("주사위가 '1'이 떴습니다.");
				System.out.println("할인쿠폰 1000원이 지급되었습니다.");
				prize = 1000;
			} else if (dice <= 64) {
				System.out.println("주사위가 '2'가 떴습니다.");
				System.out.println("할인쿠폰 1000원이 지급되었습니다.");
				prize = 1000;
			} else if (dice <= 84) {
				System.out.println("주사위가 '3'이 떴습니다.");
				System.out.println("할인쿠폰 1000원이 지급되었습니다.");
				prize = 1000;
			} else if (dice <= 94) {
				System.out.println("주사위가 ★'4'★가 떴습니다.");
				System.out.println("할인쿠폰 3000원이 지급되었습니다.");
				prize = 3000;
			} else if (dice <= 99) {
				System.out.println("주사위가 ★★'5'★★가 떴습니다.");
				System.out.println("할인쿠폰 5000원이 지급되었습니다.");
				prize = 5000;
			} else {
				System.out.println("주사위가 ★★★'6'★★★이 떴습니다.");
				System.out.println("할인쿠폰 10000원이 지급되었습니다.");
				prize = 10000;
			}
			
			//id002■Bronze■0■63■3,000원
			
			try {
				File file = new File(EVENTCOUPON);
		        
		        FileWriter fw = new FileWriter(file, true);
		        BufferedWriter writer = new BufferedWriter(fw);
		               
		        writer.write(String.format("%s■%s■%d■%d■%d원\n", chkUId
		        					, "Bronze", (int)(Math.random()*10)
		        					, (int)(Math.random()*100), prize));
		        
		        writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			pause();
			userFunctUi(chkUId);
			
		} else {
			System.out.println("'주사위'를 입력해주세요");
		}
		
		
	}
	
	public static void setChkUId(String chkUId) {
		Ui.chkUId = chkUId; 
	}
	
	public static String getChkUId() {
		return chkUId;
	}
	
}
