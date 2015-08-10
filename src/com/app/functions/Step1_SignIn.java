package com.app.functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step1_SignIn {

	final static Logger logger = Logger.getLogger(Step1_SignIn.class);

	public static WebDriver signIn(WebDriver d) {

		try {
			d.get("http://preview:hunter2@alpha.redmart.com/");
			logger.info("open the website");
			WebElement loginBtn = (new WebDriverWait(d, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#signin a.signinBtn")));
			logger.info("login button element is found");
			loginBtn.click();
			logger.info("click login button");
			Thread.sleep(1000);
			WebElement emailAddress = (new WebDriverWait(d, 10)).until(
					ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginBar input[name='email']")));
			logger.info("email address input feild is found");
			emailAddress.clear();
			emailAddress.sendKeys("jiawen+8@redmart.com");
			logger.info("input email address");
			WebElement passwordInput = (new WebDriverWait(d, 10)).until(
					ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginBar input[name='password']")));
			logger.info("password input feild is found");
			passwordInput.sendKeys("test");
			WebElement signInbtn = (new WebDriverWait(d, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.signinBtn.button")));
			logger.info("sign in button is found");
			signInbtn.click();
			logger.info("click sign in button to login");
			WebElement hiUser = (new WebDriverWait(d, 10)).until(ExpectedConditions.presenceOfElementLocated(
					By.cssSelector("#accountPreviewInner span[data-reactid='.0.0.0.0.1.0.0.0.0']")));
			logger.info("the text is: \"" + hiUser.getText() + "\"" );
			if (hiUser.getText().equals("Hi,")) {
				logger.info("login successfully");
			} else {
				logger.error("login failed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;

	}

}
