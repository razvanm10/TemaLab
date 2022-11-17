import java.util.List;

import javax.lang.model.element.Element;

public class Documentar extends Film{
	private int nrEpisoade;
	private String descriere;
	
	public int getNrEpisoade() {
		return nrEpisoade;
	}
	
	public void setNrEpisoade(int nrEpisoade) {
		this.nrEpisoade = nrEpisoade;
	}
	
	public String getDescriere() {
		return descriere;
	}
	
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public Documentar() {
		super();
	}

	public Documentar(String titlu, String regizor, double buget, int nrEpisoade, String descriere) {
		super(titlu, regizor, buget);
		this.nrEpisoade = nrEpisoade;
		this.descriere = descriere;
	}
	
	public String toString() {
		return super.toString() + "\nNumar de episoade: " + nrEpisoade + "\nDescriere: " + descriere;
	}
	
	public String print() {
		return super.toString();
	}
	
	public boolean descriereaContineCuvintele(List<String> cuvinte) {
		int k = 0;
		for (String cuvant:cuvinte) {
			if(this.descriere.contains(cuvant)) {
				k++;
			}
			
		}
		return k == cuvinte.size();
	}

}
