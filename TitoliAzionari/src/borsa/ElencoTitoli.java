package borsa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import titolo.ClassificazioneAziendale;
import titolo.ITitolo;
import titolo.Titolo;

public class ElencoTitoli implements Serializable {


	/**
	 * 
	 */
	private  final long serialVersionUID = 1752405761414486254L;

	private  Set<ITitolo> borsa = new TreeSet<>();

	public  boolean aggiungiTitolo(ITitolo titoloDaAggiungere) {

		return borsa.add(titoloDaAggiungere);
	}

	public  boolean aggiungiTitoli(Collection<ITitolo> titoli) {
		return borsa.addAll(titoli);
	}
	
	
	
	public  void oscillazioneBorsa() {

		for (ITitolo iTitoli : borsa) {

			iTitoli.variazioneGiornaliera();
		}
	}

	public  boolean contieneTitolo(ITitolo titolo) {

		return borsa.contains(titolo);
	}

	public  boolean contieneTitolo(String nomeTitolo) {

		return !borsa.stream().noneMatch(titolo -> titolo.getNome().equalsIgnoreCase(nomeTitolo));
	}

	public  int numTitoli() {
		return borsa.size();
	}
	
	public  ITitolo getTitolo(int index ){
		return (ITitolo) borsa.stream().sorted().toArray()[index];
	}
}
