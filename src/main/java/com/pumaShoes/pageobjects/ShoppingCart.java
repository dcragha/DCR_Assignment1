package com.pumaShoes.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
WebDriver driver;
	
	public ShoppingCart(WebDriver driver ){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='product-name']")
	WebElement productname;
	
	public String product(){
		String prname=productname.getText();
		return prname;
	}
}
