package com.sist.main;

import com.sist.vo.*;
import com.sist.manager.*;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.*;
/*
	Container
	**	=JFrame
		=JDialog 
		=JWindow //이클립스 처음 열 때 뜨는 창 처럼 스스로 사라지는 창
	**	=JPanel //

 */
public class MusicUserMain extends JFrame{
	
	JTabbedPane tp;
	MusicListPanel mlp=new MusicListPanel();
	MusicFindPanel mfp=new MusicFindPanel();
	MusicDetailPanel mdp = new MusicDetailPanel();
	
	public MusicUserMain()
	{
		
		tp=new JTabbedPane();
		tp.addTab("뮤직목록", mlp);
		tp.addTab("뮤직검색", mfp);
		tp.addTab("뮤직상세보기", mdp);
		//tp.setTabPlacement(JTabbedPane.LEFT);//테이블 위치 어디에 붙일것인지
		//윈도우에 추가
		add("Center",tp);
		//크기
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우창x누르면 자동으로 프로그램 종료
		//이걸 안쓰면 x눌러도 감추기만 할 뿐 종료되지 않아서 쌓인다
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MusicUserMain();
	}

}
