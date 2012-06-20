package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ObjectVO;
import vo.ContactVO;
import dao.DAOException;
import dao.spec.IContactDAO;
import java.util.ArrayList;
import java.util.List;

public class ContactJDBCDAO extends GenericJDBCDAO implements IContactDAO {

    public ContactJDBCDAO(Properties properties) throws DAOException {
        super(properties);
    }

    public void update(ObjectVO vo) throws DAOException {
        ContactVO contact = (ContactVO) vo;
        String sql = "UPDATE " + this.getTableName()
                + " SET USER_ID = ?, NAME = ?, PHONE = ?, CELLPHONE = ?  WHERE ID = ?";
        
        try {
            System.out.println(sql);
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            
            stmt.setString(1, contact.getName());
            stmt.setInt(2, contact.getUser_id());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getCellphone());
            stmt.setInt(5, contact.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void insert(ObjectVO vo) throws DAOException {
        String sql = "INSERT INTO " + this.getTableName()
                + " (NAME, USER_ID, PHONE, CELLPHONE) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ContactVO contact = (ContactVO) vo;
            stmt.setString(1, contact.getName());
            stmt.setInt(2, contact.getUser_id());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getCellphone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    

    public String getTableName() {
        return "CONTACTS";
    }

    protected ObjectVO createVO(ResultSet rs) throws DAOException {
        try {
            int id = rs.getInt("ID");
            int user_id = rs.getInt("USER_ID");
            String name = rs.getString("NAME");
            String phone = rs.getString("PHONE");
            String cell_phone = rs.getString("CELLPHONE");
           
            return new ContactVO(id, user_id, name, phone, cell_phone);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public final List<ContactVO> selectContactByUser(int id) throws DAOException {
        List<ContactVO> contacts = new ArrayList<ContactVO>();
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE USER_ID ="+ id ;
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                contacts.add((ContactVO)this.createVO(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return contacts;
    }

    public ContactVO selectContactByName(String contName) throws DAOException {
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
        return (ContactVO) vo;
    }
    
    public ContactVO selectContactByNumber(String contNumber) throws DAOException {
        ObjectVO vo = null;
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE PHONE = '"+ contNumber + "'"
                        +"OR CELLPHONE='" + contNumber + "'";

        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                vo = this.createVO(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return (ContactVO) vo;
    }


}
