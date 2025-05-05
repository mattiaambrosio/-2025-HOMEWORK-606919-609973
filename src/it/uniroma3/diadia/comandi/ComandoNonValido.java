package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO ioconsole;

	
	public ComandoNonValido(IO io) {
		this.ioconsole = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		this.ioconsole.mostraMessaggio("Comando sconosciuto");
	}
	
	@Override
	public void setParametro(String parametro) {}

}
	
