package dominio;

/**
 * La clase Asesino representa el oficio de asesino del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
@SuppressWarnings("serial")
public class Asesino extends Casta {

	/**
	 * Crea un personaje con oficio de asesino dadas la proabilidad de golpe
	 * crítico y de evitar danio y el danio crítico del persnaje.
	 * <p>
	 * 
	 * @param prob_crit
	 * @param evasion
	 * @param danio_crit
	 */
	public Asesino(double prob_crit, double evasion, double danio_crit) {
		super(prob_crit, evasion, danio_crit);
		this.nombreCasta = "Asesino";
	}

	/**
	 * Crea un personaje con oficio de asesino. <br>
	 */
	public Asesino() {
		super();
		this.nombreCasta = "Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	// Golpe Crítico
	/**
	 * Realiza la primer habilidad de la casta del asesino, golpe crítico. <br>
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanioCritico())) > 0) {
				return true;
			}
		}
		return false;
	}

	// Aumentar Evasion
	/**
	 * Realiza la segunda habilidad de la casta del asesino, aumentar evasión.
	 * <br>
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDanio() + 0.15 < 0.5) {
				this.probabilidadEvitarDanio += 0.15;
			} else {
				this.probabilidadEvitarDanio = 0.5;
			}
			return true;
		}
		return false;
	}

	// Robar
	/**
	 * Realiza la tercer habilidad de la casta del asesino, robar. <br>
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
