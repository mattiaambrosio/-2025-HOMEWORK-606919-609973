package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;


public class Labirinto	{
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
		//creaStanze();
	}

	/*private void creaStanze() {

		
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
	}*/
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}
	
	public class LabirintoBuilder{
		
		private Labirinto labirinto;
		private Stanza ultima;
		private Map<String, Stanza> map;
		
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.map = new HashMap<>();
		}
		
		public Map<String,Stanza> getMap(){
			return map;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
			Stanza s = new Stanza(nomeStanza);
			this.labirinto.setStanzaCorrente(s);

			UltimaAggiunta(s);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nomeVincente) {
			Stanza v = new Stanza(nomeVincente);
			this.labirinto.setStanzaVincente(v);
			UltimaAggiunta(v);

			return this;

		}

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			UltimaAggiunta(s);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
			Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
			if(this.ultima==null) return this;
			this.ultima.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanza, String adiacente, Direzione direzione) {
			Stanza s1 = this.map.get(stanza);
			Stanza a1 = this.map.get(adiacente);
			if(s1!=null) {
				s1.impostaStanzaAdiacente(direzione, a1);
			}
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza m = new StanzaMagica(nome);
			UltimaAggiunta(m);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzo) {
			Stanza b = new StanzaBuia(nome, attrezzo);
			UltimaAggiunta(b);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, Direzione dir, String attrezzo) {
			Stanza bl = new StanzaBloccata(nome, dir, attrezzo);
			UltimaAggiunta(bl);
			return this;
		}

		public LabirintoBuilder addMago(String nome, String pres, Attrezzo attrezzo) {
			Mago mago = new Mago(nome, pres, attrezzo);
			if(this.ultima==null) return this;
			this.ultima.setPersonaggio(mago);
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String pres, Attrezzo attrezzo, String cibo) {
			Cane cane = new Cane(nome, pres, attrezzo, cibo);
			if(this.ultima==null) return this;
			this.ultima.setPersonaggio(cane);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String pres) {
			Strega strega = new Strega(nome, pres);
			if(this.ultima==null) return this;
			this.ultima.setPersonaggio(strega);
			return this;
		}
		

		public void UltimaAggiunta(Stanza stanza) {
			this.ultima = stanza;
			this.map.put(stanza.getNome(),stanza);
		}
	}
	
}
