package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;

public class StanzaBuia extends Stanza{
	private String nomeAtt;
	private IO io;
	
	public StanzaBuia(String nome, String nomeAtt) {
		super(nome);
		this.nomeAtt = nomeAtt;
	}
	
	@Override
	public String getDescrizione() {
		String buio = "C'è buio pesto";
		if(hasAttrezzo("lanterna")) {
			return toString();
		}
		else return buio;	
	}
	
}
