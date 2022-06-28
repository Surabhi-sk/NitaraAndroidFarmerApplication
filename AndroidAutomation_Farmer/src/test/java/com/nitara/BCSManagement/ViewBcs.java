package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class ViewBcs extends GenericBase

{
	@Test
	public void ViewBcs() throws Throwable

	{
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");

		/** Go to cattle Profile page -> Select BCS */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "BCS");

		/** Clic Addbcs from viewbcs page */
		addbcsPage.ClickAddBcs_btn();

		/** Fill bcs Form */
		String date = generateRandomData.getPastDate(2);
		addbcsPage.addbcs(date);

//		/** Select Time Period from dropdown */
//		viewbcspage.select_Timeperiod();

		/** Assert bcs score */
		 viewbcspage.assert_Bcsscore();

		/** View the added details */
		viewbcspage.captureScreenshots("View BCS");

	}
	
}
