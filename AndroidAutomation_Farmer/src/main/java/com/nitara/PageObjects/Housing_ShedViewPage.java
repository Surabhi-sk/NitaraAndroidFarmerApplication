package com.nitara.PageObjects;



import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Housing_ShedViewPage extends BasePage 

{ 
	
	@AndroidFindBy(id = "shed") 
	private MobileElement nameofshed;
		
	
	@AndroidFindBy(id = "mainArea") 
	private MobileElement group;
	
	@AndroidFindBy(id = "addCattleToGroup") 
	private MobileElement Addcattletogroupbtn;
	
	@AndroidFindBy(id = "checkbox") 
	private MobileElement checkbox;
	
	@AndroidFindBy(id = "chkSelectAll") 
	private MobileElement selectallcheckbox;
	
	
	@AndroidFindBy(id = "continueBtn") 
	private MobileElement addtogroupbtn;	

	
	@AndroidFindBy(id = "moveRight") 
	private MobileElement moverightarrow;
	
	@AndroidFindBy(id = "moveRight") 
	private MobileElement moveleftarrow;
	
	@AndroidFindBy(id = "arrow_btn") 
	private MobileElement downarrow;
	
	@AndroidFindBy(id = "screenshot") 
	private MobileElement page;
	
	@AndroidFindBy(id = "btnSave") 
	private MobileElement Savebtn;	
	
	@AndroidFindBy(id = "goToShed") 
	private MobileElement gotoshedbtn;
	
	@AndroidFindBy(id = "backBtnTxt") 
	private MobileElement gobackbtn;
	
	@AndroidFindBy(id = "backButtonText") 
	private MobileElement gobacktoshedview;
	
	@AndroidFindBy(id = "search_cattle_in_group") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	
	@AndroidFindBy(id = "allCattleAssignedTxt")
	private MobileElement display_msg;
	
	@AndroidFindBy(id = "chkSelectAll")
	private MobileElement chkSelectAll;
	
	public void searchCattle(String tag) {
		sendKeys(search_cattle,tag);
	}
	
	public void Searchshed(String shedname)
	{
		for(;;)
		{
				String actshedname =nameofshed.getText();
			
				if(actshedname.equals(shedname))
				{	
					System.out.println("matched");
					break;
					
				}
				else if(moverightarrow.isDisplayed())
				{
					moverightarrow.click();
				}
				else
				{
					moveleftarrow.click();
				}
				
				
		}
	}
	
	public void Assertshed(String shedname) {
		Assert.assertEquals(nameofshed.getText(), shedname);
	}
	
	
	public void Clickgobackbtn() throws InterruptedException
	{
		
		waitVisibility(gobackbtn);
		click(gobackbtn);

	}
	
	public void ClickSelectallcheckbox() throws InterruptedException
	{
		
		waitVisibility(selectallcheckbox);
		click(selectallcheckbox);

	}
		
	public void Clickgobacktoshed() throws InterruptedException
	{
		
		waitVisibility(gobacktoshedview);
		click(gobacktoshedview);

	}
	
	
	
	
	public void Clickgotoshedbtn() throws InterruptedException
	{
		//Thread.sleep(5000);
		waitVisibility(gotoshedbtn);
		click(gotoshedbtn);

	}
	
	
	public void ClickGroup() throws InterruptedException
	{
		Thread.sleep(5000);
		//waitVisibility(group);
		click(group);

	}
	
	public void ClickAddCattleToGroupBtn() throws InterruptedException
	{
		waitVisibility(Addcattletogroupbtn);
		click(Addcattletogroupbtn);
		
	}
	
	public void ClickCheckbox() throws InterruptedException
	{
		waitVisibility(checkbox);
			click(checkbox);

	}
	public void ClickSavebtn() throws InterruptedException
	{	
		
		waitVisibility(Savebtn);
			click(Savebtn);
			//tap();
			waitVisibility(Savebtn);
			click(Savebtn);

	}
	
	public void ClickAddToGroup() throws InterruptedException
	{
		waitVisibility(addtogroupbtn);
	
		click(addtogroupbtn);
		
	}
	public void ClickAddToGroupBtn() throws InterruptedException
	{
		waitVisibility(addtogroupbtn);
	
		click(addtogroupbtn);
		
		//tap();
		
		if(addtogroupbtn.isDisplayed())
		{
		
		waitVisibility(addtogroupbtn);
		click(addtogroupbtn);
		
		}
		
		
	//	Doubleclick(addtogroupbtn);
	//	click(page);			
			
		
	}
	
	public void assertWarningMsg(String msg) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),msg);
	}
	
	public void AssertCattleAdditionToGroup(String tag) {
		WebElement cattle_tag= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\""+tag+"\"))");
		Assert.assertEquals(cattle_tag.getText(), tag);
	}
	
	public void assertMsg(String msg) {
		waitVisibility(display_msg);
		Assert.assertEquals(display_msg.getText(),msg);
	}
	
	public void clickSelectAll() {
		click(chkSelectAll);
	}
		


}
