import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.FakeComando;

class AbstractComandoTest {

	private FakeComando comando;
	private Partita p;

	@BeforeEach
	void setUp() throws Exception {
		comando = new FakeComando();
		p = new Partita(Labirinto.newBuilder("napoliLab.txt").getLabirinto());
	}

	@Test
	void testSetParametro() {
		comando.setParametro("chiave");
		assertEquals("chiave", comando.getParametro());
	}

	@Test
	void testGetParametroNullSeNonImpostato() {
		assertNull(comando.getParametro());
	}

	@Test
	void testEseguiImpostaFlag() {
		// oppure un mock se serve
		comando.esegui(p);
		assertTrue(comando.isEseguito());
	}

}
