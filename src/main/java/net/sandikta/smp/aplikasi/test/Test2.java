package net.sandikta.smp.aplikasi.test;

import java.util.ArrayList;
import java.util.List;

import net.sandikta.smp.aplikasi.dao.AccountDao2;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Guru;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class Test2 {

	public static void main(String[] args) {
		Dao<UserAccount, Long> userAccount = new AccountDao2();
		
		List<UserAccount> user = userAccount.findAll();
		for (UserAccount s : user) {
			System.out.println("\nUsername: " + s.getUsername());
			System.out.println("Passowrd: " + s.getPassword());
			
			List<Guru> guru = new ArrayList<Guru>();
			guru.add(s.getGuru());
			
			System.out.println("\nData Guru:");
			for (Guru g : guru) {
				System.out.println("\tNama: " + g.getNama());
				System.out.println("\tNIK: " + g.getNik());
				System.out.println("\tAlamat: " + g.getAlamat() + "\n");
			}
		}
	}
}