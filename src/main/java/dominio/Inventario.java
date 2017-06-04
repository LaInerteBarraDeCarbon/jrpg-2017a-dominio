package dominio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Clase que se encarga de los ítems en el inventario. <br>
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
	 * Foto del item. <br>
	 */
	private final String foto;

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
	 * @param foto
	 *            Foto del item. <br>
	 * @throws IOException
	 *             Error al abrir archivo. <br>
	 */
	public Inventario(final int id, final String nombre, final int bonusSalud, final int bonusEnergia,
			final int bonusAtaque, final int bonusDefensa, final int bonusMagia, final String foto) throws IOException {
		this.idItem = id;
		this.nombre = nombre;
		this.bonusSalud = bonusSalud;
		this.bonusEnergia = bonusEnergia;
		this.bonusFuerza = bonusAtaque;
		this.bonusDestreza = bonusDefensa;
		this.bonusInteligencia = bonusMagia;
		this.foto = foto;
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
	 * Devuelve el ícono de la foto. <br>
	 * 
	 * @return Ícono. <br>
	 * @throws IOException
	 *             Error al abrir el archivo. <br>
	 */
	public BufferedImage getFoto() throws IOException {
		return ImageIO.read(new File("recursos/" + foto));
	}
}
