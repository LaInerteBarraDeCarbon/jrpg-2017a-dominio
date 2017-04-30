package dominio;

/**
 * Esta interface proporciona los m�todos para la batalla, como el nombre de los
 * personajes, su salud, el danio de ataque que realizan, entre otros. <br>
 */
public interface Peleable {

	/**
	 * Indica el danio recibido. <br>
	 * 
	 * @param danio
	 * @return Danio recibido. <br>
	 */
	public int serAtacado(int danio);

	/**
	 * Devuelve la salud del personaje. <br>
	 * 
	 * @return Salud. <br>
	 */
	public int getSalud();

	/**
	 * Indica la condici�n de despu�s de turno. <br>
	 */
	public void despuesDeTurno();

	/**
	 * Ataca a otro personaje. <br>
	 * 
	 * @param atacado
	 * @return Danio realizado. <br>
	 */
	public int atacar(Peleable atacado);

	/**
	 * Otorga experiencia al personaje. <br>
	 * 
	 * @return Experiencia. <br>
	 */
	public int otorgarExp();

	/**
	 * Devuelve el ataque del personaje. <br>
	 * 
	 * @return Ataque. <br>
	 */
	public int getAtaque();

	/**
	 * Establece el ataque del personaje. <br>
	 * 
	 * @param ataque
	 */
	public void setAtaque(int ataque);

	/**
	 * Indica si el personaje se encuentra vivo. <br>
	 * 
	 * @return true de estar vivo, false de estar muerto. <br>
	 */
	public boolean estaVivo();

	/**
	 * Devuelve el nombre del personaje. <br>
	 * 
	 * @return Nombre. <br>
	 */
	public String getNombre();
}
