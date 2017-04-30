package dominio;

import java.util.LinkedList;

/**
 * La clase Alianza permite realizar vinculos con otros personajes emplea
 * funciones que permiten agregar personajes o quitarlos. <br>
 */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	/**
	 * La funcion Alianza se utiliza para determinar lazos con otros personajes.
	 * <br>
	 */
	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * Devuelve los aliados almacenados en la lista. <br>
	 */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	/**
	 * Esta funcion se encarga de cargar la lista con los aliados obtenidos.
	 * <br>
	 * 
	 * @param aliados
	 * 
	 */
	public void setAliados(LinkedList<Personaje> aliados) {
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
	 */
	public void eliminarPersonaje(Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * Esta funcion se encarga de agragar un personaje a la alianza. <br>
	 * 
	 * @param pj
	 */
	public void aniadirPersonaje(Personaje pj) {
		aliados.add(pj);
	}
}
