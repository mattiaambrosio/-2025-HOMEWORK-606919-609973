package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private IOConsole ioconsole;
	

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	public Borsa(IOConsole ioconsole) {
		this(DEFAULT_PESO_MAX_BORSA);
		this.ioconsole = ioconsole;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(this.attrezzi[i]!=null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
			}

		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(this.attrezzi[i]!=null) {
				peso += this.attrezzi[i].getPeso();
			}

		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		int x = this.numeroAttrezzi;
		if(this.numeroAttrezzi==0) {
			this.ioconsole.mostraMessaggio("Non hai attrezzi in borsa...");
			return null;
		}
		else {
			for(int i=0; i<this.numeroAttrezzi; i++) {
				if(this.attrezzi[i]!=null) {
					if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
						for(int j=i; j<this.numeroAttrezzi; j++) {
							this.attrezzi[j] = this.attrezzi[j+1];
							this.numeroAttrezzi--;
						}
					}
				}
			}
		}
		if(numeroAttrezzi==x) {
			this.ioconsole.mostraMessaggio("Non hai questo attrezzo in borsa...");
			return a;
		}
		return a;
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public void vediBorsa() {
		if(!isEmpty()) {
			this.ioconsole.mostraMessaggio("La tua borsa contiene:");
			for(int i=0; i<this.numeroAttrezzi; i++) {
				if(this.attrezzi[i]!=null) {
					this.ioconsole.mostraMessaggio(this.attrezzi[i].toString());
				}
			}
			this.ioconsole.mostraMessaggio("Peso Totale: " +this.getPeso()+"kg/"+this.pesoMax+"kg");
		}
		else
			this.ioconsole.mostraMessaggio("Borsa vuota!");
	}

}
