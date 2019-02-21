package com.cg.emailReg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.pageBeans.RegPageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegStepDef {

	private WebDriver driver;
	private RegPageFactory rpg;

	@Before
	public void openBrowsser() {
		String strDriver= "D:\\Seleniums Lib\\ex\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", strDriver);
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rpg = new RegPageFactory(driver);

		driver.get("file:///D:/Seleniums%20Lib/ex/WorkingWithForms.html");
	}
	@Given("^user is on the registeration page$")
	public void user_is_on_the_registeration_page() throws Throwable {
		openBrowsser();
	}

	@Then("^check the title of the page$")
	public void check_the_title_of_the_page() throws Throwable {
		if (driver.getTitle().equals("Email Registration Form")) System.out.println("TestCase 1:***Title Matched");
		else System.out.println("TestCase 1:\n****Title Not Matched");
		driver.close();
	}

	@When("^user enters correct details$")
	public void user_enters_correct_details() throws Throwable {
		rpg.setPfuserPwd("abcd");
		rpg.setPfuserCnfPwd("abcd");
		rpg.setPfuserGender("Male");
		rpg.setPfuserDOB("12041997"); Thread.sleep(2000);
		rpg.setPfuserEmail("abhishek@gmail.com"); Thread.sleep(2000);
		rpg.setPfuserCity("Pune"); Thread.sleep(2000);
		List<String> l= new ArrayList<>();
		l.add("Reading");
		rpg.setPfuserHobbies(l);
		rpg.setPfuserReg();
	}

	@When("^user enters wrong details$")
	public void user_enters_wrong_details() throws Throwable {
		rpg.setPfuserPwd("abcd");
		rpg.setPfuserCnfPwd("abc");
		//rpg.setPfuserDOB("12041997");
		//rpg.setPfuserEmail("abhishek.gmail.com");
		//rpg.setPfuserCity("Pune");
		rpg.setPfuserReg();
	}

	@Then("^display alert message$")
	public void display_alert_message() throws Throwable {
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("TestCase 3:\n****** " + alertMessage);
	    driver.close();
	}
}
