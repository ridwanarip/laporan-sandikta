package net.sandikta.smp.aplikasi.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class AccountDao implements Dao<UserAccount, Long> {

	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<UserAccount> findAll() {
		CriteriaQuery<UserAccount> cq = session.getCriteriaBuilder()
				.createQuery(UserAccount.class);
		cq.from(UserAccount.class);
		
		List<UserAccount> account = session.createQuery(cq).getResultList();
		return account;
	}

	@Override
	public UserAccount findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(UserAccount account) {
		this.session.saveOrUpdate(account);
	}

	@Override
	public void delete(UserAccount account) {
		this.session.delete(account);
	}

}