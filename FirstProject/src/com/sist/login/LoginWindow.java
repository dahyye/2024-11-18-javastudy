package com.sist.login;


import javax.swing.*; //스윙 클래스
import java.awt.event.*; //리스너 클래스
public class LoginWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("로그인 창"); //프레임생성
		JLabel l1 = new JLabel("사용자:");//라벨생성
		l1.setBounds(20,20,80,30);//라벨위치
		JTextField text = new JTextField();//사용자입력창
		text.setBounds(100, 20, 100, 30); //입력창위치
		JLabel l2 = new JLabel("비밀번호:"); //라벨생성
		l2.setBounds(20,75,80,30);//라벨위치
		JPasswordField value = new JPasswordField();//비밀번호입력창
		value.setBounds(100,75,100,30);//입력창위치
		
		
		JButton b = new JButton("로그인");//버튼생성
		b.setBounds(100, 120, 80, 30);//버튼위치
		
		JButton c = new JButton("회원가입");//버튼생성
		c.setBounds(40, 160, 90, 30);//버튼위치
		JButton d = new JButton("탈퇴");//버튼생성
		d.setBounds(150, 160, 90, 30);//버튼위치
		
		f.add(l1);	f.add(text);//프레임에 사용자라벨, 입력창 붙이기
		f.add(l2);	f.add(value);	f.add(b); //프레임에 비밀번호라벨, 입력창 ,버튼 붙이기
		f.add(c); 	f.add(d);
		f.setSize(300,250);//창 사이즈
		f.setLayout(null);//기본레이아웃 사용
		f.setVisible(true);//프레임보이기
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		b.addActionListener(new ActionListener() { //버튼에 리스너 붙이기
			
			@Override
			public void actionPerformed(ActionEvent e) { //리스너함수
				// TODO Auto-generated method stub
				
				String data = "사용자: "+ text.getText();//사용자명 추가
				data +=",비밀번호: "						//비밀번호 추가
						+ new String(value.getPassword());
				JOptionPane.showMessageDialog(f, data);  //메시지창 띄우기
				
				
			}
		});
	}

}
