package net.sandikta.smp.aplikasi.desktop.select.kelas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.TahunPelajaranDao;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.TahunPelajaran;
import net.sandikta.smp.aplikasi.entities.enums.Kelas;
import net.sandikta.smp.aplikasi.entities.enums.Semester;
import net.sandikta.smp.aplikasi.export.SaveSiswaPdf;

public class ListSiswaKelasController implements Initializable {
	
	private ObservableList<TahunPelajaran> tahunPelajaranObser = 
			FXCollections.observableArrayList();
	
	@FXML
	private Label lblKelas;
	@FXML
	private Label lblSemester;
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
	
	public void setSiswa(TahunPelajaran tPelajaran) {
		this.tahunPelajaranObser.addAll(getAllByKelasSemester(
				tPelajaran.getKelas(), tPelajaran.getSemester()));
		this.lblKelas.setText("Kelas: " + tPelajaran.getKelas());
		this.lblSemester.setText("Semester: " + tPelajaran.getSemester());
	}
	
	public List<TahunPelajaran> getAllByKelasSemester(Kelas kelas, Semester sms) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<TahunPelajaran, Long> daoTahunPelajaran = new TahunPelajaranDao();
			daoTahunPelajaran.setSession(session);
			
			List<TahunPelajaran> tahunPelajaran = ((TahunPelajaranDao) 
					daoTahunPelajaran).findByKelasSemester(kelas, sms);
			return tahunPelajaran;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	@FXML
	public void savePdf(ActionEvent event) {
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
	}
}