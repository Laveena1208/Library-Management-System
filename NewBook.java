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
 public class NewBook extends JFrame implements ActionListener
 {
	 JLabel limage;
	 JTextField tBookid,tname,tpublisher,tpublisheryear;
	 JButton b1,b2,bBookid,bname,bpublisher,bpublisherYear;
	  Menu_Page Mp;
	  NewBook NB;
	  Login_Page Lp;
	  NewBook(Menu_Page Mp)
	 {
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\NewStudent(image).JPG");
		limage=new JLabel(i);
		limage.setBounds(0, 0, 1920, 1080);
		bBookid = new JButton("BookID: ");bBookid.setBackground(Color.BLACK);bBookid.setForeground(Color.WHITE);bBookid.setFont(new Font("osward", Font.BOLD, 13));
		bname = new JButton("Name: ");bname.setBackground(Color.BLACK);bname.setForeground(Color.WHITE);bname.setFont(new Font("osward", Font.BOLD, 13));
		bpublisher = new JButton("Publisher ");bpublisher.setBackground(Color.BLACK);bpublisher.setForeground(Color.WHITE);bpublisher.setFont(new Font("osward", Font.BOLD, 13));
		bpublisherYear = new JButton("PublisherYear ");bpublisherYear.setBackground(Color.BLACK);bpublisherYear.setForeground(Color.WHITE);bpublisherYear.setFont(new Font("osward", Font.BOLD, 13));
		tBookid=new JTextField();
		tname=new JTextField();
		tpublisher=new JTextField();
		tpublisheryear=new JTextField();
		b1=new JButton("Save");b1.setBackground(Color.BLACK);b1.setForeground(Color.WHITE);b1.setFont(new Font("osward", Font.BOLD, 13));
        b2=new JButton("Close");b2.setBackground(Color.BLACK);b2.setForeground(Color.WHITE);b2.setFont(new Font("osward", Font.BOLD, 13));
		this.setLayout(null);
        this.setSize(1920, 1080);
		
		
		bBookid.setBounds(50,50,120,25);
		tBookid.setBounds(250,50,200,25);
		bname.setBounds(50,100,100,25);
		tname.setBounds(250,100,200,25);
		bpublisher.setBounds(50,150,130,25);
		tpublisher.setBounds(250,150,200,25);
		bpublisherYear.setBounds(50,200,130,25);
		tpublisheryear.setBounds(250,200,200,25);
        b1.setBounds(200, 270, 100, 25);
        b2.setBounds(350, 270, 100, 25);
		
		setTitle("Add Book");
		
		add(limage);
		limage.add(bBookid);
		limage.add(bname);
		limage.add(bpublisher);
		limage.add(bpublisherYear);
		limage.add(tBookid);
		limage.add(tname);
		limage.add(tpublisher);
		limage.add(tpublisheryear);
		limage.add(b1);
		limage.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(1920 ,1080);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	 }
	public void actionPerformed(ActionEvent e) 
	{
				
		  String sub="";
          String s=e.getActionCommand();
          if(s.equals("Save"))
          {
              JOptionPane.showMessageDialog(NB,"Saved Sucessfully!"); 
		
            try
			{
				//Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kithani2001@@");    
				String query ="insert into NewBook values(?,?,?,?)";
				PreparedStatement st =con.prepareStatement(query);
				
				st.setString(1, tBookid.getText());
				st.setString(2, tname.getText());
				st.setString(3, tpublisher.getText());
				st.setString(4, tpublisheryear.getText());
				
				
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
				Menu_Page Mp = new Menu_Page(Lp);
		
			}
	}
	/* public static void main(String args[])
	{
		NewBook NB= new NewBook();
	}*/
 }