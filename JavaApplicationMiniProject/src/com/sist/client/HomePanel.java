package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.*;
import com.sist.vo.*;
import java.util.List;
import java.net.*;


import com.sist.commons.ImageChange;
import com.sist.dao.*;

public class HomePanel extends JPanel implements ActionListener, MouseListener{
	ControlPanel cp;
	//이미지출력
	JPanel pan = new JPanel();
	JButton b1,b2; //페이지 이전, 다음
	JLabel la=new JLabel("0 page / 0 pages");
	JLabel[] imgs=new JLabel[12];
	
	int curpage=1;
	int totalpage=0;
	
	JTable table;
	DefaultTableModel model;
	TableColumn column;
	//데이터베이스 연동(FoodDAO)
	JTable table2;
	DefaultTableModel model2;
	TableColumn column2;
	
	
	FoodDAO dao = FoodDAO.newInstance();
	JLabel titleLa=new JLabel("인기 맛집 Top5",JLabel.CENTER);
	JLabel nameLa=new JLabel("현재 접속자",JLabel.CENTER);
	//				화면 이동시켜주는 코드
	MemberDAO mDao=MemberDAO.newInstance();
	public HomePanel(ControlPanel cp)
	{
		//Jpanel -> flowlayout
		setLayout(null);
		this.cp=cp;
		pan.setLayout(new GridLayout(3,4,5,5));
		pan.setBounds(20, 15, 550, 500);
		add(pan);
		
		
		b1=new JButton("이전");
		b2=new JButton("다음");
		JPanel p = new JPanel();
		p.add(b1); p.add(la); p.add(b2);
		
		p.setBounds(20, 530, 550, 35);
    	add(p);
    	
    	String[] col2={"아이디","이름","성별"};
    	Object[][] row2=new Object[0][3];
    	model2=new DefaultTableModel(row2,col2)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
    		
    	};
    	
    	String[] col={"","업체명","평점"};
    	Object[][] row=new Object[0][3];
    	model=new DefaultTableModel(row,col)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
    		
    	};
    	
    	table2=new JTable(model2);
    	table2.getTableHeader().setReorderingAllowed(false);
    	table2.setRowHeight(35);
    	JScrollPane js2=new JScrollPane(table2);
    	for(int i=0;i<col.length;i++)
    	{
    		column2=table2.getColumnModel().getColumn(i);
    		if(i==0)
    			column2.setPreferredWidth(100);
    		else if(i==1)
    			column2.setPreferredWidth(150);
    		else if(i==2)
    			column2.setPreferredWidth(80);
    	}
    	
    	
    	table=new JTable(model);
    	table.getTableHeader().setReorderingAllowed(false);
    	table.setRowHeight(35);
    	JScrollPane js=new JScrollPane(table);
    	for(int i=0;i<col.length;i++)
    	{
    		column=table.getColumnModel().getColumn(i);
    		if(i==0)
    			column.setPreferredWidth(100);
    		else if(i==1)
    			column.setPreferredWidth(150);
    		else if(i==2)
    			column.setPreferredWidth(80);
    	}
    	   	
    	
    	// 20, 595, 550, 35
    	titleLa.setBounds(580, 10, 230, 45);
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
    	add(titleLa);
    	js.setBounds(580,70, 230, 170);
    	add(js);
    	
    	
    	nameLa.setBounds(580,280, 230, 45);
    	nameLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
    	add(nameLa);
    	js2.setBounds(580,350, 230, 170);
    	add(js2);
    	
    	table2.addMouseListener(this);
    	b1.addActionListener(this);//이전
    	b2.addActionListener(this);//다음 
    	print();
	}
	//초기화
	public void init()
	{
		for(int i=0;i<imgs.length;i++)
		{
			imgs[i]=new JLabel("");
		}
		pan.removeAll(); //전체삭제
		pan.validate(); //재배치
	}
	//이미지 출력
	public void print()
	{
		//총페이지 읽기
		totalpage=dao.foodTotalPage();
		List<FoodVO> list=dao.foodListData(curpage);
		for(int i=0;i<list.size();i++)
		{
			FoodVO vo=list.get(i);
			try {
				
				URL url=new URL(vo.getPoster());
				Image image=ImageChange.getImage(new ImageIcon(url), 130, 180); //200,180
				imgs[i]=new JLabel(new ImageIcon(image));
				imgs[i].setToolTipText(vo.getName()+"^"+vo.getFno());
				pan.add(imgs[i]);
				imgs[i].addMouseListener(this);
			} catch (Exception e) {	}
		
		}
			la.setText(curpage+" page / "+totalpage+" page");
			
			for(int i=model.getRowCount()-1;i>=0;i--)
	    	{
	    		model.removeRow(i);
	    	}
			
			List<FoodVO> tList=dao.foodTop5();
	    	for(FoodVO vo:tList)
	    	{
	    		try
	    		{
	    			URL url=new URL("https://www.menupan.com"+vo.getPoster());
	    			Image image=ImageChange.getImage(new ImageIcon(url), 35, 35);
	    			Object[] data= {
	    				new ImageIcon(image),
	    				vo.getName(),
	    				String.valueOf(vo.getScore())
	    			};
	    			model.addRow(data);
	    		}catch(Exception ex) {}
	    	}
	    	
	    	//List<FoodVO>
	    	
	    	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				if(e.getClickCount()==2)
				{
					String fno=imgs[i].getToolTipText();
					fno=fno.substring(fno.lastIndexOf("^")+1); //사진에 마우스올리면 보이는 글씨에 번호가 있어 그 번호 이용해서 데이터가져오기
					FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
					cp.fdp.detailPrint(1, vo);
					cp.card.show(cp, "DETAIL");
				}
			}
		}
		
		if(e.getSource()==cp.hp.table2)
		{
			if(e.getClickCount()==2)
			{
				
				int selectRow=table2.getSelectedRow();
				

				String id=cp.hp.model2.getValueAt(selectRow, 0).toString();
				MemberVO vo=mDao.memberInfo(id);
				String info="이름:"+vo.getName()+"\n"+
							"성별:"+vo.getSex()+"\n"+
							"이메일:"+vo.getEmail()+"\n"+
							"생년월일:"+vo.getBirthday().toString()+"\n"+
							"주소:"+vo.getAddress()+"\n"+
							"등록일:"+vo.getRegdate();
				JOptionPane.showMessageDialog(this, info);
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
	//마우스가 올라갔다면
	public void mouseEntered(MouseEvent e) { 
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(new LineBorder(Color.red,3));
				//이미지에 마우스를 가져갈 때 마다 사진라인에 빨간색 표시가 된다
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(new LineBorder(null));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==b1)
		{
			//이전
			if(curpage>1)
			{
				curpage--;
				init();
				print();
			}
		}
		else if(e.getSource()==b2)
		{
			//다음
			if(curpage<totalpage)
			{
				curpage++;
				init();
				print();
			}
		}
	}
	
	
}
