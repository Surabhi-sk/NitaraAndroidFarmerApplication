package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;



public class AddVaccination extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Vaccination_AddData(Map<String,String> data) throws Throwable {


		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** In this function -
		 * Reach the add health activity page for the cattle 
		 * Register a Cattle
		 * Reach the add health activity page for the registered cattle
		 * Farmer HomePage -> Health Management -> Search Cattle with Tag No 
		 * -> Select health activity from the list
		 * 
		 * @param activity type - Vaccination /Deworming /Treatment
		 */
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill Vaccination Form */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.enter_vaccinationDate(generateRandomData.getPastDate(25));
		addVaccinationPage.click_Save();


		/** Assert record success message for the activity 
		 * @Param activity type - Vaccination /Deworming /Treatment 
		 */	
		healthRecordSuccessPage.captureScreenshots("AddVaccination");
		healthRecordSuccessPage.assertSuccessMsg("Vaccination");

	}	
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_DosageMandate(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill vaccination form  */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
//		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_AmountMandate(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill vaccination form  */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
//		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_VaccineTypeMandate(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill vaccination form  */
//		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_BeforeDOB(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill vaccination form  */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.enter_vaccinationDate(data.get("date"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_TheileriaAlreadyGiven(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill vaccination form  */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();
		healthRecordSuccessPage.homeButton();
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertAlert(data.get("warningMessage"));
	}
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_CattleAgeLessThan4Months(Map<String,String> data) throws Exception {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill vaccination form  */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.enter_vaccinationDate(data.get("date"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertAlert(data.get("warningMessage"));
	}

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_AddDataMultipleCattle(Map<String,String> data) throws Throwable {


		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		String Tag2 = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
		/** In this function -
		 * Reach the add health activity page for the cattle 
		 * Register a Cattle
		 * Reach the add health activity page for the registered cattle
		 * Farmer HomePage -> Health Management -> Search Cattle with Tag No 
		 * -> Select health activity from the list
		 * 
		 * @param activity type - Vaccination /Deworming /Treatment
		 */
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill Vaccination Form */
		addVaccinationPage.click_addCattle();
		searchCattlePage.searchCattle(Tag2);
		addVaccinationPage.click_checkbox();
		addVaccinationPage.click_continue();
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.enter_vaccinationDate(generateRandomData.getPastDate(25));
		addVaccinationPage.click_Save();


		/** Assert record success message for the activity 
		 * @Param activity type - Vaccination /Deworming /Treatment 
		 */	
		healthRecordSuccessPage.captureScreenshots("AddVaccination");
		healthRecordSuccessPage.assertSuccessMsg("Vaccination");

	}	
}
