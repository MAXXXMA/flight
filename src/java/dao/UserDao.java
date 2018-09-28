package dao;

import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao extends BaseDao {

    private User extractUesr(ResultSet rs) throws SQLException {
        User user = new User();
        user.setEmail(rs.getString("email"));
        user.setUserId(rs.getString("userId"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        return user;
    }

    /**
     * verify login
     *
     * @param email
     * @param password
     * @return
     */
    public User getUserByLogin(String email, String password) {
        Connection conn = getConnection();
        User user = null;
        try {
            String sql = "select * from User where email = ? and password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = extractUesr(rs);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public User getUser(String userId) {
        Connection conn = getConnection();
        User user = null;
        try {
            String sql = "select * from User where userId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = extractUesr(rs);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    /**
     * get user by email
     *
     * @param email
     * @return
     */
    public User getUserByEmail(String email) {
        Connection conn = getConnection();
        User user = null;
        try {
            String sql = "select * from User where email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = extractUesr(rs);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    /**
     * create new user and store in xml
     *
     * @param user
     */
    public void add(User user) {
        Connection conn = getConnection();
        try {
            String sql = "insert into User values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getName());
            preparedStatement.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * get all users
     *
     * @return
     */
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        Connection conn = getConnection();
        try {
            String sql = "select * from User";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(extractUesr(rs));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public void remove(String userId) {

        Connection conn = getConnection();
        try {
            String sql = "delete from User where userId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
