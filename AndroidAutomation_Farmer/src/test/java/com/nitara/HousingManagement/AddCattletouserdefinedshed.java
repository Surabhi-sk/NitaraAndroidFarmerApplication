package com.nitara.HousingManagement;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddCattletouserdefinedshed extends GenericBase 
{
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCattletoUserdefinedShed_AddCattletoGroupWhenCattleSelectedforMoving(Map<String,String> data) throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and creatuserdefinedshed */
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
		
		/** Select all Cattle */
		shedViewPage.clickSelectAll();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Assert warning **/
		shedViewPage.assertWarningMsg(data.get("warningMessage"));

	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCattletoUserdefinedShed_addAlreadyAddedCattletoShed(Map<String,String> data) throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and creatuserdefinedshed */
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
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);
		
		/** Assert warning **/
		shedViewPage.assertWarningMsg(data.get("warningMessage"));
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCattletoUserdefinedShed_addAllCattletoShed(Map<String,String> data) throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and creatuserdefinedshed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Select all Cattle */
		shedViewPage.clickSelectAll();
		
		/** Select  Add to group */
		shedViewPage.ClickAddToGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Assert all cattle added to grp **/
		shedViewPage.assertMsg(data.get("warningMessage"));
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddCattletoUserdefinedShed_NavigatetoGroupViewWithoutCattleSelection(Map<String,String> data) throws Throwable{
		
		/**  Go to Housing  and creatuserdefinedshed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Select  Add to group */
		shedViewPage.ClickAddToGroup();
		
		/** Assert warning **/
		shedViewPage.assertWarningMsg(data.get("warningMessage"));
	}
	
	@Test
	public void AddCattletoUserdefinedShed() throws Throwable
	{		
	
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
	
		/**  Go to Housing  and creatuserdefinedshed */
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
	
		
	}
}
