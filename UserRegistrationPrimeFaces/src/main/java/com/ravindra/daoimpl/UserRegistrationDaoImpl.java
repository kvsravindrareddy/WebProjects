package com.ravindra.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ravindra.common.HibernateUtil;
import com.ravindra.controller.UserRegistrationController;
import com.ravindra.dao.UserRegistrationDao;

public class UserRegistrationDaoImpl implements UserRegistrationDao {
	Session session = null;
	Transaction txn = null;
	private static final Logger logger = Logger.getLogger(UserRegistrationDaoImpl.class);
	public void registerIntoDb(UserRegistrationController register) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			logger.debug("*********inside register************");
			txn = session.beginTransaction();
			session.save(register);
			//			session.getTransaction().commit();
			txn.commit();
			logger.debug("********after commit********");
		}catch(Exception e) {
			if(txn!=null) {
				txn.rollback();
				logger.error("Exception occured while begining the transaction : "+e);
			}
		}
		finally {
			session.close();
		}
	}

	@Override
	public Boolean existingUserCheck(String userName) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String hqlQuery = "from UserRegistrationController where user_name='"+userName+"'";
			Query query = session.createQuery(hqlQuery);
			List list = query.list();
			if(list.size()>0) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
	}


	public static void main(String[] args) {
		UserRegistrationDaoImpl obj = new UserRegistrationDaoImpl();
		if(obj.existingUserCheck("kvsravindrareddy.java@gmail.com")) {
			System.out.println("**********true");
		} else {
			System.out.println("**********false");
		}
	}
}
