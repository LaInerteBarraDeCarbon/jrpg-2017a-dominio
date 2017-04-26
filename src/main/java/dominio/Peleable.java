package dominio;

/**
 * Esta interface proporciona los m�todos para la batalla, como el nombre de los
 * personajes, su salud, el da�o de ataque que realizan, entre otros. <br>
 */
public interface Peleable {

	/**
	 * Indica el da�o recibido. <br>
	 * 
	 * @param da�o
	 * @return Da�o recibido. <br>
	 */
	public int serAtacado(int da�o);

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
	 * @return Da�o realizado. <br>
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
