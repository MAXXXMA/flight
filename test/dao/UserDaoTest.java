/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.User;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao;
    User newUser;

    public UserDaoTest() {
        userDao = new UserDao();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        newUser = new User();
        newUser.setEmail(UUID.randomUUID().toString() + "@uts.com");
        newUser.setName("test user");
        newUser.setPassword("password");
    }

    @After
    public void tearDown() {
        userDao.remove(newUser.getUserId());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAdd() {
        String userId = newUser.getUserId();
        userDao.add(newUser);
        User fetchedUser = userDao.getUser(userId);
        assertTrue(fetchedUser.getEmail().equals(newUser.getEmail()));
        assertTrue(fetchedUser.getName().equals(newUser.getName()));
        assertTrue(fetchedUser.getPassword().equals(newUser.getPassword()));
    }

    @Test
    public void testGet() {
        String userId = newUser.getUserId();
        userDao.add(newUser);
        User fetchedUser = userDao.getUser(userId);
        assertTrue(fetchedUser.getUserId().equals(newUser.getUserId()));
        assertTrue(fetchedUser.getEmail().equals(newUser.getEmail()));
        assertTrue(fetchedUser.getName().equals(newUser.getName()));
        assertTrue(fetchedUser.getPassword().equals(newUser.getPassword()));
    }

    @Test
    public void testGetEmail() {
        userDao.add(newUser);
        User fetchedUser = userDao.getUserByEmail(newUser.getEmail());
        assertTrue(fetchedUser.getUserId().equals(newUser.getUserId()));
        assertTrue(fetchedUser.getEmail().equals(newUser.getEmail()));
        assertTrue(fetchedUser.getName().equals(newUser.getName()));
        assertTrue(fetchedUser.getPassword().equals(newUser.getPassword()));
    }

    @Test
    public void testGetLogin() {
        userDao.add(newUser);
        User fetchedUser = userDao.getUserByLogin(newUser.getEmail(), newUser.getPassword());
        assertTrue(fetchedUser.getUserId().equals(newUser.getUserId()));
        assertTrue(fetchedUser.getEmail().equals(newUser.getEmail()));
        assertTrue(fetchedUser.getName().equals(newUser.getName()));
        assertTrue(fetchedUser.getPassword().equals(newUser.getPassword()));
    }
    
    @Test
    public void testGetAll() {
        userDao.add(newUser);
        List<User> users = userDao.getAll();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testRemove() {
        String userId = newUser.getUserId();
        userDao.remove(userId);
        User fetchedUser = userDao.getUser(userId);
        assertTrue(fetchedUser == null);
    }

}
