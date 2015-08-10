package com.app.functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step3_Checkout {

	final static Logger logger = Logger.getLogger(Step3_Checkout.class);

	public static WebDriver upsell(WebDriver d) {
		try {
			d.get("http://alpha.redmart.com/cart");
			logger.info("start to check out");
			WebElement checkOutbtn = (new WebDriverWait(d, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#showInCart a.button")));
			logger.info("checkOutbtn is found: " + checkOutbtn.getText());
		} catch (Exception e) {
			logger.error("element can't find");
			d.quit();
		}
		return d;
	}

	public static WebDriver addAddress(WebDriver d) {
		return d;
	}

	public static WebDriver addContactInfo(WebDriver d) {
		return d;
	}

	public static WebDriver selectDeliverySlot(WebDriver d) {
		return d;
	}

	public static WebDriver payment(WebDriver d) {
		return d;
	}

}
