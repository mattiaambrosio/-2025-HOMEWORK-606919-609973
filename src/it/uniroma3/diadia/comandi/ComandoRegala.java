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
	private Attrezzo att;
	
	public ComandoRegala(IO io) {
		this.io = io;
	}


	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null && attrezzo!=null) {
			this.messaggio = personaggio.riceviRegalo(att, partita);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			io.mostraMessaggio(this.messaggio);
		} 
		else if(personaggio!=null && !(this.getParametro().equals(attrezzo.getNome()))){
			io.mostraMessaggio(MESSAGGIO_NON_ATTREZZO);
		}
		else io.mostraMessaggio(MESSAGGIO_A_CHI);

}

public String getMessaggio() {
	return this.messaggio;
}

}
