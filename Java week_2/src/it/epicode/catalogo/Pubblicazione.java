package it.epicode.catalogo;

public abstract class Pubblicazione implements Articolo {
	private String codiceUnivoco;
	private String titolo;
	@Override
	public String toString() {
		return "Pubblicazione [codiceUnivoco=" + codiceUnivoco + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}
	private int annoPubblicazione;
	private int numeroPagine;
	public Pubblicazione(String codiceUnivoco,String titolo,int annoPubblicazione,int numeroPagine) {
		this.codiceUnivoco = codiceUnivoco;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}
	@Override
	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}
	@Override
	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}
	@Override
	public String getTitolo() {
		return titolo;
	}
	@Override
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Override
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	@Override
	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	@Override
	public int getNumeroPagine() {
		return numeroPagine;
	}
	@Override
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	
}
