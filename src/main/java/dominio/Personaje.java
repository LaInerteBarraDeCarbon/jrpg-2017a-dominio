package dominio;

import java.io.Serializable;

/**
 * La clase Personaje crea personajes con sus respectivas raza y casta. Se
 * encarga de asignar el ataque, la defensa y la magia del personaje, llevar a
 * cabo los métodos para las batallas, como atacar y la experiencia, entre
 * otros. <br>
 * <br>
 * También se encarga de seguir el desarrollo del personaje con respecto a su
 * nivel, aumentando sus atributos a medida que va subiendo de nivel.<br>
 * <br>
 * La clase también lleva el seguimiento de las alianzas realizadas por el
 * personaje, tanto las que crea y realiza como las que deja.<br>
 * <br>
 */
@SuppressWarnings("serial")
public abstract class Personaje extends Peleable implements Serializable {

	/**
	 * Cantidad de habilidades del personaje. <br>
	 */
	protected final static int cantidadHabilidadesPersonaje = 2;
	/**
	 * Capacidad maxima para aumentar habilidades. <br>
	 */
	private final static int maximoSkill = 200;
	/**
	 * Maximo nivel del personaje. <br>
	 */
	private final static int maximoNivel = 100;
	/**
	 * Multiplicador que agrega a la experiencia con respecto al nivel. <br>
	 */
	private final static int multiplicadorExp = 40;
	/**
	 * Puntos de salud a subir de nivel. <br>
	 */
	private final static int aumentarSalud = 25;
	/**
	 * Puntos de energia a subir de nivel. <br>
	 */
	private final static int aumentarEnergia = 20;
	/**
	 * Cantidad de experiencia adicional para subir de nivel. <br>
	 */
	private final static int cantidadEXP = 50;
	/**
	 * Nivel inicial del personaje. <br>
	 */
	private final static int nivelInicial = 1;
	/**
	 * Inteligencia inicial del personaje. <br>
	 */
	private final static int inteligenciaInicial = 10;
	/**
	 * Fuerza inicial del personaje. <br>
	 */
	private final static int fuerzaInicial = 10;
	/**
	 * Destreza inicial del personaje. <br>
	 */
	private final static int destrezaInicial = 10;
	/**
	 * Vida inicial del personaje. <br>
	 */
	private final static int vidaInicial = 100;
	/**
	 * Energia inicial del personaje. <br>
	 */
	private final static int energiaInicial = 100;
	/**
	 * Puntos adicionales a atributo por casta. <br>
	 */
	private final static int incrementoCasta = 5;
	/**
	 * Destreza necesaria para realizar critico. <br>
	 */
	private final static int destrezaCritico = 1000;
	/**
	 * Energia minima para realizar alguna accion. <br>
	 */
	protected final static int minimoEnergia = 10;
	/**
	 * Multiplicador de fuerza para el ataque. <br>
	 */
	private final static double multplicadorFuerza = 1.5;
	/**
	 * Multiplicador de inteligencia para la magia. <br>
	 */
	private final static double multplicadorMagia = 1.5;

	/**
	 * Energía del personaje. <br>
	 */
	protected int energia;
	/**
	 * Defensa del personaje. Depende de la destreza. <br>
	 */
	protected int defensa;

	/**
	 * Magia del personaje. Depende de la inteligencia. <br>
	 */
	protected int magia;

	/**
	 * Nombre del personaje. <br>
	 */
	protected String nombreRaza;

	/**
	 * Máxima vida del personaje. <br>
	 */
	protected int saludTope;
	/**
	 * Energía máxima del personaje. <br>
	 */
	protected int energiaTope;

	/**
	 * Fuerza del personaje. <br>
	 */
	protected int fuerza;
	/**
	 * Destreza del personaje. <br>
	 */
	protected int destreza;
	/**
	 * Inteligencia del personaje. <br>
	 */
	protected int inteligencia;
	/**
	 * Casta del personaje. <br>
	 */
	protected Casta casta;

	/**
	 * Posicion X del personaje. <br>
	 */
	protected int x;
	/**
	 * Posicion Y del personaje. <br>
	 */
	protected int y;

	/**
	 * Experiencia del personaje. <br>
	 */
	protected int experiencia;
	/**
	 * Nivel del personaje. <br>
	 */
	protected int nivel;

	/**
	 * ID del personaje. <br>
	 */
	protected int idPersonaje;

	/**
	 * Alianza del personaje. <br>
	 */
	protected Alianza clan = null;
	/**
	 * Tabla de nivel del personaje. <br>
	 */
	public static int tablaDeNiveles[];

	/**
	 * Habilidades de la raza. <br>
	 */
	protected String[] habilidadesRaza;

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
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = cero;
		Personaje.tablaDeNiveles[1] = cero;
		for (int i = 2; i < 101; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + cantidadEXP;
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
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		super.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = cero;
		nivel = nivelInicial;
		fuerza = fuerzaInicial;
		inteligencia = inteligenciaInicial;
		destreza = destrezaInicial;
		if (casta instanceof Guerrero) {
			fuerza += incrementoCasta;
		}
		if (casta instanceof Hechicero) {
			inteligencia += incrementoCasta;
		}
		if (casta instanceof Asesino) {
			destreza += incrementoCasta;
		}

		x = cero;
		y = cero;
		saludTope = vidaInicial;
		energiaTope = energiaInicial;

		ataque = this.calcularPuntosDeAtaque();
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

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
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
	 * Establece el nombre del personaje. <br>
	 * 
	 * @param nombre
	 *            Nombre del personaje. <br>
	 */
	public void setNombre(final String nombre) {
		super.nombre = nombre;
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
	 * Establece el clan al que pertence el personaje. <br>
	 * 
	 * @param clan
	 *            Alianza del personaje. <br>
	 */
	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.aniadirPersonaje(this);
	}

	/**
	 * Estableve la salud del personaje. <br>
	 * 
	 * @param salud
	 *            Salud del personaje. <br>
	 */
	public void setSalud(final int salud) {
		this.salud = salud;
	}

	/**
	 * Devuelve la energía del personaje. <br>
	 * 
	 * @return Energia del personaje. <br>
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Establece la energía del personaje. <br>
	 * 
	 * @param energia
	 *            Energia del personaje. <br>
	 */
	public void setEnergia(final int energia) {
		this.energia = energia;
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
	 * Establece la fuerza del personaje. <br>
	 * 
	 * @param fuerza
	 *            Fuerza del personaje. <br>
	 */
	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
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
	 * Establece la destreza del personaje. <br>
	 * 
	 * @param destreza
	 *            Destreza del personaje. <br>
	 */
	public void setDestreza(final int destreza) {
		this.destreza = destreza;
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
	 * Establece la inteligencia del personaje. <br>
	 * 
	 * @param inteligencia
	 *            Inteligencia del personaje. <br>
	 */
	public void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
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
	 * Establece la casta del personaje. <br>
	 * 
	 * @param casta
	 *            Casta del personaje. <br>
	 */
	public void setCasta(final Casta casta) {
		this.casta = casta;
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
	 * Establece la experiencia del personaje. <br>
	 * 
	 * @param experiencia
	 *            Experiencia del personaje. <br>
	 */
	public void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
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
	 * Establece el nivel del personaje. <br>
	 * 
	 * @param nivel
	 *            Nivel del personaje. <br>
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
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
	 * Establece el ID del personaje. <br>
	 * 
	 * @param idPersonaje
	 *            ID del personaje. <br>
	 */
	public void setIdPersonaje(final int idPersonaje) {
		this.idPersonaje = idPersonaje;
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
	 * Establece la defensa del personaje. <br>
	 * 
	 * @param defensa
	 *            Defensa del personaje. <br>
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Devuelve la vida máxima del personaje. <br>
	 * 
	 * @return Vida máxima del personaje. <br>
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Establece la vida máxima del personaje. <br>
	 * 
	 * @param saludTope
	 *            Maxima salud del personaje. <br>
	 */
	public void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}

	/**
	 * Devuelve la energía máxima del personaje. <br>
	 * 
	 * @return Energía máxima del personaje. <br>
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Establece la energía máxima del personaje. <br>
	 * 
	 * @param energiaTope
	 *            Maxima energia del personaje. <br>
	 */
	public void setEnergiaTope(final int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * Ataca a otro personaje. <br>
	 * 
	 * @param atacado
	 *            Personaje atacado. <br>
	 * @return Danio realizado. <br>
	 */
	public int atacar(final Peleable atacado) {
		if (!this.estaVivo()) {
			return cero;
		}
		if (atacado.getSalud() > cero) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / destrezaCritico) {
				return atacado.serAtacado(this.golpeCritico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return cero;
	}

	/**
	 * Calcula el danio de un golpe crítico. <br>
	 * 
	 * @return Danio del golpe crítico. <br>
	 */
	public int golpeCritico() {
		return (int) (this.ataque * this.getCasta().getDanioCritico());
	}

	/**
	 * Indica si posee la energía para atacar a otro personaje. <br>
	 * 
	 * @return true si tiene energía, false si no tiene la energía suficiente.
	 *         <br>
	 */
	public boolean puedeAtacar() {
		return energia > minimoEnergia;
	}

	/**
	 * Calcula los puntos de ataque del personaje. <br>
	 * 
	 * @return Puntos de ataque. <br>
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * multplicadorFuerza);
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
		return (int) (this.getInteligencia() * multplicadorMagia);
	}

	/**
	 * Devuelve los puntos de salud a punto máximo. <br>
	 */
	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	/**
	 * Devuelve los puntos de energía a su punto máximo. <br>
	 */
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * Modifica los atributos del personaje. <br>
	 */
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Indica el danio recibido. <br>
	 * 
	 * @param danio
	 *            Danio recibido. <br>
	 * @return Danio recibido. <br>
	 */
	public int serAtacado(int danio) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDanio()) {
			danio -= this.defensa;
			if (danio > cero) {
				if (salud <= danio) {
					danio = salud;
					salud = cero;
				} else {
					salud -= danio;
				}
				return danio;
			}
			return cero;
		}
		return cero;
	}

	/**
	 * Indica el danio realizado al personaje. De ser mayor el ataque a la vida,
	 * lo mata. <br>
	 * 
	 * @param danio
	 *            Danio recibido. <br>
	 * @return Danio realizado. <br>
	 */
	public int serRobadoSalud(int danio) {
		danio -= this.defensa;
		if (danio <= cero) {
			return cero;
		}
		if ((salud - danio) >= cero) {
			salud -= danio;
		} else {
			danio = salud;// le queda menos salud que el danio inflingido
			salud = cero;
		}
		return danio;
	}

	/**
	 * Realiza quita de energía al personaje. <br>
	 * 
	 * @param danio
	 *            Danio recibido. <br>
	 * @return Danio realizado. <br>
	 */
	public int serDesernegizado(int danio) {
		danio -= this.defensa;
		if (danio <= cero) {
			return cero;
		}
		if ((energia - danio) >= cero) {
			energia -= danio;
		} else {
			danio = energia;// le queda menos energia que el danio inflingido
			energia = cero;
		}
		return danio;
	}

	/**
	 * Realiza curación al personaje. <br>
	 * 
	 * @param salud
	 *            Salud a recuperar. <br>
	 */
	public void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope;
		}
	}

	/**
	 * Devuelve energía al personaje. <br>
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
		this.clan.aniadirPersonaje(this);
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
			a.aniadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.aniadirPersonaje(nuevoAliado);
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
		if (this.fuerza + fuerza <= maximoSkill) {
			this.fuerza += fuerza;
		}
		if (this.destreza + destreza <= maximoSkill) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= maximoSkill) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	/**
	 * Aumenta el nivel del personaje y actualiza sus atributos. <br>
	 */
	public void subirNivel() {
		int acumuladorExperiencia = cero;
		if (this.nivel == maximoNivel) {
			return;
		}
		while (this.nivel != maximoNivel
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += aumentarSalud;
			this.energiaTope += aumentarEnergia;
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
		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
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
		return this.nivel * multiplicadorExp;
	}

	/**
	 * Clona un personaje. <br>
	 * 
	 * @return Personaje. <br>
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
}
