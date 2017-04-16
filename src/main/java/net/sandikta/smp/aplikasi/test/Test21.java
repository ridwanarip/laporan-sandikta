package net.sandikta.smp.aplikasi.test;

import net.sandikta.smp.aplikasi.dao.AccountDao2;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class Test21 {

	public static void main(String[] args) {
		
		Dao<UserAccount, Long> userAccount = new AccountDao2();
		
		UserAccount user = userAccount.findByID(Long.parseLong("1"));
		System.out.println("Nama: " + user.getUsername());
	}
}