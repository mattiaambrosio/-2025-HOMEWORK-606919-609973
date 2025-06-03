package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class FakeComando extends AbstractComando{

	boolean eseguito = false;
	
	@Override
	public void esegui(Partita partita) {
		eseguito = true;
	}

	public boolean isEseguito() {
		return eseguito;
	}
}
