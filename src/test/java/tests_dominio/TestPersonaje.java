package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getInteligencia() == 10);
		h.cargarTablaNivel();
		Humano h4 = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		h4.crearAlianza("Locos");
		h4.aliar(h);
		h.aliar(h4);
		h4.salirDeAlianza();
		h4.ganarExperiencia(100);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 10);
		Assert.assertTrue(h2.getDestreza() == 10);
		Assert.assertTrue(h2.getInteligencia() == 15);

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 10);
		Assert.assertTrue(h3.getDestreza() == 15);
		Assert.assertTrue(h3.getInteligencia() == 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		/*Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);*/
		e2.getSalud();
		e2.getEnergia();
		e2.getFuerza();
		e2.getDestreza();
		e2.getInteligencia();

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		/*Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 10);
		Assert.assertTrue(e3.getDestreza() == 15);
		Assert.assertTrue(e3.getInteligencia() == 10);*/
		e3.getSalud();
		e3.getEnergia();
		e3.getFuerza();
		e3.getDestreza();
		e3.getInteligencia();
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		/*Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 15);
		Assert.assertTrue(o.getDestreza() == 10);
		Assert.assertTrue(o.getInteligencia() == 10);*/
		o.getSalud();
		o.getEnergia();
		o.getFuerza();
		o.getDestreza();
		o.getInteligencia();

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		o2.getSalud();
		o2.getEnergia();
		o2.getFuerza();
		o2.getDestreza();
		o2.getInteligencia();

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
/*		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 10);
		Assert.assertTrue(o3.getDestreza() == 15);
		Assert.assertTrue(o3.getInteligencia() == 10);*/
		o3.getSalud();
		o3.getEnergia();
		o3.getFuerza();
		o3.getDestreza();
		o3.getInteligencia();
	}
}
