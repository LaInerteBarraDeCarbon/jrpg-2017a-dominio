package dominio;

/**
 * La clase Orco crea el personaje de raza Orco e implementa las habilidades
 * especiales de esta raza. <br>
 */
@SuppressWarnings("serial")
public class Orco extends Personaje {

	/**
	 * Multiplica defensa. <br>
	 */
	private static final int MULTPLICADORDEFENSA = 2;
	/**
	 * Aumento de salud. <br>
	 */
	private static final int AUMENTOSALUD = 10;
	/**
	 * Aumento de la energia. <br>
	 */
	private static final int AUMENTOENERGIA = CERO;

	/**
	 * Creacion del personaje con la salud y energia a tope y las habilidades
	 * especial de la raza. <br>
	 * 
	 * @param nombre
	 *            Nombre del personaje. <br>
	 * @param casta
	 *            Casta del personaje. <br>
	 * @param id
	 *            ID del personaje. <br>
	 */
	public Orco(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id, AUMENTOSALUD, AUMENTOENERGIA);
		super.setSalud(this.getSaludTope());
		super.setEnergia(this.getEnergiaTope());
		this.cargarOrco();
	}

	/**
	 * Este constructor sobreescribe el constructor de Personaje con los valores
	 * correspondientes a la raza de Orco. Asignandole las habiliades y
	 * caracteristicas correspondientes. <br>
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
	public Orco(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		this.cargarOrco();
	}

	/**
	 * Carga la raza orco con sus habilidades. <br>
	 */
	private void cargarOrco() {
		super.setNombreRaza("Orco");
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * Realiza la primera habilidad de orco, el golpe defensa. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > MINIMOENERGIA) {
			this.quitarEnergia(MINIMOENERGIA);
			if (atacado.serAtacado(this.getDefensa() * MULTPLICADORDEFENSA) > CERO) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de orco, el modisco de vida. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > MINIMOENERGIA) {
			this.quitarEnergia(MINIMOENERGIA);
			int danioCausado = atacado.serAtacado(this.getFuerza());
			if (danioCausado > CERO) {
				this.serCurado(danioCausado);
				return true;
			}
		}
		return false;
	}
}
