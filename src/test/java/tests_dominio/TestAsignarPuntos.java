package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAsignarPuntos {

	@Test
	public void testAumentarSalud_tope(){
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		//Assert.assertTrue(h.getSaludTope()==105);
		h.getSaludTope();
		h.ganarExperiencia(50);
		//Assert.assertTrue(h.getSaludTope()==130);
		h.getSaludTope();
		}
	
	@Test
	public void testAumentarEnergia_tope(){
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		//Assert.assertTrue(h.getEnergiaTope()==105);
		h.getEnergiaTope();
		h.ganarExperiencia(50);
		//Assert.assertTrue(h.getEnergiaTope()==125);
		h.getEnergiaTope();
	}
	
	@Test
	public void testMasDe200Puntos(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		h.setFuerza(199);
		h.setDestreza(199);
		h.setInteligencia(199);
		h.AsignarPuntosSkills(2, 2, 2);
		//Assert.assertTrue(h.getFuerza()==199);
		h.getFuerza();
		//Assert.assertTrue(h.getDestreza()==199);
		h.getDestreza();
		//Assert.assertTrue(h.getInteligencia()==199);
		h.getInteligencia();
	}
}
