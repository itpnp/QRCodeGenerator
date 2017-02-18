/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.service.impl;

import java.util.List;
import qrcodegenerator.dao.AreaDao;
import qrcodegenerator.dao.impl.AreaDaoImpl;
import qrcodegenerator.entity.Area;
import qrcodegenerator.service.AreaService;

/**
 *
 * @author Rizaldi Habibie
 */
public class AreaServiceImpl implements AreaService {
private AreaDao areaDao = new AreaDaoImpl();
    @Override
    public Area addArea(Area area) {
        return areaDao.addArea(area);
    }

    @Override
    public Area findById(String areaCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Area> findByName(String areaName) {
        return areaDao.findByName(areaName);
    }

    @Override
    public Area updateArea(Area area) {
        return areaDao.updateArea(area);
    }

    @Override
    public List showAllArea() {
        return areaDao.showAllArea();
    }

    @Override
    public Long getAreaCount(String areaCode) {
        return areaDao.getAreaCount(areaCode);
    }
    
}
