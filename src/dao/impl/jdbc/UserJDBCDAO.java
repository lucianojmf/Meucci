package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ObjectVO;
import vo.UserVO;
import dao.DAOException;
import dao.spec.IUserDAO;

public class UserJDBCDAO extends GenericJDBCDAO implements IUserDAO {

    public UserJDBCDAO(Properties properties) throws DAOException {
        super(properties);
    }

    public void update(ObjectVO vo) throws DAOException {
        UserVO user = (UserVO) vo;
        String sql = "UPDATE " + this.getTableName()
                + " SET NAME = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(2, user.getId());
            stmt.setString(1, user.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void insert(ObjectVO vo) throws DAOException {
        String sql = "INSERT INTO " + this.getTableName()
                + " (NAME) VALUES (?)";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            UserVO user = (UserVO) vo;
            stmt.setString(1, user.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    

    public String getTableName() {
        return "USERS";
    }

    protected ObjectVO createVO(ResultSet rs) throws DAOException {
        try {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
           
            return new UserVO(id, name);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public final UserVO selectUserByName(String name) throws DAOException {
        ObjectVO vo = null;
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE NAME = '"
                + name + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                vo = this.createVO(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return (UserVO) vo;
    }


}
