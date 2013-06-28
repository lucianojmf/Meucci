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
import vo.AdminVO;

/**
 *
 * @author luciano
 */
public class IAdminTest {
    
    public IAdminTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of delete method, of class IAdmin.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        IAdmin instance = new IAdminImpl();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class IAdmin.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        AdminVO user = null;
        IAdmin instance = new IAdminImpl();
        instance.create(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IAdmin.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        AdminVO user = null;
        IAdmin instance = new IAdminImpl();
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdmin method, of class IAdmin.
     */
    @Test
    public void testGetAdmin() throws Exception {
        System.out.println("getAdmin");
        int id = 0;
        IAdmin instance = new IAdminImpl();
        AdminVO expResult = null;
        AdminVO result = instance.getAdmin(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class IAdmin.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        IAdmin instance = new IAdminImpl();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdminByLogin method, of class IAdmin.
     */
    @Test
    public void testGetAdminByLogin() throws Exception {
        System.out.println("getAdminByLogin");
        String login = "";
        IAdmin instance = new IAdminImpl();
        AdminVO expResult = null;
        AdminVO result = instance.getAdminByLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of authenticate method, of class IAdmin.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("authenticate");
        AdminVO user = null;
        IAdmin instance = new IAdminImpl();
        boolean expResult = false;
        boolean result = instance.authenticate(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IAdminImpl implements IAdmin {

        public void delete(int id) throws BusinessException {
        }

        public void create(AdminVO user) throws BusinessException {
        }

        public void update(AdminVO user) throws BusinessException {
        }

        public AdminVO getAdmin(int id) throws BusinessException {
            return null;
        }

        public List getAll() throws BusinessException {
            return null;
        }

        public AdminVO getAdminByLogin(String login) throws BusinessException {
            return null;
        }

        public boolean authenticate(AdminVO user) throws BusinessException {
            return false;
        }
    }
}
