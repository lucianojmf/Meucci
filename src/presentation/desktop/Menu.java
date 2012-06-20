/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Menu.java
 *
 * Created on 08/05/2012, 22:34:44
 */
package presentation.desktop;

import business.BusinessException;
import business.BusinessFactory;
import business.spec.IPublicContacts;
import business.spec.IUser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vo.PublicContactsVO;
import vo.UserVO;

/**
 *
 * @author luciano
 */
public class Menu extends javax.swing.JFrame {

    private static Menu instance;
    private List<UserVO> listUsr;
    private List<PublicContactsVO> listCont;

    /** Creates new form Menu */
    public Menu() {
        initComponents();
        initDataTable();
    }

    //Estancia singleton do menu
    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        lblUsers = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPublicContacts = new javax.swing.JTable();
        lblPublic = new javax.swing.JLabel();
        btnNewUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnContacUserList = new javax.swing.JButton();
        btnNewPublicContact = new javax.swing.JButton();
        btnEditPublicContact = new javax.swing.JButton();
        btnRemovePublicContact = new javax.swing.JButton();
        btnImportPublicContact = new javax.swing.JButton();
        barMenu = new javax.swing.JMenuBar();
        menuReports = new javax.swing.JMenu();
        subReportGenerate = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(presentation.desktop.MeucciApp.class).getContext().getResourceMap(Menu.class);
        setTitle(resourceMap.getString("frmMenu.title")); // NOI18N
        setName("frmMenu"); // NOI18N
        setResizable(false);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblUser.setBackground(resourceMap.getColor("tblUser.background")); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUser.setName("tblUser"); // NOI18N
        jScrollPane1.setViewportView(tblUser);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle"); // NOI18N
        lblUsers.setText(bundle.getString("MenuForm.lblUsers.text")); // NOI18N
        lblUsers.setName("lblUsers"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tblPublicContacts.setBackground(resourceMap.getColor("tblPublicContacts.background")); // NOI18N
        tblPublicContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPublicContacts.setName("tblPublicContacts"); // NOI18N
        jScrollPane2.setViewportView(tblPublicContacts);

        lblPublic.setText(bundle.getString("MenuForm.lblPublic.text")); // NOI18N
        lblPublic.setName("lblPublic"); // NOI18N

        btnNewUser.setIcon(resourceMap.getIcon("btnNewUser.icon")); // NOI18N
        btnNewUser.setName("btnNewUser"); // NOI18N
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });

        btnEditUser.setIcon(resourceMap.getIcon("btnEditUser.icon")); // NOI18N
        btnEditUser.setName("btnEditUser"); // NOI18N
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setIcon(resourceMap.getIcon("btnDeleteUser.icon")); // NOI18N
        btnDeleteUser.setName("btnDeleteUser"); // NOI18N
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnContacUserList.setIcon(resourceMap.getIcon("btnContacUserList.icon")); // NOI18N
        btnContacUserList.setName("btnContacUserList"); // NOI18N
        btnContacUserList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContacUserListActionPerformed(evt);
            }
        });

        btnNewPublicContact.setFont(resourceMap.getFont("btnNewPublicContact.font")); // NOI18N
        btnNewPublicContact.setIcon(resourceMap.getIcon("btnNewPublicContact.icon")); // NOI18N
        btnNewPublicContact.setName("btnNewPublicContact"); // NOI18N
        btnNewPublicContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPublicContactActionPerformed(evt);
            }
        });

        btnEditPublicContact.setFont(resourceMap.getFont("btnEditPublicContact.font")); // NOI18N
        btnEditPublicContact.setIcon(resourceMap.getIcon("btnEditPublicContact.icon")); // NOI18N
        btnEditPublicContact.setName("btnEditPublicContact"); // NOI18N
        btnEditPublicContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPublicContactActionPerformed(evt);
            }
        });

        btnRemovePublicContact.setFont(resourceMap.getFont("btnRemovePublicContact.font")); // NOI18N
        btnRemovePublicContact.setIcon(resourceMap.getIcon("btnRemovePublicContact.icon")); // NOI18N
        btnRemovePublicContact.setName("btnRemovePublicContact"); // NOI18N
        btnRemovePublicContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePublicContactActionPerformed(evt);
            }
        });

        btnImportPublicContact.setFont(resourceMap.getFont("btnImportPublicContact.font")); // NOI18N
        btnImportPublicContact.setIcon(resourceMap.getIcon("btnImportPublicContact.icon")); // NOI18N
        btnImportPublicContact.setName("btnImportPublicContact"); // NOI18N
        btnImportPublicContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportPublicContactActionPerformed(evt);
            }
        });

        barMenu.setName("barMenu"); // NOI18N

        menuReports.setText(bundle.getString("MenuForm.menuReports.text")); // NOI18N
        menuReports.setName("menuReports"); // NOI18N

        subReportGenerate.setText(bundle.getString("MenuForm.menuReports.generate.text")); // NOI18N
        subReportGenerate.setName("subReportGenerate"); // NOI18N
        subReportGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subReportGenerateActionPerformed(evt);
            }
        });
        menuReports.add(subReportGenerate);

        barMenu.add(menuReports);

        menuHelp.setText(bundle.getString("MenuForm.menuHelp.text")); // NOI18N
        menuHelp.setName("menuHelp"); // NOI18N

        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuHelp.add(jMenuItem4);

        barMenu.add(menuHelp);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(lblPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNewUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnContacUserList)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(btnNewPublicContact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditPublicContact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemovePublicContact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImportPublicContact)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsers)
                    .addComponent(lblPublic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewUser)
                            .addComponent(btnEditUser)
                            .addComponent(btnDeleteUser)
                            .addComponent(btnContacUserList)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNewPublicContact)
                            .addComponent(btnEditPublicContact)
                            .addComponent(btnRemovePublicContact)
                            .addComponent(btnImportPublicContact))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-750)/2, (screenSize.height-434)/2, 750, 434);
    }// </editor-fold>//GEN-END:initComponents
    
        private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed
            NewUserForm.getInstance().setVisible(true);
    }//GEN-LAST:event_btnNewUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        if (tblUser.getSelectedRow() != -1) {
            EditUserForm editUser = new EditUserForm(this, rootPaneCheckingEnabled, listUsr.get(tblUser.getSelectedRow()));
            editUser.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("USER NOT SELECTED! YOU NEED SELECT A USER TO EDIT."),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI ALERT"),
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if (tblUser.getSelectedRow() != -1) {
            UserVO userVO = listUsr.get(tblUser.getSelectedRow());
            IUser user = BusinessFactory.getInstance().getUser();

            int n = JOptionPane.showConfirmDialog(
                    this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("ARE YOU SURE YOU WANT TO DELETE THE USER ") + userVO.getName() + java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString(" ?"),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI - EXLUDE USER"),
                    JOptionPane.YES_NO_OPTION);
            //Caso o usuario tenha clicado em sim, confirmando a exclusao
            if (n == 0) {
                try {
                    user.delete(userVO.getId());
                    updateDataFormView();
                } catch (BusinessException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("USER NOT SELECTED! YOU NEED SELECT A USER TO DELETE."),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI ALERT"),
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnContacUserListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContacUserListActionPerformed
        if (tblUser.getSelectedRow() != -1) {
            UserContactListForm contactList = new UserContactListForm(this, rootPaneCheckingEnabled, listUsr.get(tblUser.getSelectedRow()));
            contactList.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("USER NOT SELECTED! YOU NEED SELECT A USER TO SHOW YOUR CONTACTS."),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI ALERT"),
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnContacUserListActionPerformed

    private void btnNewPublicContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPublicContactActionPerformed
        NewPublicContactForm.getInstance().setVisible(true);
    }//GEN-LAST:event_btnNewPublicContactActionPerformed

    private void btnEditPublicContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPublicContactActionPerformed
        if (tblPublicContacts.getSelectedRow() != -1) {
            EditPublicContactForm editContact = new EditPublicContactForm(this, rootPaneCheckingEnabled, listCont.get(tblPublicContacts.getSelectedRow()));
            editContact.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("USER NOT SELECTED! YOU NEED SELECT A CONTACT TO EDIT."),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI ALERT"),
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditPublicContactActionPerformed

    private void btnRemovePublicContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePublicContactActionPerformed
        if (tblPublicContacts.getSelectedRow() != -1) {
            PublicContactsVO contactsVO = listCont.get(tblPublicContacts.getSelectedRow());
            IPublicContacts cont = BusinessFactory.getInstance().getPublicContact();

            int n = JOptionPane.showConfirmDialog(
                    this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("ARE YOU SURE YOU WANT TO DELETE THE USER ") + contactsVO.getName() + java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString(" ?"),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI - EXLUDE USER"),
                    JOptionPane.YES_NO_OPTION);
            //Caso o usuario tenha clicado em sim, confirmando a exclusao
            if (n == 0) {
                try {
                    cont.delete(contactsVO.getId());
                    updateDataFormView();
                } catch (BusinessException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("CONTACT NOT SELECTED! YOU NEED SELECT A CONTACT TO DELETE."),
                    java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("MEUCCI ALERT"),
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRemovePublicContactActionPerformed

    private void btnImportPublicContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportPublicContactActionPerformed
        importPublicContacts();
    }//GEN-LAST:event_btnImportPublicContactActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       AboutBox.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void subReportGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subReportGenerateActionPerformed
        Report.getInstance().setVisible(true);
    }//GEN-LAST:event_subReportGenerateActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JButton btnContacUserList;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditPublicContact;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnImportPublicContact;
    private javax.swing.JButton btnNewPublicContact;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JButton btnRemovePublicContact;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPublic;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuReports;
    private javax.swing.JMenuItem subReportGenerate;
    private javax.swing.JTable tblPublicContacts;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    //************ MÉTODOS PERSONALIZADOS *******************************/
    private void initDataTable() {
        DefaultTableModel dtmUser = new DefaultTableModel(null, new String[]{java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("USER NAME")});
        DefaultTableModel dtmCon = new DefaultTableModel(null, new String[]{java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("NAME"), java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("PHONE"), java.util.ResourceBundle.getBundle("presentation/desktop/languages/Bundle").getString("CELLPHONE")});
        IUser user = BusinessFactory.getInstance().getUser();
        IPublicContacts contacts = BusinessFactory.getInstance().getPublicContact();

        listUsr = null;
        listCont = null;
        try {
            //lista todos usuarios da base de dados
            listUsr = user.getAll();

            //lista os contatos publicos da base de dados
            listCont = contacts.getAll();


            //navega na lista de usuarios e add na tabela do form
            for (UserVO userVO : listUsr) {
                dtmUser.addRow(new String[]{userVO.getName()});
            }

            //navega na lista de contatos de add na tabela do form
            for (PublicContactsVO con : listCont) {
                dtmCon.addRow(new String[]{con.getName(), con.getPhone(), con.getCellphone()});
            }
            tblUser.setModel(dtmUser);
            tblUser.repaint();

            tblPublicContacts.setModel(dtmCon);
            tblPublicContacts.repaint();

        } catch (BusinessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDataFormView() {
        initDataTable();
    }

    private void importPublicContacts() {
        PublicImportContactForm form = new PublicImportContactForm(null, rootPaneCheckingEnabled);
        this.setVisible(false);
        form.setVisible(true);
    }
}
