package com.sist.client;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;
import com.sist.vo.*;
import com.sist.dao.*;
public class BoardUpdate extends JPanel implements ActionListener{
    JLabel titleLa,nameLa,subLa,contLa,pwdLa,noLa;
    JTextField nameTf,subTf;
    JPasswordField pwdPf;
    JTextArea ta;
    JButton b1,b2;
    ControlPanel cp;
    public BoardUpdate(ControlPanel cp)
    {
    	this.cp=cp;
    	titleLa=new JLabel("수정하기",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
    	setLayout(null);
    	titleLa.setBounds(100, 15, 830, 50);
    	add(titleLa);
    	
    	noLa=new JLabel();
    	noLa.setBounds(340, 70, 20, 30);
    	add(noLa);
    	noLa.setVisible(false);
    	// <input type=hidden>
    	
    	nameLa=new JLabel("이름",JLabel.CENTER);
    	nameTf=new JTextField();
    	nameLa.setBounds(100, 70, 80, 30);
    	nameTf.setBounds(185, 70, 150, 30);
    	add(nameLa);add(nameTf);
    	
    	subLa=new JLabel("제목",JLabel.CENTER);
    	subTf=new JTextField();
    	subLa.setBounds(100, 105, 80, 30);
    	subTf.setBounds(185, 105, 450, 30);
    	add(subLa);add(subTf);
    	
    	
    	contLa=new JLabel("내용",JLabel.CENTER);
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	contLa.setBounds(100, 140, 80, 30);
    	js.setBounds(185, 140, 450, 250);
    	add(contLa);add(js);
 
    	pwdLa=new JLabel("비밀번호",JLabel.CENTER);
    	pwdPf=new JPasswordField();
    	//             Top  Right Bottom Left ==> CSS
    	pwdLa.setBounds(100, 395, 80, 30);
    	//             x  y width heigth
    	pwdPf.setBounds(185, 395, 150, 30);
    	add(pwdLa);add(pwdPf);
    	
    	b1=new JButton("수정");
    	b2=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(100, 435, 535, 35);
    	add(p);
    	
    	b1.addActionListener(this); //수정	
    	b2.addActionListener(this); //취소
    	
    }
    
    //값 채우기
    public void print(ReplyBoardVO vo)
    {
    	nameTf.setText(vo.getName());
    	subTf.setText(vo.getSubject());
    	ta.setText(vo.getContent());
    	noLa.setText(String.valueOf(vo.getNo()));
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			cp.card.show(cp, "BDETAIL");
		}
		else if(e.getSource()==b1)
		{
			//실제 수정을 담당하는 곳
			String name=nameTf.getText();
			if(name.trim().length()<1)
			{
				nameTf.requestFocus();
				return;
			}
			String subject=subTf.getText();
			if(subject.trim().length()<1)
			{
				subTf.requestFocus();
				return;
			}
			String content=ta.getText();
			if(content.trim().length()<1)
			{
				ta.requestFocus();
				return;
			}
			String pwd=String.valueOf(pwdPf.getPassword());
			if(pwd.trim().length()<1)
			{
				pwdPf.requestFocus();
				return;
			}
			
			String no=noLa.getText();
			
			ReplyBoardVO vo = new ReplyBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			vo.setNo(Integer.parseInt(no));
			
			//오라클연결
			ReplyBoardDAO dao = ReplyBoardDAO.newInstance();
			boolean bCheck=dao.boardUpdate(vo);
			
			if(bCheck==true)
			{
				cp.card.show(cp, "BDETAIL");
				cp.bDetail.print(2, vo.getNo());
			}
			else
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다\n다시 입력하세요");
				pwdPf.setText("");
				pwdPf.requestFocus();
			}
		}
		
	}
}