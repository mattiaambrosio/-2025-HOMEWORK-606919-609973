import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;

class StanzaBuiaTest {

public Stanza stanzaBuia;
	
	@BeforeEach
	public void setUp() {
		stanzaBuia = new StanzaBuia("N11","lanterna");
	
	}
	
	@Test
	public void testGetNome() {
		assertEquals("N11",this.stanzaBuia.getNome());
	}
	public void testAttrezzo() {
		assertEquals("lanterna",this.stanzaBuia.getAttrezzo("lanterna"));
	}
}