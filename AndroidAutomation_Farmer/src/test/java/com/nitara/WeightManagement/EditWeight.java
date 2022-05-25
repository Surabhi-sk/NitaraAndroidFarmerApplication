package com.nitara.WeightManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class EditWeight extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Weight_EditData(Map<String,String> data) throws Exception {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Go to Cattle Profile - Select weight **/
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag,"Weight");
		
		/** View Weight Screen */
		weightViewPage.click_addWeight();
		
		/** Fill Add weight form - Assert Success Page */
		data.put("Date",new GenerateRandomData().getPastDate(1));
		addWeightPage.fillAddWeightForm(data);
		weightSuccessPage.assert_weightSuccessPage(data.get("calculateBy"));
		weightSuccessPage.click_recordAnotherWeightEntry(); // Go to view screen 
		
		/** Edit the added weight */
		weightViewPage.click_moreOptions();
		weightViewPage.click_editOption();
		addWeightPage.enter_weightDate(new GenerateRandomData().getPastDate(10));
		addWeightPage.click_saveBtn();
		
		weightSuccessPage.captureScreenshots("EditWeight");
		weightSuccessPage.click_recordAnotherWeightEntry();
		//weightViewPage.assert_weightDate(new GenerateRandomData().getPastDate(10));
		
		
	}

}
