package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAtributos {

	@Test
	public void testIncrementarFuerza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);

		Assert.assertTrue(h.getAtaque() == 22);
		h.getAtaque();
		h.AsignarPuntosSkills(10, 0, 0);
		Assert.assertTrue(h.getAtaque() > 22);
		h.getAtaque();
	}

	@Test
	public void testIncrementarDestreza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);

		Assert.assertTrue(h.getDefensa() == 10);
		h.getDefensa();
		h.AsignarPuntosSkills(0, 10, 0);
		Assert.assertTrue(h.getDefensa() > 10);
		h.getDefensa();
	}

	@Test
	public void testIncrementarInteligencia() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getMagia() == 15);
		h.getMagia();
		h.AsignarPuntosSkills(0, 0, 10);
		Assert.assertTrue(h.getMagia() > 15);
		h.getMagia();
	}

	@Test
	public void testDespuesDeTurno() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.despuesDeTurno();
	}
}
