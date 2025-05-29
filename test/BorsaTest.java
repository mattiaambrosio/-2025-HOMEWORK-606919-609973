import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.ComparatorePerNome;

class BorsaTest {
	
	

	@Test
	void testDueAttrezziPesoUguale() {
		ComparatorePerNome comp = new ComparatorePerNome();
		Set<Attrezzo> elencoAttrezzi = new TreeSet<Attrezzo>(comp);
		Attrezzo spada = new Attrezzo("spada",2);
		Attrezzo montblanc = new Attrezzo("montblanc",2);
		Attrezzo montblanc2 = new Attrezzo("montblanc",2);
		elencoAttrezzi.add(montblanc);
		elencoAttrezzi.add(montblanc2);
		elencoAttrezzi.add(spada);
		
		assertTrue(elencoAttrezzi.size()==2);
		
		
	}

}
