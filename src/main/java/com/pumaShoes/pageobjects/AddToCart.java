package com.pumaShoes.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	WebDriver driver;

	public AddToCart(WebDriver driver ){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//div[@class='product-view']/div/form/div[3]/div/span")
	WebElement shoeName;

	@FindBy(id="product-size-click-btn")
	WebElement productsize;

	@FindBy(xpath="//div[@class='product-size-click-btn']")
	WebElement size;

	@FindBy(xpath="//ul[@id='configurable_swatch_size']/li[2]")
	WebElement sizes;

	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement addToCartBtn;


	public void selectsize() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(size));
		size.click();
		wait.until(ExpectedConditions.elementToBeClickable(sizes));
		sizes.click();
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
	}

	public  String getShoeName(){
		String name=shoeName.getText();
		return name;
	}

}
