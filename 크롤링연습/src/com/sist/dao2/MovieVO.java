package com.sist.dao2;
/*



M_NO        NOT NULL NUMBER        
M_TITLE     NOT NULL VARCHAR2(100) 
M_ENG_TITLE NOT NULL VARCHAR2(100) 
M_POST      NOT NULL VARCHAR2(100) 
NATION      NOT NULL VARCHAR2(40)  
GENRE       NOT NULL VARCHAR2(20)  
RUNTIME     NOT NULL VARCHAR2(20)  
REG_DATE             DATE          
TOTAL_AUDI           NUMBER        
DIR         NOT NULL VARCHAR2(20)  
ACT                  VARCHAR2(100) 
RATING               NUMBER(2,1)   
STORY       NOT NULL CLOB     

*/

import java.util.Date;

public class MovieVO {
	private int m_no,total_audi,rating;
	private String m_title,m_eng_title,m_post,nation,genre,runtime,dir,acr,story;
	private String reg_date;
	
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getTotal_audi() {
		return total_audi;
	}
	public void setTotal_audi(int total_audi) {
		this.total_audi = total_audi;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_eng_title() {
		return m_eng_title;
	}
	public void setM_eng_title(String m_eng_title) {
		this.m_eng_title = m_eng_title;
	}
	public String getM_post() {
		return m_post;
	}
	public void setM_post(String m_post) {
		this.m_post = m_post;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getAcr() {
		return acr;
	}
	public void setAcr(String acr) {
		this.acr = acr;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	

}
