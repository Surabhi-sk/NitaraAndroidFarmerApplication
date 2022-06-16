package com.nitara.CattleManagement;

import java.util.Map;
import org.testng.annotations.Test;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class RegisterBull extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Bull(Map<String,String> data) throws InterruptedException {

		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.select_cattleType(data.get("cattleType"));
		registerCattleBullPage.select_cattleBreed(data.get("breed"));
		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();


		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterBull");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullTagNumberAccceptsSpecialCharacters(Map<String,String> data) throws InterruptedException{

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();

		/**BULL Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();

		/**Entering TagNumber with special characters*/
		registerCattleBullPage.enter_TagNumber(data.get("tagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull Tag with special characters");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullSameEarTag(Map<String,String> data) throws InterruptedException{

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();

		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();

		/**Entering Already Registered TagNumber*/
		registerCattleBullPage.enter_TagNumber(data.get("tagNumber"));
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with same eartag");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullCoopTagNumberAcceptsNonNumericValue(Map<String,String> data) throws InterruptedException{

		String tagNumber =generateRandomData.generateRandomNumber(7);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);

		/**Entering CoopTagNumber having non numeric values*/
		registerCattleBullPage.enter_CoopTagNumber(data.get("cooptagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with non numeric cooptagNumber");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullPashuAadharLesserThan12Digits(Map<String,String> data) throws InterruptedException{

		String tagNumber =generateRandomData.generateRandomNumber(7);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);

		/**Entering CoopTagNumber having non numeric values*/
		registerCattleBullPage.enter_CoopTagNumber(data.get("cooptagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with Pashu aadhar less than 12 digits");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullPashuAadharMoreThan12Digits(Map<String,String> data) throws InterruptedException{
		String tagNumber =generateRandomData.generateRandomNumber(7);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);

		/**Entering CoopTagNumber having non numeric values*/
		registerCattleBullPage.enter_CoopTagNumber(data.get("cooptagNumber"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with pashu aadhar more than 12 digits");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullCattleTagMandatory(Map<String,String> data) throws InterruptedException{

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull Cattle Tag Mandatory");
    	WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullYearOfBirthMandatory(Map<String,String> data) throws InterruptedException{
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull without year of birth");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullMinimumWeight(Map<String,String> data) throws InterruptedException{
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.select_cattleType(data.get("cattleType"));
		registerCattleBullPage.select_cattleBreed(data.get("breed"));

		/**Entering weight of bull less than 15kgs*/
		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull weight less than 15kg");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullMaximumWeight(Map<String,String> data) throws InterruptedException{
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.select_cattleType(data.get("cattleType"));
		registerCattleBullPage.select_cattleBreed(data.get("breed"));

		/**Entering weight of bull more than 1000kgs*/
		registerCattleBullPage.enter_weight(data.get("weight"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull with weight more than 2000kg");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_BullUnder6Months(Map<String,String> data) throws InterruptedException{
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoadBar();
		farmerHomePage.click_RegisterCattleButton();


		/** Bull Register form */
		cattleTypePage.select_cattleType("BULL");
		registerCattleBullPage.assert_CattleType();
		registerCattleBullPage.enter_TagNumber(tagNumber);
		registerCattleBullPage.enter_CoopTagNumber (cooptagNumber);
		registerCattleBullPage.select_YOB(data.get("yearOfBirth"));
		registerCattleBullPage.select_month(data.get("monthOfBirth"));
		registerCattleBullPage.press_SaveButton();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("RegisterBull under 6 months");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

}
