package dominio;

/**
 * La clase Hechicero representa el oficio de hechicero del personaje y sus 3
 * habilidades concretas.
 * <p>
 */
public class Hechicero extends Casta {

	/**
	 * Crea un personaje con oficio de hechicero dadas la proabilidad de golpe
	 * crítico y de evitar daño y el daño crítico del persnaje.
	 * <p>
	 * 
	 * @param prob_crit
	 * @param evasion
	 * @param daño_crit
	 */
	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}

	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	/**
	 * Define la habilidad1 para el hechicero.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true si logra atacar, false de lo contrario. <br>
	 */
	// Bola de Fuego
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Define la habilidad2 para el hechicero.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true si logra curar, false de lo contrario. <br>
	 */
	// Curar Aliado
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/**
	 * Define la habilidad3 para el hechicero.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true si logra robar, false de lo contrario. <br>
	 */
	// Robar Energia y Salud
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
