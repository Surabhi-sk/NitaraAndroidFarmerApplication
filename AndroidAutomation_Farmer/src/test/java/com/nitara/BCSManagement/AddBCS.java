package com.nitara.BCSManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.HousingManagement.Createsmartshed;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddBCS extends GenericBase {
	@Test
	public void AddBcs() throws Exception

	{

		/** Register cattle */

//		String url = prop.getProperty("APIbaseUrl");
//		RegisterMilkingCattle reg = new RegisterMilkingCattle();
//		String Tag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");
		String Tag = "62012365";
		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_bcs_btn();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();

		/** capture screenshot */
		addbcsPage.captureScreenshots("Add BCS");

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpdateBcs_AddBcsBeforeFirstCalvingDate(Map<String, String> data) throws Exception

	{

		/** Register cattle */

//		String url = prop.getProperty("APIbaseUrl");
//		RegisterMilkingCattle reg = new RegisterMilkingCattle();
//		String Tag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");
		String Tag="83317885";
		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_bcs_btn();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(data.get("date"));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();
		addbcsPage.assertWarning(data.get("warningMessage")+" "+generateRandomData.getPastDate(25));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpdateBcs_AddBcsWithin15DaysOfPreviousBCSDate(Map<String, String> data) throws Exception

	{

		/** Register cattle */

		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");
		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_bcs_btn();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();
		addbcsPage.homeButton();
		farmerHomePage.click_bcs_btn();
		helper_AppNavigation.selectCattle(Tag);
		addbcsPage.waitForPageLoad();
		addbcsPage.ClickBcs_slider();
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(24));
		addbcsPage.press_SaveButton();
		addbcsPage.assertWarning(data.get("warningMessage")+" "+generateRandomData.getPastDate(25));
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpdateBcs_AddBcsBackdatedBCSEntry(Map<String, String> data) throws Exception

	{

		/** Register cattle */

		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url, "RegisterMilkingOrDryCattle");
		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_bcs_btn();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();
		addbcsPage.homeButton();
		farmerHomePage.click_bcs_btn();
		helper_AppNavigation.selectCattle(Tag);
		addbcsPage.waitForPageLoad();
		addbcsPage.ClickBcs_slider();
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(30));
		addbcsPage.press_SaveButton();
		addbcsPage.assertWarning(data.get("warningMessage")+" "+generateRandomData.getPastDate(25));
	}

}
