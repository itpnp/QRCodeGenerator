/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.dao;

import java.util.List;
import qrcodegenerator.entity.Area;

/**
 *
 * @author Rizaldi Habibie
 */
public interface AreaDao {
    
    /**
     * 
     * @param area
     * @return true if success
     */
    public Area addArea(Area area);
    
    /**
     * 
     * @param areaCode
     * @return Area
     */
    public Area findById(String areaCode);
    
    /**
     * 
     * @param areaName
     * @return return @List @Area
     */
    public List<Area> findByName(String areaName);
    
    /**
     * 
     * @param area
     * @return true if update success
     */
    public Area updateArea(Area area);
    
    /**
     * 
     * @return List of Area 
     */
    public List showAllArea();
    
    /**
     * 
     * @param areaCode
     * @return @Long
     */
    public Long getAreaCount(String areaCode);
}
