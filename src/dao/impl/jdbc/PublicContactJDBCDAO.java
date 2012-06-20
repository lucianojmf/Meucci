package dao.impl.jdbc;

import business.BusinessFactory;
import business.spec.IPublicContacts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ObjectVO;
import vo.PublicContactsVO;
import dao.DAOException;
import dao.spec.IPublicContactsDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class PublicContactJDBCDAO extends GenericJDBCDAO implements IPublicContactsDAO {

    public PublicContactJDBCDAO(Properties properties) throws DAOException {
        super(properties);
    }

    public void update(ObjectVO vo) throws DAOException {
        PublicContactsVO contact = (PublicContactsVO) vo;
        String sql = "UPDATE " + this.getTableName()
                + " SET NAME = ?, SET PHONE = ?, SET CELLPHONE = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(4, contact.getId());
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getCellphone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void insert(ObjectVO vo) throws DAOException {
        String sql = "INSERT INTO " + this.getTableName()
                + " (NAME, PHONE, CELLPHONE) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            PublicContactsVO contact = (PublicContactsVO) vo;
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getCellphone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public String getTableName() {
        return "PUBLICCONTACTS";
    }

    protected ObjectVO createVO(ResultSet rs) throws DAOException {
        try {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String phone = rs.getString("PHONE");
            String cell_phone = rs.getString("CELLPHONE");

            return new PublicContactsVO(id, name, phone, cell_phone);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public PublicContactsVO selectContactByName(String contName) throws DAOException {
        ObjectVO vo = null;
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE NAME = '"
                + contName + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                vo = this.createVO(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return (PublicContactsVO) vo;
    }

    public PublicContactsVO selectContactByNumber(String contNumber) throws DAOException {
        ObjectVO vo = null;
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE PHONE = '" + contNumber + "'"
                + "OR CELLPHONE='" + contNumber + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                vo = this.createVO(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return (PublicContactsVO) vo;
    }

    public boolean importContacts(String address) throws DAOException {
        boolean toReturn = false;
        BusinessFactory factory = BusinessFactory.getInstance();
        File file = new File(address);
        int header_discard = 1;
        
        IPublicContacts contact = factory.getPublicContact();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);

            String string;
            String tmp[];

            //Ignore header lines
            for (int i = 0; i < header_discard; i++) {
                in.readLine();
            }

            //Reading and insertion lines in NumberCalledVO object list
            while ((string = in.readLine()) != null) {
                //Regular expression to split
                tmp = string.split("\\,");
                PublicContactsVO cont = new PublicContactsVO();

                cont.setName(tmp[0]);
                cont.setPhone(tmp[1].replaceAll(" ", "").replaceAll("-", ""));
                cont.setCellphone(tmp[1].replaceAll(" ", "").replaceAll("-", ""));

                contact.create(cont);
            }
            in.close();
            toReturn = true;
        } catch (Exception e) {
            System.out.println(e);
            toReturn = false;
        }

        return toReturn;
    }
}
