package dominio;

import java.io.Serializable;

/**
 * La clase Casta representa el oficio de cada personaje.
 * <p>
 * Administra los atributos de probabilidades que se usar�n en la batalla.
 * <p>
 * Tambi�n define las 3 habilidades que var�an seg�n el tipo de personaje.
 * <p>
 */
public abstract class Casta implements Serializable {

	/**
	 * Probabilidad de acertar un golpe cr�tico de un personaje. <br>
	 */
	protected double probabilidadGolpeCritico;
	/**
	 * Probabilidad de evitar da�o que tiene el personaje. <br>
	 */
	protected double probabilidadEvitarDa�o;
	/**
	 * Da�o cr�tico que realiza el personaje. <br>
	 */
	protected double da�oCritico;
	/**
	 * Nombre de la casta a la que pertenece el personaje. <br>
	 */
	protected String nombreCasta;
	/**
	 * Habilidades de la casta del personaje. <br>
	 */
	protected String[] habilidadesCasta;

	/**
	 * Crea la casta de un personaje con probabilidad de golpe cr�tico y de
	 * evitar da�o, y su da�o cr�tico predefinido. <br>
	 */
	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDa�o = 0.2;
		this.da�oCritico = 1.5;
	}

	/**
	 * Crea una casta dadas la proabilidad de golpe cr�tico y de evitar da�o, y
	 * el da�o cr�tico del persnaje.
	 * <p>
	 * 
	 * @param prob_crit
	 * @param evasion
	 * @param da�o_crit
	 */
	public Casta(double prob_crit, double evasion, double da�o_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDa�o = evasion;
		this.da�oCritico = da�o_crit;
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
	 * Devuelve la probabilidad de golpe cr�tico del personaje. <br>
	 * 
	 * @return Probabilida de golpe cr�tico. <br>
	 */
	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * Establece la probabilidad de golpe cr�tico del personaje. <br>
	 * 
	 * @param probabilidadGolpeCritico
	 */
	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * Devuelve la probabilidad de evitar da�o del personaje. <br>
	 * 
	 * @return Probabilidad de evitar golpe. <br>
	 */
	public double getProbabilidadEvitarDa�o() {
		return probabilidadEvitarDa�o;
	}

	/**
	 * Establece la probabilidad de evitar da�o del personaje. <br>
	 * 
	 * @param probabilidadEvitarDa�o
	 */
	public void setProbabilidadEvitarDa�o(double probabilidadEvitarDa�o) {
		this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
	}

	/**
	 * Devuelve el da�o cr�tico del personaje. <br>
	 * 
	 * @return Da�o cr�tico. <br>
	 */
	public double getDa�oCritico() {
		return da�oCritico;
	}

	/**
	 * Establece el da�o cr�tico del personaje. <br>
	 * 
	 * @param da�oCritico
	 */
	public void setDa�oCritico(double da�oCritico) {
		this.da�oCritico = da�oCritico;
	}
}
