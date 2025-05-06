import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.*;


class ComandoPrendiTest {

	private Comando comandoPrendi;
	private IO io;
	private Partita partita;

	@BeforeEach
	public void setUp() {
		io = new IOConsole();
		partita = new Partita();
		comandoPrendi = new ComandoPrendi(io);
	}


	@Test
	public void testEsegui() {
		comandoPrendi.setParametro("osso");
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
		comandoPrendi.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
	}
}
