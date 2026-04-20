package View;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class TitlePanel extends BasePanel {
	private JButton start;
	@Override
	protected void initialize() {
		JLabel title=new JLabel("じゃんけんゲーム",SwingConstants.CENTER);
		title.setFont(new Font("Meiryo UI",Font.BOLD,60));
		title.setBounds(50,150,700,100);
		add(title);
		
		start=new JButton("始める");
		start.setFont(new Font("Meiryo UI",Font.BOLD,50));
		start.setBounds(300,300,175,75);
		add(start);
	}
	
	public void setStartListener(Runnable r) {
		start.addActionListener(e ->r.run());
	}
	
}
