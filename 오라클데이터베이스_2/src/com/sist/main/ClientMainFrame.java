package com.sist.main;
//jtattoo download 검색
//JTattoo-1.6.13.jar  size about 1.3MB  다운로드
//프로젝트에 buildpath에 다운받은 파일 추가


import java.awt.Menu;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.sist.vo.*;
import com.sist.dao.*;

//Screenshots에서 하나 결정  (  HiFiLookAndFeel  )
//어떤 컴퓨터를 server 컴퓨터로 사용할 지 결정 ip/port공유 ()
//port번호 결정 0~65,535 사이가능 (3050)
//0~1023까지는 사용중  		이외에 4000()/8080()/1521(오라클) 은 사용중


//import com.sist.client.*;
									//상속=>재사용=>변경
public class ClientMainFrame extends JFrame implements ActionListener {
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
		
		cp.b1.addActionListener(this);
		cp.b2.addActionListener(this);
	}
	public static void main(String[] args) {
		try
		{//HiFiLookAndFeel
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}catch (Exception ex){}
		new ClientMainFrame();
	}
	@Override
	//웹에서는 자바스크립트로 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp.b2) //로그인 취소
		{
			System.exit(0);
		}
		else if(e.getSource()==cp.b1) //로그인 
		{
			String id = cp.tf.getText();
			System.out.println(id);
			if(id.trim().length()<1)
			{
				cp.tf.requestFocus();
				return;
			}
			String pwd = String.valueOf(cp.pf.getPassword());
			System.out.println("pwd"+pwd);
			
			if(pwd.trim().length()<1)
			{
				cp.pf.requestFocus();
				return;
			}
			MemberDAO dao = MemberDAO.newInstance();
			MemberVO vo = dao.isLogin(id, pwd);
			if(vo.getMsg().equals("NOID"))//비밀번호 실패
			{
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				cp.tf.setText("");
				cp.pf.setText("");
				cp.tf.requestFocus();
			}
			else if(vo.getMsg().equals("NOPWD"))//패스워드실패
			{
				System.out.println("로그인실패");
				JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다");
				cp.pf.setText("");
				cp.pf.requestFocus();
			}
			else//로그인성공
			{
				String msg = vo.getName() + "님 로그인되었습니다\n"+"메인페이지로 이동합니다!!";
				JOptionPane.showMessageDialog(this, msg);
			}
		}
		
	}
}
