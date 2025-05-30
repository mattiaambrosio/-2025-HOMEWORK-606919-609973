import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.*;



class ComandoVaiTest {

	private Partita partita;
	private Comando comandoVai;
	private IO io;
	private Labirinto labirinto;

	
	@BeforeEach
	public void setUp() {
		io = new IOConsole();
		comandoVai = new ComandoVai(io);
		Labirinto bilocale = new LabirintoBuilder()
			.addStanzaIniziale("camera")
			.addStanzaVincente("vesuvio")
			.addAttrezzo("bibbia",10)// dove? fa riferimento all’ultima stanza aggiunta: la “camera”
			.addAdiacenza("camera","vesuvio" ,"sud") // camera si trova a nord di salotto
			.getLabirinto(); // restituisce il Labirinto così specificato
		partita = new Partita(bilocale);
	}

	@Test
	public void testEsegui() {
		comandoVai.setParametro("sud");
		Stanza stanzaSud = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("sud");
		comandoVai.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente() == stanzaSud);
		
	}
}
