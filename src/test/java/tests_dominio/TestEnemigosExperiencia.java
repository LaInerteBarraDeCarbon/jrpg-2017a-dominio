package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestEnemigosExperiencia {

	@Test
	public void testPjvsNPC() {

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		Personaje.cargarTablaNivel();
		Assert.assertTrue(h.getExperiencia() == 0);
		h.getExperiencia();
		while (npc.estaVivo())
			h.atacar(npc);
		h.ganarExperiencia(npc.otorgarExp());
		Assert.assertTrue(h.getExperiencia() == 30);
		h.getExperiencia();
	}

	@Test
	public void testMasFuerteMasExperiencia() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 2, 0);
		Assert.assertTrue(npc.otorgarExp() < npc2.otorgarExp());
	}

	@Test
	public void testPjvsPj() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 2);
		Personaje.cargarTablaNivel();
		Assert.assertTrue(h.getExperiencia() == 0);
		h.getExperiencia();
		Assert.assertTrue(h2.getExperiencia() == 0);
		h2.getExperiencia();

		while (h2.estaVivo())
			h.atacar(h2);

		h.ganarExperiencia(h2.otorgarExp());
		Assert.assertTrue(h.getExperiencia() == 40);
		h.getExperiencia();
		Assert.assertTrue(h2.getExperiencia() == 0);
		h2.getExperiencia();

	}

	@Test
	public void testGetHabilidadesRaza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.getHabilidadesRaza();
	}

	@Test
	public void testGetHabilidadesCasta() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.getHabilidadesCasta();
	}

	@Test
	public void testGetNombreRaza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.getNombreRaza();
	}

	@Test
	public void testSetMagia() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.setMagia(0);
	}

	@Test
	public void testGetIdPersonaje() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.getIdPersonaje();
	}

	@Test
	public void testSetSaludTope() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.establecerSalud(1000);
	}

	@Test
	public void testSetEnergiaTope() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.establecerEnergia(500);
	}

	@Test
	public void testPuedeAtacar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.quitarEnergia(10);
		Assert.assertTrue(h.puedeAtacar());
	}

	@Test
	public void testRestablecerSalud() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.restablecerSalud();
	}

	@Test
	public void testRestablecerEnergia() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.restablecerEnergia();
	}

	@Test
	public void testSerRobadoSaludReturnsCero() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.serRobadoSalud(0);
	}

	@Test
	public void testSerRobadoSaludEndsWithCero() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.estableceDefensa(0);
		h.establecerSalud(100);
		h.serRobadoSalud(500);
	}

	@Test
	public void testSerDesernegizadoReturnsCero() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.serDesernegizado(0);
	}

	@Test
	public void testSerDesernegizadoEndsWithCero() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.estableceDefensa(0);
		h.quitarEnergia(100);
		h.serDesernegizado(500);
	}

	@Test
	public void testSerEnergizadoEndsWithTope() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.quitarEnergia(100);
		h.establecerSalud(500);
		h.serEnergizado(500);
	}

	@Test
	public void testCrearAlianza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.crearAlianza("A1");
	}

	@Test
	public void testSalirDeAlianzaNula() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.salirDeAlianza();
	}

	@Test
	public void testSalirDeAlianzaExistente() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.crearAlianza("A1");
		h.salirDeAlianza();
	}

	@Test
	public void testAliarReturnsFalse() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.crearAlianza("A1");
		Humano h2 = new Humano("Pepe", new Guerrero(), 40);
		h2.aliar(h);
	}

	@Test
	public void testDistanciaCon() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Pepe", new Guerrero(), 40);
		h.distanciaCon(h2);
	}
}
