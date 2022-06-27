package com.nitara.HealthManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class EditVaccination extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Vaccination_EditData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);		
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_vaccinationDate(date);
		addVaccinationPage.click_Save();
		
		
		/* View Vaccination Data screen assert - edited data */
		viewVaccinationPage.captureScreenshots("EditVaccination");
//		viewVaccinationPage.select_viewMore();
//		viewVaccinationPage.assert_vaccineDate(date);		
	}
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_EditDataDosageMadatory(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_dosage("");
		addVaccinationPage.enter_vaccinationDate(date);
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_EditDataAmountMandate(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_Amount("");
		addVaccinationPage.enter_vaccinationDate(date);
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_EditDataVaccineTypeMandate(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_vaccinationDate(date);
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_EditDataBeforeDOB(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_vaccinationDate(data.get("date"));
		addVaccinationPage.click_Save();
		addVaccinationPage.assertWarning(data.get("warningMessage"));
	}
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_EditDataTheileriaAlreadyGiven(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_vaccinationDate(date);
		addVaccinationPage.click_Save();
		addVaccinationPage.assertAlert(data.get("warningMessage"));
	}
	
	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void UpdateVaccination_EditDataCattleAgeLessThan4Months(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date =  generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_vaccinationDate(data.get("date"));
		addVaccinationPage.click_Save();
//		addVaccinationPage.assertAlert(data.get("warningMessage"));
	}

}
