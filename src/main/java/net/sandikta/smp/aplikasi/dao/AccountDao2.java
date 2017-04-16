package net.sandikta.smp.aplikasi.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.sandikta.smp.aplikasi.dao.interfaces.Dao;
import net.sandikta.smp.aplikasi.entities.UserAccount;

public class AccountDao2 implements Dao<UserAccount, Long> {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	public AccountDao2() {
		sessionFactory = null;
		session = null;
		transaction = null;
	}

	@Override
	public List<UserAccount> findAll() {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			
			CriteriaQuery<UserAccount> cq = session.getCriteriaBuilder()
					.createQuery(UserAccount.class);
			cq.from(UserAccount.class);
			List<UserAccount> account = session.createQuery(cq)
					.getResultList();
			return account;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
//			session.close();
//			sessionFactory.close();
		}
	}

	@Override
	public UserAccount findByID(Long id) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			UserAccount user = session.get(UserAccount.class, id);
			
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void save(UserAccount account) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(account);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void delete(UserAccount account) {
		session.delete(account);
	}

//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//
//	public Session getSession() {
//		return session;
//	}
//
	public void setSession(Session session) {
		this.session = session;
	}
//
//	public Transaction getTransaction() {
//		return transaction;
//	}
//
//	public void setTransaction(Transaction transaction) {
//		this.transaction = transaction;
//	}
}