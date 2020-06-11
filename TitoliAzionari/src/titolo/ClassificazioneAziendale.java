package titolo;


public enum ClassificazioneAziendale  {

	PICCOLA(100), MEDIA(250), GRANDE(500);

	private int numeroAzioni;

	public int getNumeroAzioni() {
		return numeroAzioni;
	}

	private ClassificazioneAziendale(int numAzioni) {
		numeroAzioni = numAzioni;
	}

	public static ClassificazioneAziendale valoreDi(int valore) {

		for (int i = 0; i < ClassificazioneAziendale.values().length; i++) {
			if (ClassificazioneAziendale.values()[i].getNumeroAzioni() == valore)
				return ClassificazioneAziendale.values()[i];
		}
		return null;
	}
}
