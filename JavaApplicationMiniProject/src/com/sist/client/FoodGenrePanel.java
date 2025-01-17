package com.sist.client;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.net.URL;

import com.sist.commons.ImageChange;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
import java.util.List;

/*
 	
 	1. JFrame / JDialog -> BorderLaouy
 	
 	2. JPabel  
 
 */

public class FoodGenrePanel extends JPanel implements ActionListener, MouseListener{


	ControlPanel cp;
	JButton[] genre = new JButton[5]; //한식, 중식, 양식, 일식
	JButton prev,next;
	JLabel la=new JLabel("0 page / 0 pages");
	JLabel[] imgs=new JLabel[12];
	
	int curpage=1;
	int totalpage=0;
	JPanel pan = new JPanel(); //이미지 출력
	FoodDAO dao=FoodDAO.newInstance();
	String strGenre="한식";
	public FoodGenrePanel(ControlPanel cp)
	{
		this.cp=cp;
		//new 
		
		prev=new JButton("이전");
		next=new JButton("다음");
		
		JPanel p1= new JPanel();
		p1.setLayout(new GridLayout(1,5,5,5));
		
		/*
		 Boarderlayout -> 동서남북중앙으로 배치
		 
		 */
		
		String[] temp={"한식","중식","양식","일식","기타"};
		for(int i=0;i<genre.length;i++)
		{
			genre[i]=new JButton(temp[i]);
	//		genre[i].setPreferredSize(50,30);
			p1.add(genre[i]);
			
			genre[i].addActionListener(this);
					
		}
		
		JPanel p2 = new JPanel();
		p2.add(prev); p2.add(la); p2.add(next);
		
		pan.setLayout(new GridLayout(3,4,3,3));
		
		setLayout(new BorderLayout());
		add("North",p1);
		add("Center",pan);
		add("South",p2);
		print();
		
		
		prev.addActionListener(this);
		next.addActionListener(this);
		
		
		
	}
	
	//초기화
		public void init()
		{
			for(int i=0;i<imgs.length;i++)
			{
				imgs[i]=new JLabel("");
			}
			pan.removeAll(); //전체삭제
			pan.validate(); //재배치
		}
		//이미지 출력
		public void print()
		{
			//총페이지 읽기
			
			totalpage=dao.foodGenreTotalPage(strGenre);
			List<FoodVO> list=dao.foodGenreData(curpage, strGenre);
			for(int i=0;i<list.size();i++)
			{
				FoodVO vo=list.get(i);
				try {
					
					URL url=new URL(vo.getPoster());
					Image image=ImageChange.getImage(new ImageIcon(url), 180,160); //200,180
					imgs[i]=new JLabel(new ImageIcon(image));
					imgs[i].setToolTipText(vo.getName()+"^"+vo.getFno());
					pan.add(imgs[i]);
					imgs[i].addMouseListener(this);
				} catch (Exception e) {	}
			
			}
			la.setText(curpage+" page / "+totalpage+" page");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<genre.length;i++)
			{
				if(e.getSource()==genre[i])
				{
					strGenre=genre[i].getText();
					//버튼 묹자열 읽기
					//현재페이지를 1으로 변경해야해
					curpage=1;
					init();
					print();
					
				}
			}
			if(e.getSource()==prev)
			{
				if(curpage>1)
				{
					curpage--;
					init();
					print();
				}
			}
			else if(e.getSource()==next)
			{
				if(curpage<totalpage)
				{
					curpage++;
					init();
					print();
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<imgs.length;i++)
			{
				if(e.getSource()==imgs[i])
				{
					if(e.getClickCount()==2)
					{
						String fno=imgs[i].getToolTipText();
						fno=fno.substring(fno.lastIndexOf("^")+1); //사진에 마우스올리면 보이는 
						FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
						cp.fdp.detailPrint(2, vo); //2번은 장르창으로 돌아가기 위한 번호
						cp.card.show(cp, "DETAIL");
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<imgs.length;i++)
			{
				if(e.getSource()==imgs[i])
				{
					imgs[i].setBorder(new LineBorder(Color.green,3));
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<imgs.length;i++)
			{
				if(e.getSource()==imgs[i])
				{
					imgs[i].setBorder(null);
				}
			}
		}
}













































