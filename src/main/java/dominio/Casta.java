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
@SuppressWarnings("serial")
public abstract class Casta implements Serializable {

	/**
	 * Energia minima para realizar alguna accion. <br>
	 */
	protected static final int ENERGIAMINIMA = 10;
	/**
	 * Numero CERO. <br>
	 */
	protected static final int CERO = 0;
	/**
	 * Cantidad de habilidades por casta. <br>
	 */
	protected static final int CANTIDADHABILIDADESCASTA = 3;
	/**
	 * Probabilidad de golpe critico de casta. <br>
	 */
	private static final double PROBABILIDADGOLPECRITICO = 0.2;
	/**
	 * Probabilidad de evitar daño de casta. <br>
	 */
	private static final double PROBABILIDADEVITARDANIO = 0.2;
	/**
	 * daño critico de casta. <br>
	 */
	private static final double DANIOCRITICO = 1.5;

	/**
	 * Probabilidad de acertar un golpe cr�tico de un personaje. <br>
	 */
	private double probabilidadGolpeCritico;
	/**
	 * Probabilidad de evitar daño que tiene el personaje. <br>
	 */
	private double probabilidadEvitarDanio;
	/**
	 * daño cr�tico que realiza el personaje. <br>
	 */
	private double danioCritico;
	/**
	 * Nombre de la casta a la que pertenece el personaje. <br>
	 */
	private String nombreCasta;
	/**
	 * Habilidades de la casta del personaje. <br>
	 */
	protected String[] habilidadesCasta;

	/**
	 * Incremento de inteligencia de la casta. <br>
	 */
	private int incrementoInteligencia;
	/**
	 * Incremento de destreza de la casta. <br>
	 */
	private int incrementoDestreza;
	/**
	 * Incremento de fuerza de la casta. <br>
	 */
	private int incrementoFuerza;

	/**
	 * Crea la casta de un personaje con probabilidad de golpe cr�tico y de
	 * evitar daño, y su daño cr�tico predefinido. <br>
	 */
	public Casta() {
		this.probabilidadGolpeCritico = PROBABILIDADGOLPECRITICO;
		this.probabilidadEvitarDanio = PROBABILIDADEVITARDANIO;
		this.danioCritico = DANIOCRITICO;
		this.incrementoInteligencia = CERO;
		this.incrementoDestreza = CERO;
		this.incrementoFuerza = CERO;
	}

	/**
	 * Crea una casta dadas la proabilidad de golpe cr�tico y de evitar daño, y
	 * el daño cr�tico del personaje.
	 * <p>
	 * 
	 * @param probCrit
	 *            Probabilidad de realizar cr�tico. <br>
	 * @param evasion
	 *            Evasion. <br>
	 * @param dañoCrit
	 *            daño Critico que realiza. <br>
	 */
	public Casta(final double probCrit, final double evasion, final double danioCrit) {
		this.probabilidadGolpeCritico = probCrit;
		this.probabilidadEvitarDanio = evasion;
		this.danioCritico = danioCrit;
	}

	/**
	 * Utiliza la primer habilidad de casta del personaje.
	 * <p>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Utiliza la segunda habilidad de casta del personaje.
	 * <p>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br>
	 * 
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Utiliza la tercera habilidad de casta del personaje.
	 * <p>
	 * 
	 * @param caster
	 *            Personaje que lanza la habilidad. <br>
	 * @param atacado
	 *            Personaje a quien lanza la habilidad. <br
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
	 *            Probabilidad de realizar un golpe critico. <br>
	 */
	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * Devuelve la probabilidad de evitar daño del personaje. <br>
	 * 
	 * @return Probabilidad de evitar golpe. <br>
	 */
	public double getProbabilidadEvitarDanio() {
		return probabilidadEvitarDanio;
	}

	/**
	 * Establece la probabilidad de evitar daño del personaje. <br>
	 * 
	 * @param probabilidadEvitardaño
	 *            La probabilidad de evitar daño. <br>
	 */
	public void setProbabilidadEvitarDanio(final double probabilidadEvitarDanio) {
		this.probabilidadEvitarDanio = probabilidadEvitarDanio;
	}

	/**
	 * Devuelve el daño cr�tico del personaje. <br>
	 * 
	 * @return daño crítico. <br>
	 */
	public double getDanioCritico() {
		return danioCritico;
	}

	/**
	 * Establece el daño cr�tico del personaje. <br>
	 * 
	 * @param dañoCritico
	 *            daño critico que realiza. <br>
	 */
	public void setDanioCritico(final double danioCritico) {
		this.danioCritico = danioCritico;
	}

	/**
	 * Devuelve el incrementeo de inteligencia de la casta. <br>
	 * 
	 * @return Inteligencia adicional. <br>
	 */
	public int getIncrementoInteligencia() {
		return incrementoInteligencia;
	}

	/**
	 * Establece el incremento de inteligencia de la casta. <br>
	 * 
	 * @param incrementoInteligencia
	 *            Incremento de inteligencia. <br>
	 */
	public void setIncrementoInteligencia(int incrementoInteligencia) {
		this.incrementoInteligencia = incrementoInteligencia;
	}

	/**
	 * Devuelve el incremento de destreza de la casta. <br>
	 * 
	 * @return Destreza adicional. <br>
	 */
	public int getIncrementoDestreza() {
		return incrementoDestreza;
	}

	/**
	 * Establece el incremento de destreza de la casta. <br>
	 * 
	 * @param incrementoDestreza
	 *            Incremento de destreza. <br>
	 */
	public void setIncrementoDestreza(int incrementoDestreza) {
		this.incrementoDestreza = incrementoDestreza;
	}

	/**
	 * Devuelve el incremento de fuerza de la casta. <br>
	 * 
	 * @return Fuerza adicional. <br>
	 */
	public int getIncrementoFuerza() {
		return incrementoFuerza;
	}

	/**
	 * Establece el incremento de fuerza de la casta. <br>
	 * 
	 * @param incrementoFuerza
	 *            Incremento de fuerza. <br>
	 */
	public void setIncrementoFuerza(int incrementoFuerza) {
		this.incrementoFuerza = incrementoFuerza;
	}

	/**
	 * Establece el nombre de la casta. <br>
	 * 
	 * @param nombreCasta
	 *            Nombre de la casta. <br>
	 */
	public void setNombreCasta(String nombreCasta) {
		this.nombreCasta = nombreCasta;
	}
}
