import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel_Images_Card_All extends JPanel{
    public Panel_Images_Card panel_images_card = new Panel_Images_Card();  //패널카드이미지
    public Panel_Images_Card1 panel_images_card1 = new Panel_Images_Card1();  //패널카드이미지1
    public Panel_Images_Card2 panel_images_card2 = new Panel_Images_Card2();  //패널카드이미지2
    public Panel_Images_Card3 panel_images_card3 = new Panel_Images_Card3();  //패널카드이미지3
    public CardLayout cardlayout_all = new CardLayout();    //카드레이아웃

    public Panel_Images_Card_All(){ //카드 레이아웃 만들기
        setLayout(cardlayout_all);
        //카드레이아웃패널에 패널카드이미지들 추가

        add("card", panel_images_card);
        add("card1", panel_images_card1);
        add("card2", panel_images_card2);
        add("card3", panel_images_card3);
        setSize(600,400);
    }

}
