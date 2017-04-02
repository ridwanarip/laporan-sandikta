package net.sandikta.smp.aplikasi.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.entities.NilaiMataPelajaran;
import net.sandikta.smp.aplikasi.entities.Siswa;
import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.NamaMataPelajaran;
import net.sandikta.smp.aplikasi.entities.enums.Semester;

public class AppSiswa {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		try {
			Transaction transaction = session.beginTransaction();

			Siswa siswa = new Siswa();
			siswa.setNoInduk(204206);
			siswa.setNama("Kukuh");
			siswa.setKelas(Kelas.IXA);
			siswa.setSemester(Semester.GANJIL);
			siswa.setTahunPelajaran("2015/2016");
			siswa.setAlamat("Griya Limus");
			siswa.getNilaiMatpel().add(tambahNilai1());
			siswa.getNilaiMatpel().add(tambahNilai2());
			

			session.save(siswa);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static NilaiMataPelajaran tambahNilai1() {

		NilaiMataPelajaran nilai = new NilaiMataPelajaran();

		nilai.setNama(NamaMataPelajaran.BAHASA_INGGRIS);
		nilai.setKkm(70);
		nilai.setNilaiAngka(75);
		nilai.setNilaiHuruf(nilai.getNilaiAngka());
		nilai.setKeterangan(70);

		return nilai;
	}

	private static NilaiMataPelajaran tambahNilai2() {

		NilaiMataPelajaran nilai = new NilaiMataPelajaran();

		nilai.setNama(NamaMataPelajaran.BAHASA_INDONESIA);
		nilai.setKkm(70);
		nilai.setNilaiAngka(76);
		nilai.setNilaiHuruf(nilai.getNilaiAngka());
		nilai.setKeterangan(76);

		return nilai;
	}
}