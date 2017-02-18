/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qrcodegenerator.entity.Area;
import qrcodegenerator.service.AreaService;
import qrcodegenerator.service.impl.AreaServiceImpl;
import qrcodegenerator.ui.AreaPage;
import qrcodegenerator.ui.AreaView;

/**
 *
 * @author Rizaldi Habibie
 */
public class AreaController {
    private AreaPage areaPage;
    private AreaView areaView;
    private Area area;
    private List<Area> areas;
    private final AreaService areaService = new AreaServiceImpl();
    
    private void addAreaPageAction(){
        areaPage.getAddButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButtonActionPerformed(e);
            }
        });
        areaPage.getEditButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed(e);
            }
        });
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt){
        if(areaPage.getAreaCodeField().getText().isEmpty() || areaPage.getAreaCodeField().getText()== null){
            JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(areaPage.getAreaNameField().getText().isEmpty() || areaPage.getAreaNameField().getText()== null){
                JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }else{
                area = new Area();
                area.setKodeArea(areaPage.getAreaCodeField().getText());
                area.setNamaArea(areaPage.getAreaNameField().getText());
                area = areaService.addArea(area);
                showAllArea();
                empty();
            }
        }
    }
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt){
        if(areaPage.getViewTable().getSelectedRow() != -1){
          area = (Area) areas.get(areaPage.getViewTable().convertRowIndexToModel(areaPage.getViewTable().getSelectedRow()));
          String newAreaName = JOptionPane.showInputDialog(areaPage.getContentPane(), "Masukkan Nama Area Baru");
          area.setNamaArea(newAreaName);
          areaService.updateArea(area);
          showAllArea();
        }else{
            JOptionPane.showMessageDialog(areaPage.getContentPane(), "Pilih Area Yang Akan Dirubah", "Perhatian", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void empty(){
        areaPage.getAreaCodeField().setText("");
        areaPage.getAreaNameField().setText("");
    }
    private void showAllArea(){
        Vector<String> tableHeaders = new Vector<>();
        Vector tableData = new Vector();
        tableHeaders.add(("Kode Area"));
        tableHeaders.add("Nama Area");
        areas = areaService.showAllArea();
        for(Object obj:areas ){
            Area rowArea = (Area) obj;
            Vector<Object> row = new Vector<>();
            row.add(rowArea.getKodeArea());
            row.add(rowArea.getNamaArea());
            tableData.add(row);
        }
        areaPage.getViewTable().setModel(new DefaultTableModel(tableData,tableHeaders));
    }
    private void addPageViewAction(){
        
    }
    private void showAreaCount(){
        Vector<String> tableHeaders = new Vector<>();
        Vector tableData = new Vector();
        tableHeaders.add(("Nama Area"));
        tableHeaders.add("Jumlah Dicetak");
        for(Object object : areas){
            Area area = (Area) object;
            Vector<Object> row = new Vector<>();
            row.add(area.getNamaArea());
            row.add(areaService.getAreaCount(area.getKodeArea()));
            tableData.add(row);
        }
        areaView.getViewTable().setModel(new DefaultTableModel(tableData,tableHeaders));
    }
    public AreaPage getAreaPage(){
        areaPage = new AreaPage();
        showAllArea();
        addAreaPageAction();
        return areaPage;
    }
    
    public AreaView getAreaView(){
        areaView = new AreaView();
        showAreaCount();
        return areaView;
    }
}
