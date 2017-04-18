package dominio;

import java.io.Serializable;

public abstract class Casta implements Serializable {
	
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDa�o;
	protected double da�oCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDa�o = 0.2;
		this.da�oCritico = 1.5;
	}

	public Casta(double prob_crit, double evasion, double da�o_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDa�o = evasion;
		this.da�oCritico = da�o_crit;
	}

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	public double getProbabilidadEvitarDa�o() {
		return probabilidadEvitarDa�o;
	}

	public void setProbabilidadEvitarDa�o(double probabilidadEvitarDa�o) {
		this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
	}

	public double getDa�oCritico() {
		return da�oCritico;
	}

	public void setDa�oCritico(double da�oCritico) {
		this.da�oCritico = da�oCritico;
	}
}
