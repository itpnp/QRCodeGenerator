/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao;

import java.util.Date;
import java.util.List;
import qrcodegenerator.entity.Area;
import qrcodegenerator.entity.Khusus;

/**
 *
 * @author Rizaldi Habibie
 */
public interface KhususDao {
    
    /**
     * method to get last numerator
     * @return String 
     */
    public String getLastNumerator();
    
    /**
     * 
     * @return String 
     */
    public List<String> generateNumerator();
    
    /**
     * 
     * @param khusus
     */
    public Khusus save(Khusus khusus);
    
    /**
     * 
     * @param listKhusus
     * @return @List
     */
    public List<Khusus> saveAll(List<Khusus> listKhusus);
    
    /**
     * 
     * @param numerator
     * @return String 
     */
    public Khusus findByNumerator(String numerator);
    
    /**
     * 
     * @return @List
     */
    public List<String> generateUniqueCode(Area area);
    
    /**
     * 
     * @param listKhusus
     * @return @List
     */
    public List<Khusus> updateAll(List<Khusus> listKhusus); 
 
    /**
     * 
     * @return @List @Khusus 
     */
    public List<Khusus> showAll();
    
    /**
     * 
     * @return @List @Khusus 
     */
    public List<Khusus> showPrinted();
    
    /**
     * 
     * @return @List @Khusus 
     */
    public List<Khusus> showNotPrinted();
    
    /**
     * 
     * @param startDate
     * @param endDate
     * @return @List @Khusus 
     */
    public List<Khusus> findByDate(Date startDate, Date endDate);
    
    /**
     * 
     * @param sheetNumber
     * @return @List @Khusus
     */
    public List<Khusus> findBySheet(int sheetNumber);
    
    /**
     * 
     * @param productName
     * @return @List @Khusus
     */
    public List<Khusus> findByProductName(String productName);
    
    /**
     * 
     * @param type
     * @return @List @Khusus 
     */
    public List<Khusus> findByType(String type);
}
