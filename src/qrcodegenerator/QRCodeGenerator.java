/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator;


import com.google.zxing.WriterException;
import qrcodegenerator.controller.LoginController;
import qrcodegenerator.ui.LoginPage;
import qrcodegenerator.ui.MainFrame;

/**
 *
 * @author Rizaldi Habibie
 */
public class QRCodeGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WriterException {
        LoginController start = new LoginController();
    }		
}
