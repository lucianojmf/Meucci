package business.impl;

import java.util.List;

import vo.AdminVO;
import business.BusinessException;
import business.spec.IAdmin;
import dao.DAOFactory;
import dao.spec.IAdminDAO;

public class Admin implements IAdmin {

	public void delete(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			dao.delete(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void create(AdminVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			user.setId(dao.selectLastID() + 1);
			dao.insert(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(AdminVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			dao.update(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public AdminVO getAdmin(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			return (AdminVO) dao.selectByID(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public AdminVO getAdminByLogin(String login) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			return (AdminVO) dao.selectByLogin(login);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public boolean authenticate(AdminVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IAdminDAO dao = factory.getAdminDAO();
			return dao.checkLoginPassword(user.getLogin(), user.getPassword());
		} catch (Exception e) {
                    e.printStackTrace();
			throw new BusinessException(e);
		}
	}
}
