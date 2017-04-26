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

	/**
	 * Probabilidad de acertar un golpe crítico de un personaje. <br>
	 */
	protected double probabilidadGolpeCritico;
	/**
	 * Probabilidad de evitar daño que tiene el personaje. <br>
	 */
	protected double probabilidadEvitarDaño;
	/**
	 * Daño crítico que realiza el personaje. <br>
	 */
	protected double dañoCritico;
	/**
	 * Nombre de la casta a la que pertenece el personaje. <br>
	 */
	protected String nombreCasta;
	/**
	 * Habilidades de la casta del personaje. <br>
	 */
	protected String[] habilidadesCasta;

	/**
	 * Crea la casta de un personaje con probabilidad de golpe crítico y de
	 * evitar daño, y su daño crítico predefinido. <br>
	 */
	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDaño = 0.2;
		this.dañoCritico = 1.5;
	}

	/**
	 * Crea una casta dadas la proabilidad de golpe crítico y de evitar daño, y
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
	 * Utiliza la primer habilidad de casta del personaje.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Utiliza la segunda habilidad de casta del personaje.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Utiliza la tercera habilidad de casta del personaje.
	 * <p>
	 * 
	 * @param caster
	 * @param atacado
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * Devuelve el nombre de la casta del personaje. <br>
	 * 
	 * @return Nombre de la casta. <br>
	 */
	public String getNombreCasta() {
		return this.nombreCasta;
	}

	/**
	 * Devuelve las habilidades de la casta del personaje. <br>
	 * 
	 * @return Habilidades de la casta. <br>
	 */
	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	/**
	 * Devuelve la probabilidad de golpe crítico del personaje. <br>
	 * 
	 * @return Probabilida de golpe crítico. <br>
	 */
	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * Establece la probabilidad de golpe crítico del personaje. <br>
	 * 
	 * @param probabilidadGolpeCritico
	 */
	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * Devuelve la probabilidad de evitar daño del personaje. <br>
	 * 
	 * @return Probabilidad de evitar golpe. <br>
	 */
	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}

	/**
	 * Establece la probabilidad de evitar daño del personaje. <br>
	 * 
	 * @param probabilidadEvitarDaño
	 */
	public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
		this.probabilidadEvitarDaño = probabilidadEvitarDaño;
	}

	/**
	 * Devuelve el daño crítico del personaje. <br>
	 * 
	 * @return Daño crítico. <br>
	 */
	public double getDañoCritico() {
		return dañoCritico;
	}

	/**
	 * Establece el daño crítico del personaje. <br>
	 * 
	 * @param dañoCritico
	 */
	public void setDañoCritico(double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
}
