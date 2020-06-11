package contenitore;

import borsa.ElencoTitoli;
import portafoglioUtente.Lotto;
import portafoglioUtente.Portafoglio;
import titolo.ClassificazioneAziendale;
import titolo.Titolo;
import util.mylib.InputDati;
import util.mylib.MyMenu;

class UtilitaTitoli
{

 private final static String MSG_NOME_TITOLO = "INSERIRE LA DENOMINAZIONE DEL NUOVO TITOLO DA CREARE:";
 private final static String MSG_PREZZO_TITOLO = "INSERIRE IL PREZZO INIZIALE DEL TITOLO %s:";
 private final static String MSG_NUMERO_AZIONI = "INSERIRE IL NUMERO DI AZIONI ACQUISTATE DEL TITOLO %s:";
 private final static String MSG_ALTRO_TITOLO = "INSERIRE UN ALTRO TITOLO IN ELENCO ?";
 private final static String MSG_NOME_PORTFOLIO = "INSERIRE LA DENOMINAZIONE DEL PORTAFOGLIO CONSIDERATO:";
 
 public static Titolo creaTitolo()
	{
	 String nome = InputDati.leggiStringaNonVuota(MSG_NOME_TITOLO);
	 double prezzo = InputDati.leggiDoubleConMinimo(String.format(MSG_PREZZO_TITOLO,nome), 1); // Impongo prezzo >= 0
	ClassificazioneAziendale az= new MyMenu<ClassificazioneAziendale>("Classificazione aziendale", ClassificazioneAziendale.values()).scegliSenzaEsciEritornaOpzione();
	 return new Titolo(nome, prezzo,az);
	}

 public static Portafoglio creaPortafoglio(ElencoTitoli borsa )
	{
	 Portafoglio p = new Portafoglio();
	 for (int i = 0; i < borsa.numTitoli(); i++)
		{
		 Titolo t = (Titolo) borsa.getTitolo(i);
		 int dimLotto = InputDati.leggiIntero(String.format(MSG_NUMERO_AZIONI, t.getNome(), 0, t.getTotaleAzioni())); // Impongo numero di azioni >= 1
		 if(dimLotto>0)
		 p.aggiungiLotto((new Lotto (t, dimLotto) ));
		 else System.out.println(String.format("Nessuna quota comprata per %s",t.getNome()));
		}
	 return p;
	}

 public static ElencoTitoli creaElencoTitoli()
	{
	 ElencoTitoli borsa =new ElencoTitoli();
	 do
		{
		 Titolo nuovoTitolo = creaTitolo();
		 borsa.aggiungiTitolo(nuovoTitolo);
		} while (InputDati.yesOrNo(MSG_ALTRO_TITOLO));
		return borsa;
	 }
 
 public static Portafoglio creaPatrimonio(ElencoTitoli titoli)
	
 {
	  return creaPortafoglio(titoli);
		
	 
	}
}

