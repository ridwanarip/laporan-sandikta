package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import net.sandikta.smp.aplikasi.entities.enums.BudiPekerti;

@Entity
@Table(name="BUDI_PEKERTI_SISWA")
public class BudiPekertiSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BUDI_PEKERTI")
	private Long idBudiPekerti;
	
	@OneToOne(mappedBy="budiPekerti")
	private Siswa siswa;
	
	@Column(name="AKHLAK_SISWA", nullable=false)
	@Enumerated(EnumType.STRING)
	private BudiPekerti akhlak;

	@Column(name="KEPRIBADIAN_SISWA", nullable=false)
	@Enumerated(EnumType.STRING)
	private BudiPekerti kepribadian;

	public Long getIdBudiPekerti() {
		return idBudiPekerti;
	}

	public void setIdBudiPekerti(Long idBudiPekerti) {
		this.idBudiPekerti = idBudiPekerti;
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

	public BudiPekerti getAkhlak() {
		return akhlak;
	}

	public void setAkhlak(BudiPekerti nilaiAkhlak) {
		// this.akhlak = akhlak;
		try {
			this.akhlak = nilaiAkhlak;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BudiPekerti getKepribadian() {
		return kepribadian;
	}

	public void setKepribadian(BudiPekerti nilaiKepribadian) {
		// this.kepribadian = kepribadian;
		try {
			this.kepribadian = nilaiKepribadian;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}