package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sandikta.smp.aplikasi.entities.enums.NamaBudiPekerti;
import net.sandikta.smp.aplikasi.entities.enums.NilaiBudiPekerti;

@Entity
@Table(name="NILAI_BUDI_PEKERTI")
public class BudiPekertiSiswa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BUDI_PEKERTI")
	private Long idBudiPekerti;
	
	@Column(name="NAMA_BUDI_PEKERTIA")
	@Enumerated(EnumType.STRING)
	private NamaBudiPekerti namaBudiPekerti;

	@Column(name="NILAI_BUDI_PEKERTI")
	@Enumerated(EnumType.STRING)
	private NilaiBudiPekerti nilaiBudiPekerti;

	public Long getIdBudiPekerti() {
		return idBudiPekerti;
	}

	public void setIdBudiPekerti(Long idBudiPekerti) {
		this.idBudiPekerti = idBudiPekerti;
	}

	public NamaBudiPekerti getNamaBudiPekerti() {
		return namaBudiPekerti;
	}

	public void setNamaBudiPekerti(NamaBudiPekerti namaBudiPekerti) {
		this.namaBudiPekerti = namaBudiPekerti;
	}

	public NilaiBudiPekerti getNilaiBudiPekerti() {
		return nilaiBudiPekerti;
	}

	public void setNilaiBudiPekerti(NilaiBudiPekerti nilaiBudiPekerti) {
		this.nilaiBudiPekerti = nilaiBudiPekerti;
	}
}