package titolo;

import util.mylib.EstrazioniCasuali;

public abstract class Oscilla {

	public static double oscilla(double valoreSingolaAzione) {
		return valoreSingolaAzione
				+ (valoreSingolaAzione * EstrazioniCasuali.estraiDouble(ITitolo.MIN_RIBASSO, ITitolo.MAX_RIALZO));
	}
}
