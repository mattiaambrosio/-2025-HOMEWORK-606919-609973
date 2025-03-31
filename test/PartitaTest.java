import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;

public class PartitaTest {
	
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
	}

	@Test
	public void testVinta() {
		partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}
	@Test
	public void testIsFinita() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());  //il giocatore ha terminato i cfu...
		partita.setFinita();
		assertTrue(partita.isFinita()); //quando è finita ritorna True
	}

}
