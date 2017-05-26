package dominio;

/**
 * Interfaz que se encarga de generar los métodos random para las distintas
 * clases, según su necesidad. <br>
 */
public interface RandomGenerator {
	/**
	 * Genera un valor double al azar. <br>
	 * 
	 * @return Valor double. <br>
	 */
	public static double nextDouble() {
		return 0;
	}

	/**
	 * Genera un valor int al azar. <br>
	 * 
	 * @param val
	 *            Parametro a multiplicar. <br>
	 * @return Número entero. <br>
	 */
	public static int nextInt(final int val) {
		return 0;
	}
}
