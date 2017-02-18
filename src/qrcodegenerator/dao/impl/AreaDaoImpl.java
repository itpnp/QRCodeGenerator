/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import qrcodegenerator.dao.AreaDao;
import qrcodegenerator.entity.Area;
import qrcodegenerator.utils.HibernateUtil;

/**
 *
 * @author Rizaldi Habibie
 */
public class AreaDaoImpl implements AreaDao{
private Session session;
private Area area;
    @Override
    public Area addArea(Area area) {
        Area savedArea = area;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
           session.beginTransaction(); 
           session.save(area);
           session.getTransaction().commit();
           JOptionPane.showMessageDialog(null,"Area Berhasil Ditambah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
            session.getTransaction().rollback();
           JOptionPane.showMessageDialog(null,"Saving Area Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return savedArea;
    }

    @Override
    public Area findById(String areaCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Area> findByName(String areaName) {
        List<Area> resultList = new ArrayList<>();
      try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Area where namaArea like '%"+areaName+"%'");
        resultList = q.list();
      }catch(HibernateException e) {
           JOptionPane.showMessageDialog(null,"Retrieve Area Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
      }
      return resultList;
    }

    @Override
    public Area updateArea(Area area) {
        Area updatedArea = area;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
           session.beginTransaction(); 
           session.update(area);
           session.getTransaction().commit();
        }catch(HibernateException e){
            session.getTransaction().rollback();
           JOptionPane.showMessageDialog(null,"Saving Area Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return updatedArea;    
    }

    @Override
    public List showAllArea() {
      List<Area> resultList = new ArrayList<>();
      try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Area");
        resultList = q.list();
      }catch(HibernateException e) {
           JOptionPane.showMessageDialog(null,"Retrieve Area Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
      }
      return resultList;
    }

    @Override
    public Long getAreaCount(String areaCode) {
        Long count = null;
        try{
           session = HibernateUtil.getSessionFactory().openSession();
           Query q = session.createQuery("select count(*)from Khusus where status = 'Printed' and kodeUnik Like :kodeUnik");
           q.setParameter("kodeUnik","%"+areaCode+"%");
           count = (long) q.uniqueResult();
        }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,"Count Area Data \n"+ex, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        return count;
    }
    
    
}
