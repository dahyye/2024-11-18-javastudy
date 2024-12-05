
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String movie = "1|쇼생크 탈출|드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|2016 .02.24 재개봉, 1995 .01.28 개봉|15세 관람가|프랭크 다라본트\r\n"
				+ "2|원더|드라마|https://movie-phinf.pstatic.net/20171229_112/1514526663263n37r0_JPEG/movie_image.jpg?type=m77_110_2|제이콥 트렘블레이(어기 풀먼), 줄리아 로버츠(이자벨 풀먼), 오웬 윌슨(네이트 풀먼)|2017 .12.27 개봉|전체 관람가|스티븐 크보스키\r\n"
				+ "";
		String[] data=movie.split("\\|");  // 정규식 
		/*
		 정규식에서 사용하는 기호
		 (*, +, ., |, ?) ->은 정규식에서 사용하고 있기 때문에 \\를 앞에 붙여줘야 정상작동
		 
		 
		 */
		for(String m:data) // for-each : 향상된 for문
		{
			System.out.println(m);
		}
	}

}
