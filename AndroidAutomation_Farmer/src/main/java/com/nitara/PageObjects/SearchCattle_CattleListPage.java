package com.nitara.PageObjects;


import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchCattle_CattleListPage extends BasePage{
	
	@AndroidFindBy(id = "search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "search_btn") 
	private MobileElement search_btn;
	
	
	@AndroidFindBy(id = "filter_msg") 
	private MobileElement msg;
	
	public void searchCattle(String Tag) {
		sendKeys(search_cattle,Tag);
		//sendKeys(search_cattle,Keys.ENTER);
	}
	
	

	public void assert_msg() {
		Assert.assertEquals(msg.getText(),"0 CATTLE LISTED FOR FARM");
	}
	
	public void press_SearchBtn() throws Exception {
		click(search_btn);
		waitForPageLoad();
	}

}
