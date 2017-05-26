package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHumano {

	@Test
	public void testIncentivar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(37, e.getAtaque());
		h.habilidadRaza1(e);
		Assert.assertTrue(e.getAtaque() > 37);
	}

	@Test
	public void testGolpeFatal() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(100, h.getEnergia());
		Assert.assertEquals(100, e.getSalud());
		if (h.habilidadRaza2(e)) {
			Assert.assertEquals(70, e.getSalud());
			Assert.assertEquals(98, h.getEnergia());
		}
		h.quitarEnergia(0);
		h.habilidadRaza2(e);
	}
}
