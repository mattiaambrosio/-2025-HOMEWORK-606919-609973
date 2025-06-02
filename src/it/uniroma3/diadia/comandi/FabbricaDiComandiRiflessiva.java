package it.uniroma3.diadia.comandi;

import java.lang.reflect.Constructor;
import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva {
	
	private IO io;
	
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}
	
	
	public Comando costruisciComando(String istruzione) throws Exception {
		/*Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		StringBuilder nomeClasse
		= new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
		nomeClasse.append( nomeComando.substring(1) ) ;
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
		comando = (Comando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance(this.io);
		// POSSIBILE ALTERNATIVA basata sul rendere il tipo Class<Comando> esplicito:
		// comando = ((Class<Comando>)Class.forName(nomeClasse.toString())).newInstance();
		comando.setParametro(parametro);
		return comando;*/
		Scanner scannerDiParole = new Scanner(istruzione);
	    String nomeComando = null;
	    String parametro = null;
	    Comando comando = null;

	    if (scannerDiParole.hasNext())
	        nomeComando = scannerDiParole.next();
	    if (scannerDiParole.hasNext())
	        parametro = scannerDiParole.next();

	    StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
	    nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
	    nomeClasse.append(nomeComando.substring(1));

	    Class<?> classeComando = Class.forName(nomeClasse.toString());
	    Constructor<?> costruttore = classeComando.getDeclaredConstructor(IO.class);
	    comando = (Comando) costruttore.newInstance(this.io);

	    comando.setParametro(parametro);
	    return comando;
	}
}
