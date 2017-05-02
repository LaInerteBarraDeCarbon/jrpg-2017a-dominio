package dominio;

/**
 * La clase Asesino representa el oficio de asesino del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Asesino extends Casta {

	/**
	 * Maxima evasion: 0.5. <br>
	 */
	private final static double maximoEvasion = 0.5;
	/**
	 * Evasion aumentada: 0.15. <br>
	 */
	private final static double aumentoEvasion = 0.15;

	/**
	 * Crea un personaje con oficio de asesino dadas la proabilidad de golpe
	 * cr�tico y de evitar danio y el danio cr�tico del persnaje.
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
		this.nombreCasta = "Asesino";
	}

	/**
	 * Crea un personaje con oficio de asesino. <br>
	 */
	public Asesino() {
		super();
		this.nombreCasta = "Asesino";
		habilidadesCasta = new String[cantidadHabilidadesCasta];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	/**
	 * Realiza la primer habilidad de la casta del asesino, golpe cr�tico. <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanioCritico())) > cero) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del asesino, aumentar evasi�n.
	 * <br>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Nadie. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (this.getProbabilidadEvitarDanio() + aumentoEvasion < maximoEvasion) {
				this.probabilidadEvitarDanio += aumentoEvasion;
			} else {
				this.probabilidadEvitarDanio = maximoEvasion;
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
