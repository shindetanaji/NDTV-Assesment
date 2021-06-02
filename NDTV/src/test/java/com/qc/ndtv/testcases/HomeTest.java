package com.qc.ndtv.testcases;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.testng.annotations.Test;

import com.qc.ndtv.pages.HomePage;

public class HomeTest extends BaseIntegration {

	HomePage home;
	@Test(enabled=false)
	public void linkTest() {
		home  = new HomePage(driver);
		List<String> links = home.getLinks();
		for(String link: links) {
			System.out.println(link);
		}
	}
	
	@Test(dataProvider="getMenu")
	public void menuTest(String mName, String mLink) {
		home = new HomePage(driver);
		assertTrue(home.verifyMenu(mName, mLink));
	}
	
}
