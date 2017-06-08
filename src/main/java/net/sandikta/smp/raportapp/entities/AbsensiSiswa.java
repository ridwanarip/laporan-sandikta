package net.sandikta.smp.raportapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sandikta.smp.raportapp.entities.enums.NamaAbsensi;

@Entity
@Table(name="NILAI_ABSESNSI")
public class AbsensiSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABSENSI", nullable=false)
	private Long idAbsensi;

	@Column(name="NAMA_ABSENSI", nullable=false)
	@Enumerated(EnumType.STRING)
	private NamaAbsensi namaAbsensi;
	
	@Column(name="JUMLAH")
	private Integer jumlah;

	public Long getIdAbsensi() {
		return idAbsensi;
	}

	public void setIdAbsensi(Long idAbsensi) {
		this.idAbsensi = idAbsensi;
	}

	public NamaAbsensi getNamaAbsensi() {
		return namaAbsensi;
	}

	public void setNamaAbsensi(NamaAbsensi namaAbsensi) {
		this.namaAbsensi = namaAbsensi;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
}