package tele;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

public class Login extends JFrame implements ActionListener

{

    JLabel l1, l2, l3;

    JTextField tf1;

    JButton btn1;

    JPasswordField p1;

 

    Login()

    {

        setTitle("Login Form For ERP");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	pack();
    	setSize(277,222);
    	 

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

        l1 = new JLabel("Login Form:");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

 

        l2 = new JLabel("Enter UserName:");

        l3 = new JLabel("Enter Password:");

        tf1 = new JTextField();

        p1 = new JPasswordField();

        btn1 = new JButton("Submit");

 

        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);

        tf1.setBounds(300, 70, 200, 30);

        p1.setBounds(300, 110, 200, 30);

        btn1.setBounds(150, 160, 100, 30);

 

        getContentPane().add(l1);

        getContentPane().add(l2);

        getContentPane().add(tf1);

        getContentPane().add(l3);

        getContentPane().add(p1);

        getContentPane().add(btn1);

        btn1.addActionListener(this);
        
        setVisible(true); 

    }

 

    public void actionPerformed(ActionEvent e)

    {

        showData();

    }

 

    public void showData()

    {

         

        String str1 = tf1.getText();

        char[] p = p1.getPassword();

        String str2 = new String(p);

        try

        {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","SYSTEM","1966");

            PreparedStatement ps = con.prepareStatement("select name from reg where name=? and pass=?");

            ps.setString(1, str1);

            ps.setString(2, str2);

            ResultSet rs = ps.executeQuery();

            if (rs.next())

            {
                Hi dispaly =new Hi();
                dispaly.setVisible(true);
                 
            } else

            {

                JOptionPane.showMessageDialog(null,"Incorrect User-Id or password..Try Again with correct detail");

            }

        }

        catch (Exception ex)

        {

            System.out.println(ex);

        }

    }

 

    public static void main(String arr[])

    {

        new Login();

    }

}