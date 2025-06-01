package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando{

	private static final String MESSAGGIO_A_CHI =
			"A chi dovresti regalarlo???";
	private static final String MESSAGGIO_NON_ATTREZZO = "Non hai quest'attrezzo!";
	private String messaggio;
	private IO io;
	private String att;

	public ComandoRegala(IO io) {
		this.io = io;
	}


	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		if(this.att==null) {
			io.mostraMessaggio("Cosa vuoi regalare?");
			att = io.leggiRiga();
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.att);
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(this.att)){
				this.messaggio = personaggio.riceviRegalo(attrezzo, partita);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
				io.mostraMessaggio(this.messaggio);
			}
			else {
				io.mostraMessaggio(MESSAGGIO_NON_ATTREZZO);
			}
		}
		else io.mostraMessaggio(MESSAGGIO_A_CHI);
	}

	public String getMessaggio() {
		return this.messaggio;
	}

	@Override
	public void setParametro(String parametro) {
		this.att = parametro;
	}

}
