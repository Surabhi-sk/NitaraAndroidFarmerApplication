package com.nitara.HousingManagement;

import org.testng.annotations.Test;




import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;


public class CreateUserdefinedShed extends GenericBase 
{
	@Test
	public void Create_Userdefinedshed() throws Throwable
	{
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();
		
		String name= createshed.Generateshedname();
			
		/** Creation of User Defined shed */
		
		/** Enter shedname */
		createshed.entershedname(name);
		
		/** Click next btn*/
		createshed.clicknextbtn();	
		
		/** Click Userdefinedshedbtn */		
		createshed.clickuserdefinedbtn();	
		
		/** Enter userdefinedshedname */
		createshed.enteruserdefinedname();	
		
		/** Click on Creategroups to create userdefined shed*/
		createshed.Clickcreatemygroups();
		
		/** capture screenshot */
		createshed.captureScreenshots("Creation of Userdefinedshed");
		
		/** search for the created shed*/ 
		shedViewPage.Searchshed(name);
		
		
		/** Assert the created shed */
		shedViewPage.Assertshed(name);
		
		
		
		
		
}
}