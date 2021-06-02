package com.qc.ndtv.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='nglobalnav']/a")
	List<WebElement> links;

	@FindBy(xpath = "//*[@title='Latest']")
	private WebElement latest;

	@FindBy(xpath = "//*[@title='Markets']")
	private WebElement markets;

	@FindBy(xpath = "//*[@title='Money']")
	private WebElement money;

	public List<String> getLinks() {
		List<String> labelsList = new ArrayList();
		for (WebElement webElement : links) {
			labelsList.add(webElement.getAttribute("href"));
		}
		return labelsList;
	}

	public boolean verifyMenu(String mName, String mLink) {
		String latestMenu = latest.getText();
		String marketsMenu = markets.getText();
		String moneyMenu = money.getText();
		String latestLink = latest.getAttribute("href");
		String marketLink = markets.getAttribute("href");
		String moneyLink = money.getAttribute("href");
		if (latestMenu.equalsIgnoreCase(mName) && latestLink.equalsIgnoreCase(mLink)) {
			return true;
		} else if (marketsMenu.equalsIgnoreCase(mName) && marketLink.equalsIgnoreCase(mLink)) {
			return true;
		} else if (moneyMenu.equalsIgnoreCase(mName) && moneyLink.equalsIgnoreCase(mLink)) {
			return true;
		} else {
			return false;
		}
	}

}
