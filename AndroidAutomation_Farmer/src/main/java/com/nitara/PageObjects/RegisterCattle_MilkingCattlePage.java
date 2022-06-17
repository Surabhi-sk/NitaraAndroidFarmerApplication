package com.nitara.PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_MilkingCattlePage  extends BasePage{
	
	@AndroidFindBy(id = "select_cattle_tv") 
	private MobileElement select_cattle;


	@AndroidFindBy(id = "phone_number") 
	private MobileElement phone_number;
	
	
	@AndroidFindBy(id = "earTagNumberOrName") 
	private MobileElement TagNumber;
	
	
	@AndroidFindBy(id = "cooperative_tag_number_et") 
	private MobileElement CoopTagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*crossed_with_list_spinner.*\"))") 
	private MobileElement crossed_with;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*cattle_type_spinner.*\"))") 
	private MobileElement cattle_type;
	
	@AndroidFindBy(id = "cattle_type_lbl") 
	private MobileElement cattle_type_lbl;
	
	
	@AndroidFindBy(id = "breed_list_spinner") 
	private MobileElement breed_list;
	
	@AndroidFindBy(id = "crossbreed_lbl") 
	private MobileElement crossbreed_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*crossbreed_toogle.*\"))") 
	private MobileElement crossbreed_toogle;
	
	
	@AndroidFindBy(id = "crossed_with_list_spinner") 
	private MobileElement crossbreed_list;


	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*is_pregnant.*\"))") 
	private MobileElement is_pregnant;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*insemination_type_spinner.*\"))")  
	private MobileElement insemination_type;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/pregnant_since_spinner") 
	private MobileElement pregnant_since;
	
	@AndroidFindBy(id = "inseminationDate") 
	private MobileElement inseminationDate;
	
	@AndroidFindBy(id = "semen_brand_spinner") 
	private MobileElement semen_brand;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*save_btn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*bull_id_et.*\"))") 
	private MobileElement bull_id;
	
	@AndroidFindBy(id = "is_inseminated")  
	private MobileElement is_Insemiminated;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*insemination_date_lbl.*\"))") 
	private MobileElement insemination_date_lbl;
	
	@AndroidFindBy(id = "is_cattle_dry")  
	private MobileElement is_cattle_dry;

	
	@AndroidFindBy(id = "dryPeriodDate") 
	private MobileElement dryPeriodDate;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*calf_result_spinner1.*\"))") 
	private MobileElement calf_result;
	
	
	@AndroidFindBy(id = "calf_result_spinner_2") 
	private MobileElement calf_result2;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*calf_count_spinner.*\"))") 
	private MobileElement calf_count;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*current_lactation.*\"))") 
	private MobileElement current_lactation;
	
	@AndroidFindBy(id = "calving_date") 
	private MobileElement calvingDate;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*text1.*\"))") 
	private MobileElement popup;
	
	@AndroidFindBy(id = "uploadphoto_tv")
	private MobileElement uploadphoto_tv;
	
	@AndroidFindBy(id = "upload_from_gallery")
	private MobileElement upload_from_gallery;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\""+"Pictures"+"\"))") 
	private MobileElement pictures;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]") 
	private MobileElement img;
	
	@AndroidFindBy(id = "save_and_go_back_btn")
	private MobileElement save_and_go_back_btn;
	
	@AndroidFindBy(id = "take_picture")
	private MobileElement take_picture;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private MobileElement permission_allow_button;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Shutter button\"]")
	private MobileElement shutter_button;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Done\"]")
	private MobileElement intent_done_apply;
	
	public void uploadPhotosfromCamera() {
		click(uploadphoto_tv);
//		click(upload_from_gallery);
//		click(pictures);
//		click(img);
		
		click(take_picture);
//		click(permission_allow_button);
//		click(permission_allow_button);
		waitForVisibility(shutter_button);
		click(shutter_button);
		waitForVisibility(intent_done_apply);
		click(intent_done_apply);

		
		click(save_and_go_back_btn);	
	}
	
	public void uploadPhotosfromGallery() {
		
		click(uploadphoto_tv);
		click(upload_from_gallery);
		click(pictures);
		click(img);		
		click(save_and_go_back_btn);	
	}
	
	public void select_cattleType(String cattleType) {
		List<MobileElement> cattleTypes = (List<MobileElement>) driver.findElementsById("cattle_container");
		List<MobileElement> actList = (List<MobileElement>) driver.findElementsById("title");//{ "Vaccination" , "Deworming" , "Treatment"};
		for(int i=0;i<actList.size();i++) {
			System.out.println(actList.get(i).getText());
			if(cattleType.contentEquals(actList.get(i).getText())) {
				cattleTypes.get(i).click();
				break;} }
		
	}

	public void assert_CattleType() 
	{
		waitVisibility(select_cattle);
		Assert.assertEquals(select_cattle.getText(), "MILKING AND DRY CATTLE");
	}
	
	public void assert_Phone_Number(String phone) {
		waitVisibility(phone_number);
		Assert.assertEquals(phone_number.getText(), phone);
	}
	
	public void enter_TagNumber(String tag) {
		waitVisibility(TagNumber);
		sendKeys(TagNumber,tag);
	}
	
	public void enter_CoopTagNumber(String tag) {
		waitVisibility(CoopTagNumber);
		sendKeys(CoopTagNumber,tag);
	}
	
	public void enter_CoopTagNumber(int tag) {
		waitVisibility(CoopTagNumber);
		sendKeys(CoopTagNumber,tag);
	}

	
	public void select_cattleBreed(String breed) {
		click(breed_list);
		select_dropdown(breed);
	}
	
	public void select_crossbreedToggle(String toggle,String crossbreed) {
		String checked = crossbreed_toogle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			crossbreed_toogle.click(); 
			click(crossed_with);
			select_dropdown(crossbreed);
		}
	}
	
	
	public void select_Lactation(String lact) {
		click(current_lactation);
		select_dropdown(lact);
	}
	
	
	public void enter_Calvingdate(String date) {
		waitForVisibility(calf_result);
		sendKeys(calvingDate,date);
	}
	
	public void press_SuggestionPopup() {
		click(popup);
	}
	
	public void enter_CalfCount(String count) {
		click(calf_count);
		select_dropdown(count);
	}
	
	public void enter_Calf1Gender(String gender) {
		click(calf_result);
		select_dropdown(gender);
	}
	
	public void enter_Calf2Gender(String gender) {
		click(calf_result2);
		select_dropdown(gender);
	}
	
	
	public void isCattlePregnant(String months) {
		String checked = is_pregnant.getAttribute("checked");
		if(checked.equals("false")) {
			is_pregnant.click();	
			pregnant_Since(months);
		}
	}
	
	public void isCattleInseminated() {
		String checked = is_Insemiminated.getAttribute("checked");
		if(checked.equals("false")) {
			is_Insemiminated.click();	
		}
	}
	
	public void artificialInsemination(String date,String semen,String BullId) {
		enter_InseminationDate(date);
		click(insemination_type);
		select_dropdown("Artificial");
		System.out.println(semen);
		select_semenBrand(semen);
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	
	public void naturalInsemination(String date,String BullId) {
		enter_InseminationDate(date);
		click(insemination_type);
		select_dropdown("Natural");
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	public void pregnant_Since(String months) {
		click(pregnant_since);
		select_dropdown(months+" Month");
	}
	
	public void enter_InseminationDate(String Date) {
		waitForVisibility(save_btn);
		sendKeys(inseminationDate,Date);
	}
	
	public void select_semenBrand(String semen) {
		click(semen_brand);
		select_dropdown(semen);
	}
	
	
	public void enter_BullId(String bullId) {
		sendKeys(bull_id,bullId);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void cattleIsDry() {
		waitForVisibility(save_btn);
		String checked = is_cattle_dry.getAttribute("checked");
		if(checked.equals("false")) {
			is_cattle_dry.click();	
		}	
	}
	
	public void enter_DryPeriodDate(String Date) {
		sendKeys(dryPeriodDate,Date);
	}
	
	public void assertWarningMsg(String msg) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),msg);
	} 

}
