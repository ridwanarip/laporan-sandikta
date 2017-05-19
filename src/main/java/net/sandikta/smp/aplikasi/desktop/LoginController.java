package net.sandikta.smp.aplikasi.desktop;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.sandikta.smp.aplikasi.dao.AccountDao;
import net.sandikta.smp.aplikasi.dao.HibernateUtil;
import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class LoginController {

	@FXML
	private Label lblStatus;

	@FXML
	private TextField txUserName;

	@FXML
	private TextField txPassword;
	
	@FXML
	private Button btnLogin;

	@FXML
	public void login(ActionEvent event) {

		SessionFactory sessionFactory = null;
		Session session = null;

		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Dao<UserAccount, Long> daoAccount = new AccountDao();
			daoAccount.setSession(session);

			List<UserAccount> user = daoAccount.findAll();
			
			for (UserAccount u : user) {
				if (txUserName.getText().equals(u.getUsername())
						&& txPassword.getText()
								.equals(u.getPassword())) {
			
					lblStatus.setText("Login Success");
					System.out.println("Sukses");

					((Node) event.getSource()).getScene().getWindow().hide();
					
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root = loader.load(getClass()
							.getResource("User.fxml").openStream());
					
					MenuController userController = (MenuController) loader.getController();
					userController.setUser(u);
					
					Scene scene = new Scene(root);
					scene.getStylesheets()
							.add(getClass()
									.getResource("application.css")
									.toExternalForm());
					
					primaryStage.setScene(scene);
					primaryStage.show();

					break;
				} else {
					lblStatus.setText("Login Gagal");
					System.out.println("Gagal");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}