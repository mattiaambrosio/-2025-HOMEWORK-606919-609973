package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;


	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); // speriamo bastino...
	}
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.attrezzi.size(); i++)
			if(this.attrezzi.get(i)!=null) {
				if (this.attrezzi.get(i).getNome().equals(nomeAttrezzo))
					a = attrezzi.get(i);
			}

		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i=0; i<this.attrezzi.size(); i++)
			if(this.attrezzi.get(i)!=null) {
				peso += this.attrezzi.get(i).getPeso();
			}

		return peso;
	}
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =
				this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.attrezzi.isEmpty()) {
			s.append("Contenuto Borsa: ");
				s.append(getContenutoOrdinatoPerPeso());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


	public int getNumeroAttrezzi() {

		return this.attrezzi.size();	
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePerNome comp = new ComparatorePerNome();
		Collections.sort(this.attrezzi, comp);
		return this.attrezzi;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> a = new TreeSet<Attrezzo>();
		Collections.sort(this.attrezzi);
		a.addAll(this.attrezzi);
		return a;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappaPerPeso = new HashMap<>();

	    for (Attrezzo attrezzo : this.attrezzi) {
	        int peso = attrezzo.getPeso();
	        if (!mappaPerPeso.containsKey(peso)) {
	            mappaPerPeso.put(peso, new HashSet<>());
	        }
	        mappaPerPeso.get(peso).add(attrezzo);
	    }

	    return mappaPerPeso;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePerNome comp = new ComparatorePerNome();
		SortedSet<Attrezzo> b = new TreeSet<Attrezzo>(comp);
		b.addAll(this.attrezzi);
		return b;
	}

}
