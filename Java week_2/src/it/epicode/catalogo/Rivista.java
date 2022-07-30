package it.epicode.catalogo;



public class Rivista extends Pubblicazione implements Articolo{
	
	
	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + " " + super.toString() + "]";
	}
	String periodicita;
	public Rivista(String codiceUnivoco, String titolo, int annoPubblicazione, int numeroPagine , String periodicita) {
		super(codiceUnivoco, titolo, annoPubblicazione, numeroPagine);
		this.periodicita=periodicita;
		
	}
	@Override
	public String getAutore() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAutore(String autore) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getGenere() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setGenere(String genere) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getPeriodicita() {
		// TODO Auto-generated method stub
		return this.periodicita;
	}
	@Override
	public void setPeriodicita() {
		// TODO Auto-generated method stub
		
	}

}
