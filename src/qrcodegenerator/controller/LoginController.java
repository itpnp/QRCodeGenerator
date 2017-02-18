/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.controller;

import javax.swing.JOptionPane;
import qrcodegenerator.entity.User;
import qrcodegenerator.service.UserPageService;
import qrcodegenerator.service.impl.UserPageServiceImpl;
import qrcodegenerator.ui.LoginPage;
import qrcodegenerator.ui.MainFrame;
import qrcodegenerator.utils.IconProgram;

/**
 *
 * @author Rizaldi Habibie
 */ 
public class LoginController {
    private LoginPage login = new LoginPage(null, true);
    private UserPageService userService = new UserPageServiceImpl();
    
    public LoginController(){
        login.getLoginButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        login.getPasswordField().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        
        login.setVisible(true);
    }
    
    private void login(){
        userService = new UserPageServiceImpl();
        User user = userService.login(login.getUsernameField().getText(), login.getPasswordField().getText());
        if( user != null){
            login.dispose();
            new MainPageController(user);
        } else {
            JOptionPane.showMessageDialog(login.getRootPane(), "Wrong Username or Password", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        login();                
    }                                           

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        login();
    }   
    
}
