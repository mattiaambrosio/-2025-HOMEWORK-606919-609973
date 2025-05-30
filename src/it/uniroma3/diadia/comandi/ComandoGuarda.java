package it.uniroma3.diadia.comandi;
import java.util.Arrays;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{
	private IO ioconsole;
	
	public ComandoGuarda(IO io) {
		this.ioconsole = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		this.ioconsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.ioconsole.mostraMessaggio("Possiedi: "+ partita.getGiocatore().getCfu() +" cfu");
	}

}