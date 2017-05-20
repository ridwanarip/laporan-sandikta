package net.sandikta.smp.aplikasi.entities.enums;

public enum MataPelajaran {

	PENDIDIKAN_AGAMA (74),
	PENDIDIKAN_KEWARGANEGARAAN (73),
	BAHASA_INDONESIA (72),
	BAHASA_INGGRIS (71),
	MATEMATIKA (72),
	ILMU_PENGETAHUAN_ALAM (71),
	ILMU_PENGETAHUAN_SOSIAL (73),
	SENI_BUDAYA (75),
	PENDIDIKAN_OLAHRAGA_dan_KESEHATAN (73),
	TEKNOLOGI_INFORMASI_dan_KOMUNIKASI (72),
	BAHASA_dan_SASTRA_SUNDA (72),
	PENDIDIKAN_LINGKUNGAN_HIDUP (81);
	
	private final int kkm;
	
	private MataPelajaran(int nilaiKkm) {
		this.kkm = nilaiKkm;
	}
	
	public int getNilaiKkm() {
		return this.kkm;
	}
}