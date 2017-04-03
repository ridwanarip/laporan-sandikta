package net.sandikta.smp.aplikasi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.Semester;

@Entity
@Table(name="SISWA")
public class Siswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SISWA")
	private Integer idSiswa;

	@Column(name="NO_INDUK_SISWA", unique=true, nullable=false)
	private Integer noInduk;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PELAJAR")
	private List<NilaiSiswa> nilaiMatpel = new 
			ArrayList<NilaiSiswa>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PELAJAR")
	private List<KegiatanSiswa> kegiatan = new 
			ArrayList<KegiatanSiswa>();
	
	@Embedded
	private BudiPekertiSiswa budiPekerti;
	
	@Embedded
	private AbsensiSiswa absensi;

	@Column(name="NAMA_SISWA", nullable=false, length=50)
	private String nama;

	@Column(name="ALAMAT", nullable=false)
	private String alamat;

	@Column(name="Kelas", nullable=false)
	@Enumerated(EnumType.STRING)
	private Kelas kelas;

	@Column(name="TAHUN_AJARAN", nullable=false)
	private String tahunPelajaran;

	@Column(name="SEMESTER", nullable=false)
	@Enumerated(EnumType.STRING)
	private Semester semester;

	public Integer getIdPelajar() {
		return idSiswa;
	}

	public void setIdPelajar(Integer idSiswa) {
		this.idSiswa = idSiswa;
	}

	public Integer getNoInduk() {
		return noInduk;
	}

	public void setNoInduk(Integer noInduk) {
		this.noInduk = noInduk;
	}

	public List<NilaiSiswa> getNilaiMatpel() {
		return nilaiMatpel;
	}

	public void setNilaiMatpel(List<NilaiSiswa> nilaiMatpel) {
		this.nilaiMatpel = nilaiMatpel;
	}

	public List<KegiatanSiswa> getKegiatan() {
		return kegiatan;
	}

	public void setKegiatan(List<KegiatanSiswa> kegiatan) {
		this.kegiatan = kegiatan;
	}

	public BudiPekertiSiswa getBudiPekerti() {
		return budiPekerti;
	}

	public void setBudiPekerti(BudiPekertiSiswa budiPekerti) {
		this.budiPekerti = budiPekerti;
	}

	public AbsensiSiswa getAbsensi() {
		return absensi;
	}

	public void setAbsensi(AbsensiSiswa absensi) {
		this.absensi = absensi;
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

	public Kelas getKelas() {
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

	public String getTahunPelajaran() {
		return tahunPelajaran;
	}

	public void setTahunPelajaran(String tahunPelajaran) {
		this.tahunPelajaran = tahunPelajaran;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
}