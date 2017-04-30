package dominio;

/**
 * La clase NonPlayableCharacter se encarga de crear los NPC, personajes
 * propiamente del juego.
 */
public class NonPlayableCharacter extends Peleable {

	/**
	 * Defensa del NPC. <br>
	 */
	private int defensa;
	/**
	 * Nombre del NPC. <br>
	 */
	private String nombre;
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
		return this.nivel * 30;
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

	public String getNombre() {
		return nombre;
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
		if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes
											// criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	public int serAtacado(int danio) {
		if (MyRandom.nextDouble() >= 0.15) {
			danio -= this.getDefensa() / 2;
			if (danio > 0) {
				salud -= danio;
				return danio;
			}
			return 0;// no le hace danio ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	/**
	 * Indica la experiencia ganada para el NPC. <br>
	 * 
	 * @param exp
	 */
	public void ganarExperiencia(int exp) {

	}
}
