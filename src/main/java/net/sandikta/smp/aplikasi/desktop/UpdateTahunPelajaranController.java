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
import net.sandikta.smp.aplikasi.dao.TahunPelajaranDao;
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

public class UpdateTahunPelajaranController implements Initializable {
	
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
	private NilaiSiswa nilaiSiswa12 = new NilaiSiswa();
	
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
	
	public void setInstances(Siswa siswa2, TahunPelajaran tp) {
		siswa = siswa2;
		siswa.getTahunPelajaran().add(tp);
		tahunPelajaran = tp;
		tahunPelajaran.setSiswa(siswa2);
		
		lblNamaSiswa.setText(siswa.getNama());
		lblNoIndukSiswa.setText(siswa.getNoInduk());
		lblAlamatSiswa.setText(siswa.getAlamat());
		kelasSiswa = Kelas.valueOf(tahunPelajaran.getKelas().toString());
		semesterSiswa = Semester.valueOf(tahunPelajaran.getSemester().toString());
		tahunPelajaranSiswa = tahunPelajaran.getTahun();
		
//		nilaiSiswa1 = tahunPelajaran.getNilaiMatpel().get(0);
//		txNilaiPelajaran1.setPromptText(String.valueOf(nilaiSiswa1.getNilaiAngka()));
//		nilaiSiswa2 = tahunPelajaran.getNilaiMatpel().get(1);
//		txNilaiPelajaran2.setPromptText(String.valueOf(nilaiSiswa2.getNilaiAngka()));
//		nilaiSiswa3 = tahunPelajaran.getNilaiMatpel().get(2);
//		txNilaiPelajaran3.setPromptText(String.valueOf(nilaiSiswa3.getNilaiAngka()));
//		nilaiSiswa4 = tahunPelajaran.getNilaiMatpel().get(3);
//		txNilaiPelajaran4.setPromptText(String.valueOf(nilaiSiswa4.getNilaiAngka()));
//		nilaiSiswa5 = tahunPelajaran.getNilaiMatpel().get(4);
//		txNilaiPelajaran5.setPromptText(String.valueOf(nilaiSiswa5.getNilaiAngka()));
//		nilaiSiswa6 = tahunPelajaran.getNilaiMatpel().get(5);
//		txNilaiPelajaran6.setPromptText(String.valueOf(nilaiSiswa6.getNilaiAngka()));
//		nilaiSiswa7 = tahunPelajaran.getNilaiMatpel().get(6);
//		txNilaiPelajaran7.setPromptText(String.valueOf(nilaiSiswa7.getNilaiAngka()));
//		nilaiSiswa8 = tahunPelajaran.getNilaiMatpel().get(7);
//		txNilaiPelajaran8.setPromptText(String.valueOf(nilaiSiswa8.getNilaiAngka()));
//		nilaiSiswa9 = tahunPelajaran.getNilaiMatpel().get(8);
//		txNilaiPelajaran9.setPromptText(String.valueOf(nilaiSiswa9.getNilaiAngka()));
//		nilaiSiswa10 = tahunPelajaran.getNilaiMatpel().get(9);
//		txNilaiPelajaran10.setPromptText(String.valueOf(nilaiSiswa10.getNilaiAngka()));
//		nilaiSiswa11 = tahunPelajaran.getNilaiMatpel().get(10);
//		txNilaiPelajaran11.setPromptText(String.valueOf(nilaiSiswa11.getNilaiAngka()));
//		nilaiSiswa12 = tahunPelajaran.getNilaiMatpel().get(11);
//		txNilaiPelajaran12.setPromptText(String.valueOf(nilaiSiswa12.getNilaiAngka()));
	}
	
	@FXML
	private Label lblTambahDataSiswa;
	@FXML
	private TabPane tabPaneSiswa;
	@FXML
	private Label lblNamaSiswa;
	@FXML
	private Label lblNoIndukSiswa;
	@FXML
	private Label lblAlamatSiswa;
	@FXML
	private ComboBox<Kelas> comboKelasSiswa;
	@FXML
	private ComboBox<Semester> comboSemesterSiswa;
	@FXML
	private ComboBox<String> comboTahunPelajaranSiswa;
	
	@FXML
	private Label lblNoNilaiMataPelajaran;
	@FXML
	private Label lblNilaiMataPelajaran;
	@FXML
	private Label lblNamaMataPelajaran;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel1;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel2;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel3;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel4;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel5;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel6;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel7;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel8;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel9;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel10;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel11;
	@FXML
	private ComboBox<MataPelajaran> comboNilaiMatpel12;
	@FXML
	private TextField txNilaiPelajaran1;
	@FXML
	private TextField txNilaiPelajaran2;
	@FXML
	private TextField txNilaiPelajaran3;
	@FXML
	private TextField txNilaiPelajaran4;
	@FXML
	private TextField txNilaiPelajaran5;
	@FXML
	private TextField txNilaiPelajaran6;
	@FXML
	private TextField txNilaiPelajaran7;
	@FXML
	private TextField txNilaiPelajaran8;
	@FXML
	private TextField txNilaiPelajaran9;
	@FXML
	private TextField txNilaiPelajaran10;
	@FXML
	private TextField txNilaiPelajaran11;
	@FXML
	private TextField txNilaiPelajaran12;
	
	@FXML
	private Label lblNamaKegiatan;
	@FXML
	private Label lblNilaiKegiatan;
	@FXML
	private ComboBox<NilaiKegiatan> comboNilaiKegiatan1;
	@FXML
	private ComboBox<NilaiKegiatan> comboNilaiKegiatan2;
	@FXML
	private ComboBox<NilaiKegiatan> comboNilaiKegiatan3;
	@FXML
	private ComboBox<NilaiKegiatan> comboNilaiKegiatan4;
	@FXML
	private ComboBox<NilaiKegiatan> comboNilaiKegiatan5;
	@FXML
	private ComboBox<NilaiKegiatan> comboNilaiKegiatan6;
	
	@FXML
	private ComboBox<NilaiBudiPekerti> comboNilaiKepribadian1;
	@FXML
	private ComboBox<NilaiBudiPekerti> comboNilaiKepribadian2;
	
	@FXML
	private TextField txNilaiAbsenSakit;
	@FXML
	private TextField txNilaiAbsenIzin;
	@FXML
	private TextField txNilaiAbsenTp;
	
	@FXML
	private Button btnTambahData;
	
	ObservableList<Kelas> listKelas = FXCollections.observableArrayList(
			Kelas.VIIA, Kelas.VIIB, Kelas.VIIC, Kelas.VIIIA, Kelas.VIIIB,
			Kelas.VIIIC, Kelas.IXA, Kelas.IXB, Kelas.VIIIC);
	
	ObservableList<Semester> listSemester = FXCollections.observableArrayList(
			Semester.GANJIL, Semester.GENAP);
	
	ObservableList<String> listTahunSiswa = FXCollections.observableArrayList(
			"2015/2016", "2016/2017", "2017/2018", "2018/2019", "2019/2020");
	
	ObservableList<MataPelajaran> listNamaMataPelajaran = FXCollections.observableArrayList(MataPelajaran.values());
	
	ObservableList<NilaiKegiatan> listNialiKegiatan = FXCollections.observableArrayList(
			NilaiKegiatan.A, NilaiKegiatan.B, NilaiKegiatan.C, NilaiKegiatan.KOSONG);
	
	ObservableList<NilaiBudiPekerti> listNilaiKepribadian = FXCollections.observableArrayList(
			NilaiBudiPekerti.Sangat_Baik, NilaiBudiPekerti.Baik, NilaiBudiPekerti.Cukup_Baik,
			NilaiBudiPekerti.Cukup);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboKelasSiswa.setItems(listKelas);
		comboSemesterSiswa.setItems(listSemester);
		comboTahunPelajaranSiswa.setItems(listTahunSiswa);
		
		comboNilaiMatpel1.setItems(listNamaMataPelajaran);
		comboNilaiMatpel2.setItems(listNamaMataPelajaran);
		comboNilaiMatpel3.setItems(listNamaMataPelajaran);
		comboNilaiMatpel4.setItems(listNamaMataPelajaran);
		comboNilaiMatpel5.setItems(listNamaMataPelajaran);
		comboNilaiMatpel6.setItems(listNamaMataPelajaran);
		comboNilaiMatpel7.setItems(listNamaMataPelajaran);
		comboNilaiMatpel8.setItems(listNamaMataPelajaran);
		comboNilaiMatpel9.setItems(listNamaMataPelajaran);
		comboNilaiMatpel10.setItems(listNamaMataPelajaran);
		comboNilaiMatpel11.setItems(listNamaMataPelajaran);
		comboNilaiMatpel12.setItems(listNamaMataPelajaran);
		
		comboNilaiKegiatan1.setItems(listNialiKegiatan);
		comboNilaiKegiatan2.setItems(listNialiKegiatan);
		comboNilaiKegiatan3.setItems(listNialiKegiatan);
		comboNilaiKegiatan4.setItems(listNialiKegiatan);
		comboNilaiKegiatan5.setItems(listNialiKegiatan);
		comboNilaiKegiatan6.setItems(listNialiKegiatan);
		
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
	public void comboTambahNilaiMatpel1(ActionEvent event) {
		nilaiSiswa1.setNamaMatpel(comboNilaiMatpel1.getValue());
		nilaiSiswa1.setKkm(comboNilaiMatpel1.getValue());
		nilaiSiswa1.setNilaiAngka(Double.parseDouble(txNilaiPelajaran1.getText()));
		nilaiSiswa1.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran1.getText()));
		nilaiSiswa1.setKeterangan(comboNilaiMatpel1.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel2(ActionEvent event) {
		nilaiSiswa2.setNamaMatpel(comboNilaiMatpel2.getValue());
		nilaiSiswa2.setKkm(comboNilaiMatpel2.getValue());
		nilaiSiswa2.setNilaiAngka(Double.parseDouble(txNilaiPelajaran2.getText()));
		nilaiSiswa2.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran2.getText()));
		nilaiSiswa2.setKeterangan(comboNilaiMatpel2.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel3(ActionEvent event) {
		nilaiSiswa3.setNamaMatpel(comboNilaiMatpel3.getValue());
		nilaiSiswa3.setKkm(comboNilaiMatpel3.getValue());
		nilaiSiswa3.setNilaiAngka(Double.parseDouble(txNilaiPelajaran3.getText()));
		nilaiSiswa3.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran3.getText()));
		nilaiSiswa3.setKeterangan(comboNilaiMatpel3.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel4(ActionEvent event) {
		nilaiSiswa4.setNamaMatpel(comboNilaiMatpel4.getValue());
		nilaiSiswa4.setKkm(comboNilaiMatpel4.getValue());
		nilaiSiswa4.setNilaiAngka(Double.parseDouble(txNilaiPelajaran4.getText()));
		nilaiSiswa4.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran4.getText()));
		nilaiSiswa4.setKeterangan(comboNilaiMatpel4.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel5(ActionEvent event) {
		nilaiSiswa5.setNamaMatpel(comboNilaiMatpel5.getValue());
		nilaiSiswa5.setKkm(comboNilaiMatpel5.getValue());
		nilaiSiswa5.setNilaiAngka(Double.parseDouble(txNilaiPelajaran5.getText()));
		nilaiSiswa5.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran5.getText()));
		nilaiSiswa5.setKeterangan(comboNilaiMatpel5.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel6(ActionEvent event) {
		nilaiSiswa6.setNamaMatpel(comboNilaiMatpel6.getValue());
		nilaiSiswa6.setKkm(comboNilaiMatpel6.getValue());
		nilaiSiswa6.setNilaiAngka(Double.parseDouble(txNilaiPelajaran6.getText()));
		nilaiSiswa6.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran6.getText()));
		nilaiSiswa6.setKeterangan(comboNilaiMatpel6.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel7(ActionEvent event) {
		nilaiSiswa7.setNamaMatpel(comboNilaiMatpel7.getValue());
		nilaiSiswa7.setKkm(comboNilaiMatpel7.getValue());
		nilaiSiswa7.setNilaiAngka(Double.parseDouble(txNilaiPelajaran7.getText()));
		nilaiSiswa7.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran7.getText()));
		nilaiSiswa7.setKeterangan(comboNilaiMatpel7.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel8(ActionEvent event) {
		nilaiSiswa8.setNamaMatpel(comboNilaiMatpel8.getValue());
		nilaiSiswa8.setKkm(comboNilaiMatpel8.getValue());
		nilaiSiswa8.setNilaiAngka(Double.parseDouble(txNilaiPelajaran8.getText()));
		nilaiSiswa8.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran8.getText()));
		nilaiSiswa8.setKeterangan(comboNilaiMatpel8.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel9(ActionEvent event) {
		nilaiSiswa9.setNamaMatpel(comboNilaiMatpel9.getValue());
		nilaiSiswa9.setKkm(comboNilaiMatpel9.getValue());
		nilaiSiswa9.setNilaiAngka(Double.parseDouble(txNilaiPelajaran9.getText()));
		nilaiSiswa9.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran9.getText()));
		nilaiSiswa9.setKeterangan(comboNilaiMatpel9.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel10(ActionEvent event) {
		nilaiSiswa10.setNamaMatpel(comboNilaiMatpel10.getValue());
		nilaiSiswa10.setKkm(comboNilaiMatpel10.getValue());
		nilaiSiswa10.setNilaiAngka(Double.parseDouble(txNilaiPelajaran10.getText()));
		nilaiSiswa10.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran10.getText()));
		nilaiSiswa10.setKeterangan(comboNilaiMatpel10.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel11(ActionEvent event) {
		nilaiSiswa11.setNamaMatpel(comboNilaiMatpel11.getValue());
		nilaiSiswa11.setKkm(comboNilaiMatpel11.getValue());
		nilaiSiswa11.setNilaiAngka(Double.parseDouble(txNilaiPelajaran11.getText()));
		nilaiSiswa11.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran11.getText()));
		nilaiSiswa11.setKeterangan(comboNilaiMatpel11.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiMatpel12(ActionEvent event) {
		nilaiSiswa12.setNamaMatpel(comboNilaiMatpel12.getValue());
		nilaiSiswa12.setKkm(comboNilaiMatpel12.getValue());
		nilaiSiswa12.setNilaiAngka(Double.parseDouble(txNilaiPelajaran12.getText()));
		nilaiSiswa12.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran12.getText()));
		nilaiSiswa12.setKeterangan(comboNilaiMatpel12.getValue().getNilaiKkm());
	}
	
	@FXML
	public void comboTambahNilaiKegiatan1(ActionEvent event) {
		kegiatanSiswa1.setNamaKegiatan(NamaKegiatan.Pramuka);
		kegiatanSiswa1.setNilaiKegiatan(comboNilaiKegiatan1.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKegiatan2(ActionEvent event) {
		kegiatanSiswa2.setNamaKegiatan(NamaKegiatan.Drumband);
		kegiatanSiswa2.setNilaiKegiatan(comboNilaiKegiatan2.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKegiatan3(ActionEvent event) {
		kegiatanSiswa3.setNamaKegiatan(NamaKegiatan.Paduan_Suara);
		kegiatanSiswa3.setNilaiKegiatan(comboNilaiKegiatan3.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKegiatan4(ActionEvent event) {
		kegiatanSiswa4.setNamaKegiatan(NamaKegiatan.Futsal);
		kegiatanSiswa4.setNilaiKegiatan(comboNilaiKegiatan4.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKegiatan5(ActionEvent event) {
		kegiatanSiswa5.setNamaKegiatan(NamaKegiatan.Beatbox);
		kegiatanSiswa5.setNilaiKegiatan(comboNilaiKegiatan5.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKegiatan6(ActionEvent event) {
		kegiatanSiswa6.setNamaKegiatan(NamaKegiatan.Taekwondo);
		kegiatanSiswa6.setNilaiKegiatan(comboNilaiKegiatan6.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKepribadian1(ActionEvent event) {
		akhlak.setNamaBudiPekerti(NamaBudiPekerti.Akhlak);
		akhlak.setNilaiBudiPekerti(comboNilaiKepribadian1.getValue());
	}
	
	@FXML
	public void comboTambahNilaiKepribadian2(ActionEvent event) {
		kepribadian.setNamaBudiPekerti(NamaBudiPekerti.Kepribadian);
		kepribadian.setNilaiBudiPekerti(comboNilaiKepribadian2.getValue());
	}
	
	private TahunPelajaran getTahunPelajaran() {
		
		TahunPelajaran tahunPelajaran = new TahunPelajaran();
		tahunPelajaran.setSiswa(siswa);

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
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa12);
		
		tahunPelajaran.getKegiatan().add(kegiatanSiswa1);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa2);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa3);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa4);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa5);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa6);
		
		tahunPelajaran.getBudiPekerti().add(akhlak);
		tahunPelajaran.getBudiPekerti().add(kepribadian);
		
		sakit.setNamaAbsensi(NamaAbsensi.Sakit);
		sakit.setJumlah(Integer.parseInt(txNilaiAbsenSakit.getText()));
		izin.setNamaAbsensi(NamaAbsensi.Izin);
		izin.setJumlah(Integer.parseInt(txNilaiAbsenIzin.getText()));
		tanpaKeterangan.setNamaAbsensi(NamaAbsensi.Tanpa_Keterangan);
		tanpaKeterangan.setJumlah(Integer.parseInt(txNilaiAbsenTp.getText()));
		
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
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
			daoTahunPelajaran.setSession(session);
			
			tahunPelajaran = getTahunPelajaran();
			
			transaction = session.beginTransaction();
			daoTahunPelajaran.save(tahunPelajaran);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}