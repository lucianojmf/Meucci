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
import vo.AdminVO;

/**
 *
 * @author luciano
 */
public class AdminTest {
    
    public AdminTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of create method, of class Admin.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        AdminVO user = new AdminVO("teste", "teste");
        Admin instance = new Admin();
        instance.create(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of delete method, of class Admin.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 1;
        Admin instance = new Admin();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

    /**
     * Test of update method, of class Admin.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        Admin instance = new Admin();
        AdminVO user = instance.getAdmin(1);
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdmin method, of class Admin.
     */
    @Test
    public void testGetAdmin() throws Exception {
        System.out.println("getAdmin");
        int id = 0;
        Admin instance = new Admin();
        AdminVO expResult = null;
        AdminVO result = instance.getAdmin(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Admin.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        Admin instance = new Admin();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdminByLogin method, of class Admin.
     */
    @Test
    public void testGetAdminByLogin() throws Exception {
        System.out.println("getAdminByLogin");
        String login = "teste";
        Admin instance = new Admin();
        AdminVO expResult = instance.getAdmin(1);
        AdminVO result = instance.getAdminByLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of authenticate method, of class Admin.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("authenticate");
        
        Admin instance = new Admin();
        AdminVO user = instance.getAdmin(1);
        boolean expResult = false;
        boolean result = instance.authenticate(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
