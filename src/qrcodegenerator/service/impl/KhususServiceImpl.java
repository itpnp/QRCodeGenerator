/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.service.impl;

import java.util.Date;
import java.util.List;
import qrcodegenerator.dao.KhususDao;
import qrcodegenerator.dao.impl.KhususDaoImpl;
import qrcodegenerator.entity.Area;
import qrcodegenerator.entity.Khusus;
import qrcodegenerator.service.KhususService;

/**
 *
 * @author Rizaldi Habibie
 */
public class KhususServiceImpl implements KhususService{
private KhususDao khususDao = new KhususDaoImpl();
    @Override
    public String getLastNumerator() {
        return khususDao.getLastNumerator();
    }

    @Override
    public List<String> generateNumerator() {
        return khususDao.generateNumerator();
    }

    @Override
    public Khusus save(Khusus khusus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Khusus findByNumerator(String numerator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Khusus> saveAll(List<Khusus> listKhusus) {
        return khususDao.saveAll(listKhusus);
    }

    @Override
    public List<String> generateUniqueCode(Area area) {
        return khususDao.generateUniqueCode(area);
    }

    @Override
    public List<Khusus> updateAll(List<Khusus> listKhusus) {
        return khususDao.updateAll(listKhusus);
    }

    @Override
    public List<Khusus> showAll() {
        return khususDao.showAll();
    }

    @Override
    public List<Khusus> showPrinted() {
        return khususDao.showPrinted();
    }

    @Override
    public List<Khusus> showNotPrinted() {
        return khususDao.showNotPrinted();
    }

    @Override
    public List<Khusus> findByDate(Date startDate, Date endDate) {
        return khususDao.findByDate(startDate, endDate);
    }

    @Override
    public List<Khusus> findBySheet(int sheetNumber) {
       return khususDao.findBySheet(sheetNumber);
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
