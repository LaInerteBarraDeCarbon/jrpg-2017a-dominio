package dominio;

/**
 * Esta clase proporciona los metodos para la batalla, como el nombre de los
 * personajes, su salud, el danio de ataque que realizan, entre otros. <br>
 */
public abstract class Peleable {

	/**
	 * Numero CERO. <br>
	 */
	protected static final int CERO = 0;
	/**
	 * Salud del personaje. <br>
	 */
	private Integer salud;
	/**
	 * Nombre del personaje. <br>
	 */
	private String nombre;
	/**
	 * Fuerza del personaje. <br>
	 */
	private int ataque;

	/**
	 * Indica el danio recibido. <br>
	 * 
	 * @param danio
	 *            Danio recibido. <br>
	 * @return Danio recibido. <br>
	 */
	public abstract int serAtacado(int danio);

	/**
	 * Devuelve la salud del personaje. <br>
	 * 
	 * @return Salud. <br>
	 */
	public int getSalud() {
		return this.salud;
	}

	/**
	 * Indica la condicion de despues de turno. <br>
	 */
	public void despuesDeTurno() {

	}

	/**
	 * Ataca a otro personaje. <br>
	 * 
	 * @param atacado
	 *            Personaje atacado. <br>
	 * @return Danio realizado. <br>
	 */
	public abstract int atacar(Peleable atacado);

	/**
	 * Otorga experiencia al personaje. <br>
	 * 
	 * @return Experiencia. <br>
	 */
	public abstract int otorgarExp();

	/**
	 * Devuelve el ataque del personaje. <br>
	 * 
	 * @return Ataque. <br>
	 */
	public int getAtaque() {
		return this.ataque;
	}

	/**
	 * Establece el ataque del personaje. <br>
	 * 
	 * @param ataque
	 *            Ataque del personaje. <br>
	 */
	public void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Indica si el personaje se encuentra vivo. <br>
	 * 
	 * @return true de estar vivo, false de estar muerto. <br>
	 */
	public boolean estaVivo() {
		return this.salud > CERO;
	}

	/**
	 * Devuelve el nombre del personaje. <br>
	 * 
	 * @return Nombre. <br>
	 */
	public String getNombre() {
		return this.nombre;
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
	 * Establece la vida de un personaje. <br>
	 * 
	 * @param vida
	 *            Vida. <br>
	 */
	public void establecerSalud(final int vida) {
		this.salud = vida;
	}

}
