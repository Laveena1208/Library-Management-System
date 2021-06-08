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
 public class NewStudent extends JFrame  implements ActionListener
 {
	 
	 JTextField  tStudentID,tname,tsurname;
	 JComboBox cbranch,cCourse;
	 JLabel limage;
     JButton b1,b2,bStudentID,bname,bsurname,bcoursename,bbranchname;
	 Menu_Page Mp;
	 NewStudent NS;
	 Login_Page Lp;
     String b[]={"","Computer  engineering","Information Technology","Civil engineering","Mechanical engineering","Instrumental engineering ","Biomedical engineering","EXTC","ETRX"};
	 String m[]={"","12th Science","Diploma"};
	 NewStudent(Menu_Page Mp)
	 {
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\NewStudent(image).JPG");
		limage=new JLabel(i);
		limage.setBounds(0, 0, 1920, 1080);
		bStudentID = new JButton("StudentID:");bStudentID.setBackground(Color.BLACK);bStudentID.setForeground(Color.WHITE);bStudentID.setFont(new Font("osward", Font.BOLD, 13));
		bname = new JButton("Name:");bname.setBackground(Color.BLACK);bname.setForeground(Color.WHITE);bname.setFont(new Font("osward", Font.BOLD, 13));
		bsurname = new JButton("Surname:");bsurname.setBackground(Color.BLACK);bsurname.setForeground(Color.WHITE);bsurname.setFont(new Font("osward", Font.BOLD, 13));
		bcoursename = new JButton("CourseName:");bcoursename.setBackground(Color.BLACK);bcoursename.setForeground(Color.WHITE);bcoursename.setFont(new Font("osward", Font.BOLD, 13));
		bbranchname = new JButton("BranchName:");bbranchname.setBackground(Color.BLACK);bbranchname.setForeground(Color.WHITE);bbranchname.setFont(new Font("osward", Font.BOLD, 13));
		b1=new JButton("Save");b1.setBackground(Color.BLACK);b1.setForeground(Color.WHITE);
        b2=new JButton("Close");b2.setBackground(Color.BLACK);b2.setForeground(Color.WHITE);
		tStudentID=new JTextField();
		tname=new JTextField();
		tsurname=new JTextField();
		//tcoursename=new JTextField();
		//tbranchname=new JTextField();
		cbranch=new JComboBox(b);
		cCourse=new JComboBox(m);
		this.setLayout(null);
        this.setSize(1920, 1080);
		
		
		bStudentID.setBounds(50,50,120,25);
		tStudentID.setBounds(250,50,200,25);
		bname.setBounds(50,100,100,25);
		tname.setBounds(250,100,200,25);
		bsurname.setBounds(50,150,130,25);
		tsurname.setBounds(250,150,200,25);
		bcoursename.setBounds(50,200,130,25);
		cCourse.setBounds(250,200,200,25);
		bbranchname.setBounds(50, 250 , 150, 25);
        cbranch.setBounds(250, 250, 200, 30);
        b1.setBounds(200, 300, 100, 25);
        b2.setBounds(350, 300, 100, 25);
		
		
		setTitle("Add Student");
		add(limage);
		limage.add(bStudentID);
		limage.add(bname);
		limage.add(bsurname);
		limage.add(bcoursename);
		limage.add(bbranchname);
		limage.add(tStudentID);
		limage.add(tname);
		limage.add(tsurname);
		limage.add(cCourse);
        limage.add(cbranch);
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
			if(e.getActionCommand().equals("Save"))
			{
				
				JOptionPane.showMessageDialog(NS,"Saved Sucessfully!"); 
				try
				{
					//Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kithani2001@@");    
					String query ="insert into NewStudent values(?,?,?,?,?)";
					PreparedStatement st =con.prepareStatement(query);
					st.setString(1, tStudentID.getText());
					st.setString(2, tname.getText());
					st.setString(3, tsurname.getText());
					st.setString(4, cCourse.getSelectedItem().toString());
				    st.setString(5, cbranch.getSelectedItem().toString());
		
					
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

	/*public static void main(String args[])
	{
		NewStudent NS= new NewStudent();
	}*/
 }