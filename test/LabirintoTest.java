import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {

	Stanza vesuvio;
	Stanza casa;
	Partita partita;

	@BeforeEach
	public void setUp() throws Exception {
		Labirinto nap = Labirinto.newBuilder("napoliLab.txt").getLabirinto();
		partita = new Partita(nap);
		vesuvio = new Stanza("Vesuvio");
		casa = new Stanza("Casa");

	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Vesuvio", partita.getLabirinto().getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(casa);
		assertEquals(casa, partita.getLabirinto().getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Angri", partita.getLabirinto().getStanzaCorrente().getNome());
	}

}
