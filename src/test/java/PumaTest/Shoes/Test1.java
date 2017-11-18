package PumaTest.Shoes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pumaShoes.pageobjects.AddToCart;
import com.pumaShoes.pageobjects.HomePage;
import com.pumaShoes.pageobjects.ShoppingCart;
import com.Puma.testbase.*;

public class Test1 extends TestBase {
	HomePage hp;
	ShoppingCart sc;

	@Test
	public void runningShoes() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		hp=new HomePage(driver);
		sc=new ShoppingCart(driver);
		
		hp.continueBooking();
		
		hp.secondShoe();
		
		AddToCart ac=new AddToCart(driver);
		String pName=ac.getShoeName();
		
		ac.selectsize();
		
		String productName=sc.product();
		
 Assert.assertEquals(pName.toLowerCase(), productName.toLowerCase());
		
	}	

}
