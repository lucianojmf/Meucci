package dao.spec;

import dao.DAOException;
import java.util.List;
import vo.ContactVO;



public interface IContactDAO extends IGenericDAO {

    List<ContactVO> selectContactByUser(int id) throws DAOException;
    ContactVO selectContactByName(String contName) throws DAOException;
    ContactVO selectContactByNumber(String contNumber) throws DAOException;
	
}
