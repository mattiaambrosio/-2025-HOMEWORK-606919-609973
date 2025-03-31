import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzo;

	@BeforeEach
	public void setUp() {
		stanza = new Stanza("Atrio");
		stanzaAdiacente = new Stanza("N10");
		attrezzo = new Attrezzo("lanterna", 3);
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Atrio", stanza.getNome());
	}
	@Test
	public void testImpostaStanzaAdiacente() {
		stanza.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(attrezzo));
		assertNotNull(stanza.getAttrezzo("lanterna"));
		assertNull(stanza.getAttrezzo("osso"));
	}
	@Test
	public void testHasAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("lanterna"));
		assertFalse(stanza.hasAttrezzo("piccione"));
		assertNotNull(stanza.hasAttrezzo("piccione"));
	}
	@Test
	public void testRemoveAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.removeAttrezzo("lanterna"));
		assertFalse(stanza.removeAttrezzo("osso"));
		assertFalse(stanza.removeAttrezzo("chiodo"));
		
	}
}
