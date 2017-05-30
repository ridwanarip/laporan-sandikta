package net.sandikta.smp.aplikasi.desktop.select.siswa;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.File;
import java.net.URL;
import java.util.List;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.TahunPelajaranDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.Siswa;
import net.sandikta.smp.aplikasi.entities.TahunPelajaran;
import net.sandikta.smp.aplikasi.export.SaveSiswaPdf;

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
	private Button btnUpdateTahunPelajaranSiswa;
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
			updateTahunPelajaran.setTahun(tp);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@FXML
	public void savePdfTahunPelajaranSiswa(ActionEvent event) {
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
	}
	
	@FXML
	public void deleteTahunPelajaranSiswa(ActionEvent event) {
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