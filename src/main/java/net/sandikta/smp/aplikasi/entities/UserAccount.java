package net.sandikta.smp.aplikasi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCOUNT_ID")
	private Long idAccount;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GURU_ID")
	private Guru guru;
	
	@Column(name="USERNAME", nullable=false, length=20)
	private String username;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public Guru getGuru() {
		return guru;
	}

	public void setGuru(Guru guru) {
		this.guru = guru;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}