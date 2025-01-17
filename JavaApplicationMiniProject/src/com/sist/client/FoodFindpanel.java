package com.sist.client;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*; //image,layout
import java.awt.event.*;
//import java.lang.foreign.AddressLayout;
import java.net.URL;

import com.sist.vo.*;
import com.sist.commons.ImageChange;
import com.sist.dao.*;
import java.util.List;
// 서버연동없이 자체적으로 처리
public class FoodFindpanel extends JPanel implements ActionListener, MouseListener{
	ControlPanel cp; //상세보기
	JTable table; //모양관리
	DefaultTableModel model; //데이터관리
	JTextField tf;
	JButton b;
	TableColumn column;
	FoodDAO dao = FoodDAO.newInstance();
	public FoodFindpanel(ControlPanel cp)
	{
		this.cp=cp;
		String[] col= { "번호", "","업체명","주소","음식종류","평점"};
		
		Object[][] row=new Object[0][6];
		model=new DefaultTableModel(row, col)
		{

			//클릭시 -> 편집방지
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			//이미지 출력 <?> => 와일드 카드 : 어떤 클래스든 사용이 가능
			//이미지 아이콘을 사용할 수 있게 만들어주기(상속없이 오버라이딩 가능)
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
			//오버라이딩 사용 => 라이브라리 변경
			//상속없이 오버라이딩이 가능 -> 익명의 클래스
			
			
		};
		
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(40);
		JScrollPane js1=new JScrollPane(table);
		
		//사이즈 조절
		for(int i=0;i<col.length;i++)
    	{
			
    		column=table.getColumnModel().getColumn(i);
    		if(i==0)
    			column.setPreferredWidth(80);
    		else if(i==1)
    			column.setPreferredWidth(80);
    		else if(i==2)
    			column.setPreferredWidth(180);
    		else if(i==3)
    			column.setPreferredWidth(350);
    		else if(i==4)
    			column.setPreferredWidth(160);
    		else if(i==5)
    			column.setPreferredWidth(80);
    		
    	}
		b=new JButton("검색");
		tf=new JTextField();
		
		setLayout(null);
		
		tf.setBounds(20,20,200,30);
		b.setBounds(225,20,80,30);
		
		js1.setBounds(20,60,800,500);
		
		add(tf); add(b);
		
		add(js1);
		
		 b.addActionListener(this);
    	 tf.addActionListener(this);
    	 table.addMouseListener(this);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b||e.getSource()==tf)
		{
			
			String address=tf.getText();
			if(address.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return;
			}
			
			print(address);
		}
	}
	
	public void print(String address)
	{
		
		//데이터 지우기
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		
		//데이터읽기
		List<FoodVO> list=dao.foodFindData(address);
		if(list.size()==0)
		{
			JOptionPane.showMessageDialog(this, "검색결과가 없습니다");
		}
		for(FoodVO vo:list)
		{
			try {
				URL url=new URL(vo.getPoster());
				Image image=ImageChange.getImage(new ImageIcon(url), 30, 30);
				//String name=""; //테이블 안에 들어간 값 색을 바꿀 땐 html을 이용, label은 setForeground이용하면 바꿀 수 있다
				Object[] data= {
						vo.getFno(), new ImageIcon(image),vo.getName(),vo.getAddress(),vo.getType()
						,vo.getScore()
					};
				model.addRow(data);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			
			if(e.getClickCount()==2)
			{
				
				int row=table.getSelectedRow();
				String fno=model.getValueAt(row, 0).toString();
				FoodVO vo = dao.foodDetailData(Integer.parseInt(fno));
				cp.fdp.detailPrint(3, vo);
				cp.card.show(cp, "DETAIL");
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
