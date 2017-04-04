package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="KEGIATAN_SISWA")
public class KegiatanSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_KEGIATAN")
	private Long idKegiatan;
	
//	@OneToOne(mappedBy="kegiatan")
//	private Siswa siswa;
	
	@Column(name="PRAMUKA")
	private String pramuka;
	
	@Column(name="DRUMBAND")
	private String drumband;
	
	@Column(name="PADUAN_SUARA")
	private String paduanSuara;
	
	@Column(name="FUTSAL")
	private String futsal;
	
	@Column(name="BEATBOX")
	private String beatbox;
	
	@Column(name="TAEKWONDO")
	private String taekwondo;
	
	@Column(name="NILAI_PRAMUKA")
	private String nilaiPramuka;
	
	@Column(name="NIALI_DRUMBAND")
	private String nilaiDrumband;
	
	@Column(name="NILAI_PADUAN_SUARA")
	private String nilaiPaduanSuara;
	
	@Column(name="NILAI_DRUMBAND")
	private String nilaiFutsal;
	
	@Column(name="NILAI_BEATBOX")
	private String nilaiBeatbox;
	
	@Column(name="NILAITAEKWONDO")
	private String nilaiTaekwondo;

	public Long getIdKegiatan() {
		return idKegiatan;
	}

	public void setIdKegiatan(Long idKegiatan) {
		this.idKegiatan = idKegiatan;
	}

//	public Siswa getSiswa() {
//		return siswa;
//	}
//
//	public void setSiswa(Siswa siswa) {
//		this.siswa = siswa;
//	}

	public String getPramuka() {
		return pramuka;
	}

	public void setPramuka(String pramuka) {
		this.pramuka = pramuka;
	}

	public String getDrumband() {
		return drumband;
	}

	public void setDrumband(String drumband) {
		this.drumband = drumband;
	}

	public String getPaduanSuara() {
		return paduanSuara;
	}

	public void setPaduanSuara(String paduanSuara) {
		this.paduanSuara = paduanSuara;
	}

	public String getFutsal() {
		return futsal;
	}

	public void setFutsal(String futsal) {
		this.futsal = futsal;
	}

	public String getBeatbox() {
		return beatbox;
	}

	public void setBeatbox(String beatbox) {
		this.beatbox = beatbox;
	}

	public String getTaekwondo() {
		return taekwondo;
	}

	public void setTaekwondo(String taekwondo) {
		this.taekwondo = taekwondo;
	}

	public String getNilaiPramuka() {
		return nilaiPramuka;
	}

	public void setNilaiPramuka(String nilaiPramuka) {
		this.nilaiPramuka = nilaiPramuka;
	}

	public String getNilaiDrumband() {
		return nilaiDrumband;
	}

	public void setNilaiDrumband(String nilaiDrumband) {
		this.nilaiDrumband = nilaiDrumband;
	}

	public String getNilaiPaduanSuara() {
		return nilaiPaduanSuara;
	}

	public void setNilaiPaduanSuara(String nilaiPaduanSuara) {
		this.nilaiPaduanSuara = nilaiPaduanSuara;
	}

	public String getNilaiFutsal() {
		return nilaiFutsal;
	}

	public void setNilaiFutsal(String nilaiFutsal) {
		this.nilaiFutsal = nilaiFutsal;
	}

	public String getNilaiBeatbox() {
		return nilaiBeatbox;
	}

	public void setNilaiBeatbox(String nilaiBeatbox) {
		this.nilaiBeatbox = nilaiBeatbox;
	}

	public String getNilaiTaekwondo() {
		return nilaiTaekwondo;
	}

	public void setNilaiTaekwondo(String nilaiTaekwondo) {
		this.nilaiTaekwondo = nilaiTaekwondo;
	}
}