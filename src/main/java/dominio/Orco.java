package dominio;

/**
 * La clase Orco crea el personaje de raza Orco e implementa las habilidades
 * especiales de esta raza.
 *
 */
public class Orco extends Personaje {

	/**
	 * Creacion del personaje con la salud y energia a tope y las habilidades
	 * especial de la raza.
	 * 
	 * @param nombre
	 * @param casta
	 * @param id
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
	 * caracteristicas correspondientes.
	 * 
	 * @param nombre
	 * @param salud
	 * @param energia
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 * @param casta
	 * @param experiencia
	 * @param nivel
	 * @param idPersonaje
	 */
	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	// Golpe Defensa
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}

	// Mordisco de Vida
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int da�o_causado = atacado.serAtacado(this.getFuerza());
			if (da�o_causado > 0) {
				this.serCurado(da�o_causado);
				return true;
			}
		}
		return false;
	}
}
