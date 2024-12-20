package com.sist.execute;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcMain extends JFrame implements ActionListener {

	//웹
	//숫자를 String으로 받아서 나중에 변환
	//웹에서는 숫자도 문자열로 입력되기 때문에
	// 10 + 10 = ?  이 때 10, 10 을 문자열로 받기때문에 정수형으로 변환 후 계산
	
	JTextField tf1, tf2, tf3;
	JLabel la;
	JComboBox box;
	JButton b1,b2;
	
	public CalcMain()
	{
		tf1 = new JTextField(7);
		tf2 = new JTextField(7);
		tf3 = new JTextField(7);
		la = new JLabel("=");
		box = new JComboBox();
		box.addItem("+");
		box.addItem("-");
		box.addItem("*");
		box.addItem("/");
		b1 = new JButton("계산");
		b2 = new JButton("종료");
		
		setLayout(new FlowLayout()); //한 줄에 출력
		add(tf1);
		add(box);
		add(tf2);
		add(la);
		add(tf3);
		add(b1);
		add(b2);
		
		setSize(500,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcMain();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==b1)
		{
			int n1=0, n2=0;
			try {
				String no1 =tf1.getText();
				n1=Integer.parseInt(no1);
				no1=tf1.getText();
				//정수로 변환이 안되면 예외처리
			} catch (Exception e2) {
				// TODO: handle exception
				tf1.setText("");
				tf1.requestFocus();
				return;
			}
			try {
				String no2 =tf2.getText();
				n2=Integer.parseInt(no2);
				no2=tf2.getText();
				//정수로 변환이 안되면 예외처리
			} catch (Exception e2) {
				// TODO: handle exception
				tf2.setText("");
				tf2.requestFocus();
				return;
			}
			
			String op = box.getSelectedItem().toString();
			
			switch(op)
			{
				case "+" :
					tf3.setText(String.valueOf(n1+n2));
					System.out.println(tf3);
					break;
					
				case "-" :
					tf3.setText(String.valueOf(n1-n2));
					break;
					
				case "*" :
					tf3.setText(String.valueOf(n1*n2));
					break;
					
				case "/" :
					if(n2==0) //이미 n2값이 변환되서 들어와
					{
						
						JOptionPane.showMessageDialog(null, "0으로 나눌 수 없다");
						tf2.setText("");
						tf2.requestFocus();
					}
					else
					{
						tf3.setText(String.valueOf(n1/(double)n2));
					}
					break;
					
				default :
				
					
			}
			
			
		}
	}

}
