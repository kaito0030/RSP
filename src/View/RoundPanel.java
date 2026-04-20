package View;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class RoundPanel extends BasePanel {
	private JLabel round;
	private JLabel score;
	
	@Override
	protected void initialize() {
        round = new JLabel("", SwingConstants.CENTER);
        round.setFont(new Font("Meiryo UI",Font.BOLD,60));
        round.setBounds(250,175,300,75);
        add(round);

        score = new JLabel("", SwingConstants.CENTER);
        score.setFont(new Font("Meiryo UI",Font.BOLD,50));
        score.setBounds(300,300,200,50);
        add(score);
		
	}
	public void update(int r,int w,int l) {
		round.setText("第"+r+"回戦");
		score.setText(w+" - "+l);
	}
}

