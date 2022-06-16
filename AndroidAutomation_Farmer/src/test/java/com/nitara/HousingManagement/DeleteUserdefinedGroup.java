package com.nitara.HousingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class DeleteUserdefinedGroup extends GenericBase{
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteUserdefinedGroup_deletelastGrp(Map<String,String> data) throws Throwable{
		
		/**  Go to Housing  and CreateUserdefinedshed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		/**  Get Group Name */
		String  grpname = shedViewPage.getGroupName();
		
		/** Click on More Options **/
		shedViewPage.clickonMoreOptions();
		
		/** Click on Delete Button **/
		shedViewPage.clickonDeleteGrpBtn();
		
		/** Assert Delete Group Warning Message **/
		shedViewPage.assert_deleteGrpWarningMsg(data.get("warningMessage"),shedname,grpname);
		
		/** Click on Yes **/
		shedViewPage.clickonyesBtn();
		
		/** Assert success message **/
		shedViewPage.assert_deleteGrpSuccessMsg(data.get("successMessage"),shedname,grpname);
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteUserdefinedGroup_deleteGrp(Map<String,String> data) throws Throwable{
		
		/**  Go to Housing  and CreateUserdefinedshed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/**  Add another Group */
		shedViewPage.clickonAddGrpBtn();
		shedViewPage.EnterGrpName();
		shedViewPage.clickonCreateGrp();
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		/**  Get Group Name */
		String  grpname = shedViewPage.getGroupName();
		
		/** Click on More Options **/
		shedViewPage.clickonMoreOptions();
		
		/** Click on Delete Button **/
		shedViewPage.clickonDeleteGrpBtn();
		
		/** Assert Delete Group Warning Message **/
		shedViewPage.assert_deleteGrpWarningMsg(data.get("warningMessage"),shedname,grpname);
		
		/** Click on Yes **/
		shedViewPage.clickonyesBtn();
		
		/** Assert success message **/
		shedViewPage.assert_deleteGrpSuccessMsg(data.get("successMessage"),shedname,grpname);
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteUserdefinedGroup_deleteGrpwithCattle(Map<String,String> data) throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		
		/**  Go to Housing  and CreateUserdefinedshed */
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
		
		/** Click on More Options **/
		shedViewPage.clickonMoreOptions();
		
		/** Click on Delete Button **/
		shedViewPage.clickonDeleteGrpBtn();
		
		/** Assert Delete Group Warning Message **/
		shedViewPage.assert_deleteGrpWithCattleWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteUserdefinedGroup_deletelastGrpoflastShed(Map<String,String> data) throws Throwable{
		
		/** CreateUserdefinedshed **/
		helperFunctions.OnlyCreateUserdefinedshed();
		
		/** Delete all except the last shed **/
		shedViewPage.deleteAllExceptLastShed();
		
		/** Delete the last shed **/
		shedViewPage.deleteLastShed(data.get("warningMessage"),data.get("successMessage"));
		
	}
	
	
}
