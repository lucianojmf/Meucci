package business.impl;

import java.util.List;

import vo.PublicContactsVO;
import business.BusinessException;
import business.BusinessFactory;
import business.spec.IPublicContacts;
import dao.DAOFactory;
import dao.spec.IPublicContactsDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PublicContacts implements IPublicContacts {

    public void delete(int id) throws BusinessException {
                DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            dao.delete(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void create(PublicContactsVO contact) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            contact.setId(dao.selectLastID() + 1);
            dao.insert(contact);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void update(PublicContactsVO contact) throws BusinessException {
         DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            dao.update(contact);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public PublicContactsVO getContact(int id) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            return (PublicContactsVO) dao.selectByID(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List getAll() throws BusinessException {
         DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            return dao.selectAll();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public PublicContactsVO getContactByName(String nameCont) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            return (PublicContactsVO) dao.selectContactByName(nameCont);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
    
    public PublicContactsVO getContactByNumber(String nameCont) throws BusinessException {
        DAOFactory factory = DAOFactory.getInstance();
        try {
            IPublicContactsDAO dao = factory.getPublicContactDAO();
            return (PublicContactsVO) dao.selectContactByNumber(nameCont);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public boolean importContacts(String address) throws BusinessException {
        boolean toReturn = false;
        boolean save = false;
        BusinessFactory factory = BusinessFactory.getInstance();
        File file = new File(address);
        int header_discard = 1;
        
        IPublicContacts contact = factory.getPublicContact();
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
                PublicContactsVO cont = new PublicContactsVO();

                cont.setName(tmp[0]);
                cont.setPhone(tmp[1].replaceAll(" ", "").replaceAll("-", ""));
                cont.setCellphone(tmp[2].replaceAll(" ", "").replaceAll("-", ""));

                
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
