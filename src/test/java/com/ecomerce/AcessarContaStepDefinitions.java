package com.ecomerce;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecomerce.helpers.ScreenshotHelper;
import com.ecomerce.helpers.WebDriverHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcessarContaStepDefinitions {

	WebDriver driver;
	
	@Given("Acessar a página de autenticação de cliente")
	public void acessar_a_pagina_de_autenticacao_de_cliente() {

		driver = WebDriverHelper.create();		
		driver.navigate().to(WebDriverHelper.URL_BASE + "/acessar-conta");
		
		ScreenshotHelper.create("Acessar_conta_com_sucesso_pt01", driver);
	}

	@Given("Informar o email de acesso {string}")
	public void informar_o_email_de_acesso(String email) {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/div/form/div[1]/input"));
		element.clear();
		element.sendKeys(email);
		
		ScreenshotHelper.create("Acessar_conta_com_sucesso_pt02", driver);
	}

	@Given("Informar a senha de acesso {string}")
	public void informar_a_senha_de_acesso(String senha) {
		
		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/div/form/div[2]/input"));
		element.clear();
		element.sendKeys(senha);
		
		ScreenshotHelper.create("Acessar_conta_com_sucesso_pt03", driver);
	}

	@When("Solicitar a realização do acesso")
	public void solicitar_a_realizacao_do_acesso() {

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/div/form/div[3]/div"));
		
		if(element.isEnabled()) {
			element.click();
		}
		else {
			fail("Botão de cadastro não habilitado.");
		}
	}

	@Then("Sistema autentica o cliente com sucesso")
	public void sistema_autentica_o_cliente_com_sucesso() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("/finalizar-pedido"));
		
		WebElement element = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/div[1]/div/h5"));
		assertEquals("Finalizar Pedido", element.getText());	
		
		ScreenshotHelper.create("Acessar_conta_com_sucesso_pt04", driver);
		
		driver.close();
	}
}



