package dominio;

import java.io.Serializable;

/**
 * La clase Casta representa el oficio de cada personaje.
 * <p>
 * Administra los atributos de probabilidades que se usarán en la batalla.
 * <p>
 * También define las 3 habilidades que varían según el tipo de personaje.
 * <p>
 */
public abstract class Casta implements Serializable {

	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDaño = 0.2;
		this.dañoCritico = 1.5;
	}

	/**
	 * Crea una casta dadas la proabilidad de golpe crítico y de evitar daño y
	 * el daño crítico del persnaje.
	 * <p>
	 * 
	 * @param prob_crit
	 * @param evasion
	 * @param daño_crit
	 */
	public Casta(double prob_crit, double evasion, double daño_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = daño_crit;
	}

	/**
	 * Define la habilidad1 para cada tipo de personaje.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Define la habilidad2 para este tipo de personaje.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Define la habilidad3 para este tipo de personaje.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}

	public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
		this.probabilidadEvitarDaño = probabilidadEvitarDaño;
	}

	public double getDañoCritico() {
		return dañoCritico;
	}

	public void setDañoCritico(double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
}
