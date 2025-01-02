package com.sist.client;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;//마우스 버튼 엔터 -> 서버로 전송
//서버에서 전송하는 값은 자동화처리 => 쓰레드
import com.sist.commons.*;

public class ChatMain extends JFrame implements ActionListener, Runnable, MouseListener{

	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	CardLayout card = new CardLayout();
	//<jsp:include>
	//네트워크 관련 클래스
	Socket s;
	OutputStream out;
	BufferedReader in;
	String myId;
	
	int selRow=-1;
	//빈 공간을 마우스로 클릭했을 때 -> -1
	
	//본인 여부 확인
	
	
	public ChatMain()
	{
		setLayout(card);
		add("LOG",login);
		add("WR",wr);
		
		
		
		setSize(800,600);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//위처럼 하면 그냥 창만 꺼지고 채팅종료가 안됨
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//종료창을 비활성화시킴
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		wr.tf.addActionListener(this); //채팅입력 후 엔터
		wr.b6.addActionListener(this); //나가기
		
		wr.table2.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{//HiFiLookAndFeel
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("클래스이름 또는 경로") -LookAndFeel
		}catch (Exception ex){}
		new ChatMain();
		
	}

	//서버값수신 후 화면출력 => 쓰레드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
				String msg=in.readLine();
				StringTokenizer st = new StringTokenizer(msg,"|");
				int protocol = Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				case Function.LOGIN: //먼저 로그인 된 사람
				{
					String[] data= {
							st.nextToken(),
							st.nextToken(),
							st.nextToken(),
							st.nextToken()
					};
					wr.model2.addRow(data);
				}
				break;
				case Function.MYLOG://나중에 로그인하고 들어오는 사람
				{
					card.show(getContentPane(), "WR");
					myId=st.nextToken();
					setTitle(myId);
				}
				break;
					
				case Function.WAITCHAT:
				{
					wr.ta.append(st.nextToken()+"\n");
					wr.bar.setValue(wr.bar.getMaximum());
				}
				break;
				
				case Function.EXIT: //누군가 나갔을 때 남아있는 사람
				{
					String yid = st.nextToken();
					//exit.jsp?id=admin
					//String yid = request.getParameter("id")->나중에 웹에서 
					for(int i=0;i<wr.model2.getRowCount();i++)
					{
						String id=wr.model2.getValueAt(i,0).toString();
						if(yid.equals(id))
						{
							wr.model2.removeRow(i);
							break;
						}
					}
				}
				break;
				
				case Function.MYEXIT: //나가는 사람
				{
					dispose();
					System.exit(0);
				}
				break;
				
				case Function.INFO:
				{
					String data="아이디"+st.nextToken()+"\n"+"이름:"+st.nextToken()+"\n"+"성별:"+st.nextToken()+"\n"+"pos:"+st.nextToken()+"\n";
					JOptionPane.showMessageDialog(this, data);
				}
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//서버로 값을 전송할 때 처리(버튼, 마우스 엔터 등) 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b2)
		{
			dispose();//윈도우 메모리 해체
			System.exit(0);//프로그램 종료	
		}
		else if(e.getSource()==login.b1)
		{
			//1. 입력값 읽기
			String id = login.tf1.getText();
			if(id.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this,"아이디를 입력하세요");
				login.tf1.requestFocus();
				return;
				
			}
			String name = login.tf2.getText();
			if(name.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this,"이름을 입력하세요");
				login.tf2.requestFocus();
				return;
				
			}
			
			String sex = "남자";
			if(login.rb1.isSelected())
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			
			//서버와 연결
			connection(id, name, sex);
			
			
		}
		//채팅입력후엔터
		else if(e.getSource()==wr.tf)
		{
			String msg = wr.tf.getText();
			if(msg.trim().length()<1)
			{
				wr.tf.requestFocus();
				return;
			}
			//메세지가 입력되었으면 서버로 전송
			try {
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			} catch (Exception e2) {
				// TODO: handle exception
			}
			wr.tf.setText("");//엔터치면 입력창의 내용이 사라지게
			
		}
		//나가기
		else if(e.getSource()==wr.b6)
		{
			try {
				out.write((Function.EXIT+"\n").getBytes());
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

	public void connection(String id, String name, String sex)
	{
		try {
			s= new Socket("localhost",3050);
			//서버정보
			out=s.getOutputStream();
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			//로그인 요청
			out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
			// ==> ObjectOutputStream
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//서버와 통신을 해라
		new Thread(this).start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table2)
		{
			if(e.getClickCount()==2)//더블클릭
			{
				int row = wr.table2.getSelectedRow(); //선택한 칸의 줄 수
				String id=wr.model2.getValueAt(row, 0).toString();
				try {
					out.write((Function.INFO+"|"+id+"\n").getBytes());
				} catch (Exception e2) {
					// TODO: handle exception
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
