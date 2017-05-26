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
	public void añadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}

	/**
	 * Devuelve una lista con los personajes de la alianza. <br>
	 * 
	 * @return Lista de la alianza. <br>
	 */
	public final LinkedList<Personaje> getAliados() {
		return Alianza.copiaListaPersonaje(aliados);
	}

	/**
	 * Genera una copia de la lista de la alianza de los personajes. <br>
	 * 
	 * @param lista
	 *            Alianza. <br>
	 * @return Copia de la lista. <br>
	 */
	private static LinkedList<Personaje> copiaListaPersonaje(LinkedList<Personaje> lista) {
		LinkedList<Personaje> listaRetorno = new LinkedList<>();
		for (int i = 0; i < lista.size(); i++)
			listaRetorno.add(lista.get(i));
		return listaRetorno;
	}
}
