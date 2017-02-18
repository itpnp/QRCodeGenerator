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
import qrcodegenerator.dao.ProductDao;
import qrcodegenerator.entity.MasterProduct;
import qrcodegenerator.utils.HibernateUtil;

/**
 *
 * @author Rizaldi Habibie
 */
public class ProductDaoImpl implements ProductDao {
private Session session;
private List<MasterProduct> resultLists;
    @Override
    public MasterProduct addProduct(MasterProduct product) {
        MasterProduct masterProduct = product;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(masterProduct);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Maaf, gagal menyimpan product\n"+e,"Error",JOptionPane.ERROR_MESSAGE);
            masterProduct = null;
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return masterProduct;
    }

    @Override
    public MasterProduct findById(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MasterProduct> findByName(String productName) {
        resultLists = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from MasterProduct where namaBarang Like '%"+productName+"%'");
            resultLists = q.list();
            session.getTransaction();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null, "Error Retrieve Data Product\n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return resultLists;
    }

    @Override
    public List<MasterProduct> showAll() {
        resultLists = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from MasterProduct");
            resultLists = q.list();
            session.getTransaction();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null, "Error Retrieve Data Product\n"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return resultLists;
    }
    
}
