package it.uniroma3.diadia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			/*"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";*/
			"Ti trovi ad Angri, vicino Napoli, ma oggi è diversa dal solito...\n"
			+ "Meglio andare al piu' presto in cima al Vesuvio per guardare meglio cosa succede nella città.\n"
			+ "Ma come ci si arriva?\n"
			+ "I vicoli napoletani sono popolati da alcuni strani personaggi, alcuni scugnizzi, altri...chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti per l'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili,\n"
			+ "regalarli se pensi che possano tirarti fuori dai guai e puoi addirittura mangiarli se hai fame.\n"
			+ "Per conoscere le istruzioni scrivi 'aiuto', Buon viaggio fratm\n";
			
			


	private Partita partita;
	private IO ioconsole;


	public DiaDia(IO ioconsole,Labirinto lab) {
		this.ioconsole = ioconsole;
		this.partita = new Partita(lab);
		

	}

	public void gioca() throws Exception {
		String istruzione; 

		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = this.ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(ioconsole);
				comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			ioconsole.mostraMessaggio("Hai vinto!");
		if (this.partita.getGiocatore().getCfu()==0)
			ioconsole.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	private void fine() {
		this.ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) throws Exception {
		IO io = new IOConsole();
		Labirinto napule = new LabirintoBuilder()
				.addStanzaIniziale("Angri")
				.addAttrezzo("stelle-filanti",4)
				.addStanzaVincente("Vesuvio")
				.addStanza("Stadio")
				.addAttrezzo("amore",3)
				.addAttrezzo("pallone",5)
				.addStanzaMagica("Murales Maradona")
				.addAttrezzo("souvenir",2)
				.addStanzaBloccata("Scampia", "est", "pizza-portafoglio")
				.addAttrezzo("pastiera",4)// dove? fa riferimento all�ultima stanza aggiunta: la �camera�
				.addStanzaBuia("Napoli Sotteranea", "amore")
				.addAttrezzo("pizza-portafoglio",6)
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
		DiaDia gioco = new DiaDia(io, napule);
		gioco.gioca();

	}

	public Partita getPartita() {
		return this.partita;
	}
}