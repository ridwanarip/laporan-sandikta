package net.sandikta.smp.raportapp.entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sandikta.smp.raportapp.entities.enums.Kelas;
import net.sandikta.smp.raportapp.entities.enums.Semester;

@Entity
@Table(name="TAHUN_PELAJARAN")
public class TahunPelajaran {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TAHUN_PELAJARAN")
	private Long IdTahunPelajaran;
	
	@ManyToOne()
	@JoinColumn(name="ID_SISWA", nullable=false)
	private Siswa siswa;
	
	@Column(name="TAHUN", nullable=false)
	private String tahun;
	
	@Column(name="TOTAL_NILAI", nullable=false)
	private Double totalNilai;
	
	@Column(name="KELAS", nullable=false)
	@Enumerated(EnumType.STRING)
	private Kelas kelas;
	
	@Column(name="SEMESTER", nullable=false)
	@Enumerated(EnumType.STRING)
	private Semester semester;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ID_TAHUN_PELAJARAN", nullable=false)
	private List<NilaiSiswa> nilaiMatpel = new ArrayList<NilaiSiswa>();

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ID_TAHUN_PELAJARAN", nullable=false)
	private List<KegiatanSiswa> kegiatan = new ArrayList<KegiatanSiswa>();

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ID_TAHUN_PELAJARAN", nullable=false)
	private List<BudiPekertiSiswa> budiPekerti = new ArrayList<BudiPekertiSiswa>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ID_TAHUN_PELAJARAN", nullable=false)
	private List<AbsensiSiswa> absensi = new ArrayList<AbsensiSiswa>();

	public Long getIdTahunPelajaran() {
		return IdTahunPelajaran;
	}

	public void setIdTahunPelajaran(Long idTahunPelajaran) {
		IdTahunPelajaran = idTahunPelajaran;
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public Double getTotalNilai() {
		return totalNilai;
	}

	public void setTotalNilai(Double totalNilai) {
		this.totalNilai = totalNilai;
	}

	public Kelas getKelas() {
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
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
}