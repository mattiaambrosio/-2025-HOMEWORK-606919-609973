package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoBorsa extends AbstractComando{
	private IO ioconsole;
	
	public ComandoBorsa(IO io) {
		this.ioconsole = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		this.ioconsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
}
