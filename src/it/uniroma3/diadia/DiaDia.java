package it.uniroma3.diadia;
import it.uniroma3.diadia.IOConsole;

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
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "borsa", "guarda"};

	private Partita partita;
	private IO ioconsole;


	public DiaDia(IO ioconsole) {
		this.ioconsole = ioconsole;
		this.partita = new Partita();

	}

	public void gioca() {
		String istruzione; 

		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = this.ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	private boolean processaIstruzione(String istruzione) {
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

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();

	}

	public Partita getPartita() {
		return this.partita;
	}
}