import java.util.*;
import java.io.*;
public class MovieSystem {
	//영화전체정보 => 모든 사용자가 공유
	static Movie[] movies = new Movie[1938];
	//초기화
	static
	{
		try
		{
			//파일 전체 읽기
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i=0;//한글자씩 읽어온다 문제는 문자형이 아닌 정수형으로 읽어와
			StringBuffer sb = new StringBuffer();//문자열 결합의 최적화
			//buffer라는 저장공간을 만들어서 하나씩 넣어버리는 방법
			//데이터가 많은 경우 buffer사용하면 좋아
			//String data="";//속도가 느려
			while((i=fr.read())!=-1)//횟수를 모를 땐 while  //-1이 파일의 끝을 뜻함
			{
				sb.append((char)i);
				//data+=(char)i; //속도가 느려
			}
			fr.close();
			//System.out.println(sb.toString());
			String data=sb.toString();
			
			//분리  영화한줄에 대한 정보
			String[] temp=data.split("\n");
			int j=0;
			for(String s:temp)
			{
				movies[j]=new Movie();
				
				//movies[0] => no, title, actor..의 정보 저장
				String[] ss=s.split("\\|");
				movies[j].no=ss[0];
				movies[j].title=ss[1];
				movies[j].genre=ss[2];
				movies[j].poster=ss[3];
				movies[j].actor=ss[4];
				movies[j].regdate=ss[5];
				movies[j].grade=ss[6];
				movies[j].director=ss[7];
				j++;
			}
		}catch(Exception ex) {} // io =>파일 입출력
		
	}
	//목록출력 => 페이지나눠서 처리
	public Movie[] movieListData(int page)
	{
		final int ROWSIZE=20; //한페이지에 20개씩 보여줄거야
		//int i=0;
		//int pagecnt = (ROWSIZE*page)-ROWSIZE;
		//(page-1)*ROWSIZE;
		//시작위치 ex. page=3이면 2*20=40 1page0~19 2page 20~39 3page 40~59
		//배열이 0부터 시작하기 때문에
		int start=(page-1)*ROWSIZE; //위 방법보다 간단하게 하는 방법
		int end=page*ROWSIZE;
		int ARRSIZE=20;
		int totalpage=(int)(Math.ceil(movies.length/20.0)); //ceil 올림함수
		//글이 45개인데 페이지당 20개씩이면 3page=> 그래서 20으로 나누고 나머지를 올림해서 1page더 생성 
		if(page==totalpage)
		{
			end=page*ROWSIZE-2;
			ARRSIZE=18;
			//마지막페이지는 20개에서 2개가 모자른 18개이기때문에
		}
		
		Movie[] movieData= new Movie[ARRSIZE];
		int j=0;
		for(int i=start;i<end;i++)
		{
			movieData[j]=movies[i];
			j++;
		}
		return movieData;
	
	}
	
	
	//상세보기
	public Movie movieDetail(int no)
	{
		return movies[no-1];
	}
	
	//검색
	
	
	
}
