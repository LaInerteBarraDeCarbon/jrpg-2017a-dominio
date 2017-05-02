package dominio;

/**
 * Esta clase proporciona los métodos para la batalla, como el nombre de los
 * personajes, su salud, el danio de ataque que realizan, entre otros. <br>
 */
public abstract class Peleable {

	/**
	 * Numero cero. <br>
	 */
	protected final static int cero = 0;
	/**
	 * Salud del personaje. <br>
	 */
	protected Integer salud;
	/**
	 * Nombre del personaje. <br>
	 */
	protected String nombre;
	/**
	 * Fuerza del personaje. <br>
	 */
	protected int ataque;

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
	 * Indica la condición de después de turno. <br>
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
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Indica si el personaje se encuentra vivo. <br>
	 * 
	 * @return true de estar vivo, false de estar muerto. <br>
	 */
	public boolean estaVivo() {
		return this.salud > cero;
	}

	/**
	 * Devuelve el nombre del personaje. <br>
	 * 
	 * @return Nombre. <br>
	 */
	public String getNombre() {
		return this.nombre;
	}
}
