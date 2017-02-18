/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.controller;

import java.awt.event.ActionEvent;
import qrcodegenerator.entity.Area;
import qrcodegenerator.entity.MasterProduct;
import qrcodegenerator.entity.User;
import qrcodegenerator.service.KhususService;
import qrcodegenerator.service.ProductService;
import qrcodegenerator.service.impl.KhususServiceImpl;
import qrcodegenerator.service.impl.ProductServiceImpl;
import qrcodegenerator.ui.ChooseArea;
import qrcodegenerator.ui.ChooseProduct;
import qrcodegenerator.ui.GeneratePage;
import qrcodegenerator.utils.PrintQRCode;

/**
 *
 * @author Rizaldi Habibie
 */
public class GeneratePageController {
    private GeneratePage generatePage;
    private KhususService khususService;
    private PrintQRCode print = new PrintQRCode();
    private Area area;
    private ProductService productService;
    private MasterProduct masterProduct;
    private User user;
    
    
    private void addAction(){
        generatePage.getGenerateButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateButtonActionPerformed(e);
            }
        });
         generatePage.getChooseProductLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseProductLabelMouseClicked(evt);
            }
        });
         generatePage.getChooseAreaLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseAreaLabelMouseClicked(evt);
            }
        });
    }
    public void setArea(Area area){
        this.area = area;
        generatePage.getAreaField().setText(area.getNamaArea());
    }
    public Area getArea(){
        return area;
    }
    public void setMasterProduct(MasterProduct masterProduct){
        this.masterProduct = masterProduct;
        generatePage.getProductCodeField().setText(masterProduct.getKodeBarang());
        generatePage.getProductNameField().setText(masterProduct.getNamaBarang());
        generatePage.getClientField().setText(masterProduct.getClient());
        generatePage.getSpecialNumberField().setText(masterProduct.getSpecialNumber());
        generatePage.getTypeField().setText(masterProduct.getType());
        generatePage.getTotalField().setText(""+masterProduct.getJumlah());
        
    }
    public void empty(){
        generatePage.getProductCodeField().setText("");
        generatePage.getProductNameField().setText("");
        generatePage.getClientField().setText("");
        generatePage.getSpecialNumberField().setText("");
        generatePage.getTypeField().setText("");
        generatePage.getAreaField().setText("");
        generatePage.getTotalField().setText("");
        area = null;
        masterProduct = null;
        generatePage.getTotalSheetField().setText("");
    }
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        if(masterProduct == null){
         masterProduct = new MasterProduct();
         masterProduct.setKodeBarang(generatePage.getProductCodeField().getText());
         masterProduct.setNamaBarang(generatePage.getProductNameField().getText());
         masterProduct.setClient(generatePage.getClientField().getText());
         masterProduct.setSpecialNumber(generatePage.getSpecialNumberField().getText());
         masterProduct.setType(generatePage.getTypeField().getText());
         masterProduct.setJumlah(Integer.parseInt(generatePage.getTotalField().getText()));
         productService = new ProductServiceImpl();
         productService.addProduct(masterProduct);
        }
        khususService = new KhususServiceImpl();
        
        print.generateNewQRCode(masterProduct, area,user, Integer.parseInt(generatePage.getTotalSheetField().getText()));
        empty();
    } 
    private void chooseProductLabelMouseClicked(java.awt.event.MouseEvent evt) {                                                
        // TODO add your handling code here:
        new ChooseProduct(null, true, this).setVisible(true);
    }   
    private void chooseAreaLabelMouseClicked(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
        new ChooseArea(null, true, this).setVisible(true);
    } 
   
    public GeneratePage getGeneratePage(User user){
        this.user = user;
        generatePage = new GeneratePage(user);
        this.addAction();
        return generatePage;
    }
}
