package dominio;

/**
 * La clase Guerrero representa el oficio de guerrero del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Guerrero extends Casta {

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
	public Guerrero(double probCrit, double evasion, double danioCrit) {
		super(probCrit, evasion, danioCrit);
		this.nombreCasta = "Guerrero";
	}

	/**
	 * Crea un personaje con el oficio de guerrero. <br>
	 */
	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	/**
	 * Realiza la primer habilidad de la casta del guerrero, ataque doble. <br>
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (atacado.serAtacado(caster.ataque * 2) > cero) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del guerrero, aumentar defensa.
	 * <br>
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	// Ignorar Defensa
	/**
	 * Realiza la tercer habilidad de la casta del guerrero, ignorar defensa.
	 * <br>
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(cero);
				if (atacado.serAtacado(caster.ataque) > cero) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
