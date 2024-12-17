package com.sist.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 	1. 이벤트 처리
 	   ---------
 	   제공하는 메소드가 구현이 안되어 있다(인터페이스)
 	   
 	   = ActionListener
 	   -> 버튼클릭, 메뉴클릭, text에서 엔터눌렀을 때
 	   	   =>actionPerformed() => 구현해서 사용
 	   	
 	   = MouseListner / MouseMotionListner
 	   = KeyListner
 	   
 	   
 	 	문제발생
 	 	
 	 	-> 입력창에서 정수 입력해야하는데 안하거나
 	 	-> 공백을 입력하거나 
 	 	==> 예외처리 필요
 	 	
 	 	
 */
public class 숫자야구게임 extends JFrame implements ActionListener{

	JTextArea ta;//힌트를 출력하는 창
	JTextField tf;
	JButton b1, b2;
	//초기화 -> 생성자, 초기화블럭
	//멤버변수를 사용해야 클래스 전체에서 사용이 가능하다
	int[] com = new int[3];
	int[] user = new int[3];
	public 숫자야구게임() //생성자를 이용하는 이유 : 구현을 해야할 때
	{
		//JTectPane(word) JTextArea(메모장)
		//---------> 문자색같은 세부사항 변경가능
		
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta); // 스크롤 생성(가로세로 스크롤 모두 가능), JScrollBar가 합쳐진 형태의 component
		ta.setEditable(false); //편집 방지
		tf = new JTextField(10); //(크기지정)
		tf.setEditable(false); //비활성화
		b1 = new JButton("시작버튼");
		b2 = new JButton("종료버튼");
		
		JPanel p = new JPanel();
		p.add(tf);
		p.add(b1);
		//b1.setBounds(165, 15, 100, 30);
		p.add(b2);
		//b2.setBounds(270, 15, 100, 30);
		
		add("Center",js);
		add("South", p);
		
		setSize(350,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트 등록
		b1.addActionListener(this); //this -> 자신이 가지고 있는 actionPerformed를 호출해라
		//만약 마우스를 처리하려명 addMouselistener();
		b2.addActionListener(this);
		tf.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new 숫자야구게임();
		
	}
	
	//버튼처리 -> 난수발생(3자리, 중복x)
	public void getRand()
	{
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//여기서 난수를 발생시키면 사용할 수가 없어
		if(e.getSource()==b2)  //이벤트가 발생한 객체에 대한 참조를 리턴
		{
			int sel=JOptionPane.showConfirmDialog(this,"종료할까요?","종료",JOptionPane.YES_NO_OPTION);
			if(sel==JOptionPane.YES_OPTION)  //YES_OPTION가 상수로 되어 있다
			{
				System.exit(0); //정상종료
			}
		}
		else if(e.getSource()==b1)
		{
			getRand();
			tf.setEditable(true);  //
			tf.requestFocus();
			b1.setEnabled(false);
		}
		else if(e.getSource()==tf)
		{
			try {
				
				//입력된 데이터 읽기
				String str=tf.getText();
				int input=Integer.parseInt(str);
				
				if(input<99 ||input>999)
				{
					JOptionPane.showMessageDialog(this, "세자리 정수만 입력해야 합니다");
					tf.setText("");
					tf.requestFocus();
					return; //메소드종료
				}
				
				user[0]=input/100;
				user[1]=(input%100)/10;
				user[2]=input%10;
				
				if((user[0]==user[1])||(user[0]==user[2])||(user[1]==user[2]))
				{
					JOptionPane.showMessageDialog(this, "중복된 수는 사용할 수 없다");
					tf.setText("");
					tf.requestFocus();
					return; //메소드종료
					
				}
				if(user[0]==0||user[1]==0||user[2]==0)
				{
					JOptionPane.showMessageDialog(this, "0은 사용할 수 없다");
					tf.setText("");
					tf.requestFocus();
					
				}
				
				//비교
				int s=0,b=0;
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(com[i]==user[j])
						{
							if(i==j)
							{
								s++;
							}
							else
								b++;
						}
					}
				}
				String hint = "Input Number:" + input + ", Result"+s+"S-"+b+"B\n";
				ta.append(hint);
				
				//종료여부 확인
				if(s==3)
				{
					JOptionPane.showMessageDialog(this, "프로그램을 종료합니다");
					System.exit(0);
				}
				
				tf.setText("");
				tf.requestFocus();
				
				
				
			} catch (NumberFormatException ex) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "세자리 정수만 입력하세요");
				tf.setText("");
				tf.requestFocus(); //예외복구
			}
		}
		
	}

}
