package dominio;

/**
 * La clase NonPlayableCharacter se encarga de crear los NPC, personajes
 * propiamente del juego.
 */
public class NonPlayableCharacter extends Peleable {

	/**
	 * Probabilidad de que el NPC de un golpe critico. <br>
	 */
	private static final double PROBGOLPECRITICO = 0.15;
	/**
	 * Probabilidad de que el NPC esquive un golpe. <br>
	 */
	private static final double PROBESQUIVAR = 0.15;
	/**
	 * Divisor de defensa para ver si le asertan un golpe. <br>
	 */
	private static final int DIVISORDEFENSA = 2;
	/**
	 * Multiplicador que agrega a la experiencia otorgada con respecto al nivel.
	 * <br>
	 */
	private static final int MULTIPLICADOREXP = 30;
	/**
	 * Multiplicador de ataque de realizar golpe critico. <br>
	 */
	private static final double MULTIPLICADORGOLPECRITICO = 1.5;

	/**
	 * Defensa del NPC. <br>
	 */
	private int defensa;
	/**
	 * Nivel del NPC. <br>
	 */
	private int nivel;
	/**
	 * Dificultad del NPC. <br>
	 */
	private static final int DIFICULTADALEATORIA = -1;

	/**
	 * Crea dicho personaje con su nombre y nivel espesifico. Cargando sus
	 * cualidades aleatoriamente. <br>
	 * 
	 * @param nombre
	 *            Nombre del NPC. <br>
	 * @param nivel
	 *            Nivel del NPC. <br>
	 * @param dificultadNPC
	 *            Dificultad del NPC. <br>
	 */
	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == DIFICULTADALEATORIA) {
			dificultad = MyRandom.nextInt(3);
		} else {
			dificultad = dificultadNPC;
		}
		switch (dificultad) {
		case 0:
			this.ataque = 10 + (nivel - 1) * 3;// 30%
			super.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.ataque = 20 + (nivel - 1) * 6;// 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.ataque = 30 + (nivel - 1) * 10;// 50%
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;
		}
	}

	/**
	 * Cantidad de experiencia que otorga al jugador. <br>
	 * 
	 * @return Experiencia ganada. <br>
	 */
	public int otorgarExp() {
		return this.nivel * MULTIPLICADOREXP;
	}

	/**
	 * Devuelve la ataque del NPC. <br>
	 * 
	 * @return ataque del NPC. <br>
	 */
	public int getataque() {
		return ataque;
	}

	/**
	 * Establece la ataque del NPC. <br>
	 * 
	 * @param ataque
	 *            Ataque. <br>
	 */
	public void setataque(final int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Establece el nombre del NPC. <br>
	 * 
	 * @param nombre
	 *            Nombre. <br>
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el nivel del NPC. <br>
	 * 
	 * @return Nivel del NPC. <br>
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Establece el nivel del NPC. <br>
	 * 
	 * @param nivel
	 *            Nivel. <br>
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Devuelve la defensa del NPC. <br>
	 * 
	 * @return Defensa del NPC. <br>
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Establece la defensa del NPC. <br>
	 * 
	 * @param defensa
	 *            Defensa. <br>
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Establece la salud del NPC. <br>
	 * 
	 * @param salud
	 *            Salud. <br>
	 */
	public void setSalud(final int salud) {
		this.salud = salud;
	}

	/**
	 * Ataca a otro personaje. <br>
	 *
	 * @param atacado
	 *            Personaje atacado. <br>
	 * @return Danio realizado. <br>
	 */
	public int atacar(final Peleable atacado) {
		if (MyRandom.nextDouble() <= PROBGOLPECRITICO) {
			return atacado.serAtacado((int) (this.getAtaque() * MULTIPLICADORGOLPECRITICO));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	/**
	 * Indica el danio recibido. <br>
	 * 
	 * @param danio
	 *            Danio recibido. <br>
	 * @return Danio recibido. <br>
	 */
	public int serAtacado(int danio) {
		if (MyRandom.nextDouble() >= PROBESQUIVAR) {
			danio -= this.getDefensa() / DIVISORDEFENSA;
			if (danio > CERO) {
				salud -= danio;
				return danio;
			}
			return CERO;
		}
		return CERO;
	}

	/**
	 * Indica la experiencia ganada para el NPC. <br>
	 * 
	 * @param exp
	 *            Experiencia ganada. <br>
	 */
	public void ganarExperiencia(final int exp) {

	}
}
