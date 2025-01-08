package com.sist.main;
import javax.swing.*;

import com.sist.dao.EmpDAO;
import com.sist.vo.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class UserMain extends JFrame implements ActionListener, MouseListener{

	CardLayout card = new CardLayout();
	JMenuItem empItem = new JMenuItem("사원관리");
	JMenuItem foodItem = new JMenuItem("맛집관리");
	JMenuItem eFindItem = new JMenuItem("사원검색");
	JMenuItem fFindIten = new JMenuItem("맛집검색");
	JMenuItem exit = new JMenuItem("종료");
	
	//화면을 모아서 관리
	EmpListPanel ep = new EmpListPanel();
	EmpFindPanel efp = new EmpFindPanel();
	public UserMain()
	{
		//Jmenu -> 상단의 메뉴바의 한 칸 / 여러개의 메뉴 아이템을 가진다
		setLayout(card);
		JMenu menu1 = new JMenu("관리");
		menu1.add(empItem);
		menu1.addSeparator(); //메뉴 아이템 사이의 분리선으로 separator라고 부름

		menu1.add(foodItem);
		menu1.addSeparator();
		menu1.add(exit);
		
		JMenu menu2 = new JMenu("검색");
		menu2.add(eFindItem);
		menu2.addSeparator(); //구분자
		menu2.add(fFindIten);
		menu2.addSeparator();
		
		JMenuBar bar = new JMenuBar();
		
		bar.add(menu1);
		bar.add(menu2);
		
		setJMenuBar(bar);
		
		add("EFP",efp); //컨테이너(카드) 임의의 이름을 지정
		add("EP",ep);
		
		
		empDataPrint();
		
		
		setSize(800,600);
		setVisible(true); //창에 화면을 나타낼 것인지 설정
		setTitle("Emp, Food 데이터 검색/출력");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ep.table.addMouseListener(this);
		
		empItem.addActionListener(this);
		foodItem.addActionListener(this);
		eFindItem.addActionListener(this);
		fFindIten.addActionListener(this);
		exit.addActionListener(this);
		
		efp.b.addActionListener(this);//버튼
		efp.tf.addActionListener(this);//엔터
		
	}

	
	public void empDataPrint()
	{
		//오라클연결
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empListData();
		for(EmpVO vo : list)
		{
			String[] data = {
					String.valueOf(vo.getEmpno()),
					vo.getEname(),
					vo.getJob(),
					vo.getHiredate().toString(),
					vo.getDvo().getDname(),
					vo.getDvo().getLoc()
			};
			ep.model.addRow(data);
		}
		
		
	}
	
	public void empFindPrint(String col,String fd)
	{
		//오라클연결
		for(int i=efp.model.getRowCount()-1;i>=0;i--)
		{
			efp.model.removeRow(i);
		}//검색할 때 계속 결과가 쌓이니까 
		//다시 검색할 때 결과를 지우고 다시 들어와야해
		
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empFindData(col, fd);
		for(EmpVO vo : list)
		{
			String[] data = {
					String.valueOf(vo.getEmpno()),
					vo.getEname(),
					vo.getJob(),
					vo.getHiredate().toString(),
					vo.getDvo().getDname(),
					vo.getDvo().getLoc()
			};
			efp.model.addRow(data);
			//테이블에출력해라
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserMain();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit)
		{
			System.exit(0);//종료
		}
		else if(e.getSource()==empItem)
		{
			card.show(getContentPane(), "EP"); 
			//화면바꾸기
			//웹에서는 <a href="list.jsp">
		}
		else if(e.getSource()==eFindItem)
		{
			card.show(getContentPane(), "EFP");
			//화면바꾸기
			//웹에서는 <a href="find.jsp">
		}
		else if(e.getSource()==efp.b||e.getSource()==efp.tf)//버튼을 클릭하거나 엔터를 누르면
		{
			String col=efp.box.getSelectedItem().toString();
			String fd=efp.tf.getText();
			if(fd.trim().length()<1)
			{
				efp.tf.requestFocus();
				return;
			}
			empFindPrint(col, fd.toUpperCase());
			//데이터는 대소문자 구분이 필요하기 때문에
			//대문자로 바꿔서 보내야 소문자를 입력했을 때도 결과값을 받을 수 있다
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ep.table)
		{
			if(e.getClickCount()==2)// 더블 클릭 
			{
				// 사번 
				int row=ep.table.getSelectedRow();
				//if(row==0) return;
				String empno=
						ep.model.getValueAt(row, 0).toString();
				//OptionPane.showMessageDialog(this, empno);
				EmpDAO dao=EmpDAO.newInstance();
				EmpVO vo=dao.empDetailData(Integer.parseInt(empno));
				String info="사번:"+vo.getEmpno()+"\n"
						   +"이름:"+vo.getEname()+"\n"
						   +"직위:"+vo.getJob()+"\n"
						   +"사수명:"+vo.getmEname()+"\n"
						   +"입사일:"+vo.getHiredate().toString()+"\n"
						   +"급여:"+vo.getSal()+"\n"
						   +"성과급:"+vo.getComm()+"\n"
						   +"부서명:"+vo.getDvo().getDname()+"\n"
						   +"근무지:"+vo.getDvo().getLoc()+"\n"
						   +"호봉:"+vo.getSvo().getGrade();
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
