package View;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Hand;
import View.Button.RoundButton;
public class SelectPanel extends BasePanel {
	private Consumer<Hand> listener;
	private JLabel message;
	
	@Override
	protected void initialize() {
        message = new JLabel("じゃんけん",SwingConstants.CENTER);
        message.setFont(new Font("HG行書体",Font.BOLD,100));
        message.setBounds(50,75,700,150);
        add(message);

        addBtn(Hand.GU,88);
        addBtn(Hand.CHOKI,325);
        addBtn(Hand.PA,562);
	}
    private void addBtn(Hand hand,int x){

        ImageIcon icon = load(hand);

        RoundButton b=new RoundButton();;
        if(icon!=null) {
        		b.setIcon(icon);
        }else {
            
            b.setText(hand.getLabel()); // ← フォールバック文字
            b.setFont(new Font("Meiryo UI", Font.BOLD, 50));
        }
        
        b.setBounds(x,280,150,150);
        

        b.addActionListener(e->{
            if(listener!=null) listener.accept(hand);
        });

        add(b);
    }
    private ImageIcon load(Hand h){
        String path="/images/"+h.name().toLowerCase()+".png";
        URL url = getClass().getResource(path);
        
        if (url == null) {
            System.out.println("画像が見つかりません: " + path);
            return null;
        }
        ImageIcon icon=new ImageIcon(getClass().getResource(path));
        Image img=icon.getImage().getScaledInstance(125,125,Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    public void setMessage(String s){
        message.setText(s);
    }

    public void setHandListener(Consumer<Hand> l){
        listener=l;
    }
}
