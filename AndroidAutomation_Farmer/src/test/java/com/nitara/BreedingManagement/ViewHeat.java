package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class ViewHeat extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Heat_ViewData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Go to cattle Profile page -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"heat");

		/** Fill the heat form */ 
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.click_BackToBreedingTimeline();

		/** Check details of added Heat in View Heat Page */ 
		breedingSuccessPage.captureScreenshots("ViewHeat");
		breedingTimelinePage.check_breedingStatus("Open");
		breedingTimelinePage.checkDateLeft(data.get("heatDate"));
		breedingTimelinePage.check_HeatType(data.get("heatType"));

	}
}
