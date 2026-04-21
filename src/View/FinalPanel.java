package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import View.Button.SquareButton;

public class FinalPanel extends BasePanel {

    private JLabel result;
    private JLabel score;
    private SquareButton exit,reset;
    @Override
    protected void initialize(){
        result=new JLabel("",SwingConstants.CENTER);
        result.setFont(new Font("HG行書体",Font.BOLD,150));
        result.setBounds(150,100,500,175);
        add(result);
        score=new JLabel("",SwingConstants.CENTER);
        score.setFont(new Font("HG行書体",Font.BOLD,50));
        score.setBounds(200,300,400,75);
        add(score);
        
        reset=new SquareButton("タイトル");
        reset.setFont(new Font("HG行書体",Font.BOLD,30));
        exit=new SquareButton("終了");
        exit.setFont(new Font("HG行書体",Font.BOLD,30));

        reset.setBounds(150,400,200,50);
        exit.setBounds(450,400,200,50);

        add(reset); add(exit);
    }

    public void setFinal(int w,int l){
        String r=(w>l)?"<html><font color=#000099>勝　利<html>":
        	(w<l)?"<html><font color=#990000>敗　北<html>":"引き分け";
        result.setText(r);
		String wk=NumToKansuji.convert(w, false);
		String lk=NumToKansuji.convert(l, false);
        score.setText("<html><font color=#000055>"+wk+
				"勝<font color=#000000> - <font color=#550000>"+lk+"敗<html>");
    }
    public void setResetListener(Runnable r){
        reset.addActionListener(e->r.run());
    }

    public void setExitListener(Runnable r){
        exit.addActionListener(e->r.run());
    }
}