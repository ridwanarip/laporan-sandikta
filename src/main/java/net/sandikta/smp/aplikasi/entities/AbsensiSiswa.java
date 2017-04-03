package net.sandikta.smp.aplikasi.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AbsensiSiswa {

	@Column(name="SAKIT")
	private Integer sakit;
	
	@Column(name="IJIN")
	private Integer ijin;
	
	@Column(name="TANPA_KETERANGAN")
	private Integer alpha;
	
	public AbsensiSiswa() {
		this.sakit = 0;
		this.ijin = 0;
		this.alpha = 0;
	}

	public Integer getSakit() {
		return sakit;
	}

	public void setSakit(Integer sakit) {
		this.sakit = sakit;
	}

	public Integer getIjin() {
		return ijin;
	}

	public void setIjin(Integer ijin) {
		this.ijin = ijin;
	}

	public Integer getAlpha() {
		return alpha;
	}

	public void setAlpha(Integer alpha) {
		this.alpha = alpha;
	}
}