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
import vo.NumberCalledVO;

/**
 *
 * @author luciano
 */
public class FaturaTest {
    
    public FaturaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of importFat method, of class Fatura.
     */
    @Test
    public void testImportFat() throws Exception {
        System.out.println("importFat");
        String address = "";
        int header_discard = 0;
        Fatura instance = new Fatura();
        List expResult = null;
        List result = instance.importFat(address, header_discard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculate method, of class Fatura.
     */
    @Test
    public void testCalculate() throws Exception {
        System.out.println("calculate");
        List<NumberCalledVO> listCalled = null;
        String address = "";
        Fatura instance = new Fatura();
        boolean expResult = false;
        boolean result = instance.calculate(listCalled, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateGenericFiles method, of class Fatura.
     */
    @Test
    public void testGenerateGenericFiles() throws Exception {
        System.out.println("generateGenericFiles");
        String address = "";
        Fatura instance = new Fatura();
        instance.generateGenericFiles(address);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
