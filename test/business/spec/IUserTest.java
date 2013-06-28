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
import vo.UserVO;

/**
 *
 * @author luciano
 */
public class IUserTest {
    
    public IUserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class IUser.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        IUser instance = new IUserImpl();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class IUser.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        UserVO user = null;
        IUser instance = new IUserImpl();
        instance.create(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IUser.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        UserVO user = null;
        IUser instance = new IUserImpl();
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class IUser.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        int id = 0;
        IUser instance = new IUserImpl();
        UserVO expResult = null;
        UserVO result = instance.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class IUser.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        IUser instance = new IUserImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByName method, of class IUser.
     */
    @Test
    public void testGetUserByName() throws Exception {
        System.out.println("getUserByName");
        String name = "";
        IUser instance = new IUserImpl();
        UserVO expResult = null;
        UserVO result = instance.getUserByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IUserImpl implements IUser {

        public void delete(int id) throws BusinessException {
        }

        public void create(UserVO user) throws BusinessException {
        }

        public void update(UserVO user) throws BusinessException {
        }

        public UserVO getUser(int id) throws BusinessException {
            return null;
        }

        public List getAll() throws BusinessException {
            return null;
        }

        public UserVO getUserByName(String name) throws BusinessException {
            return null;
        }
    }
}
