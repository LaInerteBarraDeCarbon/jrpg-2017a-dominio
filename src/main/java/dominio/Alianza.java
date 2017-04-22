package dominio;

import java.util.LinkedList;

/**
 * La clase Alianza permite realizar vinculos con otros personajes emplea
 * funciones que permiten agregar personajes o quitarlos. <br>
 */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;
<<<<<<< Updated upstream

	/**
	 * La funcion Alianza se utiliza para determinar lazos con otros personajes.
	 * <br>
	 */
=======
<<<<<<< HEAD
/** La funcion Alianza se utiliza para determinar lazos con otros personajes*/
=======

>>>>>>> parent of 23c6f48... Merge remote-tracking branch 'origin/PersonajePeleable'
>>>>>>> Stashed changes
	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}
<<<<<<< Updated upstream

	/**
	 * Devuelve los aliados almacenados en la lista. <br>
	 */
=======
<<<<<<< HEAD
/** Devuelve los aliados almacenados en la lista*/
>>>>>>> Stashed changes
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
	 * Esta funcion devuelve el nombre de aliado
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
<<<<<<< Updated upstream

	/**
	 * Esta funcion se encarga de agragar un personaje a la alianza. <br>
	 * 
	 * @param pj
	 */
=======
/** Esta funcion se encarga de agragar un personaje
 * 
 * @param pj
 * retorna si añado
 */
=======

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void eliminarPersonaje(Personaje pj) {
		aliados.remove(pj);
	}

>>>>>>> parent of 23c6f48... Merge remote-tracking branch 'origin/PersonajePeleable'
>>>>>>> Stashed changes
	public void añadirPersonaje(Personaje pj) {
		aliados.add(pj);
	}
}
