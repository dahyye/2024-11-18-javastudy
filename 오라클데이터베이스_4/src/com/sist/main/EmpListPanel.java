package com.sist.main;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class EmpListPanel extends JPanel{
	JLabel la = new JLabel("사원 목록",JLabel.CENTER);
	JTable table;
	DefaultTableModel model;
	
	public EmpListPanel()
	{
		setLayout(new BorderLayout());
		la.setFont(new Font("맑은 고딕",Font.BOLD,45));//글자체, 글자굵기, 크기
		add("North",la);
		String[] col= {"사번", "이름", "직위","입사일","부서명","근무지"};
		String[][] row = new String[0][6];
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
