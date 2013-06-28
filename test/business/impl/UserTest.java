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
import vo.UserVO;

/**
 *
 * @author luciano
 */
public class UserTest {
    
    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class User.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        User instance = new User();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class User.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        UserVO user = null;
        User instance = new User();
        instance.create(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class User.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        UserVO user = null;
        User instance = new User();
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class User.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        int id = 0;
        User instance = new User();
        UserVO expResult = null;
        UserVO result = instance.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class User.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        User instance = new User();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByName method, of class User.
     */
    @Test
    public void testGetUserByName() throws Exception {
        System.out.println("getUserByName");
        String name = "";
        User instance = new User();
        UserVO expResult = null;
        UserVO result = instance.getUserByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
