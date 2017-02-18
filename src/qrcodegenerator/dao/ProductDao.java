/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao;

import java.util.List;
import qrcodegenerator.entity.MasterProduct;

/**
 *
 * @author Rizaldi Habibie
 */
public interface ProductDao {
    
    /**
     * 
     * @param product
     * @return MasterProduct
     */
    public MasterProduct addProduct(MasterProduct product);
    
    /**
     * 
     * @param code
     * @return MasterProduct
     */
    public MasterProduct findById(String code);
    
    /**
     * 
     * @param productName
     * @return List Of MasterProduct
     */
    public List<MasterProduct> findByName(String productName);
    
    /**
     * 
     * @return @List MasterProduct 
     */
    public List<MasterProduct> showAll();
    
}
