package com.nitara.BreedingManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddDryPeriod extends GenericBase{

	@Test
	public void AddDryPeriod_ValidData() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Go to Dry Period screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"dryPeriod");

		/** Fill Dry Period form */
		addDryPeriodPage.enter_Drydate(generateRandomData.getPastDate(20));
		addDryPeriodPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.captureScreenshots("AddDryPeriod");
		breedingSuccessPage.cattletag_Assert(Tag);
	}
}
