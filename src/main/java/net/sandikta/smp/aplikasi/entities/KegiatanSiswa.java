package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sandikta.smp.aplikasi.entities.enums.Kegiatan;
import net.sandikta.smp.aplikasi.entities.enums.NilaiKegiatan;

@Entity
@Table(name="KEGIATAN_SISWA")
public class KegiatanSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_KEGIATAN")
	private Integer idKegiatan;

	@Column(name="NAMA_KEGIATAN")
	@Enumerated(EnumType.STRING)
	private Kegiatan kegiatan;

	@Column(name="NILAI_KEGIATAN")
	@Enumerated(EnumType.STRING)
	private NilaiKegiatan nilai;

	public Integer getIdKegiatan() {
		return idKegiatan;
	}

	public void setIdKegiatan(Integer idKegiatan) {
		this.idKegiatan = idKegiatan;
	}

	public Kegiatan getKegiatan() {
		return kegiatan;
	}

	public void setKegiatan(Kegiatan kegiatan) {
		// this.kegiatan = kegiatan;
		try {
			this.kegiatan = kegiatan;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NilaiKegiatan getNilai() {
		return nilai;
	}

	public void setNilai(NilaiKegiatan nilaiKegiatan) {
		// this.nilai = nilai;
		try {
			this.nilai = nilaiKegiatan;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}