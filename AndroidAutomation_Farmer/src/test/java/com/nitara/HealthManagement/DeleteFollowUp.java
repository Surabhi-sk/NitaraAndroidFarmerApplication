package com.nitara.HealthManagement;

import org.testng.annotations.Test;
import com.nitara.APIFunctions.AddFollowUpAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import appCommonClasses.GenericBase;

public class DeleteFollowUp extends GenericBase{

	@Test
	public void FollowUp_ViewData() throws Exception {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** In this function -
		 * Add Treatment to the cattle through API
		 * Add Follow Up to that treatment through API
		 */

		new AddFollowUpAPI().addFollowUpDetails(url,Tag);

		farmerHomePage.waitForPageLoad();
		helper_AppNavigation.goTo_ViewHealthActivityScreen(Tag,"Treatment");
		/** View Treatment screen - Assert details*/
		viewTreatmentPage.waitForPageLoad();	
		viewTreatmentPage.select_viewMore();	
		viewTreatmentPage.click_moreOptions();
		viewTreatmentPage.click_deleteOption();
		viewTreatmentPage.click_yesBtn();
		viewTreatmentPage.assert_deleteMsg();

	}
}
