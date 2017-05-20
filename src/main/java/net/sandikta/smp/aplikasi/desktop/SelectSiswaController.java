package net.sandikta.smp.aplikasi.desktop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.TahunPelajaranDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Siswa;
import net.sandikta.smp.aplikasi.entities.TahunPelajaran;

public class SelectSiswaController implements Initializable {
	
	Siswa siswa = new Siswa();
	TahunPelajaran tahunPelajaran = new TahunPelajaran();
	
	private ObservableList<TahunPelajaran> tahunPelajaranObser = 
			FXCollections.observableArrayList();;
	
	@FXML
	private Label lblTahunPelajaranSiswa;
	@FXML
	private ListView<TahunPelajaran> listTahunPelajaranSiswa;
	@FXML
	private Button btnInsertTahunPelajaranSiswa;
	@FXML
	private Button btnUpdateTahunPelajaranSiswa;
	@FXML
	private Button btnSaveTahunPelajaranSiswa;
	@FXML
	private Button btnHapusTahuPelajaranSiswa;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listTahunPelajaranSiswa.setItems(tahunPelajaranObser);
		listTahunPelajaranSiswa.setCellFactory(new Callback<ListView<TahunPelajaran>, 
				ListCell<TahunPelajaran>>() {
			@Override
			public ListCell<TahunPelajaran> call(ListView<TahunPelajaran> param) {
				return new TahunPelajaranListViewCell(siswa);
			}
		});
	}
	
	static class TahunPelajaranListViewCell extends ListCell<TahunPelajaran> {
		private Siswa siswa;
		public TahunPelajaranListViewCell(Siswa sis) {
			siswa = sis;
		}
		@Override
		protected void updateItem(TahunPelajaran tahunPelajaran, boolean empty) {
			super.updateItem(tahunPelajaran, empty);
			if (tahunPelajaran != null) {
				setText(siswa.getNama() + "\t\t" +tahunPelajaran.getKelas() + "\t\t" + 
						tahunPelajaran.getSemester() + "\t\t" + 
						tahunPelajaran.getTahun());
			}
		}
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa sis) {
		this.siswa = sis;
		this.tahunPelajaran.setSiswa(siswa);
		this.tahunPelajaranObser.addAll(siswa.getTahunPelajaran());
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
			scene.getStylesheets().add(getClass()
					.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void updateTahunPelajaranSiswa(ActionEvent event) {
		try {
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Pane root = loader.load(getClass()
					.getResource("UpdateTahunPelajaran.fxml").openStream());
			
			UpdateTahunPelajaranController updateTahunPelajaran = (UpdateTahunPelajaranController) 
					loader.getController();
			
			int selectTahunPelajaran = listTahunPelajaranSiswa.getSelectionModel().
					getSelectedIndex();
			TahunPelajaran tp = tahunPelajaranObser.get(selectTahunPelajaran);
			tp.setSiswa(siswa);
			updateTahunPelajaran.setInstances(siswa, tp);
			
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
	public void savePdfTahunPelajaranSiswa(ActionEvent event) {
	}
	
	@FXML
	public void hapusTahunPelajaranSiswa(ActionEvent event) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			
			Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
			daoTahunPelajaran.setSession(session);
			
			int selectTahunPelajaran = listTahunPelajaranSiswa.getSelectionModel().
					getSelectedIndex();
			TahunPelajaran tp = tahunPelajaranObser.get(selectTahunPelajaran);
			
			transaction = session.beginTransaction();
			daoTahunPelajaran.delete(tp);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}