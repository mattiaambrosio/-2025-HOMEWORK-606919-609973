package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private IO ioconsole;
	
	public ComandoFine(IO io) {
		this.ioconsole = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	@Override
	public void setParametro(String parametro) {}
}
