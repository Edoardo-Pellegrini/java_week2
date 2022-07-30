package it.epicode.catalogo;

public interface Articolo {

	String getCodiceUnivoco();

	void setCodiceUnivoco(String codiceUnivoco);

	String getTitolo();

	void setTitolo(String titolo);

	int getAnnoPubblicazione();

	void setAnnoPubblicazione(int annoPubblicazione);

	int getNumeroPagine();

	void setNumeroPagine(int numeroPagine);

	public String getAutore();
	
	public void setAutore(String autore);
	
	public String getGenere();
	
	public void setGenere(String genere);
	
	public String getPeriodicita();
	
	public void setPeriodicita();
}