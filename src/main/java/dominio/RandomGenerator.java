package dominio;

/**
 * Interfaz que se encarga de generar los métodos random para las distintas
 * clases, según su necesidad. <br>
 */
public abstract class RandomGenerator {
	/**
	 * Genera un valor double al azar. <br>
	 * 
	 * @return Valor double. <br>
	 */
	public abstract double nextDouble();

	/**
	 * Genera un valor int al azar. <br>
	 * 
	 * @param val
	 *            Parametro a multiplicar. <br>
	 * @return Número entero. <br>
	 */
	public abstract int nextInt(final int val);
}
