package dominio;

import java.io.Serializable;
import java.util.HashMap;

/**
 * La clase Personaje crea personajes con sus respectivas raza y casta. Se
 * encarga de asignar el ataque, la defensa y la magia del personaje, llevar a
 * cabo los metodos para las batallas, como atacar y la experiencia, entre
 * otros. <br>
 * <br>
 * Tambien se encarga de seguir el desarrollo del personaje con respecto a su
 * nivel, aumentando sus atributos a medida que va subiendo de nivel.<br>
 * <br>
 * La clase tambien lleva el seguimiento de las alianzas realizadas por el
 * personaje, tanto las que crea y realiza como las que deja.<br>
 * <br>
 */
@SuppressWarnings("serial")
public abstract class Personaje extends Peleable implements Serializable {

	/**
	 * Cantidad de habilidades del personaje. <br>
	 */
	private static final int CANTIDADHABILIDADPERSONAJE = 2;
	/**
	 * Capacidad maxima para aumentar habilidades. <br>
	 */
	private static final int MAXIMOSKILL = 200;
	/**
	 * Maximo nivel del personaje. <br>
	 */
	private static final int MAXIMONIVEL = 100;
	/**
	 * Multiplicador que agrega a la experiencia con respecto al nivel. <br>
	 */
	private static final int MULTIPLICADOREXP = 40;
	/**
	 * Puntos de salud a subir de nivel. <br>
	 */
	private static final int AUMENTARSALUD = 25;
	/**
	 * Puntos de energia a subir de nivel. <br>
	 */
	private static final int AUMENTARENERGIA = 20;
	/**
	 * Cantidad de experiencia adicional para subir de nivel. <br>
	 */
	private static final int CANTIDADEXP = 50;
	/**
	 * Nivel inicial del personaje. <br>
	 */
	private static final int NIVELINICIAL = 1;
	/**
	 * Inteligencia inicial del personaje. <br>
	 */
	private static final int INTELIGENCIAINICIAL = 10;
	/**
	 * Fuerza inicial del personaje. <br>
	 */
	private static final int FUERZAINICIAL = 10;
	/**
	 * Destreza inicial del personaje. <br>
	 */
	private static final int DESTREZAINICIAL = 10;
	/**
	 * Vida inicial del personaje. <br>
	 */
	private static final int VIDAINICIAL = 100;
	/**
	 * Energia inicial del personaje. <br>
	 */
	private static final int ENERGIAINICIAL = 100;
	/**
	 * Destreza necesaria para realizar critico. <br>
	 */
	private static final int DESTREZACRITICO = 1000;
	/**
	 * Energia minima para realizar alguna accion. <br>
	 */
	protected static final int MINIMOENERGIA = 10;
	/**
	 * Multiplicador de fuerza para el ataque. <br>
	 */
	private static final double MULTIPLICADORFUERZA = 1.5;
	/**
	 * Multiplicador de inteligencia para la magia. <br>
	 */
	private static final double MULTIPLICADORMAGIA = 1.5;

	/**
	 * Energia del personaje. <br>
	 */
	private int energia;
	/**
	 * Defensa del personaje. Depende de la destreza. <br>
	 */
	private int defensa;

	/**
	 * Magia del personaje. Depende de la inteligencia. <br>
	 */
	private int magia;

	/**
	 * Nombre del personaje. <br>
	 */
	private String nombreRaza;

	/**
	 * Maxima vida del personaje. <br>
	 */
	private int saludTope;
	/**
	 * Energia maxima del personaje. <br>
	 */
	private int energiaTope;

	/**
	 * Fuerza del personaje. <br>
	 */
	private int fuerza;
	/**
	 * Destreza del personaje. <br>
	 */
	private int destreza;
	/**
	 * Inteligencia del personaje. <br>
	 */
	private int inteligencia;
	/**
	 * Casta del personaje. <br>
	 */
	private Casta casta;

	/**
	 * Posicion X del personaje. <br>
	 */
	private int x;
	/**
	 * Posicion Y del personaje. <br>
	 */
	private int y;

	/**
	 * Experiencia del personaje. <br>
	 */
	private int experiencia;
	/**
	 * Nivel del personaje. <br>
	 */
	private int nivel;

	/**
	 * ID del personaje. <br>
	 */
	private int idPersonaje;

	/**
	 * Alianza del personaje. <br>
	 */
	private Alianza clan = null;
	/**
	 * Tabla de nivel del personaje. <br>
	 */
	public static int[] tablaDeNiveles;

	/**
	 * Habilidades de la raza. <br>
	 */
	protected String[] habilidadesRaza = new String[CANTIDADHABILIDADPERSONAJE];
	/**
	 * Administrador de los randoms. <br>
	 */
	private RandomGenerator random;

	/**
	 * Devuelve las habilidades de la raza que puede usar el personaje. <br>
	 * 
	 * @return Habilidades de la raza. <br>
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * Devuelve las habilidades de la casta que puede usar el personaje. <br>
	 * 
	 * @return Habilidades de la casta. <br>
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * Carga la tabla de nivel del personaje. <br>
	 */
	public static void cargarTablaNivel() {
		Personaje.setTablaDeNiveles(new int[MAXIMONIVEL + 1]);
		Personaje.getTablaDeNiveles()[0] = CERO;
		Personaje.getTablaDeNiveles()[1] = CERO;
		for (int i = 2; i < MAXIMONIVEL + 1; i++) {
			Personaje.getTablaDeNiveles()[i] = Personaje.getTablaDeNiveles()[i - 1] + CANTIDADEXP;
		}
	}

	/**
	 * Crea un personaje dado su nombre y su casta desde el nivel 1. <br>
	 * 
	 * @param nombre
	 *            Nombre del personaje. <br>
	 * @param casta
	 *            Casta del personaje. <br>
	 * @param id
	 *            ID del personaje. <br>
	 * @param vidaRaza
	 *            Vida adicional de la raza. <br>
	 * @param energiaRaza
	 *            Energia adicional de la raza. <br>
	 */
	public Personaje(final String nombre, final Casta casta, final int id, final int vidaRaza, final int energiaRaza) {
		super.setNombre(nombre);
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = CERO;
		nivel = NIVELINICIAL;
		fuerza = FUERZAINICIAL;
		inteligencia = INTELIGENCIAINICIAL;
		destreza = DESTREZAINICIAL;
		fuerza += casta.getIncrementoFuerza();
		inteligencia += casta.getIncrementoInteligencia();
		destreza += casta.getIncrementoDestreza();

		x = CERO;
		y = CERO;
		saludTope = VIDAINICIAL + vidaRaza;
		energiaTope = ENERGIAINICIAL + energiaRaza;

		super.setAtaque(this.calcularPuntosDeAtaque());
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Crea un personaje con sus atributos ya predefinidos. <br>
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
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {

		super.setNombre(nombre);
		super.establecerSalud(salud);
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = super.getSalud();
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		super.setAtaque(this.calcularPuntosDeAtaque());
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Devuelve el nombre de la raza del personaje. <br>
	 * 
	 * @return Nombre de la raza. <br>
	 */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/**
	 * Establece el nombre de la raza. <br>
	 * 
	 * @param nombreRaza
	 *            Nombre de la raza. <br>
	 */
	public void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	/**
	 * Devuelve la magia del personaje. <br>
	 * 
	 * @return Magia del personaje. <br>
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * Establece la magia del personaje. <br>
	 * 
	 * @param magia
	 *            Magia del personaje. <br>
	 */
	public void setMagia(final int magia) {
		this.magia = magia;
	}

	/**
	 * Devuelve el clan al que pertence el personaje. <br>
	 * 
	 * @return Clan. <br>
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * Devuelve la energia del personaje. <br>
	 * 
	 * @return Energia del personaje. <br>
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Devuelve la fuerza del personaje. <br>
	 * 
	 * @return Fuerza del personaje. <br>
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Devuelve la destreza del personaje. <br>
	 * 
	 * @return Destreza del personaje. <br>
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * Devuelve la inteligencia del personaje. <br>
	 * 
	 * @return Inteligencia del personaje. <br>
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Devuelve la casta del personaje. <br>
	 * 
	 * @return Casta del personaje. <br>
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * Devuelve la experiencia del personaje. <br>
	 * 
	 * @return Experiencia del personaje. <br>
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Devuelve el nivel del personaje. <br>
	 * 
	 * @return Nivel del personaje. <br>
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Devuelve el ID del personaje. <br>
	 * 
	 * @return ID del personaje. <br>
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * Devuelve la defensa del personaje. <br>
	 * 
	 * @return Defensa del personaje. <br>
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Devuelve la vida maxima del personaje. <br>
	 * 
	 * @return Vida maxima del personaje. <br>
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Devuelve la energia maxima del personaje. <br>
	 * 
	 * @return Energia maxima del personaje. <br>
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Ataca a otro personaje. <br>
	 * 
	 * @param atacado
	 *            Personaje atacado. <br>
	 * @return daño realizado. <br>
	 */
	public int atacar(final Peleable atacado) {
		if (!this.estaVivo()) {
			return CERO;
		}
		if (atacado.getSalud() > CERO) {
			if (this.getRandom().nextDouble() <= this.casta.getProbabilidadGolpeCritico()
					+ this.destreza / DESTREZACRITICO) {
				return atacado.serAtacado(this.golpeCritico());
			} else {
				return atacado.serAtacado(super.getAtaque());
			}
		}
		return CERO;
	}

	/**
	 * Devuelve un número random. <br>
	 * 
	 * @return Random. <br>
	 */
	public final RandomGenerator getRandom() {
		return random;
	}

	/**
	 * Calcula el daño de un golpe critico. <br>
	 * 
	 * @return daño del golpe critico. <br>
	 */
	public int golpeCritico() {
		return (int) (super.getAtaque() * this.getCasta().getDañoCritico());
	}

	/**
	 * Indica si posee la energia para atacar a otro personaje. <br>
	 * 
	 * @return true si tiene energia, false si no tiene la energia suficiente.
	 *         <br>
	 */
	public boolean puedeAtacar() {
		return energia > MINIMOENERGIA;
	}

	/**
	 * Calcula los puntos de ataque del personaje. <br>
	 * 
	 * @return Puntos de ataque. <br>
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * MULTIPLICADORFUERZA);
	}

	/**
	 * Calcula los puntos de defensa del personaje. <br>
	 * 
	 * @return Puntos de defensa. <br>
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * Calcula los puntos de magia del personaje. <br>
	 * 
	 * @return Puntos de magia. <br>
	 */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * MULTIPLICADORMAGIA);
	}

	/**
	 * Devuelve los puntos de salud a punto maximo. <br>
	 */
	public void restablecerSalud() {
		super.establecerSalud(this.saludTope);
	}

	/**
	 * Devuelve los puntos de energia a su punto máximo. <br>
	 */
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * Modifica los atributos del personaje. <br>
	 */
	public void modificarAtributos() {
		super.setAtaque(this.calcularPuntosDeAtaque());
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Indica el daño recibido. <br>
	 * 
	 * @param daño
	 *            daño recibido. <br>
	 * @return daño recibido. <br>
	 */
	public int serAtacado(int daño) {
		// if (this.getRandom().nextDouble() >=
		// this.getCasta().getProbabilidadEvitarDaño()) {
		daño -= this.defensa;
		if (daño > CERO) {
			if (super.getSalud() <= daño) {
				daño = super.getSalud();
				super.establecerSalud(CERO);
			} else {
				super.establecerSalud(super.getSalud() - daño);
			}
			return daño;
		}
		return CERO;
	}
	// return CERO;
	// }

	/**
	 * Indica el daño realizado al personaje. De ser mayor el ataque a la vida,
	 * lo mata. <br>
	 * 
	 * @param daño
	 *            daño recibido. <br>
	 * @return daño realizado. <br>
	 */
	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= CERO) {
			return CERO;
		}
		if ((super.getSalud() - daño) >= CERO) {
			super.establecerSalud(super.getSalud() - daño);
		} else {
			daño = super.getSalud();
			super.establecerSalud(CERO);
		}
		return daño;
	}

	/**
	 * Realiza quita de energ�a al personaje. <br>
	 * 
	 * @param daño
	 *            daño recibido. <br>
	 * @return daño realizado. <br>
	 */
	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= CERO) {
			return CERO;
		}
		if ((energia - daño) >= CERO) {
			energia -= daño;
		} else {
			daño = energia;
			energia = CERO;
		}
		return daño;
	}

	/**
	 * Realiza curaci�n al personaje. <br>
	 * 
	 * @param salud
	 *            Salud a recuperar. <br>
	 */
	public void serCurado(final int salud) {
		if ((super.getSalud() + salud) <= this.saludTope) {
			super.establecerSalud(super.getSalud() + salud);
		} else {
			super.establecerSalud(this.saludTope);
		}
	}

	/**
	 * Devuelve energia al personaje. <br>
	 * 
	 * @param energia
	 *            Energia a recuperar. <br>
	 */
	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope;
		}
	}

	/**
	 * Crea una alianza para el personaje. <br>
	 * 
	 * @param nombreAlianza
	 *            Nombre de la alianza. <br>
	 */
	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.añadirPersonaje(this);
	}

	/**
	 * Saca el personaje de la alianza. <br>
	 */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * Aniade un personaje a la alianza. De no existir una alianza, la crea.
	 * <br>
	 * 
	 * @param nuevoAliado
	 *            Nuevo miembro de la alianza. <br>
	 * @return true si se lo incluye a la alianza, false de lo contrario. <br>
	 */
	public boolean aliar(final Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Asigna los puntos de skill al personaje. <br>
	 * 
	 * @param fuerza
	 *            Puntos de fuerza. <br>
	 * @param destreza
	 *            Puntos de destreza. <br>
	 * @param inteligencia
	 *            Puntos de inteligencia. <br>
	 */
	public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.fuerza + fuerza <= MAXIMOSKILL) {
			this.fuerza += fuerza;
		}
		if (this.destreza + destreza <= MAXIMOSKILL) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= MAXIMOSKILL) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	/**
	 * Aumenta el nivel del personaje y actualiza sus atributos. <br>
	 */
	public void subirNivel() {
		int acumuladorExperiencia = CERO;
		if (this.nivel == MAXIMONIVEL) {
			return;
		}
		while (this.nivel != MAXIMONIVEL
				&& (this.experiencia >= Personaje.getTablaDeNiveles()[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.getTablaDeNiveles()[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += AUMENTARSALUD;
			this.energiaTope += AUMENTARENERGIA;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/**
	 * Indica si el personaje sube de nivel. <br>
	 * 
	 * @param exp
	 *            Experiencia ganada. <br>
	 * @return true si sube de nivel, false de lo contario. <br>
	 */
	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;
		if (experiencia >= Personaje.getTablaDeNiveles()[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/**
	 * Otorga experiencia al personaje. <br>
	 * 
	 * @return Experiencia. <br>
	 */
	public int otorgarExp() {
		return this.nivel * MULTIPLICADOREXP;
	}

	/**
	 * Clona un personaje. <br>
	 * 
	 * @return Personaje. <br>
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Distancia del personaje con respecto a otro personaje. <br>
	 * 
	 * @param p
	 *            Personaje enemigo. <br>
	 * @return Distancia. <br>
	 */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * Utiliza la primera habilidad de la casta. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true si logra realizarlo, false de lo contrario. <br>
	 */
	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**
	 * Utiliza la segunda habilidad de la casta. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true si logra realizarlo, false de lo contrario. <br>
	 */
	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/**
	 * Utiliza la tercera habilidad de la casta. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true si logra realizarlo, false de lo contrario. <br>
	 */
	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * Utiliza la primera habilidad de la raza del personaje. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidadRaza1(Peleable atacado);

	/**
	 * Utiliza la segunda habilidad de la raza del personaje. <br>
	 * 
	 * @param atacado
	 *            Personaje al que ataca. <br>
	 * @return true de lograrlo, false de lo contrario. <br>
	 */
	public abstract boolean habilidadRaza2(Peleable atacado);

	/**
	 * Devuelve la tabla de niveles. <br>
	 * 
	 * @return Tabla de niveles. <br>
	 */
	public static int[] getTablaDeNiveles() {
		return tablaDeNiveles;
	}

	/**
	 * Modifica los atributos del personaje. <br>
	 * 
	 * @param atributos
	 *            Atributos a modificar. <br>
	 */
	public void modificarAtributos(HashMap<String, Integer> atributos) {
		super.setAtaque(this.calcularPuntosDeAtaque());
		this.aumentarDefensa(this.destreza);
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Establece la tabla de niveles de los personajes. <br>
	 * 
	 * @param tablaDeNiveles
	 *            Tabla de niveles. <br>
	 */
	public static void setTablaDeNiveles(int[] tablaDeNiveles) {
		Personaje.tablaDeNiveles = tablaDeNiveles;
	}

	/**
	 * Quita energía al personaje. <br>
	 * 
	 * @param energia
	 *            Energía. <br>
	 */
	public void quitarEnergia(final int energia) {
		if (this.energia > energia) {
			this.energia -= energia;
		} else {
			this.energia = CERO;
		}
	}

	/**
	 * Establece la energía de un personaje. <br>
	 * 
	 * @param energia
	 *            Energia. <br>
	 */
	public void setEnergia(final int energia) {
		this.energia = energia;
	}

	/**
	 * Reduce la salud del personaje. <br>
	 * 
	 * @param salud
	 *            Vida a quitar. <br>
	 */
	public final void reducirSalud(final int salud) {
		super.establecerSalud(super.getSalud() - salud);
	}

	/**
	 * Actualiza la salud y la energía del personaje en batalla.
	 * 
	 * @param map
	 *            contenedor de los atributos a actualizar.
	 */
	public final void actualizarAtributos(final HashMap<String, Number> map) {
		super.establecerSalud(map.get("salud").intValue());
		energia = map.get("energia").intValue();
		defensa = map.get("defensa").intValue();
		casta.setProbabilidadEvitarDaño(map.get("probEvitarDanio").doubleValue());
	}

	/**
	 * Aumenta la defensa del personaje. <br>
	 * 
	 * @param bonus
	 *            Bonus de defensa. <br>
	 */
	public final void aumentarDefensa(final int bonus) {
		defensa += bonus;
	}

	/**
	 * Establece la defensa del personaje. <br>
	 * 
	 * @param defensa
	 *            Nueva defensa. <br>
	 */
	public void estableceDefensa(final int defensa) {
		this.defensa = defensa;
	}
}
