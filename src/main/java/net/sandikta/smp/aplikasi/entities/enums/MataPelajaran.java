package net.sandikta.smp.aplikasi.entities.enums;

public enum MataPelajaran {

	Pendidikan_Agama (74),
	Pendidikan_Kewarganegaraan (73),
	Bahasa_Indonesia (72),
	Bahasa_Inggris (71),
	Matematika (72),
	Ilmu_Pengetahuan_Alam (71),
	Ilmu_Pengetahuan_Sosial (73),
	Seni_Budaya (75),
	Pendidikan_Olahraga_dan_Kesehatan (73),
	Teknologi_Informasi_dan_Komunikasi (72),
	Bahasa_dan_Sastra_Sunda (72),
	Pendidikan_Lingkungan_Hidup (81);
	
	private final int kkm;
	
	private MataPelajaran(int nilaiKkm) {
		this.kkm = nilaiKkm;
	}
	
	public int getNilaiKkm() {
		return this.kkm;
	}
}