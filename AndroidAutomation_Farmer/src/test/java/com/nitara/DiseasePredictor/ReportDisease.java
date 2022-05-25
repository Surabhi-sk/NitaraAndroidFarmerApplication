package com.nitara.DiseasePredictor;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.PageObjects.Disease_PredictorPage;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class ReportDisease extends GenericBase

{		@Test

	public void ReportDisease() throws Throwable

{		
	/** Register cattle */
	String url = prop.getProperty("APIbaseUrl");
	RegisterMilkingCattle reg = new RegisterMilkingCattle();
	String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");

	/** Wait for farmer page to load */	
	farmerHomePage.waitForPageLoad();	

	/** Click Disease predictor  button in Homepage*/
	farmerHomePage.click_DiseasePredictorButton();

	/** Search cattle from cattlelist */		
	helper_AppNavigation.selectCattle(Tag);

	/** Skip  turotial if Displayed*/
	//diseasepredictorpage.Clickskip_btn();

	/** Add Sysmptoms **/
	diseasepredictorpage.AddSymptoms();

	/** capture screenshots */
	diseasepredictorpage.captureScreenshots("Report Disease");

	/** Go Back to Farmer Homepage */ 
	diseasepredictorpage.GoBackToHomepage();

}

}