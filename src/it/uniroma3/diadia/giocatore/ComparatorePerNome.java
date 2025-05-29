package it.uniroma3.diadia.giocatore;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatorePerNome implements Comparator<Attrezzo>{
	public int compare(Attrezzo a1, Attrezzo a2) {
		if(a1.getPeso()==a2.getPeso()) {
			return a1.getNome().compareTo(a2.getNome());
		}
		return a1.getPeso() - a2.getPeso();
	}
}
