package com.blemall.smokeTest.page;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;

public class AddShoppingCart extends Page {

	public AddShoppingCart(WebDriver driver) throws IOException {
		super(driver);
		
	}
	@Test(dataProvider="providerMethod")
	public void addShoppingCard(Map<String,String> param) throws IOException
	{
		AddShoppingCart sp=new AddShoppingCart(driver);
		sp.getElement("addshoppingcard").click();
		String num=sp.getElement("goodsnum").getText();
		System.out.println("num= "+num);
		
	}
	

}
