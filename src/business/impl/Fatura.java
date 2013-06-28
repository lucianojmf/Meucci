/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.BusinessException;
import business.BusinessFactory;
import business.spec.IContact;
import business.spec.IFatura;
import business.spec.IPublicContacts;
import business.spec.IUser;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.ContactVO;
import vo.NumberCalledVO;
import vo.PublicContactsVO;
import vo.UserVO;

/**
 *
 * @author luciano
 */
public class Fatura implements IFatura {

    private static BusinessFactory factory = BusinessFactory.getInstance();
    private IUser user = factory.getUser();
    private IContact contact = factory.getContact();
    private IPublicContacts pubCont = factory.getPublicContact();

    public List<NumberCalledVO> importFat(String address, int header_discard) throws BusinessException {

        List<NumberCalledVO> toReturn = new ArrayList<NumberCalledVO>();
        

        File file = new File(address);
        try {
            FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);

            String string;
            String tmp[];
            ContactVO aux;
            PublicContactsVO aux2;
            //Ignore header lines
            for (int i = 0; i < header_discard; i++) {
                in.readLine();
            }

            //Reading and insertion lines in NumberCalledVO object list
            while ((string = in.readLine()) != null) {
                //Regular expression to split
                tmp = string.split("\"\\,\"");
                NumberCalledVO nb = new NumberCalledVO();
                

                nb.setDate(tmp[3].substring(0, 8).replaceAll(" ", ""));
                nb.setNumber(tmp[4].replaceAll(" ", ""));
                nb.setTime(tmp[7].replaceAll(" ", ""));
                nb.setPrice(Float.parseFloat(tmp[13].trim().replaceAll("\"", "")));

                //verify if exists number
                if (!nb.getNumber().isEmpty()) {

                    //verify if is a especific contact
                    if ((aux = contact.getContactByNumber(nb.getNumber())) != null) {
                        nb.setOwner(user.getUser(aux.getUser_id()));
                    } //verify if is a public contact
                    else if ((aux2 = pubCont.getContactByNumber(nb.getNumber())) != null) {
                        nb.setPublicCall(true);
                    }//if not owner, set null
                    else {
                        nb.setOwner(null);
                    }

                } //if don't exists, this is a rate
                else {
                    nb.setRates(true);
                }

                toReturn.add(nb);

            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return toReturn;
    }

    public boolean calculate(List<NumberCalledVO> listCalled, String address) throws BusinessException {

        boolean toReturn = false;
        UserVO usr = new UserVO();                                          //variable auxiliary type user
        List<NumberCalledVO> toRemove = new ArrayList<NumberCalledVO>();    //list to remove founded numbers
        int nUsers = user.getAll().size();                                  //count of users in database
        float sumUsers;                                                     //acumulate the total cost sum for user
        float rates = 0;                                                    //rates
        float sumPublics = 0;                                               //sum of public calls
        float sumNotFoud = 0;                                               //sum of not found calls

        generateGenericFiles(address);
        try {

            FileWriter fileNotFound = new FileWriter(address + "/notFound.txt", true);
            FileWriter filePublic = new FileWriter(address + "/public.txt", true);
            
            //Iterate for all users in database----------------------------------------- 
            for (Object usrObject : user.getAll()) {

                sumUsers = 0;
                usr = (UserVO) usrObject;
                toRemove.clear();

                FileWriter fileUser = new FileWriter(address +"/" +usr.getName());

                fileUser.write("-------------------------------------------------------\n");
                fileUser.write("             LIST FOR : " + usr.getName() + "\n");
                fileUser.write("-------------+------------+---------------+------------\n");
                fileUser.write("   DATE      |    TIME    |    NUMBER     |   PRICE \n");
                fileUser.write("-------------+------------+---------------+------------\n");
                //verify on list calls for this user
                for (NumberCalledVO nb : listCalled) {
                    if (nb.getOwner() != null) {
                        if (nb.getOwner().getId() == usr.getId()) {
                            fileUser.write("  " + nb.getDate() + "   |  "
                                    + nb.getTime() + "  |  "
                                    + nb.getNumber() + "   |  "
                                    + nb.getPrice() + "      \n");

                            sumUsers += nb.getPrice();
                            //add this called to remotion list
                            toRemove.add(nb);
                        }
                    }
                    if(nb.isRates()){
                        rates += nb.getPrice();
                        toRemove.add(nb);
                    }
                    if(nb.isPublicCall()){
                        sumPublics += nb.getPrice();
                        toRemove.add(nb);
                        filePublic.write("  " + nb.getDate() + "   |  "
                                    + nb.getTime() + "  |  "
                                    + nb.getNumber() + "   |  "
                                    + nb.getPrice() + "      \n");
                        
                        
                    }

                }
                
                //footer to users files -------------------------------------------------------------
                
                fileUser.write("-------------------------------------------------------\n");
                fileUser.write(" SUM FOR YOUR CALLS : " + sumUsers + "\n");
                fileUser.write(" RATES              : " + rates + "\n");
                fileUser.write(" RATES DIVIDED      : " + (rates/nUsers) + "\n");
                fileUser.write(" PUBLICS CALLS      : " + sumPublics + "\n");
                fileUser.write(" PUBLICS CALLS DIVI : " + (sumPublics/nUsers) + "\n");
                fileUser.write("-------------------------------------------------------\n");
                fileUser.write(" SUM TOTAL          : " + (sumUsers + (sumPublics/nUsers) + (rates/nUsers)) + "\n");
                fileUser.write("-------------------------------------------------------\n");
                fileUser.close();
                
                

                //remove found numbers
                if(!toRemove.isEmpty())
                    listCalled.removeAll(toRemove);
            }
            
            //CALLS NOT FOUND -----------------------------------------------------------------
            for (NumberCalledVO nb : listCalled) {
                fileNotFound.write("  " + nb.getDate() + "   |  "
                                    + nb.getTime() + "  |  "
                                    + nb.getNumber() + "   |  "
                                    + nb.getPrice() + "      \n");
                sumNotFoud += nb.getPrice();
                
            }
            fileNotFound.write("-------------------------------------------------------\n");
            fileNotFound.write(" SUM FOR NOT FOUND CALLS : " + sumNotFoud + "\n");
            fileNotFound.write("-------------------------------------------------------\n");
            fileNotFound.close();
            
            //foooter to public file ----------------------------------------------------------
            filePublic.write("-------------------------------------------------------\n");
            filePublic.write(" SUM FOR PUBLIC CALLS : " + sumPublics + "\n");
            filePublic.write("-------------------------------------------------------\n");
            filePublic.close();

            toReturn = true;
        } catch (IOException ex) {
            toReturn = false;
            System.out.println(ex);
        }

        return toReturn;
    }

    public  void generateGenericFiles(String address) throws BusinessException {
        try {
            FileWriter allFile = new FileWriter(address + "/notFound.txt");
            FileWriter publicFile = new FileWriter(address + "/public.txt");
            
            //Create a headers to files -----------------------------------------------
            
             publicFile.write("+-----------------------------------------------------+\n");
             publicFile.write("|                 LIST FOR PUBLIC CALLS               |\n");
             publicFile.write("+------------+------------+---------------+-----------+\n");
             publicFile.write("|  DATE      |    TIME    |    NUMBER     |   PRICE   |\n");
             publicFile.write("+------------+------------+---------------+-----------+\n");
             publicFile.close();
             
             allFile.write("+-----------------------------------------------------+\n");
             allFile.write("|              LIST FOR NOT FOUND CALLS               |\n");
             allFile.write("+------------+------------+---------------+-----------+\n");
             allFile.write("|  DATE      |    TIME    |    NUMBER     |   PRICE   |\n");
             allFile.write("+------------+------------+---------------+-----------+\n");
             allFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Fatura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
