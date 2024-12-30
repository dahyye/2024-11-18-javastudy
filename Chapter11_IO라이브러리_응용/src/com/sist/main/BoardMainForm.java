package com.sist.main;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.awt.event.*;
import com.sist.board.*;

public class BoardMainForm extends JFrame implements ActionListener,MouseListener{
	CardLayout card = new CardLayout();
	BoardList bList = new BoardList();
	BoardDetail bDetail = new BoardDetail();
	BoardInsert bInsert = new BoardInsert();
	BoardUpdate bUpdate = new BoardUpdate();
	BoardDelete bDelete = new BoardDelete();
	//게시판 관리자
	BoardManager bm = new BoardManager();
	
	//변수 설정
	int curpage=1;
	int totalpage=0;
	
	public BoardMainForm()
	{
		setLayout(card);
		add("LIST",bList);
		add("DETAIL",bDetail);
		add("INSERT", bInsert);
		add("UPDATE",bUpdate );
		add("DELETE", bDelete);
		
		setTitle("윈도우 게시판 ver1.0");
		listPrint();
		setSize(640,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트등록
		bList.inBtn.addActionListener(this); //글쓰기창으로 이동
		bInsert.b1.addActionListener(this); //글쓰기
		bInsert.b2.addActionListener(this); // 취소
		
		bList.prevBtn.addActionListener(this);
		bList.nextBtn.addActionListener(this);
		bList.table.addMouseListener(this);
		
		bDetail.b1.addActionListener(this);//상세보기->수정
		bDetail.b2.addActionListener(this);//상세보기->삭제
		bDetail.b3.addActionListener(this);//상세보기->목록
		
		bDelete.b1.addActionListener(this); //삭제 -> 삭제
		bDelete.b2.addActionListener(this);// 삭제 -> 취소
		
		bUpdate.b1.addActionListener(this); //수정 -> 수정
		bUpdate.b2.addActionListener(this); //수정 -> 취소
	}
	
	public void listPrint()
	{
		//table의 내용을 지운다 -> 다음페이지 누르면 이전페이지 내용이 지워지고 다음 페이지의 내용이 출력되어야 하기 때문에
		for(int i=bList.model.getRowCount()-1;i>=0;i--) //뒤에서부터 지워야해
		{
			bList.model.removeRow(i);
		}
		
		
		//다른패키지에 같은 이름의 클래스가 있는 경우
		// java.util.list   java.awt.*
		//데이터받기
		List<BoardVO> list = bm.boardListData(curpage);
		totalpage = bm.boardTotalpage();
		bList.pageLa.setText(curpage+"page / "+totalpage+"pages");
		
		//게시물 출력
		for(int i=0;i<list.size();i++)
		{
			BoardVO vo = list.get(i);
			String[] data = {String.valueOf(vo.getNo()), vo.getSubject(), vo.getName(), new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()),String.valueOf(vo.getHit())};
			bList.model.addRow(data);
		
			
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardMainForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(bList.inBtn==e.getSource())//목록에서 새글버튼을 클릭했을 때
		{
			bInsert.nameTf.setText("");
			bInsert.subTf.setText("");
			bInsert.ta.setText("");
			bInsert.pwdPf.setText("");
			//공백으로 만들고 시작해야해 
			
			//윈도우창 변경
			card.show(getContentPane(), "INSERT");// (창을 보여주는 위치 , 바꿀 위치)
			bInsert.nameTf.requestFocus(); //커서가 시작될 위치
		}
		else if(bInsert.b2==e.getSource())//글쓰기 취소버튼
		{
			card.show(getContentPane(), "LIST");
			
		}
		else if(bInsert.b1==e.getSource()) //글쓰기 버튼
		{

			String name=bInsert.nameTf.getText();
			//입력된 값
			if(name.length()<1)
			{
				//유효성검사
				bInsert.nameTf.requestFocus();
				return;
			}
			
			String subject=bInsert.subTf.getText();
			//입력된 값
			if(subject.length()<1)
			{
				//유효성검사
				bInsert.subTf.requestFocus();
				return;
			}
			
			String content=bInsert.ta.getText();
			//입력된 값
			if(content.length()<1)
			{
				//유효성검사
				bInsert.ta.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(bInsert.pwdPf.getPassword());
			//입력된 값
			if(pwd.length()<1)
			{
				//유효성검사
				bInsert.pwdPf.requestFocus();
				return;
			}
			
			//데이터 모으기
			BoardVO vo = new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			int no=bm.boardSequence();
			vo.setNo(no);
			vo.setRegdate(new Date()); //게시글작성시간
			
			//데이터 추가
			bm.boardInsert(vo);
			card.show(getContentPane(), "LIST");
			listPrint();
			
		}
		//이전버튼
		else if(e.getSource()==bList.prevBtn)
		{
			if(curpage>1)
			{
				curpage--;
				listPrint();
			}
		}
		//다음버튼
		else if(e.getSource()==bList.nextBtn)
		{
			if(curpage<totalpage)
			{
				curpage++;
				listPrint();
			}
		}
		else if(bDetail.b1==e.getSource())//상세보기 ->수정
		{
			String no=bDetail.no.getText();
			BoardVO vo = bm.boardUpdateData(Integer.parseInt(no));
			card.show(getContentPane(), "UPDATE"); //화면이동
			
			//값채우기
			bUpdate.nameTf.setText(vo.getName());
			bUpdate.subTf.setText(vo.getSubject());
			bUpdate.ta.setText(vo.getContent());
			
		}
		else if(bUpdate.b1==e.getSource())//수정 ->수정
		{
			String name=bUpdate.nameTf.getText();
			//입력된 값
			if(name.length()<1)
			{
				//유효성검사
				bUpdate.nameTf.requestFocus();
				return;
			}
			
			String subject=bUpdate.subTf.getText();
			//입력된 값
			if(subject.length()<1)
			{
				//유효성검사
				bUpdate.subTf.requestFocus();
				return;
			}
			
			String content=bUpdate.ta.getText();
			//입력된 값
			if(content.length()<1)
			{
				//유효성검사
				bUpdate.ta.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(bUpdate.pwdPf.getPassword());
			//입력된 값
			if(pwd.length()<1)
			{
				//유효성검사
				bUpdate.pwdPf.requestFocus();
				return;
			}
			
			BoardVO vo = new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			//vo.setRegdate(new Date()); //게시글작성시간
			
			//데이터 추가
			//bm.boardInsert(vo);
			//card.show(getContentPane(), "LIST");
			//listPrint();
			
			String no = bDetail.no.getText();
			boolean bCheck = bm.boardUpdateData(vo);
			if(bCheck==false)
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();
			}
			else
			{
				card.show(getContentPane(), "LIST");
				listPrint();
			}
			
			
		}

		else if(bUpdate.b2==e.getSource())//수정 ->취소
		{
			card.show(getContentPane(), "DETAIL");
		}

		
		else if(bDetail.b2==e.getSource())//상세보기 ->삭제
		{
			System.out.println("삭제");
			card.show(getContentPane(), "DELETE");
		}

		else if(bDelete.b1==e.getSource())//삭제 -> 삭제
		{
			String pwd = String.valueOf(bDelete.pf.getPassword());
			if(pwd.length()<1)
			{
				bDelete.pf.requestFocus();
				return;
			}
			String no = bDetail.no.getText();
			boolean bCheck = bm.boardDelete(Integer.parseInt(no), pwd);
			if(bCheck==false)
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();
			}
			else
			{
				card.show(getContentPane(), "LIST");
				listPrint();
			}
		}
		
		else if(bDelete.b2==e.getSource())//삭제 -> 취소
		{
			card.show(getContentPane(), "DETAIL");
		}
		
		
		//웹에서는 반드시 현재페이지를 전송해줘야 보고있던 페이지로 이동
		else if(bDetail.b3==e.getSource())//상세보기 -> 목록
		{
			card.show(getContentPane(), "LIST");
			
		}
		
		
		
	}

	
	//onMouseDown
	@Override
	public void mouseClicked(MouseEvent e) { //클릭할 때
		// TODO Auto-generated method stub
		if(e.getSource()==bList.table)
		{
			if(e.getClickCount()==2)//더블클릭시
			{
				int row = bList.table.getSelectedRow();//SelectedRow가 선택한 행의 인덱스
				String no=bList.model.getValueAt(row, 0).toString();
				//System.out.println(no);
				BoardVO vo = bm.boardDetailData(Integer.parseInt(no));
				//정수변환해서 보내야해 
				card.show(getContentPane(), "DETAIL");
				//출력
				
				bDetail.no.setText(String.valueOf(vo.getNo())); //스트링만 받기 때문에 in를 문자로 변환
				bDetail.name.setText(vo.getName());
				bDetail.sub.setText(vo.getSubject());
				bDetail.ta.setText(vo.getContent());
				bDetail.hit.setText(String.valueOf(vo.getHit()));
				bDetail.day.setText(new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()));
				
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) { //누르고 있을 때(예.드레그)
		// TODO Auto-generated method stub
		
	}
	
	//onMouseUp
	@Override
	public void mouseReleased(MouseEvent e) { //놓았을 때
		// TODO Auto-generated method stub
		
	}
	//onMouseOver
	@Override
	public void mouseEntered(MouseEvent e) { //
		// TODO Auto-generated method stub
		
	}
	//onMouseOut
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
