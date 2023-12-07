package tele;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;  
public class Registration extends JFrame implements ActionListener
{  
	
    JLabel l1, l2, l3, l4, l5, l6, l7, l8,regnum;  
    JTextField tf1, tf2, tf5, tf6, tf7,regnumtext;  
    JButton btn1, btn2;  
    JPasswordField p1, p2; 
    //Importing image...
    Image img = Toolkit.getDefaultToolkit().getImage("c:\\chck\\check.jpg");
    

   
       

  
    
    Registration()  
    {   
    	//Background Picture
    	 this.setContentPane(new JPanel() {
        
             public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
             }
          });
        
    	
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("Registration Form ");  
        l1 = new JLabel("Registration Form For ERP:");  
        l1.setForeground(Color.red);  
        l1.setFont(new Font("Roman", Font.BOLD, 20)); 
        regnum = new JLabel("Registration Number:");
        l2 = new JLabel("Name:");  
        l3 = new JLabel("Email-ID:");
        JLabel label = new JLabel();
        l4 = new JLabel("Create Passowrd:");  
        l5 = new JLabel("Confirm Password:");  
        l6 = new JLabel("Country:");  
        l7 = new JLabel("State:");  
        l8 = new JLabel("Phone No:");   
        tf1 = new JTextField();  
        tf2 = new JTextField();  
        p1 = new JPasswordField();  
        p2 = new JPasswordField();  
        regnumtext = new JTextField();
        tf5 = new JTextField();  
        tf6 = new JTextField();  
        tf7 = new JTextField();  
        btn1 = new JButton("Submit");  
        btn2 = new JButton("Clear");  
        btn1.addActionListener(this);  
        btn2.addActionListener(this);
      //Component's sizes
        l1.setBounds(80, 10, 261, 30); 
        regnum.setBounds(80,38,200,30);
        l2.setBounds(80, 70, 200, 30);  
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);  
        l5.setBounds(80, 190, 200, 30);  
        l6.setBounds(80, 230, 200, 30);  
        l7.setBounds(80, 270, 200, 30);  
        l8.setBounds(80, 310, 200, 30); 
        
        regnumtext.setBounds(300,38,200,30);
        
        tf1.setBounds(300, 70, 200, 30);  
        tf2.setBounds(300, 110, 200, 30);  
        p1.setBounds(300, 150, 200, 30);  
        p2.setBounds(300, 190, 200, 30);  
        tf5.setBounds(300, 230, 200, 30);  
        tf6.setBounds(300, 270, 200, 30);  
        tf7.setBounds(300, 310, 200, 30);  
        btn1.setBounds(50, 350, 100, 30);  
        btn2.setBounds(170, 350, 100, 30);  
        //Adding buttons to frame
        getContentPane().add(l1);  
        getContentPane().add(l2);  
        getContentPane().add(tf1);  
        getContentPane().add(l3);  
        getContentPane().add(tf2);  
        getContentPane().add(l4);  
        getContentPane().add(p1);  
        getContentPane().add(l5);  
        getContentPane().add(p2);  
        getContentPane().add(l6);  
        getContentPane().add(tf5);  
        getContentPane().add(l7);  
        getContentPane().add(tf6);  
        getContentPane().add(l8);  
        getContentPane().add(tf7);  
        getContentPane().add(btn1);  
        getContentPane().add(btn2);  
        getContentPane().add(label);
        getContentPane().add(regnum);
        
        getContentPane().add(regnumtext);
        
        setSize(376, 290);
        getContentPane().setLayout(null);      
      
        
        setVisible(true);
        
    }  

    public void actionPerformed(ActionEvent e)   
    {  
    	  String s0 = "1000";
        if (e.getSource() == btn1)  
         {  
            int x = 0;  
            
          
            int regno = Integer.parseInt(s0);
            regno = regno+1;
            String regnot = Integer.toString(regno); 
            regnumtext.setText(regnot);
           
            String s1 = tf1.getText();  
            String s2 = tf2.getText();  
            char[] s3 = p1.getPassword();  
            char[] s4 = p2.getPassword();   
            String s8 = new String(s3);  
            String s9 = new String(s4);  
            String s5 = tf5.getText();  
            String s6 = tf6.getText();  
            String s7 = tf7.getText();  
            if (s8.equals(s9))  
            {  
                try  
                {  
                    Class.forName("oracle.jdbc.driver.OracleDriver");  
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "SYSTEM", "1966");  
                    PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?,?,?)");  
                    ps.setString(1, s0);
                    ps.setString(2, s1);
                    ps.setString(3, s2);  
                    ps.setString(4, s8);  
                    ps.setString(5, s5);  
                    ps.setString(6, s6);  
                    ps.setString(7, s7);  
                    ResultSet rs = ps.executeQuery();  
                    x++;  
                 /*   if (x > 0)   
                    {  
                    	JOptionPane.showMessageDialog(btn1, "Data saved successfully");
                    	if (JOptionPane.showConfirmDialog(null, "Do you want to visit login form?", "Conformation",
                    	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    		//Login Page object creation
                    		Login log =new Login();
                    		log.setVisible(true);
                    	    
                    	} 
                    	else 
                    	
                    	{
                           System.exit(0);
                    	}  
                    } */ 
                }  
                catch (Exception ex)   
                {  
                	JOptionPane.showMessageDialog(btn1, "Duplicate Entry Not allowed\nPlease enter a alid data");
                    System.out.println(ex);  
                }  
            }    
          }   
          else  
          {  
            regnumtext.setText("");  
            tf1.setText("");  
            tf2.setText("");  
            p1.setText("");  
            p2.setText("");  
            tf5.setText("");  
            tf6.setText("");  
            tf7.setText("");  
          }  
    }   
    
    
   

    
    public static void main(String args[]) throws IOException  
    {  
        new Registration();  
       
          
    }  
}  