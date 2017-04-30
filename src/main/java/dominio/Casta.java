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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Probabilidad de acertar un golpe crítico de un personaje. <br>
	 */
	protected double probabilidadGolpeCritico;
	/**
	 * Probabilidad de evitar danio que tiene el personaje. <br>
	 */
	protected double probabilidadEvitarDanio;
	/**
	 * Danio crítico que realiza el personaje. <br>
	 */
	protected double danioCritico;
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
	 * evitar danio, y su danio crítico predefinido. <br>
	 */
	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDanio = 0.2;
		this.danioCritico = 1.5;
	}

	/**
	 * Crea una casta dadas la proabilidad de golpe crítico y de evitar danio, y
	 * el danio crítico del persnaje.
	 * <p>
	 * 
	 * @param prob_crit
	 * @param evasion
	 * @param danio_crit
	 */
	public Casta(double prob_crit, double evasion, double danio_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDanio = evasion;
		this.danioCritico = danio_crit;
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
	 * Devuelve la probabilidad de evitar danio del personaje. <br>
	 * 
	 * @return Probabilidad de evitar golpe. <br>
	 */
	public double getProbabilidadEvitarDanio() {
		return probabilidadEvitarDanio;
	}

	/**
	 * Establece la probabilidad de evitar danio del personaje. <br>
	 * 
	 * @param probabilidadEvitarDanio
	 */
	public void setProbabilidadEvitarDanio(double probabilidadEvitarDanio) {
		this.probabilidadEvitarDanio = probabilidadEvitarDanio;
	}

	/**
	 * Devuelve el danio crítico del personaje. <br>
	 * 
	 * @return Danio crítico. <br>
	 */
	public double getDanioCritico() {
		return danioCritico;
	}

	/**
	 * Establece el danio crítico del personaje. <br>
	 * 
	 * @param danioCritico
	 */
	public void setDanioCritico(double danioCritico) {
		this.danioCritico = danioCritico;
	}
}
