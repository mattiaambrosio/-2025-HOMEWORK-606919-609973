package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.IOConsole;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	public Borsa borsa;
	private IOConsole ioconsole;
	
	
	public Giocatore(IOConsole ioconsole) {
		this.cfu = getCfu();
		this.borsa = new Borsa(ioconsole);
		this.ioconsole = ioconsole;
	}

	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	

}
