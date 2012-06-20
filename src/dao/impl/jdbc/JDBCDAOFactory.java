package dao.impl.jdbc;

import dao.spec.IContactDAO;
import dao.spec.IPublicContactsDAO;
import dao.spec.IUserDAO;
import java.util.Properties;

import dao.DAOException;
import dao.DAOFactory;
import dao.spec.IAdminDAO;

public class JDBCDAOFactory extends DAOFactory {

    private Properties properties;

    public JDBCDAOFactory(Properties properties) {
        this.properties = properties;
    }

    public IAdminDAO getAdminDAO() throws DAOException {
        return new AdminJDBCDAO(this.properties);
    }

    public IUserDAO getUserDAO() throws DAOException {
        return new UserJDBCDAO(this.properties);
    }

    public IContactDAO getContactDAO() throws DAOException {
        return new ContactJDBCDAO(this.properties);
    }

    public IPublicContactsDAO getPublicContactDAO() throws DAOException {
        return new PublicContactJDBCDAO(this.properties);
    }

}
