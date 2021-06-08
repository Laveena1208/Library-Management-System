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
 
public class ReturnBook extends JFrame implements ActionListener
 {
	 JLabel limage;
	 JTextField tStudentid,tIssuedate,tReturndate;
	 JButton bStudentid,bIssuedate,bReturndate,b1,b2,SB;
	 Menu_Page Mp;
	 ReturnBook RB;
	 Login_Page Lp;
	 	 NewStudent NS;

	 ReturnBook( Menu_Page Mp)
	 {
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\ReturnBook(image).JPG");
		limage=new JLabel(i);
		limage.setBounds(0, 0, 1920, 1080);
		//bBookid = new JButton("BookID: ");bBookid.setBackground(Color.BLACK);bBookid.setForeground(Color.WHITE);bBookid.setFont(new Font("osward", Font.BOLD, 13));
		bStudentid= new JButton("Studentid: ");bStudentid.setBackground(Color.BLACK);bStudentid.setForeground(Color.WHITE);bStudentid.setFont(new Font("osward", Font.BOLD, 13));
		bIssuedate = new JButton("Issuedate: ");bIssuedate.setBackground(Color.BLACK);bIssuedate.setForeground(Color.WHITE);bIssuedate.setFont(new Font("osward", Font.BOLD, 13));
		bReturndate = new JButton("Returndate: ");bReturndate.setBackground(Color.BLACK);bReturndate.setForeground(Color.WHITE);bReturndate.setFont(new Font("osward", Font.BOLD, 13));
		//tBookid=new JTextField();
		tStudentid=new JTextField();
		tIssuedate=new JTextField();
		tReturndate=new JTextField();
		b1=new JButton("Return");b1.setBackground(Color.BLACK);b1.setForeground(Color.WHITE);b1.setFont(new Font("osward", Font.BOLD, 13));
        b2=new JButton("Close");b2.setBackground(Color.BLACK);b2.setForeground(Color.WHITE);b2.setFont(new Font("osward", Font.BOLD, 13));
		SB=new JButton("Search");SB.setBackground(Color.BLACK);SB.setForeground(Color.WHITE);SB.setFont(new Font("osward", Font.BOLD, 13));
		this.setLayout(null);
        this.setSize(1920, 1080);
		
		//bBookid.setBounds(50,50,120,25);
		//tBookid.setBounds(250,50,200,25);
		bStudentid.setBounds(50,100,120,25);
		tStudentid.setBounds(250,100,200,25);
		bIssuedate.setBounds(50,150,130,25);
		tIssuedate.setBounds(250,150,200,25);
		SB.setBounds(480,150,130,25);
		bReturndate.setBounds(50,200,130,25);
		tReturndate.setBounds(250,200,200,25);
        b1.setBounds(200, 270, 100, 25);
        b2.setBounds(350, 270, 100, 25);
		
		setTitle("Return Book");
		
		add(limage);
		//limage.add(bBookid);
		limage.add(bStudentid);
		limage.add(bIssuedate);
		limage.add(bReturndate);
		//limage.add(tBookid);
		limage.add(tStudentid);
		limage.add(tIssuedate);
		limage.add(SB);
		limage.add(tReturndate);
		limage.add(b1);
		limage.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		SB.addActionListener(this);
		setSize(1920 ,1080);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
	 
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Search"))
        {
            
				
            try{  
				   // Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//this statement loads the driver for the databse
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kithani2001@@");  
					//here nitesh is database name, root is username and  password is empty String  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from ReturnBook where tStudentid='"+tStudentid.getText()+"'");  
					
					if(rs.next()==false) 
					{
					  tStudentid.setText("");
					  JOptionPane.showMessageDialog(this, "Record not Found");
					}
					
					else
								   
					{
						 tIssuedate.setText(rs.getString(2));
						 tReturndate.setText(rs.getString(2));
	
					} 
					  
				    con.close();  
				}
				
				catch(Exception ex)
                { 
                    System.out.println(ex);
                }
		}
		else if(e.getActionCommand().equals("Return"))
		{
				JOptionPane.showMessageDialog(RB,"Book Returned Sucessfully!"); 
		}
		else if(e.getActionCommand().equals("Close"))
		{
				this.setVisible(false);
				Menu_Page Mp = new Menu_Page(Lp);
		
		}
	}
	/* public static void main(String args[])
	{
		ReturnBook RB= new ReturnBook();
	}*/
 }