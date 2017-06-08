package net.sandikta.smp.raportapp.desktop.select.siswa;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import net.sandikta.smp.raportapp.dao.HibernateUtil;
import net.sandikta.smp.raportapp.dao.TahunPelajaranDao;
import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.entities.AbsensiSiswa;
import net.sandikta.smp.raportapp.entities.BudiPekertiSiswa;
import net.sandikta.smp.raportapp.entities.KegiatanSiswa;
import net.sandikta.smp.raportapp.entities.NilaiSiswa;
import net.sandikta.smp.raportapp.entities.Siswa;
import net.sandikta.smp.raportapp.entities.TahunPelajaran;
import net.sandikta.smp.raportapp.entities.enums.Kelas;
import net.sandikta.smp.raportapp.entities.enums.MataPelajaran;
import net.sandikta.smp.raportapp.entities.enums.NamaAbsensi;
import net.sandikta.smp.raportapp.entities.enums.NamaBudiPekerti;
import net.sandikta.smp.raportapp.entities.enums.NamaKegiatan;
import net.sandikta.smp.raportapp.entities.enums.NilaiBudiPekerti;
import net.sandikta.smp.raportapp.entities.enums.NilaiKegiatan;
import net.sandikta.smp.raportapp.entities.enums.Semester;

public class InsertTahunPelajaranController implements Initializable {
	
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
	private NilaiSiswa nilaiSiswa13 = new NilaiSiswa();
	
	private KegiatanSiswa kegiatanSiswa1 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa2 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa3 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa4 = new KegiatanSiswa();
	private KegiatanSiswa kegiatanSiswa5 = new KegiatanSiswa();
	
	private BudiPekertiSiswa akhlak = new BudiPekertiSiswa();
	private BudiPekertiSiswa kepribadian = new BudiPekertiSiswa();
	
	private AbsensiSiswa sakit = new AbsensiSiswa();
	private AbsensiSiswa izin = new AbsensiSiswa();
	private AbsensiSiswa tanpaKeterangan = new AbsensiSiswa();
	
	public void setSiswa(Siswa sis) {
		this.siswa = sis;
		this.lblNamaSiswa.setText(siswa.getNama());
		this.lblNoIndukSiswa.setText(siswa.getNoInduk());
		this.lblAlamatSiswa.setText(siswa.getAlamat());
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
	private Label lblKkmMataPelajaran1;
	
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
	private TextField txNilaiPelajaran13;
	
	@FXML
	private TextField txNilaiKkm1;
	@FXML
	private TextField txNilaiKkm2;
	@FXML
	private TextField txNilaiKkm3;
	@FXML
	private TextField txNilaiKkm4;
	@FXML
	private TextField txNilaiKkm5;
	@FXML
	private TextField txNilaiKkm6;
	@FXML
	private TextField txNilaiKkm7;
	@FXML
	private TextField txNilaiKkm8;
	@FXML
	private TextField txNilaiKkm9;
	@FXML
	private TextField txNilaiKkm10;
	@FXML
	private TextField txNilaiKkm11;
	@FXML
	private TextField txNilaiKkm12;
	@FXML
	private TextField txNilaiKkm13;
	
	@FXML
	private TextField txMatpel10;
	@FXML
	private TextField txMatpel11;
	@FXML
	private TextField txMatpel12;
	@FXML
	private TextField txMatpel13;

	@FXML
	private ComboBox<MataPelajaran> comboMatpel1;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel2;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel3;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel4;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel5;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel6;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel7;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel8;
	@FXML
	private ComboBox<MataPelajaran> comboMatpel9;
	
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
	
	private ObservableList<Kelas> listKelas = FXCollections.observableArrayList(Kelas.values());
	
	private ObservableList<Semester> listSemester = FXCollections.observableArrayList(Semester.values());
	
	private ObservableList<String> listTahunSiswa = FXCollections.observableArrayList(
			"2015/2016", "2016/2017", "2017/2018", "2018/2019", "2019/2020");
	
	private ObservableList<MataPelajaran> listNamaMataPelajaran = 
			FXCollections.observableArrayList(MataPelajaran.values());
	
	private ObservableList<NilaiKegiatan> listNialiKegiatan = 
			FXCollections.observableArrayList(NilaiKegiatan.values());
	
	private ObservableList<NilaiBudiPekerti> listNilaiKepribadian = 
			FXCollections.observableArrayList(NilaiBudiPekerti.values());
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboKelasSiswa.setItems(listKelas);
		comboSemesterSiswa.setItems(listSemester);
		comboTahunPelajaranSiswa.setItems(listTahunSiswa);
		
		comboMatpel1.setItems(listNamaMataPelajaran);
		comboMatpel2.setItems(listNamaMataPelajaran);
		comboMatpel3.setItems(listNamaMataPelajaran);
		comboMatpel4.setItems(listNamaMataPelajaran);
		comboMatpel5.setItems(listNamaMataPelajaran);
		comboMatpel6.setItems(listNamaMataPelajaran);
		comboMatpel7.setItems(listNamaMataPelajaran);
		comboMatpel8.setItems(listNamaMataPelajaran);
		comboMatpel9.setItems(listNamaMataPelajaran);
		
		comboNilaiKegiatan1.setItems(listNialiKegiatan);
		comboNilaiKegiatan2.setItems(listNialiKegiatan);
		comboNilaiKegiatan3.setItems(listNialiKegiatan);
		comboNilaiKegiatan4.setItems(listNialiKegiatan);
		comboNilaiKegiatan5.setItems(listNialiKegiatan);
		
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
	public void comboTambahMatpel1(ActionEvent event) {
		nilaiSiswa1.setNamaMatpel(comboMatpel1.getValue().toString());
		nilaiSiswa1.setKkm(Integer.parseInt(txNilaiKkm1.getText()));
		nilaiSiswa1.setNilaiAngka(Double.parseDouble(txNilaiPelajaran1.getText()));
		nilaiSiswa1.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran1.getText()));
		nilaiSiswa1.setKeterangan(Integer.parseInt(txNilaiKkm1.getText()));
	}
	
	@FXML
	public void comboTambahMatpel2(ActionEvent event) {
		nilaiSiswa2.setNamaMatpel(comboMatpel2.getValue().toString());
		nilaiSiswa2.setKkm(Integer.parseInt(txNilaiKkm2.getText()));
		nilaiSiswa2.setNilaiAngka(Double.parseDouble(txNilaiPelajaran2.getText()));
		nilaiSiswa2.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran2.getText()));
		nilaiSiswa2.setKeterangan(Integer.parseInt(txNilaiKkm2.getText()));
	}
	
	@FXML
	public void comboTambahMatpel3(ActionEvent event) {
		nilaiSiswa3.setNamaMatpel(comboMatpel3.getValue().toString());
		nilaiSiswa3.setKkm(Integer.parseInt(txNilaiKkm1.getText()));
		nilaiSiswa3.setNilaiAngka(Double.parseDouble(txNilaiPelajaran3.getText()));
		nilaiSiswa3.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran3.getText()));
		nilaiSiswa3.setKeterangan(Integer.parseInt(txNilaiKkm1.getText()));
	}
	
	@FXML
	public void comboTambahMatpel4(ActionEvent event) {
		nilaiSiswa4.setNamaMatpel(comboMatpel4.getValue().toString());
		nilaiSiswa4.setKkm(Integer.parseInt(txNilaiKkm4.getText()));
		nilaiSiswa4.setNilaiAngka(Double.parseDouble(txNilaiPelajaran4.getText()));
		nilaiSiswa4.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran4.getText()));
		nilaiSiswa4.setKeterangan(Integer.parseInt(txNilaiKkm4.getText()));
	}
	
	@FXML
	public void comboTambahMatpel5(ActionEvent event) {
		nilaiSiswa5.setNamaMatpel(comboMatpel5.getValue().toString());
		nilaiSiswa5.setKkm(Integer.parseInt(txNilaiKkm5.getText()));
		nilaiSiswa5.setNilaiAngka(Double.parseDouble(txNilaiPelajaran5.getText()));
		nilaiSiswa5.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran5.getText()));
		nilaiSiswa5.setKeterangan(Integer.parseInt(txNilaiKkm5.getText()));
	}
	
	@FXML
	public void comboTambahMatpel6(ActionEvent event) {
		nilaiSiswa6.setNamaMatpel(comboMatpel6.getValue().toString());
		nilaiSiswa6.setKkm(Integer.parseInt(txNilaiKkm6.getText()));
		nilaiSiswa6.setNilaiAngka(Double.parseDouble(txNilaiPelajaran6.getText()));
		nilaiSiswa6.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran6.getText()));
		nilaiSiswa6.setKeterangan(Integer.parseInt(txNilaiKkm6.getText()));
	}
	
	@FXML
	public void comboTambahMatpel7(ActionEvent event) {
		nilaiSiswa7.setNamaMatpel(comboMatpel7.getValue().toString());
		nilaiSiswa7.setKkm(Integer.parseInt(txNilaiKkm7.getText()));
		nilaiSiswa7.setNilaiAngka(Double.parseDouble(txNilaiPelajaran7.getText()));
		nilaiSiswa7.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran7.getText()));
		nilaiSiswa7.setKeterangan(Integer.parseInt(txNilaiKkm7.getText()));
	}
	
	@FXML
	public void comboTambahMatpel8(ActionEvent event) {
		nilaiSiswa8.setNamaMatpel(comboMatpel8.getValue().toString());
		nilaiSiswa8.setKkm(Integer.parseInt(txNilaiKkm8.getText()));
		nilaiSiswa8.setNilaiAngka(Double.parseDouble(txNilaiPelajaran8.getText()));
		nilaiSiswa8.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran8.getText()));
		nilaiSiswa8.setKeterangan(Integer.parseInt(txNilaiKkm8.getText()));
	}
	
	@FXML
	public void comboTambahMatpel9(ActionEvent event) {
		nilaiSiswa9.setNamaMatpel(comboMatpel9.getValue().toString());
		nilaiSiswa9.setKkm(Integer.parseInt(txNilaiKkm9.getText()));
		nilaiSiswa9.setNilaiAngka(Double.parseDouble(txNilaiPelajaran9.getText()));
		nilaiSiswa9.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran9.getText()));
		nilaiSiswa9.setKeterangan(Integer.parseInt(txNilaiKkm9.getText()));
	}

	private NilaiSiswa getNilai10() {
		NilaiSiswa nilaiSiswa = new NilaiSiswa();
		if (txMatpel10.getText().equals("")) {
			nilaiSiswa.setNamaMatpel(txMatpel10.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran10.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm10.getText().replace("", String.valueOf(0))));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran10.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm10.getText().replace("", String.valueOf(0))));
			return nilaiSiswa;
		} else {
			nilaiSiswa.setNamaMatpel(txMatpel10.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran10.getText()));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm10.getText()));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran10.getText()));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm10.getText()));
			return nilaiSiswa;
		}
	}
	
	private NilaiSiswa getNilai11() {
		NilaiSiswa nilaiSiswa = new NilaiSiswa();
		if (txMatpel11.getText().equals("")) {
			nilaiSiswa.setNamaMatpel(txMatpel11.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran11.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm11.getText().replace("", String.valueOf(0))));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran11.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm11.getText().replace("", String.valueOf(0))));
			return nilaiSiswa;
		} else {
			nilaiSiswa.setNamaMatpel(txMatpel11.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran11.getText()));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm11.getText()));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran11.getText()));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm11.getText()));
			return nilaiSiswa;
		}
	}
	
	private NilaiSiswa getNilai12() {
		NilaiSiswa nilaiSiswa = new NilaiSiswa();
		if (txMatpel12.getText().equals("")) {
			nilaiSiswa.setNamaMatpel(txMatpel12.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran12.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm12.getText().replace("", String.valueOf(0))));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran12.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm12.getText().replace("", String.valueOf(0))));
			return nilaiSiswa;
		} else {
			nilaiSiswa.setNamaMatpel(txMatpel12.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran12.getText()));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm12.getText()));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran12.getText()));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm12.getText()));
			return nilaiSiswa;
		}
	}
	
	private NilaiSiswa getNilai13() {
		NilaiSiswa nilaiSiswa = new NilaiSiswa();
		if (txMatpel13.getText().equals("")) {
			nilaiSiswa.setNamaMatpel(txMatpel13.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran13.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm13.getText().replace("", String.valueOf(0))));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran13.getText().replace("", String.valueOf("0.0"))));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm13.getText().replace("", String.valueOf(0))));
			return nilaiSiswa;
		} else {
			nilaiSiswa.setNamaMatpel(txMatpel13.getText());
			nilaiSiswa.setNilaiAngka(Double.parseDouble(txNilaiPelajaran13.getText()));
			nilaiSiswa.setKkm(Integer.parseInt(txNilaiKkm13.getText()));
			nilaiSiswa.setNilaiHuruf(Double.parseDouble(txNilaiPelajaran13.getText()));
			nilaiSiswa.setKeterangan(Integer.parseInt(txNilaiKkm13.getText()));
			return nilaiSiswa;
		}
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
		kegiatanSiswa5.setNamaKegiatan(NamaKegiatan.Taekwondo);
		kegiatanSiswa5.setNilaiKegiatan(comboNilaiKegiatan5.getValue());
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
		
		nilaiSiswa10 = getNilai10();
		nilaiSiswa11 = getNilai11();
		nilaiSiswa12 = getNilai12();
		nilaiSiswa13 = getNilai13();
		
		List<Double> total = new ArrayList<Double>();
		total.add(nilaiSiswa1.getNilaiAngka());
		total.add(nilaiSiswa2.getNilaiAngka());
		total.add(nilaiSiswa3.getNilaiAngka());
		total.add(nilaiSiswa4.getNilaiAngka());
		total.add(nilaiSiswa5.getNilaiAngka());
		total.add(nilaiSiswa6.getNilaiAngka());
		total.add(nilaiSiswa7.getNilaiAngka());
		total.add(nilaiSiswa8.getNilaiAngka());
		total.add(nilaiSiswa9.getNilaiAngka());
		total.add(nilaiSiswa10.getNilaiAngka());
		total.add(nilaiSiswa11.getNilaiAngka());
		total.add(nilaiSiswa12.getNilaiAngka());
		total.add(nilaiSiswa13.getNilaiAngka());
		
		double totalNilai = 0;
		for (Double d : total) {
			totalNilai += d;
		}
		tahunPelajaran.setTotalNilai(totalNilai);
		
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
		tahunPelajaran.getNilaiMatpel().add(nilaiSiswa13);
		
		tahunPelajaran.getKegiatan().add(kegiatanSiswa1);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa2);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa3);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa4);
		tahunPelajaran.getKegiatan().add(kegiatanSiswa5);
		
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
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Data telah berhasil disimpan!");
			alert.showAndWait();
			((Node) event.getSource()).getScene().getWindow().hide();
		} catch (Exception ex) {
			ex.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("Error!");
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();
			
			Label label = new Label("The exception stacktrace was:");
			
			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);
			
			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			alert.getDialogPane().setExpandableContent(expContent);
			alert.showAndWait();
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}