package net.sandikta.smp.raportapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sandikta.smp.raportapp.entities.enums.NamaKegiatan;
import net.sandikta.smp.raportapp.entities.enums.NilaiKegiatan;

@Entity
@Table(name="NILAI_KEGIATAN")
public class KegiatanSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_KEGIATAN")
	private Long idKegiatan;

	@Column(name="NAMA_KEGITAN", nullable=false)
	@Enumerated(EnumType.STRING)
	private NamaKegiatan namaKegiatan;
	
	@Column(name="NILAI_KEGIATAN", nullable=false)
	@Enumerated(EnumType.STRING)
	private NilaiKegiatan nilaiKegiatan;

	public Long getIdKegiatan() {
		return idKegiatan;
	}

	public void setIdKegiatan(Long idKegiatan) {
		this.idKegiatan = idKegiatan;
	}

	public NamaKegiatan getNamaKegiatan() {
		return namaKegiatan;
	}

	public void setNamaKegiatan(NamaKegiatan namaKegiatan) {
		this.namaKegiatan = namaKegiatan;
	}

	public NilaiKegiatan getNilaiKegiatan() {
		return nilaiKegiatan;
	}

	public void setNilaiKegiatan(NilaiKegiatan nilaiKegiatan) {
		this.nilaiKegiatan = nilaiKegiatan;
	}
}