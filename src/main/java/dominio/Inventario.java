package dominio;

import java.io.IOException;

/**
 * Clase que se encarga de
 */
public class Inventario {
	/**
	 * ID del item. <br>
	 */
	private final int idItem;
	/**
	 * Nombre del item. <br>
	 */
	private final String nombre;
	/**
	 * Modificador discreto de salud del item. <br>
	 */
	private final int bonusSalud;
	/**
	 * Modificador discreto de energía del item. <br>
	 */
	private final int bonusEnergia;
	/**
	 * Modificador discreto de fuerza del item. <br>
	 */
	private final int bonusFuerza;
	/**
	 * Modificador discreto de destreza del item. <br>
	 */
	private final int bonusDestreza;
	/**
	 * Modificador discreto de inteligencia del item. <br>
	 */
	private final int bonusInteligencia;
	/**
	 * Modificador gradual de salud. <br>
	 */
	private final double modificadorSalud;
	/**
	 * Modificador gradual de energía. <br>
	 */
	private final double modificadorEnergia;
	/**
	 * Modificador gradual de fuerza. <br>
	 */
	private final double modificadorFuerza;
	/**
	 * Modificador gradual de destreza. <br>
	 */
	private final double modificadorDestreza;
	/**
	 * Modificador gradual de inteligencia. <br>
	 */
	private final double modificadorInteligencia;

	/**
	 * Construye un objeto inventario con sus modificadores correspondientes.
	 * <br>
	 * 
	 * @param id
	 *            ID del item. <br>
	 * @param nombre
	 *            Nombre del item. <br>
	 * @param bonusSalud
	 *            Modificador discreto de salud. <br>
	 * @param bonusEnergia
	 *            Modificador discreto de energía. <br>
	 * @param bonusAtaque
	 *            Modificador discreto de fuerza. <br>
	 * @param bonusDefensa
	 *            Modificador discreto de destreza. <br>
	 * @param bonusMagia
	 *            Modificador discreto de inteligencia. <br>
	 * @param porcSalud
	 *            Modificador gradual de salud. <br>
	 * @param porcEnergia
	 *            Modificador gradual de energía. <br>
	 * @param porcAtaque
	 *            Modificador gradual de fuerza. <br>
	 * @param porcDefensa
	 *            Modificador gradual de defensa. <br>
	 * @param porcMagia
	 *            Modificador gradual de inteligencia. <br>
	 * @throws IOException
	 *             Error al abrir archivo. <br>
	 */
	public Inventario(final int id, final String nombre, final int bonusSalud, final int bonusEnergia,
			final int bonusAtaque, final int bonusDefensa, final int bonusMagia, final double porcSalud,
			final double porcEnergia, final double porcAtaque, final double porcDefensa, final double porcMagia)
			throws IOException {
		this.idItem = id;
		this.nombre = nombre;
		this.bonusSalud = bonusSalud;
		this.bonusEnergia = bonusEnergia;
		this.bonusFuerza = bonusAtaque;
		this.bonusDestreza = bonusDefensa;
		this.bonusInteligencia = bonusMagia;
		this.modificadorSalud = porcSalud;
		this.modificadorEnergia = porcEnergia;
		this.modificadorFuerza = porcAtaque;
		this.modificadorDestreza = porcDefensa;
		this.modificadorInteligencia = porcMagia;
	}

	/**
	 * Devuelve el ID del item. <br>
	 * 
	 * @return ID. <br>
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * Devuelve el nombre del item. <br>
	 * 
	 * @return Nombre. <br>
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el bonus de salud del item. <br>
	 * 
	 * @return Bonus salud. <br>
	 */
	public int getBonusSalud() {
		return bonusSalud;
	}

	/**
	 * Devuelve el bonus de energía del item. <br>
	 * 
	 * @return Bonus energía. <br>
	 */
	public int getBonusEnergia() {
		return bonusEnergia;
	}

	/**
	 * Devuelve el bonus de fuerza del item. <br>
	 * 
	 * @return Bonus fuerza. <br>
	 */
	public int getBonusFuerza() {
		return bonusFuerza;
	}

	/**
	 * Devuelve el bonus de defensa del item. <br>
	 * 
	 * @return Bonus defensa. <br>
	 */
	public int getBonusDestreza() {
		return bonusDestreza;
	}

	/**
	 * Devuelve el bonus de inteligencia del item. <br>
	 * 
	 * @return Bonus inteligencia. <br>
	 */
	public int getBonusInteligencia() {
		return bonusInteligencia;
	}

	/**
	 * Devuelve el modificador de salud del item. <br>
	 * 
	 * @return Modificador salud. <br>
	 */
	public double getModificadorSalud() {
		return modificadorSalud;
	}

	/**
	 * Devuelve el modificador de energía del item. <br>
	 * 
	 * @return Modificador energía. <br>
	 */
	public double getModificadorEnergia() {
		return modificadorEnergia;
	}

	/**
	 * Devuelve el modificador de fuerza del item. <br>
	 * 
	 * @return Modificador fuerza. <br>
	 */
	public double getModificadorFuerza() {
		return modificadorFuerza;
	}

	/**
	 * Devuelve el modificador de destreza del item. <br>
	 * 
	 * @return Modificador destreza. <br>
	 */
	public double getModificadorDestreza() {
		return modificadorDestreza;
	}

	/**
	 * Devuelve el modificador de inteligencia del item. <br>
	 * 
	 * @return Modificador inteligencia. <br>
	 */
	public double getModificadorInteligencia() {
		return modificadorInteligencia;
	}
}
