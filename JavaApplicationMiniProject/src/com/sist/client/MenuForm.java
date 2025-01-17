package com.sist.client;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 	BorderLayout //위쪽에 배치(north/south/east/west/center)
 	FlowLayout // 일자배치 ( 글자크기에 따라서 버튼크기가 달라져서 깔끔해보이지 않아 )
 	GridLayout //윈도우창을 같은 크기로 나눠서 배치
 	
 */
public class MenuForm extends JPanel{
	public JButton b1=new JButton("홈");
	public JButton b2=new JButton("맛집");
	public JButton b3=new JButton("맛집검색");
	
	public JButton b5=new JButton("커뮤니티");
	public JButton b6=new JButton("실시간채팅");
	public JButton b7=new JButton("실시간뉴스");
	//
	//초기화 ==> 배치 (클래스안에서는 배치불가능 선언만 가능)
	public MenuForm()
	{
		setLayout(new GridLayout(1,5,10,10)); //가로배치 (1,5) 세로배치 (5,1) 
											//(x,y, 0,10) 좌우간격, 위아래간격
		add(b1);add(b2);add(b3);
		add(b5);add(b6);add(b7); //순서대로 배치되기 때문에 순서 잘 지키기
		
		
		b1.addActionListener(new ActionListener() { //버튼에 리스너 붙이기
			
			@Override
			public void actionPerformed(ActionEvent e) { //리스너함수
				// TODO Auto-generated method stub
				
			
				
				
				
			}
		});
		b2.addActionListener(new ActionListener() { //버튼에 리스너 붙이기
			
			@Override
			public void actionPerformed(ActionEvent e) { //리스너함수
				// TODO Auto-generated method stub
				
				
				
			}
		});
		b3.addActionListener(new ActionListener() { //버튼에 리스너 붙이기
			
			@Override
			public void actionPerformed(ActionEvent e) { //리스너함수
				// TODO Auto-generated method stub
				
			
				
				
			}
		});
		
	}
	
}
