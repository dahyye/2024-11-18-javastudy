package 취업정보;

/*
 	HTML(Hypertext Markup Language)
 	
 	Hypertext의 의미는 링크를 통해 다른 문서로 이동할 수 있ㄴ는 문서를 뜻함
 		=> 문서간 참조가 자유료워져서 문서검색이 쉬워졌다 
 	
 	언어 - 프로그래밍언어 : 연산을 통해 프로그램을 만드는 언어 ( c, c++, java, Python 등)
 	    - 마크업 언어  : 문서나 데이터의 구조를 표시하는 언어 ( HTML, XML 등)
 	   
 	  
 	 * HTML 구조 -> 트리구조
 	
 		<!DOCTYPE html>
 		<html>												HTML
 		<head>											  ↙      ↘
 			<title>페이지타이틀</title>						head	body
 		</head>											 ↓		↙  ↘
 		<body>											title  h1   p
 			<h1>제목</h1>								
 			<p>들어갈 문장</p>
 		</body>
 		</html>
 		
 		
 		<!DOCTYPE html> 이 문서가 HTML임을 명시
 		<html>	전체 틀 구성
 		이 안에 <head>	<body>	로 영역을 나누고
 		<body>태그 안에는 사용자 눈에 보이는, 즉 브라우저에 표시될 내용을 담고
 		<head>태그 안에는 사용자 눈에 보이진 않지만 해당 문서를 해석하는데 필요한 정보를 표기	
 		
	 * HTML 태크
 		<> 열린태그 </> 닫힌태그 사이에 콘텐츠를 위치시켜서 구조 표현
 		<열린태그 속성="속성값> 콘텐츠 </닫힌태그>
 		ex. <a> => 콘텐츠에 링크를 연결할 수 있는 태그
 		<a href="http://www.codestates.com">코드스테이츠로이동하기</a>
 		href : 링크된 페이지의 URL을 명시
 		
 	 * h1 태그
 	 	문서의 제목을 포시하는 태기
 	 	Heading의 약자
 	 	<h1>~<h6>까지 문서의 크기
 	 	숫자가 커질수록 글씨크기가 작아져
 	
 	 * p1 태그
 	 	단락을 지정
 	 	Paragraph의 약자
 	 	문단의 앞뒤로 여백이 추가된다
 	 
 	 * img 태그
 	 	이미지를 표시하는 태그
 	 	닫힌 태그 없이도 작성이 가능한 Self-Closing 태그
 	 	src속성으로 표시할 이미지의 주소값 입력하고
 	 	width혹은 height속성을 이용해서 이미지 크기를 지정할 수 있다
 	 	이미지에 마우스를 올렸을 때 표시할 텍스트를 title속성으로 지정할 수 있고
 	 	이미지를 정상적으로 불러오지 못했을 때 alt 속성을 이용해서 대체할 텍스트 지정할 수 있다
 	 	
 	 	src : 이미지소스의 URL을 명시
 	 	alt : 이미지의 대체 텍스트를 지정
 		
 */

import java.util.*;
public class HTML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		
	
	}

}
