package it.uniroma3.diadia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "borsa"};

	private Partita partita;
	private IOConsole ioconsole;


	public DiaDia(IOConsole ioconsole) {
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


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("borsa"))
			ioconsole.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		else
			this.ioconsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.ioconsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		this.ioconsole.mostraMessaggio("");
	}
	private void prendi(String nomeAttrezzo) {
		if(this.partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi() == 0) {
			this.ioconsole.mostraMessaggio("Non ci sono attrezzi in questa stanza!");
			return;
		}
		if(this.partita.getGiocatore().getBorsa().getPeso() >= 10) {
			this.ioconsole.mostraMessaggio("La borsa pesa troppo!");
			return;
		}
		if(nomeAttrezzo==null) {
			this.ioconsole.mostraMessaggio("Quale attrezzo vuoi prendere?");
			nomeAttrezzo = this.ioconsole.leggiRiga();
		}
		Attrezzo attrezzo = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			this.ioconsole.mostraMessaggio("Attrezzo preso!");
		}
		else this.ioconsole.mostraMessaggio("Attrezzo non presente nella stanza!");


	}
	private void posa(String nomeAttrezzo) {
		if(this.partita.getGiocatore().getBorsa().getNumeroAttrezzi() == 0) {
			this.ioconsole.mostraMessaggio("Non hai attrezzi in borsa!");
			return;
		}
		if (this.partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi() >= 10){
			this.ioconsole.mostraMessaggio("Non c'è spazio nella stanza!");
			return;
		}
		if(nomeAttrezzo==null) {
			this.ioconsole.mostraMessaggio("Quale attrezzo vuoi posare?");
			nomeAttrezzo = this.ioconsole.leggiRiga();
		}
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			this.ioconsole.mostraMessaggio("Hai posato " +attrezzo.toString()+ " nella stanza!");
		}
		else this.ioconsole.mostraMessaggio("Non hai questo attrezzo in borsa!");

	}
	private void vai(String direzione) {
		if(direzione==null) {
			this.ioconsole.mostraMessaggio("Dove vuoi andare?");
			direzione = this.ioconsole.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.ioconsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}


	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole ioconsole = new IOConsole();
		DiaDia gioco = new DiaDia(ioconsole);
		gioco.gioca();

	}
}