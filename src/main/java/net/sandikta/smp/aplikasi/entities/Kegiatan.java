package net.sandikta.smp.aplikasi.entities;

import net.sandikta.smp.aplikasi.entities.enums.NamaKegiatan;
import net.sandikta.smp.aplikasi.entities.enums.NilaiKegiatan;

public class Kegiatan {

	NamaKegiatan kegiatan;
	
	NilaiKegiatan nilai;

	public NamaKegiatan getKegiatan() {
		return kegiatan;
	}

	public void setKegiatan(NamaKegiatan kegiatan) {
		this.kegiatan = kegiatan;
	}

	public NilaiKegiatan getNilai() {
		return nilai;
	}

	public void setNilai(NilaiKegiatan nilai) {
		this.nilai = nilai;
	}
}