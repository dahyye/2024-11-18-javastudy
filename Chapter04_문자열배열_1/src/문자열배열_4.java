import java.util.*;
import com.sist.data.*;
public class 문자열배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//파일에 대한 데이터 읽기
		String movie=ArrayData.arrayData("movie.txt");  //arrayData라는 함수가 만들어져있어서 파일을 읽어올 수 있다 => 파일의 재사용 => 메소드의 중요성
		System.out.println(movie);
		String seoul_location=ArrayData.arrayData("seoul_location.txt");
		System.out.println(seoul_location);
		String seoul_nature=ArrayData.arrayData("seoul_nature.txt");
		System.out.println(seoul_nature);
		
		
	}

}
