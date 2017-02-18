/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.utils;

import com.google.zxing.EncodeHintType;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.MediaTray;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import qrcodegenerator.entity.Area;
import qrcodegenerator.entity.Khusus;
import qrcodegenerator.entity.MasterProduct;
import qrcodegenerator.entity.Sheet;
import qrcodegenerator.entity.User;
import qrcodegenerator.service.KhususService;
import qrcodegenerator.service.SheetService;
import qrcodegenerator.service.impl.KhususServiceImpl;
import qrcodegenerator.service.impl.SheetServiceImpl;


/**
 *
 * @author Rizaldi Habibie
 */
public class PrintQRCode {
    private File file;
    private String numerator;
    private int i = 0;
    private KhususService khususService;
    private List<String> numerators;
    private Sheet sheetNumber;
    private SheetService sheetService;
    
    public void generateNewQRCode(MasterProduct masterProduct, Area area, User user, int sheet){
        khususService = new KhususServiceImpl();
        sheetService = new SheetServiceImpl();
        List<List<Khusus>> listOfLists = new ArrayList<>();
        Date date = Calendar.getInstance().getTime();
        try {
            Map<EncodeHintType, Object> hints;
            hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 1); /* default = 4 */
            List<JasperPrint> listJasper = new ArrayList<>();
            for(int j=0; j<sheet; j++){
                List<Khusus> listKhusus = new ArrayList<>();
                sheetNumber = new Sheet();
                sheetNumber.setTotalPrint(0);
                sheetNumber.setLastPrinted(null);
                sheetService.save(sheetNumber);
                Map parameter = new HashMap();
                InputStream in = this.getClass().getClassLoader().getResourceAsStream("qrcodegenerator/utils/QRCodeTemplate2.jrxml");
                List<String> codes = khususService.generateUniqueCode(area);
                numerators = khususService.generateNumerator();
                for(Object obj : numerators){
                    numerator =  (String) obj;
                    Khusus khusus = new Khusus();
                    khusus.setMasterProduct(masterProduct);
                    khusus.setQrcodeNumerator(numerator);
                    khusus.setArea(area);
                    khusus.setKodeUnik(codes.get(i));
                    khusus.setStatus("Not Printed");
                    khusus.setTanggalCetakPertama(date);
                    khusus.setSheet(sheetNumber);
                    khusus.setUser(user);
                    listKhusus.add(khusus);
                    parameter.put("numerator_"+i, numerator);
                    parameter.put("qrCode_"+i,codes.get(i));
                    i++;
                }
                parameter.put("productName", masterProduct.getNamaBarang());
                parameter.put("client", masterProduct.getClient());
                parameter.put("number", masterProduct.getSpecialNumber());
                parameter.put("qty", "QTY. "+masterProduct.getJumlah());
                parameter.put("type", masterProduct.getType());
                parameter.put("map", hints);
                parameter.put("IS_IGNORE_PAGINATION", true);
                JasperDesign design = JRXmlLoader.load(in); //Location of jrxml file example FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/rep‌​orts/" + "myReport"+".jrxml");
                design.setBottomMargin(0);
                net.sf.jasperreports.engine.JasperReport JRpt = net.sf.jasperreports.engine.JasperCompileManager.compileReport(design);   
                JasperPrint printer = JasperFillManager.fillReport( JRpt, parameter, new JREmptyDataSource());
                listJasper.add(printer);
                khususService.saveAll(listKhusus);
                listOfLists.add(listKhusus);
                i=0;
            }
            print(listJasper, khususService, listOfLists);
        }catch(JRException | PrinterException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void print(List<JasperPrint> printer, KhususService khususService, List<List<Khusus>> listOfLists) throws PrinterException, JRException{
            /* Create an array of PrintServices */
         this.khususService = khususService;
         sheetService = new SheetServiceImpl();
         Sheet sheet;
         Set<Sheet> sheets = new HashSet<>();
         PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
         int selectedService = 0;
         PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
         printRequestAttributeSet.add(MediaSizeName.NA_LEGAL);
         printRequestAttributeSet.add(MediaTray.MANUAL);
         printRequestAttributeSet.add(new Copies(1));
         JRPrintServiceExporter exporter = new JRPrintServiceExporter();
         exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, printer);
            /* We set the selected service and pass it as a paramenter */
         exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
         exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
         exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
         exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
         exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
         exporter.exportReport();
         for(int x=0; x<exporter.getPrintStatus().length;x++){
             if(exporter.getPrintStatus()[x]){
               for(Object obj : listOfLists.get(x)){
                  ((Khusus) obj).setStatus("Printed");
                  sheet = ((Khusus) obj).getSheet();
                  sheets.add(sheet);
               }
               khususService.updateAll(listOfLists.get(x));
             }
         }
         for(Object obj : sheets){
             ((Sheet) obj).setTotalPrint(((Sheet) obj).getTotalPrint()+1);
             sheetService.update((Sheet) obj);
         }
    }
    
    public void rePrintQRCode(List<Integer> sheetNumber){
        khususService = new KhususServiceImpl();
        Map<EncodeHintType, Object> hints;
        hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1); /* default = 4 */
        List<JasperPrint> listJasper = new ArrayList<>();
        List<Khusus> listOfKhusus;
        List<List<Khusus>> listOfLists = new ArrayList<>();
        try{
            for(Integer number : sheetNumber){
            Map parameter = new HashMap();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("qrcodegenerator/utils/QRCodeTemplate2.jrxml");
            listOfKhusus = khususService.findBySheet(number);
            for(Khusus khusus : listOfKhusus){
                parameter.put("numerator_"+i, khusus.getQrcodeNumerator());
                parameter.put("qrCode_"+i,khusus.getKodeUnik());
                parameter.put("productName", khusus.getMasterProduct().getNamaBarang());
                parameter.put("client", khusus.getMasterProduct().getClient());
                parameter.put("number", khusus.getMasterProduct().getSpecialNumber());
                parameter.put("qty", "QTY. "+khusus.getMasterProduct().getJumlah());
                parameter.put("type", khusus.getMasterProduct().getType());
                parameter.put("map", hints);
                parameter.put("IS_IGNORE_PAGINATION", true);
                i++;
            }
            JasperDesign design = JRXmlLoader.load(in); //Location of jrxml file example FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/rep‌​orts/" + "myReport"+".jrxml");
            design.setBottomMargin(0);
            net.sf.jasperreports.engine.JasperReport JRpt = net.sf.jasperreports.engine.JasperCompileManager.compileReport(design);   
            JasperPrint printer = JasperFillManager.fillReport( JRpt, parameter, new JREmptyDataSource());
            listJasper.add(printer);
            listOfLists.add(listOfKhusus);
            i=0;
            }
            print(listJasper, khususService, listOfLists);
        }catch(JRException | PrinterException e){
           JOptionPane.showMessageDialog(null, "Print Ulang Gagal\n" + e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
