/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import qrcodegenerator.dao.UserDao;
import qrcodegenerator.entity.Khusus;
import qrcodegenerator.entity.User;
import qrcodegenerator.utils.Connector;
import qrcodegenerator.utils.HibernateUtil;

/**
 *
 * @author Rizaldi Habibie
 */
public class UserDaoImpl implements UserDao {
private Connection sambung;
private Connector hubung;
private ResultSet rs;
private Statement stat;
private User user;
private Session session;
public UserDaoImpl(){
    user = new User();
}
    /**
     * @inheritDoc
     * @param user 
     */
    @Override
    public void addUser(User user) {
          session = HibernateUtil.getSessionFactory().openSession();
        try{
           session.beginTransaction(); 
           session.save(user);
           session.getTransaction().commit();
           JOptionPane.showMessageDialog(null,"User Berhasil Ditambah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Saving Data", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
    }
    
    /**
     * 
     * @param username
     * @param password
     * @return boolean
     */
    @Override
    public User login(String username, String password){
        User user = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Query q = null;
        try{
            session.beginTransaction();
            q = session.createQuery("from User where username = :username and password = :password");
            q.setParameter("username", username);
            user = (User) q.setParameter("password", password).uniqueResult();
        }catch(HibernateException e){
            throw new HibernateException("Error Login "+e);
        }
        return user;   
      }

    /**
     * 
     * @param user 
     */
    @Override
    public void editUser(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
           session.beginTransaction(); 
           session.update(user);
           session.getTransaction().commit();
           JOptionPane.showMessageDialog(null,"User Berhasil Diubah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Saving Data", "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
    }

    /**
     * 
     * @param id 
     */
    @Override
    public void findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param name 
     */
    @Override
    public void findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public User getUser(){
        return user;
    }

    @Override
    public List findAll() {
        List resultList = new ArrayList<>();
      try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from User");
        resultList = q.list();
        session.getTransaction().commit();
      } catch (HibernateException he) {
        he.printStackTrace();
      }
      return resultList;
    }

    @Override
    public boolean deleteUser(User user) {
        boolean deleteSuccess = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch(HibernateException e){
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null,"Error delete user \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return deleteSuccess;
    }
}
