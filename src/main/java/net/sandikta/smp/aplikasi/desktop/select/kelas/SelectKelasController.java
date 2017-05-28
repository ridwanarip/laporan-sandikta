package net.sandikta.smp.aplikasi.desktop.select.kelas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import net.sandikta.smp.aplikasi.entities.TahunPelajaran;
import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.Semester;

public class SelectKelasController implements Initializable {
	
	private TahunPelajaran tahunPelajaran = 
			new TahunPelajaran();
	
	@FXML
	private Label lblSelectKelas;
	@FXML
	private Label lblPilihKelas;
	@FXML
	private Label lblPilihSemester;
	@FXML
	private ComboBox<Kelas> comboKelas;
	@FXML
	private ComboBox<Semester> comboSemester;
	@FXML
	private Button btnPilih;
	
	private ObservableList<Kelas> listKelas = 
			FXCollections.observableArrayList(Kelas.values());
	private ObservableList<Semester> listSemester = 
			FXCollections.observableArrayList(Semester.values());
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboKelas.setItems(listKelas);
		comboSemester.setItems(listSemester);
	}

	@FXML
	public void comboPilihKelas(ActionEvent event) {
		tahunPelajaran.setKelas(comboKelas.getValue());
	}
	@FXML
	public void comboPilihSemester(ActionEvent event) {
		tahunPelajaran.setSemester(comboSemester.getValue());
	}
	
	@FXML
	public void pilihKelas(ActionEvent event) {
		try {
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Pane root = loader.load(getClass()
					.getResource("ListSiswaKelas.fxml").openStream());
			
			ListSiswaKelasController listSiswa = (ListSiswaKelasController)
					loader.getController();
			listSiswa.setSiswa(tahunPelajaran);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}