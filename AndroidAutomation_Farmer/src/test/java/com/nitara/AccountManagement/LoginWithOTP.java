package com.nitara.AccountManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class LoginWithOTP extends GenericBase{

	@Test
	public void LoginwithOTP_ValidData() throws Exception{

		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial

		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("2270722909");
		enterPhoneNoPage.click_continue();

		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();

		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();

		/** Navigated to Farmer Home page - assert if user on farmer homepage */
		farmerHomePage.assert_farmerHomePage();

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void LoginwithOTP_LessThan4Digits(Map<String,String> data) throws Exception{

		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial

		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("2270722909");
		enterPhoneNoPage.click_continue();

		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();

		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.enter_otp("111 ");
		enterOTPpage.click_ContinueBtn();


		/** Assert Warning Message */
		WarningPage.captureScreenshots("Login with OTP less than 4 digits");
		WarningPage.assertWarningMsg(data.get("warningMessage"));
	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void LoginwithOTP_IncorrectOTP(Map<String,String> data) throws Exception{

		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial

		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("2270722909");
		enterPhoneNoPage.click_continue();

		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();

		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.enter_otp("1234");
		enterOTPpage.click_ContinueBtn();


		/** Assert Warning Message */
		WarningPage.captureScreenshots("Login with Incorrect OTP");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void LoginWithOTP_30SecondsCounter() throws Exception{

		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial

		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("2270722909");
		enterPhoneNoPage.click_continue();

		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();

		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();

		/**Assertions */
		enterOTPpage.captureScreenshots("Navigated to Enter OTP page after clicking Resend OTP");
		enterOTPpage.assert_enterOTPpage();

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void LoginWithOTP_ResendOTPMoreThanThreeTimesViaSMS(Map<String,String> data) throws Exception{

		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial

		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("2270722909");
		enterPhoneNoPage.click_continue();

		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();

		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_ResendSMSBtn();
		//	enterPhoneNoPage.waitForPageLoad();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("Login with OTP send SMS more than 3 times");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}

	@Test(groups = {"Regression"}, dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void LoginWithOTP_ResendOTPMoreThanThreeTimesViaCall(Map<String,String> data) throws Exception{

		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial

		/** Enter Phone Number */
		enterPhoneNoPage.waitForPageLoad();
		enterPhoneNoPage.enter_PhoneNo("2270722909");
		enterPhoneNoPage.click_continue();

		/** Enter PIN */
		enterPinPage.waitForPageLoadBar();
		enterPinPage.click_loginWithOtpBtn();

		/** Enter OTP */
		enterOTPpage.waitForPageLoad();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterOTPpage.waitForResendOTPBtn();
		enterOTPpage.click_SendOTPViaCallBtn();
		enterPhoneNoPage.waitForPageLoad();

		/** Assert Warning Message */
		WarningPage.captureScreenshots("Login with OTP send OTP via call more than 3 times");
		WarningPage.assertWarningMsg(data.get("warningMessage"));

	}
}
