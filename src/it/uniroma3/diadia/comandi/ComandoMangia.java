package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoMangia extends AbstractComando{
	private IO io;
	private String cibo;

	public ComandoMangia(IO io) {
		this.io = io;
	}

	public void esegui(Partita partita) {
		if(cibo==null && !partita.getGiocatore().getBorsa().isEmpty()) {
			io.mostraMessaggio("Va bene mangiare... Ma che cos?\n");
			cibo = this.io.leggiRiga();
		}
		if(cibo==null && partita.getGiocatore().getBorsa().isEmpty()) {
			io.mostraMessaggio("Non hai nulla da mangiare, procuratelo!\n");
			return;
		}
		else {
			if(cibo!=null) {
				if(partita.getGiocatore().getBorsa().hasAttrezzo(cibo)) {
					partita.getGiocatore().getBorsa().removeAttrezzo(cibo);
					io.mostraMessaggio("UANMM!");
				}
				else io.mostraMessaggio("Non ce l'hai, vai a prenderlo!\n");
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.cibo = parametro;
	}


}
