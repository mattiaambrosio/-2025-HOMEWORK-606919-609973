package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String nomeDir;
	private String nomeAtt;

	public StanzaBloccata(String nome, String nomeDir, String nomeAtt) {
		super(nome);
		this.nomeDir = nomeDir;
		this.nomeAtt = nomeAtt;
	}
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite: ");
		for (String direzione : super.getDirezioni()) {
			if (direzione!=null)
				risultato.append(" " + direzione);
			if(direzione.equals(nomeDir) && !hasAttrezzo(nomeAtt)) {
				risultato.append("(bloccata)");
			}
		}
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo!=null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!hasAttrezzo(nomeAtt) && direzione.equals(nomeDir)) {
			return this;
		}

		return super.getStanzaAdiacente(direzione);


	}
}
