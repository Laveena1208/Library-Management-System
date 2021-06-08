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
 public  class Home_Page extends JFrame implements ActionListener
 {
	 JLabel limage,ltext;
	 JButton b1,b2;
	 Home_Page()
	 {
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Home_Page(Image).JPEG");
		limage=new JLabel(i);
		limage.setBounds(0,0,1920,1080);
		ltext = new JLabel("Library Management System");ltext.setBackground(Color.BLACK);ltext.setForeground(Color.WHITE);ltext.setFont(new Font("osward", Font.BOLD, 108));
		b1=new JButton("Sign IN");b1.setBackground(Color.WHITE);b1.setForeground(Color.BLACK);b1.setFont(new Font("osward", Font.BOLD, 13));
        b2=new JButton("Sign UP");b2.setBackground(Color.WHITE);b2.setForeground(Color.BLACK);b2.setFont(new Font("osward", Font.BOLD, 13));
		ltext.setBounds(50,50,3000,255);
		b1.setBounds(500, 470, 150, 45);
        b2.setBounds(720, 470, 150, 45);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add(limage);
		limage.add(ltext);
		limage.add(b1);
		limage.add(b2);
		setTitle("Home Page");
		setSize(1920,1080);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	 }
	 public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Sign IN"))
        {
            this.setVisible(false);
            Login_Page Lp = new Login_Page(this);
        }
		else if(e.getActionCommand().equals("Sign UP"))
        {
            this.setVisible(false);
            Register R = new Register(this);
        }
	}
	 public static void main(String args[])
	{
		Home_Page Hp = new Home_Page();
	}
 } 