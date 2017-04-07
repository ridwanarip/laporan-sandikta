package net.sandikta.smp.aplikasi.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.SiswaDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.AbsensiSiswa;
import net.sandikta.smp.aplikasi.entities.BudiPekertiSiswa;
import net.sandikta.smp.aplikasi.entities.KegiatanSiswa;
import net.sandikta.smp.aplikasi.entities.NilaiSiswa;
import net.sandikta.smp.aplikasi.entities.Siswa;

public class AppDaoSiswaSelect {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);

			tx = session.beginTransaction();
			
			List<Siswa> siswa = daoSiswa.findAll();
			for (Siswa s : siswa) {
				System.out.println("\nNO: " + s.getNoInduk());
				System.out.println("Nama: " + s.getNama());
				System.out.println("Alamat: " + s.getAlamat());
				System.out.println("Tahun Ajaran: " + s.getTahunAjaran());
				System.out.println("Kelas: " + s.getKelas());
				System.out.println("Semester: " + s.getSemester());
				
				System.out.println("\nNilai Siswa:");
				List<NilaiSiswa> nilai = s.getNilaiMatpel();
				for (NilaiSiswa n : nilai) {
					System.out.println("\tNama Matpel: " + n.getNamaPelajaran());
					System.out.println("\tNilai KKM: " + n.getKkm());
					System.out.println("\tNilai Angka: " + n.getNilaiAngka());
					System.out.println("\tNilai Huruf: " + n.getNilaiHuruf());
					System.out.println("\tKeterangan: " + n.getKeterangan() + "\n");
				}
				
				System.out.println("\nKegiatan Siswa: ");
				List<KegiatanSiswa> kegiatan = s.getKegiatan();
				for (KegiatanSiswa ks : kegiatan) {
					System.out.println("\tNama: " + ks.getNamaKegiatan());
					System.out.println("\tNilai: " + ks.getNilaiKegiatan() + "\n");
				}
				
				System.out.println("\nBudiPekerti Siswa: ");
				List<BudiPekertiSiswa> budi = s.getBudiPekerti();
				for (BudiPekertiSiswa b : budi) {
					System.out.println("\tNama: " + b.getNamaBudiPekerti());
					System.out.println("\tNilai: " + b.getNilaiBudiPekerti() + "\n");
				}
				
				System.out.println("\nAbsensi Siswa: ");
				List<AbsensiSiswa> absen = s.getAbsensi();
				for (AbsensiSiswa as : absen) {
					System.out.println("\tNama: " + as.getNamaAbsensi());
					System.out.println("\tJumlah: " + as.getJumlah() + "\n");
				}
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}