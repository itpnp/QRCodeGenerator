/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.service.impl;

import java.util.List;
import qrcodegenerator.dao.UserDao;
import qrcodegenerator.dao.impl.UserDaoImpl;
import qrcodegenerator.entity.User;
import qrcodegenerator.service.UserPageService;

/**
 *
 * @author Rizaldi Habibie
 */
public class UserPageServiceImpl implements UserPageService {
    UserDao userDao = new UserDaoImpl();
    
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }
    
}
