import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 프레임=>보더레이아웃
 * 화면 구성=>생성자를 이용한다
 * public : 접근 제한자, 공개적인
 * class : 클래스(객체를 생성하여 쓰기 위한 틀)
 * GUISample1 : 클래스 이름
 * extends : 상속
 * JFrame : 상속을 해줍니다
 * implements : 인터페이스 상속(사전에 미리 설계만 해 놓은 상태의 것)
 * ActionListener : 동작 부분.
 */

public class GUISample1 extends JFrame implements ActionListener {
//JFrame과 ActionListener를 상속받고 있다.
	
	//필드로 올려주기. 한 눈에 보기쉽고 가독성이 올라간다.
	private JButton redBtn;
	private JButton blueBtn;
	private JButton orangeBtn;
	private BorderLayout bl;
	private JFrame f;
	private JTextField tf;

	//화면 구성
	public GUISample1() //생성자
	{
		f = new JFrame("버튼 만들기 예제");
		
		tf = new JTextField(30);//입력창 길이
		
		JPanel p = new JPanel();//패널,컴포넌틀을 올려서 사용합니다. 눈에는 보이지 않습니다.
		
		redBtn = new JButton("빨강색");//버튼 만들기
		blueBtn = new JButton("파랑색");
		orangeBtn = new JButton("주황색");
		
		bl = new BorderLayout();//배치관리자 설정
		setLayout(bl);
		
		JPanel p2 = new JPanel();//입력창
		p2.add(tf);
		f.add("South",p2);
		
		p.add(redBtn); //패널에 버튼 붙이기
		p.add(blueBtn);
		p.add(orangeBtn);
		
		f.add("North", p); //북쪽 프레임에 패널 붙이기
		
		redBtn.addActionListener(this); //동작
		blueBtn.addActionListener(this);
		orangeBtn.addActionListener(this);
		
		f.setBounds(300, 300, 600, 500);//x,y 좌표,넓이,높이 설정
		f.setVisible(true); //화면 보이기
		
	}
	
	@Override //어노테이션 기법. ActionListener 로부터 상속
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("빨강색"))
		{
			redBtn.setBackground(Color.red);
			tf.setText(cmd+"이 선택되었습니다.");
			
		}else if(cmd.equals("파랑색"))
		{
			blueBtn.setBackground(Color.blue);
			tf.setText(cmd+"이 선택되었습니다.");
		}else if(cmd.equals("주황색"))
		{
			orangeBtn.setBackground(Color.orange);
			tf.setText(cmd+"이 선택되었습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		//GUISample1 gs1 = new GUISample1();
		new GUISample1();//안 쓸거면 이렇게만 써도 된다.
		
		
	}
	

}
