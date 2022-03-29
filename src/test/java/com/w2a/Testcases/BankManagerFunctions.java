package com.w2a.Testcases;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.w2a.Base.Utils;

public class BankManagerFunctions extends Utils {

	public static Logger log = Logger.getLogger(BankManagerFunctions.class);

	@Test(dataProvider = "dp1", dataProviderClass = Utils.class)
	public void addCustomerTest(String first_name, String last_name, String postcode) throws Exception {
		click("//button[@ng-click='manager()']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@ng-click='addCust()']"))));
		click("//*[@ng-click='addCust()']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@placeholder='First Name']"))));

		sendKeys("//*[@placeholder='First Name']", first_name);
		log.info(" Entered first name as :" + first_name);
		Thread.sleep(2000);

		sendKeys("//*[@placeholder='Last Name']", last_name);
		log.info(" Entered last name as :" + last_name);
		Thread.sleep(2000);

		sendKeys("//*[@placeholder='Post Code']", postcode);
		log.info(" Entered Post code as :" + postcode);
		Thread.sleep(2000);

		Thread.sleep(3000);

	}
	
	
	@Test(dataProvider = "dp", dataProviderClass = Utils.class)
	public void addCustomerTestFromExcel(Hashtable<String, String> data) throws Exception {
		click("//button[@ng-click='manager()']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@ng-click='addCust()']"))));
		click("//*[@ng-click='addCust()']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@placeholder='First Name']"))));

		sendKeys("//*[@placeholder='First Name']", data.get("firstname"));
		log.info(" Entered first name as :" + data.get("firstname"));
		Thread.sleep(2000);

		sendKeys("//*[@placeholder='Last Name']", data.get("lastname"));
		log.info(" Entered last name as :" + data.get("lastname"));
		Thread.sleep(2000);

		sendKeys("//*[@placeholder='Post Code']", data.get("postcode"));
		log.info(" Entered Post code as :" + data.get("postcode"));
		Thread.sleep(2000);

		Thread.sleep(3000);

	}


}
