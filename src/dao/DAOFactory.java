package dao;

import util.Configuration;
import dao.impl.jdbc.JDBCDAOFactory;
import dao.spec.IAdminDAO;
import dao.spec.IContactDAO;
import dao.spec.IPublicContactsDAO;
import dao.spec.IUserDAO;

abstract public class DAOFactory {

	private static DAOFactory instance = null;

	public static DAOFactory getInstance() {
		if (instance == null) {
			Configuration configuration = Configuration.getInstance();
			String value = configuration.getProperty("dao");
			if (value.equals("JDBC")) {
				instance = new JDBCDAOFactory(configuration.getProperties());
			}
                        System.out.println(instance);
		}
		return instance;
	}
        
	public abstract IAdminDAO getAdminDAO() throws DAOException;
        
        public abstract IUserDAO getUserDAO() throws DAOException;
        
        public abstract IContactDAO getContactDAO() throws DAOException;
        
        public abstract IPublicContactsDAO getPublicContactDAO() throws DAOException;

	
}