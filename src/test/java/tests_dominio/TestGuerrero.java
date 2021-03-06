package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;

public class TestGuerrero {

	@Test
	public void testDobleGolpe() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Elfo e2 = new Elfo("Jorge", 100, 100, 25, 20, 30, new Asesino(0.2, 100, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		e.getSalud();
		if (h.habilidadCasta1(e)) {
			Assert.assertTrue(e.getSalud() < 100);
		}
		if (h.habilidadCasta1(e2)) {
			Assert.assertTrue(e2.getSalud() < 100);
		}
		h.habilidadCasta1(e2);
	}

	@Test
	public void testAutoDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertTrue(h.getDefensa() == 20);
		h.getDefensa();
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa() == 65);
		h.getDefensa();
		h.quitarEnergia(0);
		h.habilidadCasta2(null);
	}

	@Test
	public void testIgnoraDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Elfo e2 = new Elfo("Jorge", 100, 100, 25, 20, 30, new Asesino(0.2, 100, 1.5), 0, 3, 1);
		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta3(e))
			Assert.assertTrue(e.getSalud() < 100);
		h.habilidadCasta3(e2);
		e.getSalud();
	}

}
