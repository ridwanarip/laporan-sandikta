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
import net.sandikta.smp.aplikasi.entities.TahunPelajaran;
import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.MataPelajaran;
import net.sandikta.smp.aplikasi.entities.enums.NamaAbsensi;
import net.sandikta.smp.aplikasi.entities.enums.NamaBudiPekerti;
import net.sandikta.smp.aplikasi.entities.enums.NamaKegiatan;
import net.sandikta.smp.aplikasi.entities.enums.NilaiBudiPekerti;
import net.sandikta.smp.aplikasi.entities.enums.NilaiKegiatan;
import net.sandikta.smp.aplikasi.entities.enums.Semester;

public class AppDaoSiswaInsert {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa, Long> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);

			tx = session.beginTransaction();
			
			Siswa siswa1 = createSiswa1();
			Siswa siswa2 = createSiswa2();
			
			siswa1.getTahunPelajaran().add(getTahunPelajaran1(siswa1));
			siswa2.getTahunPelajaran().add(getTahunPelajaran2(siswa2));
			
			daoSiswa.save(siswa1);
			daoSiswa.save(siswa2);
			
			List<Siswa> sis = daoSiswa.findAll();
			for (Siswa s : sis) {
				System.out.println("\nNama: " + s.getNama());
				
				List<TahunPelajaran> tahunPelajaran = s.getTahunPelajaran();
				for (TahunPelajaran tp : tahunPelajaran) {
					System.out.println("\nTahunPelajaran: " + tp.getTahun());
					System.out.println("\nSemster: " + tp.getSemester());
					
					List<NilaiSiswa> nilaiSiswa = tp.getNilaiMatpel();
					for (NilaiSiswa ns : nilaiSiswa) {
						System.out.println("\tNamaMatpel: " + ns.getNamaPelajaran());
						System.out.println("\tNilai: " + ns.getNilaiAngka());
						System.out.println("\tNilai Huruf: " + ns.getNilaiHuruf());
					}
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
	
	private static Siswa createSiswa2() {
		Siswa siswa = new Siswa();
		siswa.setNoInduk("201312");
		siswa.setNama("Ridwan Arip");
		siswa.setAlamat("Griya Alam");
		return siswa;
	}

	private static Siswa createSiswa1() {
		Siswa siswa = new Siswa();
		siswa.setNoInduk("201314");
		siswa.setNama("Dedi Septiadi");
		siswa.setAlamat("Depok");
		return siswa;
	}

	public static TahunPelajaran getTahunPelajaran1(Siswa siswa) {

		NilaiSiswa nilai1 = new NilaiSiswa();
		nilai1.setNama(MataPelajaran.BAHASA_INDONESIA);
		nilai1.setKkm(MataPelajaran.BAHASA_INDONESIA);
		nilai1.setNilaiAngka((double) 71.5);
		nilai1.setNilaiHuruf((double) 71.5);
		nilai1.setKeterangan(MataPelajaran.BAHASA_INDONESIA.getNilaiKkm());

		NilaiSiswa nilai2 = new NilaiSiswa();
		nilai2.setNama(MataPelajaran.ILMU_PENGETAHUAN_ALAM);
		nilai2.setKkm(MataPelajaran.ILMU_PENGETAHUAN_ALAM);
		nilai2.setNilaiAngka((double) 72);
		nilai2.setNilaiHuruf((double) 72);
		nilai2.setKeterangan(MataPelajaran.ILMU_PENGETAHUAN_ALAM.getNilaiKkm());

		KegiatanSiswa kegiatan1 = new KegiatanSiswa();
		KegiatanSiswa kegiatan2 = new KegiatanSiswa();
		
		kegiatan1.setNamaKegiatan(NamaKegiatan.PRAMUKA);
		kegiatan1.setNilaiKegiatan(NilaiKegiatan.B);
		kegiatan2.setNamaKegiatan(NamaKegiatan.FUTSAL);
		kegiatan2.setNilaiKegiatan(NilaiKegiatan.A);

		AbsensiSiswa ijin = new AbsensiSiswa();
		AbsensiSiswa sakit = new AbsensiSiswa();
		AbsensiSiswa alpha = new AbsensiSiswa();
		
		ijin.setNamaAbsensi(NamaAbsensi.IZIN);
		ijin.setJumlah(2);
		sakit.setNamaAbsensi(NamaAbsensi.SAKIT);
		sakit.setJumlah(3);
		alpha.setNamaAbsensi(NamaAbsensi.TANPA_KETERANGAN);
		alpha.setJumlah(2);

		BudiPekertiSiswa akhlak = new BudiPekertiSiswa();
		BudiPekertiSiswa kepribadian = new BudiPekertiSiswa();

		akhlak.setNamaBudiPekerti(NamaBudiPekerti.AKHLAK);
		akhlak.setNilaiBudiPekerti(NilaiBudiPekerti.BAIK);
		kepribadian.setNamaBudiPekerti(NamaBudiPekerti.KEPRIBADIAN);
		kepribadian.setNilaiBudiPekerti(NilaiBudiPekerti.SANGAT_BAIK);

		TahunPelajaran tahunPelajaran = new TahunPelajaran();
		tahunPelajaran.setSiswa(siswa);
		tahunPelajaran.setTahun("2016/2017");
		tahunPelajaran.setKelas(Kelas.VIIA);
		tahunPelajaran.setSemester(Semester.GANJIL);
		tahunPelajaran.getNilaiMatpel().add(nilai1);
		tahunPelajaran.getNilaiMatpel().add(nilai2);
		tahunPelajaran.getKegiatan().add(kegiatan1);
		tahunPelajaran.getKegiatan().add(kegiatan2);
		tahunPelajaran.getAbsensi().add(ijin);
		tahunPelajaran.getAbsensi().add(sakit);
		tahunPelajaran.getAbsensi().add(alpha);
		tahunPelajaran.getBudiPekerti().add(akhlak);
		tahunPelajaran.getBudiPekerti().add(kepribadian);
		
		return tahunPelajaran;
	}
	
	public static TahunPelajaran getTahunPelajaran2(Siswa siswa) {

		NilaiSiswa nilai1 = new NilaiSiswa();
		nilai1.setNama(MataPelajaran.BAHASA_INGGRIS);
		nilai1.setKkm(MataPelajaran.BAHASA_INGGRIS);
		nilai1.setNilaiAngka((double) 72);
		nilai1.setNilaiHuruf((double) 72);
		nilai1.setKeterangan(MataPelajaran.BAHASA_INGGRIS.getNilaiKkm());

		NilaiSiswa nilai2 = new NilaiSiswa();
		nilai2.setNama(MataPelajaran.MATEMATIKA);
		nilai2.setKkm(MataPelajaran.MATEMATIKA);
		nilai2.setNilaiAngka((double) 73);
		nilai2.setNilaiHuruf((double) 73);
		nilai2.setKeterangan(MataPelajaran.MATEMATIKA.getNilaiKkm());

		KegiatanSiswa kegiatan1 = new KegiatanSiswa();
		KegiatanSiswa kegiatan2 = new KegiatanSiswa();
		
		kegiatan1.setNamaKegiatan(NamaKegiatan.PRAMUKA);
		kegiatan1.setNilaiKegiatan(NilaiKegiatan.B);
		kegiatan2.setNamaKegiatan(NamaKegiatan.DRUMBAND);
		kegiatan2.setNilaiKegiatan(NilaiKegiatan.A);

		AbsensiSiswa ijin = new AbsensiSiswa();
		AbsensiSiswa sakit = new AbsensiSiswa();
		AbsensiSiswa alpha = new AbsensiSiswa();
		
		ijin.setNamaAbsensi(NamaAbsensi.IZIN);
		ijin.setJumlah(2);
		sakit.setNamaAbsensi(NamaAbsensi.SAKIT);
		sakit.setJumlah(1);
		alpha.setNamaAbsensi(NamaAbsensi.TANPA_KETERANGAN);
		alpha.setJumlah(2);

		BudiPekertiSiswa akhlak = new BudiPekertiSiswa();
		BudiPekertiSiswa kepribadian = new BudiPekertiSiswa();

		akhlak.setNamaBudiPekerti(NamaBudiPekerti.AKHLAK);
		akhlak.setNilaiBudiPekerti(NilaiBudiPekerti.BAIK);
		kepribadian.setNamaBudiPekerti(NamaBudiPekerti.KEPRIBADIAN);
		kepribadian.setNilaiBudiPekerti(NilaiBudiPekerti.SANGAT_BAIK);

		TahunPelajaran tahunPelajaran = new TahunPelajaran();
		tahunPelajaran.setSiswa(siswa);
		tahunPelajaran.setTahun("2016/2017");
		tahunPelajaran.setKelas(Kelas.VIIA);
		tahunPelajaran.setSemester(Semester.GANJIL);
		tahunPelajaran.getNilaiMatpel().add(nilai1);
		tahunPelajaran.getNilaiMatpel().add(nilai2);
		tahunPelajaran.getKegiatan().add(kegiatan1);
		tahunPelajaran.getKegiatan().add(kegiatan2);
		tahunPelajaran.getAbsensi().add(ijin);
		tahunPelajaran.getAbsensi().add(sakit);
		tahunPelajaran.getAbsensi().add(alpha);
		tahunPelajaran.getBudiPekerti().add(akhlak);
		tahunPelajaran.getBudiPekerti().add(kepribadian);
		
		return tahunPelajaran;
	}
}