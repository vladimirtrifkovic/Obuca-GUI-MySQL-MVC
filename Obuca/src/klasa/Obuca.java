package klasa;

public class Obuca {
	private String vrsta;
	private boolean muske;
	private boolean zenske;
	private boolean djecije;
	private int brKomada;
	private double cena;

	public Obuca(String vrsta, boolean muske, boolean zenske, boolean djecije, int brKomada, double cena) {
		super();
		this.vrsta = vrsta;
		this.muske = muske;
		this.zenske = zenske;
		this.djecije = djecije;
		this.brKomada = brKomada;
		this.cena = cena;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public boolean isMuske() {
		return muske;
	}

	public void setMuske(boolean muske) {
		this.muske = muske;
	}

	public int getBrKomada() {
		return brKomada;
	}

	public void setBrKomada(int brKomada) {
		this.brKomada = brKomada;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public boolean isDjecije() {
		return djecije;
	}

	public void setDjecije(boolean djecije) {
		this.djecije = djecije;
	}

	public boolean isZenske() {
		return zenske;
	}

	public void setZenske(boolean zenske) {
		this.zenske = zenske;
	}

	@Override
	public String toString() {
		return "vrsta=" + vrsta + "\nmuske=" + muske + "\nzenske=" + zenske + "\ndjecije=" + djecije + "\nBroj komada="
				+ brKomada + "\ncena=" + cena + "\n*****************";
	}
}
