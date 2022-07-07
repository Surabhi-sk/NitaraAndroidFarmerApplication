package com.nitara.HousingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;
import appCommonClasses.Helper_AppNavigation;

public class DelteSmartgroup extends GenericBase
{
	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deletegroup_DeleteSmartGroup(Map<String,String> data) throws Throwable

	{

		/**  Go to Housing  and create smartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();
		String  grpname = shedViewPage.getGroupName();

		/** Click three dots option */
		shedViewPage.clickonMoreOptions();

		/** Click delete from the option*/
		shedViewPage.clickonDeleteGrpBtn();

		/** Click yes button to delete the group*/
		shedViewPage.clickonyesBtn();

		/**Capture Screenshots*/
		shedViewPage.captureScreenshots("Delete Smartshed");
		shedViewPage.assert_deleteGrpSuccessMsg(data.get("successMessage"),shedname,grpname);

		/*createshed.clickmovecattleoutofgrp();
		createshed.clickthreedotsicon();
		createshed.clickDeletegroup();
		//ShedViewPage.Clickgobackbtn();*/

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deletegroup_cattleExists(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();

		/**  Go to Housing  and create smartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();

		shedViewPage.ClickAddCattleToGroupBtn();

		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);

		shedViewPage.ClickCheckbox();

		shedViewPage.ClickAddToGroupBtn();

		createshed.clickthreedotsicon();

		/** Click delete from the option*/
		createshed.clickDeletegroup();

		/**Capture Screenshots*/
		shedViewPage.captureScreenshots("Delete Smartshed with existing cattle");
		shedViewPage.assert_deleteGrpWithCattleWarningMsg(data.get("warningMessage"));

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deletegroup_lastGroupOfLastActiveShed(Map<String,String> data) throws Throwable {

		/**  Go to Housing  and create smartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** Delete all except the last shed **/
		shedViewPage.deleteAllExceptLastShed();

		/** Delete the last group in last shed **/
		shedViewPage.deleteLastShed(data.get("warningMessage"),data.get("successMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deletegroup_LastGroupWhenOtherShedsActive(Map<String,String> data) throws Throwable {

		/**  Go to Housing  and create smartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/**Create another shed*/
		String newShedName = new HelperFunctions().CreateAnotherSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(newShedName);

		/**Delete all groups except last*/
		shedViewPage.deleteGrpsExceptLAst();

		/**Delete last group*/
		shedViewPage.ClickGroup();
		String  grpname = shedViewPage.getGroupName();
		shedViewPage.clickonMoreOptions();
		shedViewPage.clickonDeleteGrpBtn();
		shedViewPage.clickonyesBtn();

		/**Capture Screenshots*/
		shedViewPage.captureScreenshots("Delete Smartshed");
		shedViewPage.assert_deleteGrpSuccessMsg(data.get("successMessage"),newShedName,grpname);
	}
}