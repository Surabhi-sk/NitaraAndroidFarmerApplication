package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.PageObjects.BasePage;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class DeleteBcs extends GenericBase

{
	
	@Test
	public void DeleteBcs() throws Throwable
	
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
	
	
	/** Fill bcs Form */
	String date = generateRandomData.getPastDate(25);
	addbcsPage.waitForPageLoad();
	addbcsPage.addbcs(date);
	
	/** Select Time Period from dropdown */
	viewbcspage.waitForPageLoad();
	viewbcspage.select_Timeperiod();
	
	/** click threedots icon*/
	viewbcspage.clickthreedotsicon();
	 
	 /**  delete bcs */
	 viewbcspage.clickdelete_btn();
	 viewbcspage. clickyesbtn();
	 viewbcspage.captureScreenshots("Delete BCS");
	 
	}	
	@Test
	public void DeleteBcs_SelectNoButton() throws Throwable
	
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
	
	
	/** Fill bcs Form */
	String date = generateRandomData.getPastDate(25);
	addbcsPage.waitForPageLoad();
	addbcsPage.addbcs(date);
	
	/** Select Time Period from dropdown */
	viewbcspage.waitForPageLoad();
	viewbcspage.select_Timeperiod();
	
	/** click threedots icon*/
	viewbcspage.clickthreedotsicon();
	 
	 /**  delete bcs */
	 viewbcspage.clickdelete_btn();
	 viewbcspage.clicknobtn();
	 
	}	
}
