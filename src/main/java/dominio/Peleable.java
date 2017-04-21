package dominio;

/**
 * Esta interface proporciona los m�todos para la batalla, como el nombre de los
 * personajes, su salud, el da�o de ataque que realizan, entre otros. <br>
 */
public interface Peleable {

	public int serAtacado(int da�o);

	/**
	 * Devuelve la salud del personaje. <br>
	 * 
	 * @return Salud del personaje. <br>
	 */
	public int getSalud();

	public void despuesDeTurno();

	/**
	 * Ataca a otro personaje. <br>
	 * 
	 * @param atacado
	 * @return Da�o realizado. <br>
	 */
	public int atacar(Peleable atacado);

	public int otorgarExp();

	public int getAtaque();

	public void setAtaque(int ataque);

	public boolean estaVivo();

	public String getNombre();
}
