package dominio;

/**
 * La clase Hechicero representa el oficio de hechicero del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Hechicero extends Casta {

	/**
	 * Divide la magia: 2. <br>
	 */
	private static int divisorMagia = 2;
	/**
	 * Multplica la magia: 1.5 <br>
	 */
	private static double multiplicadorMagia = 1.5;

	/**
	 * Crea un personaje con oficio de hechicero dadas la proabilidad de golpe
	 * crítico y de evitar danio y el danio crítico del persnaje.
	 * <p>
	 * 
	 * @param probCrit
	 *            Probabilidad de danio critico. <br>
	 * @param evasion
	 *            Evasion. <br>
	 * @param danioCrit
	 *            Danio critico. <br>
	 */
	public Hechicero(double probCrit, double evasion, double danioCrit) {
		super(probCrit, evasion, danioCrit);
		this.nombreCasta = "Hechicero";
	}

	/**
	 * Crea un personaje con oficio de hechizero. <br>
	 */
	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	/**
	 * Realiza la primer habilidad de la casta del hechizero, bola de fuego.
	 * <br>
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * multiplicadorMagia)) > cero) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del hechizero, curar aliado.
	 * <br>
	 */
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la tercer habilidad de la casta del hechizero, robar energía y
	 * salud. <br>
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (atacado instanceof Personaje) {
				int energiaRobada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / divisorMagia);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}

		}
		return false;
	}
}
