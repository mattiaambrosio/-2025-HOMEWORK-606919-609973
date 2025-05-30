import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

class IOSimulatorTest {
	IO io;
	DiaDia gioco;
	Labirinto lab;

	@Test
	void testVittoria() throws Exception {
		List<String> v = new ArrayList<String>(Arrays.asList("vai nord", "prendi amore", "vai sud", "vai sud", "posa amore", "guarda", "prendi pizza-portafoglio", "vai nord", "vai est", "posa pizza-portafoglio", "guarda", "vai est"));

		io = new IOSimulator(v);
		lab = new LabirintoBuilder()
			.addStanzaIniziale("Angri")
			.addAttrezzo("stelle-filanti",4)
			.addStanzaVincente("Vesuvio")
			.addStanza("Stadio")
			.addAttrezzo("amore",3)
			.addAttrezzo("pallone",5)
			.addStanzaMagica("Murales Maradona")
			.addAttrezzo("souvenir",2)
			.addStanzaBloccata("Scampia", "est", "pizza-portafoglio")
			.addAttrezzo("pastiera",8)// dove? fa riferimento all�ultima stanza aggiunta: la �camera�
			.addStanzaBuia("Napoli Sotteranea", "amore")
			.addAttrezzo("pizza-portafoglio",10)
			.addAdiacenza("Angri","Napoli Sotteranea","sud")
			.addAdiacenza("Angri","Murales Maradona","ovest")
			.addAdiacenza("Angri","Stadio","nord")
			.addAdiacenza("Angri","Scampia","est")
			.addAdiacenza("Scampia","Vesuvio","est")
			.addAdiacenza("Napoli Sotteranea","Angri","nord")
			.addAdiacenza("Murales Maradona","Angri","est")
			.addAdiacenza("Stadio","Angri","sud")
			.addAdiacenza("Scampia","Angri","ovest")
			.addAdiacenza("Vesuvio","Scampia","ovest")// camera si trova a nord di salotto
			.getLabirinto(); // restituisce il Labirinto cos� specificato
		gioco = new DiaDia(io, lab);
		gioco.gioca();

		assertTrue(gioco.getPartita().vinta());
	}
}
