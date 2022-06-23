package com.nitara.AccountManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;

public class SignUp extends GenericBase{

	@Test
	public void SignUp_ValidData() throws Exception {
		
		/** Select Language */
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Enter Username */
		String firstName = "fName"+generateRandomData.generateRandomNumber(2);
		String lastName = "lName"+generateRandomData.generateRandomNumber(2);
		enterUsername.enter_firstName(firstName);
		enterUsername.enter_lastName(lastName);
		enterUsername.click_createNewAccount();
		
		/** Assert Success Page */
		createAccountSuccessPage.assert_snackBarText();
		createAccountSuccessPage.assert_successPageMsg();
		createAccountSuccessPage.click_getStartedBtn();
		
		/** Navigated to Farmer Home page - assert if set location option is shown */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.assert_farmerHomePageAfterSignUp();

		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_phoneNumberLessThan10Digits(Map<String,String> data) throws Exception{
			
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(9);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression")
	public void SignUp_phoneNumberGreaterThan10Digits() throws Exception{
			
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(11);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		
		/** Assert Phone number entered is only taken upto 10 digits, extra digits are discarded*/
		enterPhoneNoPage.assertPhoneNumber(phone);
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_OTPLessThan4Digits(Map<String,String> data) throws Exception{
			
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_3digitotp(data.get("otp"));
		enterOTPpage.click_ContinueBtn();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_incorrectOTP(Map<String,String> data) throws Exception{
			
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp(data.get("otp"));
		enterOTPpage.click_ContinueBtn();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression")
	public void SignUp_fromOTPPageGoToPhoneNumberPage() throws Exception{
			
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** On OTP page we click on change phone number link */
		enterOTPpage.changePhoneNo();
		
		/** Assert Page */
		enterPhoneNoPage.assertPage();
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_enterPINlessThan6Digits(Map<String,String> data) throws Exception{
			
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(12345);
		createPasswordPage.click_savePin();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_PINandConfirmPINdoesntMatch(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123457);
		createPasswordPage.click_savePin();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_NoFirstNameEntered(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Click on create new account without entering first name */
		enterUsername.click_createNewAccount();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_NoLastNameEntered(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Click on create new account without entering last name */
		String firstName = "fName"+generateRandomData.generateRandomNumber(2);
		enterUsername.enter_firstName(firstName);
		enterUsername.click_createNewAccount();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_FirstNameLessThan2Digits(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Enter first name of 1 digit */
		String firstName = generateRandomData.generateRandomNumber(1);
		enterUsername.enter_firstName(firstName);
		enterUsername.click_createNewAccount();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_LastNameLessThan2Digits(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Enter last name of 1 digit */
		String firstName = "fName"+generateRandomData.generateRandomNumber(2);
		String lastName = generateRandomData.generateRandomNumber(1);
		enterUsername.enter_firstName(firstName);
		enterUsername.enter_lastName(lastName);
		enterUsername.click_createNewAccount();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
	
	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void SignUp_MiddleNameLessThan2Digits(Map<String,String> data) throws Exception{
		
		/** Select Language */
		chooseLanguagePage.waitForPageLoad();
		chooseLanguagePage.select_Language("ENGLISH");
		
		String phone =generateRandomData.generateRandomNumber(10);
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();
		
		/** Enter last name of 1 digit */
		String firstName = "fName"+generateRandomData.generateRandomNumber(2);
		String middleName = generateRandomData.generateRandomNumber(1);
		String lastName = "lName"+generateRandomData.generateRandomNumber(2);
		enterUsername.enter_firstName(firstName);
		enterUsername.enter_middleName(middleName);
		enterUsername.enter_lastName(lastName);
		enterUsername.click_createNewAccount();
		
		/** Assert Warning Message */
		enterPhoneNoPage.assertWarningMsg(data.get("warningMessage"));
		
	}
}
