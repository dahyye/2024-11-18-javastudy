import javax.swing.*;
import java.awt.*;
public class 윈도우연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();//프레임생성
		JLabel l1 = new JLabel("안녕하세요.");//라벨생성
		l1.setBounds(50,50,300,40);//위치, 크기
		l1.setFont(new Font("굴림",Font.BOLD,30));//폰트
		f.add(l1); //프레임에 라벨붙이기
		f.setSize(300,200);//프레임크기설정
		f.setLayout(null);//기본레이아웃사용
		f.setVisible(true);//프레임보이기
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//클릭시종료
	}

}
