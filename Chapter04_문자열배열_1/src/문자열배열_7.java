//1|양화진외국인선교사묘원|양화진외국인선교사묘원은 서울 마포구 합정동에 위치한 외국인 선교사들의 공동묘지이다.|04084 서울 마포구 양화진길 46 (합정동, 양화진홍보관)

import com.sist.data.*;
public class 문자열배열_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seoul=ArrayData.arrayData("seoul_location.txt");
		String[] seoul_data=seoul.split("\n");
		for(String s:seoul_data)
		{
			String[] data=s.split("\\|");
			System.out.println("번호 : "+data[0]);
			System.out.println("명소 : "+data[1]);
			System.out.println("주소 : "+data[3]);
			System.out.println("소개 : "+data[2]);
			System.out.println("======================================================================");
			
		}
	}

}
