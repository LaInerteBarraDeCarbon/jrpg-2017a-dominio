package dominio;

/**
 * La clase NonPlayableCharacter se encarga de crear los NPC, personajes
 * propiamente del juego.
 */
public class NonPlayableCharacter implements Peleable {

	/**
	 * Salud del NPC. <br>
	 */
	private int salud;
	/**
	 * Fuerza del NPC. <br>
	 */
	private int fuerza;
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
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;// 30%
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;// 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;// 50%
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;

		}
	}

	public int otorgarExp() {
		return this.nivel * 30;
	}

	/**
	 * Devuelve la fuerza del NPC. <br>
	 * 
	 * @return Fuerza del NPC. <br>
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Establece la fuerza del NPC. <br>
	 * 
	 * @param fuerza
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
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

	public boolean estaVivo() {
		return salud > 0;
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

	public int getSalud() {
		return salud;
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
		} else
			return atacado.serAtacado(this.getAtaque());
	}

	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	public void despuesDeTurno() {
	}

	/**
	 * Indica la experiencia ganada para el NPC. <br>
	 * 
	 * @param exp
	 */
	public void ganarExperiencia(int exp) {

	}

	@Override
	public int getAtaque() {
		return fuerza;
	}

	@Override
	public void setAtaque(int ataque) {
		this.fuerza = ataque;
	}
}
