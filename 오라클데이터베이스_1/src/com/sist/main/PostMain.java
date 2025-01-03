package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
//리스트가 다른곳에도 있기때문에 따로 추가해서 설정해줘야해
import java.awt.event.*;

public class PostMain extends JFrame implements ActionListener{
	
	JTextField tf;
	JButton jb;
	JTable table; //데이터를 행과 열로 구성되어 있는 테이블 형식으로 보여주는 컴포넌트
	//Scrollable인터페이스가 구현되어 있어서 JScrollPane에 붙여 스크롤 할 수 있다
	//모델로는 TableModel 사용
	DefaultTableModel model;
	
	public PostMain()
	{
		tf=new JTextField(10);
		jb=new JButton("우편번호 검색");
		
		String[] col= {"우편번호","주소"};
		String[][] row = new String[0][2];
		model = new DefaultTableModel(row,col);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		
		JPanel p = new JPanel();
		p.add(tf); p.add(jb);
		
		add("North",p);
		add("Center",js);
		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jb.addActionListener(this);
		tf.addActionListener(this);
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PostMain();
	}
	
	public void postFind(String dong)
	{
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		
		//오라클로부터 데이터 읽기
		ZipcodeDAO dao=ZipcodeDAO.newInstance();
		List<ZipcodeVO> list = dao.postFind(dong);
		for(ZipcodeVO vo : list)
		{
			String[] data= { 
					vo.getZipcode(),
					vo.getAddress()
			};
			model.addRow(data);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jb==e.getSource()||tf==e.getSource())
		{
			String dong = tf.getText();
			if(dong.trim().length()<1)
			{
				tf.requestFocus();
				return;
			}
			ZipcodeDAO dao = ZipcodeDAO.newInstance();
			int count = dao.postFindCount(dong);
			if(count==0)
			{
				JOptionPane.showMessageDialog(this, "검색결과가 없습니다!!");
				tf.setText("");
				tf.requestFocus();
			}
			else
			{
				postFind(dong);
			}

		}
	}

}
