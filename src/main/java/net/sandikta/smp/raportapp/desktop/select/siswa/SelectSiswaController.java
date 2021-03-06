package net.sandikta.smp.raportapp.desktop.select.siswa;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.raportapp.dao.HibernateUtil;
import net.sandikta.smp.raportapp.dao.TahunPelajaranDao;
import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.entities.Siswa;
import net.sandikta.smp.raportapp.entities.TahunPelajaran;
import net.sandikta.smp.raportapp.export.SaveSiswaPdf;

public class SelectSiswaController implements Initializable {
	
	private Siswa siswa = new Siswa();
	private ObservableList<TahunPelajaran> tahunPelajaranObser = 
			FXCollections.observableArrayList();;
	
	@FXML
	private Label lblSelectSiswa;
	@FXML
	private ListView<TahunPelajaran> listTahunPelajaranSiswa;
	@FXML
	private Button btnInsertTahunPelajaranSiswa;
	@FXML
	private Button btnSaveTahunPelajaranSiswa;
	@FXML
	private Button btnDeleteTahuPelajaranSiswa;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listTahunPelajaranSiswa.setItems(tahunPelajaranObser);
		listTahunPelajaranSiswa.setCellFactory(new Callback<ListView<TahunPelajaran>, 
				ListCell<TahunPelajaran>>() {
			@Override
			public ListCell<TahunPelajaran> call(ListView<TahunPelajaran> param) {
				return new TahunPelajaranListViewCell();
			}
		});
	}
	
	static class TahunPelajaranListViewCell extends ListCell<TahunPelajaran> {
		@Override
		protected void updateItem(TahunPelajaran tahunPelajaran, boolean empty) {
			super.updateItem(tahunPelajaran, empty);
			if (tahunPelajaran != null) {
				setText(tahunPelajaran.getSiswa().getNama() + "\t\t" +
						tahunPelajaran.getKelas() + "\t\t" + 
						tahunPelajaran.getSemester() + "\t\t" + 
						tahunPelajaran.getTahun());
			}
		}
	}

	public void setSiswa(Siswa sis) {
		this.siswa = sis;
		this.tahunPelajaranObser.addAll(getAllTahunPelajaranId(sis.getIdSiswa()));
		this.lblSelectSiswa.setText("Data " + siswa.getNama());
	}
	
	private List<TahunPelajaran> getAllTahunPelajaranId(Long idSiswa) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
			daoTahunPelajaran.setSession(session);
			
			List<TahunPelajaran> tahunPelajaran = ((TahunPelajaranDao) 
					daoTahunPelajaran).findAllById(idSiswa);
			return tahunPelajaran;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	@FXML
	public void insertTahunPelajaranSiswa(ActionEvent event) {
		try {
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass()
					.getResource("InsertTahunPelajaran.fxml").openStream());
			
			InsertTahunPelajaranController insertTahunPelajar = (InsertTahunPelajaranController)
					loader.getController();
			insertTahunPelajar.setSiswa(siswa);
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
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
	
	@FXML
	public void savePdfTahunPelajaranSiswa(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			int selectTahunPelajaran = listTahunPelajaranSiswa.getSelectionModel().
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
	
	@FXML
	public void deleteTahunPelajaranSiswa(ActionEvent event) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Apakah Anda yaking menghapus data ini?");
			
			int selectTahunPelajaran = listTahunPelajaranSiswa.getSelectionModel().
					getSelectedIndex();
			TahunPelajaran tp = tahunPelajaranObser.get(selectTahunPelajaran);
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				sessionFactory = HibernateUtil.getSessionFactory();
				session = sessionFactory.openSession();
				Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
				daoTahunPelajaran.setSession(session);
				
				transaction = session.beginTransaction();
				daoTahunPelajaran.delete(tp);
				transaction.commit();
				
				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setTitle("Information Dialog");
				alert1.setHeaderText("Data telah berhasil dihapus!");
				alert1.showAndWait();
			}
			
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
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}