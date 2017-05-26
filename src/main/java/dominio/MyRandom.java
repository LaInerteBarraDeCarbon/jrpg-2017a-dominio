package dominio;

import java.util.Random;

/**
 * La clase MyRandom se utiliza para calcular elementos random, sea para las
 * batallas como para la dificultad. <br>
 */
public class MyRandom extends RandomGenerator {

	/**
	 * Devuelve un random double. <br>
	 */
	@Override
	public double nextDouble() {
		return new Random().nextDouble();
	}

	/**
	 * Devuelve un random int. <br>
	 */
	@Override
	public int nextInt(final int val) {
		return new Random().nextInt(val);
	}
}
