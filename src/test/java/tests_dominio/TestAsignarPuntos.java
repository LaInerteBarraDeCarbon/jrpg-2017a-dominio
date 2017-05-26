package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAsignarPuntos {

	@Test
	public void testAumentarSalud_tope() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(105, h.getSaludTope());
		h.getSaludTope();
		h.ganarExperiencia(50);
		Assert.assertEquals(130, h.getSaludTope());
		h.getSaludTope();
	}

	@Test
	public void testAumentarEnergia_tope() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(105, h.getEnergiaTope());
		h.getEnergiaTope();
		h.ganarExperiencia(50);
		Assert.assertEquals(125, h.getEnergiaTope());
		h.getEnergiaTope();
	}
}
