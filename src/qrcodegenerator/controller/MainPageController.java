/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import qrcodegenerator.entity.User;
import qrcodegenerator.ui.AreaPage;
import qrcodegenerator.ui.AreaView;
import qrcodegenerator.ui.GeneratePage;
import qrcodegenerator.ui.MainFrame;
import qrcodegenerator.ui.ShowQRCodeData;

/**
 *
 * @author Rizaldi Habibie
 */
public class MainPageController {
    private User user;
    private MainFrame main;
    private final AreaController areaController = new AreaController();
    private final GeneratePageController generatePageController = new GeneratePageController();
    private ShowQRCodeData showQRCodeData;
    
    public MainPageController(User user){
         main = new MainFrame(user);
         main.setAreaPage(areaController.getAreaPage());
         main.setAreaView(areaController.getAreaView());
         main.setGeneratePage(generatePageController.getGeneratePage(user));
         addAction();
         main.setVisible(true);
    }
    
    private void addAction(){
        main.getAreaItem().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent avt){
                areaItemActionPerformed(avt);
            }
        });
        
        main.getAreaButton().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent avt){
                areaItemActionPerformed(avt);
            }
        });
        
        main.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        main.getGenerateButton().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent avt){
                generateButtonActionPerformed(avt);
            }
        });
        main.getGenerateItem().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent avt){
                generateItemActionPerformed(avt);
            }
        });
        
        main.getShowQRCodeButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQRCodeButtonActionPerformed(e);
            }
        });
        
        main.getShowItem().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showQRCodeButtonActionPerformed(evt);
            }
        });
    }
    private void generateItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(main.getShowQRCodeData() != null){
            main.getContentPane().remove(main.getShowQRCodeData());
            main.getContentPane().add(main.getDesktopPane1(), java.awt.BorderLayout.CENTER);
            main.getContentPane().add(main.getDesktopPane2(), java.awt.BorderLayout.EAST);
            main.getContentPane().repaint();
            main.pack();
        }
        showGeneratePage(user);
    }          
    
    private void formComponentResized(java.awt.event.ComponentEvent evt) {                                      
        if(main.getAreaPage().isVisible()){
            main.getAreaPage().setSize(main.getDesktopPane1().getSize());
            main.getAreaView().setSize(main.getDesktopPane2().getSize());
        }
        if(main.getGeneratePage().isVisible()){
            main.getGeneratePage().setSize(main.getDesktopPane1().getSize());
        }
    }
    private void showAreaPage(){
//        main.setAreaPage(areaController.getAreaPage());
//        main.setAreaView(areaController.getAreaView());
        main.getDesktopPane1().removeAll();
        main.getDesktopPane1().add(main.getAreaPage());
        main.getAreaPage().setSize(main.getDesktopPane1().getSize());
        main.getAreaPage().setVisible(true);
        
        main.getDesktopPane2().removeAll();
        main.getDesktopPane2().add(main.getAreaView());
        main.getAreaView().setSize(main.getDesktopPane2().getSize());
        main.getAreaView().setVisible(true);

    }
    public void showGeneratePage(User user){
//        main.setGeneratePage(generatePageController.getGeneratePage(user));
        main.getDesktopPane1().removeAll();
        main.getDesktopPane1().add(main.getGeneratePage());
        main.getGeneratePage().setSize(main.getDesktopPane1().getSize());
        main.getGeneratePage().setVisible(true);
        main.getDesktopPane2().removeAll();
    }
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(main.getShowQRCodeData() != null){
            main.getContentPane().remove(main.getShowQRCodeData());
            main.getContentPane().add(main.getDesktopPane1(), java.awt.BorderLayout.CENTER);
            main.getContentPane().add(main.getDesktopPane2(), java.awt.BorderLayout.EAST);
            main.getContentPane().repaint();
            main.pack();
        }
        showGeneratePage(user);
    } 
    private void areaItemActionPerformed(java.awt.event.ActionEvent evt){
       if(main.getShowQRCodeData() != null){
          main.getContentPane().remove(main.getShowQRCodeData());
          main.getContentPane().add(main.getDesktopPane1(), java.awt.BorderLayout.CENTER);
          main.getContentPane().add(main.getDesktopPane2(), java.awt.BorderLayout.EAST);
          main.getContentPane().repaint();
          main.pack();  
        }
        showAreaPage();
    }
    
    private void showQRCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        showQRCodeData = new ShowQRCodeData();
        main.setShowQRCodeData(showQRCodeData);
        main.getContentPane().remove(main.getDesktopPane1());
        main.getContentPane().remove(main.getDesktopPane2());
        main.getContentPane().add(showQRCodeData, BorderLayout.CENTER);
        main.pack();
        
    } 
}
