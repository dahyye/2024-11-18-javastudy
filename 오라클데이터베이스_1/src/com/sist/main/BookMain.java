package com.sist.main;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class BookMain extends JFrame implements ActionListener{

	JTextField tf;
	JButton b1;
	JTable table;
	DefaultTableModel model;
	
	public BookMain()
	{
		tf = new JTextField(10);
		b1 = new JButton("검색");
		//bookid,bookname,publisher,price FROM book
		String[] col = {"번호","이름","출판사","가격"};
		String[][] row= new String[0][4];
		model = new DefaultTableModel(row,col);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		
		JPanel p = new JPanel();
		p.add(tf); p.add(b1);
		
		add("North",p);
		add("Center",js);
		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		tf.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookMain();
	}

	//오라클로부터 데이터가져와서 테이블에 데이터 출력
	public void bookFind(String publisher)
	{
		//
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		
		//오라클에서 데이터 가져와
		BookDAO dao = BookDAO.newInstance();
		List<BookVO> list = dao.bookFind(publisher);
		for(BookVO vo : list)
		{
			String[] data = {toString().valueOf(vo.getBookid()),
					vo.getBookname(),
					vo.getPublisher(),
					toString().valueOf(vo.getPrice())};
			model.addRow(data);
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1||tf==e.getSource())
		{
			String publisher = tf.getText();
			if(publisher.trim().length()<1)
			{
				tf.requestFocus();
				return;	
			}
			BookDAO dao = BookDAO.newInstance();
			System.out.println("dao생성");
			int count = dao.bookFindCount(publisher);
			System.out.println("카운트값 받아오기");
			if(count==0)
			{
				
				JOptionPane.showMessageDialog(this, "검색결과가 없습니다");
				tf.setText("");
				tf.requestFocus();
			}
			else
			{
				bookFind(publisher);
			}
		}
	}

}
