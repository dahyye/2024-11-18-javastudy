package com.sist.board;
import java.util.*;
import java.io.*;
public class BoardManager {
	//게시물을 모아서 관리 영역
	//게시몰이 모든 사용자에게 공유 => static
	//윈도우창 여러개에서 한 개의 데이터로 사용
	private static List<BoardVO> boardList = new ArrayList<BoardVO>();
	//오라클 -> 저장된 데이터가 
	
	//초기화
	public BoardManager()
	{
		boardGetData(); 
		//추가될 때 마다 데이터를 계속 일어와야 한다
		
	}
	
	public void boardGetData()
	{
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("c:\\java_data\\board.txt");
			ois = new ObjectInputStream(fis);
			boardList = (List<BoardVO>)ois.readObject();
			//ObjectInputStream => 파일과 연결이 되어있어야 데이터를 가지고 온다
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	//자바는 자동갱신이 없다
	public void boardSave()
	{
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\board.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			// 수정 -> boardList.set()
			// 삭제 -> boardList.remove()
			// 추가 -> boardList.add()
			// 파일은 마지막에 항상 갱신해줘야해
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	//총페이지
	public int boardTotalpage()
	{
		return (int)(Math.ceil(boardList.size()/10.0)); 
		//ceil 올림
	}
	
	//시퀀스(게시물 번호를 자동으로 생성)
	public int boardSequence()
	{
		int max=0;
		
		try {
			for(BoardVO vo : boardList)
			{
				if(vo.getNo()>max)
				{
					max=vo.getNo();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//예외처리를 하는 이유
		//처음에 데이터가 없을 땐 for문에서 오류가 나기 때문에 자동으로 오류처리를 하고 바로 max+1;을 리턴
		//이때 max가 0이니까 1값을 리턴함
		return max+1;
	}
	
	//기능설정
	//저장,읽기부분이 계속 중복=> 별도의 메소드를 만들어줘야한다
	//게시물 번호를 자동생성 해주는 메소드도 추가해야함 -> 시퀀스 
	
	
	//1. 목록출력 -> 페이지나누기 read
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		int j=0;
		int pagecnt=(page*10)-10;// ( cnt/10);
		List<BoardVO> temp = new  ArrayList<BoardVO>();
		//최신글이 위로 올라와야 하기 때문에
		//끝에서부터 데이터 넣기
		for(int i=boardList.size()-1;i>=0;i--)
		{
			temp.add(boardList.get(i));
		}
		for(int i=0;i<temp.size();i++)
		{
			if(j<10 && i>=pagecnt)	
			{
				BoardVO vo = temp.get(i);
				list.add(vo);
				j++;
			}
		}
		
		return list;
	}
	
	
	//2. 추가 create
	public void boardInsert(BoardVO vo)
	{
		boardList.add(vo);
		boardSave();//파일 변경, 저장된 데이터를 파일로
		
	}
	
	
	//3. 상세보기
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo = new BoardVO();
		for(BoardVO dvo : boardList)
		{
			if(dvo.getNo()==no)
			{
				dvo.setHit(dvo.getHit()+1);//클릭하면조회수증가
				boardSave(); //데이터 갱신
				break;
			}
		}
		boardGetData();
		for(BoardVO dvo : boardList)
		{
			if(dvo.getNo()==no)
			{
				vo=dvo;
				break;
			}
		}
		
		return vo;
	}
	
	
	//4. 수정 / 삭제
	public boolean boardDelete(int no, String pwd)
	{
		boolean bCheck = true;
		for(BoardVO vo : boardList) //비밀번호체크
		{
			if(vo.getNo()==no)
			{
				if(!vo.getPwd().equals(pwd))
				{
					bCheck = false;
					return bCheck;
				}
			}
		}
		
		int index=0;
		//remove(index) -> index값을 찾기 위한 변수
		for(int i=0;i<boardList.size();i++)
		{
			BoardVO vo = boardList.get(i);
					if(vo.getNo()==no)
					{
						index=i;
						break;
					}
						
		}
		boardList.remove(index);
		boardSave();//파일저장
		return bCheck;
	}
	
	//수정하기는 기존데이터값이 들어와야 하기 때문에
	//2번에 나눠서 철
	//1번째는 데이터 가지고 들어오기 
	//2번째는 데이터 수정
	public BoardVO boardUpdateData(int no)
	{
		
		BoardVO vo = new BoardVO();
		for(BoardVO dvo : boardList)
		{
			if(dvo.getNo()==no)
			{
				vo=dvo;
				break;
			}
		}
		return vo;
		
	}
	
	public boolean boardUpdateData(BoardVO vo)
	{
		boolean bCheck=false;
		int index=0;
		for(int i=0;i<boardList.size();i++)
		{
			BoardVO dvo = boardList.get(i);
			if(vo.getNo()==dvo.getNo())
			{
				index = i;
				break;
			}
		}
		BoardVO dvo = boardList.get(index);
		if(dvo.getPwd().equals(vo.getPwd()))
		{
			bCheck = true;
			boardList.set(index, vo);
			boardSave();//수정된 파일로 변경
		}
		else
		{
			bCheck=false;
		}
		return bCheck;
		
		
	}
	//5. 찾기 -> 검색
	
	
}
