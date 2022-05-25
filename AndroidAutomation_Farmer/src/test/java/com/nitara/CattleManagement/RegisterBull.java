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
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
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
	
	
	
}
