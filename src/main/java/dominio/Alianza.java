package dominio;

import java.util.LinkedList;

/**
 * La clase Alianza permite realizar vinculos con otros personajes emplea
 * funciones que permiten agregar personajes o quitarlos. <br>
 */
public class Alianza {

	/**
	 * Nombre de la alianza. <br>
	 */
	private String nombre;
	/**
	 * Lista de personajes que integran la alianza. <br>
	 */
	private LinkedList<Personaje> aliados;

	/**
	 * La funcion Alianza se utiliza para determinar lazos con otros personajes.
	 * <br>
	 * 
	 * @param nombre
	 *            Nombre de la alianza. <br>
	 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * Devuelve los aliados almacenados en la lista. <br>
	 * 
	 * @return Lista de los aliados. <br>
	 */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	/**
	 * Esta funcion se encarga de cargar la lista con los aliados obtenidos.
	 * <br>
	 * 
	 * @param aliados
	 *            Lista de aliados. <br>
	 * 
	 */
	public void setAliados(final LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	/**
	 * Esta funcion devuelve el nombre de aliado. <br>
	 * 
	 * @return Nombre de la alianza. <br>
	 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Esta funcion se encarga de quitar personajes de la alianza. <br>
	 * 
	 * @param pj
	 *            Persona a eliminar de la alianza. <br>
	 */
	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * Esta funcion se encarga de agragar un personaje a la alianza. <br>
	 * 
	 * @param pj
	 *            Personaje que integra la alianza. <br>
	 */
	public void aniadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
