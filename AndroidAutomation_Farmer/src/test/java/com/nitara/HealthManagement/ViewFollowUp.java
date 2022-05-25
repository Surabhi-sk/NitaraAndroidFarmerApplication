package com.nitara.HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.AddFollowUpAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class ViewFollowUp extends GenericBase{

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

		helper_AppNavigation.goTo_ViewHealthActivityScreen(Tag,"Treatment");
		/** View Treatment screen - Assert details*/
		viewTreatmentPage.waitForPageLoad();	
		viewTreatmentPage.select_viewMore();	
		viewTreatmentPage.assert_FollowUpDate(new GenerateRandomData().getPastDate(0));

	}
}
