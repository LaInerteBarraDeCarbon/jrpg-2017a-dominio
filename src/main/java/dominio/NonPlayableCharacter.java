package dominio;

/**
 * La clase NonPlayableCharacter se encarga de crear los NPC, personajes
 * propiamente del juego.
 */
public class NonPlayableCharacter extends Peleable {

	/**
	 * Probabilidad de que el NPC de un golpe critico: 0.15. <br>
	 */
	private static double probGolpeCritico = 0.15;
	/**
	 * Probabilidad de que el NPC esquive un golpe: 0.15. <br>
	 */
	private static double probEsquivar = 0.15;
	/**
	 * Divisor de defensa para ver si le asertan un golpe: 2. <br>
	 */
	private static int divisorDefensa = 2;
	/**
	 * Multiplicador que agrega a la experiencia otorgada con respecto al nivel:
	 * 30. <br>
	 */
	private static int multiplicadorExp = 30;
	/**
	 * Multiplicador de ataque de realizar golpe critico: 1.5 <br>
	 */
	private static double multiplicadorGolpeCritico = 1.5;

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
	private static final int dificultadAleatoria = -1;

	/**
	 * Crea dicho personaje con su nombre y nivel espesifico. Cargando sus
	 * cualidades aleatoriamente. <br>
	 * 
	 * @param nombre
	 * @param nivel
	 * @param dificultadNPC
	 */
	public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria) {
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

	public int otorgarExp() {
		return this.nivel * multiplicadorExp;
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
	 */
	public void setataque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Establece el nombre del NPC. <br>
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
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
	 */
	public void setNivel(int nivel) {
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
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Establece la salud del NPC. <br>
	 * 
	 * @param salud
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= probGolpeCritico) {
			return atacado.serAtacado((int) (this.getAtaque() * multiplicadorGolpeCritico));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	public int serAtacado(int danio) {
		if (MyRandom.nextDouble() >= probEsquivar) {
			danio -= this.getDefensa() / divisorDefensa;
			if (danio > cero) {
				salud -= danio;
				return danio;
			}
			return cero;
		}
		return cero;
	}

	/**
	 * Indica la experiencia ganada para el NPC. <br>
	 * 
	 * @param exp
	 *            Experiencia ganada. <br>
	 */
	public void ganarExperiencia(int exp) {

	}
}
