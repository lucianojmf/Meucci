package business.spec;

import java.util.List;

import vo.PublicContactsVO;
import business.BusinessException;

public interface IPublicContacts {

	void delete(int id) throws BusinessException;

	void create(PublicContactsVO contact) throws BusinessException;

	void update(PublicContactsVO contact) throws BusinessException;

	PublicContactsVO getContact(int id) throws BusinessException;

	List getAll() throws BusinessException;

	PublicContactsVO getContactByName(String nameCont) throws BusinessException;
        
        PublicContactsVO getContactByNumber(String numberCont) throws BusinessException;
        
        boolean importContacts(String address) throws BusinessException;
        


}
