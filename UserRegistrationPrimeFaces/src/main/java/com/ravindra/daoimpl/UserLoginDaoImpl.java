package com.ravindra.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ravindra.common.HibernateUtil;
import com.ravindra.dao.UserLoginDao;

public class UserLoginDaoImpl implements UserLoginDao {

	public List login(String userName, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = null;
		txn = session.beginTransaction();
		String hqlQuery = "from UserRegistrationController where userName= '"+userName+"' and password= '"+password+"'";
		Query query = session.createQuery(hqlQuery);
//		query.setString("userName", userName);
//		query.setString("password", password);
		List list = query.list();
		return list;
	}
	
	public static void main(String[] args) {
		UserLoginDaoImpl dao = new UserLoginDaoImpl();
		List list = dao.login("kvsravindrareddy@gmail.com", "d35db590fb3a8da40a28dbbe1791033c");
	}
}
