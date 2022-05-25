package com.nitara.HousingManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;



public class DeleteuserdefinedShed extends GenericBase 
{
	@Test
	public void Delete_UserdefinedShed() throws Throwable
	{		
		/**  Go to Housing  and creatuserdefinedshed */
		String  shedname = new HelperFunctions().CreateUserdefinedshed();	
		
		/** search the created shed*/ 
		shedViewPage.Searchshed(shedname);
		
		
		/**Click on three dots icon */		
		createshed.clickthreedotsicon();
		
		/** Click Delete shed */ 
		createshed.clickDeleteshed();
		
		/** Click delete button */
		createshed.clickyesbtn();
		
	//	createshed.clickmovecattleoutofgrp();
		
		createshed.captureScreenshots("DeleteUserdefinedshed");
}
	
}
