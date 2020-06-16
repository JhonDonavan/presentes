package com.presentes.services;

import com.presentes.controller.PresenteController;
import com.presentes.exceptions.PresenteComQtdNegativoExceptions;
import com.presentes.exceptions.PresentesExceptionsNotFound;
import com.presentes.model.Categoria;
import com.presentes.model.Convidado;
import com.presentes.model.Presente;
import com.presentes.repositories.PresenteRepository;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PresenteTest {

	@Autowired
	PresenteController presenteController;

	@Autowired
	PresenteRepository presenteRepository;

	@Autowired(required = true)
	PresenteServiceImpl presenteService;

	@Test
	public void testInclusãoPresentes() {

		Convidado c = new Convidado(1, "João");
		Categoria cat = new Categoria(1, "Cozinha", "Itens para cozinha");

		Presente presente = new Presente(1, cat, c, "Potes", "Vermelho", 5, "Potes para micro-ondas");

		Assert.assertTrue(presente != null);
	}

	@Test
	public void testInclusãoPresenteQuantidadeNegativo() throws PresenteComQtdNegativoExceptions, PresentesExceptionsNotFound {
		Convidado convidado = new Convidado(1, "João");
		Categoria categoria = new Categoria(1, "Cozinha", "Itens para cozinha");

		Presente presente = new Presente(1, categoria, convidado, "Potes", "Vermelho", 100, "Potes para micro-ondas");

		presente.setCategoria(categoria);
		presente.setConvidado(convidado);
		presente.setCor("Vermelho");
		presente.setNome("Portes");
		presente.setObservacao("Portes para forno");
		presente.setQtd(-1);

		presenteService.createPresente(presente);
		Assert.assertFalse("Deveria lançar uma excecão ", true);
	}

	@Test
	public void test_convidado_vazio() throws PresenteComQtdNegativoExceptions, PresentesExceptionsNotFound {
		Convidado convidado = new Convidado(1, "João");
		Categoria categoria = new Categoria(1, "Cozinha", "Itens para cozinha");

		Presente presente = new Presente(1, categoria, null, "Potes", "Vermelho", 10, "Potes para micro-ondas");

		try {
			presenteService.createPresente(presente);
			Assert.assertFalse("Deveria lançar uma excecão ", true);
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), is("Convidado vazio"));
		}
	}

	@Test
	public void test_categoria_vazio() throws PresenteComQtdNegativoExceptions, PresentesExceptionsNotFound {
		Convidado convidado = new Convidado(1, "João");
		Categoria categoria = new Categoria(1, "Cozinha", "Itens para cozinha");

		Presente presente = new Presente(1, null, convidado, "Potes", "Vermelho", 10, "Potes para micro-ondas");

		try {
			presenteService.createPresente(presente);
			Assert.assertFalse("Deveria lançar uma excecão ", true);
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), is("Categoria vazio"));
		}
	}

}
