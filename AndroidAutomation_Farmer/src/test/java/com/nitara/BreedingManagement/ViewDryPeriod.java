package com.nitara.BreedingManagement;


import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class ViewDryPeriod extends GenericBase{

	@Test
	public void Dry_ViewData() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Go to cattle Profile page -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"dryPeriod");

		/** Fill Dry Period form */
		addDryPeriodPage.enter_Drydate(generateRandomData.getPastDate(20));
		addDryPeriodPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.click_BackToBreedingTimeline();

		// Check details of added Dry period in View Heat Page 
		breedingTimelinePage.captureScreenshots("ViewDryPeriod");
		breedingTimelinePage.checkDateRight(generateRandomData.getPastDate(20));
		

	}


}
