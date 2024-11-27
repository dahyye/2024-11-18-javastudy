/*
 
	변경
	1. toUpperCase()  	: 대문자 변환
	2. toLowerCase()  	: 소문자 변환
	3. replace()		: 지정된 데이터 변경
	4. replaceAll()		: 전체를 변경  => 정규식으로 되어 있어서 사용하기 어려워
		[가-힣] -> 한글 전체
		[0-9] -> 숫자전체
		+ : 한글자이상
		* : 0글자이상
		| : 선택
		. : 임의의 문자 한개
		? : 존재여부 확인
	5. valueOf()		: 모든 데이터형을 문자형으로 변환할 때 사용
		valueOf(10) => "10"
		브라우저/윈도우창은 int형이 아닌 문자형을 넣어줘야해 => 입력하는 창이 브라우저는 <input type="text">, 원도우창은 TextField
	
 */

import javax.swing.JFrame;
import javax.swing.JTextField;
public class 문자열_7 extends JFrame{
	public 문자열_7()
	{
		JTextField tf=new JTextField();  // 입력창을 추가해주는거
		tf.setText(String.valueOf(100));  //tf.setText(100); 로 숫자를 입력하면 오류가 뜨기 때문에 valueOf()로 문자형으로 바꿔줘야해
											//(String.~~) static 변수(메모리저장안하고 쓰기)
		add("North",tf);
		setSize(600,400);  //원도우크기
		setVisible(true);  //true보여줘, false안보여줘
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 문자열_7();
		
		
	}

}
