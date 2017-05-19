package dominio;

/**
 * La clase Hechicero representa el oficio de hechicero del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Hechicero extends Casta {

	/**
	 * Magia adicional de la casta. <br>
	 */
	private static final int INCREMENTOMAGIA = 5;
	/**
	 * Divide la magia. <br>
	 */
	private static final int DIVISORMAGIA = 2;
	/**
	 * Multplica la magia. <br>
	 */
	private static final double MULTIPLICADORMAGIA = 1.5;

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
	public Hechicero(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);
		super.setNombreCasta("Hechicero");
	}

	/**
	 * Crea un personaje con oficio de hechizero. <br>
	 */
	public Hechicero() {
		super();
		super.setNombreCasta("Hechicero");
		super.setIncrementoInteligencia(INCREMENTOMAGIA);
		habilidadesCasta = new String[CANTIDADHABILIDADESCASTA];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	/**
	 * Realiza la primer habilidad de la casta del hechizero, bola de fuego.
	 * <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.quitarEnergia(ENERGIAMINIMA);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * MULTIPLICADORMAGIA)) > CERO) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del hechizero, curar aliado.
	 * <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param aliado
	 *            Personaje a quien lanza la habilidad. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad2(final Personaje caster, final Peleable aliado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.quitarEnergia(ENERGIAMINIMA);
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
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.quitarEnergia(ENERGIAMINIMA);
			if (atacado instanceof Personaje) {
				int energiaRobada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / DIVISORMAGIA);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}

		}
		return false;
	}
}
