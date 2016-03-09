package com.blemall.smokeTest.testcases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.blemall.smokeTest.page.FastToHomePage;
import com.blemall.smokeTest.page.LoginPage;
import com.test.base.TestBase;
import com.test.bean.Config;
import com.test.util.Log;

public class TestCase_06_FastToHome extends TestBase {

	// 判断首页快到家入口图片是否存在
	@Test(dataProvider = "providerMethod")
	public void usernameNotExist(Map<String, String> param) throws IOException,
			InterruptedException {
		FastToHomePage fp = new FastToHomePage(driver);
		this.openURL();
		// 进入登录页面
		this.gotoLoginPage(fp);
		// 检查登录名不存在
		this.entranceExistCheck(fp, param);
	}

	private void entranceExistCheck(FastToHomePage fp, Map<String, String> param) {
		
	}

	// 打开H5首页
	public void openURL() {
		try {
			this.goTo(Config.path);
			Log.logInfo("open URL=" + Config.path);
			// wait(3000);
			String log = ".//*[@id='main']/div/header/a[3]/img";
			if (isElementDisplayed(log)) {
				Log.logInfo("open successfully");
			} else {
				Log.logInfo("open failed");
				return;
			}
		} catch (Exception e) {
			Log.logInfo("open failed");
			Assert.fail("open failed");
		}
	}

	// 判断某个元素是否出现
	@SuppressWarnings("unused")
	private boolean isElementDisplayed(String path) {
		boolean result = false;
		try {
			result = driver.findElement(By.xpath(path)).isDisplayed();
			Log.logInfo("你要找的元素出现了");
		} catch (Exception e) {
			Log.logInfo("你要找的元素未出现");
			Assert.fail();
		}

		return result;
	}
	private void gotoLoginPage(FastToHomePage fp) {
		WebElement scrollView = fp.getElement("location");
		this.getIntoView(scrollView);
		WebElement loginEntrance = fp.getElementNoWait("loginEntrance");
		loginEntrance.click();
		Log.logInfo("click login button");
	}

}
