import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Comando;

public class ComandoVai implements Comando{
	private String direzione;
	private IOConsole ioconsole;
	private Partita partita;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}

	@Override
	public void esegui(Partita partita) {
		if(direzione==null) {
			this.ioconsole.mostraMessaggio("Dove vuoi andare?");
			direzione = this.ioconsole.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.ioconsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
}
