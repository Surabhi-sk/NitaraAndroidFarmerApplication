package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.PageObjects.BCS_ViewBCSPage;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class EditBcs extends GenericBase 


{
	@Test
	public void EditBcs() throws Throwable
	{
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		
		/** Go to cattle Profile page -> Select BCS */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "BCS");	
		
		addbcsPage.waitForPageLoad();
		
		
		/** Clic Addbcs from viewbcs page */
		addbcsPage.ClickAddBcs_btn();
		addbcsPage.waitForPageLoad();
		
		
		/** Fill bcs Form */
		String date = generateRandomData.getPastDate(2);
		addbcsPage.addbcs(date);
		
		/** Select Time Period from dropdown */
		viewbcspage.waitForPageLoad();
		viewbcspage.select_Timeperiod();
		
		
		/** Click three dots in view bcs page */
		viewbcspage.clickthreedotsicon();
		
		/** click edit button*/
		viewbcspage.clickeditbcs_btn();
		
		
		/**Fill bcs form */
		addbcsPage.waitForPageLoad();
		addbcsPage.ClickBcs_slider();		
		addbcsPage.enter_bcsDate(date);		
		addbcsPage.press_SaveButton();
		
		/** Capture the success page */
		viewbcspage.waitForPageLoad();
		viewbcspage.captureScreenshots("View BCS");
		
		/** click go back to bcs */
		addbcsPage.Clickgobacktoviewbcs();
		
//		/** Select Time Period from dropdown */
//		viewbcspage.select_Timeperiod();
		
		/** capture screenshot */
		viewbcspage.captureScreenshots("Update BCS");
		
		
		
		
		
		
		
		
	}
	}