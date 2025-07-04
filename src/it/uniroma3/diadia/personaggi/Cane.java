package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String MORSO = "Sei stato morso, hai perso 1 cfu!";
	private static final String CIBO = "pastiera";
	private Attrezzo attrezzo;
	
	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MORSO;
	}
	
	public String riceviRegalo(Attrezzo att, Partita partita) {
		if(att.getNome().equals(CIBO)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			return "BAU BAU questo è il mio cibo preferito,\n"
					+ "ti meriti un dono!";
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			return MORSO;
		}
	}
	
	
	
}
