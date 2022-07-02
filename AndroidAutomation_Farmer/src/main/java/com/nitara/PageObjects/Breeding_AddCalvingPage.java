package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_AddCalvingPage extends BasePage{

	@AndroidFindBy(id = "twinsRdBtn") 
	private MobileElement Twins_RdBtn;
	
	@AndroidFindBy(id = "singleRdBtn") 
	private MobileElement Single_RdBtn;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	
	@AndroidFindBy(id = "maleRdBtn_single") 
	private MobileElement Male_RdBtn;
	
	@AndroidFindBy(id = "femaleRdBtn_single") 
	private MobileElement Female_RdBtn;
	
	@AndroidFindBy(id = "abortedRdBtn_single") 
	private MobileElement Aborted_RdBtn;
	
	@AndroidFindBy(id = "maleRdBtn_twins") 
	private MobileElement maleRdBtn_twins;
	
	@AndroidFindBy(id = "femaleRdBtn_twins") 
	private MobileElement femaleRdBtn_twins;
	
	@AndroidFindBy(id = "abortedRdBtn_twins") 
	private MobileElement abortedRdBtn_twins;
	
	@AndroidFindBy(id = "alertTitle") 
	private MobileElement alert;
	
	@AndroidFindBy(id = "calvingTime") 
	private MobileElement calvingTime;
	
	@AndroidFindBy(id = "toggle_mode") 
	private MobileElement timePicker;
	
	@AndroidFindBy(id = "input_hour") 
	private MobileElement input_hour;
	
	@AndroidFindBy(id = "input_minute") 
	private MobileElement input_minute;
	
	@AndroidFindBy(id = "am_pm_spinner") 
	private MobileElement am_pm;
	
	
	@AndroidFindBy(id = "button1") 
	private MobileElement ok_btn;
	
	
	@AndroidFindBy(id = "calving_date") 
	private MobileElement calving_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")  
	private MobileElement save_btn;
	
	public void select_Time(String time) {
		String[] splitString = time.split(":");
		String hour = splitString[0];
		String min = splitString[1];
		String a = splitString[2];
		calvingTime.click();
		timePicker.click();
		input_hour.click();
		input_hour.clear();
		sendKeys(input_hour, hour);
		input_minute.click();
		input_minute.clear();
		sendKeys(input_minute, min);
		ok_btn.click();
		
	}
	
	
	public void enter_CalvingDate(String date) {
		calving_date.clear();
		sendKeys(calving_date,date);
	}
	
	public void enter_CalvingTime(String time) {
		calvingTime.sendKeys(time);
	}

	public void select_CalfResultSingle(String result,String gender) {
		
		
			Single_RdBtn.click();
			if(Male_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Male_RdBtn.click();
			}
			
			else if(Female_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Female_RdBtn.click();
			}
			
			else if(Aborted_RdBtn.getText().equalsIgnoreCase(gender))
			{
				Aborted_RdBtn.click();
			}

	}
	
	
	public void select_CalfResultTwins(String result,String gender1, String gender2) {
		
		
		Twins_RdBtn.click();
		if(Male_RdBtn.getText().equalsIgnoreCase(gender1))
		{
			Male_RdBtn.click();
		}
		else if(Female_RdBtn.getText().equalsIgnoreCase(gender1)) {
			Female_RdBtn.click();
		}
		else {
			Aborted_RdBtn.click();
		}
		
		if(maleRdBtn_twins.getText().equalsIgnoreCase(gender2))
		{
			maleRdBtn_twins.click();
		}
		else if(femaleRdBtn_twins.getText().equalsIgnoreCase(gender2)) {
			femaleRdBtn_twins.click();
		}
		else {
			abortedRdBtn_twins.click();
		}
		
}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	public void assertWarning(String message) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),message);		
	}
	public void assertAlert(String message) {
		waitVisibility(alert);
		Assert.assertEquals(alert.getText(),message);		
	}
	

}
