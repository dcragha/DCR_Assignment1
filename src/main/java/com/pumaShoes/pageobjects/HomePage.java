package com.pumaShoes.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver ){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//header[@id='header']/div/div/div/div[2]/ul/li")
		WebElement menMenuItem;
	@FindBy(xpath="//li[@id='men-subnav']/div/div/div[2]/ul/li[2]/a")
	WebElement runningShoes;
	
	@FindBy(xpath="//div[@class='category-products']/ul/li[2]/a")
	WebElement secondShoe; 
	
	
		
	 private boolean isElementPresent(By element){
		 try{
		 driver.findElement(element);
		 return true;
		 }catch(NoSuchElementException e){
			 return false;
		 }		 
}


	public void continueBooking() {
		Actions act=new Actions(driver);
    	act.moveToElement(menMenuItem).build().perform();
    	act.moveToElement(runningShoes).build().perform();
    	runningShoes.click();
		
	}
	
	
	
	public WebDriver secondShoe(){
		String parentWindow=driver.getWindowHandle();
		secondShoe.click();
	
	
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	
	return driver;
		
	}
	
	
	
	
}