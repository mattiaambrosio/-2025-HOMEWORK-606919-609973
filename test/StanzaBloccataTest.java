import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	public Stanza stanzaBloccata;
	
	@BeforeEach
	public void setUp() {
		stanzaBloccata = new StanzaBloccata("Atrio","nord","chiave");
	
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Atrio",this.stanzaBloccata.getNome());
	}
	public void testAttrezzo() {
		assertEquals("chiave",this.stanzaBloccata.getAttrezzo("chiave"));
	}
	
}
