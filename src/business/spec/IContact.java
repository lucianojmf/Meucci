package business.spec;

import java.util.List;

import vo.ContactVO;
import business.BusinessException;

public interface IContact {

	void delete(int id) throws BusinessException;

	void create(ContactVO contact) throws BusinessException;

	void update(ContactVO contact) throws BusinessException;

	ContactVO getContact(int id) throws BusinessException;

	List getAll() throws BusinessException;

	ContactVO getContactByName(String nameCont) throws BusinessException;
        
        ContactVO getContactByNumber(String numberCont) throws BusinessException;
        
        List<ContactVO> getContactByUser(int idUser) throws BusinessException;
        
        boolean importContacts(String address, int id_user)throws BusinessException;


}
