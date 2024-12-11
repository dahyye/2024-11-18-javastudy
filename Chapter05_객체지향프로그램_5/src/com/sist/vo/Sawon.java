package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//[접근지정어] 데이터형 변수명 => 접근지정어 (private)
// 특별한 경우 : Button/Table -> public을 줘도 상관없다
// 공개 / 비공개 선택
//@Getter 어노테이션
@Getter
@Setter
@NoArgsConstructor //default 생성자
@AllArgsConstructor //매개변수 생성자
@Data 

public class Sawon {

	private int sabun;
	private String name;
	private String dept;
	private String job; //public 이였을 때 이것만 다른 패키지에서 접근 가능
	private String regdate;//입사일
	private int pay;
	
	//오른쪽마우스->source->getter, setter 추가
	//캡슐화
//	public int getSabun() { //public으로 생성되기때문에 외부에서 접근 가능
//		return sabun;
//	}
//	public void setSabun(int sabun) {
//		this.sabun = sabun;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	public String getJob() {
//		return job;
//	}
//	public void setJob(String job) {
//		this.job = job;
//	}
//	public String getRegdate() {
//		return regdate;
//	}
//	public void setRegdate(String regdate) {
//		this.regdate = regdate;
//	}
//	public int getPay() {
//		return pay;
//	}
//	public void setPay(int pay) {
//		this.pay = pay;
//	}
	
	
	
	
}
