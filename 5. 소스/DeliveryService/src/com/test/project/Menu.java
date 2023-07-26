package com.test.project;

import java.util.ArrayList;

/**
 * 메뉴들의 정보가 담긴 클래스이다.
 * optionList에는 해당 음식점의 전체 메뉴들이 담겨있고,
 * choiceOption에는 사용자가 담은 옵션들이 저장되어 있다.
 * @author 이재성
 *
 */
public class Menu { 
	
	private String category;
	private String name;
	private int price;
	private String soldOut; 
	private ArrayList<MenuOption> optionList = new ArrayList<MenuOption>();
	private ArrayList<MenuOption> choiceOption = new ArrayList<MenuOption>();	
	
	public Menu(String category, String name, int price, String soldOut) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.soldOut = soldOut;
	}
	

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public String getSoldOut() {
		return soldOut;
	}
	
	public void setOptionList(MenuOption mo) {
		optionList.add(mo);
	}
	
	public void setChoice(MenuOption mo) {
		choiceOption.add(mo);
	}

	public ArrayList<MenuOption> getOptionList() {
		return optionList;
	}
	
	public ArrayList<MenuOption> getChoiceOption() {
		return choiceOption;
	}

	@Override
	public String toString() {
		return "Menu [category=" + category + ", name=" + name + ", price=" + price + ", choiceOption=" + choiceOption
				+  "]\n";
	}
	
	

}

/**
 * 메뉴들의 옵션정보들이 담긴 클래스이다.
 * @author 이재성
 *
 */
class MenuOption {
	private String optionName;
	private int optionPrice;
	
	public MenuOption(String optionName, int optionPrice) {
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}

	public String getOptionName() {
		return optionName;
	}
	
	public int getOptionPrice() {
		return optionPrice;
	}	
	
}