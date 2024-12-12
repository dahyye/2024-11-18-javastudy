package com.sist.client;
//jtattoo download 검색
//JTattoo-1.6.13.jar  size about 1.3MB  다운로드
//프로젝트에 buildpath에 다운받은 파일 추가


import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.UIManager;

//Screenshots에서 하나 결정  (  HiFiLookAndFeel  )
//어떤 컴퓨터를 server 컴퓨터로 사용할 지 결정 ip/port공유 ()
//port번호 결정 0~65,535 사이가능 (3050)
//0~1023까지는 사용중  		이외에 4000()/8080()/1521(오라클) 은 사용중


import com.sist.client.*;
									//상속=>재사용=>변경
public class ClientMainFrame extends JFrame {
	MenuForm mf = new MenuForm();  //포함클래스
	ControlPanel cp = new ControlPanel();
	//배치
	public ClientMainFrame()
	{
		setLayout(null); // 사용자정의 => 직접 배치
		mf.setBounds(10, 15, 1470, 50);//(x점, y점, WIDTH, HEIGHT);;
		add(mf);
		cp.setBounds(10,75,1470,785);
		add(cp);
		setSize(1500,900);
		setVisible(true);
	}
	public static void main(String[] args) {
		try
		{//HiFiLookAndFeel
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}catch (Exception ex){}
		new ClientMainFrame();
	}
}
