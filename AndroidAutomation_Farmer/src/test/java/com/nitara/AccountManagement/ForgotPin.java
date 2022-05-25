package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;

public class ForgotPin extends GenericBase{


	@Test
	public void ForgotPin_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("4444444443");
		enterPhoneNoPage.click_continue();
		
		/**Forgot PIN */
		enterPinPage.click_forgotPinBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Set PIN */
		int pin = Integer.parseInt(generateRandomData.generateRandomNumber(6));
		createPasswordPage.enter_createPin(pin);
		createPasswordPage.enter_reEnterPin(pin);
		createPasswordPage.click_savePin();
		
		/** Navigated to Farmer Home page - assert if user on farmer homepage */
		farmerHomePage.assert_farmerHomePage();
		
	}

}
