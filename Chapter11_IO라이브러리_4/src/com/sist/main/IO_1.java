package com.sist.main;
import java.io.*;
/*
 
 	1. 값 형식 데이터
 		int, / float / char ... 스택에 저장, 직접접근이 가능
 	2. 참조 형식 데이터
 		
 		
 		=> 네트워크 전송
 			값 자체를 저장후에 전송
 			=> 실제 값을 저장후에 전송
 		=> 다른 프로그램 전송 : CVS , JSON => 자체에서 값을 저장된 상태
 		
 		=> 값을 받을 경우에는 다시 -> 참조형으로 저장(역직렬화)
 					=> ObjectOutputStream / ObjectInputStream 사용
 					=> 원상 복귀가 가능
 		=> 초창기에는 많이 사용 => 오라클
 
 			Heap => 병렬 형식
 				   ---------
 				         						-----------------------------
 				   ---------					|   |    |      |      |     |				
 				    					==> 	-----------------------------
 				   ---------							Stack => 직렬 형식
 				   
 				   ---------
 				   
 				   ---------객체의 실제값 저장
 					
 		
 
 */
import java.util.*;
//객체의 실제값을 스택(실제 저장값) => 다른 컴퓨터로 전송
// 직렬화 => 빅데이터분석 => 하둡 => 파이썬(넘파일 , 판다스)

//=> 지하철 혼잡도, 날씨예측, 범죄예측, 자동차 리필 같은 프로그램을 짤 수 있다
// 데이터는 data.go.kr 에서 가지고 올 예정
//최종프로젝트에서 할 예정 => 스프링에서는파이썬이 연동x => 서버2개로 나눠서 해야해(스프링, 장고)

//데이터직렬화
class Sawon implements Serializable
{
	private int sabun; 
	private String name;
	private String dept;
	private String job;
	private int pay;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	//값을 저장 -> 생성자 이용
	public Sawon(int sabun, String name, String dept, String job, int pay) 
	{
		
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	
	public Sawon()
	{
		//디폴트 생성자
	}
}
public class IO_1 {
	public static void main(String[] args) {
		
		List<Sawon> list = new ArrayList<Sawon>();
		//Object => 데이터를 모아서 저장이 가능
		list.add(new Sawon(1,"홍길동", "개발부", "사원",3200));
		list.add(new Sawon(2,"심청이", "총무부", "과장",4200));
		list.add(new Sawon(3,"이순신", "영업부", "부장",5200));
		list.add(new Sawon(4,"강감친", "자재부", "사원",3200));
		list.add(new Sawon(5,"춘향이", "기획부", "사원",3200));
		ObjectOutputStream oos = null;
		try 
		{
			File file = new File("c:\\java_data\\sawon_info.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("객체 단위 저장완료!!");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				oos.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
			}
		}
		
	}
}





