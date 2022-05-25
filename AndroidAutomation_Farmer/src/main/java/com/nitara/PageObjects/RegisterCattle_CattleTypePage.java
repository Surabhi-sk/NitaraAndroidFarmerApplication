package com.nitara.PageObjects;

import java.util.List;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class RegisterCattle_CattleTypePage extends BasePage{
	
	public void select_cattleType(String cattleType) {
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\""+cattleType+"\"))"));
		element.click();//{ "Vaccination" , "Deworming" , "Treatment"};
//		for(int i=0;i<actList.size();i++) {
//			System.out.println(actList.get(i).getText());
//			if(cattleType.contentEquals(actList.get(i).getText())) {
//				cattleTypes.get(i).click();
//				break;} }
//		(AppiumBy.xpath("//android.widget.CheckedTextView[@text='"+mon+"']"))
	}


}
