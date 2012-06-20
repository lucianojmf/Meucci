package business.impl;

import java.util.List;

import vo.UserVO;
import business.BusinessException;
;
import business.spec.IUser;
import dao.DAOFactory;
import dao.spec.IUserDAO;


public class User implements IUser {

    public void delete(int id) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IUserDAO dao = factory.getUserDAO();
            dao.delete(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void create(UserVO user) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IUserDAO dao = factory.getUserDAO();
            user.setId(dao.selectLastID() + 1);
            dao.insert(user);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void update(UserVO user) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IUserDAO dao = factory.getUserDAO();
            dao.update(user);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public UserVO getUser(int id) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IUserDAO dao = factory.getUserDAO();
            return (UserVO) dao.selectByID(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List getAll() throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IUserDAO dao = factory.getUserDAO();
            return dao.selectAll();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public UserVO getUserByName(String name) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IUserDAO dao = factory.getUserDAO();
            return (UserVO) dao.selectUserByName(name);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

  
}
