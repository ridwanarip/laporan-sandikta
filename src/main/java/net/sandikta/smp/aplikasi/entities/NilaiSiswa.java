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

	public void setNamaMatpel(MataPelajaran mataPelajaran) {
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
		
		if (nilaiSiswa == 40) {
			this.nilaiHuruf = "Empat Puluh";
		} else if (nilaiSiswa == 40.5) {
			this.nilaiHuruf = "Empat Puluh, Lima";
		} else if (nilaiSiswa == 41) {
			this.nilaiHuruf = "Empat Puluh Satu";
		} else if (nilaiSiswa == 41.5) {
			this.nilaiHuruf = "Empat Puluh Satu, Lima";
		} else if (nilaiSiswa == 42) {
			this.nilaiHuruf = "Empat Puluh Dua";
		} else if (nilaiSiswa == 42.5) {
			this.nilaiHuruf = "Empat Puluh Dua, Lima";
		} else if (nilaiSiswa == 43) {
			this.nilaiHuruf = "Empat Puluh Tiga";
		} else if (nilaiSiswa == 43.5) {
			this.nilaiHuruf = "Empat Puluh Tiga, Lima";
		} else if (nilaiSiswa == 44) {
			this.nilaiHuruf = "Empat Puluh Empat";
		} else if (nilaiSiswa == 44.5) {
			this.nilaiHuruf = "Empat Puluh Empat, Lima";
		} else if (nilaiSiswa == 45) {
			this.nilaiHuruf = "Empat Puluh Lima";
		} else if (nilaiSiswa == 45.5) {
			this.nilaiHuruf = "Empat Puluh Lima, Lima";
		} else if (nilaiSiswa == 46) {
			this.nilaiHuruf = "Empat Puluh Enam";
		} else if (nilaiSiswa == 46.5) {
			this.nilaiHuruf = "Empat Puluh Enam, Lima";
		} else if (nilaiSiswa == 47) {
			this.nilaiHuruf = "Empat Puluh Tujuh";
		} else if (nilaiSiswa == 47.5) {
			this.nilaiHuruf = "Empat Puluh Tujuh, Lima";
		} else if (nilaiSiswa == 48) {
			this.nilaiHuruf = "Empat Puluh Delapan";
		} else if (nilaiSiswa == 48.5) {
			this.nilaiHuruf = "Empat Puluh Delapan, Lima";
		} else if (nilaiSiswa == 49) {
			this.nilaiHuruf = "Empat Puluh Sembilan";
		} else if (nilaiSiswa == 49.5) {
			this.nilaiHuruf = "Empat Puluh Sembilan, Lima";
		
		} else if (nilaiSiswa == 50) {
			this.nilaiHuruf = "Lima Puluh";
		} else if (nilaiSiswa == 50.5) {
			this.nilaiHuruf = "Lima Puluh, Lima";
		} else if (nilaiSiswa == 51) {
			this.nilaiHuruf = "Lima Puluh Satu";
		} else if (nilaiSiswa == 51.5) {
			this.nilaiHuruf = "Lima Puluh Satu, Lima";
		} else if (nilaiSiswa == 52) {
			this.nilaiHuruf = "Lima Puluh Dua";
		} else if (nilaiSiswa == 52.5) {
			this.nilaiHuruf = "Lima Puluh Dua, Lima";
		} else if (nilaiSiswa == 53) {
			this.nilaiHuruf = "Lima Puluh Tiga";
		} else if (nilaiSiswa == 53.5) {
			this.nilaiHuruf = "Lima Puluh Tiga, Lima";
		} else if (nilaiSiswa == 54) {
			this.nilaiHuruf = "Lima Puluh Empat";
		} else if (nilaiSiswa == 54.5) {
			this.nilaiHuruf = "Lima Puluh Empat, Lima";
		} else if (nilaiSiswa == 55) {
			this.nilaiHuruf = "Lima Puluh Lima";
		} else if (nilaiSiswa == 55.5) {
			this.nilaiHuruf = "Lima Puluh Lima, Lima";
		} else if (nilaiSiswa == 56) {
			this.nilaiHuruf = "Lima Puluh Enam";
		} else if (nilaiSiswa == 56.5) {
			this.nilaiHuruf = "Lima Puluh Enam, Lima";
		} else if (nilaiSiswa == 57) {
			this.nilaiHuruf = "Lima Puluh Tujuh";
		} else if (nilaiSiswa == 57.5) {
			this.nilaiHuruf = "Lima Puluh Tujuh, Lima";
		} else if (nilaiSiswa == 58) {
			this.nilaiHuruf = "Lima Puluh Delapan";
		} else if (nilaiSiswa == 58.5) {
			this.nilaiHuruf = "Lima Puluh Delapan, Lima";
		} else if (nilaiSiswa == 59) {
			this.nilaiHuruf = "Lima Puluh Sembilan";
		} else if (nilaiSiswa == 59.5) {
			this.nilaiHuruf = "Lima Puluh Sembilan, Lima";
		
		} else if (nilaiSiswa == 60) {
			this.nilaiHuruf = "Enam Puluh";
		} else if (nilaiSiswa == 60.5) {
			this.nilaiHuruf = "Enam Puluh, Lima";
		} else if (nilaiSiswa == 61) {
			this.nilaiHuruf = "Enam Puluh Satu";
		} else if (nilaiSiswa == 61.5) {
			this.nilaiHuruf = "Enam Puluh Satu, Lima";
		} else if (nilaiSiswa == 62) {
			this.nilaiHuruf = "Enam Puluh Dua";
		} else if (nilaiSiswa == 62.5) {
			this.nilaiHuruf = "Enam Puluh Dua, Lima";
		} else if (nilaiSiswa == 63) {
			this.nilaiHuruf = "Enam Puluh Tiga";
		} else if (nilaiSiswa == 63.5) {
			this.nilaiHuruf = "Enam Puluh Tiga, Lima";
		} else if (nilaiSiswa == 64) {
			this.nilaiHuruf = "Enam Puluh Empat";
		} else if (nilaiSiswa == 64.5) {
			this.nilaiHuruf = "Enam Puluh Empat, Lima";
		} else if (nilaiSiswa == 65) {
			this.nilaiHuruf = "Enam Puluh Lima";
		} else if (nilaiSiswa == 65.5) {
			this.nilaiHuruf = "Enam Puluh Lima, Lima";
		} else if (nilaiSiswa == 66) {
			this.nilaiHuruf = "Enam Puluh Enam";
		} else if (nilaiSiswa == 66.5) {
			this.nilaiHuruf = "Enam Puluh Enam, Lima";
		} else if (nilaiSiswa == 67) {
			this.nilaiHuruf = "Enam Puluh Tujuh";
		} else if (nilaiSiswa == 67.5) {
			this.nilaiHuruf = "Enam Puluh Tujuh, Lima";
		} else if (nilaiSiswa == 68) {
			this.nilaiHuruf = "Enam Puluh Delapan";
		} else if (nilaiSiswa == 68.5) {
			this.nilaiHuruf = "Enam Puluh Delapan, Lima";
		} else if (nilaiSiswa == 69) {
			this.nilaiHuruf = "Enam Puluh Sembilan";
		} else if (nilaiSiswa == 69.5) {
			this.nilaiHuruf = "Enam Puluh Sembilan, Lima";
		
		} else if (nilaiSiswa == 70) {
			this.nilaiHuruf = "Tujuh Puluh";
		} else if (nilaiSiswa == 70.5) {
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
		} else if (nilaiSiswa == 80.5) {
			this.nilaiHuruf = "Delapan Puluh, Lima";
		} else if (nilaiSiswa == 81) {
			this.nilaiHuruf = "Delapan Puluh Satu";
		} else if (nilaiSiswa == 81.5) {
			this.nilaiHuruf = "Delapan Puluh Satu, Lima";
		} else if (nilaiSiswa == 82) {
			this.nilaiHuruf = "Delapan Puluh Dua";
		} else if (nilaiSiswa == 82.5) {
			this.nilaiHuruf = "Delapan Puluh Dua, Lima";
		} else if (nilaiSiswa == 83) {
			this.nilaiHuruf = "Delapan Puluh Tiga";
		} else if (nilaiSiswa == 83.5) {
			this.nilaiHuruf = "Delapan Puluh Tiga, Lima";
		} else if (nilaiSiswa == 84) {
			this.nilaiHuruf = "Delapan Puluh Empat";
		} else if (nilaiSiswa == 84.5) {
			this.nilaiHuruf = "Delapan Puluh Empat, Lima";
		} else if (nilaiSiswa == 85) {
			this.nilaiHuruf = "Delapan Puluh Lima";
		} else if (nilaiSiswa == 85.5) {
			this.nilaiHuruf = "Delapan Puluh Empat, Lima";
		} else if (nilaiSiswa == 86) {
			this.nilaiHuruf = "Delapan Puluh Enam";
		} else if (nilaiSiswa == 86.5) {
			this.nilaiHuruf = "Delapan Puluh Enam, Lima";
		} else if (nilaiSiswa == 87) {
			this.nilaiHuruf = "Delapan Puluh Tujuh";
		} else if (nilaiSiswa == 87.5) {
			this.nilaiHuruf = "Delapan Puluh Tujuh, Lima";
		} else if (nilaiSiswa == 88) {
			this.nilaiHuruf = "Delapan Puluh Delapan";
		} else if (nilaiSiswa == 88.5) {
			this.nilaiHuruf = "Delapan Puluh Delapan, Lima";
		} else if (nilaiSiswa == 89) {
			this.nilaiHuruf = "Delapan Puluh Sembilan";
		} else if (nilaiSiswa == 89.5) {
			this.nilaiHuruf = "Delapan Puluh Sembilan, Lima";
			
		} else if (nilaiSiswa == 90) {
			this.nilaiHuruf = "Sembilan Puluh";
		} else if (nilaiSiswa == 90.5) {
			this.nilaiHuruf = "Sembilan Puluh, Lima";
		} else if (nilaiSiswa == 91) {
			this.nilaiHuruf = "Sembilan Puluh Satu";
		} else if (nilaiSiswa == 91.5) {
			this.nilaiHuruf = "Sembilan Puluh Satu, Lima";
		} else if (nilaiSiswa == 92) {
			this.nilaiHuruf = "Sembilan Puluh Dua";
		} else if (nilaiSiswa == 92.5) {
			this.nilaiHuruf = "Sembilan Puluh Dua, Lima";
		} else if (nilaiSiswa == 93) {
			this.nilaiHuruf = "Sembilan Puluh Tiga";
		} else if (nilaiSiswa == 93.5) {
			this.nilaiHuruf = "Sembilan Puluh Tiga, Lima";
		} else if (nilaiSiswa == 94) {
			this.nilaiHuruf = "Sembilan Puluh Empat";
		} else if (nilaiSiswa == 94.5) {
			this.nilaiHuruf = "Sembilan Puluh Empat, Lima";
		} else if (nilaiSiswa == 95) {
			this.nilaiHuruf = "Sembilan Puluh Lima";
		} else if (nilaiSiswa == 95.5) {
			this.nilaiHuruf = "Sembilan Puluh Lima, Lima";
		} else if (nilaiSiswa == 96) {
			this.nilaiHuruf = "Sembilan Puluh Enam";
		} else if (nilaiSiswa == 96.5) {
			this.nilaiHuruf = "Sembilan Puluh Enam, Lima";
		} else if (nilaiSiswa == 97) {
			this.nilaiHuruf = "Sembilan Puluh Tujuh";
		} else if (nilaiSiswa == 97.5) {
			this.nilaiHuruf = "Sembilan Puluh Tujuh, Lima";
		} else if (nilaiSiswa == 98) {
			this.nilaiHuruf = "Sembilan Puluh Delapan";
		} else if (nilaiSiswa == 98.5) {
			this.nilaiHuruf = "Sembilan Puluh Delapan, Lima";
		} else if (nilaiSiswa == 99) {
			this.nilaiHuruf = "Sembilan Puluh Sembilan";
		} else if (nilaiSiswa == 99.5) {
			this.nilaiHuruf = "Sembilan Puluh Sembilan, Lima";
		
		} else if (nilaiSiswa == 100) {
			this.nilaiHuruf = "Seratus";
		} else {
			this.nilaiHuruf = "Nilai Tidak Terdaftar";
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