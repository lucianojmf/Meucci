package dao.spec;

import vo.AdminVO;
import dao.DAOException;

public interface IAdminDAO extends IGenericDAO {

	boolean checkLoginPassword(String login, String password)
			throws DAOException;

	AdminVO selectByLogin(String login) throws DAOException;
}
