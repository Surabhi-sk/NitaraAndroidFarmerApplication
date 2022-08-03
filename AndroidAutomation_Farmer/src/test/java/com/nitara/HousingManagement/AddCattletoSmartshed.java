package com.nitara.HousingManagement;


import java.util.Map;

import org.bouncycastle.asn1.dvcs.Data;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddCattletoSmartshed extends GenericBase


{
	@Test(groups = {"Regression"})
	public void SmartShed_AddCattle() throws Throwable {

//		/** Register cattle */
//		String Tag = "7864334"; //new HelperFunctions().RegisterCattle_MilkingCattle();

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();

		/**  Go to Housing  and createsmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);

		/** Select Cattle */
		shedViewPage.ClickCheckbox();

		/** Select  Add to group */
		shedViewPage.ClickAddToGroupBtn();

		/**Capture Screenshots and assert*/
		shedViewPage.captureScreenshots("Add cattle to smartshed");
		shedViewPage.AssertCattleAdditionToGroup(Tag);

	}

	@Test(groups = {"Regression"})
	public void Smartshed_AddCattleToIrrelevantGroup() throws Throwable{

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();

		/**  Go to Housing  and creasmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickDryCattleGroup();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);

		/** Select Cattle */
		shedViewPage.ClickCheckbox();

		/** Select  Add to group */
		shedViewPage.ClickAddToGroupBtnOnce();

		/**Check for Warning and capture screenshots*/

		shedViewPage.captureScreenshots("Add cattle to irrelevent group");
		shedViewPage.CheckForWarningDisplay();

	}

	@Test(groups = {"Regression"})
	public void Smartshed_DisplayWarningResolvedAfterDeselectingCattle() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();


		/**  Go to Housing  and createsmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);

		/** Select Cattle */
		shedViewPage.ClickCheckbox();

		/** Select  Add to group */
		shedViewPage.ClickAddToGroupBtnOnce();

		/**Check Warning displayed*/
		shedViewPage.CheckForWarningDisplay();

		/**Deselect cattle to Check Warning Resolved*/
		shedViewPage.ResolveWarning();
		shedViewPage.captureScreenshots("Check if warning resolved after deselecting cattle");

	}

	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Smartshed_DisplayWarningWhenClickingAddtoGroupWithoutSelectingCattle(Map<String,String> data) throws Throwable {

		/**  Go to Housing  and createsmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/** Select  Add to group */
		shedViewPage.ClickAddToGroupBtnOnce();

		/**Assert Warning Message*/
		shedViewPage.captureScreenshots("Clicking Add to group without selecting cattle");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Smartshed_DisplayMessageWhenAllCattleAddedToFarm(Map<String,String> data) throws Throwable{

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();

		/**  Go to Housing  and createsmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/**Add All Cattle to Group*/
		shedViewPage.ClickSelectallcheckbox();

		/**Select Add Cattle to Group*/
		shedViewPage.ClickAddToGroupBtn();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/**Assert Display Message*/
		shedViewPage.captureScreenshots("Display Message when all cattle added to farm");
		shedViewPage.assertMsg(data.get("warningMessage"));

	}
}

