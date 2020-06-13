package portafoglioUtente;

import java.io.Serializable;
import java.util.Objects;

import titolo.ITitolo;

public class Lotto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITitolo azione;

	private int quantita;

	private final int quantitaMassimaAcquistabile;

	public Lotto(ITitolo azione, int quantita) {

		quantitaMassimaAcquistabile = azione.getTotaleAzioni();

		setAzione(azione);

		setQuantita(quantita);

	}

	/**
	 * @return the azione
	 */
	public ITitolo getAzione() {
		return this.azione;
	}

	/**
	 * @param azione
	 *            the azione to set
	 */
	private void setAzione(ITitolo azione) throws NullPointerException {

		Objects.requireNonNull(azione, "Il titolo di un'azione non puo' essere Null");

		this.azione = azione;

	}

	public String toString() {
		return String.format("Il lotto di azioni \" %s\"%nValore totale %1.3f%nValore singola Azione %1.3f%nTolale azioni possedute per questo lotto %d/%d", getNomeLotto(),
				getValoreLotto(), getValoreSingolaAzione(),getQuantita(),azione.getTotaleAzioni());
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

		if (quantita > this.quantitaMassimaAcquistabile)

			throw new IllegalArgumentException(
					"NON PUOI ACQUISTARE PIU' di " + this.quantitaMassimaAcquistabile + " azioni");

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

			this.quantita = 0;

		}
		return true;
	}

	public double getValoreLotto() {

		return this.azione.getPrezzoSingolaAzione() * this.quantita;
	}

	public double getValoreSingolaAzione() {

		return this.azione.getPrezzoSingolaAzione();
	}

	public String getNomeLotto() {
		return this.azione.getNome().toUpperCase();
	}

	public int hashCode() {
		return this.azione.hashCode();
	}

	public boolean equals(Object o) {

		if (o instanceof Lotto) {
			Lotto lotto = (Lotto) o;
			return lotto.getAzione().equals(this.azione);
		}
		return false;
	}

}
