package View;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private CardLayout layout=new CardLayout();
	private JPanel panel=new JPanel(layout);
	
	public MainFrame() {
		setTitle("じゃんけん");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(panel);
	}
	public void addScreen(JPanel P,String name) {
		panel.add(P,name);
	}
	public void showScreen(String name) {
		layout.show(panel, name);
	}
}
