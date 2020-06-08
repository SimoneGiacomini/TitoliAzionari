package titolo;

import java.util.Objects;

public class Titolo implements ITitoli {

	private String nome;
	private double valore;
	private ClassificazioneAziendale totaleAzioni;

	public Titolo(String nome, double valore, ClassificazioneAziendale totaleAzioni) {
		this.nome = nome;
		this.valore = valore;
		this.totaleAzioni = totaleAzioni;
	}

	public Titolo(String nome, double valore) {
		this(nome, valore, ClassificazioneAziendale.MEDIA);
	}

	/**
	 * @throws NullPointerException
	 *             -se totaleAzioni non corrisponde a Nessuna classificazione
	 *             Aziendale
	 */
	public Titolo(String nome, double valore, int totaleAzioni) throws NullPointerException {
		this.nome = nome;
		this.valore = valore;
		this.totaleAzioni = checkIntTotaleAzienda(totaleAzioni);
	}

	/**
	 * @throws NullPointerException
	 *             -se totaleAzioni non corrisponde a Nessuna classificazione
	 *             Aziendale
	 */
	public static ClassificazioneAziendale checkIntTotaleAzienda(int totaleAzioni) throws NullPointerException {

		ClassificazioneAziendale gr = ClassificazioneAziendale.valoreDi(totaleAzioni);

		Objects.requireNonNull(gr,
				"LE AZIONI TOTALI DI QUESTA AZIENDA NON CORRISPONDONO A NESSUNA CLASSIFICAZIONE aziendale");

		return gr;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public double getValore() {
		return valore;
	}

	@Override
	public int getTotaleAzioni() {
		return totaleAzioni.getNumeroAzioni();
	}

	@Override
	public void oscilla() {
		valore = Oscilla.oscilla(getValore());
	}

}
