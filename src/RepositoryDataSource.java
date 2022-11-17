import java.util.ArrayList;
import java.util.List;

public class RepositoryDataSource {
	List<Actor> actoriTitanic = List.of(
			new Actor("Kate Winslet", "exceptionale", "exceptionale"),
			new Actor("Leonardo DiCaprio", "exceptionale", "exceptionale"),
			new Actor("Billy Zane", "bune", "bune")
			);
	

	List<Actor> actoriHighSchoolMusical = List.of(
			new Actor("Zac Efron", "exceptionale", "exceptionale"),
			new Actor("Vanessa Hudgens", "exceptionale", "exceptionale"),
			new Actor("Ashley Tisdale", "bune", "bune"),
			new Actor("Lucas Grabeel", "bune", "exceptionale"),
			new Actor("Monique Coleman", "medii", "medii"),
			new Actor("Leonardo DiCaprio", "exceptionale", "exceptionale")
			);

	List<Actor> actoriLionKing = List.of(
			new Actor("James Earl Jones", "bune", "exceptionale"),
			new Actor("Beyonce", "exceptionale", "exceptionale"),
			new Actor("Donald Glover", "bune", "bune")
			);

	List<Film> filme = List.of(
			new Film("I Origins", "Mike Cahill", 80000),
			new Film("Lucy", "Marc Shmuger", 76000),
			new Film("The Great Gatsby", "Baz Luhrmann", 76000),
			new Documentar("The mind, explained", "Ezra Klein of Vox", 50000, 10,
					"Un documentar interesant care desluseste misterele mintii"),
			new Documentar("Chernobyl", "Craig Mazin", 90000, 5, "Un documentar interesant si fascinant"),
			new Muzical("Titanic", "James Cameron", 60000, actoriTitanic),
			new Muzical("High School Musical", "Don Schain", 70000, actoriHighSchoolMusical),
			new Muzical("The Lion King", "Don Hahn", 260000, actoriLionKing)
			
			);
	

}
