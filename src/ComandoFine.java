import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private IOConsole ioconsole;
	
	@Override
	public void esegui(Partita partita) {
		this.ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	@Override
	public void setParametro(String parametro) {}
}
