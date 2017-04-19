package net.sandikta.smp.aplikasi.desktop;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.SiswaDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Siswa;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class UserController implements Initializable {
 
	private UserAccount userAccount;
	
	private ObservableList<Siswa> siswaObser;
	
	@FXML
	private Label userLbl;

	@FXML
	private ListView<Siswa> listSiswa;
	
	public UserController() {
		siswaObser = FXCollections.observableArrayList();
		siswaObser.addAll(getAllSiswa());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
				setText(siswa.getIdSiswa() + "\t" + siswa.getNoInduk()
						+ "\t" + siswa.getNama());
			}
		}
	}
	
	public void setUser(UserAccount user) {
		userAccount = user;
		userLbl.setText("Welcome " + userAccount.getGuru().getNik()
				+ " " + userAccount.getGuru().getNama());
	}

	public void signOut(ActionEvent event) {
		try {
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Pane root = loader.load(getClass()
					.getResource("Login.fxml").openStream());
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass()
					.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
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