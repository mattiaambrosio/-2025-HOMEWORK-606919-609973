import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;

class IOSimulatorTest {
	IO io;
	DiaDia gioco;
	
	@Test
	void testVittoria() {
		List<String> v = new ArrayList<String>(Arrays.asList("guarda", "vai sud", "prendi chiave", "vai nord", "posa chiave", "guarda", "vai nord"));
		
		io = new IOSimulator(v);
		gioco = new DiaDia(io);
		gioco.gioca();
		
		assertTrue(gioco.getPartita().vinta());
	}
}
