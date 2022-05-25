package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsPage extends BasePage{
	

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*tvMilkingPreference.*\"))")  
	private MobileElement MilkingPreference_btn;
	
	public void select_MilkingPreference()
	{	
		click(MilkingPreference_btn);	
	}

}
