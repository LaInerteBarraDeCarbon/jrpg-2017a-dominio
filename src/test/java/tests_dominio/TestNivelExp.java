package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Personaje;

public class TestNivelExp {

	@Test
	public void testGanarExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(45);
		Assert.assertEquals(45, h.getExperiencia());
	}

	@Test
	public void testSubirNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(300);
		Assert.assertEquals(4, h.getNivel());
		Assert.assertEquals(0, h.getExperiencia());
	}

	@Test
	public void testLevel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 99, 1);
		h.ganarExperiencia(10000);
		Assert.assertEquals(100, h.getNivel());
	}
}
