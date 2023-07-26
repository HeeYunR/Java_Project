package com.test.test;

import java.io.BufferedWriter;
import java.io.FileWriter;



public class DummyData {

	private final static String ADMIN = ".\\dat\\admin.txt";
	private final static String RIDER = ".\\dat\\rider.txt";
	private final static String MENU = ".\\dat\\menu.txt";	
	private final static String REVIEW = ".\\dat\\review.txt";	
	
	public static void main(String[] args) {
	
		
		
		//createAdmin();
		//createRider();
		//createMenu();
		//createReview();
		
		String[] grade = {"Bronze", "Silver", "Gold", "Platinum", "Diamond"};
		
	}

	private static void createReview() {
		
		String list = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String list2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String[] prefix = {"배달이 ", "맛이 ", "양이 ", "가격이 "};
		String[] suffix = {"빨라요", "느려요", "좋아요", "나빠요", "많아요", "적어요", "싸요", "착해요"};
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(REVIEW));
			
			for (int i=0; i<100; i++) {
				
				String id = "";
				int rating = 1;
				String review = "";
				
				id += String.format("%s", list.charAt((int)(Math.random()*list.length())));
				
				int idLength = (int)(Math.random()*4)+6;
				
				for (int j=0; j<idLength; j++) {
					id += list2.charAt((int)(Math.random()*list2.length()));
				}
				
				rating = (int)(Math.random() * 5) + 1;
				
				review = prefix[(int)(Math.random()*prefix.length)] + suffix[(int)(Math.random()*suffix.length)];
				

				
				
				writer.write(String.format("%s,%s,%s\n", id, rating, review));
			}
			
			
			System.out.println("더미 데이터 생성");
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void createMenu() {
		
		String[] categorys = {"커피", "에이드", "디저트", "샌드위치", "디카페인커피", "햄버거", "음료", "사이드"};
		String[] menus = {"아메리카노", "디카페인 아메리카노", "카라멜마끼아또", "카페라떼", "자몽에이드", "레몬에이드", "망고에이드", "에그햄치즈샌드위치"
				, "치킨샌드위치", "마카롱" , "크로플", "불고기버거", "통새우와퍼", "콜라", "사이다", "제로콜라", "감자튀김", "치즈스틱"};

		String[] options = {"샷추가", "사이즈업", "휘핑크림추가", "바닐라시럽", "펄추가", "연하게", "HOT", "ICE", "우유식빵", "통밀식빵",
						"라지사이즈", "콘샐러드교환"};
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(MENU));
			
			for (int i=0; i<100; i++) {
				
				String companyNumber = "";
				String category = "";
				String menu = "";
				int menuPrice = 0;
				String option = "";
				int optionPrice = 0;
				boolean soldOut = false;
			
				companyNumber = String.format("%d-%02d-%04d%d", (int)(Math.random()*522) + 100,
															   (int)(Math.random()*100) + 1,
															   (int)(Math.random()*10000) + 1,
															   (int)(Math.random()*10));
				
				category = categorys[(int)(Math.random()*categorys.length)];
				menu = menus[(int)(Math.random()*menus.length)];
				menuPrice = ((int)(Math.random() * 20) + 1) * 1000;
				option = options[(int)(Math.random()*options.length)];
				optionPrice = ((int)(Math.random() * 5)) * 1000;
				
				int percentage = (int)(Math.random() * 100) + 1;
				
				if (percentage >= 90) {
					soldOut = true;
				} else {
					soldOut = false;
				}
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n", companyNumber, category, menu, menuPrice, option, optionPrice, soldOut));
			}
			
			
			System.out.println("더미 데이터 생성");
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createRider() {
		
		String[] names = {"김", "이", "박", "최", "정", "현", "민", "유", "재", "신"};
		String list = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String list2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String[] gu = {"강남구", "서초구", "송파구", "강동구", "동작구", "관악구", "금천구", "영등포구", "구로구"};
		String[] dong = {"신사동", "논현동", "삼성동", "청담동", "대치동", "역삼동", "서초동", "방배동", "양재동", "대방동"};
		String[] apartment = {"래미안", "현대", "아이파크", "힐스테이트", "한양", "센트레빌", "금호"};
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(RIDER));
			
			for (int i=0; i<20; i++) {
				
				String name = "";
				String id = "";
				String password = "";
				String age = "";
				String tel = "010-";
				String gender = "";
				String address = "서울시";
				int rating = 0;
			
				
				
				name = names[(int)(Math.random() * names.length)] +
						names[(int)(Math.random() * names.length)] +
						names[(int)(Math.random() * names.length)];
				
				
				id += String.format("%s", list.charAt((int)(Math.random()*list.length())));
				
				int idLength = (int)(Math.random()*4)+6;
				
				for (int j=0; j<idLength; j++) {
					id += list2.charAt((int)(Math.random()*list2.length()));
				}
				
				
				int pwLength = (int)(Math.random()*4)+6;
				
				for (int j=0; j<pwLength; j++) {
					password += list2.charAt((int)(Math.random()*list2.length()));
				}
				
				
				
				age = Integer.toString((int)(Math.random() * 14) + 27);
				
				for (int j=0; j<8; j++) {
					 
					if (j == 4) {
						tel += "-";
					}
					tel += Integer.toString((int)(Math.random()*10));
				}
				
				gender = (int)(Math.random()*2) == 0 ? "남자" : "여자";
				
				address += " " + gu[(int)(Math.random()*gu.length)] 
							+ " " + dong[(int)(Math.random()*dong.length)]
							+ " " + apartment[(int)(Math.random() * apartment.length)] + "아파트 "
							+ "10" + (int)(Math.random() * 10) + "동 "
							+ (int)(Math.random() * 20) + "0" + ((int)(Math.random() * 4) + 1) + "호";
				
				rating = (int)(Math.random()*5) + 1;
				
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", name, id, password, age, tel, gender, address, rating));
			}
			
			
			System.out.println("더미 데이터 생성");
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createAdmin() {
		String[] names = {"김", "이", "박", "최", "정", "현", "민", "유", "재", "신"};
		String list2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String[] gu = {"강남구", "서초구", "송파구", "강동구", "동작구", "관악구", "금천구", "영등포구", "구로구"};
		String[] dong = {"신사동", "논현동", "삼성동", "청담동", "대치동", "역삼동", "서초동", "방배동", "양재동", "대방동"};
		String[] apartment = {"래미안", "현대", "아이파크", "힐스테이트", "한양", "센트레빌", "금호"};
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(ADMIN));
			
			for (int i=0; i<20; i++) {
				
				String name = "";
				String id = "admin";
				String password = "";
				String age = "";
				String tel = "010-";
				String gender = "";
				String address = "서울시";
			
				
				
				name = names[(int)(Math.random() * names.length)] +
						names[(int)(Math.random() * names.length)] +
						names[(int)(Math.random() * names.length)];
				
				
				id += String.format("%03d", i+1);
				
				int pwLength = (int)(Math.random()*4)+6;
				
				for (int j=0; j<pwLength; j++) {
					password += list2.charAt((int)(Math.random()*list2.length()));
				}
				
				
				
				age = Integer.toString((int)(Math.random() * 14) + 27);
				
				for (int j=0; j<8; j++) {
					 
					if (j == 4) {
						tel += "-";
					}
					tel += Integer.toString((int)(Math.random()*10));
				}
				
				gender = (int)(Math.random()*2) == 0 ? "남자" : "여자";
				
				address += " " + gu[(int)(Math.random()*gu.length)] 
							+ " " + dong[(int)(Math.random()*dong.length)]
							+ " " + apartment[(int)(Math.random() * apartment.length)] + "아파트 "
							+ "10" + (int)(Math.random() * 10) + "동 "
							+ (int)(Math.random() * 20) + "0" + ((int)(Math.random() * 4) + 1) + "호";
				
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n", name, id, password, age, tel, gender, address));
			}
			
			
			System.out.println("더미 데이터 생성");
			writer.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

