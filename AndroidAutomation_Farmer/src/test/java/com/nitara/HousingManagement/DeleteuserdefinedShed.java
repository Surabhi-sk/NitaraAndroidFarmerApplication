package com.nitara.HousingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;



public class DeleteuserdefinedShed extends GenericBase 
{
	@Test
	public void Delete_UserdefinedShed() throws Throwable
	{		
		/**  Go to Housing  and CreateUserdefinedshed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/** search the created shed*/ 
		shedViewPage.Searchshed(shedname);
		
		/**Click on three dots icon */		
		shedViewPage.clickonMoreOptions();
		
		/** Click Delete shed */ 
		shedViewPage.clickonDeleteGrpBtn();//delete shed btn has same id as delete grp btn
		
		/** Click delete button */
		shedViewPage.clickonyesBtn();
		
		createshed.captureScreenshots("DeleteUserdefinedshed");
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteUserdefinedShed_withoutDeletingNonEmptyGroups(Map<String,String> data) throws Throwable
	{		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
	
		/**  Go to Housing  and createUserdefinedshed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);
		
		/** Select Cattle */
		shedViewPage.ClickCheckbox();
		
		/** Select  Add to group */
		shedViewPage.ClickAddToGroup();
		
		/** Assert cattle added to grp **/
		shedViewPage.AssertCattleAdditionToGroup(Tag);
		
		shedViewPage.Clickgobacktoshed();
		
		shedViewPage.Searchshed(shedname);
		
		/**Click on three dots icon */		
		shedViewPage.clickonMoreOptions();
		
		/** Click Delete shed */ 
		shedViewPage.clickonDeleteGrpBtn();//delete shed btn has same id as delete grp btn
		
		shedViewPage.assertWarningMsg(data.get("warningMessage"));;
		
		
	}
	
}