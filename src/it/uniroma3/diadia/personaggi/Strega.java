package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String RISATA = "AHAHAHAHAHAH che spasso!";
	public Strega(String nome, String pres) {
		super(nome, pres);
	}
	
	public String agisci(Partita partita) {
		List<Stanza> adiacenti =  partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		if(this.haSalutato()) {
			Stanza max = adiacenti.get(0);
			for(int i=0; i<adiacenti.size(); i++) {
				if(adiacenti.get(i).getAttrezzi().size() > max.getAttrezzi().size()) {
					max = adiacenti.get(i);
				}
			}
			partita.getLabirinto().setStanzaCorrente(max);
			return "Ti meriti una stanza con PIU' attrezzi!";
		}
		else {
			Stanza min = adiacenti.get(0);
			for(int i=0; i<adiacenti.size(); i++) {
				if(adiacenti.get(i).getAttrezzi().size() < min.getAttrezzi().size()) {
					min = adiacenti.get(i);
				}
			}
			partita.getLabirinto().setStanzaCorrente(min);
			return "Ti meriti una stanza con MENO attrezzi!";
		}
	}
	
	public String riceviRegalo(Attrezzo att, Partita partita) {
		partita.getGiocatore().getBorsa().removeAttrezzo(att.getNome());
		return RISATA;
	}

}
