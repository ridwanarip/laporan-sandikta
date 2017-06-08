package net.sandikta.smp.raportapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sandikta.smp.raportapp.entities.enums.NamaAbsensi;

@Entity
<<<<<<< HEAD:src/main/java/net/sandikta/smp/raportapp/entities/AbsensiSiswa.java
@Table(name="NILAI_ABSESNSI")
=======
@Table(name="NILAI_ABSENSI")
>>>>>>> 0ed4dcb4abae2fa82b89e2e1e4a43b9604392b4f:src/main/java/net/sandikta/smp/aplikasi/entities/AbsensiSiswa.java
public class AbsensiSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABSENSI", nullable=false)
	private Long idAbsensi;

	@Column(name="NAMA_ABSENSI", nullable=false)
	@Enumerated(EnumType.STRING)
	private NamaAbsensi namaAbsensi;
	
	@Column(name="JUMLAH")
	private Integer jumlah;

	public Long getIdAbsensi() {
		return idAbsensi;
	}

	public void setIdAbsensi(Long idAbsensi) {
		this.idAbsensi = idAbsensi;
	}

	public NamaAbsensi getNamaAbsensi() {
		return namaAbsensi;
	}

	public void setNamaAbsensi(NamaAbsensi namaAbsensi) {
		this.namaAbsensi = namaAbsensi;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
}