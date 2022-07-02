package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_SuccessPage extends BasePage{
	
	@AndroidFindBy(id = "cattleTags") 
	private MobileElement cattleTags;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home;
	
	@AndroidFindBy(id = "back_cattle_result")
	private MobileElement backto_viewBreeding;

	@AndroidFindBy(id = "record_another_cattle") 
	private MobileElement record_another;
	
	@AndroidFindBy(id = "com.nitara.farmer.qa:id/back_text") 
	private MobileElement back_to_cattleProfile;
	
	public void click_BackToBreedingTimeline() {
		click(backto_viewBreeding);
	}
	
	public void recordAnotherActivity() throws Exception {
		record_another.click();
	}

	
	public void cattletag_Assert(String tagNumber) {
		Assert.assertEquals(cattleTags.getText(), tagNumber);
	}
	
	public void homeButton() {
		waitForVisibility(home);
		click(home);
	}

	public void click_BackToCattleProfile() {
		// TODO Auto-generated method stub
		click(back_to_cattleProfile);
	}
	

}
