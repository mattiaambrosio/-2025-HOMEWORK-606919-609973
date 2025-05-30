import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.*;


class ComandoPrendiTest {

	private Comando comandoPrendi;
	private IO io;
	private Partita partita;

	@BeforeEach
	public void setUp() {
		io = new IOConsole();
		comandoPrendi = new ComandoPrendi(io);
		Labirinto bilocale = new LabirintoBuilder()
			.addStanzaIniziale("camera")
			.addAttrezzo("bibbia",10)// dove? fa riferimento all’ultima stanza aggiunta: la “camera”
			.addStanzaVincente("vesuvio")
			.addAdiacenza("camera","vesuvio" ,"sud") // camera si trova a nord di salotto
			.getLabirinto(); // restituisce il Labirinto così specificato
		partita = new Partita(bilocale);
	}

	@Test
	public void testEsegui() {
		comandoPrendi.setParametro("bibbia");
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("bibbia"));
		comandoPrendi.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("bibbia"));
	}
}
