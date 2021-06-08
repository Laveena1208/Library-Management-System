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
 public class Register extends JFrame implements ActionListener
 {
	JLabel limage;
	JButton bname,bsurname,baddress,bemail_address,bmobile_no,b1,b2;
	JTextField tname,tsurname,taddress,temail_address,tmobile_no;
	Home_Page Hp;
	Register R;
	Register(Home_Page Hp)
	{
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Register.JPG");
		limage=new JLabel(i);
		limage.setBounds(0,0,1920,1080);
		
		bname=new JButton("Name");
		bname.setBackground(Color.BLACK);
		bname.setForeground(Color.WHITE);
		bname.setFont(new Font("osward", Font.BOLD, 13));
		
		bsurname=new JButton("Surname");
		bsurname.setBackground(Color.BLACK);
		bsurname.setForeground(Color.WHITE);
		bsurname.setFont(new Font("osward", Font.BOLD, 13));
		
		baddress=new JButton("Address");
		baddress.setBackground(Color.BLACK);
		baddress.setForeground(Color.WHITE);
		baddress.setFont(new Font("osward", Font.BOLD, 13));
		
		bemail_address=new JButton("EmailAddress");
		bemail_address.setBackground(Color.BLACK);
		bemail_address.setForeground(Color.WHITE);
		bemail_address.setFont(new Font("osward", Font.BOLD, 13));
		
		bmobile_no=new JButton("Mobile_No");
		bmobile_no.setBackground(Color.BLACK);
		bmobile_no.setForeground(Color.WHITE);
		bmobile_no.setFont(new Font("osward", Font.BOLD, 13));
		
		b1=new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("osward", Font.BOLD, 13));
		
		b2=new JButton("Close");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("osward", Font.BOLD, 13));
		
		tname=new JTextField();
		tsurname=new JTextField();
		taddress=new JTextField();
		temail_address=new JTextField();
		tmobile_no=new JTextField();
		
		setTitle("Please Register");
		this.setLayout(null);
		this.setSize(1920, 1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bname.setBounds(50,50,120,25);
		tname.setBounds(250,50,200,25);
		bsurname.setBounds(50,100,120,25);
		tsurname.setBounds(250,100,200,25);
		baddress.setBounds(50,150,130,25);
		taddress.setBounds(250,150,200,25);
		bemail_address.setBounds(50,200,130,25);
		temail_address.setBounds(250,200,200,25);
        bmobile_no.setBounds(50,250,100,25);
		tmobile_no.setBounds(250,250,200,25);
		b1.setBounds(200, 300, 100, 25);
        b2.setBounds(350, 300, 100, 25);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add(limage);
		limage.add(bname);
		limage.add(tname);
		limage.add(bsurname);
		limage.add(tsurname);
		limage.add(baddress);
		limage.add(taddress);
		limage.add(bemail_address);
		limage.add(temail_address);
		limage.add(bmobile_no);
		limage.add(tmobile_no);
		limage.add(b1);
		limage.add(b2);
		
	}
	public void actionPerformed(ActionEvent e) 
    {
        /*if(e.getActionCommand().equals("Submit"))
        {
            JOptionPane.showMessageDialog(R,"Submitted Sucessfully!"); 
        }*/
		  String sub="";
          String s=e.getActionCommand();
          if(s.equals("Submit"))
          {
              JOptionPane.showMessageDialog(R,"Registered Sucessfully!"); 
		
            try
			{
				//Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kithani2001@@");    
				String query ="insert into Register values(?,?,?,?,?)";
				PreparedStatement st =con.prepareStatement(query);
				
				st.setString(1, tname.getText());
				st.setString(2, tsurname.getText());
				st.setString(3, taddress.getText());
				st.setString(4, temail_address.getText());
				st.setString(5, tmobile_no.getText());
				
				st.execute();
				con.close();
            
            
			}
			catch (Exception ee)
			{
				System.out.println(ee);
			}
		} 
		else if(e.getActionCommand().equals("Close"))
        {
          this.setVisible(false);
          Home_Page Hp = new Home_Page();
		
        }
	}
	/*spublic static void main(String args[])
	{
		Register R=new Register();
	}*/
	 
 }