package net.sandikta.smp.aplikasi.desktop;

import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.SiswaDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Siswa;

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
				setText(siswa.getIdSiswa() + "\t\t" + siswa.getNoInduk()
						+ "\t\t" + siswa.getNama());
			}
		}
	}
	
//	@FXML
//	public void signOut(ActionEvent event) {
//		try {
//			((Node) event.getSource()).getScene().getWindow().hide();
//			Stage primaryStage = new Stage();
//			FXMLLoader loader = new FXMLLoader();
//			
//			Pane root = loader.load(getClass()
//					.getResource("Login.fxml").openStream());
//			
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass()
//					.getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
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
					.getResource("InsertSiswa.fxml").openStream());
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass()
					.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void selectKelas(ActionEvent event) {
		
	}
	
	@FXML
	public void selectSiswa(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Pane root = loader.load(getClass()
					.getResource("SelectSiswa.fxml").openStream());
			
			SelectSiswaController selectSiswaController = (SelectSiswaController)
					loader.getController();
			
			int selectSiswa = listSiswa.getSelectionModel().getSelectedIndex();
			Siswa siswaSelect = siswaObser.get(selectSiswa);
			
			selectSiswaController.setSiswa(siswaSelect);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass()
					.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void deleteSiswa(ActionEvent event) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa, Long> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);
			
			int selectSiswa = listSiswa.getSelectionModel().getSelectedIndex();
			Siswa siswaSelect = siswaObser.get(selectSiswa);
			
			transaction = session.beginTransaction();
			daoSiswa.delete(siswaSelect);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public List<Siswa> getAllSiswa() {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<Siswa, Long> daoSiswa = new SiswaDao();
			daoSiswa.setSession(session);
			
			List<Siswa> siswa = daoSiswa.findAll();
			
			for (Siswa s : siswa) {
				System.out.println("\nID: " + s.getIdSiswa());
				System.out.println("Nama: " + s.getNama());
			}
			return siswa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}