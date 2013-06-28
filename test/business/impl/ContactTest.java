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
import vo.ContactVO;

/**
 *
 * @author luciano
 */
public class ContactTest {
    
    public ContactTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class Contact.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        Contact instance = new Contact();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Contact.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ContactVO contact = null;
        Contact instance = new Contact();
        instance.create(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Contact.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ContactVO contact = null;
        Contact instance = new Contact();
        instance.update(contact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class Contact.
     */
    @Test
    public void testGetContact() throws Exception {
        System.out.println("getContact");
        int id = 0;
        Contact instance = new Contact();
        ContactVO expResult = null;
        ContactVO result = instance.getContact(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Contact.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        Contact instance = new Contact();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByName method, of class Contact.
     */
    @Test
    public void testGetContactByName() throws Exception {
        System.out.println("getContactByName");
        String nameCont = "";
        Contact instance = new Contact();
        ContactVO expResult = null;
        ContactVO result = instance.getContactByName(nameCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByNumber method, of class Contact.
     */
    @Test
    public void testGetContactByNumber() throws Exception {
        System.out.println("getContactByNumber");
        String numberCont = "";
        Contact instance = new Contact();
        ContactVO expResult = null;
        ContactVO result = instance.getContactByNumber(numberCont);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByUser method, of class Contact.
     */
    @Test
    public void testGetContactByUser() throws Exception {
        System.out.println("getContactByUser");
        int idUser = 0;
        Contact instance = new Contact();
        List expResult = null;
        List result = instance.getContactByUser(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of importContacts method, of class Contact.
     */
    @Test
    public void testImportContacts() throws Exception {
        System.out.println("importContacts");
        String address = "";
        int id_user = 0;
        Contact instance = new Contact();
        boolean expResult = false;
        boolean result = instance.importContacts(address, id_user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
