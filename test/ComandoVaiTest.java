import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.*;



class ComandoVaiTest {

	private Partita partita;
	private Comando comandoVai;
	private IO io;
	
	@BeforeEach
	public void setUp() {
		io = new IOConsole();
		partita = new Partita();
		comandoVai = new ComandoVai(io);
	}
	
	@Test
	public void testEsegui() {
		comandoVai.setParametro("sud");
		Stanza stanzaSud = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("sud");
		comandoVai.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente() == stanzaSud);
	}
}
