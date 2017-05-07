package com.rafaeltulio.po;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rafaeltulio.utils.Utils;

public class CadastroPage {

	private WebDriver driver;
	@SuppressWarnings("unused")
	private WebDriverWait wait;

	String email;
	String recuperaEmail;
	String recuperaSenha;
	String recuperaNome;

	public CadastroPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.parseInt(Utils.getPropertyValue("timeout.global.web")));

	}

	public void getUrl() {
		System.out.println(driver.getTitle());
		
	}

	public void selecionarTipoPessoaFisica() {
		WebElement tipoPessoaFisica = driver.findElement(By.id("pessoaFisica"));
		tipoPessoaFisica.click();
		System.out.println("Tipo Pessoa Fisica Selecionada!");		
	}
	/**
	 * Preencher o E-mail de Cadastro Randomicamente
	 */	
	public void preencherEmailCadastro() {
		
		try {
			email = UUID.randomUUID().toString().substring(1, 6) + "@automacao.madeiramadeira.com.br";
			WebElement cadastroEmail = driver.findElement(By.id("txtEmail"));
			cadastroEmail.clear();
			cadastroEmail.sendKeys(email);			
			System.out.println("E-Mail Preenchido no Cadastro: "+email);
			recuperaEmail = driver.findElement(By.id("txtEmail")).getAttribute("value");
			
		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * CADASTRAR CPF ATRAVES DE MASSA DE DADOS EXTERNA dataDrivenCPF.csv
	 */	
	public void cadastrarCPF(String cpf) throws Exception {
		WebElement txtCpf = driver.findElement(By.id("txtCPF"));
		txtCpf.clear();
		txtCpf.sendKeys(cpf);
		txtCpf.sendKeys(Keys.TAB);
		System.out.println("CPF Informado no Cadastro: " +cpf);
	}

	/**
	 * Preencher Nome Completo Para Cadastro
	 * @throws InterruptedException 
	 */	
	public void preencherNome(String nomeCompleto) {
		WebElement txtName = driver.findElement(By.id("txtName"));
		txtName.clear();
		txtName.sendKeys(nomeCompleto.toUpperCase());
		txtName.sendKeys(Keys.TAB);
		System.out.println("Nome Preenchido no Cadastro: "+nomeCompleto);
		
		recuperaNome = driver.findElement(By.id("txtName")).getAttribute("value");
	}

	/**
	 * Preencher Telefone Celular
	 */
	public void preencherFoneContato(String telefone) {
		WebElement txtTel1 = driver.findElement(By.id("txtTel1"));
		txtTel1.clear();
		txtTel1.sendKeys(telefone);
		txtTel1.sendKeys(Keys.TAB);
		System.out.println("Telefone Contato Preenchido no Cadastro: "+telefone);
	}

	/**
	 * Preencher Senha para Cadastro
	 */
	public void preencherSenha(String senha) {
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
		txtPassword.clear();
		txtPassword.sendKeys(senha);
		System.out.println("Senha Preenchida! " +senha);
		recuperaSenha = driver.findElement(By.id("txtPassword")).getAttribute("value");
	}


	public void preencherCEP(String cep) {
		WebElement txtCEP = driver.findElement(By.id("txtCEP"));
		txtCEP.clear();
		txtCEP.sendKeys(cep);
		txtCEP.sendKeys(Keys.TAB);
		System.out.println("CEP Preenchido no cadastro: "+cep);
	}

	public void preencherNumeroEnd(String numeroEnd) {
		WebElement txtAddNum = driver.findElement(By.id("txtAddNum"));
		txtAddNum.clear();
		txtAddNum.sendKeys(numeroEnd);
		txtAddNum.sendKeys(Keys.TAB);
		System.out.println("Número Preenchido: "+numeroEnd);
	}

}
