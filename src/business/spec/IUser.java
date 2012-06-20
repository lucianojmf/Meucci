package business.spec;

import java.util.List;

import vo.UserVO;
import business.BusinessException;

public interface IUser {

	void delete(int id) throws BusinessException;

	void create(UserVO user) throws BusinessException;

	void update(UserVO user) throws BusinessException;

	UserVO getUser(int id) throws BusinessException;

	List getAll() throws BusinessException;

	UserVO getUserByName(String name) throws BusinessException;


}
