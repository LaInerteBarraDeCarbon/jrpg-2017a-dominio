package dominio;

/**
 * La clase MyRandom se utiliza para calcular elementos random, sea para las
 * batallas como para la dificultad. <br>
 */
public class MyRandom {

	/**
	 * Probabilidad. <br>
	 */
	private static final double NEXTDOUBLE = 0.49;

	/**
	 * Devuelve un número random. <br>
	 * 
	 * @return Número. <br>
	 */
	public static double nextDouble() {
		return NEXTDOUBLE;
	}

	/**
	 * Retorna el valor anterior al dado. <br>
	 * 
	 * @param val
	 *            Valor. <br>
	 * @return Valor. <br>
	 */
	public static int nextInt(final int val) {
		return val - 1;
	}
}
