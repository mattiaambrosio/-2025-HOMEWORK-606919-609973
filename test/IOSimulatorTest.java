import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;

class IOSimulatorTest {
	IO io;
	DiaDia gioco;
	
	@Test
	void testVittoria() {
		String vittoria[] = {"guarda", "vai sud", "prendi chiave", "vai nord", "posa chiave", "guarda", "vai nord"};
		
		io = new IOSimulator(vittoria);
		gioco = new DiaDia(io);
		gioco.gioca();
		
		assertTrue(gioco.getPartita().vinta());
	}
}
