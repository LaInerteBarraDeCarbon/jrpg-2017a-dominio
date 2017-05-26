package tests_dominio;

import org.junit.Assert;
import org.junit.Test;
import dominio.*;

public class TestAliarCombatir {

	@Test
	public void testCrearAlianza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 1);

		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.aliar(h2);
		Assert.assertNotNull(h.getClan());
		Assert.assertNotNull(h2.getClan());
	}

	@Test
	public void testDañar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Asesino(), 1);

		Assert.assertEquals(105, h2.getSalud());
		if (h.atacar(h2) != 0)
			Assert.assertTrue(h2.getSalud() < 105);
		else
			Assert.assertEquals(105, h2.getSalud());
	}
}
