/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao.impl;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import qrcodegenerator.dao.SheetDao;
import qrcodegenerator.entity.Sheet;
import qrcodegenerator.service.SheetService;
import qrcodegenerator.service.impl.SheetServiceImpl;
import qrcodegenerator.utils.HibernateUtil;

/**
 *
 * @author Rizaldi Habibie
 */
public class SheetDaoImpl implements SheetDao {
    private Session session;
    @Override
    public Sheet save(Sheet sheet) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Date date = Calendar.getInstance().getTime();
            sheet.setLastPrinted(date);
            session.save(sheet);
            session.getTransaction().commit();
        }catch(HibernateException e){
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null,"Error saving sheet \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return sheet;
    }

    @Override
    public Sheet update(Sheet sheet) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Date date = Calendar.getInstance().getTime();
            sheet.setLastPrinted(date);
            session.update(sheet);
            session.getTransaction().commit();
        }catch(HibernateException e){
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null,"Error update sheet \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return sheet;
    }
    
}
