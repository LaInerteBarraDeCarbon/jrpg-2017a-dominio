package dominio;

/**
 * La clase Asesino representa el oficio de asesino del personaje
 * y sus 3 habilidades concretas.
 * <p>
 */
public class Asesino extends Casta {

	/**
	 * Crea un personaje con oficio de asesino dadas la proabilidad de
	 * golpe cr�tico y de evitar da�o y el da�o cr�tico del persnaje.
	 * <p>
	 * @param prob_crit	es la probabilidad del personaje de dar un golpe cr�tico.
	 * @param evasion	es la probabilidad del personaje de evitar el da�o.
	 * @param da�o_crit	es la fuerza del da�o cr�tico del personaje.
	 */
	public Asesino(double prob_crit, double evasion, double da�o_crit) {
		super(prob_crit, evasion, da�o_crit);
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
	// Golpe Cr�tico
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDa�oCritico())) > 0)
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
			if (this.getProbabilidadEvitarDa�o() + 0.15 < 0.5)
				this.probabilidadEvitarDa�o += 0.15;
			else
				this.probabilidadEvitarDa�o = 0.5;
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
