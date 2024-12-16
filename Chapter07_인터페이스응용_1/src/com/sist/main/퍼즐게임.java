package com.sist.main;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//인터페이스

/*
 	ActionListener : 버튼 / enter / Menu
 	 => actionPerFormed
 	 
 	 //인터페이스는 처리하는 기능이 여러개 있다
 	             --------------------
 	             메소드는 선언 => 프로그램에 맞게 구현해서 사용
 	             인터페이스 단점 : 선언된 메소드가 많은 경우에 
 	             				선택적으로 사용할 수 없다
 	             				메소드는 {} 구현완료
					가급적이면 구현해서 전송 -> 선택적으로 처리가 가능하다 => default(원하는 기능만 재구현)
					
 */
public class 퍼즐게임 extends JFrame implements ActionListener, MouseListener{
	JButton[] btns = new JButton[9];
	JLabel la = new JLabel("퍼즐게임",JLabel.CENTER);
	JButton b1,b2;
	int [] panCount = new int[9];
	int last = 0;
	int cols = 0, rows=0; //빈칸
	//초기화
	public 퍼즐게임()
	{
		b1 = new JButton("시작");
		b2 = new JButton("종료");
		
		JPanel p = new JPanel();//컴퍼넌트 여러개를 묶어서 한 번에 배치
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3,3,5,5));//gridlayout 크기가 동일하게 배치되는 (ex. 계산기 숫자입력하는 부분처럼)
									//3x3배열인데 위아래 좌우를 5만큼의 간격을 준다
		for(int i=0;i<9;i++)
		{
			btns[i] = new JButton(String.valueOf(i+1));
			btns[i].setFont(new Font("궁서체", Font.BOLD,45));
			pan.add(btns[i]);
			btns[i].addActionListener(this);
		}
		setLayout(null);
		pan.setBounds(10, 15, 350, 350);
		add(pan);
		p.add(b1);p.add(b2);
		p.setBounds(10,370,350,35);
		add(p);
		
		setSize(380,470);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 퍼즐게임();
	}
	
	//버튼 처리하는 메소드 -> 클릭하면 자동호출
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==btns[last]) //마지막자리가 숫자가 없어서 오류생기기 때문에
			{								//if문으로 오류처리
				return ;
			}
			if(e.getSource()==btns[i])
			{
				panCount[i]=8;
				
				panCount[last]=Integer.parseInt(btns[i].getText())-1;
				last=i;
				puzzleLayout();
				
				if(isEnd())
				{
					JOptionPane.showMessageDialog(this, "Game Over");
					//System.exit(0);
				}
			}
		}
		if(e.getSource()==b2) 
		{
			System.exit(0);
		}
		else if(e.getSource()==b1)
		{
			getRand();
			puzzleLayout();
		}
	}

	
	//사용자 정의 메소드
	public void getRand()
	{
		for(int i=0;i<9;i++)
		{
			panCount[i]=(int)(Math.random()*9);
			for(int j=0;j<i;j++)
			{
				if(panCount[i]==panCount[j])
				{
					i--;
					break;
				}
			}//중복없는 랜덤
		}
		
		for(int i=0;i<9;i++)
		{
			if(panCount[i]==8)
			{
				last=i;
				break;
			}
				
		}
		
			
	}
	//배치
	public void puzzleLayout()
	{
		for(int i=0;i<9;i++)
		{
			if(last==i)
			{
				btns[i].setText("");
			}
			else 
			{
				btns[i].setText(String.valueOf(panCount[i]+1));
			}
		}
	}
	
	public boolean isEnd()
	{
		for(int i=0;i<9;i++)
		{
			if(panCount[i]!=i)
			{
				return false;
			}
		}

		return true;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
