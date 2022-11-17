public class Actor {
	private String nume;
	private String abilitatiDans;
	private String abilitatiCantat;
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getAbilitatiDans() {
		return abilitatiDans;
	}
	public void setAbilitatiDans(String abilitatiDans) {
		this.abilitatiDans = abilitatiDans;
	}
	public String getAbilitatiCantat() {
		return abilitatiCantat;
	}
	public void setAbilitatiCantat(String abilitatiCantat) {
		this.abilitatiCantat = abilitatiCantat;
	}
	public Actor() {}
	
	public Actor(String nume, String abilitatiDans, String abilitatiCantat) {
		this.nume = nume;
		this.abilitatiDans = abilitatiDans;
		this.abilitatiCantat = abilitatiCantat;
	}
	public String toString() {
		return "\n\nNume: "+ nume + ",\nAbilitati de dans: "+ abilitatiDans + ",\nAbilitati de cantat: " + abilitatiCantat;
	}

}
