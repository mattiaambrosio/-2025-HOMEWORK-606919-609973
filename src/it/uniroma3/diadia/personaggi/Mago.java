package it.uniroma3.diadia.personaggi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"nella stanza!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo!=null) {
			attrezzo.setPeso(attrezzo.getPeso()/2);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			return "Grazie del regalo fratm, a buon rendere...";
		}
		else return "Non hai quest'attrezzo";
	}
}
