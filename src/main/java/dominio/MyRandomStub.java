package dominio;

/**
 * La clase MyRandomStub se utiliza como stub para calcular elementos random,
 * sea para las batallas como para la dificultad. <br>
 */
public class MyRandomStub extends RandomGenerator {

	/**
	 * Probabilidad. <br>
	 */
	private static final double NEXTDOUBLE = 0.49;

	/**
	 * Devuelve un número random. <br>
	 * 
	 * @return Número. <br>
	 */
	public double nextDouble() {
		return NEXTDOUBLE;
	}

	/**
	 * Retorna el valor anterior al dado. <br>
	 * 
	 * @param val
	 *            Valor. <br>
	 * @return Valor. <br>
	 */
	public int nextInt(final int val) {
		return val - 1;
	}
}