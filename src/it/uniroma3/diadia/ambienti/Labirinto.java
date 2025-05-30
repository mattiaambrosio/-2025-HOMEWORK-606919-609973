package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Labirinto	{
	public Stanza stanzaCorrente;
	public Stanza stanzaVincente;

	public Labirinto() {
		creaStanze();
	}

	private void creaStanze() {

		
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave", 2);

		
		Stanza atrio = new StanzaBloccata("Atrio", "nord", "chiave");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaMagica("Aula N10");
		Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
		Stanza biblioteca = new Stanza("Biblioteca");

		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		
		aulaN10.addAttrezzo(lanterna);
		aulaN10.addAttrezzo(chiave);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
}
