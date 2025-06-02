package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private IO ioconsole;
	
	public ComandoPrendi(IO io) {
		this.ioconsole = io;
	}


	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi() == 0) {
			this.ioconsole.mostraMessaggio("Non ci sono attrezzi in questa stanza!");
			return;
		}
		if(partita.getGiocatore().getBorsa().getPeso() >= 10) {
			this.ioconsole.mostraMessaggio("La borsa pesa troppo!");
			return;
		}
		if(nomeAttrezzo==null) {
			this.ioconsole.mostraMessaggio("Quale attrezzo vuoi prendere?");
			nomeAttrezzo = this.ioconsole.leggiRiga();
		}
		Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			this.ioconsole.mostraMessaggio("Hai preso " +attrezzo.toString()+ "!");
		}
		else this.ioconsole.mostraMessaggio( nomeAttrezzo +" non presente nella stanza!");
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
