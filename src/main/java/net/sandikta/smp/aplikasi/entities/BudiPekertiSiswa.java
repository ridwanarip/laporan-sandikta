package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import net.sandikta.smp.aplikasi.entities.enums.BudiPekerti;

@Embeddable
public class BudiPekertiSiswa {

	@Column(name="AKHLAK_SISWA", nullable=false)
	@Enumerated(EnumType.STRING)
	private BudiPekerti akhlak;

	@Column(name="KEPRIBADIAN_SISWA", nullable=false)
	@Enumerated(EnumType.STRING)
	private BudiPekerti kepribadian;

	public BudiPekerti getAkhlak() {
		return akhlak;
	}

	public void setAkhlak(BudiPekerti nilaiAkhlak) {
		// this.akhlak = akhlak;
		try {
			this.akhlak = nilaiAkhlak;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BudiPekerti getKepribadian() {
		return kepribadian;
	}

	public void setKepribadian(BudiPekerti nilaiKepribadian) {
		// this.kepribadian = kepribadian;
		try {
			this.kepribadian = nilaiKepribadian;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}