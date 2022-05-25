package com.nitara.MilkingMangement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class RecordCattleMilkingData extends GenericBase{

	@Test 
	public void Milking_RecordCattleMilking() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = "40118830";//reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		// Choose Milking Preference
		new HelperFunctions().setMilkingPreferences("Cattle Milking");
		
		// Select Milk Recording Button on Farmer HomePage
		farmerHomePage.click_MilkRecordingButton();
		
		// Add Cattle Milking Data for the registered cattle
		cattleMilkingPage.searchcattle(Tag);
		cattleMilkingPage.enterYield("14.00");
		cattleMilkingPage.saveCattleMilkingDetails();
		
		//Assert Cattle Milking Success Page
		cattleMilkingSuccessPage.assertCattleYield("14.00");
		
	}

}
