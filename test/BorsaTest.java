
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {


    private Borsa borsa;
    private Attrezzo spada, libro, lanterna;

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        spada = new Attrezzo("spada", 5);
        libro = new Attrezzo("libro", 3);
        lanterna = new Attrezzo("lanterna", 2);

        borsa.addAttrezzo(spada);
        borsa.addAttrezzo(libro);
        borsa.addAttrezzo(lanterna);
    }

    @Test
    void testGetContenutoOrdinatoPerPeso() {
        List<Attrezzo> ordinati = borsa.getContenutoOrdinatoPerPeso();
        List<Attrezzo> expected = List.of(lanterna, libro, spada);
        assertEquals(expected, ordinati);
    }

    @Test
    void testGetContenutoOrdinatoPerNome() {
        SortedSet<Attrezzo> ordinati = borsa.getContenutoOrdinatoPerNome();
        List<String> nomi = ordinati.stream().map(Attrezzo::getNome).toList();
        assertEquals(List.of("lanterna", "libro", "spada"), nomi);
    }

    @Test
    void testGetContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> raggruppati = borsa.getContenutoRaggruppatoPerPeso();

        assertEquals(3, raggruppati.size());

        assertTrue(raggruppati.containsKey(2));
        assertTrue(raggruppati.containsKey(3));
        assertTrue(raggruppati.containsKey(5));

        assertEquals(Set.of(libro), raggruppati.get(3));
        assertEquals(Set.of(lanterna), raggruppati.get(2));
        assertEquals(Set.of(spada), raggruppati.get(5));
    }

    @Test
    void testGetSortedSetOrdinatoPerPeso() {
        SortedSet<Attrezzo> ordinati = borsa.getSortedSetOrdinatoPerPeso();
        List<Attrezzo> lista = new ArrayList<>(ordinati);

        List<Attrezzo> expected = List.of(lanterna, libro, spada);
        assertEquals(expected, lista);
    }
}
