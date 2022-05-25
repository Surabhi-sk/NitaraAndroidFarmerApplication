package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class RegisterCalf extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Calf(Map<String,String> data) throws InterruptedException {
		
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		//farmerHomePage.clickskip_btn();
	
		/** Calf Register form */
		cattleTypePage.select_cattleType("CALF");
		registerCattleCalfPage.assert_CattleType();
		registerCattleCalfPage.enter_TagNumber(tagNumber);
		registerCattleCalfPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleCalfPage.select_YOB(data.get("yearOfBirth"));
		registerCattleCalfPage.select_month(data.get("monthOfBirth"));
		registerCattleCalfPage.select_cattleType(data.get("cattleType"));
		registerCattleCalfPage.select_cattleBreed(data.get("breed"));

		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleCalfPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
		
		registerCattleCalfPage.enter_weight(data.get("weight"));
		registerCattleCalfPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterCalf");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
	}


}
