package com.cg.pageBeans;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegPageFactory {
	WebDriver driver;
	public RegPageFactory(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= ".//*[@id='txtPassword']")
	@CacheLookup
	WebElement pfuserPwd;
	
	@FindBy(xpath= ".//*[@id='txtConfPassword']")
	@CacheLookup
	WebElement pfuserCnfPwd;
	
	@FindBy(xpath= ".//*[@id='txtEmail']")
	@CacheLookup
	WebElement pfuserEmail;
	
	@FindBy(xpath= ".//*[@id='DOB']")
	@CacheLookup
	WebElement pfuserDOB;
	
	@FindBy(xpath= "html/body/form/table/tbody/tr[13]/td/input")
	@CacheLookup
	WebElement pfuserReg;
	
	@FindBy(name= "City")
	@CacheLookup
	WebElement pfuserCity;
	
	@FindBy(name= "chkHobbies")
	@CacheLookup
	List<WebElement> pfuserHobbies;
	
	@FindBy(name= "gender")
	@CacheLookup
	List<WebElement> pfuserGender;
	
	public WebElement getPfuserPwd() {
		return pfuserPwd;
	}

	public void setPfuserPwd(String suserPwd) {
		pfuserPwd.sendKeys(suserPwd);
	}

	public WebElement getPfuserCnfPwd() {
		return pfuserCnfPwd;
	}

	public void setPfuserCnfPwd(String suserCnfPwd) {
		pfuserCnfPwd.sendKeys(suserCnfPwd);
	}

	
	public WebElement getPfuserEmail() {
		return pfuserEmail;
	}

	public void setPfuserEmail(String suserEmail) {
		pfuserEmail.sendKeys(suserEmail);
	}

	public WebElement getPfuserDOB() {
		return pfuserDOB;
	}

	public void setPfuserDOB(String suserDOB) {
		pfuserDOB.sendKeys(suserDOB);
	}

	public void setPfuserReg() {
		pfuserReg.click();
	}

	public WebElement getPfuserCity() {
		return pfuserCity;
	}

	public void setPfuserCity(String suserCity) {
		new Select(pfuserCity).selectByVisibleText(suserCity);
	}

	public void setPfuserHobbies(List<String> l) throws InterruptedException {
		for (WebElement webElement : pfuserHobbies) {
			for (String string : l) {
				if (string.equals(webElement.getAttribute("value"))) webElement.click();
			}
			Thread.sleep(500);
		}
	}

	

	public List<WebElement> getPfuserGender() {
		return pfuserGender;
	}

	public void setPfuserGender(String str) {
		 for (WebElement webElement : pfuserGender) {
			if(webElement.getAttribute("value").equals(str)) webElement.click();
		}
	}
}
