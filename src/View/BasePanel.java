package View;
import java.awt.Color;

import javax.swing.JPanel;
public abstract class BasePanel extends JPanel {
	Color backColor=new Color(125,200,150,127);
	public BasePanel() {
		setLayout(null);
		setBackground(backColor);
		initialize();
	}
	protected abstract void initialize();
}
