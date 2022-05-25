package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class EditPD extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_ViewData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Add insemination for the cattle for the given date */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new HelperFunctions().Insemination_ForGivenDate(Tag,generateRandomData.getPastDate(40));

		/** Go to cattle Profile page -> Select Breeding */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"PD");

		/** Fill PD Form */
		addPDPage.enter_PDdate(generateRandomData.getPastDate(40-21));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.assert_CattleTag(Tag);
		addPDPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.click_BackToBreedingTimeline();
		
		/** Edit the added PD details */
		breedingSuccessPage.captureScreenshots("EditPD");
		breedingTimelinePage.press_editBtnRight();
		addPDPage.waitForPageLoad();
		addPDPage.press_SaveButton();
		addPDPage.waitForPageLoad();
		breedingSuccessPage.cattletag_Assert(Tag);
		
	
	}
}
