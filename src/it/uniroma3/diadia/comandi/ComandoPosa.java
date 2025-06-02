package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	String nomeAttrezzo;
	private IO ioconsole;
	
	public ComandoPosa(IO io) {
		this.ioconsole = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().getNumeroAttrezzi() == 0) {
			this.ioconsole.mostraMessaggio("Non hai attrezzi in borsa!");
			return;
		}
		if (partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi() >= 10){
			this.ioconsole.mostraMessaggio("Non c'è spazio nella stanza!");
			return;
		}
		if(nomeAttrezzo==null) {
			this.ioconsole.mostraMessaggio("Quale attrezzo vuoi posare?");
			nomeAttrezzo = this.ioconsole.leggiRiga();
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			this.ioconsole.mostraMessaggio("Hai posato " +attrezzo.toString()+ " nella stanza!");
		}
		else this.ioconsole.mostraMessaggio("Non hai "+ nomeAttrezzo +" in borsa!");
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

}
