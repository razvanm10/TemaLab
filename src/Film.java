public class Film {
	private String titlu;
	private String regizor;
	private double buget;
	
	public String getTitlu() {
		return titlu;
	}
	
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	
	public String getRegizor() {
		return regizor;
	}
	
	public void setRegizor(String regizor) {
		this.regizor = regizor;
	}
	
	public double getBuget() {
		return buget;
		
	}
	
	public void setBuget(double buget) {
		this.buget = buget;
	}
	
	public Film() {}

	public Film(String titlu, String regizor, double buget) {
		this.titlu = titlu;
		this.regizor = regizor;
		this.buget = buget;
		
	}
	
	public String toString() {
		return "\n" + titlu + " - " + regizor + "\nBuget: " + buget;
	}
	
	public String print(){
		return "\n" + titlu + " - " + regizor + "\nBuget: " + buget;
	}
	

}
