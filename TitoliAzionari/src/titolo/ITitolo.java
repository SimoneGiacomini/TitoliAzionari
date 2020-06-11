package titolo;

public interface ITitolo  {
	public static final double MAX_RIALZO = 0.2;
	public static final double MIN_RIBASSO = -0.2;

	String getNome();

	double getPrezzoSingolaAzione();

	double getQuotazioneTotale();
	
	int getTotaleAzioni();

	void variazioneGiornaliera() ;

	int hashCode();
	
	boolean equals(Object o);
}

