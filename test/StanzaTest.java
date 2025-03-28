import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StanzaTest {

	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzo;

	@BeforeEach
	public void setUp() {
		this.stanza = new Stanza("Atrio");
		this.stanzaAdiacente = new Stanza("N10");
		this.attrezzo = new Attrezzo("lanterna", 3);
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
	}
	@Test
	public void testRemoveAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.removeAttrezzo("lanterna"));
		assertFalse(stanza.hasAttrezzo("lanterna"));
		assertFalse(stanza.removeAttrezzo("osso"));
	}
	@Test
	public void testHasAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("lanterna"));
	}
	

}
