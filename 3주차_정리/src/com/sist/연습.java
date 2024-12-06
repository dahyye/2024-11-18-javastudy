package com.sist;

public class 연습 {
	
	public int age;
	public String name;
	public boolean isMarried;
	public int children;
	
	public String orderNum;
	public String customerID;
	public String orderDate;
	public String customerName;
	public String productNum;
	public String ShippingAddress;
	
	public void orderInfo()
	{
	
		System.out.println("주문번호 :"+orderNum);
		System.out.println("주문자 아이디 :"+customerID);
		System.out.println("주문 날찌 :"+orderDate);
		System.out.println("주문자 이름 :"+customerName);
		System.out.println("주문 상품 번호 :"+ productNum);
		System.out.println("배송 주소 :"+ShippingAddress);
	}
	
	public void peopleInfo()
	{
		System.out.println("나이 :"+age);
		System.out.println("이름 :"+name);
		System.out.println("결혼 여부 :"+isMarried);
		System.out.println("자녀 수 :"+children);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		연습 peopleJames=new 연습();
		
		peopleJames.age = 40;
		peopleJames.name = "James";
		peopleJames.isMarried = true;
		peopleJames.children = 3;
		//peopleJames.peopleInfo();
		
		연습 name1 = new 연습();
		
		name1.orderNum = "201907210001";
		name1.customerID = "abc123";
		name1.orderDate = "2019년 7월 21일";
		name1.customerName = "홍길순";
		name1.productNum = "PD-345-12";
		name1.ShippingAddress = "서울시 영등포구 여의도동 20번지";
		
		name1.orderInfo();
		
		
		
	}

}
