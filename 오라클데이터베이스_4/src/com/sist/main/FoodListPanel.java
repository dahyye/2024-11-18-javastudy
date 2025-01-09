package com.sist.main;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class FoodListPanel extends JPanel{
	JLabel la = new JLabel("맛집 목록",JLabel.CENTER);
	JTable table;
	DefaultTableModel model;
	
	public FoodListPanel()
	{
		setLayout(new BorderLayout());
		la.setFont(new Font("맑은 고딕",Font.BOLD,45));//글자체, 글자굵기, 크기
		add("North",la);
		String[] col= {"번호", "이름", "타입","전화번호"};
		String[][] row = new String[0][4];
		model=new DefaultTableModel(row,col)
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table = new JTable(model);
		table.setRowHeight(30);
		JScrollPane js = new JScrollPane(table);
		add("Center",js);
	}
}
	