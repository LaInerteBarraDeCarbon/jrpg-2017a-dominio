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

	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDa�o;
	protected double da�oCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDa�o = 0.2;
		this.da�oCritico = 1.5;
	}

	/**
	 * Crea una casta dadas la proabilidad de golpe cr�tico y de evitar da�o y
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

	public double getProbabilidadEvitarDa�o() {
		return probabilidadEvitarDa�o;
	}

	public void setProbabilidadEvitarDa�o(double probabilidadEvitarDa�o) {
		this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
	}

	public double getDa�oCritico() {
		return da�oCritico;
	}

	public void setDa�oCritico(double da�oCritico) {
		this.da�oCritico = da�oCritico;
	}
}
