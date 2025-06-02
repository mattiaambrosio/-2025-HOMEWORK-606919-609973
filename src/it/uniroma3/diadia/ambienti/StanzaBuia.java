package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	private String nomeAtt;
	
	public StanzaBuia(String nome, String nomeAtt) {
		super(nome);
		this.nomeAtt = nomeAtt;
	}
	
	@Override
	public String getDescrizione() {
		String buio = "C'è buio pesto";
		if(hasAttrezzo(this.nomeAtt)) {
			return toString();
		}
		else return buio;	
	}
	
}
