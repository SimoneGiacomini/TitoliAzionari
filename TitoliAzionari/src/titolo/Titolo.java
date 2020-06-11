package titolo;

import java.io.Serializable;
import java.util.Objects;

public class Titolo implements ITitolo, Serializable, Comparable<ITitolo> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1773189871419516967L;

	private static final String NO_CATEGORIA = "LE AZIONI TOTALI DI QUESTA AZIENDA NON CORRISPONDONO A NESSUNA CLASSIFICAZIONE aziendale";
	
	private String nome;

	private double valore;

	private ClassificazioneAziendale totaleAzioni;

	public Titolo(String nome, double valore, ClassificazioneAziendale totaleAzioni) {
		setNome(nome);

		setValore(valore);

		this.totaleAzioni = totaleAzioni;

	}

	/** <b>Costruttore di DEFAULT</b> */
	public Titolo(String nome, double valore) {

		this(nome, valore, ClassificazioneAziendale.MEDIA);

	}

	/**
	 * @throws NullPointerException
	 *             -se totaleAzioni non corrisponde a Nessuna classificazione
	 *             Aziendale
	 */
	public Titolo(String nome, double valore, int totaleAzioni) throws NullPointerException {

		setNome(nome);

		setValore(valore);

		this.totaleAzioni = checkIntTotaleAzienda(totaleAzioni);
	}

	private void setNome(String nome) {
		nome = nome.trim();

		if (nome == null || nome.length() < 1) {
			throw new IllegalArgumentException("il nome non puo' essere vuoto");
		}

		this.nome = nome;
	}

	private void setValore(double valore) {

		if (valore < 1.0)
			throw new IllegalArgumentException("Il valore di una singola azione non puo' essere minore di 1");

		this.valore = valore;
	}

	/**
	 * @throws NullPointerException
	 *             -se totaleAzioni non corrisponde a Nessuna classificazione
	 *             Aziendale
	 */
	public static ClassificazioneAziendale checkIntTotaleAzienda(int totaleAzioni) throws NullPointerException {

		ClassificazioneAziendale gr = ClassificazioneAziendale.valoreDi(totaleAzioni);

		Objects.requireNonNull(gr, NO_CATEGORIA);

		return gr;
	}

	// private void setTotaleAzioni(int totAzioni) {
	// int max=Math.max(valore/10,20);
	// if(totAzioni<max){
	// ---------------
	// throw new IllegalArgumentException("Numero totale di azioni, troppo basso");
	// ---------------
	// <<<<<<<<<<<>
	// totAzioni=max;
	// <<<<<<<<<<<>
	// }
	// this.totaleAzioni=totAzioni;
	// }

	@Override
	public String getNome() {

		return nome;
	}

	@Override
	public double getPrezzoSingolaAzione() {

		return valore;
	}

	@Override
	public int getTotaleAzioni() {

		return totaleAzioni.getNumeroAzioni();
	}

	@Override
	public void variazioneGiornaliera() {

		valore = Oscilla.oscilla(getPrezzoSingolaAzione());
	}

	@Override
	public int hashCode() {

		return getNome().hashCode();
	}

	@Override
	public int compareTo(ITitolo o) {

		return (int) (o.getPrezzoSingolaAzione() - this.getPrezzoSingolaAzione());
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Titolo) {

			Titolo t = (Titolo) o;

			return getNome().equalsIgnoreCase(t.getNome());
		} else

			return false;
	}

	@Override
	public double getQuotazioneTotale() {
		
		return valore * totaleAzioni.getNumeroAzioni();
	}

}
