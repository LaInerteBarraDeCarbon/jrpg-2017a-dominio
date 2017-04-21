package dominio;

/**
 * La clase Asesino representa el oficio de asesino del personaje
 * y sus 3 habilidades concretas.
 * <p>
 */
public class Asesino extends Casta {

	/**
	 * Crea un personaje con oficio de asesino dadas la proabilidad de
	 * golpe crítico y de evitar daño y el daño crítico del persnaje.
	 * <p>
	 * @param prob_crit	es la probabilidad del personaje de dar un golpe crítico.
	 * @param evasion	es la probabilidad del personaje de evitar el daño.
	 * @param daño_crit	es la fuerza del daño crítico del personaje.
	 */
	public Asesino(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta="Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	/**
	 * Define la habilidad1 para el asesino.
	 * <p>
	 * @param caster
	 * @param atacado
	 */
	// Golpe Crítico
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Define la habilidad2 para el asesino.
	 * <p>
	 * @param caster
	 * @param atacado
	 */
	// Aumentar Evasion
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;
			else
				this.probabilidadEvitarDaño = 0.5;
			return true;
		}
		return false;
	}

	/**
	 * Define la habilidad3 para el asesino.
	 * <p>
	 * @param caster
	 * @param atacado
	 */
	// Robar
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
