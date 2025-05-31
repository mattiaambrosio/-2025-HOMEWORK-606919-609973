package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	private IO ioconsole;

	public FabbricaDiComandiFisarmonica(IO io) {
		this.ioconsole = io;
	}

	public Comando costruisciComando(String istruzione) {
		String[] parole = istruzione.split(" ");
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (parole[0] != null)
			nomeComando = parole[0]; // prima parola: nome del comando
		if (parole.length!=1 && parole[1] != null)
			parametro = parole[1]; // seconda parola: eventuale parametro

		if (nomeComando == null)
			comando = new ComandoNonValido(ioconsole);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(ioconsole);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(ioconsole);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(ioconsole);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(ioconsole);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(ioconsole);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(ioconsole);
		else if(nomeComando.equals("borsa"))
			comando = new ComandoBorsa(ioconsole);
		else if (nomeComando.equals("mangia"))
			comando = new ComandoMangia(ioconsole);
		else if(nomeComando.equals("regala"))
			comando = new ComandoRegala(ioconsole);
		else comando = new ComandoNonValido(ioconsole);
		comando.setParametro(parametro);
		return comando;
	}
}

