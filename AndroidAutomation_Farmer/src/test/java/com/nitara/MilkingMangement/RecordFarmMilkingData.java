package com.nitara.MilkingMangement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class RecordFarmMilkingData extends GenericBase {

	@Test
	public void Milking_RecordCattleMilking() throws Throwable {

		// Choose Milking Preference
		new HelperFunctions().setMilkingPreferences("Farm Milking");
		
		farmerHomePage.click_MilkRecordingButton();

		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("22");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("560");
		// farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();

		// farmMilkingSuccessPage.assertSession("Morning");
		farmMilkingSuccessPage.assertSessionYield("22");
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void FarmMilking_YieldMandate(Map<String, String> data) throws Throwable {

		// Choose Milking Preference
		new HelperFunctions().setMilkingPreferences("Farm Milking");

		farmerHomePage.click_MilkRecordingButton();

		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("560");
		// farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();
		farmMilkingPage.assertWarning(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void FarmMilking_UpdateValues(Map<String, String> data) throws Throwable {

		// Choose Milking Preference
//		new HelperFunctions().setMilkingPreferences("Farm Milking");

		farmerHomePage.click_MilkRecordingButton();

		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("20");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("560");
		// farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();
		farmMilkingSuccessPage.homebutton();
		farmerHomePage.click_MilkRecordingButton();

		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("20");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("5600");
		farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();
		farmMilkingSuccessPage.assertSessionYield("20");
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void FarmMilking_Delete(Map<String, String> data) throws Throwable {

		// Choose Milking Preference
//		new HelperFunctions().setMilkingPreferences("Farm Milking");
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_MilkRecordingButton();

		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("20");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("560");
		// farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();
		farmMilkingSuccessPage.homebutton();
		farmerHomePage.click_MilkRecordingButton();

		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("0");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("5600");
//		farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();
		farmMilkingSuccessPage.assertSessionYield("0");
	}
}
