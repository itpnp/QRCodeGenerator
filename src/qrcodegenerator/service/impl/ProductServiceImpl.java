/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.service.impl;

import java.util.List;
import qrcodegenerator.dao.ProductDao;
import qrcodegenerator.dao.impl.ProductDaoImpl;
import qrcodegenerator.entity.MasterProduct;
import qrcodegenerator.service.ProductService;

/**
 *
 * @author Rizaldi Habibie
 */
public class ProductServiceImpl implements ProductService {
private ProductDao productDao= new ProductDaoImpl();
    @Override
    public MasterProduct addProduct(MasterProduct product) {
        return productDao.addProduct(product);
    }

    @Override
    public MasterProduct findById(String code) {
        return productDao.findById(code);
    }

    @Override
    public List<MasterProduct> findByName(String productName) {
        return productDao.findByName(productName);
    }

    @Override
    public List<MasterProduct> showAll() {
        return productDao.showAll();
    }
    
}
