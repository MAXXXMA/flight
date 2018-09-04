package dao;

import dto.User;
import dto.Users;

public class UserDao extends BaseDao {

    /**
     * verify login
     * @param email
     * @param password
     * @return 
     */
    public User getUserByLogin(String email, String password) {
        for (User u : getAll().getUsers()) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    /**
     * get user by username
     * @param username
     * @return 
     */
    public User getUser(String userId) {
        for (User u : getAll().getUsers()) {
            if (u.getUserId().equals(userId)) {
                return u;
            }
        }
        return null;
    }
    
    /**
     * get user by email
     * @param email
     * @return 
     */
    public User getUserByEmail(String email) {
        for (User u : getAll().getUsers()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    /**
     * create new user and store in xml
     * @param user 
     */
    public void addUser(User user) {
        Users users = getAll();
        users.addUser(user);
        save(users);
    }
    
    /**
     * get all users
     * @return 
     */
    public Users getAll() {
        return (Users) this.get(Users.class);
    }
}
