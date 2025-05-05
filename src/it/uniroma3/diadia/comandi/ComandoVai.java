package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoVai implements Comando{
	private String direzione;
	private IO ioconsole;

	public ComandoVai(IO io) {
		this.ioconsole = io;
	}

	@Override
	public void esegui(Partita partita) {
		if(direzione==null) {
			this.ioconsole.mostraMessaggio("Dove vuoi andare?");
			direzione = this.ioconsole.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu-1);
		}
		this.ioconsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
}
