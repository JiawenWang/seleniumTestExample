package jUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.app.browserInvokes.OpenBrowser;
import com.app.functions.Step1_SignIn;
import com.app.functions.Step2_AddItems;
import com.app.functions.Step3_Checkout;

public class TestFunc {
	final static Logger logger = Logger.getLogger(TestFunc.class);
	
	public static void main(String[] args) {

		WebDriver d = null;

		try {
			d = OpenBrowser.launchBrowser(d);
			logger.info("browser is opened");
			d = Step1_SignIn.signIn(d);
			d = Step2_AddItems.addItemPart1(d);
			d = Step3_Checkout.upsell(d);

			Thread.sleep(3000);
			d.quit();
		} catch (Exception e) {
			e.printStackTrace();
			d.quit();
		}

	}
}
