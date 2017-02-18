/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao;

import java.util.List;
import qrcodegenerator.entity.User;

/**
 *
 * @author Rizaldi Habibie
 */
public interface UserDao {
    
    /**
     * method for adding new user into system
     * @param user 
     */
    public void addUser(User user);
    
    /**
     * method for get inside system
     * @param username
     * @param password
     * @return true if exist
     * @return false if doesnt exist
     */
    public User login(String username,String password);
    
    /**
     * method for edit user profile
     * @param user 
     */
    public void editUser(User user);
    
    /**
     * method for searching certain user
     * @param id 
     */
    public void findById(int id);
    
    /**
     * method for searching certain user
     * @param name 
     */
    public void findByName(String name);
    
    /**
     * method to show all user
     * @return List
     */
    public List findAll();
    
    /**
     * @param user
     * @return @boolean
     */
    public boolean deleteUser(User user);
}
