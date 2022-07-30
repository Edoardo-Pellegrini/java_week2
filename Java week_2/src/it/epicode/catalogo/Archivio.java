package it.epicode.catalogo;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

public class Archivio {
	static int codiceProgressivo = 1;
	static String y;
	static Map<String, Pubblicazione> archivio = new TreeMap<>();

	// domanda: esiste un modo per eliminare un oggetto definitivamente?

	public static void main(String[] args) {
		System.out.println("---BENVENUTI AL SISTEMA DI AGGIUNTA ARTICOLI DELLA BIBLIOTECA DI PAPEROPOLI---");
		System.out.println("---MANUALE D'USO---");
		System.out.println("---AGGIUNGERE '-' AL POSTO DEGLI SPAZI---");
		System.out.println("---*Buona navigazione*---");
		System.out.println("=======================");
		System.out.println("Inserisci il numero di articoli che vuoi aggiungere");
		Scanner sc = new Scanner(System.in);
		int numeroArticoli = sc.nextInt();

		while (codiceProgressivo <= numeroArticoli) {
			AggiungiPubblicazione();
		}

		System.out.println("Tutti gli articoli aggiunti :)");
		Menu();

	}

	public static void AggiungiPubblicazione() {
		System.out.println("=======================");
		System.out.println("Scegli cosa aggiungere : ");
		System.out.println("1 -- LIBRO");
		System.out.println("2 -- RIVISTA");

		System.out.println("=======================");

		Scanner s = new Scanner(System.in);
		int x = s.nextInt();

		y = x + "00" + codiceProgressivo;
		if (x == 1) {
			System.out.println("=======================");
			System.out.println("Scrivi : ");
			System.out.println("- Titolo del libro");
			System.out.println("- Anno di pubblicazione");
			System.out.println("- Numero delle pagine");
			System.out.println("- Autore");
			System.out.println("- Genere");

			System.out.println("=======================");
			String titolo = s.next();
			int annoPubblicazione = s.nextInt();
			int numeroPagine = s.nextInt();
			String autore = s.next();
			String genere = s.next();
			Libro articolo = new Libro(y, titolo, annoPubblicazione, numeroPagine, autore, genere);
			archivio.put(y, articolo);
		} else if (x == 2) {
			System.out.println("=======================");
			System.out.println("Scrivi : ");
			System.out.println("- Titolo della rivista");
			System.out.println("- Anno di pubblicazione");
			System.out.println("- Numero delle pagine");
			System.out.println("- periodicità (settimanale-mensile-semestrale");

			System.out.println("=======================");
			String titolo = s.next();
			int annoPubblicazione = s.nextInt();
			int numeroPagine = s.nextInt();
			String periodicita = s.next().toLowerCase();
			boolean var = false;
			while (var != true) {
				if (periodicita.equals("settimanale") || periodicita.equals("mensile")
						|| periodicita.equals("semestrale")) {
					Rivista articolo = new Rivista(y, titolo, annoPubblicazione, numeroPagine, periodicita);

					archivio.put(y, articolo);
					var = true;

				} else {
					System.out.println("Controlla di aver scritto una periodicità giusta");
					System.out.println("Puoi scrivere mensile,settimale o semetrale");
					System.out.println("Scrivi di nuovo la periodicità :");
					periodicita = s.next().toLowerCase();

				}
			}

		} else {
			System.out.println("!Scelta inserita non valida!");
			System.out.println("Scrivi 1 per aggiungere un libro o 2 per aggiungere una rivista");
			AggiungiPubblicazione();
		}
		System.out.println("Questa è l'archivio aggiornato : " + archivio);
		codiceProgressivo++;

	}

	public static void Menu() {
		Scanner sca = new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("---BENVENUTO NEL MENU DI NAVIGAZIONE---");
		System.out.println("Scegli la funzione che ti serve");

		System.out.println("0--Aggiungi");
		System.out.println("1--Rimuovi");
		System.out.println("2--Cerca");
		System.out.println("3--Stampa archivio (file txt)");
		System.out.println("4--Trascrivi dal tuo pc (file txt)");
		System.out.println("=======================");
		int x = sca.nextInt();
		if (x == 1) {
			System.out.println("Scrivi il codice dell'articolo da rimuovere");
			String codice = sca.next();
			Rimuovi(codice);
		} else if (x == 2) {
			
			System.out.println("=======================");
			System.out.println("---RICERCA---");
			System.out.println("Seleziona che parametro di ricerca usare oppure torna al menu");
			System.out.println("0-- Ritorna al menu");
			System.out.println("1-- Cerca tramite codice articolo");
			System.out.println("2-- Cerca tramite anno di pubblicazione");
			System.out.println("3-- Cerca tramite autore");
			System.out.println("=======================");
			int parametro = sca.nextInt();
			if (parametro == 0) {
				Menu();
			} else if (parametro == 1) {
				System.out.println("Scrivi il codice articolo da cercare");
				System.out.println("=======================");
				String codice = sca.next();
				CercaTramiteCodice(codice);
			} else if (parametro == 2) {
				System.out.println("Scrivi l'anno dell'articolo da cercare");
				System.out.println("=======================");
				int anno = sca.nextInt();
				CercaTramiteAnno(anno);

			} else if (parametro == 3) {
				System.out.println("Scrivi l'autore dell'articolo da cercare");
				System.out.println("=======================");
				String autore = sca.next();
				CercaTramiteAutore(autore);
			} else {
				System.out.println("Devi selezionare una funzione valida!");
				Menu();
			}
		} else if (x == 0) {
			AggiungiPubblicazione();
			Menu();
		} else if (x == 3) {
			System.out.println("---FILE TXT AGGIUNTO SUL PC LOCALE---");
			StampaFileTxt("archivio/archivio.txt");
			Menu();
		} else if (x == 4) {
			System.out.println("---FILE TXT TRASCRITTO IN CONSOLE---");
			LeggiTxt("archivio/archivio.txt");
			Menu();
		} else {
			System.out.println("Devi selezionare 1 per rimuovere un articolo o 2 per cercarlo nell'archivio");
			Menu();
		}
	}

	public static void Rimuovi(String codice) {
		if (archivio.get(codice) != null) {
			System.out.println("Articolo " + archivio.get(codice).getTitolo() + " rimosso");
			archivio.remove(codice);
		} else {
			System.out.println("Codice non trovato :(");
		}

		Menu();

	}

	public static void CercaTramiteCodice(String codice) {
		if (archivio.get(codice) != null) {
			System.out.println("Articolo " + archivio.get(codice).getTitolo() + " trovato");
			System.out.println("Anno pubblicazione :" + archivio.get(codice).getAnnoPubblicazione());
			System.out.println("Numero pagine  :" + archivio.get(codice).getNumeroPagine());

			if (archivio.get(codice).getAutore() != null) {
				System.out.println("Autore :" + archivio.get(codice).getAutore());
				System.out.println("Genere :" + archivio.get(codice).getGenere());
			} else {
				System.out.println("Periodicità :" + archivio.get(codice).getPeriodicita());

			}

		} else {
			System.out.println("Codice non trovato :(");
		}
		Menu();

	}

	public static void CercaTramiteAnno(int anno) {
		archivio.values().stream().filter(articolo -> articolo.getAnnoPubblicazione() == anno).forEach(articolo -> {
			System.out.println("Articolo " + articolo.getTitolo() + " trovato");
			System.out.println("Numero pagine  :" + articolo.getNumeroPagine());

			if (articolo.getAutore() != null) {
				System.out.println("Autore :" + articolo.getAutore());
				System.out.println("Genere :" + articolo.getGenere());
			} else {
				System.out.println("Periodicità :" + articolo.getPeriodicita());

			}

		});
		Menu();
	}

	public static void CercaTramiteAutore(String autore) {

		archivio.values().stream().filter(articolo -> articolo instanceof Libro)
				.filter(articolo -> articolo.getAutore().equals(autore)).forEach(articolo -> {

					System.out.println("Articolo " + articolo.getTitolo() + " trovato");
					System.out.println("Anno pubblicazione  :" + articolo.getAnnoPubblicazione());
					System.out.println("Numero pagine  :" + articolo.getNumeroPagine());
					System.out.println("Genere :" + articolo.getGenere());
				});

		Menu();
	}

	public static void StampaFileTxt(String percorso) {
		File txt = new File(percorso);
		String articolo = "";
		for (Pubblicazione ele : archivio.values()) {
			articolo += ele.toString();
		}
		try {
			FileUtils.writeStringToFile(txt, articolo, "UTF-8");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void LeggiTxt(String percorso) {
		try {
			String console = FileUtils.readFileToString(new File(percorso)); // come mai è deprecato?
			System.out.println(console);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
