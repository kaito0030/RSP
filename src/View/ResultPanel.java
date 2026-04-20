package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Hand;

public class ResultPanel extends BasePanel {

    private JLabel pImg,cImg,pText,cText,res,score;
    private JButton next;

    @Override
    protected void initialize(){

        pImg=new JLabel();
        pImg.setBounds(200,120,120,120);
        add(pImg);

        cImg=new JLabel();
        cImg.setBounds(480,120,120,120);
        add(cImg);

        pText=new JLabel("",SwingConstants.CENTER);
        pText.setBounds(200,240,120,30);
        add(pText);

        cText=new JLabel("",SwingConstants.CENTER);
        cText.setBounds(480,240,120,30);
        add(cText);

        JLabel vs=new JLabel("VS",SwingConstants.CENTER);
        vs.setBounds(350,150,100,50);
        add(vs);

        res=new JLabel("",SwingConstants.CENTER);
        res.setBounds(300,300,200,50);
        add(res);

        score=new JLabel("",SwingConstants.CENTER);
        score.setBounds(300,350,200,50);
        add(score);

        next=new JButton("次へ");
        next.setBounds(300,450,200,50);
        add(next);
    }

    public void setHands(Hand player,Hand cpu){
        pImg.setIcon(load(player));
        cImg.setIcon(load(cpu));
        pText.setText(player.getLabel());
        cText.setText(cpu.getLabel());
    }

    public void setResultText(String t){
        res.setText(t);
    }

    public void setScore(int w,int l){
        score.setText("勝:"+w+" 負:"+l);
    }

    public void setNextListener(Runnable r){
        next.addActionListener(e->r.run());
    }

    private ImageIcon load(Hand h){
        String path="/images/"+h.name().toLowerCase()+".png";
        ImageIcon icon=new ImageIcon(getClass().getResource(path));
        Image img=icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}