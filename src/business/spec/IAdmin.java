package business.spec;

import java.util.List;

import vo.AdminVO;
import business.BusinessException;

public interface IAdmin {

	void delete(int id) throws BusinessException;

	void create(AdminVO user) throws BusinessException;

	void update(AdminVO user) throws BusinessException;

	AdminVO getAdmin(int id) throws BusinessException;

	List getAll() throws BusinessException;

	AdminVO getAdminByLogin(String login) throws BusinessException;

	boolean authenticate(AdminVO user) throws BusinessException;

}
