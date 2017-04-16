package net.sandikta.smp.aplikasi.desktop;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

	public void login(ActionEvent event) {
		// if (txUserName.getText().equals("user")
		// && (txPassowrd.getText().equals("pass"))) {
		// lblStatus.setText("Login Success");
		// } else {
		// lblStatus.setText("Login Failed");
		// }

		// Dao<UserAccount, Long> userAccount = new AccountDao2();
		// List<UserAccount> user = userAccount.findAll();
		// for (UserAccount u : user) {
		// if (txUserName.getText().equals(u.getUsername())
		// && txPassword.getText().equals(u.getPassword())) {
		// lblStatus.setText("Login Success");
		// System.out.println("Sukses");
		// break;
		// } else {
		// lblStatus.setText("Login Gagal");
		// System.out.println("Gagal");
		// }
		// }

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
					break;
				} else {
					lblStatus.setText("Login Failed");
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