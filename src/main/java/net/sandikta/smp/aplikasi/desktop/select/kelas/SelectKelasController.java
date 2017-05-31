package net.sandikta.smp.aplikasi.desktop.select.kelas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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
		}
	}
}