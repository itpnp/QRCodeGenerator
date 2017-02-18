/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.entity;

import java.util.Date;

/**
 *
 * @author Rizaldi Habibie
 */
public class Sheet {
    
   private Integer sheetId; 
   private Integer totalPrint;
   private Date lastPrinted;

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Integer getTotalPrint() {
        return totalPrint;
    }

    public void setTotalPrint(Integer totalPrint) {
        this.totalPrint = totalPrint;
    }

    public Date getLastPrinted() {
        return lastPrinted;
    }

    public void setLastPrinted(Date lastPrinted) {
        this.lastPrinted = lastPrinted;
    }
   
}
