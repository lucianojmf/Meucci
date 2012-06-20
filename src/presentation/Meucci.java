/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.BusinessFactory;
import business.spec.*;
import java.util.List;
import org.apache.derby.iapi.db.Factory;
import util.Configuration;
import vo.*;


/**
 *
 * @author luciano
 */
public class Meucci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TESTES DE CRUD
        BusinessFactory factory = BusinessFactory.getInstance();
        
        IAdmin admin = factory.getAdmin();
        IUser user = factory.getUser();
        IContact contact = factory.getContact();
        IPublicContacts pubContact = factory.getPublicContact();
        IFatura fat = factory.getFatura();
        
        //AdminVO adminVO = new AdminVO("teste", "teste");
        
        //UserVO userVO = new UserVO("Luciano");
        //user.create(userVO);
        //admin.create(adminVO);
       
        //if(admin.authenticate(adminVO))
            //System.out.println("Logado com Sucesso!!");
        
        /*List<UserVO> list = user.getAll();
        
        UserVO userVO =  user.getUserByName("Luciano");
        System.out.println(userVO.getName());
        System.out.println(userVO.getId());
        
        List<ContactVO> con = contact.getContactByUser(userVO.getId());
        for (ContactVO cont : con) {
            System.out.println(cont.getName());
            contact.update(cont);
            
        }
        //for (UserVO usr : list) {
            //System.out.println(usr.getName());
            
        //}
         * 
         */
        //List<NumberCalledVO> teste = fat.importFat("/home/luciano/Downloads/fatura.csv", 1);

        //fat.calculate(teste, "/home/luciano/Desktop/reportsMeucci/");

        //String header = Configuration.getInstance().getProperty("header_discard");
        //System.out.println(header);
        //System.out.println(contact.getContactByNumber("1634131925").getName());
        
        contact.importContacts("/home/luciano/Downloads/lista.csv", 1);
    }
}
