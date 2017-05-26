package dominio;

/**
 * La clase Guerrero representa el oficio de guerrero del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Guerrero extends Casta {

	/**
	 * Fuerza adicional de la casta. <br>
	 */
	private static final int INCREMENTOFUERZA = 5;

	/**
	 * Crea un personaje con oficio de guerrero dadas la proabilidad de golpe
	 * cr�tico y de evitar danio y el danio cr�tico del persnaje.
	 * <p>
	 * 
	 * @param probCrit
	 *            Probabilidad de danio critico. <br>
	 * @param evasion
	 *            Evaion. <br>
	 * @param danioCrit
	 *            Danio critico. <br>
	 */
	public Guerrero(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);
		super.setNombreCasta("Guerrero");
		super.setIncrementoFuerza(INCREMENTOFUERZA);
	}

	/**
	 * Crea un personaje con el oficio de guerrero. <br>
	 */
	public Guerrero() {
		super();
		super.setNombreCasta("Guerrero");
		super.setIncrementoFuerza(INCREMENTOFUERZA);
		habilidadesCasta = new String[CANTIDADHABILIDADESCASTA];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	/**
	 * Realiza la primer habilidad de la casta del guerrero, ataque doble. <br>
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
			if (atacado.serAtacado(caster.getAtaque() * 2) > CERO) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del guerrero, aumentar defensa.
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
			caster.quitarEnergia(ENERGIAMINIMA);
			caster.estableceDefensa(caster.getDefensa() + caster.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Realiza la tercer habilidad de la casta del guerrero, ignorar defensa.
	 * <br>
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
				int defensaOriginal = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).estableceDefensa(CERO);
				if (atacado.serAtacado(caster.getAtaque()) > CERO) {
					((Personaje) atacado).estableceDefensa(defensaOriginal);
					return true;
				}
			}
		}
		return false;
	}
}
