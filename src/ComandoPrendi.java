import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private Partita partita;
	private IOConsole ioconsole;
	
	@Override
	public void esegui(Partita partita) {
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
			this.ioconsole.mostraMessaggio("Hai preso " +attrezzo.toString()+ "!");
		}
		else this.ioconsole.mostraMessaggio( nomeAttrezzo +" non presente nella stanza!");
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
