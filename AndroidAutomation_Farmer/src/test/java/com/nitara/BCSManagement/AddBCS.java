package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.HousingManagement.Createsmartshed;
import com.nitara.utils.DataProviderUtils;


import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddBCS  extends GenericBase 
{
	@Test
	public void AddBcs() throws Exception
	
	{	
		
		/** Register cattle */
		
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Wait for farmer page to load */	
		farmerHomePage.waitForPageLoad();	
		
		/** Click Body condition score button in Homepage*/
		farmerHomePage.click_bcs_btn();
		
		/** Search cattle from cattlelist */		
		helper_AppNavigation.selectCattle(Tag);
			

		addbcsPage.waitForPageLoad();
		
		
		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();
		
		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));
		
		/** Save Bcs Data */
		addbcsPage.press_SaveButton();		
	
		/** capture screenshot */
		addbcsPage.captureScreenshots("Add BCS");
	

	}	
		
		
}
