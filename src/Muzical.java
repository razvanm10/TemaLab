import java.util.ArrayList;
import java.util.List;

public class Muzical extends Film {
	private List<Actor> actori = new ArrayList<>();

	public List<Actor> getActori() {
		return actori;
	}

	public void setActori(List<Actor> actori) {
		this.actori = actori;
	}

	public Muzical() {
		super();
	}

	public Muzical(String titlu, String regizor, double buget, List<Actor> actori) {
		super(titlu, regizor, buget);
		this.actori = actori;
	}
	
	
	
	public String toString() {
		String listaDeActoriString = "";
		for(Actor actor : actori) {
			listaDeActoriString = listaDeActoriString + actor.toString();
		}
		return super.toString() + "\n\nActori:"+ listaDeActoriString;
		
	}
	public String print() {
		return super.toString();
	}

}
