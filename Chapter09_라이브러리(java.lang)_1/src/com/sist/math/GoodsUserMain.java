package com.sist.math;

public class GoodsUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsDAO dao = GoodsDAO.newInstance();
		//newInstance() getInstance() 
		int count = dao.goodsTotalPage();
		int totalpage = (int)(Math.ceil(count)/15.0);
		System.out.println("파일 수 : "+count);
		System.out.println("총페이지 : "+totalpage);
	}

}
