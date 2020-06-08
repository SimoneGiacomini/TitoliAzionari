package borsa;

import titolo.ClassificazioneAziendale;
import titolo.ITitolo;
import titolo.Titolo;
@Deprecated
public enum AziendeIniziali implements ITitolo{
	APPLE("Apple", 260.174, ClassificazioneAziendale.GRANDE),
	MICROSOFT("Microsoft", 125.8,ClassificazioneAziendale.GRANDE), 
	AMAZON("AMAZON", 280.522, ClassificazioneAziendale.GRANDE)
	;

	private Titolo titolo;

	private AziendeIniziali(String nome, double valore, ClassificazioneAziendale totaleAzioni) {
		titolo=new Titolo(nome, valore, totaleAzioni);
	}

	@Override
	public String getNome() {
	return titolo.getNome();
	}


	@Override
	public double getPrezzo() {
		return titolo.getPrezzo();
	}


	@Override
	public int getTotaleAzioni() {
		return titolo.getTotaleAzioni();
	}


	@Override
	public void variazioneGiornaliera() {
		titolo.variazioneGiornaliera();
	}
	

}
