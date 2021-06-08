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
 public  class Statics extends JFrame 
 {
	 JLabel limage;
	 Menu_Page Mp;
	 Statics S;
	 Statics(Menu_Page Mp)
	 {
		ImageIcon i=new ImageIcon("E:\\JAVA PROGRAMS\\Library Management System\\Statics.png");
		limage=new JLabel(i);
		limage.setBounds(0,0,1920,1080);
		add(limage);
		
		this.setLayout(null);
        this.setSize(1920, 1080);

		setSize(1920 ,1080);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
 }