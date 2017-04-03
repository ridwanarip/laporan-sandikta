package net.sandikta.smp.aplikasi.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.entities.AbsensiSiswa;
import net.sandikta.smp.aplikasi.entities.BudiPekertiSiswa;
import net.sandikta.smp.aplikasi.entities.KegiatanSiswa;
import net.sandikta.smp.aplikasi.entities.NilaiSiswa;
import net.sandikta.smp.aplikasi.entities.Siswa;
import net.sandikta.smp.aplikasi.entities.enums.BudiPekerti;
import net.sandikta.smp.aplikasi.entities.enums.Kegiatan;
import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.MataPelajaran;
import net.sandikta.smp.aplikasi.entities.enums.NilaiKegiatan;
import net.sandikta.smp.aplikasi.entities.enums.Semester;

public class AppSiswa {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			
			session.save(getSiswa1());
			session.save(getSiswa2());
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	public static Siswa getSiswa1() {
		
		Siswa siswa = new Siswa();
		siswa.setNoInduk(201312);
		siswa.setNama("Ridwan");
		siswa.setAlamat("Griya Alam");
		siswa.setKelas(Kelas.IXA);
		siswa.setTahunPelajaran("2016/2017");
		siswa.setSemester(Semester.GANJIL);
		
		NilaiSiswa nilai = new NilaiSiswa();
		nilai.setNama(MataPelajaran.BAHASA_INDONESIA);
		nilai.setKkm(MataPelajaran.BAHASA_INDONESIA);
		nilai.setNilaiAngka((double) 71.5);
		nilai.setNilaiHuruf((double) 71.5);
		nilai.setKeterangan(MataPelajaran.BAHASA_INDONESIA.getNilaiKkm());
		
		NilaiSiswa nilai2 = new NilaiSiswa();
		nilai2.setNama(MataPelajaran.ILMU_PENGETAHUAN_ALAM);
		nilai2.setKkm(MataPelajaran.ILMU_PENGETAHUAN_ALAM);
		nilai2.setNilaiAngka((double) 72);
		nilai2.setNilaiHuruf((double) 72);
		nilai2.setKeterangan(MataPelajaran.ILMU_PENGETAHUAN_ALAM.getNilaiKkm());
		
		KegiatanSiswa kegiatan = new KegiatanSiswa();
		kegiatan.setKegiatan(Kegiatan.DRUMBAND);
		kegiatan.setNilai(NilaiKegiatan.B);
		
		AbsensiSiswa absen = new AbsensiSiswa();
		absen.setAlpha(2);
		absen.setIjin(1);
		absen.setSakit(3);
		
		BudiPekertiSiswa budiPekerti = new BudiPekertiSiswa();
		budiPekerti.setAkhlak(BudiPekerti.CUKUP_BAIK);
		budiPekerti.setKepribadian(BudiPekerti.BAIK);
		
		siswa.getNilaiMatpel().add(nilai);
		siswa.getNilaiMatpel().add(nilai2);
		siswa.getKegiatan().add(kegiatan);
		siswa.setAbsensi(absen);
		siswa.setBudiPekerti(budiPekerti);
		
		return siswa;
	}
	
	public static Siswa getSiswa2() {
		
		Siswa siswa = new Siswa();
		siswa.setNoInduk(201313);
		siswa.setNama("Andre");
		siswa.setAlamat("Limus Pratama");
		siswa.setKelas(Kelas.IXA);
		siswa.setTahunPelajaran("2016/2017");
		siswa.setSemester(Semester.GANJIL);
		
		NilaiSiswa nilai = new NilaiSiswa();
		nilai.setNama(MataPelajaran.MATEMATIKA);
		nilai.setKkm(MataPelajaran.MATEMATIKA);
		nilai.setNilaiAngka((double) 72.5);
		nilai.setNilaiHuruf((double) 72.5);
		nilai.setKeterangan(MataPelajaran.MATEMATIKA.getNilaiKkm());
		
		NilaiSiswa nilai2 = new NilaiSiswa();
		nilai2.setNama(MataPelajaran.ILMU_PENGETAHUAN_ALAM);
		nilai2.setKkm(MataPelajaran.ILMU_PENGETAHUAN_ALAM);
		nilai2.setNilaiAngka((double) 72);
		nilai2.setNilaiHuruf((double) 72);
		nilai2.setKeterangan(MataPelajaran.ILMU_PENGETAHUAN_ALAM.getNilaiKkm());
		
		KegiatanSiswa kegiatan = new KegiatanSiswa();
		kegiatan.setKegiatan(Kegiatan.FUTSAL);
		kegiatan.setNilai(NilaiKegiatan.B);
		
		AbsensiSiswa absen = new AbsensiSiswa();
		absen.setAlpha(2);
		absen.setIjin(1);
		absen.setSakit(3);
		
		BudiPekertiSiswa budiPekerti = new BudiPekertiSiswa();
		budiPekerti.setAkhlak(BudiPekerti.CUKUP_BAIK);
		budiPekerti.setKepribadian(BudiPekerti.BAIK);
		
		siswa.getNilaiMatpel().add(nilai);
		siswa.getNilaiMatpel().add(nilai2);
		siswa.getKegiatan().add(kegiatan);
		siswa.setAbsensi(absen);
		siswa.setBudiPekerti(budiPekerti);
		
		return siswa;
	}
}