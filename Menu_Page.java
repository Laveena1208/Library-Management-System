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
 public class Menu_Page extends JFrame implements ActionListener
 {
	 JLabel limage,lNewstudent,lNewbook,lStatics,lIssuebook,lReturnbook,lLogout;
	 JButton bNewstudent,bNewbook,bStatics,bIssuebook,bReturnbook,bLogout;
	 Login_Page Lp;
	 NewStudent NS;
	 Menu_Page(Login_Page Lp)
	 {
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Menu_Page.JFIF");
		limage = new JLabel(i);
		limage.setBounds(0,0,1920,1080);
		
		ImageIcon A=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\NewStudent.PNG");
		lNewstudent= new JLabel(A);
		lNewstudent.setBounds(0,0,128,128);
		bNewstudent = new JButton("Newstudent");
		bNewstudent.setBounds(0,0,128,128);
		bNewstudent.setOpaque(false);
		bNewstudent.setContentAreaFilled(true);
		bNewstudent.setBorderPainted(false);

		ImageIcon B=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\NewBook.PNG");
		lNewbook= new JLabel(B);
		lNewbook.setBounds(240,0,128,128);
		lNewbook.setOpaque(false);
		bNewbook = new JButton("Newbook");
		bNewbook.setBounds(240,0,128,128);
		bNewbook.setOpaque(false);
		bNewbook.setContentAreaFilled(true);
		bNewbook.setBorderPainted(false);
		
		ImageIcon C=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Statistics.JPG");
		lStatics= new JLabel(C);
		lStatics.setBounds(480,0,128,128);
		bStatics = new JButton("Statistics");
		bStatics.setBounds(480,0,128,128);
		bStatics.setOpaque(false);
		bStatics.setContentAreaFilled(true);
		bStatics.setBorderPainted(false);
		
		ImageIcon D=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\IssueBook.PNG");
		lIssuebook= new JLabel(D);
		lIssuebook.setBounds(720,0,128,128);
		bIssuebook = new JButton("Issuebook");
		bIssuebook.setBounds(720,0,128,128);
		bIssuebook.setOpaque(false);
		bIssuebook.setContentAreaFilled(true);
		bIssuebook.setBorderPainted(false);
		
		ImageIcon E=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\ReturnBook.PNG");
		lReturnbook= new JLabel(E);
		lReturnbook.setBounds(960,0,128,128);
		bReturnbook = new JButton("Returnbook");
		bReturnbook.setBounds(960,0,128,128);
		bReturnbook.setOpaque(false);
		bReturnbook.setContentAreaFilled(true);
		bReturnbook.setBorderPainted(false);
		
		ImageIcon F=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Logout.JPG");
		lLogout= new JLabel(F);
		lLogout.setBounds(1200,0,128,128);
		bLogout = new JButton("Logout");
		bLogout.setBounds(1200,0,128,128);
		bLogout.setOpaque(false);
		bLogout.setContentAreaFilled(true);
		bLogout.setBorderPainted(false);
		
		bNewstudent.addActionListener(this);
		bNewbook.addActionListener(this);
		bStatics.addActionListener(this);
		bIssuebook.addActionListener(this);
		bReturnbook.addActionListener(this);
		bLogout.addActionListener(this);
		
		add(limage);
		bNewstudent.add(lNewstudent);
		limage.add(bNewstudent);
		
		bNewbook.add(lNewbook);
		limage.add(bNewbook);
		
		bStatics.add(lStatics);
		limage.add(bStatics);
		
		bIssuebook.add(lIssuebook);
		limage.add(bIssuebook);
		
		bReturnbook.add(lReturnbook);
		limage.add(bReturnbook);
		
		bLogout.add(lLogout);
		limage.add(bLogout);
		
		setTitle("Menu Page");
		setLayout(null);
		setTitle("Menu.");
		setSize(1920,1080);
		setLocation(10,10);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 
	  public void actionPerformed(ActionEvent e) 
	  {
        if(e.getActionCommand().equals("Newstudent"))
        {
            this.setVisible(false);
			NewStudent NS = new NewStudent(this);
        }
		else if(e.getActionCommand().equals("Newbook"))
        {
            this.setVisible(false);
            NewBook NB = new NewBook(this);
        }
		else if(e.getActionCommand().equals("Statics"))
        {
            this.setVisible(false);
            Statics S = new Statics(this);
        }
		else if(e.getActionCommand().equals("Issuebook"))
        {
            this.setVisible(false);
            IssueBook IB = new IssueBook(this);
        }
		else if(e.getActionCommand().equals("Returnbook"))
        {
            this.setVisible(false);
            ReturnBook RB = new ReturnBook(this);
        }
		else if(e.getActionCommand().equals("Logout"))
        {
            this.setVisible(false);
            Home_Page Hp = new Home_Page();
        }
	  
		/*public static void main(String args[])
		{
			Menu_Page Mp = new Menu_Page();
		}
	  */
	  }
 }