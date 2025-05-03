import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "borsa"};
	private IOConsole ioconsole;
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.ioconsole.mostraMessaggio(elencoComandi[i]+" ");
		this.ioconsole.mostraMessaggio("");
	}
	@Override
	public void setParametro(String parametro) {}
}
