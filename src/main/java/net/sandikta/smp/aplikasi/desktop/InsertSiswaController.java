package net.sandikta.smp.aplikasi.desktop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.ComboBox;
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


public class InsertSiswaController implements Initializable {
	
	private Siswa siswa = new Siswa();
	
	private TahunPelajaran tahunPelajaran = new TahunPelajaran();
	private Kelas kelasSiswa;
	private Semester semesterSiswa;
	private String tahunPelajaranSiswa;
	
	private NilaiSiswa nilaiSiswa1 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa2 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa3 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa4 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa5 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa6 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa7 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa8 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa9 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa10 = new NilaiSiswa();
	private NilaiSiswa nilaiSiswa11 = new NilaiSiswa();
	
	private KegiatanSiswa kegiatanSiswa1 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa2 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa3 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa4 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa5 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa6 = new KegiatanSiswa();
	
	private BudiPekertiSiswa akhlak = new BudiPekertiSiswa();
	private BudiPekertiSiswa kepribadian = new BudiPekertiSiswa();
	
	private AbsensiSiswa sakit = new AbsensiSiswa();
	private AbsensiSiswa izin = new AbsensiSiswa();
	private AbsensiSiswa tanpaKeterangan = new AbsensiSiswa();
	
	@FXML
	private Label lblTambahDataSiswa;
	@FXML
	private TabPane tabPaneSiswa;
	@FXML
	private TextField txNamaSiswa;
	@FXML
	private TextField txNomorInduk;
	@FXML
	private TextField txAlamatSiswa;
	@FXML
	private ComboBox<Kelas> comboKelasSiswa;
	@FXML
	private ComboBox<Semester> comboSemesterSiswa;
	@FXML
	private ComboBox<String> comboTahunPelajaranSiswa;
	
	@FXML
	private Label lblNamaMataPelajaran;
	@FXML
	private Label lblNilaiMataPelajaran;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa1;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa2;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa3;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa4;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa5;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa6;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa7;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa8;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa9;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa10;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpelSiswa11;
	
	@FXML
	private TextField txNilaiSiswa1;
	@FXML
	private TextField txNilaiSiswa2;
	@FXML
	private TextField txNilaiSiswa3;
	@FXML
	private TextField txNilaiSiswa4;
	@FXML
	private TextField txNilaiSiswa5;
	@FXML
	private TextField txNilaiSiswa6;
	@FXML
	private TextField txNilaiSiswa7;
	@FXML
	private TextField txNilaiSiswa8;
	@FXML
	private TextField txNilaiSiswa9;
	@FXML
	private TextField txNilaiSiswa10;
	@FXML
	private TextField txNilaiSiswa11;
	
	@FXML
	private Label lblNamaMataPelajaran1;
	@FXML
	private Label lblNilaiMataPelajaran1;
	@FXML
	private ComboBox<NamaKegiatan> comboNamaKegiatan1;
	@FXML
	private ComboBox<NamaKegiatan> comboNamaKegiatan2;
	@FXML
	private ComboBox<NamaKegiatan> comboNamaKegiatan3;
	@FXML
	private ComboBox<NamaKegiatan> comboNamaKegiatan4;
	@FXML
	private ComboBox<NamaKegiatan> comboNamaKegiatan5;
	@FXML
	private ComboBox<NamaKegiatan> comboNamaKegiatan6;
	@FXML
	private TextField txNilaiKegiatanSiswa1;
	@FXML
	private TextField txNilaiKegiatanSiswa2;
	@FXML
	private TextField txNilaiKegiatanSiswa3;
	@FXML
	private TextField txNilaiKegiatanSiswa4;
	@FXML
	private TextField txNilaiKegiatanSiswa5;
	@FXML
	private TextField txNilaiKegiatanSiswa6;
	
	@FXML
	private ComboBox<NilaiBudiPekerti> comboNilaiKepribadian1;
	@FXML
	private ComboBox<NilaiBudiPekerti> comboNilaiKepribadian2;
	
	@FXML
	private TextField txNilaiAbsenSiswaSakit;
	@FXML
	private TextField txNilaiAbsenSiswaIzin;
	@FXML
	private TextField txNilaiAbsenSiswaTP;
	@FXML
	private Button btnTambahData;
	
	ObservableList<Kelas> listKelas = FXCollections.observableArrayList(
			Kelas.VIIA, Kelas.VIIB, Kelas.VIIC, Kelas.VIIIA, Kelas.VIIIB,
			Kelas.VIIIC, Kelas.IXA, Kelas.IXB, Kelas.VIIIC);
	
	ObservableList<Semester> listSemester = FXCollections.observableArrayList(
			Semester.GANJIL, Semester.GENAP);
	
	ObservableList<String> listTahunSiswa = FXCollections.observableArrayList(
			"2015/2016", "2016/2017", "2017/2018", "2018/2019", "2019/2020");
	
	ObservableList<MataPelajaran> listNamaMataPelajaran = FXCollections.observableArrayList(
			MataPelajaran.BAHASA_INDONESIA, MataPelajaran.BAHASA_INGGRIS, MataPelajaran.BAHASA_SUNDA,
			MataPelajaran.ILMU_PENGETAHUAN_ALAM, MataPelajaran.ILMU_PENGETAHUAN_SOSIAL,
			MataPelajaran.PENDIDIKAN_AGAMA, MataPelajaran.PENDIDIKAN_KEWARGANEGARAAN, 
			MataPelajaran.PENDIDIKAN_LINGKUNGAN_HIDUP, MataPelajaran.PENDIDIKAN_OLAHRAGA_dan_KESEHATAN,
			MataPelajaran.SENI_BUDAYA, MataPelajaran.TEKNOLOGI_INFORMASI_dan_KOMUNIKASI);
	
	ObservableList<NamaKegiatan> listNamaKegiatan = FXCollections.observableArrayList(
			NamaKegiatan.PRAMUKA, NamaKegiatan.DRUMBAND, NamaKegiatan.PADUAN_SUARA,
			NamaKegiatan.FUTSAL, NamaKegiatan.BEATBOX, NamaKegiatan.TAEKWONDO);
	
	ObservableList<NilaiBudiPekerti> listNilaiKepribadian = FXCollections.observableArrayList(
			NilaiBudiPekerti.SANGAT_BAIK, NilaiBudiPekerti.BAIK, NilaiBudiPekerti.CUKUP_BAIK,
			NilaiBudiPekerti.CUKUP);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboKelasSiswa.setItems(listKelas);
		
		comboSemesterSiswa.setItems(listSemester);
		
		comboTahunPelajaranSiswa.setItems(listTahunSiswa);
		
		comboNilaiMatpelSiswa1.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa2.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa3.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa4.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa5.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa6.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa7.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa8.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa9.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa10.setItems(listNamaMataPelajaran);
		comboNilaiMatpelSiswa11.setItems(listNamaMataPelajaran);
		
		comboNamaKegiatan1.setItems(listNamaKegiatan);
		comboNamaKegiatan2.setItems(listNamaKegiatan);
		comboNamaKegiatan3.setItems(listNamaKegiatan);
		comboNamaKegiatan4.setItems(listNamaKegiatan);
		comboNamaKegiatan5.setItems(listNamaKegiatan);
		comboNamaKegiatan6.setItems(listNamaKegiatan);
		
		comboNilaiKepribadian1.setItems(listNilaiKepribadian);
		comboNilaiKepribadian2.setItems(listNilaiKepribadian);
	}

	@FXML
	public void comboTambahKelasSiswa(ActionEvent event) {
		kelasSiswa = comboKelasSiswa.getValue();
	}
	
	@FXML
	public void comboTambahSemesterSiswa(ActionEvent event) {
		semesterSiswa = comboSemesterSiswa.getValue();
	}
	
	@FXML
	public void comboTambahTahunPelajaranSiswa(ActionEvent event) {
		tahunPelajaranSiswa = comboTahunPelajaranSiswa.getValue();
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa1(ActionEvent event) {
		nilaiSiswa1.setNama(comboNilaiMatpelSiswa1.getValue());
		nilaiSiswa1.setKkm(comboNilaiMatpelSiswa1.getValue());
		nilaiSiswa1.setNilaiAngka(Double.parseDouble(txNilaiSiswa1.getText()));
		nilaiSiswa1.setNilaiHuruf(Double.parseDouble(txNilaiSiswa1.getText()));
		nilaiSiswa1.setKeterangan(comboNilaiMatpelSiswa1.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa2(ActionEvent event) {
		nilaiSiswa2.setNama(comboNilaiMatpelSiswa2.getValue());
		nilaiSiswa2.setKkm(comboNilaiMatpelSiswa2.getValue());
		nilaiSiswa2.setNilaiAngka(Double.parseDouble(txNilaiSiswa2.getText()));
		nilaiSiswa2.setNilaiHuruf(Double.parseDouble(txNilaiSiswa2.getText()));
		nilaiSiswa2.setKeterangan(comboNilaiMatpelSiswa2.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa3(ActionEvent event) {
		nilaiSiswa3.setNama(comboNilaiMatpelSiswa3.getValue());
		nilaiSiswa3.setKkm(comboNilaiMatpelSiswa3.getValue());
		nilaiSiswa3.setNilaiAngka(Double.parseDouble(txNilaiSiswa3.getText()));
		nilaiSiswa3.setNilaiHuruf(Double.parseDouble(txNilaiSiswa3.getText()));
		nilaiSiswa3.setKeterangan(comboNilaiMatpelSiswa3.getValue().getNilaiKkm());
	}
	
	public void comboTambahNilaiMatpelSiswa4(ActionEvent event) {
		nilaiSiswa4.setNama(comboNilaiMatpelSiswa4.getValue());
		nilaiSiswa4.setKkm(comboNilaiMatpelSiswa4.getValue());
		nilaiSiswa4.setNilaiAngka(Double.parseDouble(txNilaiSiswa4.getText()));
		nilaiSiswa4.setNilaiHuruf(Double.parseDouble(txNilaiSiswa4.getText()));
		nilaiSiswa4.setKeterangan(comboNilaiMatpelSiswa4.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa5(ActionEvent event) {
		nilaiSiswa5.setNama(comboNilaiMatpelSiswa5.getValue());
		nilaiSiswa5.setKkm(comboNilaiMatpelSiswa5.getValue());
		nilaiSiswa5.setNilaiAngka(Double.parseDouble(txNilaiSiswa5.getText()));
		nilaiSiswa5.setNilaiHuruf(Double.parseDouble(txNilaiSiswa5.getText()));
		nilaiSiswa5.setKeterangan(comboNilaiMatpelSiswa5.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa6(ActionEvent event) {
		nilaiSiswa6.setNama(comboNilaiMatpelSiswa6.getValue());
		nilaiSiswa6.setKkm(comboNilaiMatpelSiswa6.getValue());
		nilaiSiswa6.setNilaiAngka(Double.parseDouble(txNilaiSiswa6.getText()));
		nilaiSiswa6.setNilaiHuruf(Double.parseDouble(txNilaiSiswa6.getText()));
		nilaiSiswa6.setKeterangan(comboNilaiMatpelSiswa6.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa7(ActionEvent event) {
		nilaiSiswa7.setNama(comboNilaiMatpelSiswa7.getValue());
		nilaiSiswa7.setKkm(comboNilaiMatpelSiswa7.getValue());
		nilaiSiswa7.setNilaiAngka(Double.parseDouble(txNilaiSiswa7.getText()));
		nilaiSiswa7.setNilaiHuruf(Double.parseDouble(txNilaiSiswa7.getText()));
		nilaiSiswa7.setKeterangan(comboNilaiMatpelSiswa7.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa8(ActionEvent event) {
		nilaiSiswa8.setNama(comboNilaiMatpelSiswa8.getValue());
		nilaiSiswa8.setKkm(comboNilaiMatpelSiswa8.getValue());
		nilaiSiswa8.setNilaiAngka(Double.parseDouble(txNilaiSiswa8.getText()));
		nilaiSiswa8.setNilaiHuruf(Double.parseDouble(txNilaiSiswa8.getText()));
		nilaiSiswa8.setKeterangan(comboNilaiMatpelSiswa8.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa9(ActionEvent event) {
		nilaiSiswa9.setNama(comboNilaiMatpelSiswa9.getValue());
		nilaiSiswa9.setKkm(comboNilaiMatpelSiswa9.getValue());
		nilaiSiswa9.setNilaiAngka(Double.parseDouble(txNilaiSiswa9.getText()));
		nilaiSiswa9.setNilaiHuruf(Double.parseDouble(txNilaiSiswa9.getText()));
		nilaiSiswa9.setKeterangan(comboNilaiMatpelSiswa9.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa10(ActionEvent event) {
		nilaiSiswa10.setNama(comboNilaiMatpelSiswa10.getValue());
		nilaiSiswa10.setKkm(comboNilaiMatpelSiswa10.getValue());
		nilaiSiswa10.setNilaiAngka(Double.parseDouble(txNilaiSiswa10.getText()));
		nilaiSiswa10.setNilaiHuruf(Double.parseDouble(txNilaiSiswa10.getText()));
		nilaiSiswa10.setKeterangan(comboNilaiMatpelSiswa10.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpelSiswa11(ActionEvent event) {
		nilaiSiswa11.setNama(comboNilaiMatpelSiswa11.getValue());
		nilaiSiswa11.setKkm(comboNilaiMatpelSiswa11.getValue());
		nilaiSiswa11.setNilaiAngka(Double.parseDouble(txNilaiSiswa11.getText()));
		nilaiSiswa11.setNilaiHuruf(Double.parseDouble(txNilaiSiswa11.getText()));
		nilaiSiswa11.setKeterangan(comboNilaiMatpelSiswa11.getValue().getNilaiKkm());
	}
	
	
	@FXML
	public void comboTambahNamaKegiatan1(ActionEvent event) {
		kegiatanSiswa1.setNamaKegiatan(comboNamaKegiatan1.getValue());
		kegiatanSiswa1.setNilaiKegiatan(NilaiKegiatan.valueOf(txNilaiKegiatanSiswa1.getText()));
	}

	@FXML
	public void comboTambahNamaKegiatan2(ActionEvent event) {
		kegiatanSiswa2.setNamaKegiatan(comboNamaKegiatan2.getValue());
		kegiatanSiswa2.setNilaiKegiatan(NilaiKegiatan.valueOf(txNilaiKegiatanSiswa2.getText()));
	}
	
	@FXML
	public void comboTambahNamaKegiatan3(ActionEvent event) {
		kegiatanSiswa3.setNamaKegiatan(comboNamaKegiatan3.getValue());
		kegiatanSiswa3.setNilaiKegiatan(NilaiKegiatan.valueOf(txNilaiKegiatanSiswa3.getText()));
	}
	
	@FXML
	public void comboTambahNamaKegiatan4(ActionEvent event) {
		kegiatanSiswa4.setNamaKegiatan(comboNamaKegiatan4.getValue());
		kegiatanSiswa4.setNilaiKegiatan(NilaiKegiatan.valueOf(txNilaiKegiatanSiswa4.getText()));
	}
	
	@FXML
	public void comboTambahNamaKegiatan5(ActionEvent event) {
		kegiatanSiswa5.setNamaKegiatan(comboNamaKegiatan5.getValue());
		kegiatanSiswa5.setNilaiKegiatan(NilaiKegiatan.valueOf(txNilaiKegiatanSiswa5.getText()));
	}
	
	@FXML
	public void comboTambahNamaKegiatan6(ActionEvent event) {
		kegiatanSiswa6.setNamaKegiatan(comboNamaKegiatan6.getValue());
		kegiatanSiswa6.setNilaiKegiatan(NilaiKegiatan.valueOf(txNilaiKegiatanSiswa6.getText()));
	}
	
	@FXML
	public void comboTambahNilaiKepribadian1(ActionEvent event) {
		akhlak.setNamaBudiPekerti(NamaBudiPekerti.AKHLAK);
		akhlak.setNilaiBudiPekerti(comboNilaiKepribadian1.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKepribadian2(ActionEvent event) {
		kepribadian.setNamaBudiPekerti(NamaBudiPekerti.KEPRIBADIAN);
		kepribadian.setNilaiBudiPekerti(comboNilaiKepribadian2.getValue());
	}
	
	private TahunPelajaran getTahunPelajaran() {

		tahunPelajaran.setKelas(kelasSiswa);
		tahunPelajaran.setSemester(semesterSiswa);
		tahunPelajaran.setTahun(tahunPelajaranSiswa);
		
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa1);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa2);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa3);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa4);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa5);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa6);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa7);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa8);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa9);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa10);
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa11);
		
		tahunPelajaran.getKegiatan().add(kegiatanSiswa1);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa2);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa3);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa4);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa5);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa6);
		
		tahunPelajaran.getBudiPekerti().add(akhlak);
		tahunPelajaran.getBudiPekerti().add(kepribadian);
		
		sakit.setNamaAbsensi(NamaAbsensi.SAKIT);
		sakit.setJumlah(Integer.parseInt(txNilaiAbsenSiswaSakit.getText()));
		izin.setNamaAbsensi(NamaAbsensi.IZIN);
		izin.setJumlah(Integer.parseInt(txNilaiAbsenSiswaIzin.getText()));
		tanpaKeterangan.setNamaAbsensi(NamaAbsensi.TANPA_KETERANGAN);
		tanpaKeterangan.setJumlah(Integer.parseInt(txNilaiAbsenSiswaIzin.getText()));
		
		tahunPelajaran.getAbsensi().add(sakit);
		tahunPelajaran.getAbsensi().add(izin);
		tahunPelajaran.getAbsensi().add(tanpaKeterangan);
		
		return tahunPelajaran;
	}
	
	@FXML
	public void saveSiswa(ActionEvent event) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		siswa.setNama(txNamaSiswa.getText());
		siswa.setNoInduk(txNomorInduk.getText());
		siswa.setAlamat(txAlamatSiswa.getText());
		siswa.getTahunPelajaran().add(getTahunPelajaran());
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa, Long> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);
			
			transaction = session.beginTransaction();
			daoSiswa.save(siswa);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}
