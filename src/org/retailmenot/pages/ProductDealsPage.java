package org.retailmenot.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.retailmenot.util.Utility;

public class ProductDealsPage {

	private final WebDriver driver;

	By usernameLocator = By.id("username");


	public ProductDealsPage(WebDriver driver) {
		this.driver = driver;

	}
	public boolean verifyHotProductDealsPage(String title)
	{
		boolean result = false;
		if(driver.getTitle().equals(title))
		{
			result =true;
		}
		return result;
	}

	// The login page allows the user to type their username into the username field
	public int  getCategoryItemsCount(String categoryName,String xpathID){
		 													 
		driver.findElement(By.xpath("(//a[contains(text(),'"+categoryName+"')])[2]")).click();
														                 
		List<WebElement> itemsList = driver.findElements(By.cssSelector("#"+ xpathID +">div>div>div"));
		return itemsList.size();
	}
   public int getDescriptionCount(String categoryName)
   {
	   try{
	   System.out.println("Xpath is" + Utility.prop.getProperty("categoryItem_XpathPart1")+categoryName+Utility.prop.getProperty("categoryItem_XpathPart2"));
	   
	   WebElement e = Utility.findElementsByLocator("xpath","xpath value",driver);
	   List<WebElement> descList = driver.findElements(By.xpath(Utility.prop.getProperty("categoryItem_XpathPart1")+categoryName+Utility.prop.getProperty("categoryItem_XpathPart2")));
	   //List<WebElement> descList = driver.findElements(By.xpath(".//*[@id='"+categoryName+"']//div/h6"));
	   int count=0;
	   for(int i=0;i<descList.size();i++)
	   {
		   System.out.println(descList.get(i).getText());
		   
		   if(descList.get(i).getText().length()>0)
		   {
			   count++;
		   }
	   }
	   }
	   catch(Exception e)
	   {
		    
	   }
	   return count;
   }
}

//local variables we have to intialize
//global variables takes default values














