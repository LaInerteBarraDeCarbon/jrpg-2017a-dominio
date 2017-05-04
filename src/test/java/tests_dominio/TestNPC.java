package tests_dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.NonPlayableCharacter;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		assertTrue(30 == npc.otorgarExp());
	}

	@Test
	public void creacionNPC() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Atomos", 30, 2);
		if (npc.getNivel() < 60) {
			npc.setNivel(60);
		}
		if (npc.getDefensa() != 15) {
			npc.setDefensa(15);
		}
		assertEquals("Atomos", npc.getNombre());
	}

	@Test
	public void ataqueNPC() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Lamia", 30, 1);
		Humano jugador = new Humano("Firion", new Guerrero(), 1);
		if (jugador.puedeAtacar()) {
			jugador.atacar(npc);
		}
		npc.atacar(jugador);
		if (jugador.estaVivo() && npc.estaVivo()) {
			jugador.despuesDeTurno();
			npc.despuesDeTurno();
		} else {
			if (jugador.estaVivo()) {
				jugador.ganarExperiencia(npc.otorgarExp());
			} else {
				npc.ganarExperiencia(jugador.otorgarExp());
			}
		}
		assertTrue(npc.estaVivo());
	}
}
