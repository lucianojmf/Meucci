/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.spec;

import business.BusinessException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vo.ContactVO;

/**
 *
 * @author luciano
 */
public class IContactTest {
    
    public IContactTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class IContact.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        IContact instance = new IContactImpl();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class IContact.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ContactVO contact = null;
        IContact instance = new IContactImpl();
        instance.create(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IContact.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ContactVO contact = null;
        IContact instance = new IContactImpl();
        instance.update(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class IContact.
     */
    @Test
    public void testGetContact() throws Exception {
        System.out.println("getContact");
        int id = 0;
        IContact instance = new IContactImpl();
        ContactVO expResult = null;
        ContactVO result = instance.getContact(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class IContact.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        IContact instance = new IContactImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByName method, of class IContact.
     */
    @Test
    public void testGetContactByName() throws Exception {
        System.out.println("getContactByName");
        String nameCont = "";
        IContact instance = new IContactImpl();
        ContactVO expResult = null;
        ContactVO result = instance.getContactByName(nameCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByNumber method, of class IContact.
     */
    @Test
    public void testGetContactByNumber() throws Exception {
        System.out.println("getContactByNumber");
        String numberCont = "";
        IContact instance = new IContactImpl();
        ContactVO expResult = null;
        ContactVO result = instance.getContactByNumber(numberCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByUser method, of class IContact.
     */
    @Test
    public void testGetContactByUser() throws Exception {
        System.out.println("getContactByUser");
        int idUser = 0;
        IContact instance = new IContactImpl();
        List expResult = null;
        List result = instance.getContactByUser(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of importContacts method, of class IContact.
     */
    @Test
    public void testImportContacts() throws Exception {
        System.out.println("importContacts");
        String address = "";
        int id_user = 0;
        IContact instance = new IContactImpl();
        boolean expResult = false;
        boolean result = instance.importContacts(address, id_user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IContactImpl implements IContact {

        public void delete(int id) throws BusinessException {
        }

        public void create(ContactVO contact) throws BusinessException {
        }

        public void update(ContactVO contact) throws BusinessException {
        }

        public ContactVO getContact(int id) throws BusinessException {
            return null;
        }

        public List getAll() throws BusinessException {
            return null;
        }

        public ContactVO getContactByName(String nameCont) throws BusinessException {
            return null;
        }

        public ContactVO getContactByNumber(String numberCont) throws BusinessException {
            return null;
        }

        public List<ContactVO> getContactByUser(int idUser) throws BusinessException {
            return null;
        }

        public boolean importContacts(String address, int id_user) throws BusinessException {
            return false;
        }
    }
}
