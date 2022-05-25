package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import com.nitara.utils.PropertyManager;

import appCommonClasses.GenericBase;

public class Login extends GenericBase{
	@Test
	public void Login_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("6352817747");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.enter_pin("123456");
		enterPinPage.click_loginBtn();
		
		/** Navigated to Farmer Home page - assert if user on farmer homepage */
		farmerHomePage.assert_farmerHomePage();
	}

}
