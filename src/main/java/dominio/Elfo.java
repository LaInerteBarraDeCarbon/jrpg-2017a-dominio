package dominio;

/**
 * La clase Elfo crea los personajes de dicha raza. Asi tambien implementa sus
 * habilidades especiales de esta raza. <br>
 */
@SuppressWarnings("serial")
public class Elfo extends Personaje {

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
	public Elfo(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
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
	public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * Realiza la primer habilidad de raza de elfo, el golpe de nivel. <br>
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > minimoEnergia) {
			this.setEnergia(this.getEnergia() - minimoEnergia);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * minimoEnergia) > cero) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de raza de elfo, el ataque de bosque. <br>
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > minimoEnergia) {
			this.setEnergia(this.getEnergia() - minimoEnergia);
			if (atacado.serAtacado((int) (this.magia)) > cero) {
				return true;
			}
		}
		return false;
	}
}
