package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ObjectVO;
import vo.AdminVO;
import dao.DAOException;
import dao.spec.IAdminDAO;

public class AdminJDBCDAO extends GenericJDBCDAO implements IAdminDAO {

    public AdminJDBCDAO(Properties properties) throws DAOException {
        super(properties);
    }

    public void update(ObjectVO vo) throws DAOException {
        AdminVO user = (AdminVO) vo;
        String sql = "UPDATE " + this.getTableName()
                + " SET LOGIN = ?, PASSWORD = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(3, user.getId());
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void insert(ObjectVO vo) throws DAOException {
        String sql = "INSERT INTO " + this.getTableName()
                + " (LOGIN, PASSWORD) VALUES (?,?)";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            AdminVO user = (AdminVO) vo;
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean checkLoginPassword(String login, String password)
            throws DAOException {
        boolean isAuthenticated = false;
        String sql = "SELECT PASSWORD FROM " + this.getTableName()
                + " WHERE LOGIN = '" + login + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String result = rs.getString("PASSWORD");
                isAuthenticated = result.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
        return isAuthenticated;
    }

    public String getTableName() {
        return "ADMIN";
    }

    protected ObjectVO createVO(ResultSet rs) throws DAOException {
        try {
            int id = rs.getInt("ID");
            String login = rs.getString("LOGIN");
            String password = rs.getString("PASSWORD");
           
            return new AdminVO(id, login, password);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public final AdminVO selectByLogin(String login) throws DAOException {
        ObjectVO vo = null;
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE LOGIN = '"
                + login + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                vo = this.createVO(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return (AdminVO) vo;
    }
}
