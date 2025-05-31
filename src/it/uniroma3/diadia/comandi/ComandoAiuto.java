package it.uniroma3.diadia.comandi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	static final private List<String> elencoComandi = new ArrayList<String>(Arrays.asList("vai, aiuto, fine, prendi, posa, borsa, guarda, mangia, regala"));
	private IO ioconsole;
	
	public ComandoAiuto(IO io) {
		this.ioconsole = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.size(); i++) 
			this.ioconsole.mostraMessaggio(elencoComandi.get(i)+" ");
		this.ioconsole.mostraMessaggio(" ");
	}
	
}
