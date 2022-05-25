package com.nitara.CattleManagement;

import java.util.Map;
import org.testng.annotations.Test;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class RegisterMilkingorDryCattle extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_MilkingorDryCattle(Map<String,String> data) throws InterruptedException {

		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		//farmerHomePage.clickskip_btn();

		registerMilkingCattlePage.waitForPageLoad();
		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		registerMilkingCattlePage.enter_TagNumber(tagNumber);
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
//		registerMilkingCattlePage.select_cattleType(data.get("cattleType"));
//		registerMilkingCattlePage.select_cattleBreed(data.get("breed"));
//
//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerMilkingCattlePage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		registerMilkingCattlePage.select_Lactation(data.get("currentLactation"));
		registerMilkingCattlePage.enter_Calvingdate(data.get("lastCalvingDate"));
//		registerMilkingCattlePage.enter_CalfCount(data.get("calfCount"));
//		registerMilkingCattlePage.enter_Calf1Gender(data.get("calf1Gender"));

//		if(data.get("calfCount").equalsIgnoreCase("twins")) {
//			registerMilkingCattlePage.enter_Calf2Gender(data.get("calf2Gender"));
//		}

		// Check cattle Pregnant - Artificial or Natural Insemination
//		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerMilkingCattlePage.isCattlePregnant(data.get("pregnantSince"));
//				registerMilkingCattlePage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
//			}
//			else{
//				registerMilkingCattlePage.isCattlePregnant(data.get("pregnantSince"));
//				registerMilkingCattlePage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
//
//		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
//		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerMilkingCattlePage.isCattleInseminated();
//				registerMilkingCattlePage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}
//
//			else{
//				registerMilkingCattlePage.isCattleInseminated();
//				registerMilkingCattlePage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}

		if(data.get("isCattleDry").equalsIgnoreCase("true")) {
			registerMilkingCattlePage.cattleIsDry();
			registerMilkingCattlePage.enter_DryPeriodDate(data.get("dryPeriodDate"));
		}

		registerMilkingCattlePage.press_SaveButton();
		
		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterMilch");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
	
	}

}

