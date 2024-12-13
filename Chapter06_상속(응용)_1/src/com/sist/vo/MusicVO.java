package com.sist.vo;
//사용자정의 데이터형
public class MusicVO {
	private int no;
	private String title;
	private String singer;
	private String album;
	public int getNo() {
		return no;
	}
	
	//변수에 대한 기능 읽기,쓰기
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	
}
