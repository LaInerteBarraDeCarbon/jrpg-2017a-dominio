package dominio;

/**
 * La clase Guerrero representa el oficio de guerrero del personaje
 * y sus 3 habilidades concretas.
 * <p>
 */
public class Guerrero extends Casta {

	/**
	 * Crea un personaje con oficio de guerrero dadas la proabilidad de
	 * golpe crítico y de evitar daño y el daño crítico del persnaje.
	 * <p>
	 * @param prob_crit	es la probabilidad del personaje de dar un golpe crítico.
	 * @param evasion	es la probabilidad del personaje de evitar el daño.
	 * @param daño_crit	es la fuerza del daño crítico del personaje.
	 */
	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	/**
	 * Define la habilidad1 para el guerrero.
	 * <p>
	 * @param caster
	 * @param atacado
	 */
	// Ataque Doble
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	/**
	 * Define la habilidad2 para el guerrero.
	 * <p>
	 * @param caster
	 * @param atacado
	 */
	// Aumentar Defensa
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	/**
	 * Define la habilidad3 para el guerrero.
	 * <p>
	 * @param caster
	 * @param atacado
	 */
	// Ignorar Defensa
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
