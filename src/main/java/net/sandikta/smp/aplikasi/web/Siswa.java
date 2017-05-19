package net.sandikta.smp.aplikasi.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sandikta.smp.aplikasi.entities.AbsensiSiswa;
import net.sandikta.smp.aplikasi.entities.BudiPekertiSiswa;
import net.sandikta.smp.aplikasi.entities.KegiatanSiswa;
import net.sandikta.smp.aplikasi.entities.NilaiSiswa;
import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.Semester;

@Entity
@Table(name="SISWA")
public class Siswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SISWA")
	private Long idSiswa;

	@Column(name="NO_INDUK_SISWA", unique=true, nullable=false)
	private String noInduk;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_SISWA")
	private List<NilaiSiswa> nilaiMatpel = new ArrayList<NilaiSiswa>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_SISWA")
	private List<KegiatanSiswa> kegiatan = new ArrayList<KegiatanSiswa>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_SISWA")
	private List<BudiPekertiSiswa> budiPekerti = new ArrayList<BudiPekertiSiswa>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_SISWA")
	private List<AbsensiSiswa> absensi = new ArrayList<AbsensiSiswa>();

	@Column(name="NAMA_SISWA", nullable=false, length=50)
	private String nama;

	@Column(name="ALAMAT", nullable=false)
	private String alamat;

	@Column(name="Kelas", nullable=false)
	@Enumerated(EnumType.STRING)
	private Kelas kelas;

	@Column(name="TAHUN_AJARAN", nullable=false)
	private String tahunAjaran;

	@Column(name="SEMESTER", nullable=false)
	@Enumerated(EnumType.STRING)
	private Semester semester;

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

	public List<BudiPekertiSiswa> getBudiPekerti() {
		return budiPekerti;
	}

	public void setBudiPekerti(List<BudiPekertiSiswa> budiPekerti) {
		this.budiPekerti = budiPekerti;
	}

	public List<AbsensiSiswa> getAbsensi() {
		return absensi;
	}

	public void setAbsensi(List<AbsensiSiswa> absensi) {
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

	public String getTahunAjaran() {
		return tahunAjaran;
	}

	public void setTahunAjaran(String tahunAjaran) {
		this.tahunAjaran = tahunAjaran;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
}