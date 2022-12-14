import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

public class Main {
	// a
	/**
	 * Functia afiseaza lista de filme cu toate detaliile , cum ar fi lista actori si aptitudinile lor
	 * @param filme - lista de filme
	 */
	public static void afisareFilme(List<Film> filme) {
		for (Film film : filme)
			System.out.println(film.toString());
	}
	/**
	 * Functia afiseaza lista de filme doar cu titlul filmului, numele regizorului si bugetul
	 * @param filme - lista de filme
	 */

	public static void afisareFilmeSumar(List<Film> filme) {
		for (Film film : filme)
			System.out.println(film.print());
	}

	/**
	 * Metoda creaza o lista de filme muzical si o returneaza
	 * @param filme - lista de filme
	 * @param n - numarul de actori preluat de pe linia de comanda
	 * @return o lista de filme muzical
	 */
	public static List<Film> creareListaFilmeMuzicale(List<Film> filme, String n) {
		List<Film> filmeMuzical = new ArrayList<>();
		Integer num = Integer.valueOf(n);
		System.out.println("\nNumarul n din linia de comanda: " + num);
		for (Film film : filme) {
			if (film instanceof Muzical) {
				if (((Muzical) film).getActori().size() < num)
					filmeMuzical.add(film);
			}

		}
		return filmeMuzical;
		

	}
	
	/**
	 * Metoda numara câte documentare au în descrierea lor un set de cuvinte.
	 * @param filme - lista de filme din care se iau documentarele
	 * @param cuvinte - setul de cuvinte
	 * @param numarAparitii - cate documentare contin setul de cuvinte
	 * @return 
	 */
	public static long numarDeAparitiiCuvinte(List<Film> filme,List<String> cuvinte,long numarAparitii) {
		numarAparitii = filme.stream().filter(el -> (el instanceof Documentar))
				.filter(el -> ((Documentar) el).descriereaContineCuvintele(cuvinte)).count();
		return numarAparitii;
		
	}
	
	/**
	 * 
	 * @param cuvinte lista de cuvinte 
	 * @return un string formatat pentru afisarea cuvintelor din lista de cuvinte
	 */
	public static String formatareListaCaString(List<String> cuvinte) {
		String setulDeCuvinteString = cuvinte.stream().map(el -> String.valueOf(el)).collect(Collectors.joining(", "));
		return setulDeCuvinteString;
		
	}
	
	/**
	 * Metoda sorteaza crescator dupa buget , iar la bugete egale sorteaza lexicografic dupa numele regizorului
	 * @param filme - lista de filme pe care aplicam sortarea
	 */
	public static void sortareDupaBugetSauNumeRegizor(List<Film> filme) {
		Comparator<Film> comparator = new Comparator<Film>() {

			@Override
			public int compare(Film o1, Film o2) {
				if (Double.compare(o1.getBuget(), o2.getBuget()) == 0) {
					return o1.getRegizor().compareTo(o2.getRegizor());

				}
				return Double.compare(o1.getBuget(), o2.getBuget());
			}
		};
		System.out.println();
		Collections.sort(filme, comparator);
		afisareFilmeSumar(filme);
	}
	
	/**
	 * metoda parcurge lista de filme , iar din Muzicale ia numele actorilor o singura data
	 * @param filme - lista de filme
	 * @return o lista de actori distincti din filmele muzical 
	 */
	public static List<String> actoriDistincti(List<Film> filme){
		List<String> actori = filme.stream()
                .filter(el -> el instanceof Muzical)
                .map(el -> ((Muzical) el).getActori())
                .flatMap(Collection::stream)
                .map(el -> el.getNume())
                .distinct()
                .collect(Collectors.toList());
		return actori;
		
	}
	
	/**
	 * 
	 * @param filme
	 * @return o lista care contine strict filmele muzicale
	 */
	public static List<Muzical> creareLisaMuzicale(List<Film> filme) {
		List<Muzical> muzicale = filme.stream()
				.filter(el -> el instanceof Muzical)
				.map(el -> (Muzical) el)
				.collect(Collectors.toList());
		return muzicale;
	}
	
	/**
	 * Metoda afiseaza actorii ,muzicalele in care au jucat si numele regizorului
	 * @param actori - lista cu actorii din muzicale, fiecare aparand o singura data
	 * @param muzicale - lista de muzicale
	 */
	public static void printareActorSiFilme(List<String> actori, List<Muzical> muzicale) {
		actori.forEach(el -> {
			System.out.println("Actor: " + el);
			muzicale.forEach(muzical -> {
				if (muzical.getActori().stream()
						.map(Actor::getNume)
						.toList()
						.contains(el)) {
					System.out.println(muzical.getTitlu() + " - " + muzical.getRegizor());

				}
			});
			System.out.println();
		});
	}

	public static void main(String[] args) {

		List<Actor> actoriTitanic = new ArrayList<>();
		actoriTitanic.add(new Actor("Kate Winslet", "exceptionale", "exceptionale"));
		actoriTitanic.add(new Actor("Leonardo DiCaprio", "exceptionale", "exceptionale"));
		actoriTitanic.add(new Actor("Billy Zane", "bune", "bune"));

		List<Actor> actoriHighSchoolMusical = new ArrayList<>();
		actoriHighSchoolMusical.add(new Actor("Zac Efron", "exceptionale", "exceptionale"));
		actoriHighSchoolMusical.add(new Actor("Vanessa Hudgens", "exceptionale", "exceptionale"));
		actoriHighSchoolMusical.add(new Actor("Ashley Tisdale", "bune", "bune"));
		actoriHighSchoolMusical.add(new Actor("Lucas Grabeel", "bune", "exceptionale"));
		actoriHighSchoolMusical.add(new Actor("Monique Coleman", "medii", "medii"));
		actoriHighSchoolMusical.add(new Actor("Leonardo DiCaprio", "exceptionale", "exceptionale"));

		List<Actor> actoriLionKing = new ArrayList<>();
		actoriLionKing.add(new Actor("James Earl Jones", "bune", "exceptionale"));
		actoriLionKing.add(new Actor("Beyonce", "exceptionale", "exceptionale"));
		actoriLionKing.add(new Actor("Donald Glover", "bune", "bune"));

		List<Film> filme = new ArrayList<>();
		filme.add(new Film("I Origins", "Mike Cahill", 80000));
		filme.add(new Film("Lucy", "Marc Shmuger", 76000));
		filme.add(new Film("The Great Gatsby", "Baz Luhrmann", 76000));
		filme.add(new Documentar("The mind, explained", "Ezra Klein of Vox", 50000, 10,
				"Un documentar interesant care desluseste misterele mintii"));
		filme.add(new Documentar("Chernobyl", "Craig Mazin", 90000, 5, "Un documentar interesant si fascinant"));
		filme.add(new Muzical("Titanic", "James Cameron", 60000, actoriTitanic));
		filme.add(new Muzical("High School Musical", "Don Schain", 70000, actoriHighSchoolMusical));
		filme.add(new Muzical("The Lion King", "Don Hahn", 260000, actoriLionKing));

		// a
		
		afisareFilme(filme);

		// b
		
		List<Film> filmeMuzical = creareListaFilmeMuzicale(filme, args[0]);
		System.out.println("\nFILME MUZICAL");
		afisareFilme(filmeMuzical);

		// c
		
		List<String> cuvinte = List.of("interesant", "fascinant");
		long numarAparitii = numarDeAparitiiCuvinte(filme, cuvinte, 0);
		String setulDeCuvinteString = formatareListaCaString(cuvinte);
		System.out.println("\nSetul de cuvinte: " + setulDeCuvinteString);
		System.out.println("Numar de ocumentare care contin setul de cuvinte: " + numarAparitii);

		// e
		
		System.out.println("\nFILMELE SORTATE");
		sortareDupaBugetSauNumeRegizor(filme);
		System.out.println();
		
		//d
		
		System.out.println("\nAfisare actori si filmele in care au jucat\n");
		List<String> actori = actoriDistincti(filme);
        List<Muzical> muzicale = creareLisaMuzicale(filme);
        printareActorSiFilme(actori,muzicale);
       
				

	}

}
