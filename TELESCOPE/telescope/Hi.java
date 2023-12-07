package tele;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

 

public class Hi extends JFrame implements ActionListener{

 

//Initializing Components

    JLabel lb, lb1, lb2, lb3, lb4, lb5 , lb6;

    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JButton btn1,btn2;

 

    //Creating Constructor for initializing JFrame components

    Hi() {

        //Providing Title

        super("Fetching Student Information");

 
        setSize(500,400);
        lb = new JLabel("Fetching Student Information From Database");

        lb.setBounds(20, 50, 450, 20);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 20));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

        lb1 = new JLabel("UserName:");

        lb1.setBounds(50, 105, 100, 20);

        tf1 = new JTextField(50);

        tf1.setBounds(160, 105, 100, 20);

        lb2 = new JLabel("Mail-id:");

        lb2.setBounds(50, 135, 100, 20);

        tf2 = new JTextField(100);

        tf2.setBounds(160, 135, 200, 20);

        lb3 = new JLabel("PassWord:");

        lb3.setBounds(50, 165, 100, 20);

        tf3 = new JTextField(50);

        tf3.setBounds(160, 165, 100, 20);

        lb4 = new JLabel("Country:");

        lb4.setBounds(50, 200, 100, 20);

        tf4 = new JTextField(50);

        tf4.setBounds(160, 200, 100, 20);
        lb5 = new JLabel("state:");

        lb5.setBounds(50, 230, 100, 20);

        tf5 = new JTextField(50);

        tf5.setBounds(160, 230, 100, 20);
        lb6 = new JLabel("Phone:");

        lb6.setBounds(50, 260, 100, 20);

        tf6 = new JTextField(50);

        tf6.setBounds(160, 260, 100, 20);

        getContentPane().setLayout(null);

        btn1 = new JButton("Submit");
        btn1.setBounds(110, 317, 85, 21);
        getContentPane().add(btn1);
        btn1.addActionListener(this);  
        
        
        btn2 = new JButton("Clear");
        btn2.setBounds(243, 317, 85, 21);
        getContentPane().add(btn2);
        btn2.addActionListener(this);

        //Add components to the JFrame

        getContentPane().add(lb);

        getContentPane().add(lb1);

        getContentPane().add(tf1);

        getContentPane().add(lb2);

        getContentPane().add(tf2);

        getContentPane().add(lb3);

        getContentPane().add(tf3);

        getContentPane().add(lb4);

        getContentPane().add(tf4);
        getContentPane().add(lb5);

        getContentPane().add(tf5);
        getContentPane().add(lb6);

        getContentPane().add(tf6);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        

 

        //Set TextField Editable False

        tf1.setEditable(true);

        tf2.setEditable(false);

        tf3.setEditable(false);

        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    	setVisible(true);  
        
        
    }
       
public void actionPerformed(ActionEvent e)
{
        	
   if (e.getSource() == btn1)  
         { 
            try {
             //one of the entries to check
            String str = tf1.getText();
            //mandatory driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            //credentials

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "SYSTEM", "1966");
            //query

            PreparedStatement st = con.prepareStatement("select * from reg where name=?");

            st.setString(1, str);

 

            //Excuting Query

            ResultSet rs = st.executeQuery();

            while (rs.next()) 
            {

                String s = rs.getString(1);

                String s1 = rs.getString(2);

                String s2 = rs.getString(3);

                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                String s5 = rs.getString(6);

 

                //Sets Records in TextFields.

                tf1.setText(s);

                tf2.setText(s1);

                tf3.setText(s2);

                tf4.setText(s3);
                
                tf5.setText(s4);
                
                tf6.setText(s5);

            }

        } //Create Exception Handler

        catch (Exception ex) 
        {

            System.out.println(ex);

        }

    }
   else
   {
	   tf1.setText("");

       tf2.setText("");

       tf3.setText("");

       tf4.setText("");
       
       tf5.setText("");
       
       tf6.setText("");
   }
}

//Running Constructor

 

    public static void main(String args[]) {

        new Hi();

    }

}