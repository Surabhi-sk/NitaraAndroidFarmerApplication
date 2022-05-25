package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class ViewCalving extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Calving_ViewData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Add insemination for the cattle for the given date */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new HelperFunctions().Insemination_ForGivenDate(Tag,generateRandomData.getPastDate(151));

		/** Add PD for the cattle for the given date */
		farmerHomePage.waitForPageLoad();
		new HelperFunctions().PD_ForGivenDate(Tag,generateRandomData.getPastDate(20));

		/** Go to cattle Profile page -> Select Breeding - Calving */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"Calving");


		/** Fill calving form */
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}

		addCalvingPage.press_SaveButton();

		breedingSuccessPage.click_BackToBreedingTimeline();
	}
}
