package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	public Labirinto labirinto;
	public Giocatore giocatore;


	public Partita(IOConsole ioconsole) {
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore(ioconsole);
		this.finita = false;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}

	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu()== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


}
