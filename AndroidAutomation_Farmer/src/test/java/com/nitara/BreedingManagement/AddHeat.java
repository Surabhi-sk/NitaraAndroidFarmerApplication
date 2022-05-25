package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddHeat extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	@Parameters("url")
	public void Heat_AddData(Map<String,String> data) throws Throwable {
	
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** Go to Heat screen */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"heat");	
		
		/** Fill the heat data */
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.captureScreenshots("AddHeat");
		breedingSuccessPage.cattletag_Assert(Tag);	
	}
}
