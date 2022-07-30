package it.epicode.catalogo;

public class Libro extends Pubblicazione implements Articolo{
	String autore;
	String genere;
	public Libro(String codiceUnivoco, String titolo, int annoPubblicazione, int numeroPagine ,String autore, String genere) {
		super(codiceUnivoco, titolo, annoPubblicazione, numeroPagine);
		this.autore=autore;
		this.genere=genere;
		
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + " " + super.toString() + "]";
	}
	@Override
	public String getCodiceUnivoco() {
		// TODO Auto-generated method stub
		return super.getCodiceUnivoco();
	}
	@Override
	public void setCodiceUnivoco(String codiceUnivoco) {
		// TODO Auto-generated method stub
		super.setCodiceUnivoco(codiceUnivoco);
	}
	@Override
	public String getTitolo() {
		// TODO Auto-generated method stub
		return super.getTitolo();
	}
	@Override
	public void setTitolo(String titolo) {
		// TODO Auto-generated method stub
		super.setTitolo(titolo);
	}
	@Override
	public int getAnnoPubblicazione() {
		// TODO Auto-generated method stub
		return super.getAnnoPubblicazione();
	}
	@Override
	public void setAnnoPubblicazione(int annoPubblicazione) {
		// TODO Auto-generated method stub
		super.setAnnoPubblicazione(annoPubblicazione);
	}
	@Override
	public int getNumeroPagine() {
		// TODO Auto-generated method stub
		return super.getNumeroPagine();
	}
	@Override
	public void setNumeroPagine(int numeroPagine) {
		// TODO Auto-generated method stub
		super.setNumeroPagine(numeroPagine);
	}
	@Override
	public String getPeriodicita() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setPeriodicita() {
		// TODO Auto-generated method stub
		
	}

	
}
