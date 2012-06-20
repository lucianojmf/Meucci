package dao.spec;

import dao.DAOException;
import vo.PublicContactsVO;



public interface IPublicContactsDAO extends IGenericDAO {

   PublicContactsVO selectContactByName(String contName) throws DAOException;
   
   PublicContactsVO selectContactByNumber(String contNumber) throws DAOException;

	
}
