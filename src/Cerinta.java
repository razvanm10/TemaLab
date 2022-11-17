import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cerinta {
	
	public Cerinta() {
	}
	
	/**
	 * Functia afiseaza lista de filme cu toate detaliile , cum ar fi lista actori si aptitudinile lor
	 * @param filme - lista de filme
	 */
	public void afisareFilme(List<Film> filme) {
		for (Film film : filme)
			System.out.println(film.toString());
	}
	/**
	 * Functia afiseaza lista de filme doar cu titlul filmului, numele regizorului si bugetul
	 * @param filme - lista de filme
	 */

	public  void afisareFilmeSumar(List<Film> filme) {
		for (Film film : filme)
			System.out.println(film.print());
	}

	/**
	 * Metoda creaza o lista de filme muzical si o returneaza
	 * @param filme - lista de filme
	 * @param n - numarul de actori preluat de pe linia de comanda
	 * @return o lista de filme muzical
	 */
	public List<Film> creareListaFilmeMuzicale(List<Film> filme, String n) {
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
	public long numarDeAparitiiCuvinte(List<Film> filme,List<String> cuvinte,long numarAparitii) {
		numarAparitii = filme.stream().filter(el -> (el instanceof Documentar))
				.filter(el -> ((Documentar) el).descriereaContineCuvintele(cuvinte)).count();
		return numarAparitii;
		
	}
	
	/**
	 * 
	 * @param cuvinte lista de cuvinte 
	 * @return un string formatat pentru afisarea cuvintelor din lista de cuvinte
	 */
	public  String formatareListaCaString(List<String> cuvinte) {
		String setulDeCuvinteString = cuvinte.stream().map(el -> String.valueOf(el)).collect(Collectors.joining(", "));
		return setulDeCuvinteString;
		
	}
	
	/**
	 * Metoda sorteaza crescator dupa buget , iar la bugete egale sorteaza lexicografic dupa numele regizorului
	 * @param filme - lista de filme pe care aplicam sortarea
	 */
	public void sortareDupaBugetSauNumeRegizor(List<Film> filme) {
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
	public List<String> actoriDistincti(List<Film> filme){
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
	public List<Muzical> creareLisaMuzicale(List<Film> filme) {
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
	public void printareActorSiFilme(List<String> actori, List<Muzical> muzicale) {
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

}
