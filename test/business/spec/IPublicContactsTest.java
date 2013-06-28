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
import vo.PublicContactsVO;

/**
 *
 * @author luciano
 */
public class IPublicContactsTest {
    
    public IPublicContactsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class IPublicContacts.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        IPublicContacts instance = new IPublicContactsImpl();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class IPublicContacts.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        PublicContactsVO contact = null;
        IPublicContacts instance = new IPublicContactsImpl();
        instance.create(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IPublicContacts.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PublicContactsVO contact = null;
        IPublicContacts instance = new IPublicContactsImpl();
        instance.update(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class IPublicContacts.
     */
    @Test
    public void testGetContact() throws Exception {
        System.out.println("getContact");
        int id = 0;
        IPublicContacts instance = new IPublicContactsImpl();
        PublicContactsVO expResult = null;
        PublicContactsVO result = instance.getContact(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class IPublicContacts.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        IPublicContacts instance = new IPublicContactsImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByName method, of class IPublicContacts.
     */
    @Test
    public void testGetContactByName() throws Exception {
        System.out.println("getContactByName");
        String nameCont = "";
        IPublicContacts instance = new IPublicContactsImpl();
        PublicContactsVO expResult = null;
        PublicContactsVO result = instance.getContactByName(nameCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByNumber method, of class IPublicContacts.
     */
    @Test
    public void testGetContactByNumber() throws Exception {
        System.out.println("getContactByNumber");
        String numberCont = "";
        IPublicContacts instance = new IPublicContactsImpl();
        PublicContactsVO expResult = null;
        PublicContactsVO result = instance.getContactByNumber(numberCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of importContacts method, of class IPublicContacts.
     */
    @Test
    public void testImportContacts() throws Exception {
        System.out.println("importContacts");
        String address = "";
        IPublicContacts instance = new IPublicContactsImpl();
        boolean expResult = false;
        boolean result = instance.importContacts(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IPublicContactsImpl implements IPublicContacts {

        public void delete(int id) throws BusinessException {
        }

        public void create(PublicContactsVO contact) throws BusinessException {
        }

        public void update(PublicContactsVO contact) throws BusinessException {
        }

        public PublicContactsVO getContact(int id) throws BusinessException {
            return null;
        }

        public List getAll() throws BusinessException {
            return null;
        }

        public PublicContactsVO getContactByName(String nameCont) throws BusinessException {
            return null;
        }

        public PublicContactsVO getContactByNumber(String numberCont) throws BusinessException {
            return null;
        }

        public boolean importContacts(String address) throws BusinessException {
            return false;
        }
    }
}
