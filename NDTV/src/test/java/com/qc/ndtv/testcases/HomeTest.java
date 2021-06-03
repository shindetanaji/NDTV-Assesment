package com.qc.ndtv.testcases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qc.ndtv.pages.HomePage;

public class HomeTest extends BaseIntegration {

	HomePage home;
	
	@BeforeTest
	public void allow() {
		home = new HomePage(driver);
		home.clickOnAllow();
	}
	
	@Test
	public void topSoriesTest() {
		home = new HomePage(driver);
		//1 - list of href all topStories
		List<String> sories = home.getTopStories();
		for(String link: sories) {
			System.out.println(link);
		}
		
		//2. Assert tool-tip of the LATEST
		assertTrue(home.verifyLatest());
		
		//3. Right-click on LATEST and open the same in a New-window
		assertTrue(home.verifyLatestPageTitle());
	}
	
	@Test(enabled=false)
	public void linkTest() {
		home  = new HomePage(driver);
		List<String> links = home.getLinks();
		for(String link: links) {
			System.out.println(link);
		}
	}
	
	@Test(dataProvider="getMenu", enabled=false)
	public void menuTest(String mName, String mLink) {
		home = new HomePage(driver);
		assertTrue(home.verifyMenu(mName, mLink));
	}
	
}
