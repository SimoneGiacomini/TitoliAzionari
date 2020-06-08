package portafoglioUtente;

import java.util.Objects;

import titolo.ITitolo;

public class Lotto {

	private ITitolo azione;

	private int quantita;

	private final int quantitaMassimaAcquistabile = azione.getTotaleAzioni();

	public Lotto(ITitolo azione, int quantita) {

		setAzione(azione);

		setQuantita(quantita);
	}

	/**
	 * @return the azione
	 */
	public ITitolo getAzione() {
		return azione;
	}

	/**
	 * @param azione
	 *            the azione to set
	 */
	private void setAzione(ITitolo azione) throws NullPointerException {

		Objects.requireNonNull(azione, "Il titolo di un'azione non puo' essere Null");

		this.azione = azione;

	}

	/**
	 * @return the quantita
	 */
	public int getQuantita() {
		return quantita;
	}

	/**
	 * @param quantita
	 *            the quantita to set
	 */
	private void setQuantita(int quantita) {

		if (quantita > quantitaMassimaAcquistabile)

			throw new IllegalArgumentException(
					"NON PUOI ACQUISTARE PIU' di " + quantitaMassimaAcquistabile + " azioni");

		else if (quantita < 1)

			throw new IllegalArgumentException("NON PUOI ACQUISTARE meno di 1 azione");

		this.quantita = quantita;
	}

	public boolean acquistaPiuQuote(int nuoveQuote) {

		try {

			setQuantita(getQuantita() + nuoveQuote);

			return true;

		} catch (IllegalArgumentException e) {

			// setQuantita(quantitaMassimaAcquistabile);

			return false;
		}
	}

	public boolean vendiPiuQuote(int numeroQuoteDaVendere) {

		try {

			setQuantita(getQuantita() - numeroQuoteDaVendere);

			// return true;

		} catch (IllegalArgumentException e) {

			quantita = 0;
			
		}
		return true;
	}

}
