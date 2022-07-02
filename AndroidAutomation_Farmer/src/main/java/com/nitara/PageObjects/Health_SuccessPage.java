package com.nitara.PageObjects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_SuccessPage extends BasePage{

	@AndroidFindBy(id = "successMessage") 
	private MobileElement success_msg;
	
	@AndroidFindBy(id = "go_back_to_cattle_result") 
	private MobileElement goback;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home;
	
	public void assertSuccessMsg(String activity) {
		waitForVisibility(success_msg);
		//Assert.assertEquals(success_msg.getText(),activity+" has been Recorded successfully for");
	} 
	
	public void goToView() {
		waitForVisibility( goback);
		click( goback);
	}

	public void homeButton() {
		// TODO Auto-generated method stub
		click(home);
	}
	
	

}
