/*
 
 	배열복사
 		옅은 복사(Call By Reference) => 주소에 의한 참조
 			=> 같은 메모리를 이용한다
 		깊은 복사 => 새로운 배열 생성 (메모리 공간이 따로 생성)
 
 
 */
public class 배열정리_추가내용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10, 20, 30, 40, 50};
		//int[] arr_copy=arr; // 다른 주소값을 가지고 데이터를 변경해도 arr_copy값만 바뀐다
		int[] arr_copy=arr.clone();
		System.out.println("arr="+arr);
		System.out.println("arr_copy="+arr_copy); //arr와 같은 주소값 출력
		
		//변경
		arr_copy[0]=100;
		arr_copy[1]=200;
		arr_copy[2]=300;
		arr_copy[3]=400;
		arr_copy[4]=500;

		for(int i:arr)
		{
			System.out.print(i+" "); //arr의 값도 변경된 걸 확인
		}
	}

}
