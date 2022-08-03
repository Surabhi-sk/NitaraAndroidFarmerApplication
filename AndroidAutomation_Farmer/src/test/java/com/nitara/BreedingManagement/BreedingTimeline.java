package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;
import appCommonClasses.Helper_AppNavigation;

public class BreedingTimeline extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Heat_AddData(Map<String,String> data) throws Throwable {
	
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to Heat screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity("heat");
		
		
		/** Fill the heat data */
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert heat data on the time line */
		breedingSuccessPage.click_BackToBreedingTimeline();	
		breedingTimelinePage.assert_HeatEntry();
		breedingTimelinePage.checkDateLeft(data.get("heatDate"));
		breedingTimelinePage.check_HeatType(data.get("heatType"));
		
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Insemination_ValidData(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to Insemination screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity(data.get("type")+"insemination");
		
		/** Enter data */
		addAIPage.enter_BullId(data.get("bullID"));
		addAIPage.enter_InseminationDate(data.get("inseminationDate"));
		addAIPage.press_SaveButton();
				
		/** Assert insemination data on the time line */
		breedingSuccessPage.click_BackToBreedingTimeline();	
		breedingTimelinePage.verify_Insemination(data.get("type"),data.get("inseminationDate"),data.get("bullID"));

	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_ValidData(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Inseminated");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to pd screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity("pd");
		
		/** Add data **/
		addPDPage.enter_PDdate(data.get("PDdate"));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.press_SaveButton();

		/** Assert pd data on the time line */
		breedingSuccessPage.click_BackToBreedingTimeline();	
		breedingTimelinePage.verify_PD(data.get("isCattlePregnant"),data.get("PDdate"));

	}
	
	@Test
	public void AddDryPeriod_ValidData() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to dry period screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity("dryPeriod");

		/** Fill Dry Period form */
		String date= generateRandomData.getPastDate(20);
		addDryPeriodPage.enter_Drydate(date);
		addDryPeriodPage.press_SaveButton();

		/** Assert dry period data on the time line */
		breedingSuccessPage.click_BackToBreedingTimeline();	
		breedingTimelinePage.verify_dryPeriod(date);
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void Calving_AddData(Map<String, String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Pregnant");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to calving screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity("calving");

		/** Fill calving form */
		if (data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"), data.get("calfGender1"));
			addCalvingPage.enter_CalvingDate(data.get("calvingDate"));
			addCalvingPage.press_SaveButton();

			/** Assert calving data on the time line */
			breedingSuccessPage.click_BackToBreedingTimeline();	
			breedingTimelinePage.waitForPageLoad();
			breedingTimelinePage.verify_calving(data.get("calvingDate"),data.get("calfResult"), data.get("calfGender1"));
		} else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"), data.get("calfGender1"),
					data.get("calfGender2"));
			addCalvingPage.enter_CalvingDate(data.get("calvingDate"));
			addCalvingPage.press_SaveButton();

			/** Assert calving data on the time line */
			breedingSuccessPage.click_BackToBreedingTimeline();	
			breedingTimelinePage.waitForPageLoad();
			breedingTimelinePage.verify_calving(data.get("calvingDate"),data.get("calfResult"), data.get("calfGender1"),data.get("calfGender2"));
		}
		

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void Insemination_DuringReg(Map<String, String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Inseminated");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to time line screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		
		/** Assert insemination data on the time line */
		breedingTimelinePage.verify_Insemination(data.get("type"),data.get("inseminationDate"),data.get("bullID"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void PD_DuringReg(Map<String, String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Pregnant");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to time line screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		
		/** Assert pd data on the time line */
		breedingTimelinePage.verify_Insemination(data.get("type"),data.get("inseminationDate"),data.get("bullID"));
		breedingTimelinePage.verify_PD(data.get("isCattlePregnant"),data.get("PDdate"));

	}
	
	@Test
	public void AddDryPeriod_DuringReg() throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Dry");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to time line screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		
		/** Assert pd data on the time line */
		breedingTimelinePage.verify_dryPeriod("30 Jun 2022");

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpcomingActivity_InseminationIsAdded(Map<String, String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Inseminated");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to cattle profile */
		new Helper_AppNavigation().goTo_CattleProfile(Tag);	
		
		/** Assert upcoming activity */
		breedingTimelinePage.verify_upcomingActivity(data.get("activity"),data.get("date"));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpcomingActivity_PDIsAdded(Map<String, String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Pregnant");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to cattle profile */
		new Helper_AppNavigation().goTo_CattleProfile(Tag);	
		
		/** Assert upcoming activity */
		breedingTimelinePage.verify_upcomingActivity(data.get("activity"),data.get("date"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpcomingActivity_DryPeriodIsAdded(Map<String, String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Dry");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to cattle profile */
		new Helper_AppNavigation().goTo_CattleProfile(Tag);	
		
		/** Assert upcoming activity */
		breedingTimelinePage.verify_upcomingActivity(data.get("activity"),data.get("date"));

	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpcomingActivity_HeatIsAdded(Map<String, String> data) throws Throwable {
	
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to Heat screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity("heat");
		
		
		/** Fill the heat data */
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert heat data on the time line */
		breedingSuccessPage.click_BackToBreedingTimeline();	
		breedingSuccessPage.click_BackToCattleProfile();
		breedingTimelinePage.verify_upcomingActivity(data.get("activity"),data.get("date"));
		
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpcomingActivity_CalvingIsAdded(Map<String, String> data) throws Throwable {
	
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle_Pregnant");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/** Go to calving screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"breeding");	
		breedingTimelinePage.click_AddActivity();
		breedingActivityListPage.select_Activity("calving");

		/** Fill calving form */
		addCalvingPage.select_CalfResultSingle(data.get("calfResult"), data.get("calfGender1"));
		addCalvingPage.enter_CalvingDate(data.get("calvingDate"));
		addCalvingPage.press_SaveButton();

		/** Assert heat data on the time line */
		breedingSuccessPage.click_BackToBreedingTimeline();	
		breedingSuccessPage.click_BackToCattleProfile();
		breedingTimelinePage.verify_upcomingActivity(data.get("activity"),data.get("date"));
		
	}
}
