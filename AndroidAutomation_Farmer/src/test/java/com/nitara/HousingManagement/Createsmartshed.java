package com.nitara.HousingManagement;

import java.util.Map;

import org.bouncycastle.asn1.dvcs.Data;
import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;


public class Createsmartshed extends GenericBase
{
	@Test
	public void Createsmartshed_ValidData() throws Throwable
	{
		String name= createshed.Generateshedname();

		/** Go to Selection of Shedtype page */
		farmerHomePage.waitForPageLoadBar();
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();

		/** Creation of SmartShed */

		/** Enter shed name */
		createshed.entershedname(name);

		/** Click next  button */
		createshed.clicknextbtn();

		/** Click smart shed */
		createshed.clicksmartshedbtn();

		/** Select smartgroups */
		createshed.selectSmartGroup("Dry");
		createshed.selectSmartGroup("Early Milking");
		createshed.selectSmartGroup("Late Milking");
		createshed.selectSmartGroup("3-6 Month Calf");

		/** Click create smartshed button */
		createshed.clickcreatesmartshedbtn();

		/** capture screenshot */
		createshed.captureScreenshots("Creation of smartshed");

		/** search for the created shed*/
		shedViewPage.Searchshed(name);


		/** Assert the created shed */
		shedViewPage.Assertshed(name);

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreatesmartShed_DuplicateName(Map<String,String> data) throws Throwable{

		String name= createshed.Generateshedname();

		/** Go to Selection of Shedtype page */
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();

		/** Creation of SmartShed */

		/** Enter shed name */
		createshed.entershedname(name);

		/** Click next  button */
		createshed.clicknextbtn();

		/** Click smart shed */
		createshed.clicksmartshedbtn();

		/** Select smartgroups */
		createshed.selectSmartGroup("Dry");

		/** Click create smartshed button */
		createshed.clickcreatesmartshedbtn();

		/**Create new shed*/
		createshed.ClickAddShedbtn();

		/**Add same name as previous shed*/
		createshed.entershedname(name);

		/** Click next  button */
		createshed.clicknextbtn();

		/** capture screenshot */
		createshed.captureScreenshots("Creation of smartshed");

		/**Assert Warning MEssage*/
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreateSmartShed_NameMandatory(Map<String,String> data) throws Throwable{

		/** Go to Selection of Shedtype page */
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();

		/** Click next  button */
		createshed.clicknextbtn();

		/** capture screenshot */
		createshed.captureScreenshots("Creation of smartshed without a name");

		/**Assert Warning MEssage*/
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreateSmartShed_SpecialCharacters(Map<String,String> data) throws Throwable{

		/** Go to Selection of Shedtype page */
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();

		/** Creation of SmartShed */

		/** Enter shed name */
		createshed.entershedname("12#@c%");

		/** Click next  button */
		createshed.clicknextbtn();

		/** capture screenshot */
		createshed.captureScreenshots("Creation of smartshed without a name");

		/**Assert Warning MEssage*/
//		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void CreateSmartShed_NoSmartGroups(Map<String,String> data) throws Throwable{

		String name= createshed.Generateshedname();

		/** Go to Selection of Shedtype page */
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();

		/** Creation of SmartShed */

		/** Enter shed name */
		createshed.entershedname(name);

		/** Click next  button */
		createshed.clicknextbtn();

		/** Click smart shed */
		createshed.clicksmartshedbtn();

		/** Click create smartshed button */
		createshed.clickcreatesmartshedbtn();

		/** capture screenshot */
		createshed.captureScreenshots("Creation of smartshed");

		/**Assert Warning MEssage*/
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}


}