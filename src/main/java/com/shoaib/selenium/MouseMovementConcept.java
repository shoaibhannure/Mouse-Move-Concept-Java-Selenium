package com.shoaib.selenium;

/*
 * 
 * 
 * @Author:- SHOAIB HANNURE
 * 
 * 
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/"); // launch website

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tr/td[contains(text(),'Travel Info')]"))).build().perform();
		//Move to Travel Info Section
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td/a[contains(text(),'FAQ')]")).click(); //Click on FAQ
		
		System.out.println("Clicked on FAQ from Travel Section by using Mouse Movement by Action Class");
		
		String FAQPageTitle=driver.getTitle();
		System.out.println("Title of FAQ Page is   "+FAQPageTitle);
		
		if (FAQPageTitle.contains("General Air Travel Faqs | SpiceJet Airlines")) {
			System.out.println("Landed on FAQ Page");
		}
		else {
			System.out.println("Landed on an Incorrect Page");
		}

	}

}
