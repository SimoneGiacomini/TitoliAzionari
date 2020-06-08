package borsa;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import titolo.ITitolo;

public class ElencoTitoli implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Set<ITitolo> borsa = new TreeSet<>();

	public static boolean aggiungiTitolo(ITitolo titoloDaAggiungere) {
	
		return borsa.add(titoloDaAggiungere);
	}

	public static void oscillazioneBorsa() {

		for (ITitolo iTitoli : borsa) {

			iTitoli.variazioneGiornaliera();
		}
	}

	public static boolean contieneTitolo(ITitolo titolo) {

		return borsa.contains(titolo);
	}

	public static boolean contieneTitolo(String nomeTitolo) {

		for (ITitolo iTitoli : borsa) {

			if (iTitoli.getNome().equalsIgnoreCase(nomeTitolo))
				return true;
		}
		return false;
	}

	public static int numTitoli() {
		return borsa.size();
	}
}
