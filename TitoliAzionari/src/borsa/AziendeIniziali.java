package borsa;

import titolo.ClassificazioneAziendale;
import titolo.ITitoli;

public enum AziendeIniziali implements ITitoli {
	APPLE("Apple", 260.174, ClassificazioneAziendale.GRANDE),
	MICROSOFT("Microsoft", 125.8,ClassificazioneAziendale.GRANDE), 
	AMAZON("AMAZON", 280.522, ClassificazioneAziendale.GRANDE);
	
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the valore
	 */
	public double getValore() {
		return valore;
	}

	/**
	 * @return the totaleAzioni
	 */
	public int getTotaleAzioni() {
		return totaleAzioni.getNumeroAzioni();
	}

	private AziendeIniziali(String nome, double valore, ClassificazioneAziendale totaleAzioni) {
		this.nome = nome;
		this.valore = valore;
		this.totaleAzioni = totaleAzioni;
	}

	private String nome;
	private double valore;
	private ClassificazioneAziendale totaleAzioni;

	@Override
	public void oscilla() {
		// TODO Auto-generated method stub

	}

}
