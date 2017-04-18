package dominio;

public interface Peleable {
	public int serAtacado(int da�o);
	public int getSalud();
	public void despuesDeTurno();
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
