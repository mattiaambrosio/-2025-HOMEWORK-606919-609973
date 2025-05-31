package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private Attrezzo attrezzo;
	private String nome;
	
	public Cane(String nome, String presentazione, Attrezzo attrezzo, Attrezzo cibo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	public String riceviRegalo(Attrezzo att) {
		if(this.attrezzo==att) {
			
		}
	}
	
	
	
}
