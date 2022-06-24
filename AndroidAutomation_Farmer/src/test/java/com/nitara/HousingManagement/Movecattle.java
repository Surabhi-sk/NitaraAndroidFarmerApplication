package com.nitara.HousingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class Movecattle extends GenericBase
{	
	
	@Test
	public void Movecattle_fromUserdefinedToSmartShed() throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and create smart shed */
		String  smart_shedname = new HelperFunctions().CreateSmartshed();		
	
		/**  create user defined shed */
		String  shedname = helperFunctions.CreateUserdefinedshedfromShedViewPage();	
		
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
		
		shedViewPage.waitForPageLoad();
		
		/** Select  cattle */
		shedViewPage.ClickSelectallcheckbox();
		
		/** Move  cattle */
		shedViewPage.movecattle(smart_shedname);	
		
		movecattlesuccesspage.Movecattle_Assert();
		
		
	}
	
	@Test
	public void Movecattle_fromSmartShedToUserdefined() throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  create user defined shed */
		String  shedname = helperFunctions.CreateUserdefinedshed();	
		
		/**  Go to Housing  and create smart shed */
		String  smart_shedname = new HelperFunctions().CreateSmartshedfromShedViewPage();		
	
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
		
		shedViewPage.waitForPageLoad();
		
		/** Select  cattle */
		shedViewPage.ClickSelectallcheckbox();
		
		/** Move  cattle */
		shedViewPage.movecattle(shedname);	
		
		movecattlesuccesspage.Movecattle_Assert();
		
		
	}
	
	@Test
	public void Movecattle_toAnotherGroupinSameSmartShed() throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and create smart shed */
		String  smart_shedname = new HelperFunctions().CreateSmartshed();
		
		/**  Add another Group */
		shedViewPage.clickonAddGrpBtn();
		shedViewPage.clickOpenandMilkingGroup();
		shedViewPage.clickonAddGrpToSmartShedBtn();
	
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
		
		shedViewPage.waitForPageLoad();
		
		/** Select  cattle */
		shedViewPage.ClickSelectallcheckbox();
		
		/** Move  cattle */
		shedViewPage.movecattle(smart_shedname);	
		
		movecattlesuccesspage.Movecattle_Assert();
		
		
	}
	
	@Test
	public void Movecattle_toAnotherGroupinSameUserdefinedShed() throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and create smart shed */
		String  shedname = new HelperFunctions().CreateUserdefinedshed();
		
		/**  Add another Group */
		shedViewPage.clickonAddGrpBtn();
		shedViewPage.EnterGrpName();
		shedViewPage.clickonCreateGrp();
	
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
		
		shedViewPage.waitForPageLoad();
		
		/** Select  cattle */
		shedViewPage.ClickSelectallcheckbox();
		
		/** Move  cattle */
		shedViewPage.movecattle(shedname);	
		
		movecattlesuccesspage.Movecattle_Assert();
		
		
	}
	
	@Test(groups="Regression")
	public void Movecattle_toNonRecommendedSmartGroup() throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and create smart shed */
		String  shedname = new HelperFunctions().CreateSmartshed();
		
		/**  Add another Group */
		shedViewPage.clickonAddGrpBtn();
		shedViewPage.clickEarlyMilkingGroup();
		shedViewPage.clickonAddGrpToSmartShedBtn();
	
		/** Select Group */
		shedViewPage.ClickLateMilkingGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);
		
		/** Select Cattle */
		shedViewPage.ClickCheckbox();
		
		/** Select  Add to group */
		shedViewPage.ClickAddToGroup();
		
		shedViewPage.waitForPageLoad();
		
		/** Select  cattle */
		shedViewPage.ClickSelectallcheckbox();
		
		/** Move  cattle */
		shedViewPage.movecattle(shedname);	
		
		shedViewPage.Movecattle_Warning();
		
		
	}
	
	
	@Test
	public void Movecattle_toVerifyWarningResolvedMessage() throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and create smart shed */
		String  shedname = new HelperFunctions().CreateSmartshed();
		
		/**  Add another Group */
		shedViewPage.clickonAddGrpBtn();
		shedViewPage.clickEarlyMilkingGroup();
		shedViewPage.clickonAddGrpToSmartShedBtn();
	
		/** Select Group */
		shedViewPage.ClickLateMilkingGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Search Cattle **/
		shedViewPage.searchCattle(Tag);
		
		/** Select Cattle */
		shedViewPage.ClickCheckbox();
		
		/** Select  Add to group */
		shedViewPage.ClickAddToGroup();
		
		shedViewPage.waitForPageLoad();
		
		/** Select  cattle */
		shedViewPage.ClickSelectallcheckbox();
		
		/** Move  cattle */
		shedViewPage.movecattle(shedname);	
		
		shedViewPage.waitForPageLoad();
		
		shedViewPage.Movecattle_Warning();
		
		shedViewPage.resolveWarning();
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Movecattle_verifyMoveBtnIsDisabledWhenNocattleIsSelected(Map<String,String> data) throws Throwable{
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		/** Refresh Farmer home page **/
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_HomeButton();
		
		/**  Go to Housing  and create smart shed */
		String  shedname = new HelperFunctions().CreateSmartshed();
	
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
		
		/** Move  cattle */
		shedViewPage.clickOnMoveCattleBtn();	
		
		shedViewPage.assertWarningMsg(data.get("warningMessage"));
	}
	
	@Test
		public void Movecattle_moveMultipleCattle() throws Throwable{
			
			/** Register 2 cattle */
			String url = prop.getProperty("APIbaseUrl");
			String Tag =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
			String Tag1 =  registerCattleApi.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
			
			/** Refresh Farmer home page **/
			farmerHomePage.waitForPageLoad();
			farmerHomePage.click_HomeButton();
			
			/**  Go to Housing  and create user defined shed */
			String  shedname = new HelperFunctions().CreateUserdefinedshed();
			
			/**  Add another Group */
			shedViewPage.clickonAddGrpBtn();
			shedViewPage.EnterGrpName();
			shedViewPage.clickonCreateGrp();
		
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
			
			/** Select Add cattle to group */
			shedViewPage.ClickAddCattleToGroupBtn();
			
			/** Search Cattle **/
			shedViewPage.searchCattle(Tag1);
			
			/** Select Cattle */
			shedViewPage.ClickCheckbox();
			
			/** Select  Add to group */
			shedViewPage.ClickAddToGroup();
			
			shedViewPage.waitForPageLoad();
			
			/** Select  cattle */
			shedViewPage.ClickSelectallcheckbox();
			
			/** Move  cattle */
			shedViewPage.movecattle(shedname);	
			
			movecattlesuccesspage.Movecattle_Assert();
			
			
		}
	
	
}