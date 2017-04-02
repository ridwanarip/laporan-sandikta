package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GURU")
public class Guru {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GURU_ID")
	private Integer guruId;
	
	@Column(name="NIK", unique=true, nullable=false, length=5)
	private String nik;
	
	@Column(name="NAMA_GURU", nullable=false, length=25)
	private String nama;
	
	@Column(name="ALAMAT", nullable=false)
	private String alamat;

	public Integer getGuruId() {
		return guruId;
	}

	public void setGuruId(Integer guruId) {
		this.guruId = guruId;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}