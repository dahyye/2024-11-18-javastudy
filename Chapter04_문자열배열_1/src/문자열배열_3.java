import java.util.*;
import com.sist.data.*;

public class 문자열배열_3 {
/*
	class Music
	{
		String title, singer, album, state;
		int modify;
	}
	=> 한 개에 대한 정보 
			
*/	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] title=ArrayData.title;
		String[] singer=ArrayData.singer;
		String[] album=ArrayData.album;
		String[] state=ArrayData.state;  // 순위변동상태
		int[] modify=ArrayData.modify;  //순위변동수치
		
		

			
		
		
//		String[][] music=new String[50][5];  //2차원배열
//		Music[] music=new Music[50]; //사용자정의 데이터형
		
//		목룍출력
		System.out.println("music top 50");
		for(int i=0;i<title.length;i++)//for-each사용하면 안됨 5개를 동시에 출력해야 하기 때문에
		{
			String s=state[i];
			String m="";
			if(s.equals("유지"))
			{
				m="-";
			}
			else if(s.equals("상승"))
			{
				m="▲"+modify[i];
			}
			else if(s.equals("하강"))
			{
				m="▼"+modify[i];
			}
			System.out.println(
			(i+1)+"."+m+" "+title[i]+" "+singer[i]+" "+album[i]);
		}
		System.out.println("===============================================================================================");
		
		
		
		//검색
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("카테고리 선택(곡명1, 가수명2): ");
//		int menu=scan.nextInt();
//		int count=0;
//		if(menu==1) //곡명
//		{
//			System.out.print("제목을 입력 :");
//				
//			String name=scan.next();
//			System.out.println("==============================================");
//			for(int i=0;i<title.length;i++)
//			{
//				if(title[i].contains(name))
//				{
//					System.out.println("노래명 : "+title[i]);
//					System.out.println("가수명 : "+singer[i]);
//					System.out.println("앨범명 : "+album[i]);
//					System.out.println("상승폭 : "+
//					(state[i].equals("유지")?"유지":state[i]+" "+modify[i]));
//					count++;
//					System.out.println("==============================================");	
//				}
//			}
//			System.out.println("총 "+count+"번 검색");
//		}
//		else if(menu==2) //가수명
//		{
//			System.out.print("가수명을 입력 :");
//			System.out.println("==============================================");	
//			String name=scan.next();
//			System.out.println("==============================================");	
//			for(int i=0;i<singer.length;i++)
//			{
//				if(singer[i].contains(name))
//				{
//					System.out.println("노래명 : "+title[i]);
//					System.out.println("가수명 : "+singer[i]);
//					System.out.println("앨범명 : "+album[i]);
//					System.out.println("상승폭 : "+
//					(state[i].equals("유지")?"유지":state[i]+" "+modify[i]));
//					count++;
//					System.out.println("==============================================");	
//				}
//			}
//			System.out.println("총 "+count+"번 검색");
		
//		등폭(상승,하강)이 가장 많은 노래명과 가수명 출력	
		
//		int max=0;

//		int count=0;
//		for(int i=0;i<title.length;i++)
//		{
//			
//			if(modify[i]>max)
//			{
//				max=modify[i];
//				count++;
//			}
//			
//		}
		
//		System.out.println("max : "+max);
//		System.out.println("index : "+index);
//		System.out.println("노래명 : "+title[index]);
//		System.out.println("가수명 : "+singer[index]);
//		System.out.println("앨범명 : "+album[index]);
//		System.out.println("상승폭 : "+
//		(state[index].equals("유지")?"유지":state[index]+" "+modify[index]));
//		System.out.println("==============================================");	

//		등폭(상승,하강)이 가장 많은 노래명과 가수명 출력(강사님)
		
		int max=0;
		int min=100;
		for(int i=0;i<title.length;i++)
		{
			if(modify[i]>max)
				max=modify[i];
		}
		System.out.println("max : "+max);
		int count = 0;
		for(int i=0;i<title.length;i++)
		{
			if(modify[i]==max)
			count++;
		}
		System.out.println("배열의 갯수는 : "+count);	
//		동적 배열 생성
		int[] arr=new int[count];
		int j=0;
		for(int i=0;i<title.length;i++)
		{
			if(max==modify[i])
			{
				arr[j]=i;
				j++;
			}
			
		
		}
		//데이터출력
		for(int i:arr)
		{
				
			System.out.println("노래명 : "+title[i]);
			System.out.println("가수명 : "+singer[i]);
			System.out.println("앨범명 : "+album[i]);
			System.out.println("상승폭 : "+
				(state[i].equals("유지")?"유지":state[i]+" "+modify[i]));
				
			System.out.println("==============================================");	
		}
		
	}

}
