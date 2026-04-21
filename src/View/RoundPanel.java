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
        round.setFont(new Font("HG行書体",Font.BOLD,100));
        
        round.setBounds(50,175,700,150);
        add(round);

        score = new JLabel("", SwingConstants.CENTER);
        score.setFont(new Font("HG行書体",Font.BOLD,40));
        score.setBounds(200,325,400,50);
        add(score);
		
	}
	public void update(int r,int w,int l) {
		String rk=NumToKansuji.convert(r, true);
		round.setText("<html><font color=#440000>第&ensp;"
				+ "<font color=#BB0000>"+rk+"&ensp;<font color=#440000>回&ensp;戦<html>");
		String wk=NumToKansuji.convert(w, false);
		String lk=NumToKansuji.convert(l, false);
		score.setText("<html><font color=#000055>"+wk+
				"勝<font color=#000000> - <font color=#550000>"+lk+"敗<html>");
	}
}

