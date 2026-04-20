package View;
import java.awt.Image;
import java.net.URL;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Hand;
public class SelectPanel extends BasePanel {
	private Consumer<Hand> listener;
	private JLabel message;
	
	@Override
	protected void initialize() {
        message = new JLabel("じゃんけん",SwingConstants.CENTER);
        message.setBounds(300,100,200,50);
        add(message);

        addBtn(Hand.GU,180);
        addBtn(Hand.CHOKI,330);
        addBtn(Hand.PA,480);
	}
    private void addBtn(Hand hand,int x){

        ImageIcon icon = load(hand);

        JButton b = new JButton(icon);
        b.setBounds(x,280,120,120);

        b.setBorder(null);
        b.setContentAreaFilled(false);

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
        Image img=icon.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    public void setMessage(String s){
        message.setText(s);
    }

    public void setHandListener(Consumer<Hand> l){
        listener=l;
    }
}
