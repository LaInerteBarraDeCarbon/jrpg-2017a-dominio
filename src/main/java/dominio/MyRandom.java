package dominio;

import java.util.Random;

/**
 * La clase MyRandom se utiliza para calcular elementos random, sea para las
 * batallas como para la dificultad. <br>
 */
public class MyRandom implements RandomGenerator {

	/**
	 * Valor random general. <br>
	 */
	private static Random random = new Random();

	/**
	 * Devuelve un número double al azar. <br>
	 * 
	 * @return Número double. <br>
	 */
	public double nextDouble() {
		return random.nextDouble() * random.nextInt(100);
	}

	/**
	 * Devuelve un número entero al azar. <br>
	 * 
	 * @param val
	 *            Valor. <br>
	 * @return Número entero. <br>
	 */
	public int nextInt(final int val) {
		return random.nextInt(100) * val;
	}
}
