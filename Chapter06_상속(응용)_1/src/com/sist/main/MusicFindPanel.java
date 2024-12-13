package com.sist.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.*;
import javax.swing.table.*;

//프론트
/////////////////////////////////
//백앤드
import com.sist.vo.*;
import com.sist.manager.*;
import java.awt.event.*; //버튼처리
public class MusicFindPanel extends JPanel
implements ActionListener
{

	JLabel la;
	JButton b1,b2;
	JTable table;
	DefaultTableModel model;
	JTextField tf;
	GenieMusicSystem gm = new GenieMusicSystem();
	public MusicFindPanel()
	{
		setLayout(null);
		tf = new JTextField();
		la=new JLabel("Music 검색",JLabel.CENTER);
		la.setFont(new Font("궁서체",Font.BOLD,35));
		la.setBounds(10,15,760,50);
		add(la);
		
		tf.setBounds(10,70,200,30);
		add(tf);
		
		String[] col={"순위","곡명","가수명","앨범"};
		String[][] row=new String[0][4];
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js =new JScrollPane(table);
		js.setBounds(10,105,760,400);
		add(js);
		tf.addActionListener(this);

	}
	
/*
		
		Event
		버튼 / 텍스트 엔터 / 메뉴 actionPerformed
		마우스
			mouseClicked,mouseReleased mousePressed
			mouseEnterted mouseExited
		키보드	
		
		
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf)//엔터일 때
		{
			String fd=tf.getText();
			if(fd.trim().length()<1)//문자갯수가져온거
			{
				//입력이 안됐다면
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return;
			}
			musicFind(fd);
		}
		
	}
	public void musicFind(String fd)
	{
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		MusicVO[] music=gm.musicFindData(fd);
		for(MusicVO vo:music)
		{
			String[] data= {String.valueOf(vo.getNo()),vo.getTitle(),vo.getSinger(),vo.getAlbum()};
			model.addRow(data);
		}
	}
}
