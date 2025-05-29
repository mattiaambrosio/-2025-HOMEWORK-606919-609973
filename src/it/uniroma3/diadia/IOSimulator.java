package it.uniroma3.diadia;

import java.util.List;

public class IOSimulator implements IO {

	private List<String> comandi;
	int i = 0;

	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_GREEN = "\u001B[32m";

	public IOSimulator(List<String> comandi) {
		this.comandi = comandi;
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio + '\n');


	}

	@Override
	public String leggiRiga() {
		if(i<comandi.size()) {
			this.mostraMessaggio(ANSI_GREEN + comandi.get(i) + ANSI_RESET);
			return this.comandi.get(i++);
		}
		return null;

	}
}
