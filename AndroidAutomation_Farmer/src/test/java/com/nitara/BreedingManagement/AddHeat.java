package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddHeat extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	@Parameters("url")
	public void Heat_AddData(Map<String,String> data) throws Throwable {
	
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Go to Heat screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"heat");	
		
		/** Fill the heat data */
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.captureScreenshots("AddHeat");
		breedingSuccessPage.cattletag_Assert(Tag);	
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateHeat_UpdateData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
//		String Tag="36218491";
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"heat");	
		
		/** Fill the heat form */ 
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.homeButton();
		breedingSuccessPage.click_BackToBreedingTimeline();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"heat");
		breedingTimelinePage.press_editBtnLeft();
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateHeat_15DaysAfterLastCalvingDate(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Go to cattle Profile page -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"heat");
		
		/** Fill the heat form */ 
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();
		addHeatPage.assertWarning(data.get("warningMessage"));

	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateHeat_MinimumGapOf14Days(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
//		String Tag="36218491";
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"heat");
		
		/** Fill the heat form */ 
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
//		breedingSuccessPage.homeButton();
		breedingSuccessPage.click_BackToBreedingTimeline();
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();
		addHeatPage.assertWarning(data.get("warningMessage"));

	}
}
