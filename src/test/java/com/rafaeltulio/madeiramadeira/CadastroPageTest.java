package com.rafaeltulio.madeiramadeira;

import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.opencsv.CSVReader;
import com.rafaeltulio.po.CadastroPage;
import com.rafaeltulio.po.HomePage;
import com.rafaeltulio.utils.Utils;

public class CadastroPageTest {

	private WebDriver driver;
	HomePage home;
	CadastroPage cadastro;
	String cpf;

	@Before
	public void before() throws Exception {
		driver = Utils.selectBrowser(Utils.getPropertyValue("browser"));
		home = new HomePage(driver);
	}

	@After
	public void after() throws Exception {

		driver.quit();

	}

	@SuppressWarnings({ "resource", "unused" })
	@Test
	public void testValidarObrigatoriedadeSenha() throws Exception {
		CSVReader reader;
		String[] line;
		String cpf;
		CSVReader csvReader = reader = new CSVReader(new FileReader(
				Utils.getPropertyValue("csv.cpf")));
		reader.readNext();
		while ((line = reader.readNext()) != null) {
			cpf = line[0];
			System.out.println("TC_validarObrigatoriedadeEmail");
			
			home.homeMadeira();
			home.clicarCadastrar();

			CadastroPage cadastro = new CadastroPage(driver);
			cadastro.getUrl();
			cadastro.selecionarTipoPessoaFisica();
			cadastro.preencherEmailCadastro();
			cadastro.cadastrarCPF(cpf);
			cadastro.preencherNome("Cadastro_Pessoa Fisica");
			cadastro.preencherFoneContato("41991679999");
			cadastro.preencherSenha("madeirateste");
			cadastro.preencherCEP("80020320");
			cadastro.preencherNumeroEnd("717");
		}
	}
}