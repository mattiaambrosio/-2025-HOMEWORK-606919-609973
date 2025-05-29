import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Stanza ultima;
	public Map<String, Stanza> map;
	

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.map = new HashMap<String, Stanza>();
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
		Stanza s = this.map.get(stanza);
		Stanza a = this.map.get(adiacente);
		s.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	public void UltimaAggiunta(Stanza stanza) {
		this.ultima = stanza;
	}
}
