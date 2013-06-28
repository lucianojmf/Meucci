/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

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
public class PublicContactsTest {
    
    public PublicContactsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class PublicContacts.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        PublicContacts instance = new PublicContacts();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PublicContacts.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        PublicContactsVO contact = null;
        PublicContacts instance = new PublicContacts();
        instance.create(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PublicContacts.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PublicContactsVO contact = null;
        PublicContacts instance = new PublicContacts();
        instance.update(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class PublicContacts.
     */
    @Test
    public void testGetContact() throws Exception {
        System.out.println("getContact");
        int id = 0;
        PublicContacts instance = new PublicContacts();
        PublicContactsVO expResult = null;
        PublicContactsVO result = instance.getContact(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class PublicContacts.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        PublicContacts instance = new PublicContacts();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByName method, of class PublicContacts.
     */
    @Test
    public void testGetContactByName() throws Exception {
        System.out.println("getContactByName");
        String nameCont = "";
        PublicContacts instance = new PublicContacts();
        PublicContactsVO expResult = null;
        PublicContactsVO result = instance.getContactByName(nameCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByNumber method, of class PublicContacts.
     */
    @Test
    public void testGetContactByNumber() throws Exception {
        System.out.println("getContactByNumber");
        String nameCont = "";
        PublicContacts instance = new PublicContacts();
        PublicContactsVO expResult = null;
        PublicContactsVO result = instance.getContactByNumber(nameCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of importContacts method, of class PublicContacts.
     */
    @Test
    public void testImportContacts() throws Exception {
        System.out.println("importContacts");
        String address = "";
        PublicContacts instance = new PublicContacts();
        boolean expResult = false;
        boolean result = instance.importContacts(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
