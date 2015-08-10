package com.app.functions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step2_AddItems {

	final static Logger logger = Logger.getLogger(Step2_AddItems.class);

	public static WebDriver addItemPart1(WebDriver d) {

		try {

			d.get("http://alpha.redmart.com/sales");
			logger.info("start to select item in on-sale page");
			WebElement productList = (new WebDriverWait(d, 10)).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@id='contentSection']/article/div[3]/div/ul")));
			logger.info("the productList element is found: " + productList.getText());

			// WebElement item2 =
			// d.findElement(By.xpath("//*[@id='contentSection']/article/div[3]/div/ul/li[2]"));
			// logger.info("item2 is: " + item2.getCssValue("li"));

			List<WebElement> elementList = d
					.findElements(By.cssSelector("//*[@id='contentSection']/article/div[3]/div/ul"));
			
			for (WebElement prod:elementList) {
				int i = 0;
				logger.info(i + prod.toString());
			}

			/*
			 * String productFound = null; List<WebElement> prodList =
			 * productList.findElements(By.tagName("li")); int products =
			 * prodList.size(); logger.info("product list size is: \"" +
			 * products + "\""); String[][] productOpt = new
			 * String[products][10]; int prodNum = 0; logger.info(
			 * "initial prodNum = " + prodNum); for (WebElement prod : prodList)
			 * { List<WebElement> optList =
			 * prod.findElements(By.tagName("div")); int optNum = 0;
			 * logger.info("inital optNum = " + optNum); for (WebElement opt :
			 * optList) { productOpt[prodNum][optNum] = opt.getText(); if
			 * (opt.getText().equals("ADD TO CART")) { productFound =
			 * productOpt[prodNum][optNum]; logger.info(
			 * "products element is found: " + productFound.trim());
			 * opt.click(); logger.info("Add to cart btn is clicked on: " +
			 * opt.getText().substring(4, 9)); } else { logger.info(
			 * "No add button is clicked"); }
			 * 
			 * optNum++; if (optNum >= 9) { break; } } prodNum++; if (prodNum >=
			 * 2) { break; } }
			 */
			logger.info("product selection is done");

		} catch (Exception e) {
			d.quit();
			e.printStackTrace();

		}

		return d;

	}

}
