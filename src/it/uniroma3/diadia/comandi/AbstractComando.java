package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{
	
	private String parametro;
	
	abstract public void esegui(Partita partita);
	
	@Override
	public void setParametro(String parametro) {
		this.parametro  = parametro;
	}
	
	public String getParametro() {
		return this.parametro;
	}

}
