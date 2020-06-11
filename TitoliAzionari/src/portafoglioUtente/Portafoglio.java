package portafoglioUtente;

import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Supplier;

public class Portafoglio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9145728020424948499L;
	
	HashSet<Lotto> portaFoglio = new HashSet<>();

	public Portafoglio() {

	}

	public Portafoglio(List<Lotto> lotti) {
		portaFoglio.addAll(lotti);
	}

	public boolean aggiungiLotto(Lotto daAggiungere) {

		return portaFoglio.add(daAggiungere);

	}

	public double getValoreTotale() {
		double valore = 0;
		for (Lotto lotto : portaFoglio) {
			valore += lotto.getValoreLotto();
		}
		return valore;
	}
	
	
	public Lotto getLottoByName(String name) {

		return this.portaFoglio.stream().filter(lotto -> lotto.getNomeLotto().equalsIgnoreCase(name)).findFirst().orElseThrow(IllegalArgumentException::new);
	}
	 public String toString()
	 {
		 StringBuffer result = new StringBuffer();
			
		  result.append (INTRO_COMPOSIZIONE);

		  for (Iterator iterator = portaFoglio.iterator(); iterator.hasNext();) {
			Lotto lotto = (Lotto) iterator.next();
			result.append(lotto.toString());
			
		}
			
		 
		 return result.toString();
	 }
	 private final static String INTRO_COMPOSIZIONE = "Composizione:\n";
	 
}
