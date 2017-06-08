package net.sandikta.smp.raportapp.desktop;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.raportapp.dao.HibernateUtil;
import net.sandikta.smp.raportapp.dao.SiswaDao;
import net.sandikta.smp.raportapp.dao.interfaces.Dao;
import net.sandikta.smp.raportapp.desktop.select.siswa.SelectSiswaController;
import net.sandikta.smp.raportapp.entities.Siswa;

public class MenuController implements Initializable {
 
	private ObservableList<Siswa> siswaObser =
			FXCollections.observableArrayList();
	
	@FXML
	private Label lblUser;
	@FXML
	private ListView<Siswa> listSiswa;
	@FXML
	private TextField txCariSiswa;
	@FXML
	private Button btnCariSiswa;
	@FXML
	private Button btnRefreshSiswa;
	@FXML
	private Button btnInsertSiswa;
	@FXML
	private Button btnSelectKelas;
	@FXML
	private Button btnSelectSiswa;
	@FXML
	private Button btnDeleteSiswa;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		siswaObser.addAll(getAllSiswa());
		listSiswa.setItems(siswaObser);
		listSiswa.setCellFactory(new Callback<ListView<Siswa>, ListCell<Siswa>>() {
			@Override
			public ListCell<Siswa> call(ListView<Siswa> param) {
				return new SiswaListViewCell();
			}
		});
	}
	
	static class SiswaListViewCell extends ListCell<Siswa> {
		@Override
		protected void updateItem(Siswa siswa, boolean empty) {
			super.updateItem(siswa, empty);
			if (siswa != null) {
				setText(siswa.getNoInduk()
						+ "\t\t" + siswa.getNama()
						+ "\t\t" + siswa.getAlamat());
			}
		}
	}
	
	@FXML
	public void cariSiswa(ActionEvent event) {
		Siswa siswa = new Siswa();
		for (Siswa s : siswaObser) {
			if (s.getNoInduk().equalsIgnoreCase(txCariSiswa.getText())) {
				System.out.println("\nNama: " + s.getNama());
				siswa = s;
			}
		}
		siswaObser.clear();
		siswaObser.add(siswa);
		listSiswa.refresh();
	}
	
	@FXML
	public void refreshSiswa(ActionEvent event) {
		siswaObser.clear();
		siswaObser.addAll(getAllSiswa());
		listSiswa.refresh();
	}
	
	@FXML
	public void insertSiswa(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Pane root = loader.load(getClass()
					.getResource("insert/InsertSiswa.fxml").openStream());
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
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
	
	@FXML
	public void selectKelas(ActionEvent event) {
		try { 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Pane root = loader.load(getClass()
					.getResource("select/kelas/SelectKelas.fxml").openStream());
			
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
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
	
	@FXML
	public void selectSiswa(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass()
					.getResource("select/siswa/SelectSiswa.fxml").openStream());
			SelectSiswaController selectSiswaController = (SelectSiswaController)
					loader.getController();
			
			int selectSiswa = listSiswa.getSelectionModel().getSelectedIndex();
			Siswa siswaSelect = siswaObser.get(selectSiswa);
			selectSiswaController.setSiswa(siswaSelect);
			
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
	public void deleteSiswa(ActionEvent event) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Apakah Anda yakin ingin menghapus data ini?");
			
			int selectSiswa = listSiswa.getSelectionModel().getSelectedIndex();
			Siswa siswaSelect = siswaObser.get(selectSiswa);
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				sessionFactory = HibernateUtil.getSessionFactory();
				session = sessionFactory.openSession();
				Dao<Siswa, Long> daoSiswa = new SiswaDao();
				daoSiswa.setSession(session);
				
				transaction = session.beginTransaction();
				daoSiswa.delete(siswaSelect);
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

	private List<Siswa> getAllSiswa() {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa, Long> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);
			
			List<Siswa> siswa = daoSiswa.findAll();
			return siswa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}