package dominio;

/**
 * La clase Asesino representa el oficio de asesino del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Asesino extends Casta {

	/**
	 * Destreza adicional de la casta. <br>
	 */
	private static final int INCREMENTODESTREZA = 5;
	/**
	 * Maxima evasion. <br>
	 */
	private static final double MAXIMOEVASION = 0.5;
	/**
	 * Evasion aumentada. <br>
	 */
	private static final double AUMENTAREVASION = 0.15;

	/**
	 * Crea un personaje con oficio de asesino dadas la proabilidad de golpe
	 * crítico y de evitar danio y el danio crítico del persnaje.
	 * <p>
	 * 
	 * @param probCrit
	 *            Probabilidad de realizar un golpe critico. <br>
	 * @param evasion
	 *            Evasion. <br>
	 * @param danioCrit
	 *            Danio critico que realiza. <br>
	 */
	public Asesino(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);
		super.setIncrementoDestreza(INCREMENTODESTREZA);
		super.setNombreCasta("Asesino");
	}

	/**
	 * Crea un personaje con oficio de asesino. <br>
	 */
	public Asesino() {
		super();
		super.setNombreCasta("Asesino");
		super.setIncrementoDestreza(INCREMENTODESTREZA);
		habilidadesCasta = new String[CANTIDADHABILIDADESCASTA];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	/**
	 * Realiza la primer habilidad de la casta del asesino, golpe crítico. <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado((int) (caster.getAtaque() * caster.getCasta().getDanioCritico())) > CERO) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del asesino, aumentar evasión.
	 * <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Nadie. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (this.getProbabilidadEvitarDanio() + AUMENTAREVASION < MAXIMOEVASION) {
				super.setProbabilidadEvitarDanio(super.getProbabilidadEvitarDanio() + AUMENTAREVASION);
			} else {
				super.setProbabilidadEvitarDanio(MAXIMOEVASION);
			}
			return true;
		}
		return false;
	}

	/**
	 * Realiza la tercer habilidad de la casta del asesino, robar. <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}
}
