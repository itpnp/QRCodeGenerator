/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.utils;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Rizaldi Habibie
 */
public class IconProgram {


    public void setIcon(JFrame jFrame, JDialog jDialog){
    String urlGambar = "qrcodegenerator/images/program_icon.jpg";
    ImageIcon gambar = new ImageIcon(getClass().getClassLoader().getResource(urlGambar));
    
    if(jFrame ==null){
        jDialog.setIconImage(gambar.getImage());
    }else{
        jFrame.setIconImage(gambar.getImage());
    }
    }
}
