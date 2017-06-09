package tests_dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Orco;
import dominio.Hechicero;
import dominio.Elfo;
import dominio.Asesino;

public class TestDaño {

	@Test
	public void testAtaqueComunYLaSaludNoBajeDe0() {
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);

		assertEquals(100, o.getSalud());
		o.getSalud();
		if (h.atacar(o) != 0) {
			// Assert.assertTrue(o.getSalud() == 0);
			o.getSalud();
			h.atacar(o);
			// Assert.assertTrue(o.getSalud() == 0);
			o.getSalud();
			h.atacar(o);
			// Assert.assertTrue(o.getSalud() == 0);
			o.getSalud();
		} else
			Assert.assertEquals(0, o.getSalud());
	}

	@Test
	public void testLosMuertosNoAtacan() {
		Humano h = new Humano("Nico", 100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);

		h.atacar(o);
		h.atacar(o);
		h.atacar(o);
		h.atacar(o);

		o.atacar(h);
		Assert.assertEquals(100, h.getSalud());
	}

	@Test
	public void testAtaqueSinEnergia() {
		Humano h = new Humano("Octi", 100, 3, 25, 10, 30, new Hechicero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 8, 15, 0, 30, new Asesino(0.2, 0, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Vale", 100, 9, 20, 10, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 3);
		o.quitarEnergia(9);
		e.quitarEnergia(8);
		h.quitarEnergia(3);
		e.habilidadRaza1(o);
		e.habilidadRaza2(h);
		h.habilidadRaza1(o);
		h.habilidadRaza2(e);
		o.habilidadRaza1(e);
		o.habilidadRaza2(h);
	}

	@Test
	public void testAtaqueSinSalud() {
		Humano h = new Humano("Octi", 0, 0, 25, 10, 30, new Hechicero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 0, 8, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		assertEquals(0, o.getSalud());
		o.getSalud();
		assertEquals(0, h.getSalud());
		h.getSalud();
	}

	@Test
	public void testSerAtacadoConDañoNoNulo() {
		Humano h = new Humano("Octi", 16, 0, 25, 10, 30, new Hechicero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 0, 200, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		o.setAtaque(230);
		o.setEnergia(100);
		h.atacar(o);
		o.atacar(h);
		o.atacar(h);
	}

	@Test
	public void testAtaqueMinimaEnergia() {
		Humano h = new Humano("Octi", 16, 0, 25, 10, 30, new Hechicero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 89, 200, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		o.quitarEnergia(10);
		h.quitarEnergia(11);
		if (o.getEnergia() >= 10) {
			o.atacar(h);
		}
	}

	@Test
	public void testDañoCritico() {
		Guerrero g = new Guerrero(0, 0, 0);
		// Humano hum = new Humano("Octi",16,0,25,10,30,g,0,1,1);
		g.setProbabilidadEvitarDaño(0.2);
		g.setDañoCritico(1.5);
	}

	@Test
	public void TestAtaqueMayorProbGolpeCritico() {
		Guerrero g = new Guerrero(0.4, 2, 1.5);
		g.setProbabilidadEvitarDaño(0.88);
		g.setProbabilidadGolpeCritico(0.95);
		Orco o = new Orco("Octi", 89, 200, 15, 0, 30, g, 0, 1, 1);
		Humano h = new Humano("Nico", 56, 240, 12, 0, 30, new Guerrero(0.2, 0, 1.5), 1, 1, 1);
		o.serAtacado(10);
		h.serAtacado(0);
	}
}