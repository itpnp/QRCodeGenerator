/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qrcodegenerator.entity.Khusus;
import qrcodegenerator.service.KhususService;
import qrcodegenerator.service.impl.KhususServiceImpl;

/**
 *
 * @author Rizaldi Habibie
 */
public final class ShowQRCodeData extends javax.swing.JPanel {
private KhususService khususService = new KhususServiceImpl();
private List<Khusus> listAllDataKhusus, temporaryList;
private Vector<String> tableHeaders;
private Vector tableData;
private Locale lokal;
private boolean searchData;
private List<Khusus> searchList;
        
    /**
     * Creates new form ShowQRCodeData
     */
    public ShowQRCodeData() {
        initComponents();
        listAllDataKhusus = khususService.showAll();
        showData(listAllDataKhusus);
        startDate.setFormats("dd MMMM yyyy");
        endDate.setFormats("dd MMMM yyyy");
    }
    public boolean search(){
        searchList = new ArrayList<>();
        if(!typeParameter.getText().equals("") && !productParameter.getText().equals("") && startDate.getDate()!= null && endDate.getDate()!= null){
            for(Khusus khusus : khususService.findByDate(startDate.getDate(), endDate.getDate())){
                if(khusus.getMasterProduct().getNamaBarang().toLowerCase().contains(productParameter.getText().toLowerCase())) {
                   searchList.add(khusus);
                } 
            }
            for(Iterator<Khusus> iterator = searchList.iterator(); iterator.hasNext(); ){
                if(!iterator.next().getMasterProduct().getType().contains(typeParameter.getText().toLowerCase())) {
                   searchList.remove(iterator);
                } 
            }
        }else if (typeParameter.getText().equals("") && !productParameter.getText().equals("") && startDate.getDate()!= null && endDate.getDate()!= null) {
            for(Khusus khusus : khususService.findByDate(startDate.getDate(), endDate.getDate())){
                if(khusus.getMasterProduct().getNamaBarang().toLowerCase().contains(productParameter.getText().toLowerCase())) {
                   searchList.add(khusus);
                } 
            }
        }else if(typeParameter.getText().equals("")  && productParameter.getText().equals("")  && startDate.getDate()!= null && endDate.getDate()!= null){
            searchList = khususService.findByDate(startDate.getDate(), endDate.getDate());
        }else if(!typeParameter.getText().equals("")  && productParameter.getText().equals("")  && startDate.getDate()!= null && endDate.getDate()!= null){
            for(Khusus khusus : khususService.findByDate(startDate.getDate(), endDate.getDate())){
                if(khusus.getMasterProduct().getType().toLowerCase().contains(typeParameter.getText().toLowerCase())) {
                   searchList.add(khusus);
                } 
            }
        }else if(!typeParameter.getText().equals("")  && productParameter.getText().equals("")  && startDate.getDate()== null && endDate.getDate()== null){
            for(Khusus khusus : listAllDataKhusus){
                if(khusus.getMasterProduct().getType().toLowerCase().contains(typeParameter.getText().toLowerCase())) {
                   searchList.add(khusus);
                } 
            }
        }else if(typeParameter.getText().equals("")  && !productParameter.getText().equals("")  && startDate.getDate()== null && endDate.getDate()== null){
            for(Khusus khusus : listAllDataKhusus){
                if(khusus.getMasterProduct().getType().toLowerCase().contains(productParameter.getText().toLowerCase())) {
                   searchList.add(khusus);
                } 
            }
        }
        showData(searchList);
        return searchData = true;
    }
    public void showData(List<Khusus> lists){
        try{
            tableHeaders = new Vector<>();
            tableData = new Vector();
            this.tableHeaders.add("Numerator");
            this.tableHeaders.add("Code");
            this.tableHeaders.add("Status");
            this.tableHeaders.add("Tanggal");
            this.tableHeaders.add("Area");
            this.tableHeaders.add("Nama Barang");
            this.tableHeaders.add("Sheet");
            for(Object obj : lists){
                Khusus khusus = (Khusus) obj;
                Vector<Object> row = new Vector<>();
                row.add(khusus.getQrcodeNumerator());
                row.add(khusus.getKodeUnik());
                row.add(khusus.getStatus());
                row.add(khusus.getTanggalCetakPertama());
                row.add(khusus.getArea().getNamaArea());
                row.add(khusus.getMasterProduct().getNamaBarang());
                row.add(khusus.getSheet().getSheetId());
                tableData.add(row);
            }
            viewTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Sorry, Problems Appear"+e);
        }
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        radioGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        printedButton = new javax.swing.JRadioButton();
        noPrintedButton = new javax.swing.JRadioButton();
        allData = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startDate = new org.jdesktop.swingx.JXDatePicker();
        endDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productParameter = new javax.swing.JTextField();
        typeParameter = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(viewTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 510;
        gridBagConstraints.ipady = 186;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        radioGroup.add(printedButton);
        printedButton.setText("Sudah Dicetak");
        printedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printedButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanel2.add(printedButton, gridBagConstraints);

        radioGroup.add(noPrintedButton);
        noPrintedButton.setText("Belum Dicetak");
        noPrintedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPrintedButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanel2.add(noPrintedButton, gridBagConstraints);

        radioGroup.add(allData);
        allData.setText("Semua Data");
        allData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanel2.add(allData, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel2.add(jButton1, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filter", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Dari Tanggal");

        jLabel2.setText("Sampai Tanggal");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Tipe Barang");

        productParameter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        typeParameter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        searchButton.setBackground(new java.awt.Color(51, 51, 51));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qrcodegenerator/images/search-icon.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productParameter)
                    .addComponent(typeParameter, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton)
                .addGap(0, 68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(productParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(typeParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void printedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printedButtonActionPerformed
        temporaryList = new ArrayList<>();
        if(searchData){
           for(Khusus khusus : searchList){
            if(khusus.getStatus().equals("Printed")){
                temporaryList.add(khusus);
            }
          } 
        }else{
          for(Khusus khusus : listAllDataKhusus){
            if(khusus.getStatus().equals("Printed")){
                temporaryList.add(khusus);
            }
        }  
        }
        
        showData(temporaryList);        
    }//GEN-LAST:event_printedButtonActionPerformed

    private void noPrintedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPrintedButtonActionPerformed
        temporaryList = new ArrayList<>();
        if(searchData){
           for(Khusus khusus : searchList){
            if(khusus.getStatus().equals("Not Printed")){
                temporaryList.add(khusus);
            }
          } 
        }else{
          for(Khusus khusus : listAllDataKhusus){
            if(khusus.getStatus().equals("Not Printed")){
                temporaryList.add(khusus);
            }
         }  
        }
        
        showData(temporaryList);
    }//GEN-LAST:event_noPrintedButtonActionPerformed

    private void allDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allDataActionPerformed
        searchData = false;
        showData(listAllDataKhusus);
    }//GEN-LAST:event_allDataActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ReprintDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allData;
    private org.jdesktop.swingx.JXDatePicker endDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton noPrintedButton;
    private javax.swing.JRadioButton printedButton;
    private javax.swing.JTextField productParameter;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JButton searchButton;
    private org.jdesktop.swingx.JXDatePicker startDate;
    private javax.swing.JTextField typeParameter;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
