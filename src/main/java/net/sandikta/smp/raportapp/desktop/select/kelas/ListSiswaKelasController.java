package net.sandikta.smp.raportapp.desktop.select.kelas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.raportapp.dao.HibernateUtil;
import net.sandikta.smp.raportapp.dao.TahunPelajaranDao;
import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.entities.TahunPelajaran;
import net.sandikta.smp.raportapp.entities.enums.Kelas;
import net.sandikta.smp.raportapp.entities.enums.Semester;
import net.sandikta.smp.raportapp.export.SaveSiswaPdf;

public class ListSiswaKelasController implements Initializable {
	
	private ObservableList<TahunPelajaran> tahunPelajaranObser = 
			FXCollections.observableArrayList();
	
	@FXML
	private Label lblKelas;
	@FXML
	private Label lblSemester;
	@FXML
	private Label lblTahun;
	@FXML
	private ListView<TahunPelajaran> listSiswa;
	@FXML
	private Button btnSavePdf;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listSiswa.setItems(tahunPelajaranObser);
		listSiswa.setCellFactory(new Callback<ListView<TahunPelajaran>, 
				ListCell<TahunPelajaran>>() {
			@Override
			public ListCell<TahunPelajaran> call(ListView<TahunPelajaran> param) {
				return new KelasListViewCell();
			}
		});
	}
	
	static class KelasListViewCell extends ListCell<TahunPelajaran> {
		@Override
		protected void updateItem(TahunPelajaran tahunPelajaran, boolean empty) {
			super.updateItem(tahunPelajaran, empty);
			if (tahunPelajaran != null) {
				setText(tahunPelajaran.getSiswa().getNoInduk() + "\t" + 
						tahunPelajaran.getSiswa().getNama() + "\t\t"+ 
						tahunPelajaran.getKelas() + "\t\t" + 
						tahunPelajaran.getSemester() + "\t\t" + 
						tahunPelajaran.getTahun());
			}
		}
	}
	
	public void setSiswa(TahunPelajaran tahunPelajaran) {
		this.tahunPelajaranObser.addAll(getAllByTahun(
				tahunPelajaran.getKelas(), tahunPelajaran.getSemester(),
				tahunPelajaran.getTahun()));
		this.lblKelas.setText("Kelas: " + tahunPelajaran.getKelas());
		this.lblSemester.setText("Semester: " + tahunPelajaran.getSemester());
		this.lblTahun.setText("Tahun: " + tahunPelajaran.getTahun());
	}
	
	public List<TahunPelajaran> getAllByTahun(Kelas kelas, Semester sms, String tahun) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
			daoTahunPelajaran.setSession(session);
			
			List<TahunPelajaran> tahunPelajaran = ((TahunPelajaranDao) 
					daoTahunPelajaran).findByTahun(kelas, sms, tahun);
			return tahunPelajaran;
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
			return null;
		} finally {
			session.close();
		}
	}
	
	@FXML
	public void savePdf(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			
			int selectTahunPelajaran = listSiswa.getSelectionModel().
					getSelectedIndex();
			TahunPelajaran tp = tahunPelajaranObser.get(selectTahunPelajaran);
			
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter exfilter = new FileChooser.
					ExtensionFilter("Pdf files (*.pdf)", "*.pdf");
			fileChooser.getExtensionFilters().add(exfilter);
			
			File file = fileChooser.showSaveDialog(primaryStage);
			
			SaveSiswaPdf.saveSiswa(file, tp);
		} catch (Exception ex) {
			ex.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("Error! \nSilahkan pilih list siswa!");
			
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