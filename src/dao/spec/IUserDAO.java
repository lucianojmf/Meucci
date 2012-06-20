package dao.spec;

import dao.DAOException;
import vo.UserVO;


public interface IUserDAO extends IGenericDAO {

    UserVO selectUserByName(String name) throws DAOException;
	
}
