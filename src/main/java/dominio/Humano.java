package dominio;

/**
 * La clase Humano es la encargada de crear la raza humano. <br>
 */
@SuppressWarnings("serial")
public class Humano extends Personaje {
	/**
	 * Aumento de salud. <br>
	 */
	private static final int AUMENTOSALUD = 5;
	/**
	 * Aumento de energia. <br>
	 */
	private static final int AUMENTOENERGIA = 5;
	/**
	 * Divisor de consumo de energia. <br>
	 */
	private static final int DIVISORENERGIA = 2;
	/**
	 * Divisor de cantidad de vida. <br>
	 */
	private static final int DIVISORVIDA = 2;

	/**
	 * Crea el personaje de raza Humano asginandole los valores predefinidos de
	 * su salud y energia. <br>
	 * 
	 * @param nombre
	 *            Nombre del personaje. <br>
	 * @param casta
	 *            Casta del personaje. <br>
	 * @param id
	 *            ID del personaje. <br>
	 */
	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id, AUMENTOSALUD, AUMENTOENERGIA);
		super.establecerSalud(super.getSaludTope());
		super.setEnergia(this.getEnergiaTope());
		this.cargarHumano();
	}

	/**
	 * Este constructor sobreescribe el constructor de Personaje con los valores
	 * correspondientes a la raza de Humano. Asignandole las habiliades y
	 * caracteristicas correspondientes. <br>
	 * 
	 * 
	 * @param nombre
	 *            Nombre del personaje. <br>
	 * @param salud
	 *            Salud del personaje. <br>
	 * @param energia
	 *            Energia del personaje. <br>
	 * @param fuerza
	 *            Fuerza del personaje. <br>
	 * @param destreza
	 *            Destreza del personaje. <br>
	 * @param inteligencia
	 *            Inteligencia del personaje. <br>
	 * @param casta
	 *            Casta del personaje. <br>
	 * @param experiencia
	 *            Experiencia del personaje. <br>
	 * @param nivel
	 *            Nivel del personaje. <br>
	 * @param idPersonaje
	 *            ID del personaje. <br>
	 */
	public Humano(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		this.cargarHumano();
	}

	/**
	 * Carga la raza humano con sus habilidades de raza. <br>
	 */
	private void cargarHumano() {
		super.setNombreRaza("Humano");
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * Realiza la primer habilidad de raza del humano, incentivar. <br>
	 * 
	 * @param atacado
	 *            Personaje al que buffea. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > MINIMOENERGIA) {
			this.quitarEnergia(MINIMOENERGIA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de raza del humano, golpe fatal. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > MINIMOENERGIA) {
			if (atacado.serAtacado(atacado.getSalud() / DIVISORVIDA) > CERO) {
				this.quitarEnergia(DIVISORENERGIA);
				return true;
			}
		}
		this.quitarEnergia(MINIMOENERGIA);
		return false;
	}
}
