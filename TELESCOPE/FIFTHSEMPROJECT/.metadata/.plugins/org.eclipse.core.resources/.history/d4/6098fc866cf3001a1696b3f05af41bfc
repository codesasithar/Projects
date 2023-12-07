package idcardgeneratingsystem;
//import these libraries
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private ImageIcon format=null;
    String fname=null;
    int s=0;
    byte[] pimage=null;
    int lvalue = 1000;
    
    public Home() {
        initComponents();
    }

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// these codes use for select image from local machine       
JFileChooser fchoser=new JFileChooser();
        fchoser.showOpenDialog(null);
        File f=fchoser.getSelectedFile();
        fname=f.getAbsolutePath();
        ImageIcon micon=new ImageIcon(fname);        
        try {
            File image=new File(fname);
            FileInputStream fis=new FileInputStream(image);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum; (readnum=fis.read(buf)) !=-1;)
            {            
                baos.write(buf,0,readnum);                
            }
            pimage=baos.toByteArray();
            lblimage.setIcon(resizeImage(fname, buf));
        } catch (Exception e) {
        }   
    }  



 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// Thse codes use for set details on printing panel        
String cou=txtcountry.getText();
        String date=((JTextField)idate.getDateEditor().getUiComponent()).getText();
        String birthday=((JTextField)bdate.getDateEditor().getUiComponent()).getText();
        String name= txtname.getText();
        String adress= txtadress.getText();
        String gender = cmbgender.getSelectedItem().toString();
        String info = txtinfo.getText();
        
        
        
        lblcountry.setText(cou);
        lbldate.setText(date);
        lblbcountry.setText(cou);
        lblname.setText(name);
        lblbday.setText(birthday);
        lbladress.setText(adress);
        lblgender.setText(gender);
        lblinfor.setText(info);
        
        //id number generate
        String year= birthday.substring(2, 4);
       // JOptionPane.showMessageDialog(rootPane, year);
        int genvalue=0;
        if(gender.equals("Male")) // 
        {
            genvalue=100;
        }
        else{
            genvalue=500;
        }
        
        lvalue++;
        
        String gen = String.valueOf(genvalue);
        String las = String.valueOf(lvalue);
        String nic= year+gen+las+"V";
        
        lblnic.setText(nic);
        
        
        
        
        
    }                                        

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// these codes use to print panel       
  try {
            Toolkit tkp = panelid.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    panelid.print(g);
    g.dispose();
    pjp.end();
            
        } catch (Exception e) {
        }
    }       

This method use to resize image to fit lable
 public ImageIcon resizeImage(String imagePath, byte[] pic){
          
        ImageIcon myImage=null;
        if(imagePath !=null)
        {
        myImage=new ImageIcon(imagePath);
        
        }else{
         myImage=new ImageIcon(pic);
        }
                
        Image img=myImage.getImage();
        Image img2=img.getScaledInstance(lblimage.getHeight(), lblimage.getWidth(),  Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(img2);
        return image;
    } 