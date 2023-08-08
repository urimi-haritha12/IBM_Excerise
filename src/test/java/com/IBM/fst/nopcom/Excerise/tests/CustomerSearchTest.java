package com.ibm.fst.nopcomm.exercise2.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.fst.nopcomm.exercise2.utility.BaseTest;



public class CustSearchTest extends BaseTest {
	
	@DataProvider(name="CustomerSearch")
	public Object[][] getTestData(){
		return new Object[][] {
			{"admin@yourstore.com","admin",false,"Dashboard","name","John Smith"}
			
		};
	}
	
	@Test(dataProvider = "CustomerSearch")
	public void verifyCustFunctionality(String username,String password,boolean remCheck,String dashBoardtxt,
			String criteria, String criteriaValue) throws Exception {
		
		
		loginPage.logIn(username, password, remCheck);
		
		
		custSearchPage.verifyHomepage(dashBoardtxt);		
		
		custSearchPage.clickonCustmenu();		
		
		custSearchPage.searchCustomer(criteria, criteriaValue);		
		
		custSearchPage.validateCustResult(criteriaValue,username);
		
	}

}
