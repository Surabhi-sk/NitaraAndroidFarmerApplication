package com.nitara.HousingManagement;

import java.util.Map;

import org.bouncycastle.asn1.dvcs.Data;
import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class DeleteSmartshed extends GenericBase
{
	@Test(groups = {"Regression"})
	public void Delete_Smartshed() throws Throwable

	{
		/**  Go to Housing  and creasmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/**Click on three dots icon */
		createshed.clickthreedotsicon();

		/** Click Delete shed */
		createshed.clickDeleteshed();

		/** Click delete button */
		createshed.clickyesbtn();

		//	createshed.clickmovecattleoutofgrp();

		createshed.captureScreenshots("Deletesmartshed");
	/*	createshed.clickthreedotsicon();
		createshed.clickDeletegroup();
	//	ShedViewPage.Clickgobacktoshed();

		createshed.clickyesbtn();*/




	}
	@Test(groups = {"Regression"})
	public void Delete_SmartshedGroupsAreEmpty() throws Throwable{

		/**  Go to Housing  and createsmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/**Click on three dots icon */
		createshed.clickthreedotsicon();

		/** Click Delete shed */
		createshed.clickDeleteshed();

		/** Click delete button */
		createshed.clickyesbtn();

		createshed.captureScreenshots("Deletesmartshed");

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Delete_SmartshedWithoutDeletingGroups(Map<String,String> data) throws Throwable {

		/**  Go to Housing  and createsmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();

		/** search the created shed*/
		shedViewPage.Searchshed(shedname);

		/** Select Group */
		shedViewPage.ClickGroup();

		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();

		/** Select Cattle */
		shedViewPage.ClickCheckbox();

		/** Select  Add to group */
		shedViewPage.ClickAddToGroupBtn();

		shedViewPage.Clickgobacktoshed();

		/**Click on three dots icon */
		createshed.clickthreedotsicon();

		/** Click Delete shed */
		createshed.clickDeleteshed();

		/**Capture Screenshots*/
		shedViewPage.captureScreenshots("Delete Smartshed Without deleting groups");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}

}