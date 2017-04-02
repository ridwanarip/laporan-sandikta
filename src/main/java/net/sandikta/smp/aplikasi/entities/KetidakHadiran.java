package net.sandikta.smp.aplikasi.entities;

public class KetidakHadiran {

	private int sakit;
	private int ijin;
	private int alpha;
	
	public KetidakHadiran() {
		this.sakit = 0;
		this.ijin = 0;
		this.alpha = 0;
	}
	
	public int getSakit() {
		return sakit;
	}
	public void setSakit(int sakit) {
		this.sakit = sakit;
	}
	public int getIjin() {
		return ijin;
	}
	public void setIjin(int ijin) {
		this.ijin = ijin;
	}
	public int getAlpha() {
		return alpha;
	}
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}
}