/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.utils;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthContext;
import javax.swing.plaf.synth.SynthPainter;

/**
 *
 * @author Rizaldi Habibie
 */
public class BackgroundPainter extends SynthPainter{
    
 
     @Override
     public void paintPanelBackground(SynthContext context,
                                    Graphics g, int x, int y,
                                    int w, int h)
   {
      Color start = UIManager.getColor("Panel.startBackground");
      Color end = UIManager.getColor("Panel.endBackground");
      Graphics2D g2 = (Graphics2D)g;
      GradientPaint grPaint = new GradientPaint(
          (float)x, (float)y, start,
          (float)w, (float)h, end);
      g2.setPaint(grPaint);
      g2.fillRect(x, y, w, h);
      g2.setPaint(null);
      g2.setColor(new Color(255, 255, 255, 255));
      g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//      CubicCurve2D.Double arc2d = new CubicCurve2D.Double(
//          0, h/4, w/3, h/10, 66 * w, 1.5 * h, w, h/8);
//      g2.draw(arc2d);
      g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
   }

}
