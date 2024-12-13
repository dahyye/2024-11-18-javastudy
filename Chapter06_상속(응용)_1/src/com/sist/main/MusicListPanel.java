package com.sist.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.*;

import com.sist.manager.*;
import com.sist.vo.*;
import javax.swing.JPanel;
import java.awt.event.*; //버튼처리

public class MusicListPanel extends JPanel
//버튼 구현할 때 사용
implements ActionListener
{
	Image back;
	JLabel la;
	JButton b1,b2;
	JTable table;
	DefaultTableModel model;
	GenieMusicSystem gm = new GenieMusicSystem();
	public MusicListPanel()
	{
		back=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpg");
		setLayout(null);
		la=new JLabel("Music Top 50",JLabel.CENTER);
		la.setFont(new Font("궁서체",Font.BOLD,35));
		la.setBounds(10,15,760,50);
		add(la);
		
		b1=new JButton("지니뮤직");
		b2=new JButton("멜론");
		b1.setBounds(10,75,120,30);
		b2.setBounds(135,75,100,30);
		add(b1); add(b2);
		
		
		String[] col={"순위","곡명","가수명","앨범"};
		String[][] row=new String[0][4];
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js =new JScrollPane(table);
		js.setBounds(10,110,760,400);
		add(js);
		musicPrint(2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
	}
	public void musicPrint(int type)
	{					//데이터를 0부터 끝까지 읽어 (length랑 비슷하다고 생각하면됨) //경험상 앞에서 지우면 꼭 하나씩 남아서 뒤에서부터 삭제시켜줘야해
		for(int i=model.getRowCount()-1;i>=0;i--)
		{              //버튼을 누르면 데이터가 나오는데 삭제되지 않아서 멜론->지니순으로 선택하면 연결되서 같이 나와
						//그래서 지워주는 코드가 필요해
			model.removeRow(i);			
		}
		if(type==1)
		{
			gm=new GenieMusicSystem();
			la.setText("지니뮤직 Top50"); //la의 텍스트를 바꿔라 
			b1.setEnabled(false);
			b2.setEnabled(true);
		}
		else
		{
			gm=new MelonMusicSystem();
			//System.out.println("멜론뮤직");
			la.setText("멜론뮤직 Top50"); //la의 텍스트를 바꿔라 
			b2.setEnabled(false);//버튼활성화여부
			b1.setEnabled(true);
		}
		
		MusicVO[] musics=gm.musicAllData();
		for(MusicVO vo : musics) //클래스로 모아서 데이터를 한 번에 가져올 수 있어
		{
			String[] data= {String.valueOf(vo.getNo()),vo.getTitle(),vo.getSinger(),vo.getAlbum()};
							// No만 int형식이기때문에 형변환해서 들어와
			model.addRow(data);
		}
		
		
		
		
	}
	//오버라이딩 중요
	//버튼처리
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			musicPrint(1);
			
		}else if(e.getSource()==b2)
		{
			musicPrint(2);
		}
	}

}
