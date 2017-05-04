package dominio;

/**
 * La clase Elfo crea los personajes de dicha raza. Asi tambien implementa sus
 * habilidades especiales de esta raza. <br>
 */
@SuppressWarnings("serial")
public class Elfo extends Personaje {

	/**
	 * Aumento de salud del elfo. <br>
	 */
	private static final int AUMENTARENERGIA = 10;
	/**
	 * Aumento de energia del elfo. <br>
	 */
	private static final int AUMENTARVIDA = CERO;

	/**
	 * Crea el personaje Elfo con sus valores ya establecidos y le asigna sus
	 * habilidades de raza. <br>
	 * 
	 * @param nombre
	 *            Nombre del personaje. <br>
	 * @param casta
	 *            Casta del personaje. <br>
	 * @param id
	 *            ID del personaje. <br>
	 */
	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id, AUMENTARVIDA, AUMENTARENERGIA);
		super.setSalud(this.getSaludTope());
		super.setEnergia(this.getEnergiaTope());
		this.cargarElfo();
	}

	/**
	 * Este constructor sobreescribe el constructor de Personaje con los valores
	 * correspondientes a la raza de Elfo. Asignandole las habiliades y
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
	public Elfo(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		this.cargarElfo();
	}

	/**
	 * Carga la raza elfo con sus habilidades de raza. <br>
	 */
	private void cargarElfo() {
		super.setNombreRaza("Elfo");
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * Realiza la primer habilidad de raza de elfo, el golpe de nivel. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > MINIMOENERGIA) {
			this.setEnergia(this.getEnergia() - MINIMOENERGIA);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * MINIMOENERGIA) > CERO) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de raza de elfo, el ataque de bosque. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > MINIMOENERGIA) {
			this.setEnergia(this.getEnergia() - MINIMOENERGIA);
			if (atacado.serAtacado((int) (this.getMagia())) > CERO) {
				return true;
			}
		}
		return false;
	}
}
