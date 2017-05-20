package net.sandikta.smp.aplikasi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SISWA")
public class Siswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SISWA")
	private Long idSiswa;

	@Column(name="NO_INDUK_SISWA", unique=true, nullable=false)
	private String noInduk;
	
	@Column(name="NAMA_SISWA", nullable=false, length=50)
	private String nama;

	@Column(name="ALAMAT", nullable=false)
	private String alamat;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="siswa")
	private List<TahunPelajaran> tahunPelajaran = new ArrayList<TahunPelajaran>();

	public Long getIdSiswa() {
		return idSiswa;
	}

	public void setIdSiswa(Long idSiswa) {
		this.idSiswa = idSiswa;
	}

	public String getNoInduk() {
		return noInduk;
	}

	public void setNoInduk(String noInduk) {
		this.noInduk = noInduk;
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

	public List<TahunPelajaran> getTahunPelajaran() {
		return tahunPelajaran;
	}

	public void setTahunPelajaran(List<TahunPelajaran> tahunPelajaran) {
		this.tahunPelajaran = tahunPelajaran;
	}
}