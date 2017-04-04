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
import net.sandikta.smp.aplikasi.entities.enums.MataPelajaran;

@Entity
@Table(name="NILAI_SISWA_MATPEL")
public class NilaiSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_NILAI_MATPEL")
	private Long idNilaiMatpel;

	@Column(name="MATA_PELAJARAN")
	@Enumerated(EnumType.STRING)
	private MataPelajaran namaMatpel;

	@Column(name="NILAI_KKM")
	private Integer kkm;

	@Column(name="NILAI_ANGKA")
	private Double nilaiAngka;

	@Column(name="NILAI_HURUF")
	private String nilaiHuruf;

	@Column(name="KETERANGAN")
	@Enumerated(EnumType.STRING)
	private DeskripsiBelajar keterangan;

	public Long getIdNilaiMatpel() {
		return idNilaiMatpel;
	}

	public void setIdNilaiMatpel(Long idNilaiMatpel) {
		this.idNilaiMatpel = idNilaiMatpel;
	}

	public MataPelajaran getNamaPelajaran() {
		return namaMatpel;
	}

	public void setNama(MataPelajaran mataPelajaran) {
		this.namaMatpel = mataPelajaran;
	}

	public int getKkm() {
		return kkm;
	}

	public void setKkm(MataPelajaran mataPelajaran) {
		// this.kkm = kkm;
		try {
			if (this.namaMatpel.equals(mataPelajaran)) {
				this.kkm = mataPelajaran.getNilaiKkm();
			} else {
				throw new Exception("Error set nilai KKM");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Double getNilaiAngka() {
		return nilaiAngka;
	}

	public void setNilaiAngka(Double nilaiSiswa) {
		this.nilaiAngka = nilaiSiswa;
	}

	public String getNilaiHuruf() {
		return nilaiHuruf;
	}

	public void setNilaiHuruf(Double nilaiSiswa) {
		if (nilaiSiswa == 70.5) {
			this.nilaiHuruf = "Tujuh Puluh, Lima";
		} else if (nilaiSiswa == 71) {
			this.nilaiHuruf = "Tujuh Puluh Satu";
		} else if (nilaiSiswa == 71.5) {
			this.nilaiHuruf = "Tujuh Puluh Satu, Lima";
		} else if (nilaiSiswa == 72) {
			this.nilaiHuruf = "Tujuh Puluh Dua";
		} else if (nilaiSiswa == 72.5) {
			this.nilaiHuruf = "Tujuh Puluh Dua, Lima";
		} else if (nilaiSiswa == 73) {
			this.nilaiHuruf = "Tujuh Puluh Tiga";
		} else if (nilaiSiswa == 73.5) {
			this.nilaiHuruf = "Tujuh Puluh Tiga, Lima";
		} else if (nilaiSiswa == 74) {
			this.nilaiHuruf = "Tujuh Puluh Empat";
		} else if (nilaiSiswa == 74.5) {
			this.nilaiHuruf = "Tujuh Puluh Empat,Lima";
		} else if (nilaiSiswa == 75) {
			this.nilaiHuruf = "Tujuh Puluh Lima";
		} else if (nilaiSiswa == 75.5) {
			this.nilaiHuruf = "Tujuh Puluh Lima,Lima";
		} else if (nilaiSiswa == 76) {
			this.nilaiHuruf = "Tujuh Puluh Enam";
		} else if (nilaiSiswa == 76.5) {
			this.nilaiHuruf = "Tujuh Puluh Enam, Lima";
		} else if (nilaiSiswa == 77) {
			this.nilaiHuruf = "Tujuh Puluh Tujuh";
		} else if (nilaiSiswa == 77.5) {
			this.nilaiHuruf = "Tujuh Puluh Tujuh, Lima";
		} else if (nilaiSiswa == 78) {
			this.nilaiHuruf = "Tujuh Puluh Delapan";
		} else if (nilaiSiswa == 78.5) {
			this.nilaiHuruf = "Tujuh Puluh Delapan, Lima";
		} else if (nilaiSiswa == 79) {
			this.nilaiHuruf = "Tujuh Puluh Sembilan";
		} else if (nilaiSiswa == 79.5) {
			this.nilaiHuruf = "Tujuh Puluh Sembilan, Lima";
		} else if (nilaiSiswa == 80) {
			this.nilaiHuruf = "Delapan Puluh";
		}
	}

	public DeskripsiBelajar getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(Integer nilaiKkm) {
		// this.keterangan = DeskripsiBelajar.TUNTAS;
		if (this.nilaiAngka >= nilaiKkm) {
			this.keterangan = DeskripsiBelajar.TUNTAS;
		} else {
			this.keterangan = DeskripsiBelajar.BELUM_TUNTAS;
		}
	}
}