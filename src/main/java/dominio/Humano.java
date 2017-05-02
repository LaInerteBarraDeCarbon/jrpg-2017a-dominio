package dominio;

/**
 * La clase Humano es la encargada de crear la raza humano. <br>
 */
@SuppressWarnings("serial")
public class Humano extends Personaje {
	/**
	 * Aumento de salud. <br>
	 */
	private final static int aumentoSalud = 5;
	/**
	 * Aumento de energia. <br>
	 */
	private final static int aumentoEnergia = 5;
	/**
	 * Divisor de consumo de energia. <br>
	 */
	private final static int divisorEnergia = 2;
	/**
	 * Divisor de cantidad de vida. <br>
	 */
	private final static int divisorVida = 2;

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
		super(nombre, casta, id);
		saludTope += aumentoSalud;
		energiaTope += aumentoEnergia;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
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
		nombreRaza = "Humano";

		habilidadesRaza = new String[CANTIDADHABILIDADPERSONAJE];
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
			this.setEnergia(this.getEnergia() - MINIMOENERGIA);
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
			if (atacado.serAtacado(atacado.getSalud() / divisorVida) > CERO) {
				this.setEnergia(this.getEnergia() / divisorEnergia);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - MINIMOENERGIA);
		return false;
	}
}
