/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.service;

import qrcodegenerator.entity.Sheet;

/**
 *
 * @author Rizaldi Habibie
 */
public interface SheetService {
     /**
     * 
     * @param @Sheet
     * @return @Sheet 
     */
    public Sheet save(Sheet sheet);
    
    /**
     * 
     * @param @Sheet
     * @return @Sheet
     */
    public Sheet update(Sheet sheet);
}
