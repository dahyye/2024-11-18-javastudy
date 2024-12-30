package com.sist.movie;
import java.io.Serializable;
/*

데이터베이스 : 컬럼

1.	1|
2.	쇼생크 탈출|
3.	드라마|
4.	https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|
5.	팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|
6.	2016 .02.24 재개봉, 1995 .01.28 개봉|
7.	15세 관람가|
8.	프랭크 다라본트


*/

public class Movie implements Serializable {  //직렬화를 하기 휘해서
	
	private int mno;
	private String title, genre, porster, actor, redate, grade, director;
	
	
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPorster() {
		return porster;
	}
	public void setPorster(String porster) {
		this.porster = porster;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
}
