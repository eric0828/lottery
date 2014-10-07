package com.lottery.ui;

import com.lottery.action.ImportBtnAction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
                    frame.setSize(1000, 700);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainUI() {
		setTitle("\u5927\u4E50\u900F\u5206\u6790\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u5BFC\u5165\u6570\u636E");
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		mnNewMenu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton importBtn = new JButton("\u5BFC\u5165\u6570\u636E");
		importBtn.addActionListener(new ImportBtnAction());
		toolBar.add(importBtn);
		
		JComboBox comboBox_1 = new JComboBox();
		toolBar.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		toolBar.add(comboBox);
	}

}
