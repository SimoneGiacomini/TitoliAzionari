package titolo;

public interface ITitoli  {
	public static final double MAX_RIALZO = 0.2;
	public static final double MIN_RIBASSO = -0.2;

	String getNome();

	double getValore();

	int getTotaleAzioni();

	void oscilla() ;}

