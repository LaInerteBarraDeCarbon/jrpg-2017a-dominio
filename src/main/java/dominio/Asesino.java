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
	private static double maximoEvasion = 0.5;
	/**
	 * Evasion aumentada: 0.15. <br>
	 */
	private static double aumentoEvasion = 0.15;
	
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
	public Asesino(double probCrit, double evasion, double danioCrit) {
		super(probCrit, evasion, danioCrit);
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
		if (caster.getEnergia() > energiaMinima) {
			caster.setEnergia(caster.getEnergia() - energiaMinima);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanioCritico())) > cero) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de la casta del asesino, aumentar evasión.
	 * <br>
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
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
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
