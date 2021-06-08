import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 91963
 */
public class Login_Page extends JFrame implements ActionListener
{
	JButton  bUsername,bPassword,bLogin,bClose;
	JLabel limage;
	JTextField tUsername;
	JPasswordField tPassword;
	Home_Page Hp;
	Login_Page(Home_Page Hp)
	{
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Login_Page(image).JPG");
		limage = new JLabel(i);
		limage.setBounds(0, 0, 1920, 1080);
		
		bUsername = new JButton("Username");bUsername.setBackground(Color.BLACK);bUsername.setForeground(Color.WHITE);bUsername.setFont(new Font("osward", Font.BOLD, 18));
		bPassword = new JButton("Password");bPassword.setBackground(Color.BLACK);bPassword.setForeground(Color.WHITE);bPassword.setFont(new Font("osward", Font.BOLD, 18));
		bLogin = new JButton("Login");bLogin.setBackground(Color.BLACK);bLogin.setForeground(Color.WHITE);bLogin.setFont(new Font("osward", Font.BOLD, 18));
		bClose = new JButton("Close");bClose.setBackground(Color.BLACK);bClose.setForeground(Color.WHITE);bClose.setFont(new Font("osward", Font.BOLD, 18));
		tUsername=new JTextField();
		tPassword=new JPasswordField();
		this.setLayout(null);
        this.setSize(1920, 1080);
		bUsername.setBounds(610,350,150,30);
		bPassword.setBounds(610,420,150,30);
		bLogin.setBounds(680,480,90,45);
		bClose.setBounds(780,480,90,45);
		tUsername.setBounds(790,350,200,32);
		tPassword.setBounds(790,420,200,32);
		
		//JOptionPane.showMessageDialog(Close,"Hello, Welcome to Javatpoint.");  
		
		add(limage);
		limage.add(bUsername);
		limage.add(bPassword);
		limage.add(bLogin);
		limage.add(bClose);
		limage.add(tUsername);
		limage.add(tPassword);
		bLogin.addActionListener(this);
		bClose.addActionListener(this);
		setLayout(null);
		setTitle("Please Login");
		setSize(1920,1080);
		setLocation(10,10);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public void actionPerformed(ActionEvent e) 
    {
		  String sub="";
          String s=e.getActionCommand();
          if(s.equals("Login"))
          {
              this.setVisible(false);
			  Menu_Page Mp = new Menu_Page(this);
            try
			{
				//Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kithani2001@@");    
				String query ="insert into StudentLogin values(?,?)";
				PreparedStatement st =con.prepareStatement(query);
				
				st.setString(1, tUsername.getText());
				st.setString(2, tPassword.getText());
				
					st.execute();
				con.close();
            
            
			}
			catch (Exception ee)
			{
				System.out.println(ee);
			}
		} 
	  /* else if(e.getActionCommand().equals("Login"))
        {
            this.setVisible(false);
            Menu_Page Mp = new Menu_Page(this);
        }*/
		else if(e.getActionCommand().equals("Close"))
        {
            this.setVisible(false);
            Home_Page Hp = new Home_Page();
		
        }
	}
	/*public static void main(String args[])
	{
		Login_Page Lp = new Login_Page();
	}*/
}

