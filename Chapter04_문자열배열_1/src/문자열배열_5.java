import java.util.Arrays;

public class 문자열배열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String movie="1|쇼생크 탈출|드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|2016 .02.24 재개봉, 1995 .01.28 개봉|15세 관람가|프랭크 다라본트";
		String[] info=movie.split("\\|"); //split 받을 땐 항상 문자열로 받아
		//split은 정규식에서 사용하는 기호(| ? . + * ...) 을 사용하라 때 \\를 사용해야해
		System.out.println("순위 : "+info[0]);
		System.out.println("영화명 : "+info[1]);
		System.out.println("장르 : "+info[2]);
		//info[3]은 포스터
		System.out.println("출연 : "+info[4]);
		System.out.println("개봉일 : "+info[5]);
		System.out.println("관람등급 : "+info[6]);
		System.out.println("감독 : "+info[7]);
	}

}
