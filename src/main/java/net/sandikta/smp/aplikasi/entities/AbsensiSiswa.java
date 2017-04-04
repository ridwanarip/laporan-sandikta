package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ABSESNSI_SISWA")
public class AbsensiSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABSENSI")
	private Long idAbsensi;
	
	@OneToOne(mappedBy="absensi")
	private Siswa siswa;
	
	@Column(name="SAKIT")
	private Integer sakit;
	
	@Column(name="IJIN")
	private Integer ijin;
	
	@Column(name="TANPA_KETERANGAN")
	private Integer alpha;
	
	public AbsensiSiswa() {
		this.sakit = 0;
		this.ijin = 0;
		this.alpha = 0;
	}

	public Long getIdAbsensi() {
		return idAbsensi;
	}

	public void setIdAbsensi(Long idAbsensi) {
		this.idAbsensi = idAbsensi;
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

	public Integer getSakit() {
		return sakit;
	}

	public void setSakit(Integer sakit) {
		this.sakit = sakit;
	}

	public Integer getIjin() {
		return ijin;
	}

	public void setIjin(Integer ijin) {
		this.ijin = ijin;
	}

	public Integer getAlpha() {
		return alpha;
	}

	public void setAlpha(Integer alpha) {
		this.alpha = alpha;
	}
}