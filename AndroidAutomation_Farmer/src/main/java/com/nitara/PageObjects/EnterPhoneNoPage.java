package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterPhoneNoPage extends BasePage{
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*editTextPhone.*\"))")
	private MobileElement phone_et;
	
	@AndroidFindBy(id = "continue_button") 
	private MobileElement continue_btn;
	
	@AndroidFindBy(id = "textView2") 
	private MobileElement textView2;
	
	public void enter_PhoneNo(String phone) {
		sendKeys(phone_et, phone);
	}
	
	public void click_continue() {
		click(continue_btn);
	}
	
	public void assertPhoneNumber(String phone) {
		Assert.assertEquals(phone_et.getText(), phone.substring(0, 10));
	}

	public void assertPage() {
		// TODO Auto-generated method stub
		Assert.assertEquals(textView2.getText(), "ENTER YOUR PHONE NUMBER");
	}
	

}
