package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Mago;

public class LabirintoBuilder extends Labirinto{

	private Labirinto labirinto;
	private Stanza ultima;
	public Map<String, Stanza> map;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.map = new HashMap<String, Stanza>();

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

	public LabirintoBuilder addAdiacenza(String stanza, String adiacente, String direzione) {
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

	public LabirintoBuilder addStanzaBloccata(String nome, String dir, String attrezzo) {
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

	public void UltimaAggiunta(Stanza stanza) {
		this.ultima = stanza;
		this.map.put(stanza.getNome(),stanza);
	}
}
