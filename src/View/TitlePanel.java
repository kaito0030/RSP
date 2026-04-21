package View;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import View.Button.SquareButton;
public class TitlePanel extends BasePanel {
	private SquareButton start;
	
	private JTextField textBox;

	@Override
	protected void initialize() {
		JLabel title=new JLabel("<html><font color=#DC143C>じゃんけん遊戯<html>",SwingConstants.CENTER);
		title.setFont(new Font("HG行書体",Font.BOLD,60));
		title.setBounds(50,100,700,100);
		add(title);
		
		JLabel text=new JLabel("名前を入力せよ",SwingConstants.CENTER);
		text.setFont(new Font("HG行書体",Font.BOLD,40));
		text.setBounds(50,250,700,75);
		add(text);
		textBox=new JTextField("操者",10);
		textBox.setCaretPosition(2);
		textBox.setBounds(250,325,300,40);
		textBox.setFont(new Font("HG行書体",Font.BOLD,30));
		textBox.setHorizontalAlignment(JTextField.CENTER);

		add(textBox);
		
		start=new SquareButton("始める");
		start.setFont(new Font("HG行書体",Font.BOLD,50));
		start.setBounds(300,450,200,75);
		add(start);
	}
	public String getText() {
		String name;
		try {
			name=textBox.getText();
		}catch(NullPointerException e) {
			name="操者";
		}
		return name;
	}
	

	public void setStartListener(Runnable r) {
		start.addActionListener(e ->r.run());
	}
	
}
