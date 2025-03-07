package com.sist.client;
import java.awt.Color;
import java.awt.Font;

// detail.jsp
import javax.swing.*;

import com.sist.dao.ReplyBoardDAO;
import com.sist.vo.*;
import java.awt.event.*;
//고유번호(Primary Key) -> 상세보기, 수정, 삭제, 답변
//hiden으로 감추고 시작
public class BoardDetail extends JPanel implements ActionListener{
     JLabel titleLa,nameLa,noLa,subLa,dayLa,hitLa;
     JLabel name,no,sub,day,hit;
     JTextArea ta;
     JButton b1,b2,b3, b4; // 수정 / 삭제 / 목록 
     ControlPanel cp;
     public  BoardDetail(ControlPanel cp)
     {
    	 this.cp=cp;
    	 titleLa=new JLabel("내용보기",JLabel.CENTER);// <table>
     	 titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
     	 
     	 setLayout(null);
    	 titleLa.setBounds(10, 15, 830, 50);
    	 add(titleLa);
    	 
    	 noLa=new JLabel("번호",JLabel.CENTER);
    	 noLa.setBounds(100, 75 , 80, 30);
    	 noLa.setBackground(Color.green);
     	 noLa.setOpaque(true);
     	 //jlabel은 투명모드 -> 불투명으로 바꾸는게 setOpaque(true) 
     	 
    	 no=new JLabel("",JLabel.CENTER);
    	 no.setBounds(185, 75, 120, 30);
    	 add(noLa);add(no);
    	 
    	 dayLa=new JLabel("작성일",JLabel.CENTER);
    	 dayLa.setBounds(310, 75 , 80, 30);
    	 dayLa.setBackground(Color.green);
    	 dayLa.setOpaque(true);
    	 day=new JLabel("",JLabel.CENTER);
    	 day.setBounds(395, 75, 200, 30);
    	 add(dayLa);add(day);
    	 
    	 nameLa=new JLabel("이름",JLabel.CENTER);
    	 nameLa.setBounds(100, 110 , 80, 30);
    	 nameLa.setBackground(Color.green);
    	 nameLa.setOpaque(true);
    	 name=new JLabel("",JLabel.CENTER);
    	 name.setBounds(185, 110, 120, 30);
    	 add(nameLa);add(name);
    	 
    	 hitLa=new JLabel("조회수",JLabel.CENTER);
    	 hitLa.setBounds(310, 110 , 80, 30);
    	 hitLa.setBackground(Color.green);
    	 hitLa.setOpaque(true);
    	 hit=new JLabel("",JLabel.CENTER);
    	 hit.setBounds(395, 110, 200, 30);
    	 add(hitLa);add(hit);
    	 
    	 subLa=new JLabel("제목",JLabel.CENTER);
    	 subLa.setBounds(100, 145 , 80, 30);
    	 subLa.setBackground(Color.green);
    	 subLa.setOpaque(true);
    	 sub=new JLabel("");
    	 sub.setBounds(185, 145, 400, 30);
    	 add(subLa);add(sub);
    	 
    	 ta=new JTextArea();
    	 ta.setEditable(true); // 비활성화 
    	 ta.setBounds(100, 180, 485, 250);
    	 add(ta);
    	 
    	 JPanel p=new JPanel();
    	 b1=new JButton("수정");
    	 b2=new JButton("삭제");
    	 b3=new JButton("목록");
    	 b4=new JButton("답변");
    	 p.add(b4); p.add(b1);p.add(b2);p.add(b3);
    	 p.setBounds(100, 440, 485, 35);
    	 add(p);
    	 
    	 b1.addActionListener(this);//수정
    	 b2.addActionListener(this);//삭제
    	 b3.addActionListener(this);//목록
    	 b4.addActionListener(this);//답변
     }
     
     public void print(int type,int n)
     {
    	 //데이터베이스연동
    	 ReplyBoardDAO dao= ReplyBoardDAO.newInstance();
    	 ReplyBoardVO vo=dao.boardDetailData(type,n);
    	 name.setText(vo.getName());
    	 no.setText(String.valueOf(vo.getNo()));
    	 day.setText(vo.getDbday());
    	 hit.setText(String.valueOf(vo.getHit()));
    	 sub.setText(vo.getSubject());
    	 ta.setText(vo.getContent());
    	 
     }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b3) //목록
		{
			cp.card.show(cp, "BLIST");
			cp.bList.print();
			
			
			
		}
		else if(e.getSource()==b1) //수정
		{
			cp.bUpdate.pwdPf.setText("");
			String strNo=no.getText();
			ReplyBoardDAO dao= ReplyBoardDAO.newInstance();
			ReplyBoardVO vo = dao.boardUpdateData(Integer.parseInt(strNo));
			cp.card.show(cp, "BUPDATE");
			cp.bUpdate.print(vo);
		}
		else if(e.getSource()==b2) //삭제https://www.snuh.org/content/M001004005.do
		{
			String strNo=no.getText();
			cp.bDelete.pf.setText("");
			cp.card.show(cp, "BDELETE");
			cp.bDelete.noLa.setText(strNo);
			cp.bDelete.pf.requestFocus();
			}
		else if(e.getSource()==b4) //답변
		{
			String strNo=no.getText(); //번호
			//초기화
			//윈도우는 화면 변경할 때 초기화가 안된다 -> 따로 초기화해줘야해
			
			cp.bReply.nameTf.setText("");
			cp.bReply.subTf.setText("");
			cp.bReply.ta.setText("");
			//화면이동
			cp.card.show(cp, "BREPLY");
			cp.bReply.noLa.setText(strNo);
			
		}
	}
}