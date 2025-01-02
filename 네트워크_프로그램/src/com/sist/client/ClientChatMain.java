package com.sist.client;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.net.*;
import com.sist.commons.*;

public class ClientChatMain extends JFrame implements ActionListener, Runnable{

	JButton b1,b2;
	JTextField tf; //텍스트입력하는 곳
	JTextArea ta; //텍스트가 출력되는 공간
	private String name;
	//서버연결 -> 네트워크 관련
	Socket s;//클라이언트 소켓 생성
	//단방향(보냄과 동시에 받을 순 없다)
	OutputStream out;  //서버에서 들어오는 값은 자동화처리
	BufferedReader in; 
	
	//레이아웃
	public ClientChatMain()
	{
		b1 = new JButton("접속");
		b2 = new JButton("종료");
		tf = new JTextField(25);
		tf.setEnabled(false);
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane js = new JScrollPane(ta);
		
		JPanel p = new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);
		
		add("Center", js);
		add("South",p);
		setSize(450,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientChatMain();
	}


	@Override//서버에서 들어오는 값 처리
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
				String msg = in.readLine();
				//서버에서 전송한 값 수신
				ta.append(msg+"\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Override//버튼
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(b2==e.getSource())
		{
			System.exit(0);
		}
		else if(b1==e.getSource())
		{
			
			name = JOptionPane.showInputDialog("이름 입력 : ");
	
			try {
				//클라이언트 서버연결
				s=new Socket("192.168.10.107",3050);
				//송수신 스트림 생성
				out = s.getOutputStream();//서버아이피에 연결해서 값을 보내겠다
				in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
				//getInputStream 을 getInputStream(2바이트로 변환해서) 값을 받는다
			} catch (Exception e2) {
				// TODO: handle exception
			}
			tf.setEnabled(true);
			b1.setEnabled(false);//접속은 한 번만 해야하니까
			new Thread(this).start(); //run call
			//서버에서 들어오는 값을 받는다
			
			
		}
		else if(e.getSource()==tf)//채팅입력
		{
			String msg = tf.getText();
			if(msg.trim().length()<1) //입력이 안됐을 때 
			{
				tf.requestFocus();
				return;
			}
			
			try {
				out.write(("["+name+"]"+msg+"\n").getBytes()); //서버로 데이터 전송
				//getBytes 바이트배열로 반
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
			tf.setText("");
		}
		
	}

}
