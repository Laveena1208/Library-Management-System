import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
import javax.swing.*;
import java.sql.*;
 public  class IssueBook extends JFrame implements ActionListener
 {
	 JLabel limage;
	 JTextField tStudentID,tIssueDate,tDueDate;
	 JButton b1,b2,bStudentID,bIssueDate,bDueDate,SB;
	 Menu_Page Mp;
	 IssueBook IB;
	 Login_Page Lp;
	 NewStudent NS;
	 IssueBook(Menu_Page Mp)
	 {
		 ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\IssueBook.JPG");
		 limage=new JLabel(i);
		 limage.setBounds(0,0,1920,1080);
		 
		// bBookID=new JButton("BookID:");
		// bBookID.setBackground(Color.BLACK);
		// bBookID.setForeground(Color.WHITE);
		// bBookID.setFont(new Font("osward", Font.BOLD, 13));
		 
		 bStudentID=new JButton("StudentId:");
		 bStudentID.setBackground(Color.BLACK);
		 bStudentID.setForeground(Color.WHITE);
		 bStudentID.setFont(new Font("osward", Font.BOLD, 13));
		 
		 bIssueDate=new JButton("IssueDate:");
		 bIssueDate.setBackground(Color.BLACK);
		 bIssueDate.setForeground(Color.WHITE);
		 bIssueDate.setFont(new Font("osward",Font.BOLD, 13));
		 
		 bDueDate=new JButton("DueDate:");
		 bDueDate.setBackground(Color.BLACK);
		 bDueDate.setForeground(Color.WHITE);
		 bDueDate.setFont(new Font("osward",Font.BOLD, 13));
		 
		 b1=new JButton("Issue");
		 b1.setBackground(Color.BLACK);
		 b1.setForeground(Color.WHITE);
		 
		 b2=new JButton("Close");
		 b2.setBackground(Color.BLACK);
		 b2.setForeground(Color.WHITE);
		 
		// tBookID=new JTextField();
		 tStudentID=new JTextField();
		 tIssueDate=new JTextField();
		 tDueDate=new JTextField();
		 
		 SB=new JButton("Search");SB.setBackground(Color.BLACK);SB.setForeground(Color.WHITE);SB.setFont(new Font("osward", Font.BOLD, 13));
		 
		 this.setLayout(null);
         this.setSize(1920, 1080);
		
		//bBookID.setBounds(50,50,100,25);		
		//tBookID.setBounds(250,50,200,25);
		bStudentID.setBounds(50,100,100,25);
		tStudentID.setBounds(250,100,200,25);
		bIssueDate.setBounds(50,150,130,25);
		tIssueDate.setBounds(250,150,200,25);
		bDueDate.setBounds(50,200,130,25);
		tDueDate.setBounds(250,200,200,25);
        b1.setBounds(200, 270, 100, 25);
        b2.setBounds(350, 270, 100, 25);
		SB.setBounds(480,150,130,25);
		
		setTitle("Issue Book");
		
		add(limage);
		//limage.add(bBookID);
		limage.add(bStudentID);
		limage.add(bIssueDate);
		limage.add(bDueDate);
		//limage.add(tBookID);
		limage.add(tStudentID);
		limage.add(tIssueDate);
		limage.add(SB);
		limage.add(tDueDate);
		limage.add(b1);
		limage.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		SB.addActionListener(this);
		setSize(1920,1080);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	 }
	  
	   @Override
	public void actionPerformed(ActionEvent e) 
	{
        if(e.getActionCommand().equals("Search"))
        {
            
            try{  
				   // Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//this statement loads the driver for the databse
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kithani2001@@");  
					//here nitesh is database name, root is username and  password is empty String  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from IssueBook where tStudentID='"+tStudentID.getText()+"'");  
					
					if(rs.next()==false) 
					{
					  tStudentID.setText("");
					  JOptionPane.showMessageDialog(this, "Record not Found");
					}
					
					else
								   
					{
						 tIssueDate.setText(rs.getString(2));
						 tDueDate.setText(rs.getString(2));
	
					} 
					  
				    con.close();  
				}
								
			catch(Exception ex)
            { 
                System.out.println(ex);
            } 
		}
		else if(e.getActionCommand().equals("Issue"))
		{
				JOptionPane.showMessageDialog(IB,"Book Issued Sucessfully!"); 
		}
		else if(e.getActionCommand().equals("Close"))
		{
				this.setVisible(false);
				Menu_Page Mp = new Menu_Page(Lp);
		
		}
	}
	/* public static void main(String args[])
	 {
		 IssueBook IB=new IssueBook();
	 }*/
 } 
 