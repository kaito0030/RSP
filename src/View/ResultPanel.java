package View;

import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Hand;
import View.Button.SquareButton;

public class ResultPanel extends BasePanel {

    private JLabel pImg,cImg,pText,cText,res,score,pName,eName;
    private SquareButton next;

    @Override
    protected void initialize(){
    		pName=new JLabel("",SwingConstants.CENTER);
    		pName.setBounds(75,25,200,100);
    		pName.setFont(new Font("HG行書体",Font.BOLD,50));
    		add(pName);
    		
    		eName=new JLabel("<html><font color=#550000>敵<html>",SwingConstants.CENTER);
    		eName.setBounds(535,25,200,100);
    		eName.setFont(new Font("HG行書体",Font.BOLD,50));
    		add(eName);
    		
    		
        pImg=new JLabel();
        pImg.setBounds(75,100,200,200);
        add(pImg);

        cImg=new JLabel();
        cImg.setBounds(525,100,200,200);
        add(cImg);

        pText=new JLabel("",SwingConstants.CENTER);
        pText.setFont(new Font("HG行書体",Font.BOLD,30));
        pText.setBounds(125,300,100,50);
        add(pText);

        cText=new JLabel("",SwingConstants.CENTER);
        cText.setFont(new Font("HG行書体",Font.BOLD,30));
        cText.setBounds(575,300,100,50);
        add(cText);

        JLabel vs=new JLabel("対",SwingConstants.CENTER);
        vs.setFont(new Font("HG行書体",Font.BOLD,50));
        vs.setBounds(350,175,120,60);
        add(vs);

        res=new JLabel("",SwingConstants.CENTER);
        res.setFont(new Font("HG行書体",Font.BOLD,70));
        res.setBounds(290,315,220,100);
        add(res);

        score=new JLabel("",SwingConstants.CENTER);
        score.setFont(new Font("HG行書体",Font.BOLD,30));
        score.setBounds(100,405,600,50);
        add(score);
        
        next=new SquareButton("次へ");
        next.setFont(new Font("HG行書体",Font.BOLD,30));
        next.setBounds(300,465,200,50);

    }
    public void addNextButton() {
        add(next);
		revalidate();
		repaint();
    }
    public void removeNextButton() {
    		remove(next);
    		revalidate();
    		repaint();
    }
    public void setName(String name) {
    		pName.setText("<html><font color=#000055>"+name+"<html>");
    }
    public void setHands(Hand player,Hand cpu){
        ImageIcon tImg;
        tImg=load(player);
        if(tImg!=null) {
    	    		pImg.setIcon(tImg);
        }else {
        		pImg.setText(player.getLabel());
        }
        tImg=load(cpu);
        if(tImg!=null) {
    	    		cImg.setIcon(tImg);
        }else {
        		cImg.setText(cpu.getLabel());
        }
 
        pText.setText(player.getLabel());
        cText.setText(cpu.getLabel());
    }

    public void setResultText(String t){
        res.setText(t);
    }

    public void setScore(int w,int l){
		String wk=NumToKansuji.convert(w, false);
		String lk=NumToKansuji.convert(l, false);
		score.setText("<html><font color=#000055>"+wk+
				"勝<font color=#000000> - <font color=#550000>"+lk+"敗<html>");
    }

    public void setNextListener(Runnable r){
        next.addActionListener(e->r.run());
    }

    private ImageIcon load(Hand h){

        String path = "/images/" + h.name().toLowerCase() + ".png";

        URL url = getClass().getResource(path);

        if (url == null) {
            System.out.println("画像が見つかりません: " + path);
            return null;
        }

        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}