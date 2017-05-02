package dominio;

/**
 * La clase Humano es la encargada de crear la raza humano. <br>
 */
@SuppressWarnings("serial")
public class Humano extends Personaje {
	/**
	 * Aumento de vida: 5. <br>
	 */
	private static int aumentoSalud = 5;
	/**
	 * Aumento de energia: 5. <br>
	 */
	private static int aumentoEnergia = 5;
	/**
	 * Divisor de consumo de energia: 2. <br>
	 */
	private static int divisorEnergia = 2;
	/**
	 * Divisor de cantidad de vida: 2. <br>
	 */
	private static int divisorVida = 2;

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
	public Humano(String nombre, Casta casta, int id) {
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
	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * Realiza la primer habilidad de raza del humano, incentivar. <br>
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > minimoEnergia) {
			this.setEnergia(this.getEnergia() - minimoEnergia);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Realiza la segunda habilidad de raza del humano, golpe fatal. <br>
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > minimoEnergia) {
			if (atacado.serAtacado(atacado.getSalud() / divisorVida) > cero) {
				this.setEnergia(this.getEnergia() / divisorEnergia);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - minimoEnergia);
		return false;
	}
}
