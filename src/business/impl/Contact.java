package business.impl;

import java.util.List;

import vo.ContactVO;
import business.BusinessException;
import business.BusinessFactory;
import business.spec.IContact;
import dao.DAOFactory;
import dao.spec.IContactDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Contact implements IContact {

    public void delete(int id) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            dao.delete(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void create(ContactVO contact) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            contact.setId(dao.selectLastID() + 1);
            dao.insert(contact);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void update(ContactVO contact) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            dao.update(contact);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public ContactVO getContact(int id) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            return (ContactVO) dao.selectByID(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List getAll() throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            return dao.selectAll();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public ContactVO getContactByName(String nameCont) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            return (ContactVO) dao.selectContactByName(nameCont);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public ContactVO getContactByNumber(String numberCont) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            return (ContactVO) dao.selectContactByNumber(numberCont);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List<ContactVO> getContactByUser(int idUser) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IContactDAO dao = factory.getContactDAO();
            return dao.selectContactByUser(idUser);

        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public boolean importContacts(String address, int id_user) throws BusinessException {
        boolean toReturn = false;
        boolean save = false;
        BusinessFactory factory = BusinessFactory.getInstance();
        File file = new File(address);
        int header_discard = 1;

        IContact contact = factory.getContact();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);

            String string;
            String tmp[];

            //Ignore header lines
            for (int i = 0; i < header_discard; i++) {
                in.readLine();
            }

            //Reading and insertion lines in NumberCalledVO object list
            while ((string = in.readLine()) != null) {
                save = false;
                //Regular expression to split
                tmp = string.split("\\,");
                ContactVO cont = new ContactVO();

                cont.setName(tmp[0]);
                cont.setPhone(tmp[1].replaceAll(" ", "").replaceAll("-", ""));
                cont.setCellphone(tmp[2].replaceAll(" ", "").replaceAll("-", ""));
                cont.setUser_id(id_user);

                System.out.print(cont.getName() + "   ");
                System.out.print(cont.getPhone() + "   ");
                System.out.println(cont.getCellphone());

                if (!cont.getPhone().isEmpty()) {
                    if (contact.getContactByNumber(cont.getPhone()) == null) {
                        save = true;
                    }
                } else if (!cont.getCellphone().isEmpty()) {
                    if (contact.getContactByNumber(cont.getCellphone()) == null) {
                        save = true;
                    }
                }


                if (save) {
                    contact.create(cont);
                }

            }
            in.close();
            toReturn = true;
        } catch (Exception e) {
            System.out.println(e);
            toReturn = false;
        }

        return toReturn;
    }
}
