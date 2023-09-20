import javax.swing.*;
import java.awt.*;

public class Panel_Menu extends JPanel {
    JButton button_menu[] = new JButton[4];
    public Panel_Menu(){
        setLayout(new GridLayout(4,1)); //row 4, clos 1 레이아웃

        button_menu[0] = new JButton("추천 노래");
        button_menu[1] = new JButton("청량한 노래");
        button_menu[2] = new JButton("강해지는 노래");
        button_menu[3] = new JButton("감성 노래");

        for(int i = 0 ; i<button_menu.length; i++) {
            button_menu[i].setFont(new Font("바탕", Font.BOLD, 10));    //폰트 설정
            button_menu[i].setBackground(Color.PINK);   //버튼 색 설정
            button_menu[i].setForeground(Color.WHITE);
            add(button_menu[i]);
        }
        setSize(200,450);   //가로 200, 세로 450
    }

}