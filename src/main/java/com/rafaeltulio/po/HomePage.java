package com.rafaeltulio.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rafaeltulio.utils.Utils;

public class HomePage {

	private WebDriver driver;
	@SuppressWarnings("unused")
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.parseInt(Utils
				.getPropertyValue("timeout.global.web")));
	}

	public void homeMadeira() {
		driver.get(Utils.getPropertyValue("url.madeiramadeira"));
		System.out.println("Acessando URL: "
				+ Utils.getPropertyValue("url.madeiramadeira"));
	}

	public void clicarCadastrar() {
		driver.navigate().to(
				Utils.getPropertyValue("url.madeiramadeira")
						+ Utils.getPropertyValue("url.cadastro"));
		;

	}
}
