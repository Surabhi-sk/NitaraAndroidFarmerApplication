package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class DeletePD extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_ViewData(Map<String,String> data) throws Throwable {
		
		//To verify if user is able to delete the last added pd data - Not Pregnant/Pregnant.

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingCattle_Inseminated");

		/** Go to cattle Profile page -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"PD");

		/** Fill PD Form */
		addPDPage.enter_PDdate(generateRandomData.getPastDate(40-21));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.assert_CattleTag(Tag);
		addPDPage.press_SaveButton();

		/** Go back to timeline */
		breedingSuccessPage.click_BackToBreedingTimeline();
		

		/** Delete the added pd record */
		breedingTimelinePage.press_deleteBtnRight();
		breedingTimelinePage.press_YesBtn();

		/** Assert Delete message */
		breedingTimelinePage.captureScreenshots("DeletePD");
		breedingTimelinePage.assertDeleteMsg("PD",generateRandomData.getPastDate(40-21));

	}
	
	@Test(groups="Regression")
	public void PD_selectNoInPOPUPwhenDeleteBtnIsClicked() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingCattle_Inseminated");

		/** Go to cattle Profile page -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"PD");

		/** Fill PD Form */
		addPDPage.enter_PDdate(generateRandomData.getPastDate(40-21));
		addPDPage.assert_CattleTag(Tag);
		addPDPage.press_SaveButton();

		/** Go back to timeline */
		breedingSuccessPage.click_BackToBreedingTimeline();
		

		/** Delete the added pd record */
		breedingTimelinePage.press_deleteBtnRight();
		breedingTimelinePage.press_NoBtn();

	}
}
