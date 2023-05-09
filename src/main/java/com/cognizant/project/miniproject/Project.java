package com.cognizant.project.miniproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Project {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		String url = "https://www.bookswagon.com/";
		driver.get(url);
		WebElement inputbar = driver.findElement(By.id("inputbar"));
		inputbar.sendKeys("Selenium Webdriver");
		WebElement searchButton = driver.findElement(By.id("btnTopSearch"));
		searchButton.click();
//		Thread.sleep(5000);
		WebElement count = driver.findElement(By.className("preferences-show")).findElement(By.tagName("b"));
		if (Integer.parseInt(count.getText()) > 10)
			System.out.println("The count of search result is greater than 10");
		else
			System.out.println("count is less than 10");
		Select ddlsort = new Select(driver.findElement(By.id("ddlSort")));
		ddlsort.selectByValue("Product_ActualPrice asc");
		Thread.sleep(1000);
		List<WebElement> products = driver.findElements(By.className("list-view-books"));
		for (int i = 0; i < 5; i++) {
			WebElement product = products.get(i);
			System.out.println("Product Name: "
					+ product.findElement(By.className("title")).findElement(By.tagName("a")).getText());
			System.out.println(
					"Price: " + product.findElement(By.className("price")).findElement(By.className("sell")).getText());
			System.out.println();
			System.out.println();
		}
		driver.close();

	}

}
