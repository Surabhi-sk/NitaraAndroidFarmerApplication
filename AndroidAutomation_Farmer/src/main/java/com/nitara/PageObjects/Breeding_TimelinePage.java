package com.nitara.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class Breeding_TimelinePage extends BasePage{

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnAddActivity.*\"))")
	private MobileElement addActivity_Btn;
	
	@AndroidFindBy(id="tvTitleLeft")
	private MobileElement heat_btn;
	
	@AndroidFindBy(id="tvTitleRight")
	private MobileElement tvTitleRight;
	
	@AndroidFindBy(id = "naturalBtn")
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "heat_date")
	private MobileElement heat_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "l2value")
	private MobileElement breedingStatus;
	
	@AndroidFindBy(id ="tvDateLeft")
	private MobileElement checkDateLeft;
	
	@AndroidFindBy(id ="tvDateRight")
	private MobileElement checkDateRight;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[1]")
	private MobileElement heatTyData;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[2]")
	private MobileElement recordedData;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*tvTotalDaysLeft.*\"))") 
	private MobileElement totalDaysLeft;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\".*PD.*\"))") 
	private MobileElement PD;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnRemoveLeft.*\"))") 
	private MobileElement deleteBtnLeft ;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement popup_Yes;
	
	@AndroidFindBy(id = "android:id/button2")
	private MobileElement popup_No;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement deleteMsg;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnEditLeft.*\"))") 
	private MobileElement editBtnLeft ;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnEditRight.*\"))") 
	private MobileElement editBtnRight ;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnRemoveRight.*\"))") 
	private MobileElement deleteBtnRight ;
	
	@AndroidFindBy(id = "android:id/text1")
	private MobileElement lactationCountDropdown;
	
	@AndroidFindBy(id = "com.nitara.farmer.qa:id/r2lbl")
	private MobileElement Upcoming_activity;
	
	@AndroidFindBy(id = "com.nitara.farmer.qa:id/r2value")
	private MobileElement Upcoming_activity_date;
	
	public void click_AddActivity() throws Exception {
		click(addActivity_Btn);
	}
	
	
    public void check_breedingStatus(String status) throws Exception {

    	waitVisibility(breedingStatus);
    	Assert.assertEquals(breedingStatus.getText(),status);
    }
    
    public void checkDateLeft(String cdate) throws Exception {
    	waitVisibility(checkDateLeft);
    	Assert.assertEquals(checkDateLeft.getText(),cdate);
    }
    
    public void checkDateRight(String cdate) throws Exception {
    	Thread.sleep(3000);
    	waitVisibility(checkDateRight);
    	Assert.assertEquals(checkDateRight.getText(),cdate);
    }
	
    public void check_HeatType(String type) {
		List<MobileElement> List = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		Assert.assertEquals(List.get(16).getText(), type);
	}
    
	   public void press_DeleteBtnLeft() throws Exception {
		   deleteBtnLeft.getText();
	    	click(deleteBtnLeft);
	    }
	   
	   public void press_deleteBtnRight() throws Exception {
		   deleteBtnRight.getText();
	    	click(deleteBtnRight);
	    }
	   
	   public void press_editBtnLeft() throws Exception {
		   editBtnLeft.getText();
		   click(editBtnLeft);
	    }
	   
	   public void press_editBtnRight() throws Exception {
		   editBtnRight.getText();
		   click(editBtnRight);
	    }
	   
	   public void press_YesBtn() throws Exception {
	    	waitVisibility(popup_Yes);
	    	click(popup_Yes);
	    }
	   public void press_NoBtn() throws Exception {
	    	waitVisibility(popup_No);
	    	click(popup_No);
	    }
	   public void assertDeleteMsg(String activity, String date) {
		   waitVisibility(deleteMsg);
		   Assert.assertEquals(deleteMsg.getText(),activity+" data recorded on "+date+" has been deleted");
	   }
	   public void assertMsg(String date) {
		   Assert.assertEquals(checkDateLeft.getText(),date);
	   }

	public void getId() {
		// TODO Auto-generated method stub
		addActivity_Btn.getText();
		List<MobileElement> List = (List<MobileElement>) driver.findElementsById("tvTitleRight");
		for(int i=0;i<List.size() ;i++ ) {
			System.out.println(List.get(i).getText());
		}
		
		System.out.println();System.out.println();System.out.println();
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		for(int i=0;i<List1.size()-1 ;i++ ) {
			System.out.println(List1.get(i).getText());
		}
	}
	
	public void verify_Insemination(String type, String date, String bullId) {
		List<MobileElement> List = (List<MobileElement>) driver.findElementsById("tvTitleLeft");
		Assert.assertEquals(List.get(0).getText(),"HEAT");
		Assert.assertEquals(List.get(1).getText(),"INSEMINATION");
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		Assert.assertEquals(List1.get(20).getText(),date);
		Assert.assertEquals(List1.get(21).getText(),type);
		Assert.assertEquals(List1.get(22).getText(),bullId);
	}
	
	
	public void verify_PD(String status, String date) throws Exception {
		addActivity_Btn.getText();

		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");

		if(status.equalsIgnoreCase("true")) {
			List<MobileElement> List = (List<MobileElement>) driver.findElementsById("tvTitleRight");
			Assert.assertEquals(List.get(0).getText(),"PD");
			Assert.assertEquals(List1.get(19).getText(),"Pregnant");
			Assert.assertEquals(List1.get(18).getText(),"Physical");
			Assert.assertEquals(List1.get(16).getText(),date);
			
		}
		else {
			Assert.assertEquals(List1.get(17).getText(),"Not Pregnant");
			Assert.assertEquals(List1.get(16).getText(),"Physical");
		}

		
	}
	
	public void assert_HeatEntry() {
		Assert.assertEquals(heat_btn.getText(),"HEAT");
	}
    
	public void verify_dryPeriod(String date) throws Exception {
		Assert.assertEquals(tvTitleRight.getText(), "DRY PERIOD");
		checkDateRight(date);
	}


	public void verify_calving(String date, String Calf_result, String CalfGender1) {
		
		// TODO Auto-generated method stub
		lactationCountDropdown.click();
		lactationCountDropdown.click();
		
		waitForPageLoad();
		TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(436,1403)).moveTo(PointOption.point(436,879)).release().perform();
        touchAction.press(PointOption.point(436,1403)).moveTo(PointOption.point(436,879)).release().perform();
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		Assert.assertEquals(List1.get(20).getText(), "CALVING");
		Assert.assertEquals(List1.get(21).getText(), date);
		Assert.assertEquals(List1.get(23).getText(), Calf_result);
		Assert.assertEquals(List1.get(24).getText(), CalfGender1);
		
	}
	
public void verify_calving(String date, String Calf_result, String CalfGender1, String CalfGender2) {
		
		// TODO Auto-generated method stub
		lactationCountDropdown.click();
		lactationCountDropdown.click();
		
		waitForPageLoad();
		TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(436,1403)).moveTo(PointOption.point(436,879)).release().perform();
        touchAction.press(PointOption.point(436,1403)).moveTo(PointOption.point(436,879)).release().perform();
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		Assert.assertEquals(List1.get(20).getText(), "CALVING");
		Assert.assertEquals(List1.get(21).getText(), date);
		Assert.assertEquals(List1.get(23).getText(), Calf_result);
		Assert.assertEquals(List1.get(24).getText(), CalfGender1);
		Assert.assertEquals(List1.get(25).getText(), CalfGender2);
		
	}


public void verify_upcomingActivity(String activity, String date) {
	// TODO Auto-generated method stub
	Assert.assertEquals(Upcoming_activity.getText(), activity);
	Assert.assertEquals(Upcoming_activity_date.getText(), date);
	
	
}



 
}
