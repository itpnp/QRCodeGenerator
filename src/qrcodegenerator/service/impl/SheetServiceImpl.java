/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.service.impl;

import qrcodegenerator.dao.SheetDao;
import qrcodegenerator.dao.impl.SheetDaoImpl;
import qrcodegenerator.entity.Sheet;
import qrcodegenerator.service.SheetService;

/**
 *
 * @author Rizaldi Habibie
 */
public class SheetServiceImpl implements SheetService{
private SheetDao sheetDao;
    @Override
    public Sheet save(Sheet sheet) {
        sheetDao = new SheetDaoImpl();
        return sheetDao.save(sheet);
    }

    @Override
    public Sheet update(Sheet sheet) {
        sheetDao = new SheetDaoImpl();
        return sheetDao.update(sheet);    }
    
}
