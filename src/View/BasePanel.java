package View;
import javax.swing.JPanel;
public abstract class BasePanel extends JPanel {
	public BasePanel() {
		setLayout(null);
		initialize();
	}
	protected abstract void initialize();
}
