/*
 (난수로)
 계절처리하기
 345->봄
 678->여름
 9 10 11 ->가을
 12 1 2->겨울
 */

public class 자바선택문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = (int)(Math.random()*12)+1;
		switch(month)
		{
		case(3) :
		case(4) :
		case(5) :
			System.out.println(month+"월는 봄입니다");
			break;
		case(6) :
		case(7) :
		case(8) :
			System.out.println(month+"월는 여름입니다");
			break;
		case(9) :
		case(10) :
		case(11) :
			System.out.println(month+"월는 가을입니다");
			break;
		case(12) :
		case(1) :
		case(2) :
			System.out.println(month+"월는 겨울입니다");
			break;
		//사용자입력으로 하면 다른 숫자가 나올 수 있어서 그 때는 default로 예외처리를 해주는게 좋아
		/*
		default : 
			System.out.println(month+"월는 겨울입니다");
			break;
		*/
		
		}
		
	}

}
