package dominio;

/**
 * La clase MyRandom se utiliza para calcular elementos random, sea para las
 * batallas como para la dificultad. <br>
 */
public class MyRandom {

	/**
	 * Devuelve un número random. <br>
	 * 
	 * @return Número. <br>
	 */
	public static double nextDouble() {
		return 0.49;
	}

	/**
	 * Retorna el valor anterior al dado. <br>
	 * 
	 * @param val
	 * @return Valor. <br>
	 */
	public static int nextInt(int val) {
		return val - 1;
	}
}
