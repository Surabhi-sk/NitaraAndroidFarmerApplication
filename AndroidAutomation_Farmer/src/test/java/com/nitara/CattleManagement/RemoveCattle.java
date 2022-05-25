package com.nitara.CattleManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class RemoveCattle extends GenericBase{

	@Test 
	public void CattleProfile_RemoveCattle() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");


		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Search Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Edit option
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"delete");

		/** Remove Cattle */
		removeCattlePage.enter_remarks("Delete text");
		removeCattlePage.enter_amount("3000");
		removeCattlePage.click_remove();
		removeCattlePage.click_yes();
		removeCattlePage.assert_deleteMsg(Tag);
		removeCattlePage.captureScreenshots("DeleteCattle");
		removeCattlePage.click_back();
		
		searchCattlePage.searchCattle(Tag);
		searchCattlePage.assert_msg();

	}

}


