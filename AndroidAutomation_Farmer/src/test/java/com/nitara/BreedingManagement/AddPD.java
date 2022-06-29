package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddPD extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_ValidData(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		


		/** Add insemination for the cattle for the given date */
		new HelperFunctions().Insemination_ForGivenDate(Tag,generateRandomData.getPastDate(40));

		/** Go to PD screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"pd");

		addPDPage.enter_PDdate(generateRandomData.getPastDate(18));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.assert_CattleTag(Tag);
		addPDPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.captureScreenshots("AddPD");
		breedingSuccessPage.cattletag_Assert(Tag);
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_NoInseminationData(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		


		/** Go to PD screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"pd");

		/** Assert warning message */
		addPDPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_PDdateWithin21DaysOfInseminationdate(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		


		/** Add insemination for the cattle for the given date */
		new HelperFunctions().Insemination_ForGivenDate(Tag,generateRandomData.getPastDate(20));

		/** Go to PD screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"pd");

		addPDPage.enter_PDdate(generateRandomData.getPastDate(0));
		addPDPage.press_SaveButton();

		/** Assert warning */
		addPDPage.assertWarningMsg(data.get("warningMessage"));
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_PDdateWithin21DaysOfPDdate(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		


		/** Add insemination for the cattle for the given date */
		new HelperFunctions().Insemination_ForGivenDate(Tag,generateRandomData.getPastDate(42));

		/** Go to PD screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"pd");

		addPDPage.enter_PDdate(generateRandomData.getPastDate(20));
		addPDPage.press_SaveButton();
		breedingSuccessPage.homeButton();
		
		/** Go to PD screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"pd");

		addPDPage.enter_PDdate(generateRandomData.getPastDate(0));
		addPDPage.press_SaveButton();

		/** Assert warning */
		addPDPage.assertWarningMsg(data.get("warningMessage"));
	}
}
