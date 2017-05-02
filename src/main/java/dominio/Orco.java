package dominio;

/**
 * La clase Orco crea el personaje de raza Orco e implementa las habilidades
 * especiales de esta raza. <br>
 */
@SuppressWarnings("serial")
public class Orco extends Personaje {

	/**
	 * Multiplica defensa: 2. <br>
	 */
	private static int multiplicadorDefensa = 2;

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
	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
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
	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * Realiza la primera habilidad de orco, el golpe defensa. <br>
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > minimoEnergia) {
			this.setEnergia(this.getEnergia() - minimoEnergia);
			if (atacado.serAtacado(this.getDefensa() * multiplicadorDefensa) > cero) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de orco, el modisco de vida. <br>
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > minimoEnergia) {
			this.setEnergia(this.getEnergia() - minimoEnergia);
			int danioCausado = atacado.serAtacado(this.getFuerza());
			if (danioCausado > cero) {
				this.serCurado(danioCausado);
				return true;
			}
		}
		return false;
	}
}
