/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import qrcodegenerator.dao.KhususDao;
import qrcodegenerator.entity.Area;
import qrcodegenerator.entity.Khusus;
import qrcodegenerator.utils.AlphabetArray;
import qrcodegenerator.utils.HibernateUtil;

/**
 *
 * @author Rizaldi Habibie
 */
public class KhususDaoImpl implements KhususDao{
private Session session;
private String abjad, lastNumerator, codePart2;
private int getCodePart2;
private AlphabetArray alphabets= new AlphabetArray();
private List<Integer> getCodePart4;

    @Override
    public String getLastNumerator() {
        Khusus khusus = new Khusus();
        List<Khusus> results = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            DetachedCriteria maxId = DetachedCriteria.forClass(Khusus.class).setProjection( Projections.max("noUrut") );
            results = session.createCriteria(Khusus.class).add( Property.forName("noUrut").eq(maxId)).list();
            if(!results.isEmpty()){
              lastNumerator =  results.get(0).getQrcodeNumerator(); 
            }else{
              lastNumerator = null;  
            }
        }catch(HibernateException e){
           JOptionPane.showMessageDialog(null,"Error Getting Numerator \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
           return null;
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return lastNumerator;
    }

    @Override
    public List<String> generateNumerator() {
        List<String> numerators = new ArrayList<>();
        int last = 0;
        try{
            if(getLastNumerator() != null){
              last = Integer.parseInt(getLastNumerator().substring(1,8));
              abjad = getLastNumerator().substring(0,1);
              if(last != 9999999){
              } else {
                  for(int i=0; i<26; i++){
                      if(Objects.equals(abjad, alphabets.getAlphabet(i))){
                          if(i==25){
                              break;
                          }else{
                              abjad = alphabets.getAlphabet(i+1);
                              break;
                          }
                      }
                  }
                  last = 0;
              }
            }else{
              abjad = alphabets.getAlphabet(0);
              last = 0;
            }
            for(int x = 0; x<42; x++){
               if(last<10){
                 numerators.add(abjad+"000000"+ last);
               }else if(last>=10 && last<100){
                 numerators.add(abjad+"00000"+ last);
               }else if(last>=100 && last<1000){
                 numerators.add(abjad+"0000"+ last);
               }else if(last>=1000 && last<10000){
                 numerators.add(abjad+"000"+ last);
               }else if(last>=10000 && last<100000){
                 numerators.add(abjad+"00"+ last);
               }else if(last>=100000 && last<1000000){
                 numerators.add(abjad+"0"+ last);
               }else if(last>=1000000 && last<10000000){
                 numerators.add(abjad+ last);
               }
               last++;
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error Generate Numerator \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
           return null;
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return numerators;
    }

    @Override
    public Khusus save(Khusus khusus) {
        Khusus savedKhusus = khusus;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
           session.beginTransaction(); 
           session.save(khusus);
           session.getTransaction().commit();
           JOptionPane.showMessageDialog(null,"Data Khusus Berhasil Ditambah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
            session.getTransaction().rollback();
           JOptionPane.showMessageDialog(null,"Saving Khusus Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return savedKhusus;
    }

    @Override
    public Khusus findByNumerator(String numerator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Khusus> saveAll(List<Khusus> listKhusus) {
        List<Khusus> lists = listKhusus;
        Khusus khusus;
        int i = 0;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            for(Object obj:lists){
              if(i==21){
                  session.flush();
                  session.clear();
              }
              khusus = (Khusus) obj;
              session.save(khusus);
              i++;
            } 
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"List Data Khusus Berhasil Ditambah", "Success", JOptionPane.INFORMATION_MESSAGE, null);
        }catch(HibernateException e){
          session.getTransaction().rollback();
          JOptionPane.showMessageDialog(null,"Saving List Data Khusus \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return lists;
    }

    @Override
    public List<String> generateUniqueCode(Area area) {
        List<String> fixCodes = new ArrayList<>();
        List<Khusus> lists = new ArrayList<>();
        getCodePart4 = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().openSession();
        int start = 0;
        Query q = null;
        try{
            session.beginTransaction();
            q = session.createQuery("from Khusus where kodeUnik Like  :kodeUnik");
            q.setParameter("kodeUnik","%"+area.getKodeArea()+"%");
            
            for(Object obj : q.list()){
                getCodePart2 = Integer.parseInt(((Khusus) obj).getKodeUnik().substring(3, 8));
                if(getCodePart2 > start){
                    start = getCodePart2;
                    codePart2 = ((Khusus) obj).getKodeUnik().substring(3, 8);
                }else{
                    codePart2 = ((Khusus) obj).getKodeUnik().substring(3, 8);
                }
            }
            q = null;
            start = 0;
            q = session.createQuery("from Khusus where kodeUnik Like :kodeUnik");
            q.setParameter("kodeUnik","%"+codePart2+"-"+area.getKodeArea()+"%");
            for(Object obj : q.list()){
                getCodePart4.add(Integer.parseInt(((Khusus) obj).getKodeUnik().substring(13, 17)));
                getCodePart2 = Integer.parseInt(((Khusus) obj).getKodeUnik().substring(3, 8));
            }
            for(Object obj : getCodePart4){
                if((Integer) obj > start){
                    start = (Integer) obj;
                }
            }
            if(start == 9999){
                start = 0;
                getCodePart2 = getCodePart2+1;
            }
            
            if(start != 0 ){
                start = start+1;
            }
            for(int i=0; i<42; i++){
                if(start !=0 && start <10){
                    fixCodes.add("H2-"+setCodePart2(getCodePart2)+"-"+area.getKodeArea()+"-000"+start);
                }else if(start >=10 && start <100){
                    fixCodes.add("H2-"+setCodePart2(getCodePart2)+"-"+area.getKodeArea()+"-00"+start);
                }else if(start >=100 && start<1000){
                    fixCodes.add("H2-"+setCodePart2(getCodePart2)+"-"+area.getKodeArea()+"-0"+start);
                }else if(start >=1000 && start <10000){
                    fixCodes.add("H2-"+setCodePart2(getCodePart2)+"-"+area.getKodeArea()+"-"+start);
                }else{
                    fixCodes.add("H2-"+setCodePart2(getCodePart2)+"-"+area.getKodeArea()+"-0000");
                }
                if(start == 9999){
                   start = -1;
                   getCodePart2 = getCodePart2+1;
                }
                start++;
            }
            
        }catch(HibernateException e){
          JOptionPane.showMessageDialog(null,"Error Generate New Code \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        return fixCodes;
    }
    
    /**
     *
     * @param getCodePart2
     * @return
     */
    public String setCodePart2(int getCodePart2){
        if(getCodePart2 !=0 && getCodePart2 <10){
             codePart2 = "0000"+getCodePart2;
        }else if(getCodePart2 >=10 && getCodePart2 <100){
             codePart2 = "000"+getCodePart2;
        }else if(getCodePart2 >=100 && getCodePart2<1000){
             codePart2 = "00"+getCodePart2;
        }else if(getCodePart2 >=1000 && getCodePart2 <10000){
             codePart2 = "0"+getCodePart2;
        }else if(getCodePart2 >=10000 && getCodePart2 <100000){
             codePart2 = ""+getCodePart2;
        }else{
             codePart2 = "00000";
        }
        return codePart2;
    }

    @Override
    public List<Khusus> updateAll(List<Khusus> listKhusus) {
        List<Khusus> lists = listKhusus;
        Khusus khusus;
        int i = 0;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            for(Object obj:lists){
              if(i==21){
                  session.flush();
                  session.clear();
              }
              khusus = (Khusus) obj;
              session.update(khusus);
              i++;
            } 
            session.getTransaction().commit();
        }catch(HibernateException e){
          session.getTransaction().rollback();
          JOptionPane.showMessageDialog(null,"Update List Data Khusus \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
        return lists;
    }

    @Override
    public List<Khusus> showAll() {
        List<Khusus> listKhusus = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Khusus");
            listKhusus = q.list();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Retrive Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        return listKhusus;
    }

    @Override
    public List<Khusus> showPrinted() {
        List<Khusus> listKhusus = new ArrayList<>();
        Query q = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            q = session.createQuery("from Khusus where status = :status");
            q.setParameter("status","Printed");
            listKhusus = q.list();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Retrive Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        return listKhusus;
    }

    @Override
    public List<Khusus> showNotPrinted() {
        List<Khusus> listKhusus = new ArrayList<>();
        Query q = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            q = session.createQuery("from Khusus where status = :status");
            q.setParameter("status","Not Printed");
            listKhusus = q.list();
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Retrive Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        return listKhusus;
    }

    @Override
    public List<Khusus> findByDate(Date startDate, Date endDate) {
        List<Khusus> listKhusus = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listKhusus =  session.createCriteria(Khusus.class).add( Restrictions.or(
                          Restrictions.isNull("tanggalCetakPertama"),
                          Restrictions.ge("tanggalCetakPertama", startDate))).add( Restrictions.or(
                          Restrictions.isNull("tanggalCetakPertama"),
                          Restrictions.lt("tanggalCetakPertama", endDate))).list();
            for (Khusus khusus : listKhusus) {
                Hibernate.initialize(khusus.getArea());
                Hibernate.initialize(khusus.getMasterProduct());
            }
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Error Retrive Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            if(session.isOpen()){
                session.close();
            }
        }
       
        return listKhusus;
    }

    @Override
    public List<Khusus> findBySheet(int sheetNumber) {
        List<Khusus> lists = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().openSession();
        Query q = null;
        try{
            session.beginTransaction();
            q = session.createQuery("from Khusus where sheet.sheetId Like  :noUrutSheet");
            lists = q.setParameter("noUrutSheet", sheetNumber).list();
            for (Khusus khusus : lists) {
                Hibernate.initialize(khusus.getArea());
                Hibernate.initialize(khusus.getMasterProduct());
                Hibernate.initialize(khusus.getSheet());
            }
        }catch(HibernateException e){
            throw new HibernateException("Error"+e);
        }
        return lists;
    }

    @Override
    public List<Khusus> findByProductName(String productName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Khusus> findByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
