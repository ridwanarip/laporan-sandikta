package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sandikta.smp.aplikasi.entities.enums.DeskripsiBelajar;
import net.sandikta.smp.aplikasi.entities.enums.NamaMataPelajaran;

@Entity
@Table(name = "NILAI_MATPEL")
public class NilaiMataPelajaran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATPEL")
	private Integer idPelajaran;

	@Column(name = "NAMA_MATA_PELAJARAN")
	@Enumerated(EnumType.STRING)
	private NamaMataPelajaran nama;

	@Column(name = "NILAI_KKM")
	private Integer kkm;

	@Column(name = "NILAI_ANGKA")
	private Integer nilaiAngka;

	@Column(name = "NILAI_HURUF")
	private String nilaiHuruf;

	@Column(name = "KETERANGAN")
	@Enumerated(EnumType.STRING)
	private DeskripsiBelajar keterangan;

	public Integer getIdPelajaran() {
		return idPelajaran;
	}

	public void setIdPelajaran(Integer idPelajaran) {
		this.idPelajaran = idPelajaran;
	}

	public NamaMataPelajaran getNama() {
		return nama;
	}

	public void setNama(NamaMataPelajaran nama) {
		this.nama = nama;
	}

	public int getKkm() {
		return kkm;
	}

	public void setKkm(int kkm) {
		this.kkm = kkm;
	}

	public int getNilaiAngka() {
		return nilaiAngka;
	}

	public void setNilaiAngka(int nilaiAngka) {
		this.nilaiAngka = nilaiAngka;
	}

	public String getNilaiHuruf() {
		return nilaiHuruf;
	}

	public void setNilaiHuruf(int nilai) {
		if (nilai == 70.5) {
			this.nilaiHuruf = "Tujuh Puluh, Lima";
		} else if (nilai == 71) {
			this.nilaiHuruf = "Tujuh Puluh Satu";
		} else if (nilai == 71.5) {
			this.nilaiHuruf = "Tujuh Puluh Satu, Lima";
		} else if (nilai == 72) {
			this.nilaiHuruf = "Tujuh Puluh Dua";
		} else if (nilai == 72.5) {
			this.nilaiHuruf = "Tujuh Puluh Dua, Lima";
		} else if (nilai == 73) {
			this.nilaiHuruf = "Tujuh Puluh Tiga";
		} else if (nilai == 73.5) {
			this.nilaiHuruf = "Tujuh Puluh Tiga, Lima";
		} else if (nilai == 74) {
			this.nilaiHuruf = "Tujuh Puluh Empat";
		} else if (nilai == 74.5) {
			this.nilaiHuruf = "Tujuh Puluh Empat,Lima";
		} else if (nilai == 75) {
			this.nilaiHuruf = "Tujuh Puluh Lima";
		} else if (nilai == 75.5) {
			this.nilaiHuruf = "Tujuh Puluh Lima,Lima";
		} else if (nilai == 76) {
			this.nilaiHuruf = "Tujuh Puluh Enam";
		} else if (nilai == 76.5) {
			this.nilaiHuruf = "Tujuh Puluh Enam, Lima";
		} else if (nilai == 77) {
			this.nilaiHuruf = "Tujuh Puluh Tujuh";
		} else if (nilai == 77.5) {
			this.nilaiHuruf = "Tujuh Puluh Tujuh, Lima";
		} else if (nilai == 78) {
			this.nilaiHuruf = "Tujuh Puluh Delapan";
		} else if (nilai == 78.5) {
			this.nilaiHuruf = "Tujuh Puluh Delapan, Lima";
		} else if (nilai == 79) {
			this.nilaiHuruf = "Tujuh Puluh Sembilan";
		} else if (nilai == 79.5) {
			this.nilaiHuruf = "Tujuh Puluh Sembilan, Lima";
		} else if (nilai == 80) {
			this.nilaiHuruf = "Delapan Puluh";
		}
	}

	public DeskripsiBelajar getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(Integer nilaiKKM) {
		// this.keterangan = DeskripsiBelajar.TUNTAS;
		if (this.nilaiAngka >= nilaiKKM) {
			this.keterangan = DeskripsiBelajar.TUNTAS;
		} else {
			this.keterangan = DeskripsiBelajar.BELUM_TUNTAS;
		}
	}
}